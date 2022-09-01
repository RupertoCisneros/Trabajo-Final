import { AfterViewInit, Component, forwardRef, OnDestroy, OnInit, ViewChild, DoCheck, ChangeDetectorRef } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
  FormControl,
} from '@angular/forms';

import { MatSelect } from '@angular/material/select';
import { ReplaySubject, Subject } from 'rxjs';
import { take, takeUntil } from 'rxjs/operators';

export interface Pais {
  tipoCatalogoId: number;
  nombre: string;
}

export interface FechaNacimientoFormsValue {
  nacionalidad: string;
  pais_origen: number;
  file: File
}

import { Subscription } from 'rxjs';
import { ConsultasService } from 'src/app/global/services/consultas.service';
import { PamService } from '@core/helpers/pam.service';

@Component({
  selector: 'app-nacionalidad-form',
  templateUrl: './nacionalidad-form.component.html',
  styleUrls: ['./nacionalidad-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => NacionalidadFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => NacionalidadFormComponent),
      multi: true,
    },
  ],
})

export class NacionalidadFormComponent implements OnInit, AfterViewInit, OnDestroy, DoCheck {

  abrir=false
  public paises: Pais[] = []
  persona: any
  formatos = ['pdf']


  public paisesCtrl: FormControl = new FormControl('', [Validators.required]);
  public paisesFilterCtrl: UntypedFormControl = new UntypedFormControl('');
  public filteredPaises: ReplaySubject<Pais[]> = new ReplaySubject<Pais[]>(1);
  @ViewChild('selectPais', { static: true })
  selectPais!: MatSelect;
  protected _onDestroy = new Subject<void>();
  nacionalidad!: string

  form: UntypedFormGroup = new UntypedFormGroup({
    nacionalidad: new UntypedFormControl(''),
    pais_origen: new UntypedFormControl(''),

  });
  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };

  get value(): FechaNacimientoFormsValue {
    return this.form.value;
  }
  set value(value: FechaNacimientoFormsValue) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  constructor(
    private formBuilder: UntypedFormBuilder,
    private consultaService: ConsultasService,
    private pamService: PamService,
    private changeDetectorRefs: ChangeDetectorRef,) {
    this.persona = this.pamService.obtenerPersona()
    this.form = this.formBuilder.group({
      pais_origen: ['', Validators.required],
      nombrePais: ['',Validators.required],
      visa: []
    });

    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }

  ngOnInit() {
    this.consultaService.consultaTipoCatalogo(12).subscribe(data => {
      this.paises = data
      if (this.persona.nacionalidad = 6) {
        this.nacionalidad = 'Ecuatoriano'
        this.paisesCtrl.setValue(this.paises[0].tipoCatalogoId)
      } else {
        this.nacionalidad = 'Extranjero'
      }
      this.filteredPaises.next(this.paises.slice());
      this.paisesFilterCtrl.valueChanges
        .pipe(takeUntil(this._onDestroy))
        .subscribe(() => {
          this.filterPaises();
        });
    })

  }

  protected setInitialValue() {
    this.filteredPaises
      .pipe(take(1), takeUntil(this._onDestroy))
      .subscribe(() => {
        if (this.selectPais) {
          this.selectPais.compareWith = (a: Pais, b: Pais) => a && b && a.tipoCatalogoId === b.tipoCatalogoId;
        }
      });
  }

  ngDoCheck() {
    let nombrePais;
    for (const pais of this.paises) {
      if (pais.tipoCatalogoId === this.paisesCtrl.value) {
        nombrePais = pais.nombre
      }
    }
    this.form.patchValue({
      pais_origen: this.paisesCtrl.value,
      nombrePais: nombrePais,
    });
    if (this.f['pais_origen'].value != 80) {
      this.abrir=true
    }else{
      this.f['visa'].reset();
      this.abrir=false
    }
    this.changeDetectorRefs.detectChanges();
  }

  ngAfterViewInit() {
    this.setInitialValue();
  }

  protected filterPaises() {
    if (!this.paises) {
      return;
    }
    let search = this.paisesFilterCtrl.value;
    if (!search) {
      this.filteredPaises.next(this.paises.slice());
      return;
    } else {
      search = search.toLowerCase();
    }
    this.filteredPaises.next(
      this.paises.filter(pais => pais.nombre.toLowerCase().indexOf(search) > -1)
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
  recibirDocumento(array:any){
    if (array) {
      this.form.controls['visa'].setValue({files: array})
    }
  }

}
