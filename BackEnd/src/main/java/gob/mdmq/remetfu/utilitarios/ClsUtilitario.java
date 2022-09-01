/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.utilitarios;

import gob.mdmq.remetfu.config.ProjectProperties;
import gob.mdmq.remetfu.repository.AnalisisTramiteRegistroProfesionalRepository;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClsUtilitario {

    @Autowired
    private AnalisisTramiteRegistroProfesionalRepository analisisTramiteRegistroProfesionalRepository;

    @Autowired
    ProjectProperties propiedades;        
    
    public static String getDireccionIP() throws UnknownHostException {
        String direccionIP = "";
        try {
            direccionIP = InetAddress.getLocalHost().getHostAddress();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return direccionIP;
    }


    public Date getProximoDiaHabil(Date fechaAnalisis, int parametro) {

        try {
            Date fecha = new Date();
            Calendar diaSemana = Calendar.getInstance();
            diaSemana.setTime(fechaAnalisis);
            String resp = "";
            resp = "0";
            var dias = 0;
            while (dias < parametro) {
                resp = analisisTramiteRegistroProfesionalRepository.verificaFechaFeriado(diaSemana.getTime());

                if ((diaSemana.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && diaSemana.get(Calendar.DAY_OF_WEEK)
                        != Calendar.SUNDAY) && !resp.equals("1")) {
                    dias++;
                }

                diaSemana.add(Calendar.DATE, 1);

            }
            diaSemana.add(Calendar.DATE, -1);
            fechaAnalisis = diaSemana.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fechaAnalisis;

    }

    public String cabeceraPersonasGenerica() {

        String cabecera = String.format("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:mdmq=\"http://mdmq.quito.gob.ec/\">\n"
                + "<soap:Header>\n"
                + "<mdmq:Cabecera>\n"
                + "<!--Optional:-->\n"
                + "<mdmq:UserName>" + propiedades.getUsuarioCabeceraPersonas() + "</mdmq:UserName>\n" //30 en pruebas
                + "<!--Optional:-->\n"
                + "<mdmq:Password>" + propiedades.getClaveCabeceraPersonas() + "</mdmq:Password>\n" //123456 en pruebas
                + "</mdmq:Cabecera>\n"
                + "</soap:Header>\n");

        return cabecera;
    }

    public String bodyPersonas(String identificacion, char tipoIdentificacion) {

        String body = String.format("<soap:Body >\n"
                + "      <mdmq:fn_consulta_buscarPersonaCompleto>\n"
                + "         <!--Optional:-->\n"
                + "         <mdmq:strIdentificacion>%1$s</mdmq:strIdentificacion>\n"
                + "         <!--Optional:-->\n"
                + "         <mdmq:strTipoIdentificacion>%2$s</mdmq:strTipoIdentificacion>\n"
                + "         <mdmq:strAccion></mdmq:strAccion>\n"
                + "      </mdmq:fn_consulta_buscarPersonaCompleto>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>", identificacion, tipoIdentificacion);

        return body;
    }

    public String bodyPersonasDiscapcidad(String identificacion, char tipoIdentificacion) {

        String body = String.format("<soap:Body >\n"
                + "      <mdmq:fn_consulta_buscarPersonaCompletoDiscapacidad>\n"
                + "         <!--Optional:-->\n"
                + "         <mdmq:strIdentificacion>%1$s</mdmq:strIdentificacion>\n"
                + "         <!--Optional:-->\n"
                + "         <mdmq:strTipoIdentificacion>%2$s</mdmq:strTipoIdentificacion>\n"
                + "         <mdmq:strAccion></mdmq:strAccion>\n"
                + "      </mdmq:fn_consulta_buscarPersonaCompletoDiscapacidad>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>", identificacion, tipoIdentificacion);

        return body;
    }

    public String bodyPersonasCim(String identificacion) {

        String body = String.format("<soap:Body>\n"
                + "      <mdmq:fn_consulta_buscarPersona_CIM>\n"
                + "         <mdmq:intPersonaID>%1$s</mdmq:intPersonaID>\n"
                + "      </mdmq:fn_consulta_buscarPersona_CIM>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>", identificacion);

        return body;
    }

    public String bodyDireccionPersona(String cim) {

        String body = String.format(" <soap:Body>\n"
                + "      <mdmq:fn_consulta_telefonos_direcciones>\n"
                + "         <mdmq:intPersonaID>%1$s</mdmq:intPersonaID>\n"
                + "      </mdmq:fn_consulta_telefonos_direcciones>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>", cim);

        return body;
    }

    public String bodyDinardap(String identificacion) {

//        String body = String.format("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:int=\"http://interoperabilidad.dinardap.gob.ec/interoperador/\">\n"
        String body = String.format("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:int=\"http://interoperabilidad.dinardap.gob.ec/interoperador/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <int:consultar>\n"
                + "         <!--Optional:-->\n"
                + "         <parametros>\n"
                + "            <!--Zero or more repetitions:-->\n"
                + "            <parametro>\n"
                + "               <!--Optional:-->\n"
                + "               <nombre>codigoPaquete</nombre>\n"
                + "               <valor>" + propiedades.getValorDinardapConsulta() + "</valor>\n" //4262 en pruebas
                + "               <!--Optional:-->\n"
                + "            </parametro>\n"
                + "              <parametro>\n"
                + "               <!--Optional:-->\n"
                + "               <nombre>identificacion</nombre>\n"
                + "               <valor>%1$s</valor>\n"
                + "               <!--Optional:-->\n"
                + "            </parametro>\n"
                + "         </parametros>\n"
                + "      </int:consultar>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>", identificacion);

        return body;

    }

    public String PersonasPAM(String token) {

        String cabecera = String.format("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <tem:ObtenerPersonaExtension>\n"
                + "         <!--Optional:-->\n"
                + "         <tem:sessionId>%1$s</tem:sessionId>\n"
                + "      </tem:ObtenerPersonaExtension>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>", token);

        return cabecera;
    }

}
