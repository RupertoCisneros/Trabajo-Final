/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemTipoCatalogo;
import gob.mdmq.remetfu.dto.DtoCatalogo;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioCatalogo;
import gob.mdmq.remetfu.service.ServicioTipoCatalogo;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
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
public class CatalogoRestController {

    @Autowired
    private ServicioCatalogo servicioCatalogo;

    @Autowired
    private ServicioTipoCatalogo servicioTipoCatalogo;

    @Autowired
    private ClsLog logArchivos;

    @GetMapping("/obtenerCatalogos")
    public ResponseEntity<List<DtoCatalogo>> obtenerCatalogo() {
        try {
            return ResponseEntity.ok(servicioCatalogo.obtenerListaCatalogo());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);
        }

    }

    @GetMapping("/obtenerListaCatalogos")
    public ResponseEntity<List<DtoCatalogo>> obtenerListaCatalogos() {
        try {
            return ResponseEntity.ok(servicioCatalogo.obtenerListaCatalogos());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);
        }

    }

    @GetMapping("/obtenerCatalogoById/{id}")
    public ResponseEntity<List<DtoCatalogo>> obtenerCatalogoById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(servicioCatalogo.obtenerCatalogoById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/creaCatalogo/{tipoCatalogoId}/{nombre}")
    public ResponseEntity<?> guardarCatalogos(
            @PathVariable(value = "tipoCatalogoId") Long tipoCatalogoId,
            @PathVariable(value = "nombre") String nombre,
            @RequestBody RemCatalogo remCatalogo) {
        String pantalla = "";
        pantalla = this.getClass().getName();
        try {
            Optional<RemTipoCatalogo> codigoTipoCatalogo = servicioTipoCatalogo.obtenerById(tipoCatalogoId);

            remCatalogo.setNombre(nombre);
            remCatalogo.setTipoCatalogoId(codigoTipoCatalogo.get());

            Boolean guardarCatalogo = servicioCatalogo.creaUpdate(remCatalogo);
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Insertar datos de Catalogo");
            if (guardarCatalogo) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Error al grabar datos de Catalogo");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/eliminarCatalogo/{catalogoId}")
    public ResponseEntity<?> eliminarCatalogo(
            @PathVariable(value = "catalogoId") Long catalogoId,
            @RequestBody RemCatalogo remCatalogo) {
        String pantalla = "";
        pantalla = this.getClass().getName();
        try {
            Boolean eliminarCatalogo = servicioCatalogo.eliminarCatalogo(catalogoId);
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Eliminación de datos de Catalogo");
            if (eliminarCatalogo) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            logArchivos.RegistrarProceso(pantalla, "Pasa datos de auditoria", "Error al eliminar datos de Catalogo");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
        }
    }

}
