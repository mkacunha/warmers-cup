import { ScoreService } from './../score/score.service';
import { ScoreModule } from './../score/score.module';
import { HomeComponent } from './home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule,
    ScoreModule
  ],
  declarations: [
    HomeComponent
  ],
  exports: [
    HomeComponent
  ],
  providers: [
    ScoreService
  ]
})
export class HomeModule { }
