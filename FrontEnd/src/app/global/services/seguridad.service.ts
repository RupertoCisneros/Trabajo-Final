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
export class SeguridadService {

  ipTramite!:any
  usuarioKeycloak!:any
  mensaje!:any
  persona:any

  constructor(
    private http: HttpClient,
    private ipService: IpService,
    private keycloakService: KeycloakAuthService,
    private pamService: PamService) {
      this.persona = this.pamService.obtenerPersona()
      this.usuarioKeycloak = this.keycloakService.getLoggedUser();
     }

  async asignarPerfil(body: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    body.terminalCreacion = this.ipTramite
    body.terminalModificacion = this.ipTramite
    body.usuarioCreacion = this.usuarioKeycloak.cedula,
    body.usuarioModificacion = this.usuarioKeycloak.cedula

    await this.guardarAsignarPerfil(body).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }

  async guardarAsignarPerfil(body: any) {
    const get$ = this.http.post(`${environment.url_api}/crearAsignarUsuario/`, JSON.stringify(body), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
    });
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }

  async registroActivarOInactivarUsuario(usuario: any,proceso:number) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let body = {
      terminalModificacion: this.ipTramite,
      usuarioModificacion: this.usuarioKeycloak.cedula,
      body: usuario
    }
    console.log(body);
    await this.activarOInactivarUsuario(body,proceso).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async activarOInactivarUsuario(params:any,proceso:number){
    const get$ = this.http.post(`${environment.url_api}/inactivarUsuario/${params.terminalModificacion}/${params.usuarioModificacion}/${proceso}`, JSON.stringify(params.body), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
    });
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }
}
