/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemAtencionAnimales;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemEnfermedadesAnimales;
import gob.mdmq.remetfu.repository.AtencionAnimalRepository;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.EnfermedadesAnimalesRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omaldonado
 */
@Service
public class ServicioEnfermedadesAnimales {

    @Autowired
    private EnfermedadesAnimalesRepository enfermedadesAnimalesRepository;
    @Autowired
    private AtencionAnimalRepository atencionAnimalRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;

    public boolean crearEnfermedadAnimal(String observaciones, Long atencionAnimalesId, Long enfermedadesDetectadasId) {
        boolean respuesta = false;
        RemEnfermedadesAnimales enfermedadesAnimales = new RemEnfermedadesAnimales();
        Date fecha = new Date();
        try {
            Optional<RemAtencionAnimales> atencionAnimalId = atencionAnimalRepository.findById(atencionAnimalesId);
            Optional<RemCatalogo> enfermedadesDetectadaId = catalogoRepository.findById(enfermedadesDetectadasId);

            enfermedadesAnimales.setAtencionAnimalesId(atencionAnimalId.get());
            enfermedadesAnimales.setEnfermedadesDetectadas(enfermedadesDetectadaId.get());
            enfermedadesAnimales.setEstado("ACT");
            enfermedadesAnimales.setFechaCreacion(fecha);
            enfermedadesAnimales.setFechaModificacion(fecha);
            enfermedadesAnimales.setFechaRegistro(fecha);
            enfermedadesAnimales.setTerminalCreacion("");
            enfermedadesAnimales.setTerminalModificacion("");
            enfermedadesAnimales.setUsuarioCreacion("");
            enfermedadesAnimales.setUsuarioModificacion("");

            enfermedadesAnimalesRepository.save(enfermedadesAnimales);
            return respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }
    }

}
