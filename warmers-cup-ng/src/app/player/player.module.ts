import { HttpClientModule } from '@angular/common/http';
import { PlayerComponent } from './player.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlayerService } from './player.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  declarations: [PlayerComponent],
  exports: [PlayerComponent],
  providers: [PlayerService]
})
export class PlayerModule { }
