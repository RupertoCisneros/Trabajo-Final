/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.WebService;

import gob.mdmq.remetfu.dto.DtoRegistroEspecialista;
import gob.mdmq.remetfu.service.ServicioRegistroProfesional;
import java.io.IOException;
import java.io.StringReader;

import java.util.Arrays;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.MediaType;

import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gob.mdmq.remetfu.config.ProjectProperties;
import gob.mdmq.remetfu.dto.DtoAnimalTutor;
import gob.mdmq.remetfu.dto.DtoConsultaComite;
import gob.mdmq.remetfu.dto.DtoEstructuraMail;
import gob.mdmq.remetfu.service.ServicioAnimalTutor;
import gob.mdmq.remetfu.service.ServicioComiteEticaCab;
import gob.mdmq.remetfu.utilitarios.ClsUtilitario;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author omaldonado
 */
@Component
public class ConsultaWebServices {

    private Document xmlDocument;

    @Autowired
    ProjectProperties propiedades;    

    @Autowired
    private ServicioRegistroProfesional servicioRegistroProfesional;
   @Autowired
    private ServicioAnimalTutor servicioAnimalTutor;
   @Autowired
    private ServicioComiteEticaCab servicioComiteEticaCab;
   
    @Autowired
    private ClsUtilitario clsUtilitario;

    public Document obtenerPersona(String identificacion, char tipoIdentificacion) throws ParserConfigurationException {
        Document document = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String urlString = propiedades.getWsSoapClientPersonasURL();

            var body = String.format(clsUtilitario.cabeceraPersonasGenerica()
                    + clsUtilitario.bodyPersonas(identificacion, tipoIdentificacion));

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            headers.add("Content-type", "text/xml;charset=utf-8");
            headers.add("SOAPAction", propiedades.getWsSoapClientPersonasActionPersonaCompleto() );

            HttpEntity<String> response = restTemplate.exchange(
                    urlString,
                    HttpMethod.POST,
                    new HttpEntity<Object>(body, headers),
                    String.class);

            var rawXmlResponse = response.getBody();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = stringAXml(rawXmlResponse);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {

            return null;
        }

    }

    public Document obtenerPersonaCim(String identificacion) {
        Document document = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String urlString = propiedades.getWsSoapClientPersonasURL() ;

            var body = String.format(clsUtilitario.cabeceraPersonasGenerica()
                    + clsUtilitario.bodyPersonasCim(identificacion));

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            headers.add("Content-type", "text/xml;charset=utf-8");
            headers.add("SOAPAction",propiedades.getWsSoapClientPersonasActionPersonaCIM() );

            HttpEntity<String> response = restTemplate.exchange(
                    urlString,
                    HttpMethod.POST,
                    new HttpEntity<Object>(body, headers),
                    String.class);

            var rawXmlResponse = response.getBody();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = stringAXml(rawXmlResponse);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {

            return null;
        }

    }

    public Document obtenerDireccionPersona(String cim) {

        Document document = null;
        try {

            RestTemplate restTemplate = new RestTemplate();
            String urlString = propiedades.getWsSoapClientPersonasURL();

            var body = String.format(clsUtilitario.cabeceraPersonasGenerica()
                    + clsUtilitario.bodyDireccionPersona(cim));

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            headers.add("Content-type", "text/xml;charset=utf-8");
            headers.add("SOAPAction", propiedades.getWsSoapClientPersonasActionDirecciones());

            HttpEntity<String> response = restTemplate.exchange(
                    urlString,
                    HttpMethod.POST,
                    new HttpEntity<Object>(body, headers),
                    String.class);

            var rawXmlResponse = response.getBody();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = stringAXml(rawXmlResponse);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {

            return null;
        }

    }


    public Document obtenerPersonaDiscapacidad(String identificacion, char tipoIdentificacion) throws ParserConfigurationException {

        Document document = null;
        try {

            RestTemplate restTemplate = new RestTemplate();
            String urlString = propiedades.getWsSoapClientPersonasURL();

            var body = String.format(clsUtilitario.cabeceraPersonasGenerica()
                    + clsUtilitario.bodyPersonasDiscapcidad(identificacion, tipoIdentificacion));

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            headers.add("Content-type", "text/xml;charset=utf-8");
            headers.add("SOAPAction", propiedades.getWsSoapClientPersonasActionDiscapacidad());

            HttpEntity<String> response = restTemplate.exchange(
                    urlString,
                    HttpMethod.POST,
                    new HttpEntity<Object>(body, headers),
                    String.class);

            var rawXmlResponse = response.getBody();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = stringAXml(rawXmlResponse);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {

            return null;
        }

    }


    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }

        public DtoEstructuraMail generarReporte(long subTipoRegistro, long registroId) {
        DtoEstructuraMail respuesta = new DtoEstructuraMail();
        int subtipoRegistroId =(int) subTipoRegistro;
        try {
            switch (subtipoRegistroId) {
                case 2:
                     respuesta = reporteVeterinario(subTipoRegistro, registroId);
                    break;
                case 11:
                   respuesta = reporteEspecialista(subTipoRegistro, registroId);
                    break;
                case 26:
                   respuesta = reporteAnimalTutor(subTipoRegistro, registroId);
                    break;
                case 4:
                   respuesta = reporteComiteEtica(subTipoRegistro, registroId);
                break;
                default:
                    break;
            }
        } catch (Exception ex) {
            return null;
        }
        return respuesta;
    }
       

    public DtoEstructuraMail reporteEspecialista(long subTipoRegistro, long registroProfesionalId) {
        DtoEstructuraMail reporte = new DtoEstructuraMail();
        DtoRegistroEspecialista dtoRegistroEspecialista = new DtoRegistroEspecialista();

        try {
            dtoRegistroEspecialista = servicioRegistroProfesional.obtenerDatosRegistroEspecialistas(registroProfesionalId);

            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String jsonEspecialista = prettyGson.toJson(dtoRegistroEspecialista);

            reporte = generarPdf(subTipoRegistro, registroProfesionalId, jsonEspecialista);
            reporte.setMail(dtoRegistroEspecialista.getMail());
            
        } catch (NumberFormatException | ParseException e) {
            e.printStackTrace();
            return null;
        }
        return reporte;
    }

    public Document stringAXml(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.xmlDocument = builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
        return xmlDocument;
    }

    private DtoEstructuraMail reporteVeterinario(long subTipoRegistro, long registroProfesionalId) {
        DtoEstructuraMail reporte = new DtoEstructuraMail();
        DtoRegistroEspecialista dtoRegistroEspecialista = new DtoRegistroEspecialista();
        try {
            dtoRegistroEspecialista = servicioRegistroProfesional.obtenerDatosRegistroEspecialistas(registroProfesionalId);
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String jsonVeterinario = prettyGson.toJson(dtoRegistroEspecialista);
            reporte = generarPdf(subTipoRegistro, registroProfesionalId, jsonVeterinario);
            reporte.setMail(dtoRegistroEspecialista.getMail());
        } catch (NumberFormatException | ParseException e) {
            return null;
        }
        return reporte;
    }
    public DtoEstructuraMail reporteAnimalTutor(long subTipoRegistro, long animalTutorId) {
        DtoEstructuraMail reporte = new DtoEstructuraMail();
        DtoAnimalTutor dtoAnimalTutor = new DtoAnimalTutor();
        try {
            dtoAnimalTutor = servicioAnimalTutor.obtenerDatosAnimalTutor(animalTutorId);
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String jsonAnimalTutor = prettyGson.toJson(dtoAnimalTutor);
            reporte = generarPdf(subTipoRegistro, animalTutorId, jsonAnimalTutor);
        } catch(NumberFormatException e){
        }
        return reporte;
    }
    public DtoEstructuraMail reporteComiteEtica(long subTipoRegistro, long comiteEticaCabId) {
        DtoEstructuraMail reporte = new DtoEstructuraMail();
        List<DtoConsultaComite> dtoConsultaComite = null;
        try {
            dtoConsultaComite = servicioComiteEticaCab.consultaDatosComiteEtica(comiteEticaCabId);
            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String jsonComiteEtica = prettyGson.toJson(dtoConsultaComite);
            reporte = generarPdf(subTipoRegistro, comiteEticaCabId, jsonComiteEtica);
        } catch(NumberFormatException e){
        }
        return reporte;
    }

    public DtoEstructuraMail generarPdf(long tipoReporte, long registroProfesionalId, String dtoReporte) {
        DtoEstructuraMail reporte = new DtoEstructuraMail();
        try {
            RestTemplate restTemplate = new RestTemplate();
            String urlString = String.format(propiedades.getWsreportesRemetfu()+"/exportarRegistros"+"/%1$s", tipoReporte);
            ResponseEntity<Resource> result = restTemplate.postForEntity(urlString, dtoReporte, Resource.class);
           reporte.setContenidoMail(result.getBody().getInputStream().readAllBytes()); 
           reporte.setNombreArchivo( result.getBody().getFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporte;
    }
    
    public Document obtenerPersonaPAM(String token){
        Document document = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            String urlString = propiedades.getWsMdmqWsPam();
            var body = String.format(clsUtilitario.PersonasPAM(token));
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
            headers.add("Content-type", "text/xml;charset=utf-8");
            headers.add("SOAPAction", propiedades.getWsMdmqWsPamObtenerPersonaExtension());
            HttpEntity<String> response = restTemplate.exchange(
                    urlString,
                    HttpMethod.POST,
                    new HttpEntity<Object>(body, headers),
                    String.class);
            var rawXmlResponse = response.getBody();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = stringAXml(rawXmlResponse);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            return null;
        }
    }

}
