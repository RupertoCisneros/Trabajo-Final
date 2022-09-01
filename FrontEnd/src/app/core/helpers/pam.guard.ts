import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { PamService } from '@core/helpers/pam.service';
import { LoadingService } from '@global/services/loading.service';
import { MensajesService } from '@global/services/mensajes.service';
import { environment } from 'src/environments/environment';
import { KeycloakAuthService } from './keycloak-auth.service';

@Injectable({
  providedIn: 'root'
})
export class PamGuard implements CanActivate {
  constructor(
    private router: Router, 
    private pamService: PamService, 
    private keycloakAuthService: KeycloakAuthService, 
    private loadingService: LoadingService,
    private mensajesService: MensajesService) {

  }
  async canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Promise<boolean | UrlTree> {
    //KEYCLOACK
    if (this.keycloakAuthService.IsAuthenticated()) {
      localStorage.removeItem('persona')
      this.router.navigate(['']);
      return false
    }
    this.loadingService.loading = true
    //PAM - se obtiene el token del PAM y se crea la persona si no existe en la base de datos
    let token = route.queryParams['token']
    if (token) {
      await this.pamService.CrearPersonaPam(token).then(data => {
        if (data.usuarioId) {
          localStorage.setItem('persona', JSON.stringify(data))
          this.router.navigate(['Externo/Inicio'])
          this.loadingService.loading = false
          return true;
        } else
          if (!data.ok) {
            this.mensajesService.openFailureSnackBar('Error de Conexión, vuelva a intentarlo.',1500).afterDismissed().subscribe(()=>{
              this.loadingService.loading = false
              window.location.href = environment.url_pam;
            })
            return false;
          }
        return false;
      })
    } else {
      this.loadingService.loading = false
      if (localStorage.getItem('persona')) {
        this.router.navigate(['Externo/Inicio'])
        this.loadingService.loading = false
        return true
      }
    }

    return true;

  }

}
