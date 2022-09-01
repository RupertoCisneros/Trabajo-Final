/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemAnimalTutor;
import gob.mdmq.remetfu.Entidades.RemArchivos;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.Entidades.RemTipoAnimalTutor;
import gob.mdmq.remetfu.Entidades.RemTutorMascota;
import gob.mdmq.remetfu.Entidades.RemTutoresComunitarios;
import gob.mdmq.remetfu.dto.DtoAnimalTutor;
import gob.mdmq.remetfu.dto.DtoConsultaRegistros;
import gob.mdmq.remetfu.dto.fileserver.DtoArchivo;
import gob.mdmq.remetfu.dto.fileserver.DtoDatosAuditoria;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import gob.mdmq.remetfu.dto.DtoAnimalTutor;
import gob.mdmq.remetfu.dto.DtoConsultaRegistros;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.fileserver.DtoArchivo;
import gob.mdmq.remetfu.dto.fileserver.DtoDatosAuditoria;
import gob.mdmq.remetfu.repository.AnimalTutorRepository;
import gob.mdmq.remetfu.repository.ArchivosRepository;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.MicrochipMascotaRepository;
import gob.mdmq.remetfu.repository.ParametroRepository;
import gob.mdmq.remetfu.repository.TipoAnimalTutorRepository;
import gob.mdmq.remetfu.repository.TutorComunitarioRepository;
import gob.mdmq.remetfu.repository.TutorMascotaRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioAnimalTutor {

    @Autowired
    private AnimalTutorRepository animalTutorRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @Autowired
    private MicrochipMascotaRepository microchipMascotaRepository;
    @Autowired
    private ArchivosRepository archivosRepository;
    @Autowired
    private TutorMascotaRepository tutorMascotaRepository;
    @Autowired
    private ServicioUtilitario servicioUtilitario;
    @Autowired
    private ServicioNomenclatura servicioNomenclatura;
    @Autowired
    private ServicioCatalogo servicioCatalogo;
    @Autowired
    private ServicioWSO2 servicioWSO2;
    @Autowired
    private TutorComunitarioRepository tutorComunitarioRepository;
    @Autowired
    private TipoAnimalTutorRepository tipoAnimalTutorRepository;
    @Autowired
    private ParametroRepository parametroRepository;
    @Autowired
    private ServicioSubtipoRegistro servicioSubtipoRegistro;
    @Autowired
    private ServicioSAO servicioSao;
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private ServicioMail servicioMail;
    @Autowired
    private UsuariosRepository usuariosRepository;

    RemArchivos identificacionFotografica1Id = null;
    RemArchivos identificacionFotografica2Id = null;

    public Optional<RemAnimalTutor> obtenerById(Long id) {
        return animalTutorRepository.findById(id);

    }

    public List<RemAnimalTutor> obtenerTutorAnimalTodos() {
        return (List<RemAnimalTutor>) animalTutorRepository.findAll();
    }

    @Transactional
    public RemAnimalTutor crearAnimalTutor(Map<String, Object[]> models) {
        boolean respuesta = false;

        RemAnimalTutor animalTutorObj = new RemAnimalTutor();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList listaIdentificacionFotografica = null;
        ArrayList listaTipoAnimal = null;
        ArrayList listaTutoresComunitarios = null;
        RemTutorMascota tutorId = null;
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        Map<String, Object> map4 = new HashMap<String, Object>();
        Map<String, Object> map5 = new HashMap<String, Object>();
        Map<String, Object> map6 = new HashMap<String, Object>();
        Map<String, Object> map7 = new HashMap<String, Object>();
        RemArchivos esterilizacionId, vacunacionId, identificacionVisibleId, examenClinico = null;
        Date fechaAuditoria = new Date();
        Optional<RemCatalogo> motivoFallecimientoId, pruebaComportamientoId = null;
        RemMicrochipMascota microchipMascotaId = null;
        Long sumaSecuencia = Long.MAX_VALUE;

        try {

            Map<String, Object[]> map = new HashMap<String, Object[]>();
            map = (Map<String, Object[]>) models;
            var animalTutor = map.get("animalTutor");
            var datosIngreso = map.get("datosIngreso");

            map2 = (Map<String, Object>) animalTutor[0];
            map3 = (Map<String, Object>) datosIngreso[0];

            var procedenciaAnimal = map3.get("procedenciaAnimal");
            var colorPredominante = map3.get("colorPredominante");
            var colorSecundario = map3.get("colorSecundario");
            var especie = map3.get("especie");
            var estadoReproductivo = map3.get("estadoReproductivo");
            var estadoTutoria = map3.get("estadoTutoria");
            var estatusVivienda = map3.get("estatusVivienda");
            var motivoFallecimiento = map3.get("motivoFallecimiento") == null ? "" : map3.get("motivoFallecimiento");
            var parroquia = map3.get("parroquia");
            var permanencia = map3.get("permanencia");
            var pruebaComportamiento = map3.get("pruebaComportamiento") == null ? "" : map3.get("pruebaComportamiento");
            var raza = map3.get("raza");
            var sexo = map3.get("sexo");
            var tutor = map3.get("usuarioId");
            var comunitario = map2.get("comunitario");
            var tipoVivienda = map3.get("tipoVivienda");
            var nombreAnimal = map2.get("nombreAnimal");
            var fechaNacimiento = map2.get("fechaNacimiento");
            var cerramiento = map2.get("cerramiento");
            var enfermedadCatastrofica = map2.get("enfermedadCatastrofica") == null ? "" : map2.get("enfermedadCatastrofica");
            var examenComportamental = map2.get("examenComportamental");
            var examenComportamentalArchivo = map2.get("examenClinicoArchivo");
            var certificadoVacunacion = map2.get("certificadoVacunacion");
            var certificadoEsterilizacion = map2.get("certificadoEsterilizacion");
            var examenFisico = map2.get("examenFisico") == null ? "" : map2.get("examenFisico");
            var observacionMicrochip = map2.get("observacionMicrochip") == null ? "" : map2.get("observacionMicrochip");
            var senialesParticulares = map2.get("seniasParticulares");
            var barrio = map2.get("barrio");
            var nomenclatura = map2.get("nomenclatura") == null ? "" : map2.get("nomenclatura");
            var otros = map2.get("otros") == null ? "" : map2.get("otros");
            var principal = map2.get("principal");
            var referencia = map2.get("referencia") == null ? "" : map2.get("referencia");
            var secundaria = map2.get("secundaria");
            var fallecimiento = map2.get("fallecimiento") == null ? "" : map2.get("fallecimiento");
            var mt2Vivienda = map2.get("metrosCuadradosTotal");
            var mt2Permanencia = map2.get("metrosCuadradosAproximado");
            var descripcionEnfermedad = map2.get("descripcionEnfermedades") == null ? "" : map2.get("descripcionEnfermedades");
            var microchipMascota = map2.get("codigoMicrochip") == null ? "" : map2.get("codigoMicrochip");
            var tipoAnimal = map2.get("tipoAnimal");
            var esterilizacionArchivo = map2.get("certificadoEsterilizadoArchivo");
            var vacunacionArchivo = map2.get("certificadoVacunacionArchivo");
            var identificacionFotografica = map2.get("identificacionFotografica");
            var tutoresComunitarios = map2.get("tutoresComunitarios");
            var identificacionVisible = map2.get("identificacionVisible");
            var usuarioCreacion = map2.get("usuarioCreacion");
            var terminalCreacion = map2.get("terminalCreacion");
            var usuarioModificacion = map2.get("usuarioModificacion");
            var terminalModificacion = map2.get("terminalModificacion");

            Optional<RemCatalogo> colorPredominanteId = catalogoRepository.findById(Long.parseLong(colorPredominante.toString()));
            Optional<RemCatalogo> colorSecundarioId = catalogoRepository.findById(Long.parseLong(colorSecundario.toString()));
            Optional<RemCatalogo> especieId = catalogoRepository.findById(Long.parseLong(especie.toString()));
            Optional<RemCatalogo> estadoReproductivoId = catalogoRepository.findById(Long.parseLong(estadoReproductivo.toString()));
            Optional<RemCatalogo> estadoTutoriaId = catalogoRepository.findById(Long.parseLong(estadoTutoria.toString()));

            if (!microchipMascota.equals("")) {
                microchipMascotaId = microchipMascotaRepository.obtenerCodigoMicroChip(microchipMascota.toString());
            }

            Optional<RemCatalogo> parroquiaId = catalogoRepository.findById(Long.parseLong(parroquia.toString()));
            Optional<RemCatalogo> permanenciaId = catalogoRepository.findById(Long.parseLong(permanencia.toString()));

            Optional<RemCatalogo> razaId = catalogoRepository.findById(Long.parseLong(raza.toString()));
            Optional<RemCatalogo> sexoId = catalogoRepository.findById(Long.parseLong(sexo.toString()));
            Optional<RemCatalogo> tipoViviendaId = catalogoRepository.findById(Long.parseLong(tipoVivienda.toString()));
            Optional<RemCatalogo> estado = servicioCatalogo.obtenerById(Long.parseLong("223"));

            if (!pruebaComportamiento.equals("")) {
                pruebaComportamientoId = catalogoRepository.findById(Long.parseLong(pruebaComportamiento.toString()));
                animalTutorObj.setPruebaComportamiento(pruebaComportamientoId.get());
            }

            if (!motivoFallecimiento.equals("")) {
                motivoFallecimientoId = catalogoRepository.findById(Long.parseLong(motivoFallecimiento.toString()));
                animalTutorObj.setMotivoFallecimiento(motivoFallecimientoId.get());
            }
            if (!identificacionFotografica.equals("")) {
                listaIdentificacionFotografica = (ArrayList) identificacionFotografica;
                guardarFotografias(listaIdentificacionFotografica, terminalCreacion.toString(), usuarioCreacion.toString());
            }
            if (!esterilizacionArchivo.toString().equals("")) {
                ArrayList listaEsterilizacion = (ArrayList) esterilizacionArchivo;
                map4 = (Map<String, Object>) listaEsterilizacion.get(0);
                esterilizacionId = guardarArchivo(map4.get("base64").toString(), terminalCreacion.toString(), usuarioCreacion.toString(), map4.get("nombreArchivo").toString());
                animalTutorObj.setCertificadoEsterilizacionArchivo(esterilizacionId);
            }

            if (!vacunacionArchivo.toString().equals("")) {
                ArrayList listaVacunacion = (ArrayList) vacunacionArchivo;
                map5 = (Map<String, Object>) listaVacunacion.get(0);
                vacunacionId = guardarArchivo(map5.get("base64").toString(), terminalCreacion.toString(), usuarioCreacion.toString(), map5.get("nombreArchivo").toString());
                animalTutorObj.setCertificadoVacunacionArchivo(vacunacionId);
            }

            if (!identificacionVisible.toString().equals("")) {
                ArrayList listaidentificacionVisible = (ArrayList) identificacionVisible;
                map6 = (Map<String, Object>) listaidentificacionVisible.get(0);
                identificacionVisibleId = guardarArchivo(map6.get("base64").toString(), terminalCreacion.toString(), usuarioCreacion.toString(), map6.get("nombreArchivo").toString());
                animalTutorObj.setIdentificacionVisible(identificacionVisibleId);
            }

            if (!examenComportamentalArchivo.toString().equals("")) {
                ArrayList listaexamenComportamentalArchivo = (ArrayList) examenComportamentalArchivo;
                map7 = (Map<String, Object>) listaexamenComportamentalArchivo.get(0);
                examenClinico = guardarArchivo(map7.get("base64").toString(), terminalCreacion.toString(), usuarioCreacion.toString(), map7.get("nombreArchivo").toString());
                animalTutorObj.setExamenComportamentalArchivo(examenClinico);
            }

            if (tutor != null) {
                tutorId = tutorMascotaRepository.obtenerTutor(Long.parseLong(tutor.toString()));
            }

            if (!descripcionEnfermedad.equals("")) {
                animalTutorObj.setDescripcionEnfermedad(descripcionEnfermedad.toString());
            }

            animalTutorObj.setColorPredominante(colorPredominanteId.get());
            animalTutorObj.setColorSecundario(colorSecundarioId.get());
            animalTutorObj.setEspecie(especieId.get());
            animalTutorObj.setEstadoReproductivo(estadoReproductivoId.get());
            animalTutorObj.setEstadoTutoria(estadoTutoriaId.get());
            animalTutorObj.setMicrochipMascotaId(microchipMascotaId);
            animalTutorObj.setParroquia(parroquiaId.get());
            animalTutorObj.setPermanencia(permanenciaId.get());
            animalTutorObj.setRaza(razaId.get());
            animalTutorObj.setSexo(sexoId.get());
            animalTutorObj.setTipoVivienda(tipoViviendaId.get());
            animalTutorObj.setIdentificacionFotografica1(identificacionFotografica1Id);
            animalTutorObj.setIdentificacionFotografica2(identificacionFotografica2Id);
            animalTutorObj.setTutorId(tutorId);
            animalTutorObj.setComunitario(comunitario.toString());
            animalTutorObj.setProcedenciaAnimal(Integer.parseInt(procedenciaAnimal.toString()));
            animalTutorObj.setNombreAnimal(nombreAnimal.toString());
            Date fechaNacimientoAnimal = sdf.parse(fechaNacimiento.toString());
            if (!fallecimiento.equals("")) {
                Date fechaFallecimientoAnimal = sdf.parse(fallecimiento.toString());
                animalTutorObj.setFechaFallecimiento(fechaFallecimientoAnimal);
            }
            animalTutorObj.setFechaNacimiento(fechaNacimientoAnimal);
            animalTutorObj.setCerramiento(cerramiento.toString());
            animalTutorObj.setEstatusVivienda(Integer.parseInt(estatusVivienda.toString()));
            animalTutorObj.setEnfermedadCatastrofica(enfermedadCatastrofica.toString());
            animalTutorObj.setExamenComportamental(examenComportamental.toString());
            animalTutorObj.setCertificadoVacunacion(certificadoVacunacion.toString());
            animalTutorObj.setCertificadoEsterilizacion(certificadoEsterilizacion.toString());
            animalTutorObj.setExamenFisico(examenFisico.toString());
            animalTutorObj.setObservacionMicrochip(observacionMicrochip.toString());
            animalTutorObj.setSenialesParticulares(senialesParticulares.toString());
            animalTutorObj.setBarrio(barrio.toString());
            animalTutorObj.setCallePrincipal(principal.toString());
            animalTutorObj.setCalleNumero(nomenclatura.toString());
            animalTutorObj.setCalleSecundaria(secundaria.toString());
            animalTutorObj.setCalleReferencia1(referencia.toString());
            animalTutorObj.setCalleReferencia2("");
            animalTutorObj.setMt2Vivienda(new BigDecimal(mt2Vivienda.toString()));
            animalTutorObj.setMt2Permanencia(new BigDecimal(mt2Permanencia.toString()));
            animalTutorObj.setAcuerdoResponsabilidad("SI");
            animalTutorObj.setFechaCreacion(fechaAuditoria);
            animalTutorObj.setFechaModificacion(fechaAuditoria);
            animalTutorObj.setFechaRegistro(fechaAuditoria);
            animalTutorObj.setUsuarioCreacion(usuarioCreacion.toString());
            animalTutorObj.setUsuarioModificacion(usuarioModificacion.toString());
            animalTutorObj.setTerminalCreacion(terminalCreacion.toString());
            animalTutorObj.setTerminalModificacion(terminalModificacion.toString());
            animalTutorObj.setAcuerdoResponsabilidad("SI");
            animalTutorObj.setEstado(estado.get());
            var secuencialTemp = servicioNomenclatura.obtenerSecuencialTemp(Long.parseLong("26"));
            if (secuencialTemp != Long.parseLong("-1")) {
                sumaSecuencia = secuencialTemp + 1;
                if (servicioNomenclatura.actualizaSecuencialNomenclaturaTemp(sumaSecuencia, Long.parseLong("26"))) {
                    respuesta = true;
                } else {
                    respuesta = false;
                }
            }

            animalTutorObj.setSecuencialTmp(sumaSecuencia);
            animalTutorObj.setSecuencialFinal(Long.parseLong("0"));

            var animalTutorCreado = animalTutorRepository.save(animalTutorObj);
            if (!tutoresComunitarios.equals("")) {
                listaTutoresComunitarios = (ArrayList) tutoresComunitarios;
                guardarTutoresComunitarios(listaTutoresComunitarios, animalTutorCreado.getAnimalTutorId());
            }
            if (!tipoAnimal.equals("")) {
                listaTipoAnimal = (ArrayList) tipoAnimal;
                guardarTipoAnimal(listaTipoAnimal, animalTutorCreado.getAnimalTutorId(), terminalCreacion.toString(), usuarioCreacion.toString());
            }
            taskExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        var ordenGenerada = servicioSao.generarOrdenPago(Long.parseLong("26"), animalTutorCreado.getAnimalTutorId(), animalTutorCreado.getUsuarioCreacion(), Long.parseLong(tutor.toString()), animalTutorCreado.getTerminalCreacion(), animalTutorCreado.getUsuarioCreacion());
                        var mensaje = mensajePreRegistroAnimalMail(animalTutorCreado.getAnimalTutorId(), ordenGenerada);
                        servicioMail.enviarNotificaciones("Registro Animal con Tutor", mensaje, Long.parseLong(tutor.toString()), 26, animalTutorCreado.getAnimalTutorId(), true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return animalTutorObj;
        } catch (Exception e) {
            e.printStackTrace();
            return animalTutorObj;
        } finally {
            identificacionFotografica1Id = null;
            identificacionFotografica2Id = null;
        }
    }

    private void guardarFotografias(ArrayList listaIdentificacionFotografica, String ip, String usuario) {
        List<String> listaFotosB64 = new ArrayList<>();
        DtoArchivo dtoArchivo = new DtoArchivo();
        DtoDatosAuditoria dtoDatosAuditoria = new DtoDatosAuditoria();
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            dtoDatosAuditoria.setDireccionIP(ip);
            dtoDatosAuditoria.setUsuario(usuario);
            dtoArchivo.setDatosAuditoria(dtoDatosAuditoria);

            dtoArchivo.setObservacion("");

            if (listaIdentificacionFotografica.size() > 1) {

                for (int x = 0; x < listaIdentificacionFotografica.size(); x++) {

                    map = (Map<String, Object>) listaIdentificacionFotografica.get(x);
                    dtoArchivo.setNombre(map.get("nombreArchivo").toString());
                    dtoArchivo.setContenido(map.get("base64").toString());
                    var fotografias = servicioWSO2.guardarArchivo(dtoArchivo);
                    if (servicioUtilitario.guardarArchivo(fotografias, ip, usuario)) {
                        listaFotosB64.add(fotografias);
                    }

                }
                identificacionFotografica1Id = archivosRepository.buscarArchivo(listaFotosB64.get(0).substring(1, listaFotosB64.get(0).length() - 1));
                identificacionFotografica2Id = archivosRepository.buscarArchivo(listaFotosB64.get(1).substring(1, listaFotosB64.get(1).length() - 1));

            } else {

                map = (Map<String, Object>) listaIdentificacionFotografica.get(0);
                dtoArchivo.setNombre(map.get("nombreArchivo").toString());
                dtoArchivo.setContenido(map.get("base64").toString());
                var fotografias = servicioWSO2.guardarArchivo(dtoArchivo);
                if (servicioUtilitario.guardarArchivo(fotografias, ip, usuario)) {
                    listaFotosB64.add(fotografias);
                }

                identificacionFotografica1Id = archivosRepository.buscarArchivo(listaFotosB64.get(0).substring(1, listaFotosB64.get(0).length() - 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private RemArchivos guardarArchivo(String b64, String ip, String usuario, String nombreArchivo) {
        RemArchivos archivos = new RemArchivos();
        DtoArchivo dtoArchivo = new DtoArchivo();
        DtoDatosAuditoria dtoDatosAuditoria = new DtoDatosAuditoria();

        try {
            dtoDatosAuditoria.setDireccionIP(ip);
            dtoDatosAuditoria.setUsuario(usuario);
            dtoArchivo.setDatosAuditoria(dtoDatosAuditoria);
            dtoArchivo.setNombre(nombreArchivo);
            dtoArchivo.setObservacion("");

            dtoArchivo.setContenido(b64);
            var archivo = servicioWSO2.guardarArchivo(dtoArchivo);

            if (servicioUtilitario.guardarArchivo(archivo, ip, usuario)) {
                archivos = archivosRepository.buscarArchivo(archivo.substring(1, archivo.length() - 1));;
            }

            return archivos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void guardarTutoresComunitarios(ArrayList listaTutoresComunitarios, Long animalTutorId) {

        try {
            for (int i = 0; i < listaTutoresComunitarios.size(); i++) {
                RemTutoresComunitarios tutoresComunitarios = new RemTutoresComunitarios();

                var tutor = listaTutoresComunitarios.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                map = (Map<String, Object>) tutor;
                String tutorComunitario = map.get("tutor_id").toString();
                var tutorMascota = tutorMascotaRepository.findById(Long.parseLong(tutorComunitario));
                var animalTutor = animalTutorRepository.findById(animalTutorId);
                tutoresComunitarios.setTutorId(tutorMascota.get());
                tutoresComunitarios.setAnimalTutorId(animalTutor.get());
                tutorComunitarioRepository.save(tutoresComunitarios);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void guardarTipoAnimal(ArrayList listaTipoAnimal, Long animalTutorId, String ip, String usuario) {
        DtoArchivo dtoArchivo = new DtoArchivo();
        DtoDatosAuditoria dtoDatosAuditoria = new DtoDatosAuditoria();

        try {

            dtoDatosAuditoria.setDireccionIP(ip);
            dtoDatosAuditoria.setUsuario(usuario);
            dtoArchivo.setDatosAuditoria(dtoDatosAuditoria);

            dtoArchivo.setObservacion("");

            for (int i = 0; i < listaTipoAnimal.size(); i++) {
                RemTipoAnimalTutor tipoAnimalTutor = new RemTipoAnimalTutor();
                RemArchivos documentoAcredita = new RemArchivos();

                var tutor = listaTipoAnimal.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                map = (Map<String, Object>) tutor;
                var establecimiento = map.get("establecimiento").toString();

                var telefono = map.get("telefono").toString();
                var tipoAnimalId = map.get("tipoCatalogoId").toString();
                var tipoAnimal = catalogoRepository.findById(Long.parseLong(tipoAnimalId));
                var animalTutor = animalTutorRepository.findById(animalTutorId);
                var file = map.get("file");
                if (!file.equals("")) {
                    String b64 = file.toString();
                    dtoArchivo.setNombre(map.get("nombreArchivo").toString());
                    dtoArchivo.setContenido(b64);
                    var identificacionFotografica = servicioWSO2.guardarArchivo(dtoArchivo);
                    if (servicioUtilitario.guardarArchivo(identificacionFotografica, ip, usuario)) {
                        documentoAcredita = archivosRepository.buscarArchivo(identificacionFotografica.substring(1, identificacionFotografica.length() - 1));
                        tipoAnimalTutor.setDocumentoAcredita(documentoAcredita);
                    }
                }

                tipoAnimalTutor.setTipoAnimal(tipoAnimal.get());
                tipoAnimalTutor.setNombreIntitucion(establecimiento);
                tipoAnimalTutor.setTelefonoIntitucion(telefono);
                tipoAnimalTutor.setAnimalTutorId(animalTutor.get());
                tipoAnimalTutorRepository.save(tipoAnimalTutor);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String mensajePreRegistroAnimalMail(Long animalTutorId, String ordenGenerada) {
        var mensaje = "";
        try {
            DtoAnimalTutor dtoAnimalTutor = obtenerDatosAnimalTutor(animalTutorId);
            Optional<RemSubtipoRegistro> subTipoRegistroObj = servicioSubtipoRegistro.obtenerById(Long.parseLong("26"));
            var valorSalarioBasicoC = parametroRepository.obtenerParametro(Long.parseLong("11"));
            String ordenanza = parametroRepository.obtenerParametro(Long.parseLong("5"));
            Double valorSalarioBasicoN = Double.parseDouble(valorSalarioBasicoC);
            mensaje = "Se ha registrado correctamente el preregistro "+ dtoAnimalTutor.getNroRegistro() +", recuerde que de acuerdo a la Ordenanza " + ordenanza
                    + " se ha generado la orden de pago Nro." + ordenGenerada + " por el valor de $ " + (valorSalarioBasicoN * subTipoRegistroObj.get().getValor1().longValue() / 100.00) + ", por favor proceder con el respectivo"
                    + " pago para la emisión del carnet de identificación del animal de compañía.";
            return mensaje;
        } catch (Exception e) {
            return mensaje;
        }
    }
    public String mensajePreRegistroAnimal(Long animalTutorId) {
        var mensaje = "";
        try {
            DtoAnimalTutor dtoAnimalTutor = obtenerDatosAnimalTutor(animalTutorId);
            Optional<RemSubtipoRegistro> subTipoRegistroObj = servicioSubtipoRegistro.obtenerById(Long.parseLong("26"));
            var valorSalarioBasicoC = parametroRepository.obtenerParametro(Long.parseLong("11"));
            String ordenanza = parametroRepository.obtenerParametro(Long.parseLong("5"));
            Double valorSalarioBasicoN = Double.parseDouble(valorSalarioBasicoC);
            mensaje = "Se ha registrado correctamente el preregistro "+ dtoAnimalTutor.getNroRegistro()+", se remitirá mediante correo electrónico"
                    + " una orden de pago por el valor de $ "+ (valorSalarioBasicoN * subTipoRegistroObj.get().getValor1().longValue() / 100.00) 
                    + ", para la emisión del carnet de identificación del animal de compañia";
            return mensaje;
        } catch (Exception e) {
            return mensaje;
        }
    }

    public DtoAnimalTutor obtenerDatosAnimalTutor(Long animalTutorId) {
        DtoAnimalTutor dtoAnimalTutorRespuesta = new DtoAnimalTutor();
        DtoAnimalTutor dtoAnimalTutor = new DtoAnimalTutor();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<String> datos = animalTutorRepository.obtenerDatosAnimalTutor(animalTutorId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (int i = 0; i < datos.size(); i++) {
                var data = datos.get(i);
                String[] split = data.split(",");
                List<String> listaDatos = new ArrayList<>();
                for (int j = 0; j < split.length; j++) {
                    listaDatos.add(split[j]);
                }

                dtoAnimalTutor.setAnimalTutorId(Long.parseLong(listaDatos.get(0).toString()));
                dtoAnimalTutor.setNroRegistro(listaDatos.get(1).toString());
                dtoAnimalTutor.setSecuencialTmp(Long.parseLong(listaDatos.get(2).toString()));
                dtoAnimalTutor.setSecuencialFinal(Long.parseLong(listaDatos.get(3).toString()));
                dtoAnimalTutor.setTutorId(Long.parseLong(listaDatos.get(4).toString()));

                dtoAnimalTutor.setDenominacionTutor(listaDatos.get(5).toString());
                dtoAnimalTutor.setNombresTutor(listaDatos.get(6).toString());
                dtoAnimalTutor.setApellidosTutor(listaDatos.get(7).toString());
                dtoAnimalTutor.setIdentificacionTutor(listaDatos.get(8).toString());
                dtoAnimalTutor.setNacionalidadTutor(listaDatos.get(9).toString());
                dtoAnimalTutor.setDireccionTutor(listaDatos.get(10).toString());
                dtoAnimalTutor.setMovilTutor(listaDatos.get(11).toString());
                dtoAnimalTutor.setTelefonoTutor(listaDatos.get(12).toString());
                dtoAnimalTutor.setEmailTutor(listaDatos.get(13).toString());
                dtoAnimalTutor.setEmailPersonalTutor(listaDatos.get(14).toString());

                dtoAnimalTutor.setComunitario(listaDatos.get(15).toString());
                dtoAnimalTutor.setEstadoTutoria(Long.parseLong(listaDatos.get(16).toString()));
                dtoAnimalTutor.setEstadoTutoriaNombre(listaDatos.get(17).toString());
                dtoAnimalTutor.setProcedencia(Long.parseLong(listaDatos.get(18).toString()));
                dtoAnimalTutor.setProcedenciaNombre(listaDatos.get(19).toString());
                dtoAnimalTutor.setMicrochipMascotaId(Long.parseLong(listaDatos.get(20).toString()));
                dtoAnimalTutor.setObservacionMicrochip(listaDatos.get(21).toString());
                dtoAnimalTutor.setNombreAnimal(listaDatos.get(22).toString());
                Date fechaNacimiento = sdf.parse(listaDatos.get(23).toString());
                dtoAnimalTutor.setFechaNacimiento(fechaNacimiento);

                dtoAnimalTutor.setEspecie(Long.parseLong(listaDatos.get(24).toString()));
                dtoAnimalTutor.setEspecieNombre(listaDatos.get(25).toString());
                dtoAnimalTutor.setRaza(Long.parseLong(listaDatos.get(26).toString()));
                dtoAnimalTutor.setRazaNombre(listaDatos.get(27).toString());
                dtoAnimalTutor.setSexo(Long.parseLong(listaDatos.get(28).toString()));
                dtoAnimalTutor.setSexoNombre(listaDatos.get(29).toString());
                dtoAnimalTutor.setEstadoReproductivo(Long.parseLong(listaDatos.get(30).toString()));
                dtoAnimalTutor.setEstadoReproductivoNombre(listaDatos.get(31).toString());
                dtoAnimalTutor.setColoPredominante(Long.parseLong(listaDatos.get(32).toString()));
                dtoAnimalTutor.setColoPredominanteNombre(listaDatos.get(33).toString());
                dtoAnimalTutor.setColoSecundario(Long.parseLong(listaDatos.get(34).toString()));
                dtoAnimalTutor.setColoSecundarioNombre(listaDatos.get(35).toString());
                dtoAnimalTutor.setSenialesParticulares(listaDatos.get(36).toString());
                var identificacionFotograficaId1 = listaDatos.get(37).toString();
                var imagen1Map = servicioWSO2.getArchivo(identificacionFotograficaId1);
                map = (Map<String, Object>) imagen1Map;
                dtoAnimalTutor.setIdentificacionFotografica1(map.get("Contenido").toString());
                var identificacionFotograficaId2 = listaDatos.get(38).toString();
                if (!identificacionFotograficaId2.equals("null")) {
                    var imagen2Map = servicioWSO2.getArchivo(identificacionFotograficaId2);
                    map = (Map<String, Object>) imagen2Map;
                    dtoAnimalTutor.setIdentificacionFotografica2(map.get("Contenido").toString());
                } else {
                    dtoAnimalTutor.setIdentificacionFotografica2(null);
                }

                dtoAnimalTutor.setIdentificacionVisible(listaDatos.get(39).toString());
                dtoAnimalTutor.setPermanencia(Long.parseLong(listaDatos.get(40).toString()));
                dtoAnimalTutor.setPermanenciaNombre(listaDatos.get(41).toString());
                dtoAnimalTutor.setPermanenciaOtros(listaDatos.get(42).toString());
                dtoAnimalTutor.setParroquia(Long.parseLong(listaDatos.get(43).toString()));
                dtoAnimalTutor.setParroquiaNombre(listaDatos.get(44).toString());
                dtoAnimalTutor.setBarrio(listaDatos.get(45).toString());
                dtoAnimalTutor.setCallePrincipal(listaDatos.get(46).toString());
                dtoAnimalTutor.setCalleNumero(listaDatos.get(47).toString());
                dtoAnimalTutor.setCalleSecundaria(listaDatos.get(48).toString());
                dtoAnimalTutor.setCalleReferencia1(listaDatos.get(49).toString());
                dtoAnimalTutor.setCalleReferencia2(listaDatos.get(50).toString());

                dtoAnimalTutor.setTipoVivienda(Long.parseLong(listaDatos.get(51).toString()));
                dtoAnimalTutor.setTipoViviendaNombre(listaDatos.get(52).toString());
//                dtoAnimalTutor.setMt2Vivienda(BigDecimal listaDatos.get(53).toString()));
//                dtoAnimalTutor.setMt2Permanencia(listaDatos.get(54).toString());
                dtoAnimalTutor.setCerramiento(listaDatos.get(55).toString());
                dtoAnimalTutor.setEstatusVivienda(Long.parseLong(listaDatos.get(56).toString()));
                dtoAnimalTutor.setEstatusViviendaNombre(listaDatos.get(57).toString());
                dtoAnimalTutor.setEstatusViviendaOtros(listaDatos.get(58).toString());
                dtoAnimalTutor.setEnfermedadCatastrofica(listaDatos.get(59).toString());
                dtoAnimalTutor.setDescripcionEnfermedad(listaDatos.get(60).toString());
                dtoAnimalTutor.setExamenComportamental(listaDatos.get(61).toString());
                dtoAnimalTutor.setPruebaComportamiento(Long.parseLong(listaDatos.get(62).toString()));
                dtoAnimalTutor.setPruebaComportamientoNombre(listaDatos.get(63).toString());
                dtoAnimalTutor.setExamenComportamentalArchivo(listaDatos.get(64).toString());
                dtoAnimalTutor.setExamenFisico(listaDatos.get(65).toString());
                dtoAnimalTutor.setCertificadoVacunacion(listaDatos.get(66).toString());
                dtoAnimalTutor.setCertificadoVacunacionArchivo(listaDatos.get(67).toString());
                dtoAnimalTutor.setCertificadoEsterilizacion(listaDatos.get(68).toString());
                dtoAnimalTutor.setCertificadoEsterilizacionArchivo(listaDatos.get(69).toString());

                Date fechaFallecimiento = sdf.parse(listaDatos.get(70).toString());
                dtoAnimalTutor.setFechaFallecimiento(fechaFallecimiento);
                dtoAnimalTutor.setMotivoFallecimiento(Long.parseLong(listaDatos.get(71).toString()));
                dtoAnimalTutor.setMotivoFallecimientoNombre(listaDatos.get(72).toString());
                dtoAnimalTutor.setAcuerdoResponsabilidad(listaDatos.get(73).toString());
                Date fechaRegistro = sdf.parse(listaDatos.get(74).toString());
                dtoAnimalTutor.setFechaRegistro(fechaRegistro);
                dtoAnimalTutor.setEstado(Long.parseLong(listaDatos.get(75).toString()));
                dtoAnimalTutor.setEstadoNombre(listaDatos.get(76).toString());
                dtoAnimalTutor.setEdadAnimal(Long.parseLong(listaDatos.get(77).toString()));

//                Date fechaCreacion = sdf.parse(listaDatos.get(4).toString());
//                dtoAnimalTutor.setFechaCreacion(fechaCreacion);
//                dtoAnimalTutor.setEstado(listaDatos.get(5).toString());
//                dtoAnimalTutorRespuesta.add(dtoAnimalTutor);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return dtoAnimalTutor;

    }

}
