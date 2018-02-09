import { RouterModule, Routes, Router } from '@angular/router';


const appRoutes: Routes = [
  { path: '**', redirectTo: 'home' }
];

export const routing = RouterModule.forRoot(appRoutes);
