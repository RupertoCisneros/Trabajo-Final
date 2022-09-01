import { DatePipe } from '@angular/common';
import { AfterContentInit, ChangeDetectorRef, Component, forwardRef, OnInit } from '@angular/core';
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
import { MAT_DATE_FORMATS } from '@angular/material/core';

export const MY_FORMATS = {
  parse: {
    dateInput: 'LL',
  },
  display: {
    dateInput: 'LL',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};
export interface FechaNacimientoFormsValue {
  nacimiento: string;
  discapacidad: boolean;
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-fecha-nacimiento-form',
  templateUrl: './fecha-nacimiento-form.component.html',
  styleUrls: ['./fecha-nacimiento-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => FechaNacimientoFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => FechaNacimientoFormComponent),
      multi: true,
    },
    { provide: MAT_DATE_FORMATS, useValue: MY_FORMATS },
  ],
})
export class FechaNacimientoFormComponent implements AfterContentInit {

  persona: any
  discapacidad!: string
  nacimiento!: Date
  disable = false

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
      nacimiento: ['', Validators.required],
      discapacidad: ['', Validators.required],
    });

    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
    );
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
