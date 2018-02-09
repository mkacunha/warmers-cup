import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { routing } from './app.routes';


import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { TeamComponent } from './team/team.component';
import { PlayerComponent } from './player/player.component';
import { ScoreComponent } from './score/score.component';
import { PresentationComponent } from './presentation/presentation.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    TeamComponent,
    PlayerComponent,
    ScoreComponent,
    PresentationComponent
  ],
  imports: [
    BrowserModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
