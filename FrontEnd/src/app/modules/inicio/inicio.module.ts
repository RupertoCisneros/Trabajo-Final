import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { InicioRoutingModule } from './inicio-routing.module';
import { MaterialModule } from '@modules/material/material.module';
import { MenuComponent } from './navbar/menu/menu.component';
import { InicioComponent } from './inicio/inicio.component';
import { FlexLayoutModule } from '@angular/flex-layout';
//Loading
import { NgxLoadingModule } from 'ngx-loading';

import { PdfViewerModule } from 'ng2-pdf-viewer';

@NgModule({
  declarations: [
    MenuComponent,
    NavbarComponent,
    InicioComponent
  ],
  imports: [
    CommonModule,
    InicioRoutingModule,
    MaterialModule,
    NgxLoadingModule.forRoot({}),
    PdfViewerModule,
    FlexLayoutModule
  ],
  exports:[
    MenuComponent
  ]
})
export class InicioModule { }
