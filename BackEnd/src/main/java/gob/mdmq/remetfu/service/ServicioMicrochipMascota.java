/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.Entidades.RemRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemTutorMascota;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.MicrochipMascotaRepository;
import gob.mdmq.remetfu.repository.RegistroProfesionalRepository;
import gob.mdmq.remetfu.repository.TutorMascotaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioMicrochipMascota {

    @Autowired
    private MicrochipMascotaRepository microchipMascotaRepository;
    @Autowired
    private TutorMascotaRepository tutorMascotaRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private RegistroProfesionalRepository profesionalRepository;

    public Optional<RemMicrochipMascota> obtenerById(Long id) {
        return microchipMascotaRepository.findById(id);
    }

    public List<RemMicrochipMascota> obtenerMicrochipTodos() {
        try {
            return (List<RemMicrochipMascota>) microchipMascotaRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean crearMicrochipMascota(RemMicrochipMascota remMicrochipMascota, Long tutorId, Long usuarioId, Long establecimientoId) {

        boolean respuesta = false;
        Date fecha = new Date();
        try {

            Optional<RemTutorMascota> codigoTutor = tutorMascotaRepository.findById(tutorId);
            Optional<RemCatalogo> codigoEstablecimiento = catalogoRepository.findById(establecimientoId);
            RemRegistroProfesional registroProfesional = profesionalRepository.obtenerRegistroProfesionalMicroChip(usuarioId);

            remMicrochipMascota.setTutorId(codigoTutor.get());
            remMicrochipMascota.setEstablecimiento(codigoEstablecimiento.get());
            remMicrochipMascota.setVeterinario(registroProfesional);
            remMicrochipMascota.setFechaCreacion(fecha);
            remMicrochipMascota.setFechaIngreso(fecha);
            remMicrochipMascota.setFechaModificacion(fecha);

            microchipMascotaRepository.save(remMicrochipMascota);
            return respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }

    }

    public Optional<RemMicrochipMascota> obtenerById(String codigoMicrochip) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
