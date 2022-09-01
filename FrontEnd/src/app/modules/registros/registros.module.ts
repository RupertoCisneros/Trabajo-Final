import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegistrosRoutingModule } from './registros-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '@modules/material/material.module';
import { SharedModule } from '@shared/shared.module';
import { ConsultaAnalistaComponent } from './pages/consulta-analista/consulta-analista.component';
import { ConsultasComponent } from './pages/consultas/consultas.component';

@NgModule({
  declarations: [
    ConsultaAnalistaComponent,
    ConsultasComponent,
  ],
  imports: [
    CommonModule,
    RegistrosRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class RegistrosModule { }
