/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemAnalista;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemUsuarioPerfil;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoDatosCreacionKeycloak;
import gob.mdmq.remetfu.dto.DtoUsuarioPerfil;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.UsuarioPerfilRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruper
 */
@Service
public class ServicioUsuarioPerfil {

    @Autowired
    private UsuarioPerfilRepository usuarioPerfilRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ServicioPerfiles servicioPerfil;

    @Autowired
    private ServicioAnalista servicioAnalista;

    @Autowired
    private ServicioCatalogo servicioCatalogo;

    @Autowired
    private CatalogoRepository catalogoRepository;

    public List<RemUsuarioPerfil> obtener() {
        try {
            return (List<RemUsuarioPerfil>) usuarioPerfilRepository.findAll();
        } catch (Exception e) {
            return (List<RemUsuarioPerfil>) usuarioPerfilRepository.findAll();
        }
    }

    public Optional<RemUsuarioPerfil> obtenerById(Long id) {
        try {
            return usuarioPerfilRepository.findById(id);
        } catch (Exception e) {
            return usuarioPerfilRepository.findById(id);
        }
    }

    public boolean crearUsuarioPerfil(Long usuarioId, DtoDatosCreacionKeycloak dtoDatosCreacionKeycloak) {
        boolean respuesta = false;
        Optional<RemCatalogo> tipoUsuario;

        RemUsuarioPerfil remUsuarioPerfil = new RemUsuarioPerfil();

        try {
            Date fecha = new Date();
            var perfil = servicioPerfil.obtenerPerfilById(dtoDatosCreacionKeycloak.getIdPerfil());
            var usuario = usuariosRepository.findById(usuarioId);
            var catalogo = servicioCatalogo.obtenerById(Long.parseLong("233"));

            tipoUsuario = catalogoRepository.findById(Long.parseLong("221"));
            remUsuarioPerfil.setDescripcion("Ciudadano");
            if (dtoDatosCreacionKeycloak.getBanderaKeycloack().equals("S")) {
                tipoUsuario = catalogoRepository.findById(Long.parseLong("222"));
                remUsuarioPerfil.setDescripcion("Municipal");
            }
            remUsuarioPerfil.setUsuarioId(usuario.get());
            remUsuarioPerfil.setPerfilId(perfil);
            remUsuarioPerfil.setTipoUsuario(tipoUsuario.get());
            remUsuarioPerfil.setFechaCreacion(fecha);
            remUsuarioPerfil.setFechaModificacion(fecha);
            remUsuarioPerfil.setEstado("ACT");
            remUsuarioPerfil.setTerminalCreacion(dtoDatosCreacionKeycloak.getTerminalCreacion());
            remUsuarioPerfil.setTerminalModificacion(dtoDatosCreacionKeycloak.getTerminalCreacion());
            remUsuarioPerfil.setUsuarioCreacion(dtoDatosCreacionKeycloak.getUsuarioCreacion());
            remUsuarioPerfil.setUsuarioModificacion(dtoDatosCreacionKeycloak.getUsuarioCreacion());

            if (usuarioPerfilRepository.save(remUsuarioPerfil) != null) {

                switch (dtoDatosCreacionKeycloak.getIdPerfil().toString()) {
                    case "3": //Si es Analista, debe crear tambien la tabla de Analistas
                        BigInteger tramitesMes = new BigInteger("0");
                        RemAnalista remAnalista = new RemAnalista();
                        remAnalista.setPerfilId(perfil);
                        remAnalista.setUsuarioId(usuario.get());
                        remAnalista.setCatalogoId(catalogo.get());
                        remAnalista.setEstado("ACT");
                        remAnalista.setNroTramites(tramitesMes);
                        remAnalista.setNroTramitesMes(tramitesMes);
                        remAnalista.setMesTramites(fecha);
                        remAnalista.setUsuarioCreacion(dtoDatosCreacionKeycloak.getUsuarioCreacion());
                        remAnalista.setUsuarioModificacion(dtoDatosCreacionKeycloak.getUsuarioCreacion());
                        remAnalista.setFechaCreacion(fecha);
                        remAnalista.setFechaModificacion(fecha);
                        remAnalista.setTerminalCreacion(dtoDatosCreacionKeycloak.getTerminalCreacion());
                        remAnalista.setTerminalModificacion(dtoDatosCreacionKeycloak.getTerminalCreacion());
                        servicioAnalista.guardarAsignacionAnalistas(remAnalista);
                        break;

                }

            }
            respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }
        return respuesta;

    }

    public RemUsuarioPerfil crearUsuarioCiudadano(RemUsuarios usuarioCiudadano) {
        RemUsuarioPerfil remUsuarioPerfil = new RemUsuarioPerfil();
        Date fecha = new Date();
        try {
            if (usuarioPerfilRepository.obtenerUsuarioPAM(usuarioCiudadano.getUsuarioId()).size() == 0) {
                var tipoUsuario = catalogoRepository.findById(Long.parseLong("221"));
                var perfil = servicioPerfil.obtenerPerfilById(Long.parseLong("7"));
                var usuarioId = usuariosRepository.findById(usuarioCiudadano.getUsuarioId());
                remUsuarioPerfil.setUsuarioId(usuarioId.get());
                remUsuarioPerfil.setPerfilId(perfil);
                remUsuarioPerfil.setTipoUsuario(tipoUsuario.get());
                remUsuarioPerfil.setFechaCreacion(fecha);
                remUsuarioPerfil.setFechaModificacion(fecha);
                remUsuarioPerfil.setEstado("ACT");
                remUsuarioPerfil.setTerminalCreacion(usuarioCiudadano.getTerminalCreacion());
                remUsuarioPerfil.setTerminalModificacion(usuarioCiudadano.getTerminalCreacion());
                remUsuarioPerfil.setUsuarioCreacion(usuarioCiudadano.getUsuarioCreacion());
                remUsuarioPerfil.setUsuarioModificacion(usuarioCiudadano.getUsuarioCreacion());
                remUsuarioPerfil.setDescripcion("Ciudadano");
                return usuarioPerfilRepository.save(remUsuarioPerfil);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public DtoUsuarioPerfil obtenerPerfilesUsuario(String username) {
        DtoUsuarioPerfil perfilesUsuarios = new DtoUsuarioPerfil();

        try {
            perfilesUsuarios = usuarioPerfilRepository.obtenerPerfilesUsuario(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return perfilesUsuarios;

    }

}
