import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TramiteRoutingModule } from './tramite-routing.module';
import { TablaSenescytComponent } from './pages/crear/tabla-senescyt/tabla-senescyt.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormulariosModule } from 'src/app/shared/components/formularios/formularios.module';
import { CrearComponent } from './pages/crear/crear.component';
import { TiposRegistroComponent } from './pages/crear/tipos-registro/tipos-registro.component';
import { MisTramitesComponent } from './pages/crear/mis-tramites/mis-tramites.component';
import { VisualizacionComponent } from './pages/crear/visualizacion/visualizacion.component';

@NgModule({
  declarations: [
    TablaSenescytComponent,
    CrearComponent,
    TiposRegistroComponent,
    MisTramitesComponent,
    VisualizacionComponent,
  ],
  imports: [
    CommonModule,
    TramiteRoutingModule,
    SharedModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    FormulariosModule,

  ]
})
export class TramiteModule { }
