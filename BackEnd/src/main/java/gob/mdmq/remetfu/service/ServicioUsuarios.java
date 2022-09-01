/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemPerfil;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.WebService.ConsultaWebServices;
import gob.mdmq.remetfu.WebService.Consultar;
import gob.mdmq.remetfu.WebService.Entidad;
import gob.mdmq.remetfu.WebService.Fila;
import gob.mdmq.remetfu.WebService.Interoperador;
import gob.mdmq.remetfu.WebService.Parametro;
import gob.mdmq.remetfu.WebService.Parametros;
import gob.mdmq.remetfu.config.ProjectProperties;
import gob.mdmq.remetfu.dto.DtoDatosCreacionKeycloak;
import gob.mdmq.remetfu.dto.DtoDatosWSPersonas;
import gob.mdmq.remetfu.dto.DtoNacionalidad;
import gob.mdmq.remetfu.dto.DtoRol;

import gob.mdmq.remetfu.dto.DtoTituloParametros;
import gob.mdmq.remetfu.dto.DtoTituloUniversitario;
import gob.mdmq.remetfu.dto.DtoUsuarioAnalista;
import gob.mdmq.remetfu.dto.DtoUsuarioPAM;
import gob.mdmq.remetfu.dto.DtoUsuarios;
import gob.mdmq.remetfu.dto.DtoUsuarioPerfil;

import gob.mdmq.remetfu.repository.CatalogoRepository;

import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioUsuarios {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private ConsultaWebServices consultaWebServices;

    @Autowired
    private ServicioUtilitario servicioUtilitario;

    @Autowired
    private ServicioPerfiles servicioPerfil;

    @Autowired
    private ServicioUsuarioPerfil servicioUsuarioPerfil;

    @Autowired
    ProjectProperties propiedades;

    @Autowired
    private ServicioWSO2 servicioWSO2;

    public List<DtoUsuarioPerfil> obtener() {
        DtoUsuarios dtoUsuarios = new DtoUsuarios();
        try {
            return usuariosRepository.obtenerListaUsuarios();
        } catch (Exception e) {
            return null;
        }

    }

    public RemUsuarios createUpdate(RemUsuarios usuarios) throws ParserConfigurationException {

        Date fecha = new Date();
        usuarios.setFechaCreacion(fecha);
        usuarios.setFechaModificacion(fecha);

        return usuariosRepository.save(usuarios);
    }

    public Object obtenerTitulos(String identificacion) throws XPathExpressionException {

        String ver = "";
        String ver2 = "";
        List<DtoTituloUniversitario> dtoTituloUniversitarioListaUnificada = null;
        List<DtoTituloUniversitario> sourceList = null;
        List<DtoTituloParametros> listaTitulos = new ArrayList<>();

        try {
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(Interoperador.class);
            factory.setAddress(propiedades.getWsDINARDAPinteroperabilidadAddress());
            factory.setUsername(propiedades.getWsDINARDAPinteroperabilidadUsername());
            factory.setPassword(propiedades.getWsDINARDAPinteroperabilidadPassword());

            Interoperador port = (Interoperador) factory.create();
            Client client = ClientProxy.getClient(port);

            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) client.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();

                policy.setAllowChunking(false);
                conduit.setClient(policy);

            }

            Parametro paramCodigoPaquete = new Parametro();
            paramCodigoPaquete.setNombre("codigoPaquete");
            paramCodigoPaquete.setValor(propiedades.getValorDinardapConsulta()); //"4262" en pruebas

            Parametro paramIdent = new Parametro();
            paramIdent.setNombre("identificacion");
            paramIdent.setValor(identificacion.trim());

            Parametros parametros = new Parametros();
            parametros.getParametro().add(paramCodigoPaquete);
            parametros.getParametro().add(paramIdent);

            Consultar consultar = new Consultar();
            consultar.setParametros(parametros);
            var response = port.consultar(parametros);

            List<Entidad> entidades = response.getEntidades().getEntidad();

            for (Entidad entidad : entidades) {

                for (Fila fila : entidad.getFilas().getFila()) {
                    //for (Columna columna : fila.getColumnas().getColumna()) {
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                    DtoTituloParametros dtoTituloParametros = new DtoTituloParametros();
                    dtoTituloParametros.setAreaTitulo(fila.getColumnas().getColumna().get(0).getValor());
                    dtoTituloParametros.setFechaRegistro(fecha.parse(fila.getColumnas().getColumna().get(1).getValor()));
                    dtoTituloParametros.setIes(fila.getColumnas().getColumna().get(2).getValor());
                    dtoTituloParametros.setNivel(fila.getColumnas().getColumna().get(3).getValor());
                    dtoTituloParametros.setNombreTitulo(fila.getColumnas().getColumna().get(4).getValor());
                    dtoTituloParametros.setNumeroIdentificacion(fila.getColumnas().getColumna().get(5).getValor());
                    dtoTituloParametros.setNumeroRegistro(fila.getColumnas().getColumna().get(6).getValor());
                    dtoTituloParametros.setSubArea(fila.getColumnas().getColumna().get(7).getValor());
                    listaTitulos.add(dtoTituloParametros);

                    //}
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaTitulos;
    }

    public Optional<RemUsuarios> obtenerById(Long id) {
        var usuarios = usuariosRepository.findById(id);

        return usuarios;
    }

    public Set<DtoUsuarioAnalista> getListaAnalistas() {
        return usuariosRepository.getListaAnalistas();
    }

    public Set<DtoUsuarioAnalista> obtenerByCedula(String nroIdentificacion) {

        return usuariosRepository.obtenerByNroIdentificacion(nroIdentificacion);
    }

    public RemUsuarios obtenerByCedula2(String nroIdentificacion) {

        return usuariosRepository.obtenerByCedula(nroIdentificacion);
    }

    @Transactional
    public DtoUsuarios obtenerPersona(String token, DtoDatosCreacionKeycloak dtoDatosCreacionKeycloak, String ipIngreso) {

        DtoUsuarioPAM dtoUsuarioPAM = new DtoUsuarioPAM();
        DtoUsuarios dtoUsuarios = new DtoUsuarios();
        Set<DtoNacionalidad> personaList = new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Document documentPersona = null;

        String cedulaPersonaPAM = "";
        String mailPersonaPAM = "";
        String movilPersonaPAM = "";
        String telefonoPersonaPAM = "";
        String cimPAM = "";
        String cimPersona = "";

        try {

            if (dtoDatosCreacionKeycloak != null) {
                documentPersona = consultaWebServices.obtenerPersona(dtoDatosCreacionKeycloak.getNroIdentificacion().trim(), 'C');
                NodeList personaPAM = documentPersona.getElementsByTagName("soap:Body");
                Node nodo = personaPAM.item(0);
                Element element = (Element) nodo;
                cimPAM = element.getElementsByTagName("PE_PERSONA_ID").item(0).getTextContent();
                dtoUsuarioPAM.setUsuarioCreacion(dtoDatosCreacionKeycloak.getUsuarioCreacion());
            } else {
                documentPersona = consultaWebServices.obtenerPersonaPAM(token);
                NodeList personaPAM = documentPersona.getElementsByTagName("s:Body");
                Node nodo = personaPAM.item(0);
                Element element = (Element) nodo;
                cedulaPersonaPAM = element.getElementsByTagName("a:PERSONA_ID").item(0).getTextContent();
                mailPersonaPAM = element.getElementsByTagName("a:CORREO").item(0).getTextContent();
                movilPersonaPAM = element.getElementsByTagName("a:CELULAR").item(0).getTextContent();
                telefonoPersonaPAM = element.getElementsByTagName("a:TELEFONO").item(0).getTextContent();
                cimPAM = element.getElementsByTagName("a:PERSONA_CIM").item(0).getTextContent();

            }

            NodeList listaPersona = documentPersona.getElementsByTagName("soap:Body");
            Node nodo = listaPersona.item(0);
            Element element = (Element) nodo;
            cimPersona = cimPAM;

            var documentPersonaCim = consultaWebServices.obtenerPersonaCim(cimPersona);
            var direccionPersona = consultaWebServices.obtenerDireccionPersona(cimPersona);

            Document discapacidadPersona = null;
            if (dtoDatosCreacionKeycloak != null) {
                if (dtoDatosCreacionKeycloak.getBanderaKeycloack().equals("S")) {
                    discapacidadPersona = consultaWebServices.obtenerPersonaDiscapacidad(dtoDatosCreacionKeycloak.getNroIdentificacion().trim(), 'C');
                }
            } else {
                discapacidadPersona = consultaWebServices.obtenerPersonaDiscapacidad(cedulaPersonaPAM.trim(), 'C');
            }

            //Datos de Persona
            NodeList listaPersonaCim = documentPersonaCim.getElementsByTagName("soap:Body");
            Node nodoPersonaCim = listaPersonaCim.item(0);
            Element elementPersonCim = (Element) nodoPersonaCim;
            //Datos de Direcciones
            NodeList listDireccionPersona = direccionPersona.getElementsByTagName("soap:Body");
            Node nodoDireccionPersona = listDireccionPersona.item(0);
            Element elementDireccionPersona = (Element) nodoDireccionPersona;
            //Datos de Discapacidad            
            NodeList listaPersonaDiscapacidad = discapacidadPersona.getElementsByTagName("soap:Body");
            Node nodoPersonaDiscapacidad = listaPersonaDiscapacidad.item(0);
            Element elementPersonDiscapacidad = (Element) nodoPersonaDiscapacidad;

            dtoUsuarioPAM.setCim(elementPersonCim.getElementsByTagName("PE_PERSONA_ID").item(0).getTextContent());
            dtoUsuarioPAM.setDenominacion(elementPersonCim.getElementsByTagName("PE_DENOMINACION").item(0).getTextContent());
            dtoUsuarioPAM.setNombres(elementPersonCim.getElementsByTagName("PE_NOMBRES").item(0).getTextContent());
            dtoUsuarioPAM.setApellidos(elementPersonCim.getElementsByTagName("PE_APELLIDOS").item(0).getTextContent());
            dtoUsuarioPAM.setIdentificacion(elementPersonCim.getElementsByTagName("PE_NUM_IDENTIFICACION").item(0).getTextContent());
            dtoUsuarioPAM.setTipoIdentificacion(elementPersonCim.getElementsByTagName("PE_TIP_IDENTIFICACION").item(0).getTextContent());
            //dtoUsuarioPAM.setMailPersonal(elementPersonCim.getElementsByTagName("PE_MAIL").item(0).getTextContent());
            dtoUsuarioPAM.setMailPersonal(mailPersonaPAM);
            dtoUsuarioPAM.setBanderaKeycloack("N");
            dtoUsuarioPAM.setMail("");

            //Cuando el tipo de Usuario es Municipal, colocamos los datos que obtenemos del keyCloack
            if (dtoDatosCreacionKeycloak != null) {
                if (dtoDatosCreacionKeycloak.getBanderaKeycloack().equals("S")) {
                    dtoUsuarioPAM.setBanderaKeycloack(dtoDatosCreacionKeycloak.getBanderaKeycloack());
                    dtoUsuarioPAM.setMail(dtoDatosCreacionKeycloak.getEmailMunicipio());
                    dtoUsuarioPAM.setUsername(dtoDatosCreacionKeycloak.getUsername());
                    dtoUsuarioPAM.setSsoId(dtoDatosCreacionKeycloak.getSsoId());
                }
            }

            Date fechaNacimiento = sdf.parse(elementPersonCim.getElementsByTagName("PE_FECHA_NACIMIENTO").item(0).getTextContent());
            dtoUsuarioPAM.setFechaNacimiento(fechaNacimiento);
            personaList = servicioUtilitario.obtenerNacionalidad();
            dtoUsuarioPAM.setNacionalidad(Long.parseLong("13"));
            for (var personaNacionalidad : personaList) {

                if (personaNacionalidad.getNombreNacionalidad().toString().equals(elementPersonCim.getElementsByTagName("PE_NACIONALIDAD").item(0).getTextContent().toString())) {
                    dtoUsuarioPAM.setNacionalidad(personaNacionalidad.getIdNacionalidad());
                }

            }
            var celular = movilPersonaPAM;
            var telefono = telefonoPersonaPAM;
            if (!celular.equals("")) {
                dtoUsuarioPAM.setCelular(celular);
            } else {
                dtoUsuarioPAM.setCelular("");

            }
            if (!telefono.equals("")) {
                dtoUsuarioPAM.setTelefono(telefono);
            } else {
                dtoUsuarioPAM.setTelefono("");
            }

            var callePrincipal = elementDireccionPersona.getElementsByTagName("DR_CALLE_PRINCIPAL").item(0);
            var interseccion = elementDireccionPersona.getElementsByTagName("DR_INTERSECCION").item(0);

            if (callePrincipal != null) {
                dtoUsuarioPAM.setDireccion(elementDireccionPersona.getElementsByTagName("DR_CALLE_PRINCIPAL").item(0).getTextContent()
                        + " ");
            } else if (interseccion != null) {
                dtoUsuarioPAM.setDireccion(" " + elementDireccionPersona.getElementsByTagName("DR_INTERSECCION").item(0).getTextContent());
            } else {
                dtoUsuarioPAM.setDireccion(" ");
            }

            var porcentaje = Integer.parseInt(elementPersonDiscapacidad.getElementsByTagName("PE_PORCENTAJE_DISCAPACIDAD").item(0).getTextContent());

            if (porcentaje > 0) {
                dtoUsuarioPAM.setDiscapacidad("SI");
            } else {
                dtoUsuarioPAM.setDiscapacidad("NO");
            }

            if (crearPersonaPAM(dtoUsuarioPAM, ipIngreso) == true) {
                if (dtoDatosCreacionKeycloak != null) {
                    dtoUsuarios = obtenerDatosUsuario(dtoDatosCreacionKeycloak.getNroIdentificacion().trim());
                } else {
                    dtoUsuarios = obtenerDatosUsuario(cedulaPersonaPAM.trim());
                }

                return dtoUsuarios;
            } else {
                dtoUsuarios = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            dtoUsuarios = null;
        }
        return dtoUsuarios;
    }

    public boolean crearPersonaPAM(DtoUsuarioPAM dtoUsuarioPAM, String ipIngreso) {
        boolean respuesta = false;
        Optional<RemCatalogo> tipoUsuario = null;
        Optional<RemCatalogo> admZonal;
        Optional<RemCatalogo> nacionalidad;
        Optional<RemCatalogo> genero;
        RemUsuarios usuarioNuevo = new RemUsuarios();
        Date fechaCreacionModificacion = new Date();
        try {

            if (dtoUsuarioPAM != null) {
                if (usuariosRepository.obtenerUsuario(dtoUsuarioPAM.getIdentificacion()).isEmpty() && dtoUsuarioPAM.getBanderaKeycloack().equals("S")) {

                    tipoUsuario = catalogoRepository.findById(Long.parseLong("222"));
                    usuarioNuevo.setTipoUsuario(tipoUsuario.get());
                    usuarioNuevo.setUsername(dtoUsuarioPAM.getUsername());
                    usuarioNuevo.setSsoId(dtoUsuarioPAM.getSsoId());
                    admZonal = catalogoRepository.findById(Long.parseLong("19"));
                    nacionalidad = catalogoRepository.findById(dtoUsuarioPAM.getNacionalidad());
                    genero = catalogoRepository.findById(Long.parseLong("238"));
                    usuarioNuevo.setCim(dtoUsuarioPAM.getCim());
                    usuarioNuevo.setTipoIdentificacion(dtoUsuarioPAM.getTipoIdentificacion().charAt(0));
                    usuarioNuevo.setNroIdentificacion(dtoUsuarioPAM.getIdentificacion());
                    usuarioNuevo.setNombres(dtoUsuarioPAM.getNombres());
                    usuarioNuevo.setApellidos(dtoUsuarioPAM.getApellidos());
                    usuarioNuevo.setDenominacion(dtoUsuarioPAM.getDenominacion());
                    usuarioNuevo.setMail(dtoUsuarioPAM.getMail());   //Insttucional
                    usuarioNuevo.setDireccion(dtoUsuarioPAM.getDireccion());
                    usuarioNuevo.setMovil(dtoUsuarioPAM.getCelular());
                    usuarioNuevo.setTelefono(dtoUsuarioPAM.getTelefono());
                    usuarioNuevo.setEstado("ACT");
                    usuarioNuevo.setTipoUsuario(tipoUsuario.get());
                    usuarioNuevo.setNacionalidad(nacionalidad.get());
                    usuarioNuevo.setDiscapacidad("NO");
                    usuarioNuevo.setUsuarioCreacion(dtoUsuarioPAM.getIdentificacion());
                    usuarioNuevo.setTerminalCreacion(ipIngreso);
                    usuarioNuevo.setFechaCreacion(fechaCreacionModificacion);
                    if (!dtoUsuarioPAM.getUsuarioCreacion().equals("")) {
                        usuarioNuevo.setUsuarioCreacion(dtoUsuarioPAM.getUsuarioCreacion());
                        usuarioNuevo.setUsuarioModificacion(dtoUsuarioPAM.getUsuarioCreacion());

                    }
                    usuarioNuevo.setClave("");
                    usuarioNuevo.setFechaModificacion(fechaCreacionModificacion);
                    usuarioNuevo.setTerminalModificacion(ipIngreso);
                    usuarioNuevo.setFechaNacimiento(dtoUsuarioPAM.getFechaNacimiento());
                    usuariosRepository.save(usuarioNuevo);
                    respuesta = true;

                } else if (usuariosRepository.obtenerUsuario(dtoUsuarioPAM.getIdentificacion()).isEmpty() && dtoUsuarioPAM.getBanderaKeycloack().equals("N")) {
                    usuarioNuevo.setUsername("");
                    usuarioNuevo.setSsoId("");
                    tipoUsuario = catalogoRepository.findById(Long.parseLong("221"));
                    usuarioNuevo.setTipoUsuario(tipoUsuario.get());
                    admZonal = catalogoRepository.findById(Long.parseLong("19"));
                    nacionalidad = catalogoRepository.findById(dtoUsuarioPAM.getNacionalidad());
                    genero = catalogoRepository.findById(Long.parseLong("238"));
                    usuarioNuevo.setCim(dtoUsuarioPAM.getCim());
                    usuarioNuevo.setTipoIdentificacion(dtoUsuarioPAM.getTipoIdentificacion().charAt(0));
                    usuarioNuevo.setNroIdentificacion(dtoUsuarioPAM.getIdentificacion());
                    usuarioNuevo.setNombres(dtoUsuarioPAM.getNombres());
                    usuarioNuevo.setApellidos(dtoUsuarioPAM.getApellidos());
                    usuarioNuevo.setDenominacion(dtoUsuarioPAM.getDenominacion());
                    usuarioNuevo.setMailPersonal(dtoUsuarioPAM.getMailPersonal());  //Personal
                    usuarioNuevo.setDireccion(dtoUsuarioPAM.getDireccion());
                    usuarioNuevo.setMovil(dtoUsuarioPAM.getCelular());
                    usuarioNuevo.setTelefono(dtoUsuarioPAM.getTelefono());
                    usuarioNuevo.setEstado("ACT");
                    usuarioNuevo.setTipoUsuario(tipoUsuario.get());
                    usuarioNuevo.setNacionalidad(nacionalidad.get());
                    usuarioNuevo.setDiscapacidad("NO");
                    usuarioNuevo.setUsuarioCreacion(dtoUsuarioPAM.getIdentificacion());
                    usuarioNuevo.setTerminalCreacion(ipIngreso);
                    usuarioNuevo.setFechaCreacion(fechaCreacionModificacion);
                    usuarioNuevo.setUsuarioModificacion(dtoUsuarioPAM.getIdentificacion());
                    usuarioNuevo.setClave("");
                    usuarioNuevo.setFechaModificacion(fechaCreacionModificacion);
                    usuarioNuevo.setTerminalModificacion(ipIngreso);
                    usuarioNuevo.setFechaNacimiento(dtoUsuarioPAM.getFechaNacimiento());
                    var usuarioCreado = usuariosRepository.save(usuarioNuevo);

                    Long usuarioCiudadanoId = tipoUsuario.get().getCatalogoId();
                    if (usuarioCiudadanoId == Long.parseLong("221")) {
                        servicioUsuarioPerfil.crearUsuarioCiudadano(usuarioCreado);
                        respuesta = true;
                    }

                } else if (!usuariosRepository.obtenerUsuario(dtoUsuarioPAM.getIdentificacion()).isEmpty() && dtoUsuarioPAM.getBanderaKeycloack().equals("S")) {
                    String usuarioId = usuariosRepository.obtenerUsuarioByCedula(dtoUsuarioPAM.getIdentificacion());
                    usuarioNuevo.setUsuarioId(Long.parseLong(usuarioId));
                    usuarioNuevo.setUsername(dtoUsuarioPAM.getUsername());
                    usuarioNuevo.setSsoId(dtoUsuarioPAM.getSsoId());
                    usuarioNuevo.setMail(dtoUsuarioPAM.getMail());
                    usuariosRepository.actualizaUsuarioKeyCloack(usuarioNuevo.getUsuarioId(), usuarioNuevo.getUsername(), usuarioNuevo.getSsoId(), usuarioNuevo.getMail());
                    respuesta = true;
                } else if (!usuariosRepository.obtenerUsuario(dtoUsuarioPAM.getIdentificacion()).isEmpty() && dtoUsuarioPAM.getBanderaKeycloack().equals("N")) {
                    String usuarioId = usuariosRepository.obtenerUsuarioByCedula(dtoUsuarioPAM.getIdentificacion());
                    usuarioNuevo.setUsuarioId(Long.parseLong(usuarioId));
                    usuarioNuevo.setMailPersonal(dtoUsuarioPAM.getMailPersonal());
                    usuarioNuevo.setDireccion(dtoUsuarioPAM.getDireccion());
                    usuarioNuevo.setMovil(dtoUsuarioPAM.getCelular());
                    usuarioNuevo.setTelefono(dtoUsuarioPAM.getTelefono());
                    servicioUsuarioPerfil.crearUsuarioCiudadano(usuarioNuevo);
                    usuariosRepository.actualizaUsuarioPAM(usuarioNuevo.getUsuarioId(), usuarioNuevo.getMailPersonal(), usuarioNuevo.getDireccion(), usuarioNuevo.getMovil(), usuarioNuevo.getTelefono());
                    respuesta = true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }

    public DtoUsuarios obtenerDatosUsuario(String nroIdentificacion) throws ParseException {
        DtoUsuarios dtoUsuarios = new DtoUsuarios();
        try {

            List<String> datos = usuariosRepository.obtenerDatosUsuario(nroIdentificacion);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            var data = datos.get(0);
            String[] split = data.split(",");
            List<String> listaDatos = new ArrayList<>();

            for (int i = 0; i < split.length; i++) {

                listaDatos.add(split[i]);
            }

            dtoUsuarios.setUsuarioId(Long.parseLong(listaDatos.get(0).toString()));
            char tipoIdentificacion = listaDatos.get(1).toString().charAt(0);
            dtoUsuarios.setTipoIdentificacion(tipoIdentificacion);
            dtoUsuarios.setNroIdentificacion(listaDatos.get(2).toString().trim());
            dtoUsuarios.setDenominacion(listaDatos.get(3).toString());
            dtoUsuarios.setNombres(listaDatos.get(4).toString());
            dtoUsuarios.setApellidos(listaDatos.get(5).toString());
            dtoUsuarios.setMail(listaDatos.get(6).toString());
            dtoUsuarios.setDireccion(listaDatos.get(7).toString());
            dtoUsuarios.setTelefono(listaDatos.get(8).toString());
            dtoUsuarios.setMovil(listaDatos.get(9).toString());
            dtoUsuarios.setAceptacionMedios(listaDatos.get(10).toString());
            dtoUsuarios.setEstado(listaDatos.get(11).toString());
            dtoUsuarios.setCim(listaDatos.get(12).toString());
            dtoUsuarios.setUsername(listaDatos.get(13).toString());
            dtoUsuarios.setClave(listaDatos.get(14).toString());
            dtoUsuarios.setTipoUsuario(Long.parseLong(listaDatos.get(15).toString()));
            dtoUsuarios.setTipoUsuarioDesc(listaDatos.get(16).toString());
            dtoUsuarios.setAdmZonal(Long.parseLong(listaDatos.get(17).toString()));
            dtoUsuarios.setAdmZonalDesc(listaDatos.get(18).toString());
            Date fechaNacimiento = sdf.parse(listaDatos.get(19).toString());
            dtoUsuarios.setFechaNacimiento(fechaNacimiento);
            dtoUsuarios.setNacionalidad(Long.parseLong(listaDatos.get(20).toString()));
            dtoUsuarios.setNacionalidadDesc(listaDatos.get(21).toString());
            dtoUsuarios.setGenero(Long.parseLong(listaDatos.get(22).toString()));
            dtoUsuarios.setGeneroDesc(listaDatos.get(23).toString());
            dtoUsuarios.setMailPersonal(listaDatos.get(24).toString());
            dtoUsuarios.setDiscapacidad(listaDatos.get(25).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoUsuarios;

    }

    @Transactional
    public boolean crearAsignarUsuario(DtoDatosCreacionKeycloak dtoDatosCreacionKeycloak) {
        boolean respuesta = false;
        String ip = dtoDatosCreacionKeycloak.getTerminalCreacion();

        try {

            //Primer proceso, insertar en tabla Usuarios
            //sacar del dto 
            if (obtenerPersona(dtoDatosCreacionKeycloak.getNroIdentificacion(), dtoDatosCreacionKeycloak, ip) != null) {
                var usuarioCreado = usuariosRepository.obtenerByCedula(dtoDatosCreacionKeycloak.getNroIdentificacion());

                if (servicioUsuarioPerfil.crearUsuarioPerfil(usuarioCreado.getUsuarioId(), dtoDatosCreacionKeycloak)) {
                    Object usuarios = servicioWSO2.obtenerUsuario(dtoDatosCreacionKeycloak.getUsername());
                    Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonEspecialista = prettyGson.toJson(usuarios);
                    String respuestas = jsonEspecialista.toString().substring(1, jsonEspecialista.toString().length() - 1);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode node = mapper.readValue(respuestas, JsonNode.class);
                    JsonNode ssoId = node.get("ssoId");
                    RemPerfil perfil = servicioPerfil.obtenerPerfilById(dtoDatosCreacionKeycloak.getIdPerfil());

                    String nombrePerfil = perfil.getNombre();
                    DtoRol[] roles = servicioWSO2.getRoles(propiedades.getKeycloakClientId());
                    List<DtoRol> rolesAsignar = new ArrayList<DtoRol>();

                    for (DtoRol rol : roles) {
                        var ver = rol.getName();
                        if (rol.getName().equals(nombrePerfil)) {
                            rolesAsignar.add(rol);
                        }
                    }
                    if (servicioWSO2.asignarRoles(ssoId.asText(), propiedades.getKeycloakClientId(), rolesAsignar) != 0) {
                        respuesta = true;
                    } else {
                        respuesta = false;
                    }

                } else {
                    respuesta = false;
                }
            }

        } catch (Exception e) {
            respuesta = false;
            e.printStackTrace();
        }
        return respuesta;
    }

    //obtenerUsuariosNombres
    public Set<DtoUsuarios> obtenerUsuariosNombresAnalistas(String nombre) {
        try {
            return usuariosRepository.obtenerUsuariosNombresAnalistas(nombre);
        } catch (Exception e) {
            return null;
        }
    }
        public Set<DtoUsuarios> obtenerUsuariosNombres(String nombre) {
        try {
            return usuariosRepository.obtenerUsuariosNombres(nombre);
        } catch (Exception e) {
            return null;
        }
    }

    public DtoDatosWSPersonas obtenerDatosWSPersonas(String identificacion) {

        DtoDatosWSPersonas datosDtoWSPersonas = new DtoDatosWSPersonas();
        Document documentPersona = null;
        try {

            if (identificacion.length() == 10) {
                documentPersona = consultaWebServices.obtenerPersona(identificacion, 'C');
            } else {
                documentPersona = consultaWebServices.obtenerPersona(identificacion, 'R');
            }

            NodeList listaPersona = documentPersona.getElementsByTagName("soap:Body");
            Node nodo = listaPersona.item(0);
            Element element = (Element) nodo;
            var cimPersona = element.getElementsByTagName("PE_PERSONA_ID").item(0).getTextContent();
            var documentPersonaCim = consultaWebServices.obtenerPersonaCim(cimPersona);
            NodeList listaPersonaCim = documentPersonaCim.getElementsByTagName("soap:Body");
            Node nodoPersonaCim = listaPersonaCim.item(0);
            Element elelemtPersonCim = (Element) nodoPersonaCim;

            datosDtoWSPersonas.setCim(elelemtPersonCim.getElementsByTagName("PE_PERSONA_ID").item(0)
                    .getTextContent());
            datosDtoWSPersonas
                    .setDenominacion(elelemtPersonCim.getElementsByTagName("PE_DENOMINACION")
                            .item(0).getTextContent());
            datosDtoWSPersonas.setNombres(
                    elelemtPersonCim.getElementsByTagName("PE_NOMBRES").item(0).getTextContent());
            datosDtoWSPersonas
                    .setApellidos(elelemtPersonCim.getElementsByTagName("PE_APELLIDOS").item(0)
                            .getTextContent());
            datosDtoWSPersonas.setIdentificacion(
                    elelemtPersonCim.getElementsByTagName("PE_NUM_IDENTIFICACION").item(0)
                            .getTextContent());
            datosDtoWSPersonas.setTipoIdentificacion(
                    elelemtPersonCim.getElementsByTagName("PE_TIP_IDENTIFICACION").item(0)
                            .getTextContent());
            datosDtoWSPersonas.setMail(
                    elelemtPersonCim.getElementsByTagName("PE_MAIL").item(0).getTextContent());

            datosDtoWSPersonas.setCelular(
                    elelemtPersonCim.getElementsByTagName("PE_CELULAR").item(0).getTextContent());
            datosDtoWSPersonas
                    .setTelefono(elelemtPersonCim.getElementsByTagName("PE_TELEFONO").item(0)
                            .getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
            datosDtoWSPersonas = null;
        }
        return datosDtoWSPersonas;
    }

    @Transactional
    public boolean ActivarOInactivarUsuario(DtoUsuarioPerfil dtoUsuarioPerfil, String terminalModificacion, String usuarioModificacion, String proceso) {
        try {
            var estado="";
            var rolUsuario = dtoUsuarioPerfil.getNombre();
            DtoRol[] roles = servicioWSO2.getRoles(propiedades.getKeycloakClientId());
            List<DtoRol> rolesUsuario = new ArrayList<DtoRol>();
            for (DtoRol rol : roles) {
                if (rol.getName().equals(rolUsuario)) {
                    rolesUsuario.add(rol);
                }
            }
            if (proceso.equals("1")) {
                estado = "INA";
                if (servicioWSO2.quitarRoles(dtoUsuarioPerfil.getSsoId(), propiedades.getKeycloakClientId(), rolesUsuario) != 0) {
                    usuariosRepository.inactivarOActivarUsuario(dtoUsuarioPerfil.getUsuarioId(), estado);
                    return true;
                }
            } else if (proceso.equals("0")) {
                estado = "ACT";
                if (servicioWSO2.asignarRoles(dtoUsuarioPerfil.getSsoId(), propiedades.getKeycloakClientId(), rolesUsuario) != 0) {
                    usuariosRepository.inactivarOActivarUsuario(dtoUsuarioPerfil.getUsuarioId(), estado);
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }

}
