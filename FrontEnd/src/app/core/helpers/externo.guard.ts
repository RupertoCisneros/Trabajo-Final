import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { KeycloakAuthService } from './keycloak-auth.service';

@Injectable({
  providedIn: 'root'
})
export class ExternoGuard implements CanActivate {
  constructor(
    private router: Router,
    private keycloakAuthService: KeycloakAuthService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if (this.keycloakAuthService.IsAuthenticated()) {
        console.log(true);
        localStorage.removeItem('persona')
        this.router.navigate(['']);
        return false
      }
      if (!localStorage.getItem('persona')) {
        this.router.navigate(['/auth'])
        return false
      }
    return true;
  }
  
}
