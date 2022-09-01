/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.dto.DtoReasignaciones;
import gob.mdmq.remetfu.service.ServicioTramiteReasignacion;
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
 * @author srcisnerosv
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TramiteReasignacionRestController {
    
    @Autowired
    private ServicioTramiteReasignacion servicioTramiteReasignacion;
    
    @GetMapping("/obtenerDatosReasignaciones/{nroRegistro}/{fechaInicio}/{fechaFin}/{analistaAntes}/{analistaDespues}/{usuarioAsigna}/{nroIdentificacion}")
    public ResponseEntity<Set<DtoReasignaciones>> obtenerDatosReasignaciones(
            @PathVariable Long nroRegistro,
            @PathVariable String fechaInicio,
            @PathVariable String fechaFin,
            @PathVariable Long analistaAntes,
            @PathVariable Long analistaDespues,
            @PathVariable Long usuarioAsigna,
            @PathVariable String nroIdentificacion
        ) {
        try {
            return ResponseEntity.ok(servicioTramiteReasignacion.obtenerDatosReasignaciones(
                    nroRegistro,fechaInicio,fechaFin,analistaAntes,analistaDespues,usuarioAsigna,nroIdentificacion));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    
}
