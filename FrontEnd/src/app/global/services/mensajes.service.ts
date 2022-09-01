import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class MensajesService {

  constructor(private _snackBar: MatSnackBar) { }

  //Mensaje de petición exitosa
  openSuccessSnackBar(mensaje: string, duracion: number) {
    return this._snackBar.open(mensaje, 'Aceptar', { horizontalPosition: 'center', verticalPosition: 'top', duration: duracion, panelClass: ['green-snackbar'] });
  }
  //Mensaje de petición fallida
  openFailureSnackBar(mensaje: string, duracion: number) {
    return this._snackBar.open(mensaje, 'Aceptar', { horizontalPosition: 'center', verticalPosition: 'top', duration: duracion, panelClass: ['red-snackbar'] });
  }
  //Mensaje informativo de peticiones
  openWarningSnackBar(mensaje: string, duracion: number) {
    if (duracion != 0) {
      return this._snackBar.open(mensaje, 'Aceptar', { horizontalPosition: 'center', verticalPosition: 'top', duration: duracion,panelClass: ['button-snackbar'] });
    }else{
      return this._snackBar.open(mensaje, 'Aceptar', { horizontalPosition: 'center', verticalPosition: 'top',panelClass: ['button-snackbar'] });
    }
   
  }
}
