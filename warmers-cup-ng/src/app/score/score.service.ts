import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable()
export class ScoreService {

  constructor(private _http: HttpClient) { }

  getAllCountsByTeam(): Observable<any> {
    return this._http.get<any[]>(`${environment.urlApi}/counts/`);
  }


}
