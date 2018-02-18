import { TeamResultModal } from './team-result-modal';
import { TeamService } from './team.service';
import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Team } from './team';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  team: Team = new Team();
  teams: Team[];

  isShowForm = false;

  @ViewChild('modalDelete') modalDelete: ModalDeleteComponent;

  constructor(private _service: TeamService, public _dialog: MatDialog, private _toast: ToastrService) { }

  ngOnInit() {
    this.retrieveTeams();
  }

  onClickCancel() {
    this.isShowForm = false;
    this.team = new Team();
    this.retrieveTeams();
  }

  onClickSave() {
    this._service.save(this.team).take(1).subscribe(() => this.handleSaveSuccess(), err => console.log(err));
  }

  onClickEdit(team: Team) {
    this.team = team;
    this.isShowForm = true;
  }

  onClickNew() {
    this.isShowForm = true;
  }

  onClickDelete(id: string) {
    this._dialog
      .open(ModalDeleteComponent, { width: '500px' })
      .afterClosed()
      .take(1)
      .subscribe(result => this.handleModalDelete(result, id));
  }

  showImage(url: string) {
    this._dialog.open(ModalShowImageComponent, { data: { url: url } });
  }

  private handleModalDelete(resModal: TeamResultModal, id: string) {
    if (resModal === TeamResultModal.YES) {
      this._service
        .detete(id)
        .take(1)
        .subscribe(
        res => this.retrieveTeams(),
        err => this._toast.error('Não foi possível remover a seleção. Verifique se já não existe jogadores selecionados para a mesma.'));
    }
  }

  private retrieveTeams() {
    this._service
      .findAll()
      .take(1)
      .subscribe(
      res => this.teams = res,
      err => this._toast.error('Não foi possível recuperar as seleções, verifique sua conexão com a internet e tente novamente.'));
  }

  private handleSaveSuccess() {
    this.isShowForm = false;
    this.team = new Team();
    this.retrieveTeams();
  }
}


@Component({
  selector: 'app-modal-delete',
  templateUrl: './modals/team-delete.modal.html'
})
export class ModalDeleteComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ModalDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }


  onNoClick(): void {
    this.dialogRef.close(TeamResultModal.NO);
  }

  onYesClick() {
    this.dialogRef.close(TeamResultModal.YES);
  }

}

@Component({
  selector: 'app-show-image-modal',
  templateUrl: './modals/team-show-image.modal.html',
})
export class ModalShowImageComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ModalDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  onYesClick() {
    this.dialogRef.close(TeamResultModal.YES);
  }

}

