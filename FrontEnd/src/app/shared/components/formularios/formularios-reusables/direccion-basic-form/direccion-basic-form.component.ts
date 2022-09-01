import { Component, forwardRef, OnDestroy } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';
import { Subject } from 'rxjs';

export interface DireccionFormsValue {
  direccion: string;
}

import { Subscription } from 'rxjs';
import { PamService } from '@core/helpers/pam.service';
import { MatFormFieldControl } from '@angular/material/form-field';

@Component({
  selector: 'app-direccion-basic-form',
  templateUrl: './direccion-basic-form.component.html',
  styleUrls: ['./direccion-basic-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => DireccionBasicFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => DireccionBasicFormComponent),
      multi: true,
    },
    { provide: MatFormFieldControl, useClass: DireccionBasicFormComponent }
  ],
})
export class DireccionBasicFormComponent implements OnDestroy {

  persona: any
  protected _onDestroy = new Subject<void>();
  form: UntypedFormGroup = new UntypedFormGroup({
    direccion: new UntypedFormControl(''),
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
    private pamService: PamService) {
    this.persona = this.pamService.obtenerPersona();
    this.form = this.formBuilder.group({
      direccion: ['', Validators.required],
    });
    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
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
