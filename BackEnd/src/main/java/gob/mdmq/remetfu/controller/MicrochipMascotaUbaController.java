/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascotaUba;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioMicrochipMascotaUba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class MicrochipMascotaUbaController {
    
    @Autowired
    private ServicioMicrochipMascotaUba servicioMicrochipMascotaUba;    
    
    @PostMapping("/creaMicrochipUba/{tutorId}/{cedulaVeterinario}/{establecimientoId}")

    public ResponseEntity<?> crearMicrochipMascotaUba(
            @PathVariable(value = "tutorId") Long tutorId,
            @PathVariable(value = "cedulaVeterinario") String cedulaVeterinario,
            @PathVariable(value = "establecimientoId") Long establecimientoId,
            @RequestBody RemMicrochipMascotaUba remMicrochipMascotaUba) {

        try {

            if (servicioMicrochipMascotaUba.crearMicrochipMascotaUba(remMicrochipMascotaUba, tutorId, cedulaVeterinario, establecimientoId)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
