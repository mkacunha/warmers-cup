import { Team } from './../team/team';
import { PlayerService } from './player.service';
import { Filter } from './filter';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { TeamService } from '../team/team.service';
import { concat } from 'rxjs/observable/concat';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  filter = new Filter();

  players: any[];
  teams: Team[];

  @ViewChild('inputSelect') inputSelect: ElementRef;

  constructor(private _service: PlayerService, private _teamService: TeamService, private _toast: ToastrService) { }

  ngOnInit() {
    this.findPlayers();
    this.findTeams();
  }

  private findTeams() {
    this._teamService.findAll().take(1).subscribe(res => this.teams = res);
  }

  private findPlayers() {
    this._service
      .findAll().take(1).subscribe(res => this.players = res, () => this._toast.error('Ocorreu um erro inesperado, tente novamente.'));
  }

  playersFiltered(): any[] {
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

  copyEmails() {
    let emails = this.playersFiltered().map(player => player.email).toString();
    if (emails && emails.length > 0) {
      emails = emails.split(',').reverse().join(';');
      this.inputSelect.nativeElement.value = emails;
      this.inputSelect.nativeElement.select();
      document.execCommand('copy');
      this.inputSelect.nativeElement.value = '';
      this._toast.info('E-mails copiados para a área de tranferência');
    }
  }
}
