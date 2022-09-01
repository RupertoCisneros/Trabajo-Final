import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { PamService } from '@core/helpers/pam.service';
import { lastValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IpService } from './ip.service';

@Injectable({
  providedIn: 'root'
})
export class MicrochipService {

  persona: any
  mensaje: any
  ipTramite: any
  usuario: any

  constructor(
    private http: HttpClient,
    private pamService: PamService,
    private ipService: IpService,
    private keycloakService: KeycloakAuthService,) {
    this.usuario = this.keycloakService.getLoggedUser();
    this.persona = this.pamService.obtenerPersona()
  }

  validarRegistroMicrochip() {
    return this.http.get(`${environment.url_api}/validarIngresoPagado/${this.persona.nroIdentificacion}`)
  }
  async registroMicrochip(formulario: any, uba: boolean) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let usuario,usuarioCreacion;
    if (uba) {
      usuario = this.usuario.cedula;
      usuarioCreacion = this.usuario.cedula;
    } else {
      usuario = this.persona.usuarioId;
      usuarioCreacion = this.persona.nroIdentificacion;
    }
    let registroMicrochip;
    registroMicrochip = {
      tutorId: formulario.tutor.tutor_id,
      usuario: usuario,
      establecimientoId: formulario.establecimiento.establecimientoId,
      body: {
        acuerdoResponsabilidad: "SI",
        codigoMicrochip: formulario.microchip.codigoMicrochip,
        informacionConsiderada: formulario.informacionConsiderada.informacionConsiderada,
        observacion: formulario.observacion.observacion,
        estado: "ACT",
        terminalCreacion: this.ipTramite,
        terminalModificacion: this.ipTramite,
        usuarioCreacion: usuarioCreacion,
        usuarioModificacion: usuarioCreacion,
      }
    }
    await this.guardarMicrochip(registroMicrochip, uba).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje

  }

  async guardarMicrochip(params: any, uba: boolean) {
    let url;
    if (uba) {
      url = `${environment.url_api}/creaMicrochipUba/${String(params.tutorId)}/${String(params.usuario)}/${String(params.establecimientoId)}`
    } else {
      url = `${environment.url_api}/creaMicrochip/${String(params.tutorId)}/${String(params.usuario)}/${String(params.establecimientoId)}`
    }
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
}
