import { ChangeDetectorRef, Component, DoCheck, forwardRef } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';
import { ConsultasService } from '@global/services/consultas.service';

export interface MicrochipFormsValue {
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-certificados-form',
  templateUrl: './certificados-form.component.html',
  styleUrls: ['./certificados-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => CertificadosFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => CertificadosFormComponent),
      multi: true,
    },
  ],
})
export class CertificadosFormComponent implements DoCheck {

  form: UntypedFormGroup = new UntypedFormGroup({
  });

  mostrarVanucado:boolean = false
  mostrarEsterilizado:boolean = false
  minDate = new Date(2000, 0, 1);
  maxDate = new Date(); 
  formatos = ['jpg','pdf']
  motivosFallecimientos:any=[]
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
    private consultasService: ConsultasService,
    private changeDetectorRefs: ChangeDetectorRef,) {
      this.consultasService.consultaTipoCatalogo(26).subscribe({
        next: data => {
          this.motivosFallecimientos = data
        }
      })
    this.form = this.formBuilder.group({
      certificadoEsterilizadoBoolean: ['', [Validators.required]],
      certificadoVacunadoBoolean: ['', [Validators.required]],
      certificadoVacunado: [''],
      certificadoEsterilizado: [''],
      fallecimiento: [''],
      motivoFallecimiento: [''],
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
  ngDoCheck(): void {
    if (this.f['certificadoVacunadoBoolean'].value === 'SI') {
      this.mostrarVanucado = true
      this.f['certificadoVacunado'].addValidators([Validators.required]);
      this.f['certificadoVacunado'].updateValueAndValidity();
    }else if (this.f['certificadoVacunadoBoolean'].value === 'NO'){
      this.mostrarVanucado = false
      this.f['certificadoVacunado'].setValidators([]);
      this.f['certificadoVacunado'].reset();
      this.f['certificadoVacunado'].updateValueAndValidity();
    }
    if (this.f['certificadoEsterilizadoBoolean'].value === 'SI') {
      this.mostrarEsterilizado = true
      this.f['certificadoEsterilizado'].addValidators([Validators.required]);
      this.f['certificadoEsterilizado'].updateValueAndValidity();
    }else if (this.f['certificadoEsterilizadoBoolean'].value === 'NO'){
      this.mostrarEsterilizado = false
      this.f['certificadoEsterilizado'].setValidators([]);
      this.f['certificadoEsterilizado'].reset();
      this.f['certificadoEsterilizado'].updateValueAndValidity();
    }
    this.changeDetectorRefs.detectChanges();
  }
  recibirCertificadoVacunado(array:any){
    this.f['certificadoVacunado'].setValue({files: array})
  }
  recibirCertificadoEsterilizado(array:any){
    this.f['certificadoEsterilizado'].setValue({files: array})
  }
}

