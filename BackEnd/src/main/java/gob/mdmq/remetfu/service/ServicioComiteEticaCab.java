/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemComiteEticaCab;
import gob.mdmq.remetfu.dto.DtoComiteEticaCabecera;
import gob.mdmq.remetfu.dto.DtoConsultaComite;
import gob.mdmq.remetfu.repository.ComiteEticaCabRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioComiteEticaCab {

    @Autowired
    private ComiteEticaCabRepository comiteEticaCabRepository;
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private ServicioMail servicioMail;
    @Autowired
    private ServicioUsuarios servicioUsuario;

    public Optional<RemComiteEticaCab> obtenerById(Long id) {
        try {
            return comiteEticaCabRepository.findById(id);
        } catch (Exception e) {
            return null;
        }

    }

    public List<RemComiteEticaCab> obtenerComiteEticaCabTodos() {
        try {
            return comiteEticaCabRepository.findAll();

        } catch (Exception e) {
            return (List<RemComiteEticaCab>) ResponseEntity.badRequest().build();

        }

    }

    public String guardarActualizarComiteEtica(RemComiteEticaCab remComiteEticaCab) {
        Date fecha = new Date();

        remComiteEticaCab.setEstado(remComiteEticaCab.getEstado());
        remComiteEticaCab.setFechaCreacion(fecha);
        remComiteEticaCab.setFechaModificacion(fecha);
        remComiteEticaCab.setFechaRegistro(fecha);
        remComiteEticaCab.setTerminalCreacion(remComiteEticaCab.getTerminalCreacion());
        remComiteEticaCab.setTerminalModificacion(remComiteEticaCab.getTerminalCreacion());
        remComiteEticaCab.setUsuarioCreacion(remComiteEticaCab.getUsuarioCreacion());
        remComiteEticaCab.setUsuarioModificacion(remComiteEticaCab.getUsuarioCreacion());

        try {
            comiteEticaCabRepository.save(remComiteEticaCab);
            return "Estimado usuario, El comité de ética se activará cuando esten registrados todos sus miembros.";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public List<DtoComiteEticaCabecera> obtenerDatosComiteEtica() {
        List<DtoComiteEticaCabecera> dtoComiteEticaCabeceraRespuesta = new ArrayList<>();

        try {
            List<String> datos = comiteEticaCabRepository.obtenerDatosComiteEtica();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (int i = 0; i < datos.size(); i++) {
                var data = datos.get(i);
                String[] split = data.split(",");
                List<String> listaDatos = new ArrayList<>();

                for (int j = 0; j < split.length; j++) {

                    listaDatos.add(split[j]);
                }

                DtoComiteEticaCabecera dtoComiteEticaCabecera = new DtoComiteEticaCabecera();
                dtoComiteEticaCabecera.setComiteEticaCabId(Long.parseLong(listaDatos.get(0).toString()));
                dtoComiteEticaCabecera.setComiteEticaCabIdC(listaDatos.get(1).toString());
                dtoComiteEticaCabecera.setNombreInstitucion(listaDatos.get(2).toString());
                dtoComiteEticaCabecera.setFacultadInvestigacion(listaDatos.get(3).toString());
                Date fechaRegistro = sdf.parse(listaDatos.get(4).toString());
                dtoComiteEticaCabecera.setFechaRegistro(fechaRegistro);
                dtoComiteEticaCabecera.setEstado(listaDatos.get(5).toString());
                dtoComiteEticaCabeceraRespuesta.add(dtoComiteEticaCabecera);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoComiteEticaCabeceraRespuesta;
    }

    public List<DtoConsultaComite> consultaDatosComiteEtica(Long comiteEticaCabId) {
        List<DtoConsultaComite> dtoConsultaComiteRespuesta = new ArrayList<>();

        try {
            List<String> datos = comiteEticaCabRepository.consultaDatosComiteEtica(comiteEticaCabId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (int i = 0; i < datos.size(); i++) {
                var data = datos.get(i);
                String[] split = data.split(",");
                List<String> listaDatos = new ArrayList<>();

                for (int j = 0; j < split.length; j++) {

                    listaDatos.add(split[j]);
                }

                DtoConsultaComite dtoConsultaComite = new DtoConsultaComite();

                dtoConsultaComite.setComiteEticaCabId(Long.parseLong(listaDatos.get(0).toString()));
                dtoConsultaComite.setComiteEticaCabIdC(listaDatos.get(1).toString());
                dtoConsultaComite.setNombreInstitucion(listaDatos.get(2).toString());
                dtoConsultaComite.setFacultadInvestigacion(listaDatos.get(3).toString());
                Date fechaRegistro = sdf.parse(listaDatos.get(4).toString());
                dtoConsultaComite.setFechaRegistro(fechaRegistro);
                dtoConsultaComite.setComiteEticaDetId(Long.parseLong(listaDatos.get(5).toString()));

                dtoConsultaComite.setIdentificacion(listaDatos.get(6).toString());
                dtoConsultaComite.setNombres(listaDatos.get(7).toString());
                dtoConsultaComite.setNumeroSenecyt(listaDatos.get(8).toString());
                dtoConsultaComite.setCorreo(listaDatos.get(9).toString());
                dtoConsultaComite.setTelefono(listaDatos.get(10).toString());
                dtoConsultaComite.setCargo(listaDatos.get(11).toString());
                dtoConsultaComite.setCargoDescripcion(listaDatos.get(12).toString());
                dtoConsultaComiteRespuesta.add(dtoConsultaComite);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoConsultaComiteRespuesta;
    }

    @Transactional
    public String guardarComiteEticaCompleto(DtoComiteEticaCabecera dtoComiteEticaCab, String usuarioCreacion, String terminalModificacion) {
        Date fechaModificacion = new Date();
        try {
            comiteEticaCabRepository.actualizarComiteEticaCab(
                    dtoComiteEticaCab.getComiteEticaCabId(),
                    usuarioCreacion,
                    terminalModificacion,
                    dtoComiteEticaCab.getEstado(),
                    fechaModificacion);
            taskExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        var usuario = servicioUsuario.obtenerByCedula2(usuarioCreacion);
                        var mensaje = "Se ha registrado correctamente el registro";
                        servicioMail.enviarNotificaciones("Registro Comite de ética", mensaje, usuario.getUsuarioId(), 4, dtoComiteEticaCab.getComiteEticaCabId(), true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return "El registro ha sido guardado de manera exitosa";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }
}
