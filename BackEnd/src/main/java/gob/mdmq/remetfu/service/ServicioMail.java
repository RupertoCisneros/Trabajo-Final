/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.WebService.ConsultaWebServices;
import gob.mdmq.remetfu.config.ProjectProperties;
import gob.mdmq.remetfu.dto.DtoEstructuraMail;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;

/**
 *
 * @author omaldonado
 */
@Service
@EnableAsync
public class ServicioMail {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ConsultaWebServices consultaWebServices;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ServicioAnalisisTramiteRegistroProfesional analisisTramiteRegistroProfesional;

    @Autowired
    private ServicioSubtipoRegistro servicioSubtipoRegistro;

    @Autowired
    ProjectProperties propiedades;

    @Autowired
    private ServicioRegistroProfesional servicioRegistroProfesional;

    @Autowired
    private ServicioQR servicioQR;

    public boolean enviarMailAprobacion(Long registroProfesionalId, Long usuarioId, String ordenGenerada) {
        boolean respueta = false;
        MimeMessage message = mailSender.createMimeMessage();
        DtoEstructuraMail content = new DtoEstructuraMail();
        String s = "";
        try {

            var ciudadano = usuariosRepository.findById(usuarioId);
            var tramiteCiudadano = analisisTramiteRegistroProfesional.obtenerRegistroMail(ciudadano.get().getNroIdentificacion().trim(), usuarioId, registroProfesionalId);
            Optional<RemRegistroProfesional> registroTramite = servicioRegistroProfesional.obtenerById(registroProfesionalId);

            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(ciudadano.get().getMailPersonal());
            helper.setFrom(propiedades.getMailFrom());
            helper.setSubject("Aprobación Trámite REMETFU");
            helper.setText("Estimado usuario la solicitud con número de registro " + tramiteCiudadano.iterator().next().getNroRegistro() + " ha sido aprobado,"
                    + "por favor acerquese a cancelar el tramite con la orden de pago N° " + ordenGenerada, true);
            mailSender.send(message);
            respueta = true;

        } catch (Exception e) {
            respueta = false;
            e.printStackTrace();
        }
        return respueta;
    }

    public boolean enviarMailNegacion(Long registroProfesionalId, Long usuarioId) {
        boolean respueta = false;
        MimeMessage message = mailSender.createMimeMessage();
        DtoEstructuraMail content = new DtoEstructuraMail();
        String s = "";
        try {

            var ciudadano = usuariosRepository.findById(usuarioId);
            var tramiteCiudadano = analisisTramiteRegistroProfesional.obtenerRegistroMail(ciudadano.get().getNroIdentificacion().trim(), usuarioId, registroProfesionalId);
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(ciudadano.get().getMailPersonal());
            helper.setFrom(propiedades.getMailFrom());
            helper.setSubject("Negación Trámite REMETFU");
            helper.setText("Estimado usuario la solicitud con número de registro " + tramiteCiudadano.iterator().next().getNroRegistro() + " ha sido negada,"
                    + "por favor valide todos sus datos", true);
            mailSender.send(message);
            respueta = true;

        } catch (Exception e) {
            respueta = false;
            e.printStackTrace();
        }
        return respueta;
    }

    public boolean enviarMailDevolucion(Long registroProfesionalId, Long usuarioId) {
        boolean respueta = false;
        MimeMessage message = mailSender.createMimeMessage();
        DtoEstructuraMail content = new DtoEstructuraMail();
        String s = "";
        try {

            var ciudadano = usuariosRepository.findById(usuarioId);
            var tramiteCiudadano = analisisTramiteRegistroProfesional.obtenerRegistroMail(ciudadano.get().getNroIdentificacion().trim(), usuarioId, registroProfesionalId);
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(ciudadano.get().getMailPersonal());
            helper.setFrom(propiedades.getMailFrom());
            helper.setSubject("Devolución Trámite REMETFU");
            helper.setText("Estimado usuario la solicitud con número de registro " + tramiteCiudadano.iterator().next().getNroRegistro() + " ha sido devuelta,"
                    + "por favor valide todos sus datos", true);
            mailSender.send(message);
            respueta = true;

        } catch (Exception e) {
            respueta = false;
            e.printStackTrace();
        }
        return respueta;
    }

    public boolean enviarNotificaciones(String subject, String cuerpoMail, long usuarioId,long subTipoRegistroId,long registroId,boolean generarPdf) {
        boolean respueta = false;
        MimeMessage message = mailSender.createMimeMessage();
        DtoEstructuraMail content = new DtoEstructuraMail();
        try {
            var ciudadano = usuariosRepository.findById(usuarioId);
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());

            
            helper.setTo(ciudadano.get().getMailPersonal());
            helper.setFrom(propiedades.getMailFrom());
            helper.setSubject(subject);
            helper.setText(cuerpoMail , true);
            if (generarPdf) {
                content = consultaWebServices.generarReporte(subTipoRegistroId, registroId);  
                helper.addAttachment(content.getNombreArchivo(), new ByteArrayResource(content.getContenidoMail()));
            }
           
            mailSender.send(message);
            respueta = true;

        } catch (Exception e) {
            respueta = false;
            e.printStackTrace();
        }
        return respueta;
    }
    
}
