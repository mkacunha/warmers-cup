import { Score } from './score';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from '../environments/environment.prod';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  teams: any[];
  categories: any[];

  score: Score = new Score();

  isTeam = true;
  isCategory = false;
  isAmount = false;

  constructor(private _http: HttpClient) { }

  ngOnInit() {
    this.findTeams();
    this.findCategories();
  }

  onClickTeam(team: any) {
    this.score.$team = team;
    this.selectCategory();
  }

  onCliclCategory(category: any) {
    this.score.$category = category;
    this.selectAmount();
  }

  onClickSave() {
    this._http.post(`${environment.urlApi}/counts`, this.score).take(1).subscribe(() => this.selectTeam());
  }

  onClickCancel() {
    this.selectTeam();
  }

  private selectTeam() {
    this.isTeam = true;
    this.isCategory = false;
    this.isAmount = false;
    this.score = new Score();
  }

  private selectCategory() {
    this.isTeam = false;
    this.isCategory = true;
    this.isAmount = false;
  }

  private selectAmount() {
    this.isTeam = false;
    this.isCategory = false;
    this.isAmount = true;
  }

  private findTeams() {
    this._http
      .get<any[]>(`${environment.urlApi}/teams`)
      .take(1)
      .subscribe(res => this.teams = res);
  }

  private findCategories() {
    this._http
      .get<any[]>(`${environment.urlApi}/categories`)
      .take(1)
      .subscribe(res => this.categories = res);
  }
}
