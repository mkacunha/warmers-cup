import { MenuGuard } from './menu.guard';
import { RouterModule } from '@angular/router';
import { MenuService } from './menu.service';
import { MenuComponent } from './menu.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    MenuComponent
  ],
  exports: [
    MenuComponent
  ],
  providers: [
    MenuService,
    MenuGuard
  ]
})
export class MenuModule { }
