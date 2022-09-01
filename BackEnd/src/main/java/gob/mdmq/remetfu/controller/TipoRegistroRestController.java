/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemTipoRegistro;
import gob.mdmq.remetfu.dto.DtoTipoRegistro;
import gob.mdmq.remetfu.service.ServicioQR;
import gob.mdmq.remetfu.service.ServicioSAO;
import gob.mdmq.remetfu.service.ServicioTipoRegistro;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TipoRegistroRestController {

    @Autowired
    private ServicioTipoRegistro servicioTipoRegistro;
    @Autowired
    private ServicioSAO servicioSao;
    
    @Autowired
    private ServicioQR servicioQR;

    @GetMapping("/obtenerTipoRegistroTodos")
    public ResponseEntity<List<RemTipoRegistro>> obtenerTipoRegistroTodos() {
        try {
            return ResponseEntity.ok(servicioTipoRegistro.obtenerRegistrosTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/obtenerRegistros")
    public ResponseEntity<List<DtoTipoRegistro>> obtenerRegistros() {
        try {
            return ResponseEntity.ok(servicioTipoRegistro.obtenerTipoRegistro());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

}
