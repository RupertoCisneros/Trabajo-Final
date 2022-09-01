/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.dto.DtoMenuPerfil;
import gob.mdmq.remetfu.service.ServicioMenuPerfil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author omaldonado
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MenuPerfilController {

    @Autowired
    private ServicioMenuPerfil menuPerfil;

    @GetMapping("/obtenerDatosMenu/{perfil}")
    public ResponseEntity<List<DtoMenuPerfil>> obtenerDatosMenu(@PathVariable("perfil") String perfil) {
        try {

            return ResponseEntity.ok(menuPerfil.obtenerMenu(perfil));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

}
