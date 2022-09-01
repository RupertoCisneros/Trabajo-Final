import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DatosTecnicosAnimalFormComponent } from '@shared/components/formularios/formulario/datos-tecnicos-animal-form/datos-tecnicos-animal-form.component';
import { MicrochipFormComponent } from '@shared/components/formularios/formulario/microchip-form/microchip-form.component';
import { RecepcionAnimalFormComponent } from '@shared/components/formularios/formulario/recepcion-animal-form/recepcion-animal-form.component';
import { RetiroAnimalFormComponent } from '@shared/components/formularios/formulario/retiro-animal-form/retiro-animal-form.component';
import { ComiteEticaComponent } from './pages/comite-etica/comite-etica.component';

const routes: Routes = [
  {
    path: 'RetiroAnimal', component: RetiroAnimalFormComponent
  },
  {
    path: 'RecepcionAnimal', component: RecepcionAnimalFormComponent
  },
  {
    path: 'DatosTecnicosAnimal', component: DatosTecnicosAnimalFormComponent
  },
  {
    path: 'ComiteEtica', component: ComiteEticaComponent
  },
  {
    path: 'RegistrarMicrochip', component: MicrochipFormComponent, data: { uba: true }
  },
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UbaRoutingModule { }
