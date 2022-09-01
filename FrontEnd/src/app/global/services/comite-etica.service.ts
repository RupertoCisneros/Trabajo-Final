import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { lastValueFrom, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IpService } from './ip.service';

@Injectable({
  providedIn: 'root'
})
export class ComiteEticaService {
  ipTramite: any
  mensaje: any
  usuarioKeycloak: any

  constructor(
    private http: HttpClient,
    private ipService: IpService,
    private keycloakService: KeycloakAuthService,) {
    this.usuarioKeycloak = this.keycloakService.getLoggedUser()
  }

  async registroComite(comite: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let body = {
      nombreInstitucion: comite.nombreInstitucion,
      facultadInvestigacion: comite.facultad,
      usuarioCreacion: this.usuarioKeycloak.cedula,
      terminalCreacion: this.ipTramite,
      estado: 'INA'
    }
    await this.guardarComite(body).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async guardarComite(body: any) {
    let url = `${environment.url_api}/crearComiteEticaCab`
    const get$ = this.http.post(url, JSON.stringify(body),
      {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/json')
      }
    );
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }
  async guardarMiembroComite(params: any, body: any) {
    let url = `${environment.url_api}/creaComiteEtica/${params.idComite}/${params.body.cargo}`
    const get$ = this.http.post(url, JSON.stringify(body),
      {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/json')
      }
    );
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }

  async registroMiembroComite(params: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let body = {
      identificacion: params.body.identificacion,
      nombres: params.body.nombres,
      numeroSenecyt: params.body.nroSENESCYT.data,
      correo: params.body.email,
      telefono: params.body.telefono,
      usuarioCreacion: this.usuarioKeycloak.cedula,
      terminalCreacion: this.ipTramite
    }
    await this.guardarMiembroComite(params, body).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }

  eliminarMiembroComiteEtica(id: number) {
    return this.http.post<any>(`${environment.url_api}/eliminarMiembroComiteEtica/${id}`, JSON.stringify({}), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
    });
  }

  validarExisteMiembroComite(cedula: string, idComite: number): Observable<any> {
    return this.http.get(`${environment.url_api}/validarExisteMiembroComite/${cedula}/${idComite}`);
  }

  async registroComiteCompleto(comiteId: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let params = {
      body:{
        comiteEticaCabId: comiteId,
        estado: 'ACT'
      },
      usuarioModificacion: this.usuarioKeycloak.cedula,
      terminalModificacion: this.ipTramite,
    }
    await this.guardarComiteCompleto(params).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async guardarComiteCompleto(params: any) {
    let url = `${environment.url_api}/guardarComiteEticaCompleto/${params.usuarioModificacion}/${params.terminalModificacion}`
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
