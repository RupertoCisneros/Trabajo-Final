import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatStepper } from '@angular/material/stepper';
import { Router } from '@angular/router';
import { PamService } from '@core/helpers/pam.service';
import { ConsultasService } from '@global/services/consultas.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { AcuerdoResponsabilidadComponent } from '@shared/components/modals/acuerdo-responsabilidad/acuerdo-responsabilidad.component';
import { ConfirmacionComponent } from '@shared/components/modals/confirmacion/confirmacion.component';
import { EMPTY, Observable } from 'rxjs';
import { TramiteService } from '@global/services/tramite.service';
import { TiposRegistroComponent } from './tipos-registro/tipos-registro.component';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrls: ['./crear.component.css']
})
export class CrearComponent {
  completadoPrimer = false;
  completadoSegundo = false;
  tipodeRegistro: any;
  formulario: any;
  loading = false
  recargarTabla = false
  persona: any
  sinConexion: boolean = true
  tituloSENESCYT: any
  editarFormulario: boolean = false
  registroProfesionalEdit: any
  tiposdeRegistros = []

  @ViewChild('stepper')
  private myStepper!: MatStepper;

  constructor(
    public dialog: MatDialog,
    private tramiteService: TramiteService,
    private mensajesService: MensajesService,
    private router: Router,
    public loadingService: LoadingService,
    private pamService: PamService,
    private consultaService: ConsultasService) {
    this.persona = this.pamService.obtenerPersona();
  }
  obtener() {
    const dialogRef = this.dialog.open(TiposRegistroComponent, {
      height: 'auto',
      width: 'auto',
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.resetForm();
        this.editarFormulario = false
        this.obtenerTipoRegistro(result)
      }
      return EMPTY
    });
  }
  async obtenerTipoRegistro(tipoRegistro: any) {
    if (tipoRegistro.subtipoRegistroId) {
      this.tipodeRegistro = tipoRegistro
      let bol = await this.completadoStep(true);
      if (bol) {
        this.completadoPrimer = true
        setTimeout(() => {
          this.myStepper.next()
        }, 0.5);
      }
    }
  }

  async completadoStep(bol: boolean) {
    return new Promise(res => {
      setTimeout(() => {
        res(bol)
      }, 1);
    })
  }
  resetForm() {
    this.tipodeRegistro = null;
    window.setTimeout(() => this.myStepper.reset(), 0)
    this.completadoPrimer = false;
    this.completadoSegundo = false;
    this.formulario = null;
  }

  cancelarForm() {
    const dialogRef = this.dialog.open(ConfirmacionComponent, {
      height: '150px',
      width: '400px',
      data: { mensaje: 'Tus datos no se guardarán!' }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.resetForm();
      }
    })
  }

  async obtenerForm($event: any) {
    this.formulario = $event
    if (this.formulario) {
      let bol = await this.completadoStep(true);
      if (bol) {
        this.completadoSegundo = true;
        setTimeout(() => {
          this.myStepper.next()
        }, 0);
      }
    }

  }

  registrarRegistro() {
    if (this.tipodeRegistro.tipoFormulario === 2) {
      const dialogRef = this.dialog.open(ConfirmacionComponent, {
        height: '200px',
        width: '700px',
        data: { mensaje: 'Por favor revisar a detalle la información ingresada, para no incurrir en devoluciones o rechazos del trámite.' }
      });
      dialogRef.afterClosed().subscribe(result => {
        if (result) {
          this.acuerdoDeResponsabilidad().subscribe(result => {
            if (result) {
              this.guardarRegistro();
            }
          })
        }
      });
    }
    else {
      this.acuerdoDeResponsabilidad().subscribe(result => {
        if (result) {
          this.guardarRegistro();
        }
      })
    }
  }
  reloadCurrentRoute() {
    this.router.navigateByUrl("/Externo/Tramites", { skipLocationChange: true }).then(() => {
      this.router.navigate(["/Externo/Tramites/CrearTramite"]);
    });
  }
  acuerdoDeResponsabilidad(): Observable<any> {
    if (this.tipodeRegistro.descripcion === 'Registro de Microchip') {
      this.tipodeRegistro.informeValorOrdenanza = ''
    }
    const dialogRef = this.dialog.open(AcuerdoResponsabilidadComponent, {
      height: 'auto',
      width: '700px',
      data: { acuerdo: this.tipodeRegistro.acuerdoResponsabilidad, informeValorOrdenanza: this.tipodeRegistro.informeValorOrdenanza }
    });
    return dialogRef.afterClosed()
  }

  validarSinConexion(event: boolean) {
    if (event) {
      this.sinConexion = true
      this.resetForm();
    } else {
      this.sinConexion = false
    }
  }

  obtenerTituloSENESCYT(event: any) {
    if (event) {
      this.loading = false
      this.tituloSENESCYT = event[0]
    } else {
      this.loading = true
      this.tituloSENESCYT = null
    }

  }
  editarRegistro(tipoRegistro: any) {
    this.loadingService.loading = true
    this.consultaService.consultaTipoRegistro().subscribe((data: any) => {
      data.find((data: any) => {
        data.hijos.find((hijos: any) => {
          if (hijos.subtipoRegistroId === tipoRegistro.subregistro) {
            tipoRegistro.informeValorOrdenanza = hijos.informeValorOrdenanza
            tipoRegistro.acuerdoResponsabilidad = hijos.acuerdoResponsabilidad
            tipoRegistro.tipoFormulario = hijos.tipoFormulario
          }
        })
      })
      tipoRegistro.subtipoRegistroId = tipoRegistro.subregistro
      this.tipodeRegistro = tipoRegistro
      this.editarFormulario = true
      this.obtenerTipoRegistro(this.tipodeRegistro);
      this.loadingService.loading = false
    })
  }
  guardarRegistro() {
    this.loadingService.loading = true
    this.loadingService.mensaje = 'Guardando Información...'
    this.tramiteService.tipodeRegistro = this.tipodeRegistro
    if (this.tituloSENESCYT) {
      this.formulario.tituloSENESCYT = this.tituloSENESCYT
    }
    this.tramiteService.formulario = this.formulario
    this.tramiteService.Registrar().then(mensaje => {
      console.log(mensaje);
      if (mensaje.ok) {
        this.mensajesService.openSuccessSnackBar("Datos Grabados Correctamente", 2000)
        Swal.fire({
          text: mensaje.body.mensaje,
          confirmButtonColor: "#2fa4e7",
          confirmButtonText: "Aceptar",
          showClass: {
            popup: 'animate__animated animate__backInDown'
          },
          hideClass: {
            popup: 'animate__animated animate__backOutDown'
          },
        })
        this.reloadCurrentRoute()
        this.loadingService.loading = false
        this.loadingService.mensaje='Cargando Aplicación...';
      } else if (mensaje.error.codigoRespuesta === 400) {
        this.mensajesService.openFailureSnackBar(mensaje.error.mensaje, 2000);
        this.loadingService.loading = false
      }
      this.loadingService.loading = false
    });
  }
}
