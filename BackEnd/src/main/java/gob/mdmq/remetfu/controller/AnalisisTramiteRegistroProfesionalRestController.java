/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemAnalisisTramiteRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemAnalista;
import gob.mdmq.remetfu.Entidades.RemRegistroProfesional;
import gob.mdmq.remetfu.dto.DtoDatosActualizarAnalista;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.repository.AnalistaRepository;
import gob.mdmq.remetfu.service.ServicioAnalisisTramiteRegistroProfesional;
import gob.mdmq.remetfu.service.ServicioAnalista;
import gob.mdmq.remetfu.service.ServicioRegistroProfesional;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AnalisisTramiteRegistroProfesionalRestController {

    @Autowired
    private ServicioAnalisisTramiteRegistroProfesional servicioAnalisisTramiteRegistroProfesional;

    @Autowired
    private ServicioAnalista servicioAnalista;

    @Autowired
    private ServicioRegistroProfesional servicioRegistroProfesional;

    @Autowired
    private ClsLog logArchivos;   
    
     @Autowired
    private AnalistaRepository analistaRepository;

    @GetMapping("/analisisTramite")
    public ResponseEntity<List<RemAnalisisTramiteRegistroProfesional>> obtenerAnalistas() {
        try {
          
            return ResponseEntity.ok(servicioAnalisisTramiteRegistroProfesional.obtener());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/bandejaAnalista/{nroIdentificacion}")
    public Object obtenerBandejaporAnalista(@PathVariable String nroIdentificacion) {
        try {
            return ResponseEntity.ok(servicioAnalisisTramiteRegistroProfesional.obtenerAnalisis(nroIdentificacion));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/obtenerNroRegistrosAnalista")
    public Object obtenerNroRegistrosAnalista() {
        try {
            return ResponseEntity.ok(servicioAnalisisTramiteRegistroProfesional.obtenerNroRegistrosAnalista());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/registrosCiudadano/{nroIdentificacion}")
    public ResponseEntity<?> obtenerRegistrosCiudadano(@PathVariable String nroIdentificacion) {
        try {
            return ResponseEntity.ok(servicioAnalisisTramiteRegistroProfesional.obtenerRegistrosCiudadano(nroIdentificacion));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @PostMapping("/asignacionAnalisis/{idRegistroProfesional}/{idAnalista}")
    public ResponseEntity<?> crearTramite(
            @PathVariable(value = "idRegistroProfesional") Long idRegistroProfesional,
            @PathVariable(value = "idAnalista") Long idAnalista,
            @Valid @RequestBody RemAnalisisTramiteRegistroProfesional analisisTramiteRegistroProfesional) {

        try {

            Optional<RemAnalista> codigoAnalista = servicioAnalista.obtenerById(idAnalista);
            Optional<RemRegistroProfesional> profesionales = servicioRegistroProfesional.obtenerById(idRegistroProfesional);
            analisisTramiteRegistroProfesional.setRegistroProfesionalId(profesionales.get());
            analisisTramiteRegistroProfesional.setAnalistaId(codigoAnalista.get());

            if (servicioAnalisisTramiteRegistroProfesional.createUpdate(analisisTramiteRegistroProfesional)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {

            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos",e.getMessage()), HttpStatus.BAD_REQUEST);
           
        }
    }

    @PostMapping("/actualizarDatosTramite")
    public ResponseEntity<?> actualizarDatosTramite(@RequestBody List<DtoDatosActualizarAnalista> dtoDatosActualizarAnalista) {
        try {
            if (servicioAnalisisTramiteRegistroProfesional.actualizarTramiteRegistroProfesional(dtoDatosActualizarAnalista)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Actualización de Registros realizado Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al actualizar registros"), HttpStatus.BAD_REQUEST);

            }
        } catch (Exception e) {
            //Logs
            logArchivos.RegistrarError("Usuario", e.getMessage(), "crearUsuarioLocaAutoridad");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    

    @GetMapping("/obtenerRegistrosPorFiltros/{nroIdentificacion}/{estadoRegistro}/{fechaInicio}/{fechaFin}")
    public Object obtenerRegistrosPorFiltros(
            @PathVariable String nroIdentificacion,
            @PathVariable Long estadoRegistro,
            @PathVariable String fechaInicio,
            @PathVariable String fechaFin
        ) {
        try {
            return ResponseEntity.ok(servicioAnalisisTramiteRegistroProfesional.obtenerRegistrosPorFiltros(
                    nroIdentificacion,estadoRegistro,fechaInicio,fechaFin));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }
    
}
