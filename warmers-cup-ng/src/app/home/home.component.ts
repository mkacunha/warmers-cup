import { ScoreService } from './../score/score.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  balance: any;
  isCarregando = false;


  constructor(private _scoreService: ScoreService) { }

  ngOnInit() {
    this.refreshBalance();
  }

  refreshBalance() {
    this.isCarregando = true;
    this._scoreService
      .getAllCountsByTeam().finally(() => this.isCarregando = false).take(1).subscribe(res => this.handleRefreshBalance(res));
  }

  private handleRefreshBalance(res) {
    this.balance = res;
    if (this.balance.balanceSheetsTeam) {
      this.balance.balanceSheetsTeam = this.balance.balanceSheetsTeam
        .sort((a, b) => a.ranking > b.ranking ? 1 : a.ranking > b.ranking ? -1 : 0);
    }
  }

}
