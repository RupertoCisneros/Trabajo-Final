/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemComiteEticaDet;
import gob.mdmq.remetfu.dto.DtoComiteEticaDetalle;
import gob.mdmq.remetfu.dto.DtoValidarRegistro;
import gob.mdmq.remetfu.repository.ComiteEticaCabRepository;
import gob.mdmq.remetfu.repository.ComiteEticaDetRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioComiteEticaDet {

    @Autowired
    private ComiteEticaDetRepository comiteEticaDetRepository;
    @Autowired
    private ComiteEticaCabRepository comiteEticaCabRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    private ClsLog logArchivos;

    @Transactional

    public RemComiteEticaDet guardarComiteEticaDet(RemComiteEticaDet remComiteEticaDet) {

        boolean respuesta = false;
        String idComiteEticaDetCreado = "";
        Optional<RemComiteEticaDet> comiteEticaDetCreado;

        try {

        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public Optional<RemComiteEticaDet> obtenerById(Long id) {
        return comiteEticaDetRepository.findById(id);
    }

    public List<RemComiteEticaDet> obtenerComiteEticaTodos() {
        try {
            return (List<RemComiteEticaDet>) comiteEticaDetRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean crearModificarComiteEticaDet(RemComiteEticaDet remComiteEticaDet) {
        boolean respuesta = false;
        Date fecha = new Date();
        remComiteEticaDet.setEstado("ACT");
        remComiteEticaDet.setFechaCreacion(fecha);
        remComiteEticaDet.setFechaModificacion(fecha);
        remComiteEticaDet.setTerminalCreacion(remComiteEticaDet.getTerminalCreacion());
        remComiteEticaDet.setTerminalModificacion(remComiteEticaDet.getTerminalCreacion());
        remComiteEticaDet.setUsuarioCreacion(remComiteEticaDet.getUsuarioCreacion());
        remComiteEticaDet.setUsuarioModificacion(remComiteEticaDet.getUsuarioCreacion());

        try {            
            comiteEticaDetRepository.save(remComiteEticaDet);
            respuesta=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    public boolean eliminarMiembroComiteEticaDet(Long comiteEticaDetId) {
        boolean respuesta = false;
        try {            
            comiteEticaDetRepository.deleteById(comiteEticaDetId);
            respuesta=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public Set<DtoComiteEticaDetalle> obtenerMiembrosComiteEtica(Long comiteEticaCabId) {
        try {
            return comiteEticaDetRepository.obtenerMiembrosComiteEtica(comiteEticaCabId);
        } catch (Exception e) {
            return null;
        }
    }

    public DtoValidarRegistro validarExisteMiembroComite(String nroIdentificacion, Long comite) {

        DtoValidarRegistro dtoValidarRegistro = new DtoValidarRegistro();

        try {
            List<String> datos = comiteEticaDetRepository.validarExisteMiembroComite(nroIdentificacion, comite);
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
