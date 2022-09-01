import { Component, forwardRef, OnInit } from '@angular/core';
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

export interface TelefonoFormsValue {
  telefono: string;
  movil: string;
}

import { Subscription } from 'rxjs';
import { ValidacionesPropias } from 'src/app/global/Validaciones';

@Component({
  selector: 'app-telefono-form',
  templateUrl: './telefono-form.component.html',
  styleUrls: ['./telefono-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => TelefonoFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => TelefonoFormComponent),
      multi: true,
    },
  ],
})
export class TelefonoFormComponent {

  persona:any

  form: UntypedFormGroup = new UntypedFormGroup({
    telefono: new UntypedFormControl(''),
    movil: new UntypedFormControl(''),
  });
  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };

  get value(): TelefonoFormsValue {
    return this.form.value;
  }
  set value(value: TelefonoFormsValue) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }


  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  constructor(
    private formBuilder: UntypedFormBuilder,
    private pamService: PamService) {
    this.persona = this.pamService.obtenerPersona();
    this.form = this.formBuilder.group({
      telefono: ['', [Validators.required, Validators.pattern('[0-8].{8}'), ValidacionesPropias.soloNumeros]],
      movil: ['', [Validators.required, Validators.pattern('[0-9].{9}'), ValidacionesPropias.soloNumeros]],
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

}
