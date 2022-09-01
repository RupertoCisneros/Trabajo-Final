/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemAnalista;
import gob.mdmq.remetfu.Entidades.RemPerfil;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoAsignacionAnalista;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioAnalista;
import gob.mdmq.remetfu.service.ServicioMail;
import gob.mdmq.remetfu.service.ServicioPerfiles;
import gob.mdmq.remetfu.service.ServicioSAO;
import gob.mdmq.remetfu.service.ServicioUsuarios;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
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
public class AnalistaRestController {

    @Autowired
    private ServicioAnalista servicioAnalista;
    @Autowired
    private ServicioUsuarios servicioUsuarios;
    @Autowired
    private ServicioPerfiles servicioPerfil;
    @Autowired
    private ClsLog logArchivos;
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private ServicioMail servicioMail;

    @Autowired
    private ServicioSAO servicioSAO;

    @GetMapping("/consultarAnalistasTodos")
    public ResponseEntity<List<DtoAsignacionAnalista>> consultarAnalistasTodos() {
        try {

            return ResponseEntity.ok(servicioAnalista.getListaAnalistasActivos());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);
        }

    }

    @GetMapping("/consultarRegistrosAnalistas")
    public ResponseEntity<List<DtoAsignacionAnalista>> obtenerRegistrosAnalistas() {
        try {
            return ResponseEntity.ok(servicioAnalista.obtenerRegistrosAnalistas());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);
        }

    }

    @GetMapping("/obtenerAnalistaById/{id}")
    public Object obtenerAnalistaById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(servicioAnalista.obtenerById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);
        }

    }

    @PostMapping("/crearAnalista/{perfilId}/{usuarioId}")
    public ResponseEntity<?> crearAnalista(
            @PathVariable(value = "perfilId") Long perfilId,
            @PathVariable(value = "usuarioId") Long usuarioId,
            @RequestBody RemAnalista remAnalista) {
        try {

            Optional<RemUsuarios> codigoUsuario = servicioUsuarios.obtenerById(usuarioId);
            RemPerfil codigoPerfil = servicioPerfil.obtenerPerfilById(perfilId);

            remAnalista.setPerfilId(codigoPerfil);
            remAnalista.setUsuarioId(codigoUsuario.get());

            if (servicioAnalista.guardarActualizarAnalistas(remAnalista)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/aprobarTramite/{registroProfesionalId}/{novedad}/{idSubtipoRegistro}/{idUsuario}/{usuarioCreacion}/{terminalCreacion}")
    public ResponseEntity<?> aprobarTramite(@PathVariable(value = "registroProfesionalId") Long registroProfesionalId,
            @PathVariable(value = "novedad") String novedad,
            @PathVariable(value = "idSubtipoRegistro") Long idSubtipoRegistro,
            @PathVariable(value = "idUsuario")Long idUsuario, //idUsuario usuario dueño de registro
            @PathVariable(value = "usuarioCreacion")String usuarioCreacion,
            @PathVariable(value = "terminalCreacion")String terminalCreacion )
    {
        try {

            var ordenGenerada= servicioAnalista.aprobarTramite(registroProfesionalId, novedad, idSubtipoRegistro, idUsuario, usuarioCreacion, terminalCreacion);
            if (!ordenGenerada.equals("")) {
                taskExecutor.execute(new Runnable() {
                    public void run() {
                        try {
                            servicioMail.enviarMailAprobacion(registroProfesionalId, idUsuario,ordenGenerada);
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                });
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Trámite aprobado Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            //Logs
            logArchivos.RegistrarError("AnalistaRestController", e.getMessage(), "aprobarTramite");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/rechazarTramite/{registroProfesionalId}/{motivo}/{idUsuario}/{usuarioCreacion}/{terminalCreacion}")
    public ResponseEntity<?> rechazarTramite(@PathVariable(value = "registroProfesionalId") Long registroProfesionalId,
            @PathVariable(value = "motivo") String motivo,
            @PathVariable(value = "idUsuario") Long idUsuario,
            @PathVariable(value = "usuarioCreacion")String usuarioCreacion,
            @PathVariable(value = "terminalCreacion")String terminalCreacion) {
        try {

            if (servicioAnalista.rechazarTramite(registroProfesionalId, motivo,usuarioCreacion,terminalCreacion)) {
                taskExecutor.execute(new Runnable() {
                    public void run() {
                        try {
                            servicioMail.enviarMailNegacion(registroProfesionalId, idUsuario);
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                });
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Trámite rechazado Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            //Logs
            logArchivos.RegistrarError("AnalistaRestController", e.getMessage(), "rechazarTramite");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/devolverTramite/{registroProfesionalId}/{motivo}/{idUsuario}/{usuarioCreacion}/{terminalCreacion}")
    public ResponseEntity<?> devolverTramite(
            @PathVariable(value = "registroProfesionalId") Long registroProfesionalId,
            @PathVariable(value = "motivo") String motivo,
            @PathVariable(value = "idUsuario") Long idUsuario,
            @PathVariable(value = "usuarioCreacion")String usuarioCreacion,
            @PathVariable(value = "terminalCreacion")String terminalCreacion) {
        try {

            if (servicioAnalista.devolverTramite(registroProfesionalId, motivo,usuarioCreacion, terminalCreacion)) {
                taskExecutor.execute(new Runnable() {
                    public void run() {
                        try {
                            servicioMail.enviarMailDevolucion(registroProfesionalId, idUsuario);
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                });
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Trámite devuleto Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            //Logs
            logArchivos.RegistrarError("AnalistaRestController", e.getMessage(), "devolverTramite");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}
