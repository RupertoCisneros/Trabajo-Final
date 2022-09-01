import { Component, forwardRef } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';
import { PamService } from '@core/helpers/pam.service';
import { ConsultasService } from '@global/services/consultas.service';

export interface MicrochipFormsValue {
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-caracteristicas-form',
  templateUrl: './caracteristicas-form.component.html',
  styleUrls: ['./caracteristicas-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => CaracteristicasFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => CaracteristicasFormComponent),
      multi: true,
    },
  ],
})
export class CaracteristicasFormComponent {

  persona: any
  especies:any = []
  razas:any = []
  sexo:any
  estadosReproductivos:any=[]
  colorPredominante:any =[]
  colorSecundario:any=[]
  formatos = ['jpg','bmp','tiff']

  form: UntypedFormGroup = new UntypedFormGroup({
  });
  subscriptions: Subscription[] = [];
  onChange: any = () => { };
  onTouched: any = () => { };

  get value(): MicrochipFormsValue {
    return this.form.value;
  }
  set value(value: MicrochipFormsValue) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  constructor(
    private formBuilder: UntypedFormBuilder,
    private pamService: PamService,
    private consultasService: ConsultasService) {
    this.persona = this.pamService.obtenerPersona();

    this.consultasService.consultaTipoCatalogo(14).subscribe({
      next: data => {
        this.especies = data
      }
    })
    this.consultasService.consultaTipoCatalogo(17).subscribe({
      next: data => {
        this.estadosReproductivos = data
      }
    })
    this.consultasService.consultaTipoCatalogo(22).subscribe({
      next: data => {
        this.razas = data
      }
    })
    this.consultasService.consultaTipoCatalogo(23).subscribe({
      next: data => {
        this.colorPredominante = data
      }
    })
    this.consultasService.consultaTipoCatalogo(24).subscribe({
      next: data => {
        this.colorSecundario = data
      }
    })
    this.consultasService.consultaTipoCatalogo(38).subscribe({
      next: data => {
        this.sexo = data
      }
    })
    this.form = this.formBuilder.group({
      especie: ['', [Validators.required]],
      raza: ['', [Validators.required]],
      sexo: ['', [Validators.required]],
      estadoReproductivo: ['', [Validators.required]],
      colorPredominante: ['', [Validators.required]],
      colorSecundario: ['', [Validators.required]],
      señasParticulares: ['', [Validators.required]],
      identificacionFotografica: [''],
      identificacionVisible: ['']
    });

    this.subscriptions.push(
      this.form.valueChanges.subscribe((value: any) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }
  ngOnDestroy() {
    this.subscriptions.forEach((s) => s.unsubscribe());
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

  submit() {
    console.log(this.form.value);
  }
  recibirFotografias(array:any){
    if (array) {
      this.f['identificacionFotografica'].setValue({files: array})
    }
  }
  recibirVisible(array:any){
    if (array) {
      this.f['identificacionVisible'].setValue({files: array}) 
    }
  }
}
