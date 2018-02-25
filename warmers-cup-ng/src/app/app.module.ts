import { HomeModule } from './home/home.module';
import { ScoreModule } from './score/score.module';
import { CategoryModule } from './category/category.module';
import { PresentationModule } from './presentation/presentation.module';
import { PlayerModule } from './player/player.module';
import { TeamModule } from './team/team.module';
import { SharedModule } from './shared/shared.module';
import { MenuModule } from './menu/menu.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { routing } from './app.routes';


import { AppComponent } from './app.component';
import { ScoreComponent } from './score/score.component';


import 'rxjs/Rx';


@NgModule({
  declarations: [
    AppComponent,
    ScoreComponent,
  ],
  imports: [
    BrowserModule,
    routing,
    MenuModule,
    SharedModule,
    FormsModule,
    TeamModule,
    PlayerModule,
    PresentationModule,
    CategoryModule,
    ScoreModule,
    HomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
