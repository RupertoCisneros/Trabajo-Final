import { Component, forwardRef } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';
import { AnimalService } from '@global/services/animal.service';
import { ConsultasService } from '@global/services/consultas.service';

export interface MicrochipFormsValue {
}

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-permanencia-animal-form',
  templateUrl: './permanencia-animal-form.component.html',
  styleUrls: ['./permanencia-animal-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => PermanenciaAnimalFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => PermanenciaAnimalFormComponent),
      multi: true,
    },
  ],
})
export class PermanenciaAnimalFormComponent {
  form: UntypedFormGroup = new UntypedFormGroup({
  });
  viviendas: any = []
  estatusViviendas:any = []
  permanencias:any = []
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
    private consultasService: ConsultasService,
    public animalService: AnimalService) {
    this.consultasService.consultaTipoCatalogo(7).subscribe({
      next: data => {
        this.viviendas = data
      }
    })
    this.consultasService.consultaTipoCatalogo(6).subscribe({
      next: data => {
        this.estatusViviendas = data
      }
    })
    this.consultasService.consultaTipoCatalogo(13).subscribe({
      next: data => {
        this.permanencias = data
      }
    })
    this.form = this.formBuilder.group({
      vivienda: ['', [Validators.required]],
      metrosTotal: ['', [Validators.required,Validators.min(1)]],
      metrosAproximado: ['', [Validators.required,Validators.min(1)]],
      cerramiento: ['',[Validators.required]],
      estatusVivienda: ['',[Validators.required]],
      permanencia: ['',[Validators.required]],
      direccionTutor: ['']

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

  submit() {
    console.log(this.form.value);
  }
}
