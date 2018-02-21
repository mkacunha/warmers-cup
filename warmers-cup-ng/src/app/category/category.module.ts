import { MatDialogModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { CategoryService } from './category.service';
import { CategoryComponent, ModalDeleteComponent } from './category.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatDialogModule,
    ToastrModule.forRoot()
  ],
  declarations: [CategoryComponent, ModalDeleteComponent],
  exports: [CategoryComponent],
  providers: [CategoryService],
  entryComponents: [CategoryComponent, ModalDeleteComponent]
})
export class CategoryModule { }
