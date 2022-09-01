import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KeycloakGuard } from '@core/helpers/keycloak-auth.guard';
import { InicioComponent } from './inicio/inicio.component';

const routes: Routes = [
  {
    path: 'Inicio',
    component: InicioComponent
  },
  {
    path: 'Seguridades',
    loadChildren: () => import('@modules/seguridades/seguridades.module').then(m => m.SeguridadesModule),
    canActivate:[KeycloakGuard], data: { roles: ['Súper Administrador'] }
  },
  {
    path:
      'Tramites',
    loadChildren: () => import('@modules/tramite/tramite.module').then(m => m.TramiteModule),
    
  },
  {
    path:
      'Administracion',
    loadChildren: () => import('@modules/administracion/administracion.module').then(m => m.AdministracionModule),
    canActivate:[KeycloakGuard], data: { roles: ['Administrador','Analista de Tramites','Súper Administrador'] }
  },
  {
    path:
      'Registros',
    loadChildren: () => import('@modules/registros/registros.module').then(m => m.RegistrosModule),
    canActivate:[KeycloakGuard], data: { roles: ['Administrador','Analista de Tramites','Veterinario UBA'] }
  },
  {
    path:
      'UBA',
    loadChildren: () => import('@modules/uba/uba.module').then(m => m.UbaModule),
    canActivate:[KeycloakGuard], data: { roles: ['Veterinario UBA'] }
  },
  { path: '', redirectTo: 'Inicio', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class InicioRoutingModule { }
