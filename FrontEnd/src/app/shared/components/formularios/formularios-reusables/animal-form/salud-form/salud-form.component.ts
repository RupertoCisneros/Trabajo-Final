import { ChangeDetectorRef, Component, forwardRef } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { ConsultasService } from '@global/services/consultas.service';

export interface MicrochipFormsValue {
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-salud-form',
  templateUrl: './salud-form.component.html',
  styleUrls: ['./salud-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => SaludFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => SaludFormComponent),
      multi: true,
    },
  ],
})
export class SaludFormComponent{

  form: UntypedFormGroup = new UntypedFormGroup({
  });
  pruebasComportamiento:any=[]
  enfermedades!:boolean
  formatos = ['jpg','pdf']
  mostrarComportamiento:boolean = false



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
      this.consultasService.consultaTipoCatalogo(18).subscribe({
        next: data => {
          this.pruebasComportamiento = data
        }
      })
    this.form = this.formBuilder.group({
      enfermedades: ['', [Validators.required]],
      descripcionEnfermedades: [''],
      pruebaComportamiento: [''],
      examenClinicoBoolean: ['',[Validators.required]],
      examenClinico: [''],
      examenFisico: ['']
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
    if (this.f['examenClinicoBoolean'].value === 'SI') {
      this.mostrarComportamiento = true
      this.f['pruebaComportamiento'].addValidators([Validators.required]);
      this.f['pruebaComportamiento'].updateValueAndValidity();
      this.f['examenClinico'].addValidators([Validators.required]);
      this.f['examenClinico'].updateValueAndValidity();
    }else if (this.f['examenClinicoBoolean'].value === 'NO'){
      this.mostrarComportamiento = false
      this.f['pruebaComportamiento'].setValidators([]);
      this.f['pruebaComportamiento'].reset();
      this.f['pruebaComportamiento'].updateValueAndValidity();
      this.f['examenClinico'].setValidators([]);
      this.f['examenClinico'].reset();
      this.f['examenClinico'].updateValueAndValidity();
    }
    if (this.enfermedades) {
      this.f['enfermedades'].setValue("SI")
      this.f['descripcionEnfermedades'].setValidators([Validators.required]);
      this.f['descripcionEnfermedades'].updateValueAndValidity();
    }else{
      this.f['enfermedades'].setValue("NO")
      this.f['descripcionEnfermedades'].setValidators([]);
      this.f['descripcionEnfermedades'].updateValueAndValidity();
    }
    this.changeDetectorRefs.detectChanges();
  }

  onChangeEnfermedades(ob: MatCheckboxChange) {
    if (ob.checked) {
      this.enfermedades = true
    }else{
      this.enfermedades = false
    }
  }
  recibirEstadoSanitario(array:any){
      this.f['estadoSanitario'].setValue({files: array})
  }
  recibirExamenClinico(array:any){
    this.f['examenClinico'].setValue({files: array})
}
}
