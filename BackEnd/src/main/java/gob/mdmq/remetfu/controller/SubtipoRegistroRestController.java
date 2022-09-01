/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.service.ServicioSubtipoRegistro;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")

public class SubtipoRegistroRestController {
    
    @Autowired 
    private ServicioSubtipoRegistro servicioSubtipoRegistro;

    @GetMapping("/obtenerSubtipoRegistro")
    public ResponseEntity<?> obtenerSubtipoRegistro() throws ClassNotFoundException {
        try {
            var t= servicioSubtipoRegistro.obtener();
            return ResponseEntity.ok(servicioSubtipoRegistro.obtener());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }
    
    
    @GetMapping("/obtenerSubtipoRegistroById/{id}")
    public Object obtenerSubtipoRegistroById(@PathVariable Long id) {
         try {
            return ResponseEntity.ok(servicioSubtipoRegistro.obtenerById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    
}
