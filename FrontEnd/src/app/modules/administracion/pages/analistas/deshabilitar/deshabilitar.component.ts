import { Component, DoCheck, Inject } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-deshabilitar',
  templateUrl: './deshabilitar.component.html',
  styleUrls: ['./deshabilitar.component.css']
})
export class DeshabilitarComponent implements DoCheck {
  minDate = new Date();
  numeroDias?: number;
  errorDias = false
  form = new UntypedFormGroup({
    motivo: new UntypedFormControl(''),
    permiso: new UntypedFormControl(''),
    fechaDesde: new UntypedFormControl(''),
    fechaHasta: new UntypedFormControl(''),
  });
  permisos: any
  IsChecked!: boolean;
  constructor(
    private dialogRef: MatDialogRef<DeshabilitarComponent>,
    private formBuilder: UntypedFormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any) {
    this.IsChecked = false;
    this.errorDias = false;
    this.permisos = [{ id: 1, descripcion: 'Vacaciones' }]
    this.form = this.formBuilder.group({
      motivo: ['', [Validators.required]],
      permiso: ['', [Validators.required]],
      fechaDesde: ['', [Validators.required]],
      fechaHasta: ['', [Validators.required]],
      dias: ['', [Validators.required]]
    });
  }
  ngDoCheck(): void {
    let dias;
    if (this.f['fechaDesde'].value && this.f['fechaHasta'].value) {
      let desde = this.f['fechaDesde'].value
      let hasta = this.f['fechaHasta'].value
      dias = this.contarDias(hasta, desde);
      this.numeroDias = dias
      this.f['dias'].patchValue(this.numeroDias)
      this.errorDias = true
      if (this.numeroDias < 1 || this.numeroDias === 0) {
        this.errorDias = false
      }
    }

  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  submit() {
      this.dialogRef.close(this.form.value);
  }
  OnChange(event: MatCheckboxChange) {
    if (event.checked) {
      this.IsChecked = true
    } else {
      this.IsChecked = false
    }
  }
  contarDias(hasta: any, desde: any) {
    var Time = hasta.getTime() - desde.getTime();
    return Time / (1000 * 3600 * 24);
  }
}
