/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemAnalista;
import gob.mdmq.remetfu.dto.DtoAsignacionAnalista;
import gob.mdmq.remetfu.repository.AnalistaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioAnalista {

    @Autowired
    private AnalistaRepository analistaRepository;
    @Autowired
    private ServicioSAO servicioSao;

    public Optional<RemAnalista> obtenerById(Long id) {
        try {

            return analistaRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<RemAnalista> obtener() {
        try {
            return analistaRepository.findAll();
        } catch (Exception e) {
            return analistaRepository.findAll();
        }
    }

    public boolean guardarActualizarAnalistas(RemAnalista remAnalista) {
        boolean respuesta = false;
        try {
            analistaRepository.save(remAnalista);
            respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;

    }

    public RemAnalista guardarAsignacionAnalistas(RemAnalista remAnalista) {
        try {
            return analistaRepository.save(remAnalista);
        } catch (Exception e) {
            return null;
        }

    }

    public List<DtoAsignacionAnalista> getListaAnalistasActivos() {
        try {
            return analistaRepository.getListaAnalistasActivos();
        } catch (Exception e) {
            return analistaRepository.getListaAnalistasActivos();
        }
    }

    public RemAnalista getAnalistaByDefault() {
        try {
            return analistaRepository.obtenerAnalistatByDefault();
        } catch (Exception e) {
            return analistaRepository.obtenerAnalistatByDefault();
        }
    }

    public List<DtoAsignacionAnalista> obtenerRegistrosAnalistas() {
        try {
            return analistaRepository.obtenerRegistrosAnalistas();
        } catch (Exception e) {
            return analistaRepository.obtenerRegistrosAnalistas();
        }
    }

    @Transactional
    public String aprobarTramite(Long registroProfesionalId, String novedad, Long idSubTipoRegistro, Long idUsuario, String usuarioCreacion, String terminalTransaccion) {
        String orden = "";
        Date fechaAprobacion = new Date();
        try {

            var ordenGenerada = servicioSao.generarOrdenPago(idSubTipoRegistro, registroProfesionalId, usuarioCreacion, idUsuario, terminalTransaccion, usuarioCreacion);
            if (!ordenGenerada.equals("")) {
                analistaRepository.aprobarTramiteRegistroAnalistaProfesional(registroProfesionalId, fechaAprobacion, novedad, usuarioCreacion, terminalTransaccion);
                //Aqui se actualiza el estado de la tabla RemRegistroProfesional
                analistaRepository.aprobarTramiteProfesional(registroProfesionalId, usuarioCreacion, terminalTransaccion);
                orden = ordenGenerada;
            }
            return orden;

        } catch (Exception e) {
            e.printStackTrace();
            return orden;
        }
    }

    @Transactional
    public boolean rechazarTramite(Long registroProfesionalId, String novedad, String usuarioCreacion, String terminalTransaccion) {
        boolean respuesta = false;
        Date fechaRechazo = new Date();
        try {

            analistaRepository.rechazarTramiteRegistroAnalistaProfesional(registroProfesionalId, fechaRechazo, novedad, usuarioCreacion, terminalTransaccion);
            analistaRepository.rechazarTramiteProfesional(registroProfesionalId, usuarioCreacion, terminalTransaccion);
            return respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }
    }

    @Transactional
    public boolean devolverTramite(Long registroProfesionalId, String novedad, String usuarioCreacion, String terminalTransaccion) {
        boolean respuesta = false;
        Date fechaDevolucion = new Date();
        try {

            analistaRepository.devolverTramiteRegistroAnalistaProfesional(registroProfesionalId, fechaDevolucion, novedad, usuarioCreacion, terminalTransaccion);
            analistaRepository.devolverTramiteProfesional(registroProfesionalId, usuarioCreacion, terminalTransaccion);
            return respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }
    }

}
