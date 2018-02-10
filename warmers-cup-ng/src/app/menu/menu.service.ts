import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class MenuService {

  private showMenuSubject: BehaviorSubject<boolean> = new BehaviorSubject(true);

  constructor() { }

  get isShowMenu(): Observable<boolean> {
    return this.showMenuSubject.asObservable();
  }

  showMenu() {
    this.showMenuSubject.next(true);
  }

  hideMenu() {
    this.showMenuSubject.next(false);
  }

}
