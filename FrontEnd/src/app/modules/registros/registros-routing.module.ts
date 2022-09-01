import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KeycloakGuard } from '@core/helpers/keycloak-auth.guard';
import { ConsultaAnalistaComponent } from './pages/consulta-analista/consulta-analista.component';
import { ConsultasComponent } from './pages/consultas/consultas.component';


const routes: Routes = [
  {
    path: 'ConsultaAnalista',
    component: ConsultaAnalistaComponent,
    canActivate:[KeycloakGuard],
    data: { roles: ['Analista de Tramites'] }
  },
  {
    path: 'Consultas', component: ConsultasComponent,
    canActivate:[KeycloakGuard],
    data: { roles: ['Administrador','Veterinario UBA'] }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegistrosRoutingModule { }
