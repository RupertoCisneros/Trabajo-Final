import { Component, OnInit } from '@angular/core';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {
  mostrarMenu = false

  constructor(
    private keycloackService: KeycloakAuthService
  ) {
    if (this.keycloackService.IsAuthenticated()) {
      this.mostrarMenu = true
    }
  }

  ngOnInit(): void {
  }
}
