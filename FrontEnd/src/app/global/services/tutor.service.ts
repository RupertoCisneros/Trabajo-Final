import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PamService } from '@core/helpers/pam.service';
import { EMPTY, lastValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IpService } from './ip.service';

@Injectable({
  providedIn: 'root'
})
export class TutorService {

  persona: any
  ipTramite: any
  mensaje!: string

  constructor(private http: HttpClient,
    private pamService: PamService,
    private ipService: IpService) {
    this.persona = this.pamService.obtenerPersona()
  }

  //Mensaje de validación si existe el tutor en la base de datos
  validarTutorSiExiste(idRegistro: number) {
    if (idRegistro) {
      return this.http.get(`${environment.url_api}/validarIngresoTutor/${this.persona.nroIdentificacion}/${idRegistro}`)
    }
    return EMPTY
  }

  // Registro de tutor de la mascota
  async registroTutor(formulario: any) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ipTramite = ip.IPv4
    });
    let registroTutor = {
      idUsuario: this.persona.usuarioId,
      direccion: formulario.direccion.direccion,
      ipUsuario: this.ipTramite,
      body:{
        estado: 'ACT',
        terminalCreacion: this.ipTramite,
        terminalModificacion: this.ipTramite,
        usuarioCreacion: this.persona.nroIdentificacion,
        usuarioModificacion: this.persona.nroIdentificacion,
      }

    }
    await this.guardarTutor(registroTutor).then(mensaje => {
      this.mensaje = mensaje
    })
    return this.mensaje
  }
  //Envío de información y llamado al backend para guardar el tutor de la mascota
  async guardarTutor(params: any) {
    let url = `${environment.url_api}/crearTutorMascota/${String(params.idUsuario)}/${String(params.direccion)}/${String(params.ipUsuario)}/${params.usuarioConectado}`
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
