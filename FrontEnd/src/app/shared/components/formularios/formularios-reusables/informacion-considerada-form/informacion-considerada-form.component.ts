import { DatePipe } from '@angular/common';
import { AfterContentInit, ChangeDetectorRef, Component, forwardRef } from '@angular/core';
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
  selector: 'app-informacion-considerada-form',
  templateUrl: './informacion-considerada-form.component.html',
  styleUrls: ['./informacion-considerada-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => InformacionConsideradaFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => InformacionConsideradaFormComponent),
      multi: true,
    },
  ],
})

export class InformacionConsideradaFormComponent implements AfterContentInit {
  persona: any
  discapacidad!: string
  nacimiento!: Date

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
      informacionConsiderada: ['', Validators.required],
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
