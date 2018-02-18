import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Team } from './team';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TeamService {

  constructor(private _http: HttpClient) { }

  save(team: Team): Observable<Team> {
    if (!team.id) {
      return this._http.post<Team>(`${environment.urlApi}/teams`, team);
    } else {
      return this._http.put<Team>(`${environment.urlApi}/teams/${team.id}`, team);
    }
  }

  detete(id: string) {
    return this._http.delete(`${environment.urlApi}/teams/${id}`);
  }

  findAll(): Observable<Team[]> {
    return this._http.get<Team[]>(`${environment.urlApi}/teams`);
  }
}
