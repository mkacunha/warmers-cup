import { Component, OnInit } from '@angular/core';

import { Team } from './team';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  team: Team = new Team();
  teams: Team[];

  constructor() { }

  ngOnInit() {
  }

  onChangeGif(event) {
    if (event.target.files && event.target.files.length > 0) {
      this.team.gif = event.target.files[0];
      this.team.gifName = this.team.gif.name;
    }
  }

  onChangeBackground(event) {
    if (event.target.files && event.target.files.length > 0) {
      this.team.backgroud = event.target.files[0];
      this.team.backgroundName = this.team.gif.name;
    }
  }

  onClickCancel() {
    this.team = new Team();
  }

  onClickSave() {
    console.log(this.team);
  }
}
