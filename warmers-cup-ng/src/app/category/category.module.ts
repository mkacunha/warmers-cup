import { CategoryService } from './category.service';
import { CategoryComponent } from './category.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CategoryComponent],
  exports: [CategoryComponent],
  providers: [CategoryService]
})
export class CategoryModule { }
