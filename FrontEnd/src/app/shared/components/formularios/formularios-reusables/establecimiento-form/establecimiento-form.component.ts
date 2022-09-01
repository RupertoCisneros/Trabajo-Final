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
import { ConsultasService } from '@global/services/consultas.service';


export interface EstablecimientoFormsValue {
  establecimientoId: number;
  establecimientonombre: string;
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-establecimiento-form',
  templateUrl: './establecimiento-form.component.html',
  styleUrls: ['./establecimiento-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => EstablecimientoFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => EstablecimientoFormComponent),
      multi: true,
    },
  ],
})

export class EstablecimientoFormComponent implements AfterContentInit, DoCheck {


  persona: any
  establecimientos: any = []

  form: UntypedFormGroup = new UntypedFormGroup({});
  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };

  get value(): EstablecimientoFormsValue {
    return this.form.value;
  }
  set value(value: EstablecimientoFormsValue) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }


  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  constructor(
    private formBuilder: UntypedFormBuilder,
    private consultaService: ConsultasService,
    private changeDetector: ChangeDetectorRef,
    private pamService: PamService,
    public datepipe: DatePipe) {
    this.persona = this.pamService.obtenerPersona();
    this.form = this.formBuilder.group({
      establecimientoId: ['', Validators.required],
      establecimientoNombre: ['', Validators.required],
    });
    this.consultaService.consultaTipoCatalogo(35).subscribe(data => {
      this.establecimientos = data
      let id;
      for (const item of this.establecimientos) {
        if (item.nombre === 'Particular') {
          id = item.tipoCatalogoId
        }
      }
      this.form.patchValue({
        establecimientoId: id,
        establecimientoNombre: 'Particular'
      })
    })
   
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
  ngDoCheck() {
    let establecimientoNombre,id;
    for (const item of this.establecimientos) {
      if (item.tipoCatalogoId === this.f['establecimientoId'].value) {
        establecimientoNombre = item.nombre
      }
    }
    this.form.patchValue({
      establecimientoNombre: establecimientoNombre,
    });
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
