/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemArchivos;
import gob.mdmq.remetfu.Entidades.RemAtencionAnimales;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemEnfermedadesAnimales;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoEnfermedades;
import gob.mdmq.remetfu.dto.fileserver.DtoArchivo;
import gob.mdmq.remetfu.dto.fileserver.DtoDatosAuditoria;
import gob.mdmq.remetfu.repository.ArchivosRepository;
import gob.mdmq.remetfu.repository.AtencionAnimalRepository;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.EnfermedadesAnimalesRepository;
import gob.mdmq.remetfu.repository.MicrochipMascotaRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * @author omaldonado
 */
@Service
public class ServicioAtencionAnimal {

    @Autowired
    private AtencionAnimalRepository atencionAnimalRepository;
    @Autowired
    private EnfermedadesAnimalesRepository enfermedadesAnimalesRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @Autowired
    private ArchivosRepository archivosRepository;
    @Autowired
    private MicrochipMascotaRepository microchipMascotaRepository;
    @Autowired
    private ServicioUtilitario servicioUtilitario;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private ServicioWSO2 servicioWSO2;

    @Transactional
    public boolean crearAtencionAnimal(Map<String, Object[]> models) {

        boolean respuesta = false;
        ArrayList listaEnfermedades = null;
        RemAtencionAnimales atencionAnimales = new RemAtencionAnimales();
        Date fecha = new Date();
        List<DtoEnfermedades> listaEnfermedadesDto = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        RemArchivos identificacionFotografica1Id = null;
        RemArchivos identificacionVisible1Id = null;
        Optional<RemCatalogo> tipoIdentificacionVisibleId = null;
        DtoArchivo dtoArchivo = new DtoArchivo();
        DtoDatosAuditoria dtoDatosAuditoria = new DtoDatosAuditoria();
        Map<String, Object[]> map = new HashMap<String, Object[]>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        Map<String, Object> map4 = new HashMap<String, Object>();
        Map<String, Object> map5 = new HashMap<String, Object>();
        Map<String, Object> map6 = new HashMap<String, Object>();
        ArrayList identificacionFotografica1Lista = null;
        try {
            RemAtencionAnimales atencionAnimalesId = new RemAtencionAnimales();

            map = (Map<String, Object[]>) models;
            var atencionAnimalesPropiedad = map.get("atencionAnimales");
            var datosIngreso = map.get("datosIngreso");
            map2 = (Map<String, Object>) atencionAnimalesPropiedad[0];
            map3 = (Map<String, Object>) datosIngreso[0];
            var nacimiento = map2.get("nacimiento");
            Date fechaNacimiento = sdf.parse(nacimiento.toString());
            var nombreAnimal = map2.get("nombreAnimal");
            var observacion = map2.get("observaciones");
            var enfermedades = map2.get("enfermedades");
            var usuarioModificacion = map2.get("usuarioModificacion");
            var terminalModificacion = map2.get("terminalModificacion");
            dtoDatosAuditoria.setDireccionIP(terminalModificacion.toString());
            dtoDatosAuditoria.setUsuario(usuarioModificacion.toString());
            dtoArchivo.setDatosAuditoria(dtoDatosAuditoria);
            dtoArchivo.setObservacion("");

            listaEnfermedades = (ArrayList) enfermedades;

            for (var lista : listaEnfermedades) {
                DtoEnfermedades dtoEnfermedades = new DtoEnfermedades();
                var dtoEnfermedadesLista = (Map<String, Object>) lista;
                var idsEnfermedades = dtoEnfermedadesLista.get("tipoCatalogoId");
                dtoEnfermedades.setEnfermedadId(Long.parseLong(idsEnfermedades.toString()));

                listaEnfermedadesDto.add(dtoEnfermedades);

            }

            ///Seccion de cabeceras
            var atencionRealizada = Long.parseLong(map3.get("atencionRealizada").toString());
            var identificacionFotografica1 = map2.get("identificacionFotografica");
            var identificacionVisible = map2.get("identificacionVisible");
            var tipoIdentificacionVisible = Long.parseLong(map3.get("tipoIdentificacion").toString());
            var microChipMascota = map2.get("numeroMicrochip").toString();
            var funcionarioUBA = map2.get("funcionarioUBA").toString();
            var estadoChequeo = Long.parseLong(map3.get("estadoChequeo").toString());
            Optional<RemCatalogo> atencionRealizadaId = catalogoRepository.findById(atencionRealizada);
            if (!identificacionFotografica1.equals("")) {

                map5 = (Map<String, Object>) identificacionFotografica1;
                dtoArchivo.setNombre(map5.get("nombreArchivo").toString());
                dtoArchivo.setContenido(map5.get("base64").toString());
                var identificacionFotografica = servicioWSO2.guardarArchivo(dtoArchivo);
                if (servicioUtilitario.guardarArchivo(identificacionFotografica, terminalModificacion.toString(), usuarioModificacion.toString())) {
                    identificacionFotografica1Id = archivosRepository.buscarArchivo(identificacionFotografica.substring(1, identificacionFotografica.length() - 1));
                    atencionAnimales.setIdentificacionFotografica1(identificacionFotografica1Id);
                }
            }
            if (!identificacionVisible.equals("")) {
                map6 = (Map<String, Object>) identificacionVisible;
                dtoArchivo.setNombre(map5.get("nombreArchivo").toString());
                dtoArchivo.setContenido(map5.get("base64").toString());
                var identificacionVisibleAtencion = servicioWSO2.guardarArchivo(dtoArchivo);
                if (servicioUtilitario.guardarArchivo(identificacionVisibleAtencion, terminalModificacion.toString(), usuarioModificacion.toString())) {
                    identificacionVisible1Id = archivosRepository.buscarArchivo(identificacionVisibleAtencion.substring(1, identificacionVisibleAtencion.length() - 1));
                    atencionAnimales.setIdentificacionVisible(identificacionVisible1Id);
                }
            }

            tipoIdentificacionVisibleId = catalogoRepository.findById(tipoIdentificacionVisible);
            atencionAnimales.setTipoIdentificacionVisible(tipoIdentificacionVisibleId.get());
            RemMicrochipMascota microChipMascotaId = microchipMascotaRepository.obtenerCodigoMicroChip(microChipMascota);
            RemUsuarios funcionarioUBAId = usuariosRepository.obtenerUsuarioUBA(funcionarioUBA);
            Optional<RemCatalogo> testadoChequeoId = catalogoRepository.findById(estadoChequeo);
            atencionAnimales.setAtencionRealizada(atencionRealizadaId.get());
            atencionAnimales.setIdentificacionFotografica2(null);
            atencionAnimales.setMicrochipMascotaId(microChipMascotaId);
            atencionAnimales.setFuncionarioUba(funcionarioUBAId);
            atencionAnimales.setEstadoChequeo(testadoChequeoId.get());
            atencionAnimales.setObservaciones(observacion.toString());
            ///Seccion AtencionAnimal
            atencionAnimales.setEstado("ACT");
            atencionAnimales.setFechaCreacion(fecha);
            atencionAnimales.setFechaModificacion(fecha);
            atencionAnimales.setFechaNacimiento(fechaNacimiento);
            atencionAnimales.setFechaRegistro(fecha);
            atencionAnimales.setNombreAnimal(nombreAnimal.toString());
            atencionAnimales.setTerminalCreacion(terminalModificacion.toString());
            atencionAnimales.setTerminalModificacion(terminalModificacion.toString());
            atencionAnimales.setUsuarioCreacion(usuarioModificacion.toString());
            atencionAnimales.setUsuarioModificacion(usuarioModificacion.toString());

            atencionAnimalesId = atencionAnimalRepository.save(atencionAnimales);

            for (var enfermedadesDetectadas : listaEnfermedadesDto) {
                RemEnfermedadesAnimales enfermedadesAnimales = new RemEnfermedadesAnimales();
                Optional<RemCatalogo> idEnfermedad = catalogoRepository.findById(enfermedadesDetectadas.getEnfermedadId());

                enfermedadesAnimales.setAtencionAnimalesId(atencionAnimalesId);
                enfermedadesAnimales.setEnfermedadesDetectadas(idEnfermedad.get());
                enfermedadesAnimales.setEstado("ACT");
                enfermedadesAnimales.setFechaCreacion(fecha);
                enfermedadesAnimales.setFechaModificacion(fecha);
                enfermedadesAnimales.setFechaRegistro(fecha);
                enfermedadesAnimales.setTerminalCreacion(terminalModificacion.toString());
                enfermedadesAnimales.setTerminalModificacion(terminalModificacion.toString());
                enfermedadesAnimales.setUsuarioCreacion(usuarioModificacion.toString());
                enfermedadesAnimales.setUsuarioModificacion(usuarioModificacion.toString());

                enfermedadesAnimalesRepository.save(enfermedadesAnimales);
            }

            return respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }
    }

}
