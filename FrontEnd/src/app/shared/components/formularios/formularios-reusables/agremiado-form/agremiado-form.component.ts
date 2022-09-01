import { DatePipe } from '@angular/common';
import { AfterContentInit, ChangeDetectorRef, Component, DoCheck, forwardRef } from '@angular/core';
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

export interface FechaNacimientoFormsValue {
  nacimiento: string;
  discapacidad: boolean;
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-agremiado-form',
  templateUrl: './agremiado-form.component.html',
  styleUrls: ['./agremiado-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => AgremiadoFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => AgremiadoFormComponent),
      multi: true,
    },
  ],
})
export class AgremiadoFormComponent implements AfterContentInit,DoCheck {
  persona: any
  agremiado:boolean = false

  form: UntypedFormGroup = new UntypedFormGroup({});
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
    private changeDetector: ChangeDetectorRef,
    private pamService: PamService,
    public datepipe: DatePipe) {
    this.persona = this.pamService.obtenerPersona();
    this.form = this.formBuilder.group({
      agremiado: ['', Validators.required],
      nombreGremio: ['']
    });
    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }
  ngDoCheck(): void {
      if (this.f['agremiado'].value === 'SI') {
        this.agremiado = true
        this.f['nombreGremio'].setValidators([Validators.required])
        this.f['nombreGremio'].updateValueAndValidity()
      }else{
        this.agremiado = false
        this.f['nombreGremio'].setValidators([])
        this.f['nombreGremio'].reset()
        this.f['nombreGremio'].updateValueAndValidity()
      }
  }
  ngAfterContentInit(): void {
    this.changeDetector.detectChanges();
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
