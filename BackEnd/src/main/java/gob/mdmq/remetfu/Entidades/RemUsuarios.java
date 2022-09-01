/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_USUARIOS", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(name = "REM_USUARIOS_UNQ01", columnNames = {"NRO_IDENTIFICACION"})})
public class RemUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;
    @Size(max = 15)
    @Column(length = 15)
    private String movil;
    @Size(max = 3)
    @Column(length = 3)
    private String discapacidad;
    @Column(name = "TIPO_IDENTIFICACION")
    private Character tipoIdentificacion;
    @Column(name = "NRO_IDENTIFICACION", length = 13)
    private String nroIdentificacion;
    @Column(name = "DENOMINACION", length = 80)
    private String denominacion;
    @Column(name = "MAIL", length = 60)
    private String mail;
    @Column(name = "MAIL_PERSONAL", length = 60)
    private String mailPersonal;
    @Column(name = "DIRECCION", length = 200)
    private String direccion;
    @Column(name = "TELEFONO", length = 10)
    private String telefono;
    @Column(name = "ACEPTACION_MEDIOS", length = 10)
    private String aceptacionMedios;
    @Column(name = "ESTADO", length = 3)
    private String estado;
    @Column(name = "CIM", length = 30)
    private String cim;
    @Basic(optional = false)
    @Column(name = "USUARIO_CREACION", nullable = false, length = 30)
    private String usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "TERMINAL_CREACION", nullable = false, length = 30)
    private String terminalCreacion;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "USUARIO_MODIFICACION", nullable = false, length = 30)
    private String usuarioModificacion;
    @Basic(optional = false)
    @Column(name = "TERMINAL_MODIFICACION", nullable = false, length = 30)
    private String terminalModificacion;
    @Basic(optional = false)
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "SSO_ID", length = 100)
    private String ssoId;
    @Column(name = "USERNAME", length = 30)
    private String username;
    @Basic(optional = false)
    @Column(name = "CLAVE", nullable = false, length = 30)
    private String clave;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @Basic(optional = false)
    @Column(name = "NOMBRES", nullable = false, length = 50)
    private String nombres;

    @Basic(optional = false)
    @Column(name = "APELLIDOS", nullable = false, length = 50)
    private String apellidos;

    @JoinColumn(name = "TIPO_USUARIO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("tipoUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo tipoUsuario;

    @JoinColumn(name = "ADM_ZONAL", referencedColumnName = "CATALOGO_ID")
    @JsonBackReference("admZonal")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemCatalogo admZonal;

    @JoinColumn(name = "NACIONALIDAD", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("nacionalidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo nacionalidad;

    @JoinColumn(name = "GENERO", referencedColumnName = "CATALOGO_ID")
    @JsonBackReference("genero")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemCatalogo genero;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<RemRegistroProfesional> remRegistroProfesionalSet;

    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<RemUsuarioPerfil> remUsuarioPerfilSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<RemAnalista> remAnalisistaSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<RemTutorMascota> remTutorMascotaSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioUba", fetch = FetchType.LAZY)
    private Set<RemMicrochipMascotaUba> remMicrochipMascotaUbaSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioUba", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioUba", fetch = FetchType.LAZY)
    private Set<RemRetiroAnimales> remRetiroAnimalesSet;

    public RemUsuarios() {
    }

    public RemUsuarios(Long usuarioId, Character tipoIdentificacion, String nroIdentificacion, String denominacion, String mail, String mailPersonal, String direccion, String telefono, String aceptacionMedios, String estado, String cim, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, String movil, String ssoId, String username, String clave, String discapacidad, Date fechaNacimiento, String nombres, String apellidos, RemCatalogo tipoUsuario, RemCatalogo admZonal, RemCatalogo nacionalidad, RemCatalogo genero) {
        this.usuarioId = usuarioId;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nroIdentificacion = nroIdentificacion;
        this.denominacion = denominacion;
        this.mail = mail;
        this.mailPersonal = mailPersonal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.aceptacionMedios = aceptacionMedios;
        this.estado = estado;
        this.cim = cim;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.movil = movil;
        this.ssoId = ssoId;
        this.username = username;
        this.clave = clave;
        this.discapacidad = discapacidad;
        this.fechaNacimiento = fechaNacimiento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoUsuario = tipoUsuario;
        this.admZonal = admZonal;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
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

    public String getMailPersonal() {
        return mailPersonal;
    }

    public void setMailPersonal(String mailPersonal) {
        this.mailPersonal = mailPersonal;
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

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getTerminalCreacion() {
        return terminalCreacion;
    }

    public void setTerminalCreacion(String terminalCreacion) {
        this.terminalCreacion = terminalCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getTerminalModificacion() {
        return terminalModificacion;
    }

    public void setTerminalModificacion(String terminalModificacion) {
        this.terminalModificacion = terminalModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public Set<RemRegistroProfesional> getRemRegistroProfesionalSet() {
        return remRegistroProfesionalSet;
    }

    public void setRemRegistroProfesionalSet(Set<RemRegistroProfesional> remRegistroProfesionalSet) {
        this.remRegistroProfesionalSet = remRegistroProfesionalSet;
    }

    public Set<RemUsuarioPerfil> getRemUsuarioPerfilSet() {
        return remUsuarioPerfilSet;
    }

    public void setRemUsuarioPerfilSet(Set<RemUsuarioPerfil> remUsuarioPerfilSet) {
        this.remUsuarioPerfilSet = remUsuarioPerfilSet;
    }

    public Set<RemAnalista> getRemAnalisistaSet() {
        return remAnalisistaSet;
    }

    public void setRemAnalisistaSet(Set<RemAnalista> remAnalisistaSet) {
        this.remAnalisistaSet = remAnalisistaSet;
    }

    public Set<RemTutorMascota> getRemTutorMascotaSet() {
        return remTutorMascotaSet;
    }

    public void setRemTutorMascotaSet(Set<RemTutorMascota> remTutorMascotaSet) {
        this.remTutorMascotaSet = remTutorMascotaSet;
    }

    private static final Logger LOG = Logger.getLogger(RemUsuarios.class.getName());

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public RemCatalogo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(RemCatalogo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public RemCatalogo getAdmZonal() {
        return admZonal;
    }

    public void setAdmZonal(RemCatalogo admZonal) {
        this.admZonal = admZonal;
    }

    public RemCatalogo getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(RemCatalogo nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public RemCatalogo getGenero() {
        return genero;
    }

    public void setGenero(RemCatalogo genero) {
        this.genero = genero;
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

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet() {
        return remAtencionAnimalesSet;
    }

    public void setRemAtencionAnimalesSet(Set<RemAtencionAnimales> remAtencionAnimalesSet) {
        this.remAtencionAnimalesSet = remAtencionAnimalesSet;
    }

    public Set<RemRetiroAnimales> getRemRetiroAnimalesSet() {
        return remRetiroAnimalesSet;
    }

    public void setRemRetiroAnimalesSet(Set<RemRetiroAnimales> remRetiroAnimalesSet) {
        this.remRetiroAnimalesSet = remRetiroAnimalesSet;
    }

    public Set<RemMicrochipMascotaUba> getRemMicrochipMascotaUbaSet() {
        return remMicrochipMascotaUbaSet;
    }

    public void setRemMicrochipMascotaUbaSet(Set<RemMicrochipMascotaUba> remMicrochipMascotaUbaSet) {
        this.remMicrochipMascotaUbaSet = remMicrochipMascotaUbaSet;
    }

    @Override
    public String toString() {
        return "RemUsuarios{" + "usuarioId=" + usuarioId + ", movil=" + movil + ", discapacidad=" + discapacidad + ", tipoIdentificacion=" + tipoIdentificacion + ", nroIdentificacion=" + nroIdentificacion + ", denominacion=" + denominacion + ", mail=" + mail + ", mailPersonal=" + mailPersonal + ", direccion=" + direccion + ", telefono=" + telefono + ", aceptacionMedios=" + aceptacionMedios + ", estado=" + estado + ", cim=" + cim + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", ssoId=" + ssoId + ", username=" + username + ", clave=" + clave + ", fechaNacimiento=" + fechaNacimiento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", tipoUsuario=" + tipoUsuario + ", admZonal=" + admZonal + ", nacionalidad=" + nacionalidad + ", genero=" + genero + ", remRegistroProfesionalSet=" + remRegistroProfesionalSet + ", remUsuarioPerfilSet=" + remUsuarioPerfilSet + ", remAnalisistaSet=" + remAnalisistaSet + ", remTutorMascotaSet=" + remTutorMascotaSet + ", remMicrochipMascotaUbaSet=" + remMicrochipMascotaUbaSet + ", remAtencionAnimalesSet=" + remAtencionAnimalesSet + ", remRetiroAnimalesSet=" + remRetiroAnimalesSet + '}';
    }


}
