/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemPerfil;
import gob.mdmq.remetfu.dto.DtoPerfil;
import gob.mdmq.remetfu.service.ServicioPerfiles;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author ruper
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PerfilRestController {

    @Autowired
    private ServicioPerfiles servicioPerfil;

    @GetMapping("/obtenerPerfilesById/{id}")
    public ResponseEntity<RemPerfil> obtenerPerfilesById(@PathVariable("id") Long id) {
        try {

            return ResponseEntity.ok(servicioPerfil.obtenerPerfilById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/obtenerPerfiles")
    public ResponseEntity<Set<DtoPerfil>> obtenerPerfiles() {
        try {

            return ResponseEntity.ok(servicioPerfil.obtenerPerfiles());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

}
