/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoRegistroProfesional;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioCatalogo;
import gob.mdmq.remetfu.service.ServicioMail;
import gob.mdmq.remetfu.service.ServicioRegistroProfesional;
import gob.mdmq.remetfu.service.ServicioSubtipoRegistro;
import gob.mdmq.remetfu.service.ServicioUsuarios;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RegistroProfesionalRestController {

    @Autowired
    private ServicioRegistroProfesional servicioRegistroProfesional;
    @Autowired
    private ServicioCatalogo servicioCatalogo;
    @Autowired
    private ServicioUsuarios servicioUsuarios;
    @Autowired
    private ServicioSubtipoRegistro servicioSubtipoRegistro;
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private ServicioMail servicioMail;

    @GetMapping("/obtenerProfesional")
    public ResponseEntity<List<RemRegistroProfesional>> obtenerProfesional() {
        try {
            return ResponseEntity.ok(servicioRegistroProfesional.obtener());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/obtenerRegistroProfesional/{codigoRegistro}")
    public Object obtenerRegistroProfesional(@PathVariable Long codigoRegistro) {
        try {

            return ResponseEntity.ok(servicioRegistroProfesional.obtenerDatosRegistroEspecialistas(codigoRegistro));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/validarIngreso/{nroIdentificacion}/{subtipoRegistro}")
    public Object validarIngreso(@PathVariable String nroIdentificacion,
            @PathVariable Long subtipoRegistro
    ) {
        try {
            return ResponseEntity.ok(servicioRegistroProfesional.validarIngreso(nroIdentificacion, subtipoRegistro));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/validarIngresoPagado/{nroIdentificacion}")
    public Object validarIngresoPagado(@PathVariable String nroIdentificacion) {
        try {
            return ResponseEntity.ok(servicioRegistroProfesional.validarIngresoPagado(nroIdentificacion));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @PostMapping("/crearProfesional/{idUsuario}/{idParroquia}/{idSubTipoRegistro}/{proceso}")
    public ResponseEntity<?> crearProfesional(@PathVariable(value = "idUsuario") Long idUsuario,
            @PathVariable(value = "idParroquia") Long idParroquia,
            @PathVariable(value = "idSubTipoRegistro") Long idSubTipoRegistro,
            @PathVariable(value = "proceso") Long proceso,
            @RequestBody DtoRegistroProfesional dtoRegistroProfesional) {

        try {

            Optional<RemUsuarios> profesional = servicioUsuarios.obtenerById(idUsuario);
            Optional<RemCatalogo> parroquiaCatalogo = servicioCatalogo.obtenerById(idParroquia);
            Optional<RemSubtipoRegistro> subtipoRegistro = servicioSubtipoRegistro.obtenerById(idSubTipoRegistro);
            Optional<RemCatalogo> estado = null;
            estado = servicioCatalogo.obtenerById(Long.parseLong("223"));

            if (proceso.equals("1")) {  //Validación para actualizar
                estado = servicioCatalogo.obtenerById(dtoRegistroProfesional.getEstadoRegistro());
            }

            dtoRegistroProfesional.setParroquia(parroquiaCatalogo.get());
            dtoRegistroProfesional.setSubtipoRegistroId(subtipoRegistro.get());
            dtoRegistroProfesional.setUsuarioId(profesional.get());
            dtoRegistroProfesional.setEstado(estado.get());

            var tramiteCreado = servicioRegistroProfesional.guardarProfesional(dtoRegistroProfesional, proceso);
            var obtenerCreado = servicioRegistroProfesional.obtenerDatosRegistroEspecialistas(tramiteCreado.getRegistroProfesionalId());
            var mensaje = servicioRegistroProfesional.mensajePreRegistro(obtenerCreado);
            if (tramiteCreado != null) {
                // CompletableFuture<?> envioMailAsync = servicioMail.enviarMail(tramiteCreado.getRegistroProfesionalId(), tramiteCreado.getSubtipoRegistroId().getSubtipoRegistroId());
                taskExecutor.execute(new Runnable() {
                    public void run() {
                        try {
                            var cuerpo = "Estimado usuario su solicitud se generó correctamente";
                            Optional<RemSubtipoRegistro> subtipoRegistro = servicioSubtipoRegistro.obtenerById(tramiteCreado.getSubtipoRegistroId().getSubtipoRegistroId());
                            servicioMail.enviarNotificaciones(
                                    subtipoRegistro.get().getDescripcion(),
                                    cuerpo,
                                    tramiteCreado.getUsuarioId().getUsuarioId(),
                                    tramiteCreado.getSubtipoRegistroId().getSubtipoRegistroId(),
                                    tramiteCreado.getRegistroProfesionalId(),
                                    true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), mensaje), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/obtenerArchivoRegistroProfesional/{registroProfesionalId}")
    ResponseEntity<Resource> obtenerArchivoRegistroProfesional(@PathVariable(value = "registroProfesionalId") Long registroProfesionalId) {
        ContentDisposition contentDisposition = null;

        try {

            byte[] content = servicioRegistroProfesional.obtenerArchivoRegistroProfesional(registroProfesionalId);

            if (content != null) {
                StringBuilder stringBuilder = new StringBuilder().append("RegistroArchivo");
                contentDisposition = ContentDisposition.builder("attachment")
                        .filename(stringBuilder.append(0).append(".pdf").toString()).build();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentDisposition(contentDisposition);

                return ResponseEntity.ok().contentLength((long) content.length).contentType(MediaType.APPLICATION_PDF).headers(headers)
                        .body(new ByteArrayResource(content));
            }else{
                return null;
            }

        } catch (Exception e) {
            return null;
        }

    }

}
