import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KeycloakGuard } from '@core/helpers/keycloak-auth.guard';
import { PerfilesComponent } from './pages/perfiles/perfiles.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
const routes: Routes = [
  {
    path: 'Usuarios',
    component: UsuariosComponent,
    canActivate: [KeycloakGuard],
    data: { roles: ['Súper Administrador'] }
  },
  {
    path: 'Perfiles',
    component: PerfilesComponent,
    canActivate: [KeycloakGuard],
    data: { roles: ['Súper Administrador'] }
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SeguridadesRoutingModule { }
