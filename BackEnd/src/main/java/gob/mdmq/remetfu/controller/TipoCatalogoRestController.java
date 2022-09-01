/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemTipoCatalogo;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.dto.DtoTipoCatalogo;
import gob.mdmq.remetfu.service.ServicioTipoCatalogo;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TipoCatalogoRestController {

    @Autowired
    private ServicioTipoCatalogo servicioTipoCatalogo;

    @Autowired
    private ClsLog logArchivos;

    @GetMapping("/obtenerTipoCatalogos")
    public ResponseEntity<List<DtoTipoCatalogo>> obtenerTipoCatalogo() {
        try {
            return ResponseEntity.ok(servicioTipoCatalogo.obtenerListaTipoCatalogo());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @GetMapping("/obtenerTipoCatalogosById/{id}")
    public ResponseEntity<List<DtoTipoCatalogo>> obtenerListaTipoCatalogoById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(servicioTipoCatalogo.obtenerListaTipoCatalogoById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @PostMapping("/crearTipoCatalogo/{nombre}")
    public ResponseEntity<?> guardarTipoCatalogos(
            @PathVariable(value = "nombre") String nombre,
            @RequestBody RemTipoCatalogo remTipoCatalogo) {
        String pantalla = "";
        pantalla = this.getClass().getName();
        try {
            remTipoCatalogo.setNombre(nombre);

            RemTipoCatalogo guardarTipoCatalogo = servicioTipoCatalogo.creaUpdate(remTipoCatalogo);

            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Insertar datos de Tipo Catalogo");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
        } catch (Exception e) {
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Error al grabar datos de Tipo Catalogo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}
