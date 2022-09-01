import { Component, forwardRef, OnDestroy, Input } from '@angular/core';
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
import { ConsultasService } from 'src/app/global/services/consultas.service';
import { PamService } from '@core/helpers/pam.service';
@Component({
  selector: 'app-datepicker-simple-form',
  templateUrl: './datepicker-simple-form.component.html',
  styleUrls: ['./datepicker-simple-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => DatepickerSimpleFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => DatepickerSimpleFormComponent),
      multi: true,
    }
  ],
})
export class DatepickerSimpleFormComponent implements OnDestroy {
  persona: any
  protected _onDestroy = new Subject<void>();
  @Input() datos!: any;
  @Input() minDate!: Date;
  @Input() maxDate!: Date;

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
    private pamService: PamService) {
    this.persona = this.pamService.obtenerPersona();
    this.form = this.formBuilder.group({
      data: ['', Validators.required],
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
