import { Observable } from 'rxjs/Observable';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class PresentationService {

  constructor(private _http: HttpClient) { }


  selectTeam(hash: string): Observable<any> {
    return this._http.post(`${environment.urlApi}/presentation/select-team`, hash);
  }

}
