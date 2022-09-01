/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.service.ServicioMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author omaldonado
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EnvioMailController {

    @Autowired
    private ServicioMail servicioMail;

    @GetMapping("/enviarMail")
    public ResponseEntity<?> enviarMail() {
        try {
       
            return ResponseEntity.ok("Envio Exitoso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

}
