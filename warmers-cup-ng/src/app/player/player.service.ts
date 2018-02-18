import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PlayerService {

  constructor(private _http: HttpClient) { }

  findAll(): Observable<any> {
    return this._http.get<any[]>(`${environment.urlApi}/players`);
  }

}
