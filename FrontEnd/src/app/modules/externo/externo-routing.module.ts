import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'Tramites', loadChildren: () => import('@modules/tramite/tramite.module').then(m => m.TramiteModule) },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExternoRoutingModule { }
