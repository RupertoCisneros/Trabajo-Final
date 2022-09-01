import { Injectable } from '@angular/core'; 
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakLoginOptions } from 'keycloak-js';
import { environment } from 'src/environments/environment';
@Injectable({ 
    providedIn: 'root' 
}) 
export class KeycloakAuthService { 
  keycloakLoginOptions: KeycloakLoginOptions = {
    redirectUri: environment.page
  }
    constructor(private keycloakService: KeycloakService,private route: Router) { } 

    getLoggedUser(){
      try {
        let userDetails = this.keycloakService.getKeycloakInstance().idTokenParsed;
        return userDetails;
      } catch (e) {
        console.log('getLoggedUser Exception',e);
        return undefined
      }
    }
    logout(){
      localStorage.clear()
      this.keycloakService.logout(this.keycloakLoginOptions.redirectUri);
    }
    login(){
      this.keycloakService.login(this.keycloakLoginOptions);
    }
    redirectToProfile(){
      this.keycloakService.getKeycloakInstance().accountManagement();
    }
    getRoles(){
      let roles = this.keycloakService.getKeycloakInstance().resourceAccess
      if (roles!['remetfu-angular']) {
        return roles!['remetfu-angular'].roles;
      }
      return []
    }

    redirectToMenu(){
      if (this.keycloakService.getKeycloakInstance().authenticated) {
        this.route.navigate(['']);
      }
    }
    public isLoggedIn(): Promise<boolean>{
      return this.keycloakService.isLoggedIn();
    }

    IsAuthenticated(){
      return this.keycloakService.getKeycloakInstance().authenticated;
    }
    
    getToken(){
      return this.keycloakService.getToken();
    }

}