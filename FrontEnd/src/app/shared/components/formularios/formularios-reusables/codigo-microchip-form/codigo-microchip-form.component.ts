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

export interface MicrochipFormsValue {
  codigoMicrochip: string;
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-codigo-microchip-form',
  templateUrl: './codigo-microchip-form.component.html',
  styleUrls: ['./codigo-microchip-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => CodigoMicrochipFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => CodigoMicrochipFormComponent),
      multi: true,
    },
  ],
})
export class CodigoMicrochipFormComponent {

  persona:any
  date = new Date()

  form: UntypedFormGroup = new UntypedFormGroup({
    codigoMicrochip: new UntypedFormControl(''),
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
    private pamService: PamService) {
    this.persona = this.pamService.obtenerPersona();
    this.form = this.formBuilder.group({
      codigoMicrochip: ['', [Validators.required]],
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
