/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioMicrochipMascota;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class MicrochipMascotaController {

    @Autowired
    private ServicioMicrochipMascota servicioMicrochipMascota;

    @GetMapping("/obtenerMicrochipMascota{id}")
    public ResponseEntity<Optional<RemMicrochipMascota>> obtenerMicrochipMascotaById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(servicioMicrochipMascota.obtenerById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/obtenerMicrochipMascota")
    public ResponseEntity<List<RemMicrochipMascota>> obtenerLista() throws ClassNotFoundException {
        try {
            return ResponseEntity.ok(servicioMicrochipMascota.obtenerMicrochipTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/creaMicrochip/{tutorId}/{veterinarioId}/{establecimientoId}")

    public ResponseEntity<?> crearMicrochipMascota(
            @PathVariable(value = "tutorId") Long tutorId,
            @PathVariable(value = "veterinarioId") Long usuarioId,
            @PathVariable(value = "establecimientoId") Long establecimientoId,
            @RequestBody RemMicrochipMascota remMicrochipMascota) {

        try {

            if (servicioMicrochipMascota.crearMicrochipMascota(remMicrochipMascota, tutorId, usuarioId, establecimientoId)) {
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
