import { AfterViewInit, Component, forwardRef, OnDestroy, OnInit, ViewChild, DoCheck, Input } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';

import { MatSelect } from '@angular/material/select';
import { ReplaySubject, Subject } from 'rxjs';
import { take, takeUntil } from 'rxjs/operators';


export interface DireccionFormsValue {
  parroquia: number;
  barrio: string;
  principal: string;
  secundaria: string;
  nomenclatura: string;
  otros: string;
  referencia: string
}

export interface Parroquia {
  tipoCatalogoId: number;
  nombre: string;
}


import { Subscription } from 'rxjs';
import { ConsultasService } from 'src/app/global/services/consultas.service';
import { PamService } from '@core/helpers/pam.service';
import { MatFormFieldControl } from '@angular/material/form-field';

@Component({
  selector: 'app-direccion-form',
  templateUrl: './direccion-form.component.html',
  styleUrls: ['./direccion-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => DireccionFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => DireccionFormComponent),
      multi: true,
    },
    {provide:MatFormFieldControl, useClass: DireccionFormComponent}
  ],
})
export class DireccionFormComponent implements OnInit, AfterViewInit, OnDestroy, DoCheck {
  persona: any
  public parroquias: Parroquia[] = []
  @Input() editDireccion!: any;
  public parroquiasCtrl: UntypedFormControl = new UntypedFormControl('', [Validators.required]);
  public parroquiasFilterCtrl: UntypedFormControl = new UntypedFormControl('');
  public filteredParroquias: ReplaySubject<Parroquia[]> = new ReplaySubject<Parroquia[]>(1);
  @ViewChild('selectParroquia', { static: true })
  selectParroquia!: MatSelect;
  protected _onDestroy = new Subject<void>();

  form: UntypedFormGroup = new UntypedFormGroup({
    parroquia: new UntypedFormControl(''),
    barrio: new UntypedFormControl(''),
    principal: new UntypedFormControl(''),
    secundaria: new UntypedFormControl(''),
    nomenclatura: new UntypedFormControl(''),
    otros: new UntypedFormControl(''),
    referencia: new UntypedFormControl(''),
  });
  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };

  get value(): DireccionFormsValue {
    return this.form.value;
  }
  set value(value: DireccionFormsValue) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }


  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  constructor(private formBuilder: UntypedFormBuilder,
    private consultaService: ConsultasService,
    private pamService: PamService) {
    this.persona = this.pamService.obtenerPersona();
    if (!this.persona) {
      this.persona.direccion = ''
    }
    
    this.form = this.formBuilder.group({
      parroquiaId: ['', Validators.required],
      nombreParroquia: ['', Validators.required],
      barrio: ['', Validators.required],
      principal: ['', Validators.required],
      secundaria: ['', Validators.required],
      nomenclatura: [''],
      otros: [''],
      referencia: ['']
    });
    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }
  ngOnInit() {
    this.consultaService.consultaTipoCatalogo(4).subscribe((data: any) => {
      this.parroquias = data
      if (this.editDireccion) {
        this.form.patchValue({
          parroquiaId: this.editDireccion.parroquia,
          nombreParroquia: this.editDireccion.parroquiaDesc,
          barrio: this.editDireccion.barrio,
          principal: this.editDireccion.callePrincipal,
          secundaria: this.editDireccion.calleSecundaria,
          nomenclatura: '',
          otros: '',
          referencia: this.isNull(this.editDireccion.calleReferencia1),
        })
        this.parroquiasCtrl.setValue(this.editDireccion.parroquia)
      }
      this.filteredParroquias.next(this.parroquias.slice());
    })

    this.parroquiasFilterCtrl.valueChanges
      .pipe(takeUntil(this._onDestroy))
      .subscribe(() => {
        this.filterParroquias();
      });
  }
  isNull(obj:any){
    if (obj != 'null' || '') {
      return obj
    }else{
      return ''
    }
  }

  ngAfterViewInit() {
    this.setInitialValue();
  }

  protected setInitialValue() {
    this.filteredParroquias
      .pipe(take(1), takeUntil(this._onDestroy))
      .subscribe(() => {
        if (this.selectParroquia) {
          this.selectParroquia.compareWith = (a: Parroquia, b: Parroquia) => a && b && a.tipoCatalogoId === b.tipoCatalogoId;
        }

      });
  }
  ngDoCheck() {
    let nombreParroquia;
    for (const parroquia of this.parroquias) {
      if (parroquia.tipoCatalogoId === this.parroquiasCtrl.value) {
        nombreParroquia = parroquia.nombre
      }
    }

    this.form.patchValue({
      parroquiaId: this.parroquiasCtrl.value,
      nombreParroquia: nombreParroquia});

  }
  protected filterParroquias() {
    if (!this.parroquias) {
      return;
    }
    let search = this.parroquiasFilterCtrl.value;
    if (!search) {
      this.filteredParroquias.next(this.parroquias.slice());
      return;
    } else {
      search = search.toLowerCase();
    }
    this.filteredParroquias.next(
      this.parroquias.filter(parroquia => parroquia.nombre.toLowerCase().indexOf(search) > -1)
    );
  }

  ngOnDestroy() {
    this.subscriptions.forEach((s) => s.unsubscribe());
    this._onDestroy.next();
    this._onDestroy.complete();
  }
  registerOnChange(fn: any) {
    this.onChange = fn;
  }
  writeValue(value: any) {
    if (value) {
      this.value = value;
    }

    if (value === null) {
      this.form.reset();
    }
  }
  registerOnTouched(fn: any) {
    this.onTouched = fn;
  }
  validate(_: UntypedFormControl) {
    return this.form.valid ? null : { invalidForm: { valid: false, errors: this.form.errors } };
  }


}
