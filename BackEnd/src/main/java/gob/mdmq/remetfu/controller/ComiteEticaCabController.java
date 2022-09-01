/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemComiteEticaCab;
import gob.mdmq.remetfu.dto.DtoComiteEticaCabecera;
import gob.mdmq.remetfu.dto.DtoConsultaComite;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioComiteEticaCab;
import java.util.List;
import java.util.Optional;
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
 * @author srcisnerosv
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ComiteEticaCabController {

    @Autowired
    private ServicioComiteEticaCab servicioComiteEticaCab;

    @PostMapping("/crearComiteEticaCab")
    public ResponseEntity<?> crearComiteEticaCab(
            @RequestBody RemComiteEticaCab remComiteEticaCab) {
        try {
            var mensaje = servicioComiteEticaCab.guardarActualizarComiteEtica(remComiteEticaCab);
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), mensaje), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/obtenerCabeceraComiteEticaById/{codigoComite}")
    public ResponseEntity<Optional<RemComiteEticaCab>> obtenerComiteEticaCabById(
            @PathVariable("codigoComite") Long codigoComite) {
        try {
            return ResponseEntity.ok(servicioComiteEticaCab.obtenerById(codigoComite));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/obtenerComiteEticaCab")
    public ResponseEntity<List<RemComiteEticaCab>> obtenetComiteEticaCabTodos() throws ClassNotFoundException {
        try {
            return ResponseEntity.ok(servicioComiteEticaCab.obtenerComiteEticaCabTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/obtenerDatosComiteEtica")
    public ResponseEntity<?> obtenerDatosComiteEtica() {
        try {
            return ResponseEntity.ok(servicioComiteEticaCab.obtenerDatosComiteEtica());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar Datos del Comite de Etica", e);
        }
    }

    @GetMapping("/consultaDatosComiteEtica/{codigoComite}")
    public ResponseEntity<List<DtoConsultaComite>> consultaDatosComiteEtica(
    @PathVariable("codigoComite") Long codigoComite) {
        try {
            return ResponseEntity.ok(servicioComiteEticaCab.consultaDatosComiteEtica(codigoComite));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar Datos del Comite de Etica", e);
        }
    }

    @PostMapping("/guardarComiteEticaCompleto/{usuarioModificacion}/{terminalModificacion}")
    public ResponseEntity<?> guardarComiteEticaCompleto(
            @PathVariable(value = "usuarioModificacion") String usuarioModificacion,
            @PathVariable(value = "terminalModificacion") String terminalModificacion,
            @RequestBody DtoComiteEticaCabecera dtoComiteEticaCab) {
        try {
            var mensaje = servicioComiteEticaCab.guardarComiteEticaCompleto(dtoComiteEticaCab,usuarioModificacion,terminalModificacion);
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), mensaje), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
        }

    }
}
