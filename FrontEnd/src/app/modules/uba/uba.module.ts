import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UbaRoutingModule } from './uba-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormulariosModule } from '@shared/components/formularios/formularios.module';
import { MaterialModule } from '@modules/material/material.module';
import { SharedModule } from '@shared/shared.module';
import { ComiteEticaComponent } from './pages/comite-etica/comite-etica.component';
import { MiembrosComponent } from './pages/comite-etica/miembros/miembros.component';


@NgModule({
  declarations: [
    ComiteEticaComponent,
    MiembrosComponent,
  ],
  imports: [
    CommonModule,
    UbaRoutingModule,
    SharedModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    FormulariosModule,
  ],providers:[
    
  ]
})
export class UbaModule { }
