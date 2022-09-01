/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemAnimalTutor;
import gob.mdmq.remetfu.dto.DtoAnimalTutor;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioAnimalTutor;
import gob.mdmq.remetfu.service.ServicioMail;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
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
public class AnimalTutorRestController {


    @Autowired
    private ServicioAnimalTutor servicioAnimalTutor;


    @GetMapping("/obtenerAnimalTutor")
    public ResponseEntity<List<RemAnimalTutor>> obtenerTutorAnimalTodos() throws ClassNotFoundException {
        try {
            return ResponseEntity.ok(servicioAnimalTutor.obtenerTutorAnimalTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/obtenerAnimalTutor/{id}")
    public ResponseEntity<Optional<RemAnimalTutor>> obtenerById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(servicioAnimalTutor.obtenerById(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/crearAnimalTutor")
    public ResponseEntity<?> crearAnimalTutor(@RequestBody Map<String, Object[]> models) {
        try {
            RemAnimalTutor remAnimalTutor = servicioAnimalTutor.crearAnimalTutor(models);
            DtoAnimalTutor dtoAnimalTutor = servicioAnimalTutor.obtenerDatosAnimalTutor(remAnimalTutor.getAnimalTutorId());
            var mensaje = servicioAnimalTutor.mensajePreRegistroAnimal(dtoAnimalTutor.getAnimalTutorId());
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(),mensaje), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerDatosAnimalTutor/{id}")
    public Object obtenerDatosAnimalTutor(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(servicioAnimalTutor.obtenerDatosAnimalTutor(id));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }
    
}
