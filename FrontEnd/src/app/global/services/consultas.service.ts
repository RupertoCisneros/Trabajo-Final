import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NavItem } from '@core/models/nav-item.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConsultasService {

  constructor(private http: HttpClient) { }

  //Consulta en la tabla TIPO_CATALOGO por Id
  consultaTipoCatalogo(id: number): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerTipoCatalogosById/${id}`)
  }
  //Consulta las tablas TIPO_REGISTRO y SUBTIPO_REGISTRO cabecera y detalle
  consultaTipoRegistro(): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerRegistros`)
  }
  //Consulta los analista activos
  consultaAnalistas(): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerNroRegistrosAnalista`)
  }
  //Consulta el menu del usuario  en la tabla MENU_CABECERA y MENU
  getMenuByPerfil(perfil: String): Observable<NavItem[]> {
    return this.http.get<NavItem[]>(`${environment.url_api}/obtenerDatosMenu/${perfil}`)
  }
  //Consulta la bandeja del analista por identificación
  consultaTramitesAnalista(cedula: string): Observable<any> {
    return this.http.get(`${environment.url_api}/bandejaAnalista/${cedula}`)
  }
  //Consulta los perfiles de los usuarios
  consultarPerfiles(): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerPerfiles`)
  }
  //Consulta usuario por indentificacion
  consultarUsuarioPorIdentificacion(cedula: string): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerUsuarioByCedula/${cedula}`)
  }
  //Consulta los titulos del usuario por identificación
  consultarUsuarioTitulosDinardap(cedula: string): Observable<any> {
    return this.http.get(`${environment.url_api}/usuario/titulos/${cedula}`)
  }
  //Consulta el usuario interno de Keycloak por el nombre de usuario
  obtenerUsuarioKeyCloack(username: string): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerUsuarioKeyCloack/${username}`);
  }
  //Consulta el registro profesional por id
  obtenerRegistroProfesionalporID(id: number): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerRegistroProfesional/${id}`);
  }
  //Consulta todos los registros del ciudadano externo por identificación
  obtenerRegistrosCiudadano(cedula: string): Observable<any> {
    return this.http.get(`${environment.url_api}/registrosCiudadano/${cedula}`);
  }
  //Consulta por nombre el usuario con perfil Analistas de tramites
  consultaNombresAnalistas(nombre: string): Observable<any> {
    return this.http.get(`${environment.url_api}/consultaNombresAnalistas/${nombre}`);
  }
  consultaNombres(nombre: string): Observable<any> {
    return this.http.get(`${environment.url_api}/consultaNombres/${nombre}`);
  }
  //Consulta de registros por busqueda por filtros
  obtenerRegistrosPorFiltros(params: any): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerRegistrosPorFiltros/${params.identificacion}/${params.estado}/${params.fechaDesde}/${params.fechaHasta}/`);
  }
  // Descarga el pdf del registro Profesional
  descargarPdf(idregistro: number): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerArchivoRegistroProfesional/${idregistro}`, { responseType: 'blob' });
  }
  // Consulta todos los comites de ética
  obtenerCabeceraComite(): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerDatosComiteEtica`);
  }
  // Consulta la persona del servicio de personas por identificación
  obtenerUsuarioPersonas(identificacion: string): Observable<any> {
    return this.http.get(`${environment.url_api}/usuarioPersonas/${identificacion}`);
  }
  // Obtiene el sub tipo de registro por id
  obtenerSubTipoRegistro(id: number): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerSubtipoRegistroById/${id}`);
  }
  // Consulta los miembros del comite de ética
  obtenerMiembrosComite(id: number): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerMiembrosComiteEtica/${id}`);
  }
  // Consulta todos los usuarios internos
  obtenerUsuarios(): Observable<any> {
    return this.http.get(`${environment.url_api}/obtenerUsuarios`);
  }
  //Consulta para obtener el tutor de la mascota
  obtenerTutor(identificacion: string) {
    return this.http.get(`${environment.url_api}/datosTutorMascota/${identificacion}`)
  }


}
