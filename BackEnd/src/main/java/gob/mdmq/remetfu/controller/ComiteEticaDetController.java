/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemComiteEticaCab;
import gob.mdmq.remetfu.Entidades.RemComiteEticaDet;
import gob.mdmq.remetfu.dto.DtoComiteEticaDetalle;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioCatalogo;
import gob.mdmq.remetfu.service.ServicioComiteEticaCab;
import gob.mdmq.remetfu.service.ServicioComiteEticaDet;
import gob.mdmq.remetfu.service.ServicioUsuarios;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
@CrossOrigin
@RequestMapping("/api")
public class ComiteEticaDetController {

    @Autowired
    private ServicioComiteEticaDet servicioComiteEticaDet;
    @Autowired
    private ServicioUsuarios servicioUsuarios;
    @Autowired
    private ServicioCatalogo servicioCatalogo;
    @Autowired
    private ServicioComiteEticaCab servicioComiteEticaCab;
    @Autowired
    private ClsLog logArchivos;

    @GetMapping("/obtenerComiteEticaDet")
    public ResponseEntity<List<RemComiteEticaDet>> obtenerParametro() throws ClassNotFoundException {
        try {
            return ResponseEntity.ok(servicioComiteEticaDet.obtenerComiteEticaTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/obtenerComiteEticaDetById/{id}")
    public ResponseEntity<Optional<RemComiteEticaDet>> obtenerComiteEticaDetById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(servicioComiteEticaDet.obtenerById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/obtenerMiembrosComiteEtica/{comiteEticaCabId}")
    public ResponseEntity<Set<DtoComiteEticaDetalle>> obtenerMiembrosComiteEtica(@PathVariable("comiteEticaCabId") Long comiteEticaCabId) {
        try {
            return ResponseEntity.ok(servicioComiteEticaDet.obtenerMiembrosComiteEtica(comiteEticaCabId));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar Miembros del Comite de Etica", e);
        }
    }

    @GetMapping("/validarExisteMiembroComite/{nroIdentificacion}/{comite}")
    public Object validarExisteTutor(@PathVariable String nroIdentificacion,
            @PathVariable Long comite
    ) {
        try {
            return ResponseEntity.ok(servicioComiteEticaDet.validarExisteMiembroComite(nroIdentificacion, comite));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }
    

    @PostMapping("/creaComiteEtica/{comiteEticaCabId}/{cargo}")
    public ResponseEntity<?> creaComiteEticaDet(
            @PathVariable(value = "comiteEticaCabId") Long comiteEticaCabId,
            @PathVariable(value = "cargo") Long cargo,
            @Valid @RequestBody RemComiteEticaDet remComiteEticaDet) {
        String pantalla = "";
        pantalla = this.getClass().getName();
        try {
            Optional<RemComiteEticaCab> comiteEtica = servicioComiteEticaCab.obtenerById(comiteEticaCabId);
            Optional<RemCatalogo> cargoCatalogo = servicioCatalogo.obtenerById(cargo);

            remComiteEticaDet.setComiteEticaCabId(comiteEtica.get());
            remComiteEticaDet.setCargo(cargoCatalogo.get());

            if (servicioComiteEticaDet.crearModificarComiteEticaDet(remComiteEticaDet)) {

                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Error al grabar datos de Comite de Etica Detalle");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/eliminarMiembroComiteEtica/{comiteEticaDetId}")
    public ResponseEntity<?> eliminarMiembroComiteEtica(
            @PathVariable(value = "comiteEticaDetId") Long comiteEticaDetId) {
        String pantalla = "";
        pantalla = this.getClass().getName();
        try {
            if (servicioComiteEticaDet.eliminarMiembroComiteEticaDet(comiteEticaDetId)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Error al grabar datos de Comite de Etica Detalle");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
