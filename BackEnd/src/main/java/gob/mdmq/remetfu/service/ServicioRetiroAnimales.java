/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemArchivos;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemRetiroAnimales;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.fileserver.DtoArchivo;
import gob.mdmq.remetfu.dto.fileserver.DtoDatosAuditoria;
import gob.mdmq.remetfu.repository.ArchivosRepository;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.RetiroAnimalesRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oportero
 */
@Service
public class ServicioRetiroAnimales {

    @Autowired
    private RetiroAnimalesRepository retiroAnimalesRepository;
    @Autowired
    private ServicioWSO2 servicioWSO2;
    @Autowired
    private ServicioUtilitario servicioUtilitario;
    @Autowired
    private ArchivosRepository archivosRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;

    public boolean crearRetiroAnimales(Map<String, Object> models) {
        boolean respuesta = false;
        RemRetiroAnimales remRetiroAnimales = new RemRetiroAnimales();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> mapDatosIngresos = new HashMap<String, Object>();
        Map<String, Object> mapRetiroAnimal = new HashMap<String, Object>();
        Date fecha = new Date();
        ArrayList listaDatosIngreso = null;
        ArrayList listaRetiroAnimales = null;
        DtoArchivo dtoArchivo = new DtoArchivo();
        DtoDatosAuditoria dtoDatosAuditoria = new DtoDatosAuditoria();
        RemArchivos archivoMotivo = null;

        try {
            map = (Map<String, Object>) models;
            var datosIngreso = map.get("datosIngreso");
            var retiroAnimales = map.get("retiroAnimales");
            listaDatosIngreso = (ArrayList) datosIngreso;
            listaRetiroAnimales = (ArrayList) retiroAnimales;

            var listaDatos = listaDatosIngreso;
            mapDatosIngresos = (Map<String, Object>) listaDatos.get(0);
            var administracionZonal = mapDatosIngresos.get("administracionZonal");
            var parroquia = mapDatosIngresos.get("parroquiaId");
            var estadoTutoria = mapDatosIngresos.get("estadoTutoriaId");
            var situacionIntervencion = mapDatosIngresos.get("situacionIntervencion");
            var motivoRetiro = mapDatosIngresos.get("motivoRetiro");

            var listaRetiro = listaRetiroAnimales;
            mapRetiroAnimal = (Map<String, Object>) listaRetiro.get(0);
            dtoDatosAuditoria.setDireccionIP(mapRetiroAnimal.get("terminalCreacion").toString());
            dtoDatosAuditoria.setUsuario(mapRetiroAnimal.get("usuarioCreacion").toString());
            dtoArchivo.setDatosAuditoria(dtoDatosAuditoria);
            dtoArchivo.setNombre("Remetfu");
            dtoArchivo.setObservacion("");
            var barrio = mapRetiroAnimal.get("barrio");
            var observacionTutor = mapRetiroAnimal.get("observacionTutor");
            var condicionCalle = mapRetiroAnimal.get("condicionCalle");
            var funcionarioUBA = mapRetiroAnimal.get("funcionarioUBA");
            var motivoDescripcion = mapRetiroAnimal.get("motivoDescripcion");
            var motivoFile = mapRetiroAnimal.get("motivoFile") == null ? "" : mapRetiroAnimal.get("motivoFile");
            var nombreParroquia = mapRetiroAnimal.get("nombreParroquia");
            var nomenclatura = mapRetiroAnimal.get("nomenclatura") == null ? "" : mapRetiroAnimal.get("nomenclatura");
            var otros = mapRetiroAnimal.get("otros") == null ? "" : mapRetiroAnimal.get("otros");
            var principal = mapRetiroAnimal.get("principal") == null ? "" : mapRetiroAnimal.get("principal");
            var referencia = mapRetiroAnimal.get("referencia") == null ? "" : mapRetiroAnimal.get("referencia");
            var secundaria = mapRetiroAnimal.get("secundaria") == null ? "" : mapRetiroAnimal.get("secundaria");
            var terminalCreacion = mapRetiroAnimal.get("terminalCreacion");
            var terminalModificacion = mapRetiroAnimal.get("terminalModificacion");
            var usuarioCreacion = mapRetiroAnimal.get("usuarioCreacion");
            var usuarioModificacion = mapRetiroAnimal.get("usuarioModificacion");
            var observacionIntervencion = mapRetiroAnimal.get("observacionIntervencion");

            if (!motivoFile.equals("")) {

                map2 = (Map<String, Object>) motivoFile;
                dtoArchivo.setNombre(map2.get("nombreArchivo").toString());
                dtoArchivo.setContenido(map2.get("base64").toString());
                var identificacionFotografica = servicioWSO2.guardarArchivo(dtoArchivo);
                if (servicioUtilitario.guardarArchivo(identificacionFotografica, terminalModificacion.toString(), usuarioModificacion.toString())) {
                    archivoMotivo = archivosRepository.buscarArchivo(identificacionFotografica.substring(1, identificacionFotografica.length() - 1));
                    remRetiroAnimales.setMotivoRetiroArchivo(archivoMotivo);
                }

            }

            RemUsuarios funcionarioUbaId = usuariosRepository.obtenerUsuarioUBA(funcionarioUBA.toString());
            Optional<RemCatalogo> admZonalId = catalogoRepository.findById(Long.parseLong(administracionZonal.toString()));
            Optional<RemCatalogo> parroquiaId = catalogoRepository.findById(Long.parseLong(parroquia.toString()));
            Optional<RemCatalogo> estadoTutoriaId = catalogoRepository.findById(Long.parseLong(estadoTutoria.toString()));
            Optional<RemCatalogo> situacionIntervencionId = catalogoRepository.findById(Long.parseLong(situacionIntervencion.toString()));
            Optional<RemCatalogo> motivoRetiroId = catalogoRepository.findById(Long.parseLong(motivoRetiro.toString()));

            remRetiroAnimales.setAcuerdoResponsabilidad("SI");
            remRetiroAnimales.setEstado("ACT");
            remRetiroAnimales.setFuncionarioUba(funcionarioUbaId);
            remRetiroAnimales.setAdmZonal(admZonalId.get());
            remRetiroAnimales.setParroquia(parroquiaId.get());
            remRetiroAnimales.setEstadoTutoria(estadoTutoriaId.get());
            remRetiroAnimales.setSituacionIntervencion(situacionIntervencionId.get());
            remRetiroAnimales.setMotivoRetiro(motivoRetiroId.get());
            remRetiroAnimales.setBarrio(barrio.toString());
            remRetiroAnimales.setTutorCondicionCalle(condicionCalle.toString());
            remRetiroAnimales.setObservacionRetiro(motivoDescripcion.toString());
            remRetiroAnimales.setObservacionTutor(observacionTutor.toString());
            remRetiroAnimales.setObservacionIntervencion(observacionIntervencion.toString());
            remRetiroAnimales.setCallePrincipal(principal.toString());
            remRetiroAnimales.setCalleSecundaria(secundaria.toString());
            remRetiroAnimales.setCalleReferencia1(referencia.toString());
            remRetiroAnimales.setCalleReferencia2(otros.toString());
            remRetiroAnimales.setCalleNumero(nomenclatura.toString());
            remRetiroAnimales.setTerminalCreacion(terminalCreacion.toString());
            remRetiroAnimales.setTerminalModificacion(terminalModificacion.toString());
            remRetiroAnimales.setUsuarioCreacion(usuarioCreacion.toString());
            remRetiroAnimales.setUsuarioModificacion(usuarioModificacion.toString());
            remRetiroAnimales.setFechaRegistro(fecha);
            remRetiroAnimales.setFechaCreacion(fecha);
            remRetiroAnimales.setFechaModificacion(fecha);

            retiroAnimalesRepository.save(remRetiroAnimales);
            return respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }
    }

}
