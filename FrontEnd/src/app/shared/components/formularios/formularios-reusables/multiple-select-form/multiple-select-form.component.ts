import { Component, forwardRef, Input, OnInit } from '@angular/core';
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
  selector: 'app-multiple-select-form',
  templateUrl: './multiple-select-form.component.html',
  styleUrls: ['./multiple-select-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => MultipleSelectFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => MultipleSelectFormComponent),
      multi: true,
    },
  ],
  
})
export class MultipleSelectFormComponent implements OnInit {
  array:any[]=[]
  @Input() tipoCatalogo!: number;
  @Input() datos!: any;
  @Input() editPerfil!: any;

  form: UntypedFormGroup;
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
      this.form = this.formBuilder.group({
        data:['',[Validators.required]]
      });
    this.subscriptions.push(
      this.form.valueChanges.subscribe((value) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }
  ngOnInit(): void {
    
    this.consultaService.consultaTipoCatalogo(this.tipoCatalogo).subscribe((data:any)=>{
      this.array = data
      if (this.editPerfil) {
        this.form.patchValue({
          data: this.array
        })
      }
    })
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
