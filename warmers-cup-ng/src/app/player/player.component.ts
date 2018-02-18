import { Team } from './../team/team';
import { PlayerService } from './player.service';
import { Filter } from './filter';
import { Component, OnInit } from '@angular/core';
import { TeamService } from '../team/team.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  filter = new Filter();

  players: any[];
  teams: Team[];

  constructor(private _service: PlayerService, private _teamService: TeamService) { }

  ngOnInit() {
    this.findPlayers();
    this.findTeams();
  }

  private findTeams() {
    this._teamService.findAll().take(1).subscribe(res => this.teams = res);
  }

  private findPlayers() {
    this._service.findAll().take(1).subscribe(res => this.players = res);
  }

  playersFiltered() {
    if (this.players) {
      if (this.filter.playerName || this.filter.teamName) {
        return this.players.filter(player => {
          if (this.filter.playerName && !player.name.toLowerCase().includes(this.filter.playerName.toLowerCase())) { return false; }
          if (this.filter.teamName && !player.teamName.toLowerCase().includes(this.filter.teamName.toLowerCase())) { return false; }
          return true;
        });
      }
      return this.players;
    }
    return [];
  }
}
