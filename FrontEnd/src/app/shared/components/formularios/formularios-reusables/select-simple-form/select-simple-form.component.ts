import { Component, DoCheck, forwardRef, Input, OnInit } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';

export interface Data  {
  nombre: string;
  id: number;
}

import { Subscription } from 'rxjs';
import { ConsultasService } from 'src/app/global/services/consultas.service';

@Component({
  selector: 'app-select-simple-form',
  templateUrl: './select-simple-form.component.html',
  styleUrls: ['./select-simple-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => SelectSimpleFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => SelectSimpleFormComponent),
      multi: true,
    },
  ],
  
})
export class SelectSimpleFormComponent implements OnInit,DoCheck {
  array:any[]=[]
  @Input() tipoCatalogo!: number;
  @Input() datos!: any;
  @Input() editPerfil!: any;

  form!: UntypedFormGroup;
  subscriptions: Subscription[] = [];

  onChange: any = () => {};
  onTouched: any = () => {};

  get value(): Data {
    return this.form.value;
  }
  set value(value: Data) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }

  
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  constructor(
    private formBuilder: UntypedFormBuilder,
    private consultaService: ConsultasService) {
      
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      data:['',[Validators.required]],
      nombreData: []
    });
  this.subscriptions.push(
    this.form.valueChanges.subscribe((value) => {
      this.onChange(value);
      this.onTouched();
    })
  );
    this.consultaService.consultaTipoCatalogo(this.tipoCatalogo).subscribe((data:any)=>{
      this.array = data
      if (this.editPerfil) {
        this.f['data'].setValue(this.editPerfil.perfilAcademico)
        this.f['data'].updateValueAndValidity()
      }
    })
  }
  ngDoCheck(): void {
    let encontrado;
    if (this.f['data'].value) {
      encontrado = this.array.find(item=>item.tipoCatalogoId === this.f['data'].value)
      this.f['nombreData'].setValue(encontrado.nombre)
      this.f['nombreData'].updateValueAndValidity()
    }
   
  }

  ngOnDestroy() {
    this.subscriptions.forEach((s) => s.unsubscribe());
  }

  registerOnChange(fn:any) {
    this.onChange = fn;
  }
  writeValue(value:any) {
    if (value) {
      this.value = value;
    }

    if (value === null) {
      this.form.reset();
    }
  }
  registerOnTouched(fn:any) {
    this.onTouched = fn;
  }
  validate(_: UntypedFormControl) {
    return this.form.valid ? null:{invalidForm: {valid: false, errors: this.form.errors}};
  }

}
