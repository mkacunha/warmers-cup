import { TeamComponent } from './team/team.component';
import { PlayerComponent } from './player/player.component';
import { ScoreComponent } from './score/score.component';
import { RouterModule, Routes, Router } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PresentationComponent } from './presentation/presentation.component';
import { MenuGuard } from './menu/menu.guard';


const appRoutes: Routes = [
    { path: 'home', component: HomeComponent, canActivate: [MenuGuard] },
    { path: 'team', component: TeamComponent, canActivate: [MenuGuard] },
    { path: 'player', component: PlayerComponent, canActivate: [MenuGuard] },
    { path: 'score', component: ScoreComponent, canActivate: [MenuGuard] },
    { path: 'presentation', component: PresentationComponent, canActivate: [MenuGuard] },
    { path: '**', redirectTo: 'home', }
];

export const routing = RouterModule.forRoot(appRoutes);
