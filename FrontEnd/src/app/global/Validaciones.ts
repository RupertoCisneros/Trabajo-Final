import { AbstractControl, ValidationErrors } from '@angular/forms';
import { verificarCedula } from 'udv-ec';

export class ValidacionesPropias {
  static archivoPDF(control: AbstractControl): ValidationErrors | null {
    let nombreArchivo = control.value || '';
    if (nombreArchivo) {
      let ext = nombreArchivo.split('.').pop();
      if (ext === 'pdf') {
        return null;
      }
    }
    return { archivoPDF: 'true' };
  }
  static soloNumeros(control: AbstractControl): ValidationErrors | null {
    let valor = control.value || '';
    if (valor) {
      const regex = /^[0-9]*$/;
      if (regex.test(valor)) {
        return null
      }
      return { soloNumeros: true }
    } else {
      return { soloNumeros: true }
    }

  }
  static validarSize(control: AbstractControl): ValidationErrors | null {
    return { archivoSize: 'true' }
  }
  static validarCedula(control: AbstractControl): ValidationErrors | null {
    let cedula = control.value || '';

    if (verificarCedula(cedula)) {
      return null
    }
    return { cedulaError: 'true' }
  }
  static LessThanToday(control: AbstractControl): ValidationErrors | null {
    let today: Date = new Date();
    if (new Date(control.value) > today)
      return { "LessThanToday": true };

    return null;
  }

}
