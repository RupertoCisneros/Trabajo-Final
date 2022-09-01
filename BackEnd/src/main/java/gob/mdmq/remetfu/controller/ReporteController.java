/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.WebService.ConsultaWebServices;
import gob.mdmq.remetfu.service.ServicioQR;
import gob.mdmq.remetfu.utilitarios.ClsUtilitario;
import java.io.FileNotFoundException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 *
 * @author srcisnerosv
 */
@RestController
@RequestMapping("/api/reporte")
public class ReporteController {

    @Autowired
    private ClsUtilitario clsUtilitario;

    @Autowired
    private ConsultaWebServices consultaWebServices;

    @Autowired
    private ServicioQR servicioQR;

    @GetMapping(value = "/consultaMenu/{tipoRegistro}/{idUsuario}", produces = "application/pdf")
    public ResponseEntity< Resource> get(@PathVariable("tipoRegistro") long subTipoRegistro,
            @PathVariable("idUsuario") long registroProfesionalId) throws FileNotFoundException {

        ContentDisposition contentDisposition = null;
        try {
            byte[] content = servicioQR.estamparCodigoQr(null);

            StringBuilder stringBuilder = new StringBuilder().append("PruebaPdf:");
            contentDisposition = ContentDisposition.builder("attachment")
                    .filename(stringBuilder.append(0).append(".pdf").toString()).build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);

            return ResponseEntity.ok().contentLength((long) content.length).contentType(MediaType.APPLICATION_PDF).headers(headers)
                    .body(new ByteArrayResource(content));
        } catch (Exception e) {
            return null;

        }

    }

    @GetMapping(value = "/generarCodigo", produces = "application/pdf")
    public ResponseEntity< Resource> generarCodigo() throws FileNotFoundException {

        ContentDisposition contentDisposition = null;
        try {
            byte[] content =servicioQR.estamparCodigoQr(null);

            StringBuilder stringBuilder = new StringBuilder().append("PruebaPdf:");
            contentDisposition = ContentDisposition.builder("attachment")
                    .filename(stringBuilder.append(0).append(".pdf").toString()).build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);

            return ResponseEntity.ok().contentLength((long) content.length).contentType(MediaType.APPLICATION_PDF).headers(headers)
                    .body(new ByteArrayResource(content));
        } catch (Exception e) {
            return null;

        }

    }

}
