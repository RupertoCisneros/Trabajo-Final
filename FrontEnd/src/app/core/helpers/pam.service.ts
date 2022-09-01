import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IpService } from '@global/services/ip.service';
import { lastValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PamService {

  persona: any
  ip:any

  constructor(
    private http: HttpClient,
    private ipService: IpService) {

  }

  //Envío del token del PAM hacia el backend para la creación de la persona si no existe
  async CrearPersonaPam(token: string) {
    await this.ipService.getIPPublic().then(async (ip: any) => {
      this.ip = ip.IPv4
    });
    let url = `${environment.url_api}/crearPersonasPAM/${token}/${this.ip}`
    const get$ = this.http.get(url);
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err)
  }

  //Obtener la persona desde el localstorage
  obtenerPersona() {
    this.persona = localStorage.getItem('persona');
    /* this.persona = localStorage.getItem('persona');
    if (JSON.parse(this.persona)) {
      let p = JSON.parse(this.persona)
      p.mailPersonal = 'ruper64@hotmail.com'
      return p
    } */
    if (JSON.parse(this.persona)) {
      return JSON.parse(this.persona)
    }
    return {}
  }
}
