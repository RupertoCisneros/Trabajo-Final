/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_RETIRO_ANIMALES", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemRetiroAnimales.findAll", query = "SELECT r FROM RemRetiroAnimales r"),
    @NamedQuery(name = "RemRetiroAnimales.findByRetiroAnimalesId", query = "SELECT r FROM RemRetiroAnimales r WHERE r.retiroAnimalesId = :retiroAnimalesId"),
    @NamedQuery(name = "RemRetiroAnimales.findByBarrio", query = "SELECT r FROM RemRetiroAnimales r WHERE r.barrio = :barrio"),
    @NamedQuery(name = "RemRetiroAnimales.findByCallePrincipal", query = "SELECT r FROM RemRetiroAnimales r WHERE r.callePrincipal = :callePrincipal"),
    @NamedQuery(name = "RemRetiroAnimales.findByCalleNumero", query = "SELECT r FROM RemRetiroAnimales r WHERE r.calleNumero = :calleNumero"),
    @NamedQuery(name = "RemRetiroAnimales.findByCalleSecundaria", query = "SELECT r FROM RemRetiroAnimales r WHERE r.calleSecundaria = :calleSecundaria"),
    @NamedQuery(name = "RemRetiroAnimales.findByCalleReferencia1", query = "SELECT r FROM RemRetiroAnimales r WHERE r.calleReferencia1 = :calleReferencia1"),
    @NamedQuery(name = "RemRetiroAnimales.findByCalleReferencia2", query = "SELECT r FROM RemRetiroAnimales r WHERE r.calleReferencia2 = :calleReferencia2"),
    @NamedQuery(name = "RemRetiroAnimales.findByObservacionRetiro", query = "SELECT r FROM RemRetiroAnimales r WHERE r.observacionRetiro = :observacionRetiro"),
    @NamedQuery(name = "RemRetiroAnimales.findByTutorCondicionCalle", query = "SELECT r FROM RemRetiroAnimales r WHERE r.tutorCondicionCalle = :tutorCondicionCalle"),
    @NamedQuery(name = "RemRetiroAnimales.findByObservacionTutor", query = "SELECT r FROM RemRetiroAnimales r WHERE r.observacionTutor = :observacionTutor"),
    @NamedQuery(name = "RemRetiroAnimales.findByObservacionIntervencion", query = "SELECT r FROM RemRetiroAnimales r WHERE r.observacionIntervencion = :observacionIntervencion"),
    @NamedQuery(name = "RemRetiroAnimales.findByAcuerdoResponsabilidad", query = "SELECT r FROM RemRetiroAnimales r WHERE r.acuerdoResponsabilidad = :acuerdoResponsabilidad"),
    @NamedQuery(name = "RemRetiroAnimales.findByFechaRegistro", query = "SELECT r FROM RemRetiroAnimales r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "RemRetiroAnimales.findByEstado", query = "SELECT r FROM RemRetiroAnimales r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemRetiroAnimales.findByUsuarioCreacion", query = "SELECT r FROM RemRetiroAnimales r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemRetiroAnimales.findByTerminalCreacion", query = "SELECT r FROM RemRetiroAnimales r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemRetiroAnimales.findByFechaCreacion", query = "SELECT r FROM RemRetiroAnimales r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemRetiroAnimales.findByUsuarioModificacion", query = "SELECT r FROM RemRetiroAnimales r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemRetiroAnimales.findByTerminalModificacion", query = "SELECT r FROM RemRetiroAnimales r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemRetiroAnimales.findByFechaModificacion", query = "SELECT r FROM RemRetiroAnimales r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemRetiroAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RETIRO_ANIMALES_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long retiroAnimalesId;
    @Size(max = 150)
    @Column(length = 150)
    private String barrio;
    @Size(max = 150)
    @Column(name = "CALLE_PRINCIPAL", length = 150)
    private String callePrincipal;
    @Size(max = 15)
    @Column(name = "CALLE_NUMERO", length = 15)
    private String calleNumero;
    @Size(max = 150)
    @Column(name = "CALLE_SECUNDARIA", length = 150)
    private String calleSecundaria;
    @Size(max = 150)
    @Column(name = "CALLE_REFERENCIA1", length = 150)
    private String calleReferencia1;
    @Size(max = 150)
    @Column(name = "CALLE_REFERENCIA2", length = 150)
    private String calleReferencia2;
    @Size(max = 800)
    @Column(name = "OBSERVACION_RETIRO", length = 800)
    private String observacionRetiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TUTOR_CONDICION_CALLE", nullable = false, length = 3)
    private String tutorCondicionCalle;
    @Size(max = 800)
    @Column(name = "OBSERVACION_TUTOR", length = 800)
    private String observacionTutor;
    @Size(max = 800)
    @Column(name = "OBSERVACION_INTERVENCION", length = 800)
    private String observacionIntervencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ACUERDO_RESPONSABILIDAD", nullable = false, length = 3)
    private String acuerdoResponsabilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_CREACION", nullable = false, length = 30)
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TERMINAL_CREACION", nullable = false, length = 30)
    private String terminalCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_MODIFICACION", nullable = false, length = 30)
    private String usuarioModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TERMINAL_MODIFICACION", nullable = false, length = 30)
    private String terminalModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @JoinColumn(name = "MOTIVO_RETIRO_ARCHIVO", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("motivoRetiroArchivo")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos motivoRetiroArchivo;

    @JoinColumn(name = "ESTADO_TUTORIA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("estadoTutoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo estadoTutoria;

    @JoinColumn(name = "SITUACION_INTERVENCION", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("situacionIntervencion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo situacionIntervencion;

    @JoinColumn(name = "ADM_ZONAL", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("admZonal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo admZonal;

    @JoinColumn(name = "PARROQUIA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("parroquia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo parroquia;

    @JoinColumn(name = "MOTIVO_RETIRO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("motivoRetiro")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo motivoRetiro;

  
    @JoinColumn(name = "FUNCIONARIO_UBA", referencedColumnName = "USUARIO_ID", nullable = false)
    @JsonBackReference("funcionarioUba")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemUsuarios funcionarioUba;

    public RemRetiroAnimales() {
    }

    public RemRetiroAnimales(Long retiroAnimalesId) {
        this.retiroAnimalesId = retiroAnimalesId;
    }

    public RemRetiroAnimales(Long retiroAnimalesId, String tutorCondicionCalle, String acuerdoResponsabilidad, Date fechaRegistro, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.retiroAnimalesId = retiroAnimalesId;
        this.tutorCondicionCalle = tutorCondicionCalle;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getRetiroAnimalesId() {
        return retiroAnimalesId;
    }

    public void setRetiroAnimalesId(Long retiroAnimalesId) {
        this.retiroAnimalesId = retiroAnimalesId;
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

    public String getObservacionRetiro() {
        return observacionRetiro;
    }

    public void setObservacionRetiro(String observacionRetiro) {
        this.observacionRetiro = observacionRetiro;
    }

    public String getTutorCondicionCalle() {
        return tutorCondicionCalle;
    }

    public void setTutorCondicionCalle(String tutorCondicionCalle) {
        this.tutorCondicionCalle = tutorCondicionCalle;
    }

    public String getObservacionTutor() {
        return observacionTutor;
    }

    public void setObservacionTutor(String observacionTutor) {
        this.observacionTutor = observacionTutor;
    }

    public String getObservacionIntervencion() {
        return observacionIntervencion;
    }

    public void setObservacionIntervencion(String observacionIntervencion) {
        this.observacionIntervencion = observacionIntervencion;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public RemArchivos getMotivoRetiroArchivo() {
        return motivoRetiroArchivo;
    }

    public void setMotivoRetiroArchivo(RemArchivos motivoRetiroArchivo) {
        this.motivoRetiroArchivo = motivoRetiroArchivo;
    }

    public RemCatalogo getEstadoTutoria() {
        return estadoTutoria;
    }

    public void setEstadoTutoria(RemCatalogo estadoTutoria) {
        this.estadoTutoria = estadoTutoria;
    }

    public RemCatalogo getSituacionIntervencion() {
        return situacionIntervencion;
    }

    public void setSituacionIntervencion(RemCatalogo situacionIntervencion) {
        this.situacionIntervencion = situacionIntervencion;
    }

    public RemCatalogo getAdmZonal() {
        return admZonal;
    }

    public void setAdmZonal(RemCatalogo admZonal) {
        this.admZonal = admZonal;
    }

    public RemCatalogo getParroquia() {
        return parroquia;
    }

    public void setParroquia(RemCatalogo parroquia) {
        this.parroquia = parroquia;
    }

    public RemCatalogo getMotivoRetiro() {
        return motivoRetiro;
    }

    public void setMotivoRetiro(RemCatalogo motivoRetiro) {
        this.motivoRetiro = motivoRetiro;
    }


    public RemUsuarios getFuncionarioUba() {
        return funcionarioUba;
    }

    public void setFuncionarioUba(RemUsuarios funcionarioUba) {
        this.funcionarioUba = funcionarioUba;
    }

    @Override
    public String toString() {
        return "RemRetiroAnimales{" + "retiroAnimalesId=" + retiroAnimalesId + ", barrio=" + barrio + ", callePrincipal=" + callePrincipal + ", calleNumero=" + calleNumero + ", calleSecundaria=" + calleSecundaria + ", calleReferencia1=" + calleReferencia1 + ", calleReferencia2=" + calleReferencia2 + ", observacionRetiro=" + observacionRetiro + ", tutorCondicionCalle=" + tutorCondicionCalle + ", observacionTutor=" + observacionTutor + ", observacionIntervencion=" + observacionIntervencion + ", acuerdoResponsabilidad=" + acuerdoResponsabilidad + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", motivoRetiroArchivo=" + motivoRetiroArchivo + ", estadoTutoria=" + estadoTutoria + ", situacionIntervencion=" + situacionIntervencion + ", admZonal=" + admZonal + ", parroquia=" + parroquia + ", motivoRetiro=" + motivoRetiro + ", funcionarioUba=" + funcionarioUba + '}';
    }

    
   

}
