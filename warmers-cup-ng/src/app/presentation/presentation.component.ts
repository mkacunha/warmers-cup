import { PresentationService } from './presentation.service';
import { Component, OnInit, ViewChild, HostListener, ElementRef, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-presentation',
  templateUrl: './presentation.component.html',
  styleUrls: ['./presentation.component.css']
})
export class PresentationComponent implements OnInit, OnDestroy {

  @ViewChild('inputHash') inputHash;
  @ViewChild('teamGif') teamGif: ElementRef;

  hash: string;
  data: any;

  isShowInput = true;
  isInitInput = false;
  isSelectTeam = false;
  isShowTeam = false;

  private body: any;

  constructor(private _service: PresentationService) {

  }

  ngOnInit() {
    this.body = document.getElementsByTagName('body')[0];
    this.inputFocus();
    this.defaultBackground();
  }

  ngOnDestroy() {
    this.changeBackground(null);
  }

  onHashChange() {
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

  private showTeam(res: any) {
    this.data = res;
    this.isSelectTeam = false;
    this.isShowTeam = true;
    this.changeBackground(this.data.team.urlBackground);
    this.initObservableShowTeam();
  }

  private showInput() {
    this.isShowTeam = false;
    this.isShowInput = true;
    this.isInitInput = false;
    this.hash = '';
    this.data = {};
    this.inputFocus();
    this.defaultBackground();
  }

  private changeBackground(url: string) {
    if (url) {
      this.body.className = 'background-image';
      this.body.style.backgroundImage = `url("${url}")`;
    } else {
      this.body.className = '';
      this.body.style.backgroundImage = '';
    }
  }

  private defaultBackground() {
    this.changeBackground('../assets/images/warmers-cup-background.gif');
  }
}
