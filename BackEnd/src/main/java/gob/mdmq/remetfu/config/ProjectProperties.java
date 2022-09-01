/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.config;

/**
 *
 * @author srcisnerosv
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Component
public class ProjectProperties {

    @Value("${WSO2.usuario.token}")
    private String wso2UsuarioToken;

    @Value("${WSO2.password.token}")
    private String wso2PasswordToken;

    @Value("${WSO2.usuario.consumidor}")
    private String wso2UsuarioConsumidor;

    @Value("${WSO2.secreto.consumidor}")
    private String wso2SecretoConsumidor;

    @Value("${WSO2.TokenUrl}")
    private String wso2TokenURL;

    @Value("${WSO2.ApiMunicipales.url}")
    private String wso2ApiMunicipalesURL;

    @Value("${WS02.usuarios.url}")
    private String wso2UsuariosKeyCloak;
    
    @Value("${keycloak.clientId}")
    private String keycloakClientId;

    @Value("${ruta.archivoLog}")
    private String rutaArchivoLog;
    
    @Value("${WS.SOAPClientPersonas.url}")
    private String wsSoapClientPersonasURL;

    @Value("${WS.SOAPClientPersonas.SOAPActionPersonaCompleto}")
    private String wsSoapClientPersonasActionPersonaCompleto;

    @Value("${WS.SOAPClientPersonas.SOAPActionPersonaCIM}")
    private String wsSoapClientPersonasActionPersonaCIM;

    @Value("${WS.SOAPClientPersonas.SOAPActionPersonaDirecciones}")
    private String wsSoapClientPersonasActionDirecciones;
    
    @Value("${WS.SOAPClientPersonas.SOAPActionPersonaDiscapacidad}")
    private String wsSoapClientPersonasActionDiscapacidad;

    @Value("${WS.MDMQ_WS_PAM.url}")
    private String wsMdmqWsPam;

    @Value("${WS.MDMQ_WS_PAM.ObtenerPersonaExtension}")
    private String wsMdmqWsPamObtenerPersonaExtension;

    @Value("${WS.ReportesRemetfu}")
    private String wsreportesRemetfu;
    
    @Value("${WSO2.ApiFileServer.url}")
    private String wso2ApiFileServerURL;

    @Value("${WSO2.ApiFileServer.nombreProyecto}")
    private String wso2ApiFileServerNombreProyecto;

    @Value("${WSO2.ApiFileServer.descripcionProyecto}")
    private String wso2ApiFileServerDescripcionProyecto;

    @Value("${mail.from}")
    private String mailFrom;

    @Value("${mail.test}")
    private Boolean mailTest;

    @Value("${mail.test.to}")
    private String mailTestTo;    
    
    @Value("${WS.DocumentalService}")
    private String wsDocumentalService;
    
    @Value("${WS.ServiceSAO.pruebasInternas}") 
    private String wsServiceSAOpruebasInternas;
    
    @Value("${WS.ServiceSAO.desarrollo}") 
    private String wsServiceSAOdesarrollo;
    
    @Value("${WS.ServiceSAO.ordenesPago}")
    private String wsServiceSAOordenesPago;
    
    @Value("${WS.DINARDAP_interoperabilidad_Cabecera}")
    private String wsDINARDAPinteroperabilidadCabecera;

    @Value("${WS.DINARDAP_interoperabilidad_Address}")
    private String wsDINARDAPinteroperabilidadAddress;

    @Value("${WS.DINARDAP_interoperabilidad_Username}")
    private String wsDINARDAPinteroperabilidadUsername;

    @Value("${WS.DINARDAP_interoperabilidad_Password}")
    private String wsDINARDAPinteroperabilidadPassword;
        
    @Value("${usuarioCabeceraPersonas}") 
    private String usuarioCabeceraPersonas;
    
    @Value("${claveCabeceraPersonas}") 
    private String claveCabeceraPersonas;
    
    @Value("${valorDinardapConsulta}") 
    private String valorDinardapConsulta;
    
    public ProjectProperties() {
    }

    public ProjectProperties(String wso2UsuarioToken, String wso2PasswordToken, String wso2UsuarioConsumidor, String wso2SecretoConsumidor, String wso2TokenURL, String wso2ApiMunicipalesURL, String wso2UsuariosKeyCloak, String keycloakClientId, String rutaArchivoLog, String wsSoapClientPersonasURL, String wsSoapClientPersonasActionPersonaCompleto, String wsSoapClientPersonasActionPersonaCIM, String wsSoapClientPersonasActionDirecciones, String wsSoapClientPersonasActionDiscapacidad, String wsMdmqWsPam, String wsMdmqWsPamObtenerPersonaExtension, String wsreportesRemetfu, String wso2ApiFileServerURL, String wso2ApiFileServerNombreProyecto, String wso2ApiFileServerDescripcionProyecto, String mailFrom, Boolean mailTest, String mailTestTo, String wsDocumentalService, String wsServiceSAOpruebasInternas, String wsServiceSAOdesarrollo, String wsServiceSAOordenesPago, String wsDINARDAPinteroperabilidadCabecera, String wsDINARDAPinteroperabilidadAddress, String wsDINARDAPinteroperabilidadUsername, String wsDINARDAPinteroperabilidadPassword, String usuarioCabeceraPersonas, String claveCabeceraPersonas, String valorDinardapConsulta) {
        this.wso2UsuarioToken = wso2UsuarioToken;
        this.wso2PasswordToken = wso2PasswordToken;
        this.wso2UsuarioConsumidor = wso2UsuarioConsumidor;
        this.wso2SecretoConsumidor = wso2SecretoConsumidor;
        this.wso2TokenURL = wso2TokenURL;
        this.wso2ApiMunicipalesURL = wso2ApiMunicipalesURL;
        this.wso2UsuariosKeyCloak = wso2UsuariosKeyCloak;
        this.keycloakClientId = keycloakClientId;
        this.rutaArchivoLog = rutaArchivoLog;
        this.wsSoapClientPersonasURL = wsSoapClientPersonasURL;
        this.wsSoapClientPersonasActionPersonaCompleto = wsSoapClientPersonasActionPersonaCompleto;
        this.wsSoapClientPersonasActionPersonaCIM = wsSoapClientPersonasActionPersonaCIM;
        this.wsSoapClientPersonasActionDirecciones = wsSoapClientPersonasActionDirecciones;
        this.wsSoapClientPersonasActionDiscapacidad = wsSoapClientPersonasActionDiscapacidad;
        this.wsMdmqWsPam = wsMdmqWsPam;
        this.wsMdmqWsPamObtenerPersonaExtension = wsMdmqWsPamObtenerPersonaExtension;
        this.wsreportesRemetfu = wsreportesRemetfu;
        this.wso2ApiFileServerURL = wso2ApiFileServerURL;
        this.wso2ApiFileServerNombreProyecto = wso2ApiFileServerNombreProyecto;
        this.wso2ApiFileServerDescripcionProyecto = wso2ApiFileServerDescripcionProyecto;
        this.mailFrom = mailFrom;
        this.mailTest = mailTest;
        this.mailTestTo = mailTestTo;
        this.wsDocumentalService = wsDocumentalService;
        this.wsServiceSAOpruebasInternas = wsServiceSAOpruebasInternas;
        this.wsServiceSAOdesarrollo = wsServiceSAOdesarrollo;
        this.wsServiceSAOordenesPago = wsServiceSAOordenesPago;
        this.wsDINARDAPinteroperabilidadCabecera = wsDINARDAPinteroperabilidadCabecera;
        this.wsDINARDAPinteroperabilidadAddress = wsDINARDAPinteroperabilidadAddress;
        this.wsDINARDAPinteroperabilidadUsername = wsDINARDAPinteroperabilidadUsername;
        this.wsDINARDAPinteroperabilidadPassword = wsDINARDAPinteroperabilidadPassword;
        this.usuarioCabeceraPersonas = usuarioCabeceraPersonas;
        this.claveCabeceraPersonas = claveCabeceraPersonas;
        this.valorDinardapConsulta = valorDinardapConsulta;
    }


  
    public String getWso2UsuarioToken() {
        return wso2UsuarioToken;
    }

    public void setWso2UsuarioToken(String wso2UsuarioToken) {
        this.wso2UsuarioToken = wso2UsuarioToken;
    }

    public String getWso2PasswordToken() {
        return wso2PasswordToken;
    }

    public void setWso2PasswordToken(String wso2PasswordToken) {
        this.wso2PasswordToken = wso2PasswordToken;
    }

    public String getWso2UsuarioConsumidor() {
        return wso2UsuarioConsumidor;
    }

    public void setWso2UsuarioConsumidor(String wso2UsuarioConsumidor) {
        this.wso2UsuarioConsumidor = wso2UsuarioConsumidor;
    }

    public String getWso2SecretoConsumidor() {
        return wso2SecretoConsumidor;
    }

    public void setWso2SecretoConsumidor(String wso2SecretoConsumidor) {
        this.wso2SecretoConsumidor = wso2SecretoConsumidor;
    }

    public String getWso2TokenURL() {
        return wso2TokenURL;
    }

    public void setWso2TokenURL(String wso2TokenURL) {
        this.wso2TokenURL = wso2TokenURL;
    }

    public String getWso2ApiMunicipalesURL() {
        return wso2ApiMunicipalesURL;
    }

    public void setWso2ApiMunicipalesURL(String wso2ApiMunicipalesURL) {
        this.wso2ApiMunicipalesURL = wso2ApiMunicipalesURL;
    }

    public String getWso2UsuariosKeyCloak() {
        return wso2UsuariosKeyCloak;
    }

    public void setWso2UsuariosKeyCloak(String wso2UsuariosKeyCloak) {
        this.wso2UsuariosKeyCloak = wso2UsuariosKeyCloak;
    }

    public String getKeycloakClientId() {
        return keycloakClientId;
    }

    public void setKeycloakClientId(String keycloakClientId) {
        this.keycloakClientId = keycloakClientId;
    }

    public String getRutaArchivoLog() {
        return rutaArchivoLog;
    }

    public void setRutaArchivoLog(String rutaArchivoLog) {
        this.rutaArchivoLog = rutaArchivoLog;
    }

    public String getWsSoapClientPersonasURL() {
        return wsSoapClientPersonasURL;
    }

    public void setWsSoapClientPersonasURL(String wsSoapClientPersonasURL) {
        this.wsSoapClientPersonasURL = wsSoapClientPersonasURL;
    }

    public String getWsSoapClientPersonasActionPersonaCompleto() {
        return wsSoapClientPersonasActionPersonaCompleto;
    }

    public void setWsSoapClientPersonasActionPersonaCompleto(String wsSoapClientPersonasActionPersonaCompleto) {
        this.wsSoapClientPersonasActionPersonaCompleto = wsSoapClientPersonasActionPersonaCompleto;
    }

    public String getWsSoapClientPersonasActionPersonaCIM() {
        return wsSoapClientPersonasActionPersonaCIM;
    }

    public void setWsSoapClientPersonasActionPersonaCIM(String wsSoapClientPersonasActionPersonaCIM) {
        this.wsSoapClientPersonasActionPersonaCIM = wsSoapClientPersonasActionPersonaCIM;
    }

    public String getWsSoapClientPersonasActionDirecciones() {
        return wsSoapClientPersonasActionDirecciones;
    }

    public void setWsSoapClientPersonasActionDirecciones(String wsSoapClientPersonasActionDirecciones) {
        this.wsSoapClientPersonasActionDirecciones = wsSoapClientPersonasActionDirecciones;
    }

    public String getWsSoapClientPersonasActionDiscapacidad() {
        return wsSoapClientPersonasActionDiscapacidad;
    }

    public void setWsSoapClientPersonasActionDiscapacidad(String wsSoapClientPersonasActionDiscapacidad) {
        this.wsSoapClientPersonasActionDiscapacidad = wsSoapClientPersonasActionDiscapacidad;
    }

    public String getWsMdmqWsPam() {
        return wsMdmqWsPam;
    }

    public void setWsMdmqWsPam(String wsMdmqWsPam) {
        this.wsMdmqWsPam = wsMdmqWsPam;
    }

    public String getWsreportesRemetfu() {
        return wsreportesRemetfu;
    }

    public void setWsreportesRemetfu(String wsreportesRemetfu) {
        this.wsreportesRemetfu = wsreportesRemetfu;
    }

    public String getWsMdmqWsPamObtenerPersonaExtension() {
        return wsMdmqWsPamObtenerPersonaExtension;
    }

    public void setWsMdmqWsPamObtenerPersonaExtension(String wsMdmqWsPamObtenerPersonaExtension) {
        this.wsMdmqWsPamObtenerPersonaExtension = wsMdmqWsPamObtenerPersonaExtension;
    }
    
    public String getWso2ApiFileServerURL() {
        return wso2ApiFileServerURL;
    }

    public void setWso2ApiFileServerURL(String wso2ApiFileServerURL) {
        this.wso2ApiFileServerURL = wso2ApiFileServerURL;
    }

    public String getWso2ApiFileServerNombreProyecto() {
        return wso2ApiFileServerNombreProyecto;
    }

    public void setWso2ApiFileServerNombreProyecto(String wso2ApiFileServerNombreProyecto) {
        this.wso2ApiFileServerNombreProyecto = wso2ApiFileServerNombreProyecto;
    }

    public String getWso2ApiFileServerDescripcionProyecto() {
        return wso2ApiFileServerDescripcionProyecto;
    }

    public void setWso2ApiFileServerDescripcionProyecto(String wso2ApiFileServerDescripcionProyecto) {
        this.wso2ApiFileServerDescripcionProyecto = wso2ApiFileServerDescripcionProyecto;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public Boolean getMailTest() {
        return mailTest;
    }

    public void setMailTest(Boolean mailTest) {
        this.mailTest = mailTest;
    }

    public String getMailTestTo() {
        return mailTestTo;
    }

    public void setMailTestTo(String mailTestTo) {
        this.mailTestTo = mailTestTo;
    }

    public String getWsDocumentalService() {
        return wsDocumentalService;
    }

    public void setWsDocumentalService(String wsDocumentalService) {
        this.wsDocumentalService = wsDocumentalService;
    }

    public String getWsServiceSAOpruebasInternas() {
        return wsServiceSAOpruebasInternas;
    }

    public void setWsServiceSAOpruebasInternas(String wsServiceSAOpruebasInternas) {
        this.wsServiceSAOpruebasInternas = wsServiceSAOpruebasInternas;
    }

    public String getWsServiceSAOdesarrollo() {
        return wsServiceSAOdesarrollo;
    }

    public void setWsServiceSAOdesarrollo(String wsServiceSAOdesarrollo) {
        this.wsServiceSAOdesarrollo = wsServiceSAOdesarrollo;
    }

    public String getWsServiceSAOordenesPago() {
        return wsServiceSAOordenesPago;
    }

    public void setWsServiceSAOordenesPago(String wsServiceSAOordenesPago) {
        this.wsServiceSAOordenesPago = wsServiceSAOordenesPago;
    }

    public String getUsuarioCabeceraPersonas() {
        return usuarioCabeceraPersonas;
    }

    public void setUsuarioCabeceraPersonas(String usuarioCabeceraPersonas) {
        this.usuarioCabeceraPersonas = usuarioCabeceraPersonas;
    }

    public String getClaveCabeceraPersonas() {
        return claveCabeceraPersonas;
    }

    public String getWsDINARDAPinteroperabilidadCabecera() {
        return wsDINARDAPinteroperabilidadCabecera;
    }

    public void setWsDINARDAPinteroperabilidadCabecera(String wsDINARDAPinteroperabilidadCabecera) {
        this.wsDINARDAPinteroperabilidadCabecera = wsDINARDAPinteroperabilidadCabecera;
    }        

    public String getWsDINARDAPinteroperabilidadAddress() {
        return wsDINARDAPinteroperabilidadAddress;
    }

    public void setWsDINARDAPinteroperabilidadAddress(String wsDINARDAPinteroperabilidadAddress) {
        this.wsDINARDAPinteroperabilidadAddress = wsDINARDAPinteroperabilidadAddress;
    }

    public String getWsDINARDAPinteroperabilidadUsername() {
        return wsDINARDAPinteroperabilidadUsername;
    }

    public void setWsDINARDAPinteroperabilidadUsername(String wsDINARDAPinteroperabilidadUsername) {
        this.wsDINARDAPinteroperabilidadUsername = wsDINARDAPinteroperabilidadUsername;
    }

    public String getWsDINARDAPinteroperabilidadPassword() {
        return wsDINARDAPinteroperabilidadPassword;
    }

    public void setWsDINARDAPinteroperabilidadPassword(String wsDINARDAPinteroperabilidadPassword) {
        this.wsDINARDAPinteroperabilidadPassword = wsDINARDAPinteroperabilidadPassword;
    }

    public void setClaveCabeceraPersonas(String claveCabeceraPersonas) {
        this.claveCabeceraPersonas = claveCabeceraPersonas;
    }

    public String getValorDinardapConsulta() {
        return valorDinardapConsulta;
    }

    public void setValorDinardapConsulta(String valorDinardapConsulta) {
        this.valorDinardapConsulta = valorDinardapConsulta;
    }

    
}
