import { Component, forwardRef, OnDestroy, OnInit, Input } from '@angular/core';
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
}


import { Subscription } from 'rxjs';
import { PamService } from '@core/helpers/pam.service';

@Component({
  selector: 'app-input-simple-form',
  templateUrl: './input-simple-form.component.html',
  styleUrls: ['./input-simple-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => InputSimpleFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => InputSimpleFormComponent),
      multi: true,
    }
  ],
})
export class InputSimpleFormComponent implements OnDestroy,OnInit {

  persona: any
  @Input() requerido: any;
  protected _onDestroy = new Subject<void>();
  @Input() datos!: any;
  
  form: UntypedFormGroup = new UntypedFormGroup({
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
    private pamService: PamService,
    ) {
      this.form = this.formBuilder.group({
        data: ['',[Validators.required]],
      });
    this.persona = this.pamService.obtenerPersona();
    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }
  ngOnInit(): void {
    if (this.requerido) {
      this.f['data'].addValidators([Validators.required])
      this.f['data'].updateValueAndValidity();

    } else {
      this.f['data'].addValidators([])
      this.f['data'].updateValueAndValidity();
    }
  }
  ngDoCheck(): void {
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
