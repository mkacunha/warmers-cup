import { Observable } from 'rxjs/Observable';
import { Category } from './category';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable()
export class CategoryService {

  constructor(private _http: HttpClient) { }

  save(category: Category): Observable<Category> {
    if (!category.id) {
      return this._http.post<Category>(`${environment.urlApi}/categories`, category);
    } else {
      return this._http.put<Category>(`${environment.urlApi}/categories/${category.id}`, category);
    }
  }

  detete(id: string) {
    return this._http.delete(`${environment.urlApi}/categories/${id}`);
  }

  findAll(): Observable<Category[]> {
    return this._http.get<Category[]>(`${environment.urlApi}/categories`);
  }
}
