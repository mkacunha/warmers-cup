import { CategoryResultModal } from './modals/category-result-modal';
import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Category } from './category';
import { CategoryService } from './category.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  category: Category = new Category();
  categories: Category[];

  isShowForm = false;

  @ViewChild('modalDelete') modalDelete: ModalDeleteComponent;

  constructor(private _service: CategoryService, public _dialog: MatDialog, private _toast: ToastrService) { }

  ngOnInit() {
    this.retrieveCategories();
  }

  onClickCancel() {
    this.isShowForm = false;
    this.category = new Category();
    this.retrieveCategories();
  }

  onClickSave() {
    this._service.save(this.category).take(1).subscribe(() => this.handleSaveSuccess(), err => console.log(err));
  }

  onClickEdit(category: Category) {
    this.category = category;
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

  private handleModalDelete(resModal: CategoryResultModal, id: string) {
    if (resModal === CategoryResultModal.YES) {
      this._service
        .detete(id)
        .take(1)
        .subscribe(
        res => this.retrieveCategories(),
        err => this._toast.error('Não foi possível remover a categoria. Verifique se já não existe contagem realizada para a mesma.'));
    }
  }

  private retrieveCategories() {
    this._service
      .findAll()
      .take(1)
      .subscribe(
      res => this.categories = res,
      err => this._toast.error('Não foi possível recuperar as categorias, verifique sua conexão com a internet e tente novamente.'));
  }

  private handleSaveSuccess() {
    this.isShowForm = false;
    this.category = new Category();
    this.retrieveCategories();
  }
}


@Component({
  selector: 'app-modal-delete',
  templateUrl: './modals/category-delete.modal.html'
})
export class ModalDeleteComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ModalDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }


  onNoClick(): void {
    this.dialogRef.close(CategoryResultModal.NO);
  }

  onYesClick() {
    this.dialogRef.close(CategoryResultModal.YES);
  }

}
