import { Component } from '@angular/core';
import { ConsultasService } from 'src/app/global/services/consultas.service';
import { MatTreeNestedDataSource } from '@angular/material/tree';
import { NestedTreeControl } from '@angular/cdk/tree';
import { MatDialogRef } from '@angular/material/dialog';
import { MicrochipService } from '@global/services/microchip.service';
import { MensajesService } from '@global/services/mensajes.service';
import { AnimalService } from '@global/services/animal.service';
import { TramiteService } from '@global/services/tramite.service';
import { TutorService } from '@global/services/tutor.service';

interface TiposRegistros {
  tipoRegistroId: number,
  descripcion: string;
  tipoFormulario?: number,
  hijos?: TiposRegistros[];
}

@Component({
  selector: 'app-tipos-registro',
  templateUrl: './tipos-registro.component.html',
  styleUrls: ['./tipos-registro.component.css']
})
export class TiposRegistroComponent {
  IsChecked = false
  validador: any
  loading = true
  treeControl = new NestedTreeControl<TiposRegistros>(node => node.hijos);
  dataSource = new MatTreeNestedDataSource<TiposRegistros>();
  escogido: any

  constructor(
    private consultaService: ConsultasService,
    private dialogRef: MatDialogRef<TiposRegistroComponent>,
    private microchipService: MicrochipService,
    private mensajesService: MensajesService,
    private animalService: AnimalService,
    private tramiteService: TramiteService,
    private tutorService: TutorService) {
    this.consultaService.consultaTipoRegistro().subscribe(data => {
      this.loading = false
      this.dataSource.data = data;
    })
  }
  hasChild = (_: number, node: TiposRegistros) => !!node.hijos && node.hijos.length > 0;
  enviarRegistro() {
    this.dialogRef.close(this.escogido)
  }
  validarRegistro(result: any) {
    if (result.descripcion === 'Registro de Microchip') {
      this.microchipService.validarRegistroMicrochip().subscribe({
        next: (mensaje: any) => {
          if (mensaje.mensajeValidacion === 'OK') {
            this.validador = true
            return
          } else {
            this.validador = false
            this.mensajesService.openWarningSnackBar(mensaje.mensajeValidacion, 7000);
          }
        },
      })
    } else
      if (result.tipoFormulario === 2) {
        this.tramiteService.validarRegistroSiExiste(result.subtipoRegistroId).subscribe({
          next: (mensaje: any) => {
            if (mensaje.mensajeValidacion === 'OK') {
              this.validador = true
              return
            } else {
              this.validador = false
              this.mensajesService.openWarningSnackBar(mensaje.mensajeValidacion, 5000);
            }
          },
        })
      } else
        if (result.descripcion === 'Registro de Datos de Tutor') {
          this.tutorService.validarTutorSiExiste(result.subtipoRegistroId).subscribe({
            next: (mensaje: any) => {
              if (mensaje.mensajeValidacion === 'OK') {
                this.validador = true
                return
              } else {
                this.validador = false
                this.mensajesService.openWarningSnackBar(mensaje.mensajeValidacion, 5000);
              }
            },
          })
        } else
          if (result.descripcion === 'Registro de Animales de Compañia') {
            this.animalService.validarAnimalTutor().subscribe({
              next: (mensaje: any) => {
                if (mensaje.mensajeValidacion === 'OK') {
                  this.animalService.tutor = true
                  this.validador = true
                  return
                } else {
                  this.validador = false
                  this.mensajesService.openWarningSnackBar(mensaje.mensajeValidacion, 5000);
                }
              },
            })
          } else if (result) {
            this.validador = true
          }
  }
}

