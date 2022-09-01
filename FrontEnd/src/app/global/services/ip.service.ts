import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IpService {

  constructor(private http: HttpClient) { }

  //Obtener ip pública
  async getIPPublic() {
    const get$ = this.http.get<any>('https://geolocation-db.com/json/')
    return await lastValueFrom(get$)
      .then((resp) => resp)
      .catch((err) => err);
  }
}
