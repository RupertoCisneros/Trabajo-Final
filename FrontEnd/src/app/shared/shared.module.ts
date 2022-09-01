
import { NgModule } from '@angular/core';
import { CommonModule,DatePipe } from '@angular/common';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

//Angular Material
import { MaterialModule } from '../modules/material/material.module';

//Componentes
import { FormulariosModule } from './components/formularios/formularios.module';
import { ConfirmacionComponent } from './components/modals/confirmacion/confirmacion.component';
import { AcuerdoResponsabilidadComponent } from './components/modals/acuerdo-responsabilidad/acuerdo-responsabilidad.component';
import { InicioModule } from '@modules/inicio/inicio.module';
import { BuscarUsuarioComponent } from './components/modals/buscar-usuario/buscar-usuario.component';
import { BuscarUsernameComponent } from './components/modals/buscar-username/buscar-username.component';
import { BuscarPorFiltrosComponent } from './components/modals/buscar-por-filtros/buscar-por-filtros.component';
import { MotivoComponent } from './components/modals/motivo/motivo.component';
import { BuscarTutorComponent } from './components/modals/buscar-tutor/buscar-tutor.component';
import { CrearMiembroComponent } from './components/modals/crear-miembro/crear-miembro.component';
import { VerRegistroComponent } from './components/modals/ver-registro/ver-registro.component';

@NgModule({
  declarations: [
    ConfirmacionComponent,
    AcuerdoResponsabilidadComponent,
    BuscarUsuarioComponent,
    BuscarUsernameComponent,
    BuscarPorFiltrosComponent,
    MotivoComponent,
    BuscarTutorComponent,
    CrearMiembroComponent,
    VerRegistroComponent,

  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    MaterialModule,
    FormulariosModule,
    InicioModule
  ],
  exports:[
    BuscarUsuarioComponent
  ],
  providers: [DatePipe]
})
export class SharedModule { }
