import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { PamService } from '@core/helpers/pam.service';
import { IpService } from '@global/services/ip.service';
import { MotivoComponent } from '@shared/components/modals/motivo/motivo.component';
import { EMPTY, lastValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AnimalService } from './animal.service';
import { LoadingService } from './loading.service';
import { MensajesService } from './mensajes.service';
import { MicrochipService } from './microchip.service';
import { TutorService } from './tutor.service';

@Injectable({
  providedIn: 'root'
})
export class TramiteService {

  ipTramite: any
  tipodeRegistro: any
  formulario: any
  registroProfesional: any
  mensaje: any
  persona: any
  correo: any
  cerrarModal!: MatDialogRef<any>
  usuarioKeycloak: any

  constructor(
    private http: HttpClient,
    private ipService: IpService,
    private pamService: PamService,
    private microchipService: MicrochipService,
    private tutorService: TutorService,
    private animalService: AnimalService,
    private datePipe: DatePipe,
    public dialog: MatDialog,
    private keycloakService: KeycloakAuthService,
    private mensajeService: MensajesService,
    private loadingService: LoadingService) {
    this.usuarioKeycloak = this.keycloakService.getLoggedUser();
    this.persona = this.pamService.obtenerPersona()
  }

  //Registrar todos los tipos de registros
  async Registrar() {
    switch (this.tipodeRegistro.tipoFormulario) {
      case 1:
        if (this.tipodeRegistro.descripcion === 'Registro de Microchip') {
          return await this.microchipService.registroMicrochip(this.formulario, false);
        }
        if (this.tipodeRegistro.descripcion === 'Registro de Datos de Tutor') {
          return await this.tutorService.registroTutor(this.formulario);
        }
        if (this.tipodeRegistro.descripcion === 'Registro de Animales de Compañia') {
          return await this.animalService.registroAnimal(this.formulario);
        }
        return
      case 2:
        return await this.TramiteRegistroProfesional();
    }
  }

  async guardarRegistroProfesional(params: any) {
    let url = `${environment.url_api}/crearProfesional/${String(params.idUsuario)}/${String(params.idParroquia)}/${String(params.idSubTipoRegistro)}/${String(params.proceso)}`
    const get$ = this.http.post(url, JSON.stringify(params.body),
      {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/json')
        ,
        observe: 'response' as "body",
        responseType: "json",
      }
    );
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }

  //Registro de los tramites profesionales
  async TramiteRegistroProfesional() {
    let estado, registroProfesionalId, proceso;
    if (this.tipodeRegistro.estado === 'DEVUELTO') {
      estado = 225
      registroProfesionalId = this.tipodeRegistro.registroProfesionalId
      proceso = 1
    } else {
      proceso = 0
    }
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    console.log(this.formulario);
    this.registroProfesional = {
      idSubTipoRegistro: this.tipodeRegistro.subtipoRegistroId,
      idParroquia: this.formulario.direccion.parroquiaId,
      idUsuario: this.persona.usuarioId,
      proceso: proceso,
      body: {
        agremiado: this.isObjEmpty(this.formulario.agremiado, 'agremiado'),
        barrio: this.formulario.direccion.barrio,
        calleNumero: this.formulario.direccion.nomenclatura,
        callePrincipal: this.formulario.direccion.principal,
        calleReferencia1: this.formulario.direccion.referencia,
        calleReferencia2: '',
        calleSecundaria: this.formulario.direccion.secundaria,
        discapacidad: this.formulario.nacimiento.discapacidad,
        fechaNacimiento: this.datePipe.transform(this.formulario.nacimiento.nacimiento, 'yyyy-MM-dd'),
        movil: this.formulario.telefono.movil,
        telefono: this.formulario.telefono.telefono,
        perfilAcademico: this.isObjEmpty(this.formulario.perfiles, 'data'),
        documentoFormacion: this.isObjEmpty(this.formulario.formacion, 'files'),
        nombreGremio: this.esAgremiado(this.formulario.agremiado),
        visaArchivo: this.isObjEmpty(this.formulario.nacionalidad.visa, 'files'),
        terminalCreacion: this.ipTramite,
        terminalModificacion: this.ipTramite,
        usuarioCreacion: this.persona.nroIdentificacion,
        usuarioModificacion: this.persona.nroIdentificacion,
        acuerdoResponsabilidad: 'SI',
        tituloSENESCYT: this.formulario.tituloSENESCYT,
        estado: estado,
        registroProfesionalId: registroProfesionalId
      }
    }
    console.log(this.registroProfesional);
    await this.guardarRegistroProfesional(this.registroProfesional).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }

  isObjEmpty(obj: any, name: string) {
    if (obj) {
      if (!obj.hasOwnProperty(name)) return '';
      else return obj[`${name}`]
    }
    return ''
  }
  esAgremiado(obj: any) {
    if (obj) {
      return this.isObjEmpty(obj.nombreGremio, 'data')
    } else {
      return ''
    }
  }

  validarRegistroSiExiste(idRegistro: number) {
    if (idRegistro) {
      return this.http.get(`${environment.url_api}/validarIngreso/${this.persona.nroIdentificacion}/${idRegistro}`)
    }
    return EMPTY
  }

  //Devolución del trámite, obtiene como parametro el registro a devolver
  devolverTramite(registro: any) {
    let dialogRef = this.dialog.open(MotivoComponent, {
      width: '600px',
      data: { titulo: 'Motivo de devolución' }
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loadingService.loading = true
        let params = {
          registroProfesionalid: registro.registroProfesionalId,
          motivo: result.motivo,
          idUsuario: registro.usuarioId
        }
        this.guardarDevolverTramite(params).then(mensaje => {
          if (mensaje.codigoRespuesta === 201) {
            this.mensajeService.openSuccessSnackBar(mensaje.mensaje, 2000);
            this.loadingService.loading = false
            this.cerrarModal.close(true)
          } else {
            console.log(mensaje);
            this.loadingService.loading = false
            this.mensajeService.openFailureSnackBar('Error', 2000);
          }
        })
      }
    });
  }
  //Aprobación del trámite, obtiene como parametro el registro a aprobar
  aprobarTramite(registro: any) {
    let dialogRef = this.dialog.open(MotivoComponent, {
      width: '600px',
      data: { titulo: 'Novedad de aprobación' }
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loadingService.loading = true
        let params = {
          registroProfesionalid: registro.registroProfesionalId,
          novedad: result.motivo,
          idSubTipoRegistro: registro.subtipoRegistro,
          idUsuario: registro.usuarioId
        }
        this.guardarAprobarTramite(params).then(mensaje => {
          if (mensaje.codigoRespuesta === 201) {
            this.mensajeService.openSuccessSnackBar(mensaje.mensaje, 2000);
            this.loadingService.loading = false
            this.cerrarModal.close(true)
          } else {
            console.log(mensaje);
            this.loadingService.loading = false
            this.mensajeService.openFailureSnackBar('Error', 2000);
          }
        })
      }
    });
  }
  //Rechazo del trámite, obtiene como parametro el registro a rechazar
  rechazarTramite(registro: any) {
    let dialogRef = this.dialog.open(MotivoComponent, {
      width: '600px',
      data: { titulo: 'Motivo de rechazo' }
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.loadingService.loading = true
        let params = {
          registroProfesionalid: registro.registroProfesionalId,
          motivo: result.motivo,
          idUsuario: registro.usuarioId
        }
        this.guardarRechazarTramite(params).then(mensaje => {
          if (mensaje.codigoRespuesta === 201) {
            this.mensajeService.openSuccessSnackBar(mensaje.mensaje, 2000);
            this.loadingService.loading = false
            this.cerrarModal.close(true)
          } else {
            console.log(mensaje);
            this.loadingService.loading = false
            this.mensajeService.openFailureSnackBar('Error', 2000);
          }
        })
      }

    });
  }

  async guardarAprobarTramite(params: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let url = `${environment.url_api}/aprobarTramite/${String(params.registroProfesionalid)}/${String(params.novedad)}/${String(params.idSubTipoRegistro)}/${String(params.idUsuario)}/${this.usuarioKeycloak.cedula}/${this.ipTramite}`
    const get$ = this.http.post(url, JSON.stringify(params.body),
      {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/json')
      }
    );
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }

  async guardarDevolverTramite(params: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let url = `${environment.url_api}/devolverTramite/${String(params.registroProfesionalid)}/${String(params.motivo)}/${String(params.idUsuario)}/${this.usuarioKeycloak.cedula}/${this.ipTramite}`
    const get$ = this.http.post(url, JSON.stringify(params.body),
      {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/json')
      }
    );
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }

  async guardarRechazarTramite(params: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let url = `${environment.url_api}/rechazarTramite/${String(params.registroProfesionalid)}/${String(params.motivo)}/${String(params.idUsuario)}/${this.usuarioKeycloak.cedula}/${this.ipTramite}`
    const get$ = this.http.post(url, JSON.stringify(params.body),
      {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/json')
      }
    );
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }

}
