/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemUsuarioPerfil;
import gob.mdmq.remetfu.service.ServicioAnalista;
import gob.mdmq.remetfu.service.ServicioUsuarioPerfil;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
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
public class UsuarioPerfilRestController {

    @Autowired
    private ServicioUsuarioPerfil servicioUsuarioPerfil;
    @Autowired
    private ServicioAnalista servicioAnalista;

    @GetMapping("/obtenerUsuarioPerfil")
    public ResponseEntity<List<RemUsuarioPerfil>> obtenerUsuarioPerfil() {
        try {
            return ResponseEntity.ok(servicioUsuarioPerfil.obtener());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }
    
    @GetMapping("/obtenerPerfilesUsuario/{username}")
    public ResponseEntity<?> obtenerPerfilesUsuario(
            @PathVariable String username) {
        try {
            return ResponseEntity.ok(servicioUsuarioPerfil.obtenerPerfilesUsuario(username));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);
        }

    }    
        

}
