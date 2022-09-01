/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.dto.DtoToken;
import gob.mdmq.remetfu.dto.fileserver.DtoArchivo;
import gob.mdmq.remetfu.dto.fileserver.DtoSistemaRequest;
import gob.mdmq.remetfu.service.ServicioWSO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author oportero
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class WSO2RestController {

    @Autowired
    private ServicioWSO2 servicioWSO2;

    @PostMapping(path = "/wso2/get-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DtoToken> getToken() {
        try {
            DtoToken usuario = servicioWSO2.getToken();

            return ResponseEntity.ok(usuario);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping(path = "/wso2/get-archivo/{archivoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getArchivo(@PathVariable String archivoId) {
        try {
            Object archivo = servicioWSO2.getArchivo(archivoId);

            return ResponseEntity.ok(archivo);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PostMapping(path = "/wso2/guardar-archivo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardarArchivo(@RequestBody DtoArchivo archivo) {
        try {
            String hash = servicioWSO2.guardarArchivo(archivo);

            return ResponseEntity.ok(hash);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PostMapping(path = "/wso2/guardar-sistema", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> guardarSistema(@RequestBody DtoSistemaRequest sistema) {
        try {
            Integer result = servicioWSO2.guardarSistema(sistema);

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    
}
