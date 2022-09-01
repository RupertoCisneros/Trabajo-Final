import { DatePipe } from '@angular/common';
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
export class AnimalService {

  persona: any
  ipTramite: any
  mensaje!: string
  usuarioKeycloak: any
  tutor!: any

  constructor(private http: HttpClient,
    private pamService: PamService,
    private ipService: IpService,
    private datePipe: DatePipe,
    private keycloakService: KeycloakAuthService) {
    this.persona = this.pamService.obtenerPersona()
    this.usuarioKeycloak = this.keycloakService.getLoggedUser()
  }

  async registroAnimal(formulario: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let registroAnimal = {
      animalTutor: [
        {
          tutoresComunitarios: formulario.datosGenerales.datosGenerales.tutoresComunitarios,
          comunitario: formulario.datosGenerales.datosGenerales.comunitario,
          codigoMicrochip: formulario.datosGenerales.datosGenerales.microchip,
          observacionMicrochip: formulario.datosGenerales.datosGenerales.observacionMicrochip,
          nombreAnimal: formulario.datosGenerales.datosGenerales.nombreAnimal,
          fechaNacimiento: this.datePipe.transform(formulario.datosGenerales.datosGenerales.nacimiento, 'yyyy-MM-dd'),
          cerramiento: formulario.permanenciaAnimal.permanenciaAnimal.cerramiento,
          enfermedadCatastrofica: formulario.salud.salud.enfermedades,
          examenComportamental: formulario.salud.salud.examenClinicoBoolean,
          certificadoVacunacion: formulario.certificados.certificados.certificadoVacunadoBoolean,
          certificadoEsterilizacion: formulario.certificados.certificados.certificadoEsterilizadoBoolean,
          seniasParticulares: formulario.caracteristicas.caracteristicas.señasParticulares,
          metrosCuadradosTotal: formulario.permanenciaAnimal.permanenciaAnimal.metrosTotal,
          metrosCuadradosAproximado: formulario.permanenciaAnimal.permanenciaAnimal.metrosAproximado,
          descripcionEnfermedades: formulario.salud.salud.descripcionEnfermedades,
          identificacionFotografica: formulario.caracteristicas.caracteristicas.identificacionFotografica.files,
          identificacionVisible: formulario.caracteristicas.caracteristicas.identificacionVisible.files,
          examenClinicoArchivo: this.isObjEmptyData(formulario.salud.salud.examenClinico, 'files'),
          examenFisico: formulario.salud.salud.examenFisico,
          certificadoVacunacionArchivo: this.isObjEmptyData(formulario.certificados.certificados.certificadoVacunado, 'files'),
          certificadoEsterilizadoArchivo: this.isObjEmptyData(formulario.certificados.certificados.certificadoEsterilizado, 'files'),
          tipoAnimal: formulario.datosGenerales.datosGenerales.tipoAnimal,
          barrio: formulario.permanenciaAnimal.permanenciaAnimal.direccionTutor.barrio,
          nomenclatura: formulario.permanenciaAnimal.permanenciaAnimal.direccionTutor.nomenclatura,
          otros: formulario.permanenciaAnimal.permanenciaAnimal.direccionTutor.otros,
          principal: formulario.permanenciaAnimal.permanenciaAnimal.direccionTutor.principal,
          referencia: formulario.permanenciaAnimal.permanenciaAnimal.direccionTutor.referencia,
          secundaria: formulario.permanenciaAnimal.permanenciaAnimal.direccionTutor.secundaria,
          fallecimiento: this.datePipe.transform(formulario.certificados.certificados.fallecimiento, 'yyyy-MM-dd'),
          acuerdoResponsabilidad: "SI",
          estado: "ACT",
          usuarioCreacion: this.persona.nroIdentificacion,
          terminalCreacion: this.ipTramite,
          usuarioModificacion: this.persona.nroIdentificacion,
          terminalModificacion: this.ipTramite,
        }
      ],
      datosIngreso: [
        {
          usuarioId: this.persona.usuarioId,
          estatusVivienda: formulario.permanenciaAnimal.permanenciaAnimal.estatusVivienda,
          procedenciaAnimal: formulario.datosGenerales.datosGenerales.procedenciaAnimal,
          colorPredominante: formulario.caracteristicas.caracteristicas.colorPredominante,
          colorSecundario: formulario.caracteristicas.caracteristicas.colorSecundario,
          especie: formulario.caracteristicas.caracteristicas.especie,
          estadoReproductivo: formulario.caracteristicas.caracteristicas.estadoReproductivo,
          estadoTutoria: formulario.datosGenerales.datosGenerales.estadoTutoriaId,
          motivoFallecimiento: formulario.certificados.certificados.motivoFallecimiento,
          parroquia: formulario.permanenciaAnimal.permanenciaAnimal.direccionTutor.parroquiaId,
          permanencia: formulario.permanenciaAnimal.permanenciaAnimal.permanencia,
          pruebaComportamiento: formulario.salud.salud.pruebaComportamiento,
          raza: formulario.caracteristicas.caracteristicas.raza,
          sexo: formulario.caracteristicas.caracteristicas.sexo,
          tipoVivienda: formulario.permanenciaAnimal.permanenciaAnimal.vivienda
        }
      ]
    }
    await this.guardarAnimal(registroAnimal).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje

  }
  async registroAtencionAnimal(formulario: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let registroAtencionAnimal = {
      atencionAnimales: [
        {
          funcionarioUBA: this.usuarioKeycloak.cedula,
          enfermedades: formulario.enfermedades.data,
          identificacionFotografica: formulario.identificacionFotografica.files[0],
          identificacionVisible: formulario.identificacionVisible.files[0],
          nacimiento: this.datePipe.transform(formulario.nacimiento.data, 'yyyy-MM-dd'),
          nombreAnimal: formulario.nombreAnimal.data,
          numeroMicrochip: formulario.numeroMicrochip.data,
          observaciones: formulario.observaciones.data,
          usuarioCreacion: this.usuarioKeycloak.cedula,
          terminalCreacion: this.ipTramite,
          usuarioModificacion: this.usuarioKeycloak.cedula,
          terminalModificacion: this.ipTramite,
        }
      ],
      datosIngreso: [
        {
          atencionRealizada: formulario.atencionRealizada.data,
          estadoChequeo: formulario.estadoChequeo.data,
          tipoIdentificacion: formulario.tipoIdentificacion.data
        }]
    }
    await this.guardarAtencionAnimal(registroAtencionAnimal).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async registroRetiroAnimal(formulario: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let registroRetiroAnimal = {
      datosIngreso: [
        {
          administracionZonal: formulario.administracionZonal.data,
          parroquiaId: formulario.direccionRetiro.parroquiaId,
          estadoTutoriaId: formulario.estadoTutoriaId,
          situacionIntervencion: formulario.situacionIntervencion.data,
          motivoRetiro: formulario.motivoRetiro.data,
        }],
      retiroAnimales: [
        {
          funcionarioUBA: this.usuarioKeycloak.cedula,
          condicionCalle: formulario.condicionCalle,
          barrio: formulario.direccionRetiro.barrio,
          nombreParroquia: formulario.direccionRetiro.nombreParroquia,
          nomenclatura: formulario.direccionRetiro.nomenclatura,
          otros: formulario.direccionRetiro.otros,
          principal: formulario.direccionRetiro.principal,
          referencia: formulario.direccionRetiro.referencia,
          secundaria: formulario.direccionRetiro.secundaria,
          motivoDescripcion: formulario.motivoDescripcion.data,
          motivoFile: formulario.motivoFile.files[0],
          usuarioCreacion: this.usuarioKeycloak.cedula,
          terminalCreacion: this.ipTramite,
          usuarioModificacion: this.usuarioKeycloak.cedula,
          terminalModificacion: this.ipTramite,
          observacionTutor: formulario.observaciónTutor.data,
          observacionIntervencion: this.isObjEmptyData(formulario.observacionIntervencion,'data'),
        }]
    }
    await this.guardarRetiroAnimal(registroRetiroAnimal).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async registroRecepcionAnimal(formulario: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let registroRecepionAnimal = {
      recepcionAnimales: [
        {
          seniasParticulares: formulario.seniasParticulares.data,
          descripcionProceso: formulario.descripcionProceso.data,
          examenComportamental: formulario.examenComportamiento,
        }],
      datosIngreso: [
        {
          funcionarioUBA: this.usuarioKeycloak.cedula,
          agencia: formulario.agenciaUBA.data,
          especie: formulario.especie.data,
          raza: formulario.raza.data,
          sexo: formulario.sexo.data,
          estadoReproductivo: formulario.estadoReproductivo.data,
          colorPredominante: formulario.colorPredominante.data,
          colorSecundario: formulario.colorSecundario.data,
          procesoEjecucion: formulario.procesoEjecucion.data,
          examenClinicoComportamental: this.isObjEmpty(formulario.examenClinicoComportamental, 'data'),
          usuarioCreacion: this.usuarioKeycloak.cedula,
          terminalCreacion: this.ipTramite,
          usuarioModificacion: this.usuarioKeycloak.cedula,
          terminalModificacion: this.ipTramite,
        }
      ]
    }
    await this.guardarRecepcionAnimal(registroRecepionAnimal).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  async guardarAtencionAnimal(params: any) {
    let url = `${environment.url_api}/crearAtencionAnimal`
    const get$ = this.http.post(url, JSON.stringify(params),
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
  async guardarRetiroAnimal(params: any) {
    let url = `${environment.url_api}/crearRetiroAnimal`
    const get$ = this.http.post(url, JSON.stringify(params),
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
  async guardarRecepcionAnimal(params: any) {
    let url = `${environment.url_api}/crearRecepcionAnimales`
    const get$ = this.http.post(url, JSON.stringify(params),
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


  async guardarAnimal(params: any) {
    let url = `${environment.url_api}/crearAnimalTutor`
    const get$ = this.http.post(url, JSON.stringify(params),
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
  isObjEmpty(obj: any, name: string) {
    if (obj) {
      if (!obj.hasOwnProperty(name)) return '';
      else return obj
    }
    return ''
  }
  isObjEmptyData(obj: any, name: string) {
    if (obj) {
      if (!obj.hasOwnProperty(name)) return '';
      else return obj[`${name}`]
    }
    return ''
  }

  validarAnimalTutor() {
    return this.http.get(`${environment.url_api}/validarExisteTutor/${this.persona.nroIdentificacion}`)
  }

}
