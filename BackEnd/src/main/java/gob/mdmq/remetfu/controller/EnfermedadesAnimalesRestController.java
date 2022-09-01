/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;


import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.service.ServicioEnfermedadesAnimales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author omaldonado
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EnfermedadesAnimalesRestController {
    
    @Autowired
    private ServicioEnfermedadesAnimales servicioEnfermedadesAnimales;
    
    @PostMapping("/crearEnfermedadAnimal/{atencionAnimalesId}/{enfermedadesDetectadasId}/{observaciones}")
    public ResponseEntity<?> crearEnfermedadAnimal(
            @PathVariable(value = "atencionAnimalesId") Long atencionAnimalesId,
            @PathVariable(value = "enfermedadesDetectadasId") Long enfermedadesDetectadasId,
            @PathVariable(value = "observaciones") String observaciones){
        
        try{
             if (servicioEnfermedadesAnimales.crearEnfermedadAnimal(observaciones,atencionAnimalesId,enfermedadesDetectadasId )) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }
            
        }catch(Exception e){
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        
    }
    
}
