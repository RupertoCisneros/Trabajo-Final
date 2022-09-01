/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package gob.mdmq.remetfu.controller;

import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoDatosCreacionKeycloak;
import gob.mdmq.remetfu.dto.DtoResponse;
import gob.mdmq.remetfu.dto.DtoToken;
import gob.mdmq.remetfu.dto.DtoUsuarioAnalista;
import gob.mdmq.remetfu.dto.DtoUsuarioPerfil;
import gob.mdmq.remetfu.dto.DtoUsuarios;
import gob.mdmq.remetfu.repository.PerfilRepository;
import gob.mdmq.remetfu.service.ServicioUsuarios;
import gob.mdmq.remetfu.service.ServicioWSO2;
import gob.mdmq.remetfu.utilitarios.ClsLog;
import java.net.URI;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author srcisnerosv
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UsuariosRestController {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @Autowired
    private ServicioWSO2 servicioWSO2;

    @Autowired
    private ClsLog logArchivos;

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping("/obtenerUsuarios")
    public List<DtoUsuarioPerfil> obtenerUsuarios() {
        try {
            List<DtoUsuarioPerfil> lista = servicioUsuarios.obtener();
            return lista;
        } catch (Exception e) {
            return null;

        }
    }

    @GetMapping("/obtenerUsuariosActivos")
    public ResponseEntity<Set<DtoUsuarioAnalista>> obtenerUsuariosActivos() {
        try {
            var v = perfilRepository.findById(Long.parseLong("3"));
            return ResponseEntity.ok(servicioUsuarios.getListaAnalistas());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/obtenerUsuarioByCedula/{nroIdentificacion}")
    public ResponseEntity<Set<DtoUsuarioAnalista>> obtenerUsuarioByCedula(@PathVariable(value = "nroIdentificacion") String nroIdentificacion) {
        try {
            return ResponseEntity.ok(servicioUsuarios.obtenerByCedula(nroIdentificacion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping
    public ResponseEntity<RemUsuarios> post(@RequestBody RemUsuarios usuarios) {

        try {
            RemUsuarios p = servicioUsuarios.createUpdate(usuarios);
            return ResponseEntity.created(new URI("/api/usuarios" + p.getUsuarioId())).body(p);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/usuario/titulos/{identificacion}")
    public ResponseEntity<Object> obtenerTitulos(@PathVariable("identificacion") String identificacion) throws ClassNotFoundException {
        try {

            return ResponseEntity.ok(servicioUsuarios.obtenerTitulos(identificacion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/crearPersonasPAM/{token}/{ip}")
    public ResponseEntity<?> crearPersonasPAM(@PathVariable("token") String token, @PathVariable("ip") String ipIngreso) {

        DtoDatosCreacionKeycloak creacionKeycloak = null;
        try {
//            servicioUsuarios.generarOrdenPago();
            if (!token.equals("")) {
                var persona = servicioUsuarios.obtenerPersona(token, creacionKeycloak, ipIngreso);
                if (persona != null) {
                    return new ResponseEntity<>(persona, HttpStatus.CREATED);

                } else {
                    return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "No se encontraron datos"), HttpStatus.BAD_REQUEST);

                }
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Token no valido"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/datosUsuario/{identificacion}")
    public ResponseEntity<Object> obtenerDatosUsuario(@PathVariable("identificacion") String identificacion) throws ClassNotFoundException {
        try {

            return ResponseEntity.ok(servicioUsuarios.obtenerDatosUsuario(identificacion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping(path = "/get-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DtoToken> getToken() {
        try {
            DtoToken usuario = servicioWSO2.getToken();

            return ResponseEntity.ok(usuario);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping(path = "/get-roles/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRoles(@PathVariable String clientId) {
        try {
            Object usuario = servicioWSO2.getRoles(clientId);

            return ResponseEntity.ok(usuario);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path = "/obtenerUsuarioKeyCloack/{usuario}")
    public ResponseEntity<List<DtoUsuarioPerfil>> obtenerUsuarioKeyCloack(@PathVariable String usuario) {
        try {
            List<DtoUsuarioPerfil> usuarios = servicioWSO2.obtenerUsuario(usuario);

            return ResponseEntity.ok(usuarios);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping("/consultaNombresAnalistas/{nombre}")
    public Object consultaNombresAnalistas(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok(servicioUsuarios.obtenerUsuariosNombresAnalistas(nombre));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }
        @GetMapping("/consultaNombres/{nombre}")
    public Object consultaNombres(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok(servicioUsuarios.obtenerUsuariosNombres(nombre));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    @PostMapping("/crearAsignarUsuario")
    public ResponseEntity<?> crearAsignarUsuario(@RequestBody DtoDatosCreacionKeycloak dtoDatosCreacionKeycloak) {
        try {
            if (servicioUsuarios.crearAsignarUsuario(dtoDatosCreacionKeycloak)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(), "Datos Grabados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);

            }
        } catch (Exception e) {
            //Logs
            logArchivos.RegistrarError("Usuario", e.getMessage(), "crearUsuarioLocaAutoridad");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/usuarioPersonas/{nroIdentificacion}")
    public ResponseEntity<Object> obtenerDatosWSPersonas(@PathVariable String nroIdentificacion)
            throws ClassNotFoundException {
        try {
            return ResponseEntity.ok(servicioUsuarios.obtenerDatosWSPersonas(nroIdentificacion));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/inactivarUsuario/{terminalModificacion}/{usuarioModificacion}/{proceso}")
    public ResponseEntity<?> inactivarUsuario(
            @PathVariable(value = "terminalModificacion") String terminalModificacion,
            @PathVariable(value = "usuarioModificacion") String usuarioModificacion,
            @PathVariable(value = "proceso") String proceso,
            @RequestBody DtoUsuarioPerfil dtoUsuarioPerfil) {
        try {
            if (servicioUsuarios.ActivarOInactivarUsuario(dtoUsuarioPerfil, terminalModificacion, usuarioModificacion, proceso)) {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.CREATED.value(),"Datos grabados correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            //Logs
            logArchivos.RegistrarError("Usuario", e.getMessage(), "crearUsuarioLocaAutoridad");
            return new ResponseEntity<DtoResponse>(new DtoResponse(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
        }
    }
}
