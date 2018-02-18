import { PresentationService } from './presentation.service';
import { Component, OnInit, ViewChild, HostListener } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-presentation',
  templateUrl: './presentation.component.html',
  styleUrls: ['./presentation.component.css']
})
export class PresentationComponent implements OnInit {

  @ViewChild('inputHash') inputHash;

  hash: string;
  team: any;

  isShowInput = true;
  isInitInput = false;
  isSelectTeam = false;
  isShowTeam = false;

  constructor(private _service: PresentationService) { }

  ngOnInit() {
    this.inputFocus();
  }

  onHashChange() {
    // Observable.timer(2000).subscribe(() => console.log(this.hash));
    this.initObservableInput();
  }

  private inputFocus() {
    this.inputHash.nativeElement.focus();
  }

  private initObservableInput() {
    if (!this.isInitInput && this.isShowInput) {
      this.isInitInput = true;
      Observable.timer(1000).take(1).subscribe(() => this.selectTeam());
    }
  }

  private initObservableShowTeam() {
    Observable.timer(3000).take(1).subscribe(() => this.showInput());
  }

  private selectTeam() {
    this.isShowInput = false;
    this.isSelectTeam = true;
    this._service.selectTeam(this.hash).take(1).subscribe(res => this.showTeam(res));
  }

  private showTeam(team: any) {
    this.team = team;
    this.isSelectTeam = false;
    this.isShowTeam = true;
    this.initObservableShowTeam();
  }

  private showInput() {
    this.isShowTeam = false;
    this.isShowInput = true;
    this.isInitInput = false;
    this.inputFocus();
    this.hash = '';
    this.team = {};
  }
}
