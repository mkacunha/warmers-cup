import { environment } from './../environments/environment.prod';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ServiceWorkerModule } from '@angular/service-worker';


import { AppComponent } from './app.component';

import 'rxjs/add/operator/take';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    environment.production ? ServiceWorkerModule.register('/ngsw-worker.js') : [],
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
