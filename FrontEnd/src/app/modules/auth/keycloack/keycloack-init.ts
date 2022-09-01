import { KeycloakService } from 'keycloak-angular';
import { environment } from '../../../../environments/environment';
import Swal from 'sweetalert2'

export function initializeKeycloak(keycloak: KeycloakService): () => Promise<any> {
    return (): Promise<any> => {
        return new Promise(async (res,rej) => {
            try {
                await keycloak.init({
                    config: environment.keycloakConfig,
                    initOptions: {
                        onLoad: 'check-sso',
                        silentCheckSsoRedirectUri: window.location.origin + 'assets/static/silent-check-sso.html',
                    },
                    bearerExcludedUrls:['https://geolocation-db.com/json/'],
                    loadUserProfileAtStartUp: true
                 }).catch(err=>{
                    res(err)
                 })
              res('')
            }
            catch (error) {
                window.location.href=`${environment.page}`
                Swal.fire({
                    title: 'Error!',
                    text: 'Error de conexión con el Servidor',
                    icon: 'error',
                    confirmButtonText: 'Aceptar'
                  })
            }
        });
    };
}