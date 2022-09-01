/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemParametros;
import gob.mdmq.remetfu.service.ServicioParametro;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import java.net.URI;
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

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ParametroRestController {

    @Autowired
    private ServicioParametro servicioParametro;
    @Autowired
    private ClsLog logArchivos;

    @GetMapping("/obtenerParametros")
    public ResponseEntity<List<RemParametros>> obtenerParametro() throws ClassNotFoundException {
        try {
            return ResponseEntity.ok(servicioParametro.obtenerParametroById());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/obtenerParametroById/{id}")
    public ResponseEntity<Optional<RemParametros>> obtenerParametroById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(servicioParametro.obtenerById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/creaParametro/{descripcion}/{valor}")
    public ResponseEntity<RemParametros> guardarParametro(
            @PathVariable(value = "descripcion") String descripcion,
            @PathVariable(value = "valor") String valor,
            @RequestBody RemParametros remParametro) {
        String pantalla = "";
        pantalla = this.getClass().getName();
        try {
            remParametro.setDescripcion(descripcion);
            remParametro.setValor(valor);
            RemParametros guardarParametro = servicioParametro.crearUpdate(remParametro);
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Insertar datos de Parametros");
            return ResponseEntity.created(new URI("api/creaParametro" + guardarParametro.getParametrosId())).body(guardarParametro);
        } catch (Exception e) {
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Error al grabar datos de Parametros");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
