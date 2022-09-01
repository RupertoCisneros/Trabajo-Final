import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExternoRoutingModule } from './externo-routing.module';
import { MaterialModule } from '@modules/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ExternoRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ]
})
export class ExternoModule { }
