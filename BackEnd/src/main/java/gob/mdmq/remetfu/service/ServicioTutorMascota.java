 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemTutorMascota;
import gob.mdmq.remetfu.dto.DtoTutorMascota;
import gob.mdmq.remetfu.dto.DtoValidarRegistro;
import gob.mdmq.remetfu.repository.TutorMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author oportero
 */
@Service
public class ServicioTutorMascota {

    @Autowired

    private TutorMascotaRepository tutorMascotaRepository;

    @Transactional
    public boolean crearActualizarTutorMascota(RemTutorMascota remTutorMascota) {
        boolean respuesta = false;
        try {
            tutorMascotaRepository.save(remTutorMascota);
            respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;

    }

    public Set<DtoTutorMascota> obtenerDatosTutorMascota(String nroIdentificacion) {
        try {
            return tutorMascotaRepository.obtenerDatosTutorMascota(nroIdentificacion);
        } catch (Exception e) {
            return tutorMascotaRepository.obtenerDatosTutorMascota(nroIdentificacion);
        }
    }
    
    public DtoValidarRegistro validarIngresoTutor(String nroIdentificacion, Long subtipoRegistro) {

        DtoValidarRegistro dtoValidarRegistro = new DtoValidarRegistro();

        try {
            List<String> datos = tutorMascotaRepository.validarIngresoTutor(nroIdentificacion);
            var data = datos.get(0);
            String[] split = data.split(",");
            List<String> listaDatos = new ArrayList<>();

            for (int i = 0; i < split.length; i++) {

                listaDatos.add(split[i]);
            }

            dtoValidarRegistro.setMensajeValidacion(listaDatos.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoValidarRegistro;
    }
    
    public DtoValidarRegistro validarExisteTutor(String nroIdentificacion) {

        DtoValidarRegistro dtoValidarRegistro = new DtoValidarRegistro();

        try {
            List<String> datos = tutorMascotaRepository.validarExisteTutor(nroIdentificacion);
            var data = datos.get(0);
            String[] split = data.split(",");
            List<String> listaDatos = new ArrayList<>();

            for (int i = 0; i < split.length; i++) {

                listaDatos.add(split[i]);
            }

            dtoValidarRegistro.setMensajeValidacion(listaDatos.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoValidarRegistro;
    }

}
