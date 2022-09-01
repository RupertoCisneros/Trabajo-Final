import { Injectable } from '@angular/core';
import { Event, NavigationEnd, Router } from '@angular/router';
import { BehaviorSubject, lastValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class NavService {
    public appDrawer: any;
  private currentUrl = new BehaviorSubject<string>('');

  constructor(private router: Router,private http: HttpClient) {
      this.router.events.subscribe((event: Event) => {
          if (event instanceof NavigationEnd) {
              this.currentUrl.next(event.urlAfterRedirects);
          }
      });
  }

  public getCurrentUrl(): BehaviorSubject<string> {
      if (!this.currentUrl.value) {
          const url = this.router.url;
          this.currentUrl.next(url);
      }

      return this.currentUrl;
  }
  public closeNav() {
    this.appDrawer.close();
  }

  public openNav() {
    this.appDrawer.open();
  }
  async obtenerModulos() {
    const get$ = this.http.get(`${environment.url_api}/modulo/modulos`);
    return await lastValueFrom(get$)
    .then((resp) => resp)
    .catch((err) => err);
  }
}
