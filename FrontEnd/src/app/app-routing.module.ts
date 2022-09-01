import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExternoGuard } from '@core/helpers/externo.guard';
import { KeycloakGuard } from '@core/helpers/keycloak-auth.guard';
import { PamGuard } from '@core/helpers/pam.guard';
import { NavbarComponent } from '@modules/inicio/navbar/navbar.component';
const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('@modules/auth/auth.module').then(m => m.AuthModule),
    canActivate: [PamGuard]
  },
  {
    path: '',
    component: NavbarComponent,
    loadChildren: () => import('@modules/inicio/inicio.module').then(m => m.InicioModule),
    canActivate: [KeycloakGuard]
  },
  {
    path: 'Externo',
    component: NavbarComponent,
    loadChildren: () => import('@modules/inicio/inicio.module').then(m => m.InicioModule),
    canActivate:[ExternoGuard]

  },
  {
    path: '**', redirectTo: 'auth', pathMatch: 'full'
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
