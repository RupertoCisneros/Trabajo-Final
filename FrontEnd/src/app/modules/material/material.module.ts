
import { NgModule,LOCALE_ID } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { MatTableModule } from '@angular/material/table';
import { MatPaginatorIntl, MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatListModule } from "@angular/material/list";
import { MatMenuModule } from '@angular/material/menu'
import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from "@angular/material/card";
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule, MAT_DATE_LOCALE } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatInputModule} from '@angular/material/input';
import { MatTabsModule } from '@angular/material/tabs';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { MatStepperModule } from '@angular/material/stepper';
import {MatRadioModule} from '@angular/material/radio';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import {MatTreeModule} from '@angular/material/tree';
import {MatGridListModule} from '@angular/material/grid-list';
import { CustomPaginator } from '@global/Constantes';

import localEs from '@angular/common/locales/es';
import { registerLocaleData } from '@angular/common';
registerLocaleData(localEs,'es');
//PDF

@NgModule({
  imports: [
    CommonModule,
  ],exports:[
    MatPaginatorModule,
    MatTableModule,
    MatSortModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatSidenavModule,
    MatTooltipModule,
    MatToolbarModule,
    MatListModule,
    MatDialogModule,
    MatMenuModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatCheckboxModule,
    MatInputModule,
    MatTabsModule,
    MatSelectModule,
    MatSnackBarModule,
    MatStepperModule,
    MatRadioModule,
    NgxMatSelectSearchModule,
    MatTreeModule,
    MatGridListModule,

  ],
  providers:[
    DatePipe,
    {provide:MatPaginatorIntl, useClass: CustomPaginator},
    {provide: LOCALE_ID, useValue:'es'},
    { provide: MAT_DATE_LOCALE, useValue: 'en-GB' },
    
  ]
})
export class MaterialModule { }
