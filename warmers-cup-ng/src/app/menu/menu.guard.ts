import { MenuService } from './menu.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class MenuGuard implements CanActivate {

  constructor(private _menuService: MenuService) {

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (next.routeConfig.path === 'presentation') {
      this._menuService.hideMenu();
    } else {
      this._menuService.showMenu();
    }

    return true;
  }
}
