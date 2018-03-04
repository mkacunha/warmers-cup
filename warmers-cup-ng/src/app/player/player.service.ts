import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Player } from './player';

@Injectable()
export class PlayerService {

  constructor(private _http: HttpClient) { }

  findAll(): Observable<any> {
    return this._http.get<any[]>(`${environment.urlApi}/players`);
  }

  post(player: Player): Observable<Player> {
    return this._http.post<Player>(`${environment.urlApi}/players`, player);
  }

  notifyRemote(): Observable<any> {
    return this._http.post(`${environment.urlApi}/players/notify-remote`, null);
  }

}
