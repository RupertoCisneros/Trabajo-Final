/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemTutorMascota;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioUsuarios;
import gob.mdmq.remetfu.service.ServicioTutorMascota;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import java.util.Date;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author oportero
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TutorMascotaRestController {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @Autowired
    private ServicioTutorMascota servicioTutorMascota;

    @Autowired
    private ClsLog logArchivos;

    @PostMapping("/crearTutorMascota/{idUsuario}/{direccion}/{ipUsuario}/{usuarioConectado}")
    public ResponseEntity<?> crearTutorMascota(
            @PathVariable(value = "idUsuario") Long idUsuario,
            @PathVariable(value = "direccion") String direccion,
            @PathVariable(value = "ipUsuario") String ipUsuario,
            @PathVariable(value = "usuarioConectado") String usuarioConectado,
            @Valid @RequestBody RemTutorMascota tutorMascota) {

        try {

            Optional<RemUsuarios> usuario = servicioUsuarios.obtenerById(idUsuario);

//          Se consultan los datos de los fk relacionados
            tutorMascota.setUsuarioId(usuario.get());
            tutorMascota.setDireccion(direccion);
            tutorMascota.setEstado("ACT");
            Date fecha = new Date();
            tutorMascota.setFechaCreacion(fecha);
            tutorMascota.setTerminalCreacion(ipUsuario);
            tutorMascota.setUsuarioCreacion(usuarioConectado);
            tutorMascota.setFechaModificacion(fecha);
            tutorMascota.setTerminalModificacion(ipUsuario);
            tutorMascota.setUsuarioModificacion(usuarioConectado);
            String pantalla = "";
            pantalla = this.getClass().getName();
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Insertar datos de Tutor");
            if (servicioTutorMascota.crearActualizarTutorMascota(tutorMascota)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/datosTutorMascota/{identificacion}")
    public ResponseEntity<Object> obtenerDatosTutorMascota(@PathVariable("identificacion") String identificacion) throws ClassNotFoundException {
        try {

            return ResponseEntity.ok(servicioTutorMascota.obtenerDatosTutorMascota(identificacion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }
    
    @GetMapping("/validarIngresoTutor/{nroIdentificacion}/{subtipoRegistro}")
    public Object validarIngreso(@PathVariable String nroIdentificacion,
            @PathVariable Long subtipoRegistro
    ) {
        try {
            return ResponseEntity.ok(servicioTutorMascota.validarIngresoTutor(nroIdentificacion, subtipoRegistro));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/validarExisteTutor/{nroIdentificacion}")
    public Object validarExisteTutor(@PathVariable String nroIdentificacion
    ) {
        try {
            return ResponseEntity.ok(servicioTutorMascota.validarExisteTutor(nroIdentificacion));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }
    
}
