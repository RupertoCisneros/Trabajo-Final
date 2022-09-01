/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemTramiteReasignacion;
import gob.mdmq.remetfu.dto.DtoReasignaciones;
import gob.mdmq.remetfu.repository.TramiteReasignacionRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioTramiteReasignacion {
     
    @Autowired
    private TramiteReasignacionRepository tramiteReasignacionRepository;
    
    //@Transactional
    public boolean reasignacionRegistro(RemTramiteReasignacion remTramiteReasignacion) {
        boolean respuesta = false;
        try {
            tramiteReasignacionRepository.save(remTramiteReasignacion);
            respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;

    }    
    
    public Set<DtoReasignaciones> obtenerDatosReasignaciones(Long nroRegistro, String fechaInicio, String fechaFin, Long analistaAntes, Long analistaDespues, Long usuarioAsigna, String nroIdentificacion ) throws ParseException {
        Set<DtoReasignaciones> listaReasignacion = new HashSet<>();
        try {

            List<String> datos = tramiteReasignacionRepository.obtenerDatosReasignaciones(nroRegistro, fechaInicio, fechaFin, analistaAntes, analistaDespues, usuarioAsigna, nroIdentificacion);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            for (int i = 0; i < datos.size(); i++) {
                var data = datos.get(i);
                String[] split = data.split(",");
                List<String> listaDatos = new ArrayList<>();

                for (int j = 0; j < split.length; j++) {

                    listaDatos.add(split[j]);
                }

                for (int k = 0; k < listaDatos.size(); k++) {
                    DtoReasignaciones dtoReasignaciones = new DtoReasignaciones();
                    dtoReasignaciones.setRegistroProfesionalId(Long.parseLong(listaDatos.get(0).toString()));
                    dtoReasignaciones.setNroRegistro(listaDatos.get(1).toString().trim());
                    dtoReasignaciones.setAnalistaAntes(listaDatos.get(2).toString().trim());
                    dtoReasignaciones.setAnalistaDespues(listaDatos.get(3).toString());
                    dtoReasignaciones.setMotivoReasignacion(listaDatos.get(4).toString());
                    Date fechaReasignacion = sdf.parse(listaDatos.get(5).toString());
                    dtoReasignaciones.setFechaReasignacion(fechaReasignacion);
                    dtoReasignaciones.setNombreUsuarioRegistro(listaDatos.get(6).toString());
                    dtoReasignaciones.setNombreUsuarioReasigna(listaDatos.get(7).toString());
                    listaReasignacion.add(dtoReasignaciones);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaReasignacion;

    }
    
}
