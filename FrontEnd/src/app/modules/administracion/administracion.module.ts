import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministracionRoutingModule } from './administracion-routing.module';
import { AnalistasComponent } from './pages/analistas/analistas.component';
import { DeshabilitarComponent } from './pages/analistas/deshabilitar/deshabilitar.component';
import { MaterialModule } from '@modules/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '@shared/shared.module';
import { AprobarComponent } from './pages/aprobar/aprobar.component';
import { ListaRegistrosComponent } from './pages/analistas/lista-registros/lista-registros.component';
import { ListaAnalistasComponent } from './pages/analistas/lista-analistas/lista-analistas.component';
import { TipoCatalogoComponent } from './pages/tipo-catalogo/tipo-catalogo.component';
import { CatalogoComponent } from './pages/catalogo/catalogo.component';
@NgModule({
  declarations: [
    AnalistasComponent,
    DeshabilitarComponent,
    AprobarComponent,
    ListaRegistrosComponent,
    ListaAnalistasComponent,
    TipoCatalogoComponent,
    CatalogoComponent,
    
  ],
  imports: [
    CommonModule,
    AdministracionRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class AdministracionModule { }
