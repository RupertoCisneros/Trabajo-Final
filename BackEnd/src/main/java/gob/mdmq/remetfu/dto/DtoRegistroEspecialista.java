/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.ToString;

/**
 *
 * @author srcisnerosv
 */


@ToString
@JsonIgnoreProperties( ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoRegistroEspecialista {

    //Datos de Entidad de Usuario
    private Long usuarioId;
    private Character tipoIdentificacion;
    private String nroIdentificacion;
    private String denominacion;
    private String mail;
    private String direccion;
    private String telefono;
    private String movil;
    private String aceptacionMedios;
    private String estado;
    private String cim;
    private String clave;
    private Long tipoUsuario;
    private String tipoUsuarioDesc;  //Viene de Catalogo, cod=30
    private Long admZonal;
    private String admZonalDesc;     //Viene de Catalogo, cod=3
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    private Long nacionalidad;
    private String nacionalidadDesc;//Viene de Catalogo, cod=2
    private Long genero;
    private String generoDesc;      //Viene de Catalogo, cod=34
    private String discapacidad;

    //Datos de Entidad de Registro Profesional
    private Long registroProfesionalId;
    private String pathVisatrabajo;
    private String barrio;
    private String callePrincipal;
    private String calleNumero;
    private String calleSecundaria;
    private String calleReferencia1;
    private String calleReferencia2;
    private String estadoRegistro;
    private String agremiado;
    private String nombreGremio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInactivo;
    private int diasInactivo;
    private Long secuencialTmp;
    private Long secuencialFinal;
    private String acuerdoResponsabilidad;
    private Long subtipoRegistro;
    private String subtipoRegistroDesc;
    private Long parroquia;
    private String parroquiaDesc;
    
    //Datos de Entidad de Perfil Académico
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    private String institucionEmite;
    private Long perfilAcademico;
    private String perfilAcademicoDesc;
    
    //Datos de Entidad de Titulo Profesional
    private String nroRegistro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroTitulo;
    private String nombreTitulo;
    private String institucionTitulo;
    private String nivelTitulo;
    private String tipoTitulo;
    private String reconocidoPor;
    private String nombres;
    private String apellidos;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsigna;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRechazo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucion;
    private String novedadAprobacion;
    private String motivoDevolucion;
    private String motivoRechazo;
    private String nroRegistroProfesional;
    private String mailPersonal;
    private String estadoRegistros;
    

    public DtoRegistroEspecialista() {
    }

    public DtoRegistroEspecialista(Long usuarioId, Character tipoIdentificacion, String nroIdentificacion, String denominacion, String mail, String direccion, String telefono, String movil, String aceptacionMedios, String estado, String cim, String clave, Long tipoUsuario, String tipoUsuarioDesc, Long admZonal, String admZonalDesc, Date fechaNacimiento, Long nacionalidad, String nacionalidadDesc, Long genero, String generoDesc, String discapacidad, Long registroProfesionalId, String pathVisatrabajo, String barrio, String callePrincipal, String calleNumero, String calleSecundaria, String calleReferencia1, String calleReferencia2, String estadoRegistro, String agremiado, String nombreGremio, Date fechaInactivo, int diasInactivo, Long secuencialTmp, Long secuencialFinal, String acuerdoResponsabilidad, Long subtipoRegistro, String subtipoRegistroDesc, Long parroquia, String parroquiaDesc, Date fechaRegistro, String institucionEmite, Long perfilAcademico, String perfilAcademicoDesc, String nroRegistro, Date fechaRegistroTitulo, String nombreTitulo, String institucionTitulo, String nivelTitulo, String tipoTitulo, String reconocidoPor, String nombres, String apellidos, Date fechaAsigna, Date fechaVigencia, Date fechaRechazo, Date fechaAprobacion, Date fechaDevolucion, String novedadAprobacion, String motivoDevolucion, String motivoRechazo, String nroRegistroProfesional, String mailPersonal, String estadoRegistros) {
        this.usuarioId = usuarioId;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nroIdentificacion = nroIdentificacion;
        this.denominacion = denominacion;
        this.mail = mail;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.aceptacionMedios = aceptacionMedios;
        this.estado = estado;
        this.cim = cim;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
        this.tipoUsuarioDesc = tipoUsuarioDesc;
        this.admZonal = admZonal;
        this.admZonalDesc = admZonalDesc;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.nacionalidadDesc = nacionalidadDesc;
        this.genero = genero;
        this.generoDesc = generoDesc;
        this.discapacidad = discapacidad;
        this.registroProfesionalId = registroProfesionalId;
        this.pathVisatrabajo = pathVisatrabajo;
        this.barrio = barrio;
        this.callePrincipal = callePrincipal;
        this.calleNumero = calleNumero;
        this.calleSecundaria = calleSecundaria;
        this.calleReferencia1 = calleReferencia1;
        this.calleReferencia2 = calleReferencia2;
        this.estadoRegistro = estadoRegistro;
        this.agremiado = agremiado;
        this.nombreGremio = nombreGremio;
        this.fechaInactivo = fechaInactivo;
        this.diasInactivo = diasInactivo;
        this.secuencialTmp = secuencialTmp;
        this.secuencialFinal = secuencialFinal;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.subtipoRegistro = subtipoRegistro;
        this.subtipoRegistroDesc = subtipoRegistroDesc;
        this.parroquia = parroquia;
        this.parroquiaDesc = parroquiaDesc;
        this.fechaRegistro = fechaRegistro;
        this.institucionEmite = institucionEmite;
        this.perfilAcademico = perfilAcademico;
        this.perfilAcademicoDesc = perfilAcademicoDesc;
        this.nroRegistro = nroRegistro;
        this.fechaRegistroTitulo = fechaRegistroTitulo;
        this.nombreTitulo = nombreTitulo;
        this.institucionTitulo = institucionTitulo;
        this.nivelTitulo = nivelTitulo;
        this.tipoTitulo = tipoTitulo;
        this.reconocidoPor = reconocidoPor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaAsigna = fechaAsigna;
        this.fechaVigencia = fechaVigencia;
        this.fechaRechazo = fechaRechazo;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaDevolucion = fechaDevolucion;
        this.novedadAprobacion = novedadAprobacion;
        this.motivoDevolucion = motivoDevolucion;
        this.motivoRechazo = motivoRechazo;
        this.nroRegistroProfesional = nroRegistroProfesional;
        this.mailPersonal = mailPersonal;
        this.estadoRegistros = estadoRegistros;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Character getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Character tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getAceptacionMedios() {
        return aceptacionMedios;
    }

    public void setAceptacionMedios(String aceptacionMedios) {
        this.aceptacionMedios = aceptacionMedios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Long tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuarioDesc() {
        return tipoUsuarioDesc;
    }

    public void setTipoUsuarioDesc(String tipoUsuarioDesc) {
        this.tipoUsuarioDesc = tipoUsuarioDesc;
    }

    public Long getAdmZonal() {
        return admZonal;
    }

    public void setAdmZonal(Long admZonal) {
        this.admZonal = admZonal;
    }

    public String getAdmZonalDesc() {
        return admZonalDesc;
    }

    public void setAdmZonalDesc(String admZonalDesc) {
        this.admZonalDesc = admZonalDesc;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Long nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidadDesc() {
        return nacionalidadDesc;
    }

    public void setNacionalidadDesc(String nacionalidadDesc) {
        this.nacionalidadDesc = nacionalidadDesc;
    }

    public Long getGenero() {
        return genero;
    }

    public void setGenero(Long genero) {
        this.genero = genero;
    }

    public String getGeneroDesc() {
        return generoDesc;
    }

    public void setGeneroDesc(String generoDesc) {
        this.generoDesc = generoDesc;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Long getRegistroProfesionalId() {
        return registroProfesionalId;
    }

    public void setRegistroProfesionalId(Long registroProfesionalId) {
        this.registroProfesionalId = registroProfesionalId;
    }

    public String getPathVisatrabajo() {
        return pathVisatrabajo;
    }

    public void setPathVisatrabajo(String pathVisatrabajo) {
        this.pathVisatrabajo = pathVisatrabajo;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getCalleReferencia1() {
        return calleReferencia1;
    }

    public void setCalleReferencia1(String calleReferencia1) {
        this.calleReferencia1 = calleReferencia1;
    }

    public String getCalleReferencia2() {
        return calleReferencia2;
    }

    public void setCalleReferencia2(String calleReferencia2) {
        this.calleReferencia2 = calleReferencia2;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getAgremiado() {
        return agremiado;
    }

    public void setAgremiado(String agremiado) {
        this.agremiado = agremiado;
    }

    public String getNombreGremio() {
        return nombreGremio;
    }

    public void setNombreGremio(String nombreGremio) {
        this.nombreGremio = nombreGremio;
    }

    public Date getFechaInactivo() {
        return fechaInactivo;
    }

    public void setFechaInactivo(Date fechaInactivo) {
        this.fechaInactivo = fechaInactivo;
    }

    public int getDiasInactivo() {
        return diasInactivo;
    }

    public void setDiasInactivo(int diasInactivo) {
        this.diasInactivo = diasInactivo;
    }

    public Long getSecuencialTmp() {
        return secuencialTmp;
    }

    public void setSecuencialTmp(Long secuencialTmp) {
        this.secuencialTmp = secuencialTmp;
    }

    public Long getSecuencialFinal() {
        return secuencialFinal;
    }

    public void setSecuencialFinal(Long secuencialFinal) {
        this.secuencialFinal = secuencialFinal;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
    }

    public Long getSubtipoRegistro() {
        return subtipoRegistro;
    }

    public void setSubtipoRegistro(Long subtipoRegistro) {
        this.subtipoRegistro = subtipoRegistro;
    }

    public String getSubtipoRegistroDesc() {
        return subtipoRegistroDesc;
    }

    public void setSubtipoRegistroDesc(String subtipoRegistroDesc) {
        this.subtipoRegistroDesc = subtipoRegistroDesc;
    }

    public Long getParroquia() {
        return parroquia;
    }

    public void setParroquia(Long parroquia) {
        this.parroquia = parroquia;
    }

    public String getParroquiaDesc() {
        return parroquiaDesc;
    }

    public void setParroquiaDesc(String parroquiaDesc) {
        this.parroquiaDesc = parroquiaDesc;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getInstitucionEmite() {
        return institucionEmite;
    }

    public void setInstitucionEmite(String institucionEmite) {
        this.institucionEmite = institucionEmite;
    }

    public Long getPerfilAcademico() {
        return perfilAcademico;
    }

    public void setPerfilAcademico(Long perfilAcademico) {
        this.perfilAcademico = perfilAcademico;
    }

    public String getPerfilAcademicoDesc() {
        return perfilAcademicoDesc;
    }

    public void setPerfilAcademicoDesc(String perfilAcademicoDesc) {
        this.perfilAcademicoDesc = perfilAcademicoDesc;
    }

    public String getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(String nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public Date getFechaRegistroTitulo() {
        return fechaRegistroTitulo;
    }

    public void setFechaRegistroTitulo(Date fechaRegistroTitulo) {
        this.fechaRegistroTitulo = fechaRegistroTitulo;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getInstitucionTitulo() {
        return institucionTitulo;
    }

    public void setInstitucionTitulo(String institucionTitulo) {
        this.institucionTitulo = institucionTitulo;
    }

    public String getNivelTitulo() {
        return nivelTitulo;
    }

    public void setNivelTitulo(String nivelTitulo) {
        this.nivelTitulo = nivelTitulo;
    }

    public String getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(String tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public String getReconocidoPor() {
        return reconocidoPor;
    }

    public void setReconocidoPor(String reconocidoPor) {
        this.reconocidoPor = reconocidoPor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaAsigna() {
        return fechaAsigna;
    }

    public void setFechaAsigna(Date fechaAsigna) {
        this.fechaAsigna = fechaAsigna;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Date getFechaRechazo() {
        return fechaRechazo;
    }

    public void setFechaRechazo(Date fechaRechazo) {
        this.fechaRechazo = fechaRechazo;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getNovedadAprobacion() {
        return novedadAprobacion;
    }

    public void setNovedadAprobacion(String novedadAprobacion) {
        this.novedadAprobacion = novedadAprobacion;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public String getNroRegistroProfesional() {
        return nroRegistroProfesional;
    }

    public void setNroRegistroProfesional(String nroRegistroProfesional) {
        this.nroRegistroProfesional = nroRegistroProfesional;
    }

    public String getEstadoRegistros() {
        return estadoRegistros;
    }

    public String getMailPersonal() {
        return mailPersonal;
    }

    public void setMailPersonal(String mailPersonal) {
        this.mailPersonal = mailPersonal;
    }

    public void setEstadoRegistros(String estadoRegistros) {
        this.estadoRegistros = estadoRegistros;
    }
    
}
