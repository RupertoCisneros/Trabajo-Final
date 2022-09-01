import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { Catalogo, TipoCatalogo } from '@core/models/tipo-catalogo.model';
import { lastValueFrom, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import _ from 'underscore';
import { IpService } from './ip.service';
@Injectable({
  providedIn: 'root'
})
export class CatalogosService {

  ipTramite!:any
  usuarioKeycloak!:any
  mensaje!:any

  constructor(
    private http: HttpClient,
    private keycloakService: KeycloakAuthService,
    private ipService: IpService) {
      this.usuarioKeycloak = this.keycloakService.getLoggedUser()
  }
  obtenerTipoCatalogos(): Observable<TipoCatalogo[]> {
    return this.http.get<TipoCatalogo[]>(`${environment.url_api}/obtenerTipoCatalogos`);
  }
  obtenerCatalogos(): Observable<Catalogo[]> {
    return this.http.get<Catalogo[]>(`${environment.url_api}/obtenerListaCatalogos`);
  }

  updateUser(user: TipoCatalogo): Observable<TipoCatalogo> {
    return this.http.patch<TipoCatalogo>(`${environment.url_api}/${user.tipoCatalogoId}`, user);
  }
  async addCatalogo(Catalogo: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let fechaModificacion = new Date();
    let data = _.omit(Catalogo,'Acciones','catalogoId','isSelected')
    let body = {
      usuarioCreacion: this.usuarioKeycloak.cedula,
      terminalCreacion: this.ipTramite,
      usuarioModificacion: this.usuarioKeycloak.cedula,
      terminalModificacion: this.ipTramite,
      fechaModificacion: fechaModificacion,
      estado: data.estado
    }
    await this.guardarCatalogo(data,body).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async guardarCatalogo(data: any,body:any) {
    let url = `${environment.url_api}/creaCatalogo/${data.tipoCatalogoId}/${data.nombre}`
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

  async addTipoCatalogo(tipoCatalogo: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let body = _.omit(tipoCatalogo,'Acciones','tipoCatalogoId','isSelected')
    body.terminalCreacion = this.ipTramite
    body.terminalModificacion = this.ipTramite
    body.usuarioCreacion = this.usuarioKeycloak.cedula,
    body.usuarioModificacion = this.usuarioKeycloak.cedula
    await this.guardarTipoCatalogo(body).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async guardarTipoCatalogo(body:any) {
    let url = `${environment.url_api}/crearTipoCatalogo/${body.nombre}`
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
  eliminarCatalogo(id: number): Observable<any> {
    return this.http.post<any>(`${environment.url_api}/eliminarCatalogo/${id}`, JSON.stringify({}), {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
    });
  }
}
