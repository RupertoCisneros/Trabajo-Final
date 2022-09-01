import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private title: Title,
    private keycloakAuthService: KeycloakAuthService) {
  }
  ngOnInit(): void {
    this.title.setTitle("Login")
  }

  login(): void {
    this.keycloakAuthService.login();
  }
}
