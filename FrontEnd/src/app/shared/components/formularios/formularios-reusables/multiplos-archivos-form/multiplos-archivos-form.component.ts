import { Component, DoCheck, EventEmitter, forwardRef, Input, Output } from '@angular/core';
import {
  NG_VALUE_ACCESSOR,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators,
  UntypedFormControl,
  NG_VALIDATORS,
  AbstractControl,
} from '@angular/forms';

import { MensajesService } from '@global/services/mensajes.service';


import { Subscription } from 'rxjs';

@Component({
  selector: 'app-multiplos-archivos-form',
  templateUrl: './multiplos-archivos-form.component.html',
  styleUrls: ['./multiplos-archivos-form.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => MultiplosArchivosFormComponent),
      multi: true,
    },
    {
      provide: NG_VALIDATORS,
      useExisting: forwardRef(() => MultiplosArchivosFormComponent),
      multi: true,
    },
  ],
})
export class MultiplosArchivosFormComponent implements DoCheck {

  myFiles: any = [];
  @Input() max!: number;
  @Input() size!: number;
  @Input() formatos!: any;
  @Output() envioArray = new EventEmitter<any>();
  @Input() required: boolean = true;

  subscriptions: Subscription[] = [];

  onChange: any = () => { };
  onTouched: any = () => { };

  form: UntypedFormGroup = new UntypedFormGroup({
  });
  get value(): any {
    return this.form.value;
  }
  set value(value: any) {
    this.form.setValue(value);
    this.onChange(value);
    this.onTouched();
  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }


  constructor(private formBuilder: UntypedFormBuilder,
    private mensajeService: MensajesService
  ) {
    if (this.required) {
      this.form = this.formBuilder.group({
        files: ['', [Validators.required]],
      });
    }else{
      this.form = this.formBuilder.group({
        files: [''],
      });
    }
    this.subscriptions.push(
      this.form.valueChanges.subscribe((value: any) => {
        this.onChange(value);
        this.onTouched();
      })
    );
  }
  async onFileChange(event: any) {
    this.myFiles = []
    if (event.target.files.length <= this.max) {
      for (var i = 0; i < event.target.files.length; i++) {
        let nombreArchivo = event.target.files[i].name
        let ext = nombreArchivo.split('.').pop();
        if (this.formatos.includes(ext)) {
          if (event.target.files[i].size <= this.size) {
            const reader = new FileReader();
            reader.readAsDataURL(event.target.files[i]);
            reader.onload = () => {
              let result = reader.result as string;
              var base64 = result.replace(/^data:(.*,)?/, "");
              this.myFiles.push({base64: base64, nombreArchivo: nombreArchivo});
              this.form.valid;
            };
          } else {
            this.form.reset();
            this.form.markAllAsTouched();
            this.mensajeService.openWarningSnackBar(`El tamaño máximo es de 500KB`, 3000)

          }
        } else {
          this.form.reset();
          this.form.markAllAsTouched();
          this.mensajeService.openWarningSnackBar(`Solo se acepta formatos: ${this.formatos}`, 4000)
        }
      }
    } else {
      this.form.reset();
      this.form.markAllAsTouched();
      this.mensajeService.openWarningSnackBar(`El número maximo de archivos es: ${this.max}`, 3000)
    }
  }

  ngDoCheck(): void {
    
    if (this.myFiles.length > 0 && this.myFiles.length <= this.max) {
      this.envioArray.emit(this.myFiles);
    }
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
