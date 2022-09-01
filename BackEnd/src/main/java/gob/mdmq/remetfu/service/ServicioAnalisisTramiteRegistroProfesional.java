/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemAnalisisTramiteRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemAnalista;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemTramiteReasignacion;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoBandejaAnalista;
import gob.mdmq.remetfu.dto.DtoAsignacionAnalista;
import gob.mdmq.remetfu.dto.DtoConsultaRegistros;
import gob.mdmq.remetfu.dto.DtoDatosActualizarAnalista;
import gob.mdmq.remetfu.dto.DtoUsuarioAnalista;
import gob.mdmq.remetfu.repository.AnalisisTramiteRegistroProfesionalRepository;
import gob.mdmq.remetfu.repository.AnalistaRepository;
import gob.mdmq.remetfu.utilitarios.ClsUtilitario;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@EnableTransactionManagement
@Service
public class ServicioAnalisisTramiteRegistroProfesional {

    @Autowired
    private AnalisisTramiteRegistroProfesionalRepository analisisTramiteRegistroProfesionalRepository;

    @Autowired
    private ServicioAnalista servicioAnalista;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @Autowired
    private ClsUtilitario clsUtilitario;

    @Autowired
    private ServicioTramiteReasignacion servicioTramiteReasignacion;

    @Autowired
    private ServicioCatalogo servicioCatalogo;

    @Autowired
    private AnalistaRepository analistaRepository;

    public RemAnalisisTramiteRegistroProfesional guardarAsignacion(Optional<RemRegistroProfesional> profesionalCreado,
           RemRegistroProfesional registroProfesional, Long proceso
    ) throws UnknownHostException {

        RemAnalisisTramiteRegistroProfesional analisisTramiteRegistroProfesional = new RemAnalisisTramiteRegistroProfesional();
        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        String ver = obtenerParametros(Long.parseLong("1"));
        int parametro = Integer.parseInt(ver);
        Optional<RemCatalogo> estado =null;

        Date fechaAsigna = clsUtilitario.getProximoDiaHabil(calendar.getTime(), parametro);

        try {

            RemAnalista analistaCod = getAnalistaAsignado();

            BigInteger valorSecuencial = new BigInteger(analistaCod.getNroTramites().toString());
            BigInteger valorSecuencialMes = new BigInteger(analistaCod.getNroTramitesMes().toString());
            BigInteger valorSuma = new BigInteger("1");

            analistaCod.setNroTramites(valorSecuencial.add(valorSuma));
            analistaCod.setNroTramitesMes(valorSecuencialMes.add(valorSuma));
            estado = servicioCatalogo.obtenerById(Long.parseLong("223"));

            if (proceso.equals("1")){//Reingresado
                estado = servicioCatalogo.obtenerById(Long.parseLong("225"));
            }

            if (analistaCod != null) {
                //Armamos la entidad de Asignación de Analistas
                analisisTramiteRegistroProfesional.setRegistroProfesionalId(profesionalCreado.get());
                analisisTramiteRegistroProfesional.setAnalistaId(analistaCod);
                analisisTramiteRegistroProfesional.setEstado(estado.get());

                analisisTramiteRegistroProfesional.setFechaAsigna(fecha);

                //analisisTramiteRegistroProfesional.setFechaCreacion(fecha);
                analisisTramiteRegistroProfesional.setFechaModificacion(fecha);
                analisisTramiteRegistroProfesional.setFechaVigencia(fechaAsigna);

                //Datos Creacion
                analisisTramiteRegistroProfesional.setUsuarioCreacion(registroProfesional.getUsuarioCreacion());
                analisisTramiteRegistroProfesional.setTerminalCreacion(registroProfesional.getTerminalCreacion());
                analisisTramiteRegistroProfesional.setFechaCreacion(registroProfesional.getFechaCreacion());

                //Datos Modificacion
                analisisTramiteRegistroProfesional.setUsuarioModificacion(registroProfesional.getUsuarioModificacion());
                analisisTramiteRegistroProfesional.setTerminalModificacion(registroProfesional.getTerminalModificacion());
                analisisTramiteRegistroProfesional.setFechaModificacion(registroProfesional.getFechaModificacion());

                if (servicioAnalista.guardarActualizarAnalistas(analistaCod)) {
                    analisisTramiteRegistroProfesional = analisisTramiteRegistroProfesionalRepository.save(analisisTramiteRegistroProfesional);
                } else {
                    analisisTramiteRegistroProfesional = null;
                    throw new Exception();
                }

            } else {
                analisisTramiteRegistroProfesional = null;
                analisisTramiteRegistroProfesional.setEstado(null);
                analisisTramiteRegistroProfesionalRepository.save(analisisTramiteRegistroProfesional);
            }

        } catch (Exception e) {
            analisisTramiteRegistroProfesional.setEstado(null);
            analisisTramiteRegistroProfesionalRepository.save(analisisTramiteRegistroProfesional);
            return null;
        }
        return analisisTramiteRegistroProfesional;
    }

    public RemAnalista getAnalistaAsignado() {
        RemAnalista usuarioAnalista = new RemAnalista();
        Optional<RemAnalista> analista = null;
        RemAnalista analistaDefault = new RemAnalista();
        try {

            var analistasActivos = servicioAnalista.getListaAnalistasActivos();

            if (analistasActivos.size() != 0 && analistasActivos != null) {

                //Pasar set a una lista
                List<DtoAsignacionAnalista> listaAsignaciones = new ArrayList<DtoAsignacionAnalista>();
                listaAsignaciones.addAll(analistasActivos);

                var analistaAsigando = listaAsignaciones.get(0);
                if (analistaAsigando != null) {
                    usuarioAnalista.setAnalistaId(analistaAsigando.getAnalistaId());
                    analista = servicioAnalista.obtenerById(usuarioAnalista.getAnalistaId());

                }

            } else {
                analistaDefault = servicioAnalista.getAnalistaByDefault();
                if (analistaDefault != null) {
                    usuarioAnalista = analistaDefault;
                    return usuarioAnalista;
                }

            }

        } catch (Exception e) {

            return null;
        }
        return analista.get();

    }

    public List<RemAnalisisTramiteRegistroProfesional> obtener() {
        try {
            return (List<RemAnalisisTramiteRegistroProfesional>) analisisTramiteRegistroProfesionalRepository.findAll();
        } catch (Exception e) {
            return (List<RemAnalisisTramiteRegistroProfesional>) analisisTramiteRegistroProfesionalRepository.findAll();
        }

    }

    public boolean createUpdate(RemAnalisisTramiteRegistroProfesional analisisTramiteRegistroProfesional) {
        boolean respuesta = false;
        try {
            analisisTramiteRegistroProfesionalRepository.save(analisisTramiteRegistroProfesional);
            respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();

        }

        return respuesta;
    }

    @Transactional
    public boolean actualizarTramiteRegistroProfesional(List<DtoDatosActualizarAnalista> dtoDatosActualizarAnalista) {
        boolean respuesta = false;
        Date fecha = new Date();
        RemTramiteReasignacion remTramiteReasignacion = new RemTramiteReasignacion();
        Set<DtoUsuarioAnalista> dtoUsuarioAnalista = new HashSet<>();

        try {

            for (var lista : dtoDatosActualizarAnalista) {
                analisisTramiteRegistroProfesionalRepository.actualizarTramiteRegistroProfesional(lista.getRegistroProfesionalId(), lista.getAnalistaDespues());
                Optional<RemAnalisisTramiteRegistroProfesional> tramite = obtenerTramiteporRegistro(lista.getRegistroProfesionalId());
                Optional<RemAnalista> codigoAnalistaAntes = analistaRepository.findById(lista.getAnalistaAntes());
                Optional<RemAnalista> codigoAnalistaDespues = analistaRepository.findById(lista.getAnalistaDespues());
                dtoUsuarioAnalista = servicioUsuarios.obtenerByCedula(lista.getCedulaUsuarioReasignacion());

                Optional<RemUsuarios> codigoUsuario = servicioUsuarios.obtenerById(dtoUsuarioAnalista.iterator().next().getUsuarioId());

                remTramiteReasignacion.setTramiteReasignacionId(tramite.get().getAnalsisTramiteRegistroProfesionalId());
                remTramiteReasignacion.setAnalistaAntes(codigoAnalistaAntes.get());
                remTramiteReasignacion.setAnalistaDespues(codigoAnalistaDespues.get());
                remTramiteReasignacion.setMotivo(lista.getMotivoCambio());
                remTramiteReasignacion.setFechaReasignacion(fecha);
                remTramiteReasignacion.setUsuarioReasignacion(codigoUsuario.get().getNroIdentificacion());
                remTramiteReasignacion.setTerminalReasignacion(lista.getEquipoReasignacion());

                servicioTramiteReasignacion.reasignacionRegistro(remTramiteReasignacion);

                respuesta = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;

        }

        return respuesta;
    }

    public Optional<RemAnalisisTramiteRegistroProfesional> obtenerById(Long id) {
        try {
            return analisisTramiteRegistroProfesionalRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Optional<RemAnalisisTramiteRegistroProfesional> obtenerTramiteporRegistro(Long tramite) {
        try {
            return analisisTramiteRegistroProfesionalRepository.obtenerTramiteporRegistro(tramite);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Set<DtoBandejaAnalista> obtenerAnalisis(String nroIdentificacion) {
        try {
            return analisisTramiteRegistroProfesionalRepository.obtenerBandejaporAnalista(nroIdentificacion);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String obtenerParametros(Long codigo) {
        try {
            return analisisTramiteRegistroProfesionalRepository.obtenerParametros(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String verificaFechaFeriado(Date fechaDato) {
        try {
            return analisisTramiteRegistroProfesionalRepository.verificaFechaFeriado(fechaDato);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

//    public Set<DtoConsultaRegistros> obtenerRegistrosCiudadano(String nroIdentificacion) {
//        try {
//            return analisisTramiteRegistroProfesionalRepository.obtenerRegistrosCiudadano(nroIdentificacion);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
    public List<DtoConsultaRegistros> obtenerRegistrosCiudadano(String nroIdentificacion) {
        List<DtoConsultaRegistros> dtoConsultaRegistrosRespuesta = new ArrayList<>();
        try {
            List<String> datos = analisisTramiteRegistroProfesionalRepository.obtenerRegistrosCiudadano(nroIdentificacion);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (int i = 0; i < datos.size(); i++) {
                var data = datos.get(i);
                String[] split = data.split(",");
                List<String> listaDatos = new ArrayList<>();

                for (int j = 0; j < split.length; j++) {

                    listaDatos.add(split[j]);
                }

                DtoConsultaRegistros dtoConsultaRegistros = new DtoConsultaRegistros();
                dtoConsultaRegistros.setSubregistro(Long.parseLong(listaDatos.get(0).toString()));
                dtoConsultaRegistros.setRegistroProfesionalId(Long.parseLong(listaDatos.get(1).toString()));
                dtoConsultaRegistros.setNroRegistro(listaDatos.get(2).toString());
                dtoConsultaRegistros.setDescripcion(listaDatos.get(3).toString());
                Date fechaCreacion = sdf.parse(listaDatos.get(4).toString());
                dtoConsultaRegistros.setFechaCreacion(fechaCreacion);
                dtoConsultaRegistros.setEstado(listaDatos.get(5).toString());
                dtoConsultaRegistros.setDenominacion(listaDatos.get(6).toString());
                dtoConsultaRegistrosRespuesta.add(dtoConsultaRegistros);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return dtoConsultaRegistrosRespuesta;

    }

    public Set<DtoConsultaRegistros> obtenerRegistroMail(String nroIdentificacion, Long usuarioId, Long registroProfesionalId) {
        try {
            return analisisTramiteRegistroProfesionalRepository.obtenerRegistroMail(nroIdentificacion, usuarioId, registroProfesionalId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Set<DtoBandejaAnalista> obtenerNroRegistrosAnalista() {
        DtoBandejaAnalista dtoBandejaAnalista = new DtoBandejaAnalista();
        try {
            return analisisTramiteRegistroProfesionalRepository.obtenerNroRegistrosAnalista();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Set<DtoBandejaAnalista> obtenerRegistrosPorFiltros(String nroIdentificacion, Long estadoRegistro, String fechaInicio, String fechaFin) {
        try {
            return analisisTramiteRegistroProfesionalRepository.obtenerRegistrosPorFiltros(nroIdentificacion, estadoRegistro, fechaInicio, fechaFin);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            //return analisisTramiteRegistroProfesionalRepository.obtenerRegistrosPorFilros(nroIdentificacion,estadoRegistro,fechaInicio,fechaFin);
        }

    }

}
