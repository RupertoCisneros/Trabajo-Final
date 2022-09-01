/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemRecepcionAnimales;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.RecepcionAnimalesRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omaldonado
 */
@Service
public class ServicioRecepcionAnimales {

    @Autowired
    private RecepcionAnimalesRepository recepcionAnimalesRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;

    public boolean crearRecepcionAnimales(Map<String, Object[]> models) {
        boolean respuesta = false;
        RemRecepcionAnimales remRecepcionAnimales = new RemRecepcionAnimales();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        Map<String, Object> map4 = new HashMap<String, Object>();
        Date fecha = new Date();
        String examenClinicoComportamental = "";

        try {

            Map<String, Object[]> map = new HashMap<String, Object[]>();
            map = (Map<String, Object[]>) models;
            var recepcionAnimales = map.get("recepcionAnimales");
            var datosIngreso = map.get("datosIngreso");
            map2 = (Map<String, Object>) recepcionAnimales[0];
            map3 = (Map<String, Object>) datosIngreso[0];

            var examenClinicoComportamentalData = map3.get("examenClinicoComportamental");
            if (!examenClinicoComportamentalData.equals("")) {
                map4 = (Map<String, Object>) examenClinicoComportamentalData;
                examenClinicoComportamental = map4.get("data").toString();
            }

            Optional<RemCatalogo> agenciaUbaId = catalogoRepository.findById(Long.parseLong(map3.get("agencia").toString()));
            Optional<RemCatalogo> especieId = catalogoRepository.findById(Long.parseLong(map3.get("especie").toString()));
            Optional<RemCatalogo> razaId = catalogoRepository.findById(Long.parseLong(map3.get("raza").toString()));
            Optional<RemCatalogo> sexoId = catalogoRepository.findById(Long.parseLong(map3.get("sexo").toString()));
            Optional<RemCatalogo> estadoReproductivoId = catalogoRepository.findById(Long.parseLong(map3.get("estadoReproductivo").toString()));
            Optional<RemCatalogo> colorPredominanteId = catalogoRepository.findById(Long.parseLong(map3.get("colorPredominante").toString()));
            Optional<RemCatalogo> colorSecundarioId = catalogoRepository.findById(Long.parseLong(map3.get("colorSecundario").toString()));
            Optional<RemCatalogo> procesoEjecucionId = catalogoRepository.findById(Long.parseLong(map3.get("procesoEjecucion").toString()));
            Optional<RemCatalogo> pruebaComportamientoId = catalogoRepository.findById(Long.parseLong(examenClinicoComportamental == "" ? "0" : examenClinicoComportamental));
            RemUsuarios usuarioUBA = obtenerUsuarioUBA(map3.get("funcionarioUBA").toString());
            var seniasParticulares = map2.get("seniasParticulares");
            var descripcionProceso = map2.get("descripcionProceso");
            var examenComportamental = map2.get("examenComportamental");
            var usuarioCreacion = map3.get("usuarioCreacion");
            var terminalCreacion = map3.get("terminalCreacion");
            remRecepcionAnimales.setAcuerdoResponsabilidad("SI");
            remRecepcionAnimales.setColorPredominante(colorPredominanteId.get());
            remRecepcionAnimales.setColorSecundario(colorSecundarioId.get());
            remRecepcionAnimales.setEspecie(especieId.get());
            remRecepcionAnimales.setEstado("ACT");
            remRecepcionAnimales.setEstadoReproductivo(estadoReproductivoId.get());
            remRecepcionAnimales.setFechaCreacion(fecha);
            remRecepcionAnimales.setFechaModificacion(fecha);
            remRecepcionAnimales.setFechaRegistro(fecha);
            remRecepcionAnimales.setFuncionarioUba(usuarioUBA);
            remRecepcionAnimales.setProcesoEjecucion(procesoEjecucionId.get());
            if (!pruebaComportamientoId.isEmpty()) {
                remRecepcionAnimales.setPruebaComportamiento(pruebaComportamientoId.get());
            } else {
                remRecepcionAnimales.setPruebaComportamiento(null);

            }
            remRecepcionAnimales.setRaza(razaId.get());
            remRecepcionAnimales.setSexo(sexoId.get());
            remRecepcionAnimales.setTerminalCreacion(terminalCreacion.toString());
            remRecepcionAnimales.setTerminalModificacion(terminalCreacion.toString());
            remRecepcionAnimales.setAgenciaUba(agenciaUbaId.get());
            remRecepcionAnimales.setUsuarioCreacion(usuarioCreacion.toString());
            remRecepcionAnimales.setUsuarioModificacion(usuarioCreacion.toString());

            remRecepcionAnimales.setSenialesParticulares(seniasParticulares.toString());
            remRecepcionAnimales.setDescripcionProceso(descripcionProceso.toString());
            remRecepcionAnimales.setExamenComportamental(examenComportamental.toString());

            recepcionAnimalesRepository.save(remRecepcionAnimales);
            return respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }

    }

    public RemUsuarios obtenerUsuarioUBA(String cedula) {

        try {
            return usuariosRepository.obtenerUsuarioUBA(cedula);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
