/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import gob.mdmq.remetfu.Entidades.RemAnalisisTramiteRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemPerfilAcademico;
import gob.mdmq.remetfu.Entidades.RemRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.Entidades.RemTituloProfesional;
import gob.mdmq.remetfu.dto.DtoDatosModificacion;
import gob.mdmq.remetfu.dto.DtoDatosCreacion;
import gob.mdmq.remetfu.dto.DtoRegistroEspecialista;
import gob.mdmq.remetfu.dto.DtoRegistroProfesional;
import gob.mdmq.remetfu.dto.DtoValidarRegistro;
import gob.mdmq.remetfu.dto.fileserver.DtoArchivo;
import gob.mdmq.remetfu.dto.fileserver.DtoDatosAuditoria;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.ParametroRepository;
import gob.mdmq.remetfu.repository.PerfilAcademicoRepository;
import gob.mdmq.remetfu.repository.RegistroProfesionalRepository;
import gob.mdmq.remetfu.repository.TituloProfesionalRepository;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import gob.mdmq.remetfu.utilitarios.ClsUtilitario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioRegistroProfesional {

    @Autowired
    private RegistroProfesionalRepository registroProfesionalRepository;

    @Autowired
    private ServicioAnalisisTramiteRegistroProfesional servicioAnalisisTramiteRegistroProfesional;
    @Autowired
    private ClsLog logArchivos;
    @Autowired
    private ServicioNomenclatura servicioNomenclatura;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @Autowired
    private ServicioWSO2 servicioWSO2;
    @Autowired
    private ServicioUtilitario servicioUtilitario;
    @Autowired
    private PerfilAcademicoRepository perfilAcademicoRepository;
    @Autowired
    private TituloProfesionalRepository tituloProfesionalRepository;
    @Autowired
    private ParametroRepository parametroRepository;
    @Autowired
    private ServicioSubtipoRegistro servicioSubtipoRegistro;

    DtoDatosAuditoria dtoDatosAuditoria = new DtoDatosAuditoria();
    DtoArchivo dtoArchivo = new DtoArchivo();

    @Transactional //Realizar control de transacciones
    public RemRegistroProfesional guardarProfesional(DtoRegistroProfesional dtoRegistroProfesional, Long proceso) {

        boolean respuesta = false;
        RemRegistroProfesional registroProfesional = new RemRegistroProfesional();
        String idProfesionalCreado = "";
        Optional<RemRegistroProfesional> profesionalCreado;
        RemAnalisisTramiteRegistroProfesional asignarAnalista = null;
        dtoDatosAuditoria.setDireccionIP(dtoRegistroProfesional.getTerminalCreacion());
        dtoDatosAuditoria.setUsuario(dtoRegistroProfesional.getUsuarioCreacion());
        dtoArchivo.setDatosAuditoria(dtoDatosAuditoria);
        dtoArchivo.setObservacion("Se envia");
        ArrayList visaTrabajoLista = null;

        try {
            String terminalModificacion = ClsUtilitario.getDireccionIP();
            String usuarioModificacion = "usuarioModificacion";

            Date fecha = new Date();
            registroProfesional.setFechaCreacion(fecha);
            registroProfesional.setFechaModificacion(fecha);
            registroProfesional.setFechaInactivo(fecha);
            registroProfesional.setSecuencialTmp(0);
            registroProfesional.setSecuencialFinal(0);

            if (proceso.equals("1")) {//
                registroProfesional.setRegistroProfesionalId(dtoRegistroProfesional.getRegistroProfesionalIdActualiza());
            }
            if (dtoRegistroProfesional.getSubtipoRegistroId().getSubtipoRegistroId().toString().equals("11")) {
                registroProfesional.setAgremiado("NO");
            } else {
                registroProfesional.setAgremiado(dtoRegistroProfesional.getAgremiado());
            }
            registroProfesional.setUsuarioId(dtoRegistroProfesional.getUsuarioId());
            registroProfesional.setParroquia(dtoRegistroProfesional.getParroquia());
            registroProfesional.setEstado(dtoRegistroProfesional.getEstado());
            registroProfesional.setUsuarioId(dtoRegistroProfesional.getUsuarioId());
            registroProfesional.setSubtipoRegistroId(dtoRegistroProfesional.getSubtipoRegistroId());
            registroProfesional.setAcuerdoResponsabilidad(dtoRegistroProfesional.getAcuerdoResponsabilidad());
            registroProfesional.setBarrio(dtoRegistroProfesional.getBarrio());
            registroProfesional.setCalleNumero(dtoRegistroProfesional.getCalleNumero());
            registroProfesional.setCallePrincipal(dtoRegistroProfesional.getCallePrincipal());
            registroProfesional.setCalleReferencia1(dtoRegistroProfesional.getCalleReferencia1());
            registroProfesional.setCalleReferencia2(dtoRegistroProfesional.getCalleReferencia2());
            registroProfesional.setCalleSecundaria(dtoRegistroProfesional.getCalleSecundaria());
            registroProfesional.setDiasInactivo(dtoRegistroProfesional.getDiasInactivo());
            registroProfesional.setNombreGremio(dtoRegistroProfesional.getNombreGremio());
            registroProfesional.setUsuarioCreacion(dtoRegistroProfesional.getUsuarioCreacion());
            registroProfesional.setUsuarioModificacion(dtoRegistroProfesional.getUsuarioModificacion());
            registroProfesional.setExperienciaLaboral(dtoRegistroProfesional.getExperienciaLaboral());
            registroProfesional.setTerminalCreacion(dtoRegistroProfesional.getTerminalCreacion());
            registroProfesional.setTerminalModificacion(dtoRegistroProfesional.getTerminalModificacion());
            if (!dtoRegistroProfesional.getVisaArchivo().toString().equals("")) {

                visaTrabajoLista = (ArrayList) dtoRegistroProfesional.getVisaArchivo();

                var visa = visaTrabajoLista.get(0);
                Map<String, Object> map = new HashMap<String, Object>();
                map = (Map<String, Object>) visa;
                dtoArchivo.setNombre(map.get("nombreArchivo").toString());
                dtoArchivo.setContenido(map.get("base64").toString());
                var visaArchivo = servicioWSO2.guardarArchivo(dtoArchivo);
                if (servicioUtilitario.guardarArchivo(visaArchivo, dtoRegistroProfesional.getTerminalCreacion(), dtoRegistroProfesional.getUsuarioCreacion())) {
                    registroProfesional.setVisatrabajo(visaArchivo.substring(1, visaArchivo.length() - 1));
                }
            }

            logArchivos.RegistrarProceso("ServicioRegistroProfesional", "Pasa datos de auditoria", "guardarProfesional");

            var registroProfesionalCreado = registroProfesionalRepository.save(registroProfesional);

            if (registroProfesionalCreado != null) {
                guardarTitulosSenecyt(registroProfesionalCreado.getRegistroProfesionalId(), dtoRegistroProfesional.getTituloSENESCYT(), registroProfesional);
                if (dtoRegistroProfesional.getPerfilAcademico() != null && !dtoRegistroProfesional.getPerfilAcademico().equals("")) {
                    guardarPerfilAcademico(registroProfesionalCreado.getRegistroProfesionalId(), dtoRegistroProfesional.getPerfilAcademico(), dtoRegistroProfesional.getDocumentoFormacion(), registroProfesional);

                }
                idProfesionalCreado = registroProfesionalCreado.getRegistroProfesionalId().toString();
                profesionalCreado = registroProfesionalRepository.findById(Long.parseLong(idProfesionalCreado));
                DtoDatosCreacion datosCreacion = new DtoDatosCreacion(registroProfesionalCreado.getUsuarioCreacion(), registroProfesionalCreado.getTerminalCreacion(), fecha);
                DtoDatosModificacion datosModificacion = new DtoDatosModificacion(usuarioModificacion, terminalModificacion, fecha);

                asignarAnalista = servicioAnalisisTramiteRegistroProfesional.guardarAsignacion(profesionalCreado, registroProfesional, proceso);
                if (asignarAnalista != null) {

                    var secuencialTemp = servicioNomenclatura.obtenerSecuencialTemp(registroProfesional.getSubtipoRegistroId().getSubtipoRegistroId());

                    if (secuencialTemp != Long.parseLong("-1")) {
                        Long sumaSecuencia = secuencialTemp + 1;

                        if (servicioNomenclatura.actualizaSecuencialTemp(sumaSecuencia, registroProfesional.getSubtipoRegistroId().getSubtipoRegistroId(), registroProfesional.getUsuarioId().getUsuarioId(),
                                registroProfesionalCreado.getRegistroProfesionalId())) {

                            respuesta = true;
                        } else {

                            respuesta = false;
                            registroProfesional.setFechaCreacion(null);
                            registroProfesionalRepository.save(registroProfesional);
                        }
                    }
                }

            } else {
                respuesta = false;
                registroProfesional = null;
            }
            logArchivos.RegistrarProceso("ServicioRegistroProfesional", "Datos guardados correctamente" + 1, "guardarProfesional");

        } catch (Exception e) {

            logArchivos.RegistrarError("ServicioRegistroProfesional", "Error" + 0, "guardarProfesional");
            e.printStackTrace();
            registroProfesional = null;
        }
        return registroProfesional;
    }

    public void guardarPerfilAcademico(Long registroProfesionalId, Long perfilAcademicoId, Object documentoAcredita,
            RemRegistroProfesional registroProfesional) throws JsonProcessingException, NoSuchFieldException {

        RemPerfilAcademico perfilAcademicoObj = new RemPerfilAcademico();
        ArrayList listaPerfil = null;
        Date fecha = new Date();
        dtoDatosAuditoria.setDireccionIP(registroProfesional.getTerminalCreacion());
        dtoDatosAuditoria.setUsuario(registroProfesional.getUsuarioCreacion());
        dtoArchivo.setDatosAuditoria(dtoDatosAuditoria);
        dtoArchivo.setObservacion("Se envia");
        ArrayList perfilAcademicoLista = null;
        try {

            var tipoCatalogoId = perfilAcademicoId;//properties.get("tipoCatalogoId");
            var registroCreado = registroProfesionalRepository.findById(registroProfesionalId);
            var perfilAcademico = catalogoRepository.findById(Long.parseLong(tipoCatalogoId.toString()));

            perfilAcademicoObj.setRegistroProfesionalId(registroCreado.get());
            perfilAcademicoObj.setCatalogoId(perfilAcademico.get());
            perfilAcademicoObj.setEstado("ACT");
            perfilAcademicoObj.setFechaCreacion(fecha);
            perfilAcademicoObj.setFechaModificacion(fecha);
            perfilAcademicoObj.setFechaRegistro(fecha);
            perfilAcademicoObj.setDocumentoAcredita("");
            perfilAcademicoObj.setTerminalCreacion(registroProfesional.getTerminalCreacion());
            perfilAcademicoObj.setTerminalModificacion(registroProfesional.getTerminalModificacion());
            perfilAcademicoObj.setUsuarioCreacion(registroProfesional.getUsuarioCreacion());
            perfilAcademicoObj.setUsuarioModificacion(registroProfesional.getUsuarioModificacion());

            if (!documentoAcredita.toString().equals("")) {

                perfilAcademicoLista = (ArrayList) documentoAcredita;

                var documento = perfilAcademicoLista.get(0);
                Map<String, Object> map = new HashMap<String, Object>();
                map = (Map<String, Object>) documento;
                dtoArchivo.setNombre(map.get("nombreArchivo").toString());
                dtoArchivo.setContenido(map.get("base64").toString());
                var documentoAcreditaArchivo = servicioWSO2.guardarArchivo(dtoArchivo);
                if (servicioUtilitario.guardarArchivo(documentoAcreditaArchivo, registroProfesional.getTerminalCreacion(), registroProfesional.getUsuarioCreacion())) {
                    perfilAcademicoObj.setDocumentoAcredita(documentoAcreditaArchivo.substring(1, documentoAcreditaArchivo.length() - 1));
                }

            }

            perfilAcademicoRepository.save(perfilAcademicoObj);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void guardarTitulosSenecyt(Long registroProfesionalId, Object tituloUniversitario, RemRegistroProfesional registroProfesional) {
        RemTituloProfesional tituloProfesionalObj = new RemTituloProfesional();
        Date fecha = new Date();

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map = (Map<String, Object>) tituloUniversitario;
            var registroCreado = registroProfesionalRepository.findById(registroProfesionalId);

            tituloProfesionalObj.setRegistroProfesionalId(registroCreado.get());
            tituloProfesionalObj.setInstitucionTitulo(map.get("ies").toString());
            tituloProfesionalObj.setFechaCreacion(fecha);
            tituloProfesionalObj.setFechaModificacion(fecha);
            tituloProfesionalObj.setFechaRegistro(fecha);
            tituloProfesionalObj.setNivelTitulo(map.get("nivel").toString());
            tituloProfesionalObj.setNombreTitulo(map.get("nombreTitulo").toString());
            tituloProfesionalObj.setNroRegistro(map.get("numeroRegistro").toString());
            tituloProfesionalObj.setReconocidoPor("SENECYT");
            tituloProfesionalObj.setTipoTitulo(map.get("subArea").toString());
            tituloProfesionalObj.setTerminalCreacion(registroProfesional.getTerminalCreacion());
            tituloProfesionalObj.setTerminalModificacion(registroProfesional.getTerminalModificacion());
            tituloProfesionalObj.setUsuarioCreacion(registroProfesional.getUsuarioCreacion());
            tituloProfesionalObj.setUsuarioModificacion(registroProfesional.getUsuarioModificacion());

            tituloProfesionalRepository.save(tituloProfesionalObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<RemRegistroProfesional> obtener() {
        try {
            return (List<RemRegistroProfesional>) registroProfesionalRepository.findAll();
        } catch (Exception e) {
            return (List<RemRegistroProfesional>) registroProfesionalRepository.findAll();
        }
    }

    public RemRegistroProfesional createUpdate(RemRegistroProfesional registroProfesional) {
        try {
            return registroProfesionalRepository.save(registroProfesional);
        } catch (Exception e) {
            return registroProfesionalRepository.save(registroProfesional);
        }
    }

    public Optional<RemRegistroProfesional> obtenerById(Long id) {
        try {
            return registroProfesionalRepository.findById(id);
        } catch (Exception e) {
            return registroProfesionalRepository.findById(id);
        }
    }

    public DtoRegistroEspecialista obtenerDatosRegistroEspecialistas(Long id) throws ParseException {

        DtoRegistroEspecialista dtoRegistroEspecialista = new DtoRegistroEspecialista();
        try {
            List<String> datos = registroProfesionalRepository.obtenerPdf(id);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            var data = datos.get(0);
            String[] split = data.split(",");
            List<String> listaDatos = new ArrayList<>();

            for (int i = 0; i < split.length; i++) {

                listaDatos.add(split[i]);
            }

            dtoRegistroEspecialista.setUsuarioId(Long.parseLong(listaDatos.get(0).toString()));
            char tipoIdentificacion = listaDatos.get(1).toString().charAt(0);
            dtoRegistroEspecialista.setTipoIdentificacion(tipoIdentificacion);
            dtoRegistroEspecialista.setNroIdentificacion(listaDatos.get(2).toString().trim());
            dtoRegistroEspecialista.setDenominacion(listaDatos.get(3).toString());
            dtoRegistroEspecialista.setMail(listaDatos.get(4).toString());
            dtoRegistroEspecialista.setDireccion(listaDatos.get(5).toString());
            dtoRegistroEspecialista.setTelefono(listaDatos.get(6).toString());
            dtoRegistroEspecialista.setMovil(listaDatos.get(7).toString());
            dtoRegistroEspecialista.setAceptacionMedios(listaDatos.get(8).toString());
            dtoRegistroEspecialista.setEstado(listaDatos.get(9).toString());
            dtoRegistroEspecialista.setCim(listaDatos.get(10).toString());
            dtoRegistroEspecialista.setClave(listaDatos.get(11).toString());
            dtoRegistroEspecialista.setTipoUsuario(Long.parseLong(listaDatos.get(12).toString()));
            dtoRegistroEspecialista.setTipoUsuarioDesc(listaDatos.get(13).toString());
            dtoRegistroEspecialista.setAdmZonal(Long.parseLong(listaDatos.get(14).toString()));
            dtoRegistroEspecialista.setAdmZonalDesc(listaDatos.get(15).toString());
            Date fechaNacimiento = sdf.parse(listaDatos.get(16).toString());
            dtoRegistroEspecialista.setFechaNacimiento(fechaNacimiento);
            dtoRegistroEspecialista.setNacionalidad(Long.parseLong(listaDatos.get(17).toString()));
            dtoRegistroEspecialista.setNacionalidadDesc(listaDatos.get(18).toString());
            dtoRegistroEspecialista.setGenero(Long.parseLong(listaDatos.get(19).toString()));
            dtoRegistroEspecialista.setGeneroDesc(listaDatos.get(20).toString());
            dtoRegistroEspecialista.setDiscapacidad(listaDatos.get(21).toString());
            dtoRegistroEspecialista.setRegistroProfesionalId(Long.parseLong(listaDatos.get(22).toString()));
            dtoRegistroEspecialista.setPathVisatrabajo(listaDatos.get(23).toString());
            dtoRegistroEspecialista.setBarrio(listaDatos.get(24).toString());
            dtoRegistroEspecialista.setCallePrincipal(listaDatos.get(25).toString());
            dtoRegistroEspecialista.setCalleNumero(listaDatos.get(26).toString());
            dtoRegistroEspecialista.setCalleSecundaria(listaDatos.get(27).toString());
            dtoRegistroEspecialista.setCalleReferencia1(listaDatos.get(28).toString());
            dtoRegistroEspecialista.setCalleReferencia2(listaDatos.get(29).toString());
            dtoRegistroEspecialista.setEstadoRegistro(listaDatos.get(30).toString());
            dtoRegistroEspecialista.setAgremiado(listaDatos.get(31).toString());
            dtoRegistroEspecialista.setNombreGremio(listaDatos.get(32).toString());
            Date fechaInactivo = sdf.parse(listaDatos.get(33).toString());
            dtoRegistroEspecialista.setFechaInactivo(fechaInactivo);
            dtoRegistroEspecialista.setDiasInactivo(Integer.parseInt(listaDatos.get(34).toString()));
            dtoRegistroEspecialista.setSecuencialTmp(Long.parseLong(listaDatos.get(35).toString()));
            dtoRegistroEspecialista.setSecuencialFinal(Long.parseLong(listaDatos.get(36).toString()));
            dtoRegistroEspecialista.setAcuerdoResponsabilidad(listaDatos.get(37).toString());
            dtoRegistroEspecialista.setSubtipoRegistro(Long.parseLong(listaDatos.get(38).toString()));
            dtoRegistroEspecialista.setSubtipoRegistroDesc(listaDatos.get(39).toString());
            dtoRegistroEspecialista.setParroquia(Long.parseLong(listaDatos.get(40).toString()));
            dtoRegistroEspecialista.setParroquiaDesc(listaDatos.get(41).toString());
            Date fechaRegistro = sdf.parse(listaDatos.get(42) == null ? listaDatos.get(42).toString() : "1995-01-01 00:00:00");
            dtoRegistroEspecialista.setFechaRegistro(fechaRegistro);
            dtoRegistroEspecialista.setInstitucionEmite(listaDatos.get(43) == null ? "" : listaDatos.get(43).toString());
            dtoRegistroEspecialista.setPerfilAcademico(listaDatos.get(44) == null ? Long.MIN_VALUE : Long.parseLong(listaDatos.get(44)));
            dtoRegistroEspecialista.setPerfilAcademicoDesc(listaDatos.get(45) == null ? "" : listaDatos.get(45).toString());
            dtoRegistroEspecialista.setNroRegistro(listaDatos.get(46).toString() == "" ? "" : listaDatos.get(46).toString());

            Date fechaRegistroTitulo = sdf.parse(listaDatos.get(47) == null ? listaDatos.get(47).toString() : "1995-01-01 00:00:00");

            dtoRegistroEspecialista.setFechaRegistroTitulo(fechaRegistroTitulo);
            dtoRegistroEspecialista.setNombreTitulo(listaDatos.get(48).toString() == "" ? "" : listaDatos.get(48).toString());
            dtoRegistroEspecialista.setInstitucionTitulo(listaDatos.get(49).toString() == "" ? "" : listaDatos.get(49).toString());
            dtoRegistroEspecialista.setNivelTitulo(listaDatos.get(50).toString() == "" ? "" : listaDatos.get(50).toString());
            dtoRegistroEspecialista.setTipoTitulo(listaDatos.get(51).toString() == "" ? "" : listaDatos.get(51).toString());
            dtoRegistroEspecialista.setReconocidoPor(listaDatos.get(52).toString() == "" ? "" : listaDatos.get(52).toString());
            dtoRegistroEspecialista.setNombres(listaDatos.get(53).toString());
            dtoRegistroEspecialista.setApellidos(listaDatos.get(54).toString());

            Date fechaAsigna = sdf.parse(listaDatos.get(55) != null ? listaDatos.get(55).toString() : "1995-01-01 00:00:00");
            dtoRegistroEspecialista.setFechaAsigna(fechaAsigna);
            Date fechaVigencia = sdf.parse(listaDatos.get(56) != null ? listaDatos.get(56).toString() : "1995-01-01 00:00:00");
            dtoRegistroEspecialista.setFechaVigencia(fechaVigencia);
            Date fechaRechazo = sdf.parse(listaDatos.get(57) != null ? listaDatos.get(57).toString() : "1995-01-01 00:00:00");
            dtoRegistroEspecialista.setFechaRechazo(fechaRechazo);
            Date fechaAprobacion = sdf.parse(listaDatos.get(58) != null ? listaDatos.get(58).toString() : "1995-01-01 00:00:00");
            dtoRegistroEspecialista.setFechaAprobacion(fechaAprobacion);
            Date fechaDevolucion = sdf.parse(listaDatos.get(59) != null ? listaDatos.get(59).toString() : "1995-01-01 00:00:00");
            dtoRegistroEspecialista.setFechaDevolucion(fechaDevolucion);

            dtoRegistroEspecialista.setNovedadAprobacion(listaDatos.get(60).toString());
            dtoRegistroEspecialista.setMotivoDevolucion(listaDatos.get(61).toString());
            dtoRegistroEspecialista.setMotivoRechazo(listaDatos.get(62).toString());
            dtoRegistroEspecialista.setNroRegistroProfesional(listaDatos.get(63).toString());
            dtoRegistroEspecialista.setMailPersonal(listaDatos.get(64).toString());
            dtoRegistroEspecialista.setEstadoRegistros(listaDatos.get(65).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoRegistroEspecialista;

    }

    public DtoValidarRegistro validarIngreso(String nroIdentificacion, Long subtipoRegistro) {

        DtoValidarRegistro dtoValidarRegistro = new DtoValidarRegistro();

        try {
            List<String> datos = registroProfesionalRepository.validarIngreso(nroIdentificacion, subtipoRegistro);
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

    public DtoValidarRegistro validarIngresoPagado(String nroIdentificacion) {

        DtoValidarRegistro dtoValidarRegistro = new DtoValidarRegistro();

        try {
            List<String> datos = registroProfesionalRepository.validarIngresoPagado(nroIdentificacion);

            dtoValidarRegistro.setMensajeValidacion(datos.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoValidarRegistro;
    }

    public byte[] obtenerArchivoRegistroProfesional(Long registroProfesionalId) {

        try {
            var registroProfesional = perfilAcademicoRepository.obtenerArchivoRegistroProfesional(registroProfesionalId);

            if (registroProfesional != null) {
                var archivoId = registroProfesional.getDocumentoAcredita();
                var archivoRegistro = servicioWSO2.getArchivo(archivoId);

                Map<String, Object> map = new HashMap<String, Object>();
                map = (Map<String, Object>) archivoRegistro;
                var archivoB64 = map.get(("Contenido"));
                byte[] b64 = Base64.getDecoder().decode(archivoB64.toString());

                return b64;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public String mensajePreRegistro(DtoRegistroEspecialista registroEspecialista) {
        var mensaje = "";
        Optional<RemSubtipoRegistro> subTipoRegistroObj = servicioSubtipoRegistro.obtenerById(registroEspecialista.getSubtipoRegistro());
        var valorSalarioBasicoC = parametroRepository.obtenerParametro(Long.parseLong("11"));
        Double valorSalarioBasicoN = Double.parseDouble(valorSalarioBasicoC);
        try {
            mensaje = "Se ha registrado correctamente el " + registroEspecialista.getNroRegistroProfesional() + ". Recuerde que cuando se apruebe su pedido se"
                    + " remitirá una orden de pago por el valor de $ " + (valorSalarioBasicoN * subTipoRegistroObj.get().getValor1().longValue() / 100.00) + ", la cual deberá ser cancelada para obtener"
                    + " el REGISTRO. Se remitirá mediante correo electrónico el avance del su pedido.";
            return mensaje;
        } catch (Exception e) {
            return mensaje;
        }
    }

}
