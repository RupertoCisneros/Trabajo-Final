import { Component, OnDestroy, OnInit } from '@angular/core';
import { NavItem } from '@core/models/nav-item.model';
import { MediaChange, MediaObserver } from '@angular/flex-layout';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
import { Title } from '@angular/platform-browser';
import { ConsultasService } from '@global/services/consultas.service';
import { PamService } from '@core/helpers/pam.service';
import { LoadingService } from '@global/services/loading.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnDestroy, OnInit {
  public opened = true;
  private mediaWatcher: Subscription;
  public menu!: NavItem[];
  public resolved = false;
  ususarioLoged: any;
  roles!: string
  autenticado: any
  externo = false
  personaExterno: any
  loading = false

  constructor(
    private media: MediaObserver,
    private title: Title,
    private consultasService: ConsultasService,
    private keycloakAuthService: KeycloakAuthService,
    private pamService: PamService,
    public loadingService: LoadingService
  ) {
    loadingService.loading = true
    this.loading = true
    this.autenticado = keycloakAuthService.IsAuthenticated()
    if (this.autenticado) {
      this.roles = '(' + this.keycloakAuthService.getRoles()[0] + ')'
      this.ususarioLoged = this.keycloakAuthService.getLoggedUser();
      this.consultasService.getMenuByPerfil(this.keycloakAuthService.getRoles()[0]).subscribe({
        next: ((data) => {
          this.menu = data
          loadingService.loading = false
          this.loading = false
        }),
        error: (err) => {
          if (err) {
            console.log('Error conexión con Api');
            loadingService.loading = false
            this.loading = false
          }
        },
      })
    } else {
      this.consultasService.getMenuByPerfil('Ciudadano').subscribe({
        next: ((data) => {
          this.menu = data
          loadingService.loading = false
          this.loading = false
        }),
        error: (err) => {
          if (err) {
            console.log('Error conexión con Api');
            loadingService.loading = false
            this.loading = false
          }
        },
      })
      this.personaExterno = this.pamService.obtenerPersona()
      this.externo = true
      this.ususarioLoged = {
        name: this.personaExterno.denominacion
      }
      this.roles = ''
    }
    this.mediaWatcher = this.media
      .asObservable()
      .pipe(
        filter((changes: MediaChange[]) => changes.length > 0),
        map((changes: MediaChange[]) => changes[0])
      )
      .subscribe((mediaChange: MediaChange) => {
        this.handleMediaChange(mediaChange);
      });
  }
  ngOnInit(): void {
    this.title.setTitle('Remetfu');
  }

  private handleMediaChange(mediaChange: MediaChange): void {
    if (this.media.isActive('lt-sm')) {
      this.opened = false;
    } else {
      this.opened = true;
    }
  }

  ngOnDestroy(): void {
    this.mediaWatcher.unsubscribe();
  }

  salir(){
    if (this.autenticado) {
      this.signout();
    }else if(this.externo){
      this.signoutExterno();
    }
  }

  signout() {
    this.keycloakAuthService.logout();
  }
  signoutExterno() {
    localStorage.removeItem('persona');
    window.location.href = environment.url_pam;
  }
}
