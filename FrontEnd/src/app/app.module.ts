import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//Import servicios
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
//Modulos
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from '@modules/material/material.module';
import { AuthModule } from '@modules/auth/auth.module';
import { NgxLoadingModule } from 'ngx-loading';
//BARRAS DE CARGA NGX-LOADING-BAR
import { LoadingBarHttpClientModule } from '@ngx-loading-bar/http-client';
import { LoadingBarRouterModule } from '@ngx-loading-bar/router';
import { LoadingBarModule } from '@ngx-loading-bar/core';
//Keycloack
import { KeycloakService, KeycloakAngularModule } from 'keycloak-angular';
import { initializeKeycloak } from '@modules/auth/keycloack/keycloack-init';
import { KeycloakGuard } from '@core/helpers/keycloak-auth.guard'
import { KeycloakAuthService } from '@core/helpers/keycloak-auth.service';
//Interceptores
import { DEFAULT_TIMEOUT,defaultTimeout, TimeoutInterceptor } from '@global/Interceptors/timeout.interceptor';
import { SharedModule } from '@shared/shared.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    LoadingBarHttpClientModule,
    LoadingBarRouterModule,
    LoadingBarModule,
    AuthModule,
    SharedModule,
    KeycloakAngularModule,
    NgxLoadingModule.forRoot({})

  ],
  providers: [Title,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    },
    KeycloakGuard,
    KeycloakAuthService,
    { provide: HTTP_INTERCEPTORS, useClass: TimeoutInterceptor, multi: true },
    { provide: DEFAULT_TIMEOUT, useValue: defaultTimeout }],
  bootstrap: [AppComponent],
})
export class AppModule { }
