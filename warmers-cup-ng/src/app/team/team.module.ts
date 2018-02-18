import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TeamComponent, ModalDeleteComponent } from './team.component';
import { TeamService } from './team.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material';
import { ToastrModule } from 'ngx-toastr';

import 'rxjs/add/operator/take';


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
  declarations: [
    TeamComponent,
    ModalDeleteComponent
  ],
  exports: [
    TeamComponent,
    ModalDeleteComponent
  ],
  entryComponents: [
    TeamComponent,
    ModalDeleteComponent
  ],
  providers: [
    TeamService
  ]
})
export class TeamModule { }
