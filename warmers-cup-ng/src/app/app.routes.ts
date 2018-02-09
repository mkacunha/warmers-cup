import { TeamComponent } from './team/team.component';
import { PlayerComponent } from './player/player.component';
import { ScoreComponent } from './score/score.component';
import { RouterModule, Routes, Router } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PresentationComponent } from './presentation/presentation.component';


const appRoutes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'team', component: TeamComponent },
    { path: 'player', component: PlayerComponent },
    { path: 'score', component: ScoreComponent },
    { path: 'presentation', component: PresentationComponent },
    { path: '**', redirectTo: 'home' }
];

export const routing = RouterModule.forRoot(appRoutes);
