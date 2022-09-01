import { Component, Inject } from '@angular/core';
import { AbstractControl, UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ConsultasService } from '@global/services/consultas.service';
import { MensajesService } from '@global/services/mensajes.service';

@Component({
  selector: 'app-buscar-por-filtros',
  templateUrl: './buscar-por-filtros.component.html',
  styleUrls: ['./buscar-por-filtros.component.css']
})
export class BuscarPorFiltrosComponent {
  checked = true
  mEstado = false
  mFecha = false
  estados: any

  form: UntypedFormGroup = new UntypedFormGroup({
  });

  constructor(
    public dialogRef: MatDialogRef<BuscarPorFiltrosComponent>,
    private formBuilder: UntypedFormBuilder,
    private consultaSerivce: ConsultasService,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private mensajeService: MensajesService) {
    this.consultaSerivce.consultaTipoCatalogo(31).subscribe({
      next: (data: any) => {
        this.estados = data
      }
    })
    this.form = this.formBuilder.group({
      fechaDesde: [''],
      fechaHasta: [''],
      estado: ['']
    });
  }
  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }
  buscar() {
    if (!this.form.value.estado && !this.form.value.fechaDesde && !this.form.value.fechaHasta) {
      this.mensajeService.openWarningSnackBar('Eliga una opción para continuar.', 2000);
      return
    }
    if (!this.form.invalid) {
      this.form.value.fechaDesde = this.formatearFecha(this.form.value.fechaDesde);
      this.form.value.fechaHasta = this.formatearFecha(this.form.value.fechaHasta);
      this.dialogRef.close(this.form.value)
    }
  }
  mostrarEstado(ob: MatCheckboxChange) {
    if (ob.checked) {
      this.mEstado = true
      this.f['estado'].setValidators([Validators.required]);
      this.f['estado'].updateValueAndValidity();
    }
    else {
      this.mEstado = false
      this.f['estado'].setValidators([]);
      this.f['estado'].updateValueAndValidity();
    }
  }
  mostrarFecha(ob: MatCheckboxChange) {
    if (ob.checked) {
      this.mFecha = true
      this.f['fechaDesde'].setValidators([Validators.required]);
      this.f['fechaDesde'].updateValueAndValidity();
      this.f['fechaHasta'].setValidators([Validators.required]);
      this.f['fechaHasta'].updateValueAndValidity();
    }
    else {
      this.mFecha = false
      this.f['fechaDesde'].setValidators([]);
      this.f['fechaDesde'].updateValueAndValidity();
      this.f['fechaHasta'].setValidators([]);
      this.f['fechaHasta'].updateValueAndValidity();
    }
  }

  formatearFecha(fecha: any) {
    if (fecha === '') {
      return ''
    }
    let formatted_date = fecha.getFullYear() + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate()
    return formatted_date;
  }
}
