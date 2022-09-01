import { Component, forwardRef, OnInit } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, NG_VALIDATORS, NG_VALUE_ACCESSOR, Validators } from '@angular/forms';
import { Subject, Subscription } from 'rxjs';
import { ValidacionesPropias } from 'src/app/global/Validaciones';
export interface FechaNacimientoFormsValue {
  nacionalidad: string;
  pais_origen: number;
  file: File
}

@Component({
  selector: 'app-formacion-documento-form',
  templateUrl: './formacion-documento-form.component.html',
  styleUrls: ['./formacion-documento-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => FormacionDocumentoFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => FormacionDocumentoFormComponent),
      multi: true,
    },
  ],
})
export class FormacionDocumentoFormComponent implements OnInit {

  form: UntypedFormGroup = new UntypedFormGroup({
  });

  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };
  protected _onDestroy = new Subject<void>();

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

  constructor(private formBuilder: UntypedFormBuilder) {
    this.form = this.formBuilder.group({
      file: new UntypedFormControl('', [Validators.required,ValidacionesPropias.archivoPDF]),
      fileSource: new UntypedFormControl(''),
    });

    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
    );
   }

  ngOnInit(): void {
  }
  onFileChange(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.form.patchValue({
        fileSource: file,
      });
    }
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
