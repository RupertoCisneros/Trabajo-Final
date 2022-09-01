/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import gob.mdmq.remetfu.config.ProjectProperties;
import gob.mdmq.remetfu.dto.DtoRol;
import gob.mdmq.remetfu.dto.DtoToken;
import gob.mdmq.remetfu.dto.DtoUsuarioPerfil;
import gob.mdmq.remetfu.dto.fileserver.DtoArchivo;
import gob.mdmq.remetfu.dto.fileserver.DtoSistema;
import gob.mdmq.remetfu.dto.fileserver.DtoSistemaRequest;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioWSO2 {

    @Autowired
    ProjectProperties propiedades;

    @Autowired
    private ServicioUsuarioPerfil servicioUsuarioPerfil;

    public RestTemplate getRestTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (x509Certificates, s) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

    public DtoToken getToken() {

        // parámetros para solicitar el token
        MultiValueMap<String, String> paramsMap1 = new LinkedMultiValueMap<String, String>();
        paramsMap1.add("grant_type", "password");
        paramsMap1.add("username", propiedades.getWso2UsuarioToken());
        paramsMap1.add("password", propiedades.getWso2PasswordToken());

        RestTemplate restTemplate = new RestTemplate();

        String urlStringToken = propiedades.getWso2TokenURL();

        // Auth Basic
        restTemplate.getInterceptors().add(
                new BasicAuthenticationInterceptor(propiedades.getWso2UsuarioConsumidor(),
                        propiedades.getWso2SecretoConsumidor()));

        DtoToken response = restTemplate.postForObject(
                urlStringToken, paramsMap1,
                DtoToken.class);

        return response;
    }

    public DtoRol[] getRoles(String clientId) {

        RestTemplate restTemplate = new RestTemplate();

        String urlStringRoles = propiedades.getWso2ApiMunicipalesURL()
                + "/list-roles?client_id=" + clientId;

        DtoToken token = getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<DtoRol[]> response = restTemplate.exchange(
                urlStringRoles, HttpMethod.GET, requestEntity, DtoRol[].class);

        return response.getBody();
    }

    public List<DtoUsuarioPerfil> obtenerUsuario(String usuario) throws org.springframework.boot.configurationprocessor.json.JSONException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        List<DtoUsuarioPerfil> listaUsuarios = new ArrayList<>();
        try {
            String urlStringRoles = propiedades.getWso2UsuariosKeyCloak()
                    + "?username=" + usuario;

            DtoToken token = getToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token.getAccess_token());
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            response = restTemplate.exchange(
                    urlStringRoles, HttpMethod.GET, requestEntity, String.class);

            String usuariosKeyCloack = response.getBody();
            JSONArray partsData = new JSONArray(usuariosKeyCloack);

            for (int i = 0; i < partsData.length(); i++) {
                DtoUsuarioPerfil dtoUsuarioPerfil = new DtoUsuarioPerfil();
                DtoUsuarioPerfil usuarioPerilNombre = new DtoUsuarioPerfil();
                JSONObject jsonObject = partsData.getJSONObject(i);
                JSONObject jsonObjects = partsData.getJSONObject(i).getJSONObject("attributes");
                var cedula = jsonObjects.get("cedula");

                usuarioPerilNombre = servicioUsuarioPerfil.obtenerPerfilesUsuario(jsonObject.getString("username"));
                //dtoUsuarioPerfil.setUsuarioId(usuarioPerilNombre == null ? "" : Long.parseLong(usuarioPerilNombre.getUsuarioId().toString()));
                dtoUsuarioPerfil.setNroIdentificacion(cedula == null ? "" : cedula.toString().substring(1, cedula.toString().length() - 1).replace("\"", ""));
//                dtoUsuarioPerfil.setNroIdentificacion(jsonObject.getString("cedula"));
                dtoUsuarioPerfil.setUsername(jsonObject.getString("username"));
                dtoUsuarioPerfil.setNombres(jsonObject.getString("firstName"));
                dtoUsuarioPerfil.setApellidos(jsonObject.getString("lastName"));
                dtoUsuarioPerfil.setEmail(jsonObject.getString("email"));
                dtoUsuarioPerfil.setSsoId(jsonObject.getString("id"));
                dtoUsuarioPerfil.setEstado(usuarioPerilNombre == null ? "" : usuarioPerilNombre.getEstado());
                dtoUsuarioPerfil.setNombrePerfil(usuarioPerilNombre == null ? "" : usuarioPerilNombre.getNombrePerfil());
                listaUsuarios.add(dtoUsuarioPerfil);

            }

            return listaUsuarios;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Integer asignarRoles(String sso_id, String client_id, List<DtoRol> roles) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = null;

        try {
            if (roles.size() != 0) {
                String urlAddRoles = propiedades.getWso2ApiMunicipalesURL()
                        + "/client/user/add-role-mapping?user_id=" + sso_id + "&client_id=" + client_id;
                DtoToken token = getToken();
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", "Bearer " + token.getAccess_token());
                HttpEntity<List<DtoRol>> requestEntity = new HttpEntity<List<DtoRol>>(roles, headers);

                response = restTemplate.exchange(
                        urlAddRoles, HttpMethod.POST, requestEntity, Object.class);

                return response.hashCode();
            } else {
                throw new Exception();
            }

        } catch (Exception e) {

            e.printStackTrace();
            return 0;
        }

    }

    public Integer quitarRoles(String sso_id, String client_id, List<DtoRol> roles) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        String urlAddRoles = propiedades.getWso2ApiMunicipalesURL()
                + "/client/user/del-role-mapping?user_id=" + sso_id + "&client_id=" + client_id;

        DtoToken token = getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<List<DtoRol>> requestEntity = new HttpEntity<List<DtoRol>>(roles, headers);

        ResponseEntity<Object> response = restTemplate.exchange(
                urlAddRoles, HttpMethod.DELETE, requestEntity, Object.class);

        return response.hashCode();
    }

//Servicios Importados desde sistema smsra
//  public DtoToken getToken() {
//
//    // parámetros para solicitar el token
//    MultiValueMap<String, String> paramsMap1 = new LinkedMultiValueMap<String, String>();
//    paramsMap1.add("grant_type", "password");
//    paramsMap1.add("username", propiedades.getWso2UsuarioToken());
//    paramsMap1.add("password", propiedades.getWso2PasswordToken());
//
//    RestTemplate restTemplate = new RestTemplate();
//
//    String urlStringToken = propiedades.getWso2TokenURL();
//
//    // Auth Basic
//    restTemplate.getInterceptors().add(
//        new BasicAuthenticationInterceptor(propiedades.getWso2UsuarioConsumidor(),
//            propiedades.getWso2SecretoConsumidor()));
//
//    DtoToken response = restTemplate.postForObject(
//        urlStringToken, paramsMap1,
//        DtoToken.class);
//
//    return response;
//  }
//
    public DtoSistema getSistema() throws NoSuchFieldException, SecurityException {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String nombreProyecto = propiedades.getWso2ApiFileServerNombreProyecto();

            String urlApiFileServer = propiedades.getWso2ApiFileServerURL()
                    + "/Sistema/ConsultarPorProyecto/" + nombreProyecto;

            DtoToken token = getToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token.getAccess_token());

            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<Object> response = restTemplate.exchange(
                    urlApiFileServer, HttpMethod.GET, requestEntity, Object.class);

            Object resp = response.getBody();

            DtoSistema sistemaDto = new DtoSistema();

            Map<String, Object> map = new HashMap<String, Object>();
            map = (Map<String, Object>) resp;
            sistemaDto.setId((Integer) map.get("Id"));
            sistemaDto.setNombre((String) map.get("Nombre"));
            sistemaDto.setNombreProyecto((String) map.get("NombreProyecto"));
            return sistemaDto;
        } catch (Exception e) {
            return null;
        }
    }

    public Object getArchivo(String archivoId) {

        RestTemplate restTemplate = new RestTemplate();

        String urlApiFileServer = propiedades.getWso2ApiFileServerURL()
                + "/Archivo/Recuperar/" + archivoId;

        DtoToken token = getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange(
                urlApiFileServer, HttpMethod.GET, requestEntity, Object.class);

        return response.getBody();
    }

    public Integer guardarSistema(DtoSistemaRequest sistema)
            throws JsonProcessingException, NoSuchFieldException, SecurityException {

        RestTemplate restTemplate = new RestTemplate();

        String urlApiFileServer = propiedades.getWso2ApiFileServerURL()
                + "/Sistema/Guardar/";

        DtoToken token = getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<DtoSistemaRequest> requestEntity = new HttpEntity<DtoSistemaRequest>(sistema, headers);

        ResponseEntity<Integer> response = restTemplate.exchange(urlApiFileServer, HttpMethod.POST, requestEntity,
                Integer.class);

        return response.getBody();
    }

    public String guardarArchivo(DtoArchivo archivo)
            throws JsonProcessingException, NoSuchFieldException, SecurityException {

        try {

            RestTemplate restTemplate = new RestTemplate();

            DtoSistema sistema = getSistema();

            Integer id = 0;

            if (sistema == null) {
                // Crear Sistema
                String apiFileServerNombreProyecto = propiedades.getWso2ApiFileServerNombreProyecto();
                String apiFileServerDescripcionProyecto = propiedades.getWso2ApiFileServerDescripcionProyecto();
                DtoSistemaRequest request = new DtoSistemaRequest(apiFileServerDescripcionProyecto, apiFileServerNombreProyecto,
                        archivo.getDatosAuditoria());

                guardarSistema(request);
                sistema = getSistema();
                id = sistema.getId();

            } else {
                id = sistema.getId();
            }

            String urlApiFileServer = propiedades.getWso2ApiFileServerURL()
                    + "/Archivo/Guardar/" + id;

            DtoToken token = getToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token.getAccess_token());

            HttpEntity<DtoArchivo> requestEntity = new HttpEntity<DtoArchivo>(archivo, headers);

            ResponseEntity<String> response = restTemplate.exchange(urlApiFileServer, HttpMethod.POST, requestEntity,
                    String.class);

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
