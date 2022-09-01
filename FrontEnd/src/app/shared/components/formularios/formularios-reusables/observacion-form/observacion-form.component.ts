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

export interface ObservacionFormsValue {
  observacion: string;
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-observacion-form',
  templateUrl: './observacion-form.component.html',
  styleUrls: ['./observacion-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => ObservacionFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => ObservacionFormComponent),
      multi: true,
    },
  ],
})
export class ObservacionFormComponent {

  persona:any

  form: UntypedFormGroup = new UntypedFormGroup({
    codigoMicrochip: new UntypedFormControl(''),
  });
  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };

  get value(): ObservacionFormsValue {
    return this.form.value;
  }
  set value(value: ObservacionFormsValue) {
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
      observacion: ['', [Validators.required]],
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
