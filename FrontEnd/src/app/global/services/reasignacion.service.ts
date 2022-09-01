import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { lastValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IpService } from './ip.service';

@Injectable({
  providedIn: 'root'
})
export class ReasignacionService {

  ipTramite: any
  mensaje: any
  usuarioKeycloak!: any
  constructor(
    private http: HttpClient,
    private ipService: IpService,
    private keycloakService: KeycloakAuthService,
  ) {
    this.usuarioKeycloak = this.keycloakService.getLoggedUser();
  }
  async reasignar(seleccionados: any, usuarioSeleccionado: any, motivo: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let data = [];
    for (const tramite of seleccionados) {
      let param = {
        motivoCambio: motivo,
        analistaAntes: tramite.analistaId,
        analistaDespues: usuarioSeleccionado.analistaId,
        registroProfesionalId: tramite.registroProfesionalId,
        cedulaUsuarioReasignacion: this.usuarioKeycloak.cedula,
        equipoReasignacion: this.ipTramite,
      }
      data.push(param)
    }
    await this.reasignarTramites(data).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  
  async reasignarTramites(body: any) {
    const get$ = this.http.post(`${environment.url_api}/actualizarDatosTramite`, JSON.stringify(body), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
    });
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }


}


