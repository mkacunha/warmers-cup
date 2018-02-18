import { HttpClientModule } from '@angular/common/http';
import { PresentationService } from './presentation.service';
import { PresentationComponent } from './presentation.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  declarations: [PresentationComponent],
  exports: [PresentationComponent],
  providers: [PresentationService]
})
export class PresentationModule { }
