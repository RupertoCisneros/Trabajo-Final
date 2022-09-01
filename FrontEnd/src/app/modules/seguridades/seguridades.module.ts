import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { CrearUsuarioComponent } from './pages/perfiles/crear-usuario/crear-usuario.component';
import { MaterialModule } from '@modules/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { SeguridadesRoutingModule } from './seguridades-routing.module';
import { PerfilesComponent } from './pages/perfiles/perfiles.component';

@NgModule({
  declarations: [
    UsuariosComponent,
    CrearUsuarioComponent,
    PerfilesComponent
  ],
  imports: [
    CommonModule,
    SeguridadesRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'}),
    SharedModule
  ],
  exports:[
  ]
})
export class SeguridadesModule { }
