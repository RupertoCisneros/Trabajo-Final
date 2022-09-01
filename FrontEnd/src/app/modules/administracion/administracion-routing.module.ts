import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KeycloakGuard } from '@core/helpers/keycloak-auth.guard';
import { AnalistasComponent } from './pages/analistas/analistas.component';
import { AprobarComponent } from './pages/aprobar/aprobar.component';
import { CatalogoComponent } from './pages/catalogo/catalogo.component';
import { TipoCatalogoComponent } from './pages/tipo-catalogo/tipo-catalogo.component';

const routes: Routes = [
  { path: 'ReasignarTramites', component: AnalistasComponent,data:{roles: ['Administrador']},canActivate: [KeycloakGuard]},
  { path: 'Aprobar', component: AprobarComponent,data:{roles: ['Analista de Tramites']},canActivate: [KeycloakGuard]},
  { path: 'TipoCatalogo', component: TipoCatalogoComponent,data:{roles: ['Súper Administrador']},canActivate: [KeycloakGuard]},
  { path: 'Catalogo', component: CatalogoComponent,data:{roles: ['Súper Administrador']},canActivate: [KeycloakGuard]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministracionRoutingModule { }
