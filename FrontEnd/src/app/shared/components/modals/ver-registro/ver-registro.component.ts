import { Component, EventEmitter, Inject, OnInit, Output } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { TramiteService } from '@global/services/tramite.service';

@Component({
  selector: 'app-ver-registro',
  templateUrl: './ver-registro.component.html',
  styleUrls: ['./ver-registro.component.css']
})
export class VerRegistroComponent implements OnInit {

  id!: any
  registro: any
  @Output() enviarRegistro = new EventEmitter<string>();
  file!: Blob
  fileURL: any
  mostrarBoton!: boolean
  rutaBack: any
  motivo!: boolean
  aprobar: boolean = false
  loading = false

  constructor(
    public dialog: MatDialog,
    private consultaService: ConsultasService,
    public loadingService: LoadingService,
    private mensajesService: MensajesService,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public tramiteService: TramiteService) {
    this.rutaBack = data.routerLink
    this.motivo = data.motivo || false
    this.id = data.id
    this.aprobar = data.aprobar
  }

  ngOnInit(): void {
    this.loading = true
    this.consultaService.descargarPdf(this.id)
      .subscribe({
        next: (blob: Blob) => {
          this.consultaService.obtenerRegistroProfesionalporID(this.id).subscribe({
            next: data => {
              if (Object.keys(data).length != 0) {
                this.registro = {
                  registroProfesionalId: data.registroProfesionalId,
                  usuarioId: data.usuarioId,
                  subtipoRegistro: data.subtipoRegistro,
                  nroRegistroProfesional: data.nroRegistroProfesional,
                  fechaAsigna: data.fechaAsigna,
                  nacionalidad: data.nacionalidadDesc,
                  nroIdentificacion: data.nroIdentificacion,
                  denominacion: data.denominacion,
                  nombres: data.nombres,
                  apellidos: data.apellidos,
                  discapacidad: data.discapacidad,
                  direccion: data.direccion,
                  movil: data.movil,
                  telefono: data.telefono,
                  mail: data.mail,
                  barrio: data.barrio,
                  calleNumero: data.calleNumero,
                  callePrincipal: data.callePrincipal,
                  calleSecundaria: data.calleSecundaria,
                  calleReferencia1: data.calleReferencia1,
                  calleReferencia2: data.calleReferencia2,
                  parroquia: data.parroquiaDesc,
                  registro: data.subtipoRegistroDesc,
                  estadoRegistros: data.estadoRegistros,
                  agremiado: data.agremiado,
                  nombreGremio: data.nombreGremio,
                  perfilAcademicoDesc: data.perfilAcademicoDesc,
                  institucionTitulo: data.institucionTitulo,
                  nombreTitulo: data.nombreTitulo,
                  nivelTitulo: data.nivelTitulo,
                  tipoTitulo: data.tipoTitulo,
                  reconocidoPor: data.reconocidoPor
                }
                this.enviarRegistro.emit(this.registro)
              } else {
                this.mensajesService.openFailureSnackBar('Error al cargar el documento', 3000)
                this.tramiteService.cerrarModal.close()
                this.loading = false
              }
            }
          })
          this.file = new Blob([blob], { type: 'application/pdf' });
          this.fileURL = URL.createObjectURL(this.file);
          if (this.file.size > 0) {
            this.mostrarBoton = true
          }
          this.loading = false
        }
      });
  }
  showDocument(): void {
    window.open(this.fileURL, '_blank', 'width=auto, height=auto');
  }

}
