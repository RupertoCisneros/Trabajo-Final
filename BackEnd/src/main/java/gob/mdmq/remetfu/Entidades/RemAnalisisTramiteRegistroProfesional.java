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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(name = "REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL_UNQ01",columnNames = {"REGISTRO_PROFESIONAL_ID"})})
@NamedQueries({
    @NamedQuery(name = "RemAnalisisTramiteRegistroProfesional.findAll", query = "SELECT r FROM RemAnalisisTramiteRegistroProfesional r"),
    @NamedQuery(name = "RemAnalisisTramiteRegistroProfesional.findByregistroProfesionalId", query = "SELECT r FROM RemAnalisisTramiteRegistroProfesional r WHERE r.registroProfesionalId = :registroProfesionalId")})

public class RemAnalisisTramiteRegistroProfesional implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ASIGNA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsigna;
    @Size(max = 500)
    @Column(name = "NOVEDAD_APROBACION", length = 500)
    private String novedadAprobacion;
    @Size(max = 500)
    @Column(name = "MOTIVO_DEVOLUCION", length = 500)
    private String motivoDevolucion;
    @Size(max = 500)
    @Column(name = "MOTIVO_RECHAZO", length = 500)
    private String motivoRechazo;
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

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALSIS_TRAMITE_REGISTRO_PROFESIONAL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long analsisTramiteRegistroProfesionalId;
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;
    @Column(name = "FECHA_APROBACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;
    @Column(name = "FECHA_DEVOLUCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucion;
    @Column(name = "FECHA_RECHAZO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRechazo;

    @JoinColumn(name = "REGISTRO_PROFESIONAL_ID", referencedColumnName = "REGISTRO_PROFESIONAL_ID", nullable = false)
    @JsonBackReference("analisis")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private RemRegistroProfesional registroProfesionalId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("estado")
    @JoinColumn(name = "ESTADO", referencedColumnName = "CATALOGO_ID", nullable = false)
    private RemCatalogo estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("analistaId")
    @JoinColumn(name = "ANALISTA_ID", referencedColumnName = "ANALISTA_ID", nullable = false)
    private RemAnalista analistaId;

    public RemAnalisisTramiteRegistroProfesional() {
    }

    public RemAnalisisTramiteRegistroProfesional(Long analsisTramiteRegistroProfesionalId) {
        this.analsisTramiteRegistroProfesionalId = analsisTramiteRegistroProfesionalId;
    }

    public RemAnalisisTramiteRegistroProfesional(Long analsisTramiteRegistroProfesionalId, Date fechaVigencia, Date fechaAprobacion, Date fechaDevolucion, Date fechaRechazo, Date fechaAsigna, String novedadAprobacion, String motivoDevolucion, String motivoRechazo, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemRegistroProfesional registroProfesionalId, RemCatalogo estado, RemAnalista analistaId) {
        this.analsisTramiteRegistroProfesionalId = analsisTramiteRegistroProfesionalId;
        this.fechaVigencia = fechaVigencia;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaRechazo = fechaRechazo;
        this.fechaAsigna = fechaAsigna;
        this.novedadAprobacion = novedadAprobacion;
        this.motivoDevolucion = motivoDevolucion;
        this.motivoRechazo = motivoRechazo;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.registroProfesionalId = registroProfesionalId;
        this.estado = estado;
        this.analistaId = analistaId;
    }


    public Long getAnalsisTramiteRegistroProfesionalId() {
        return analsisTramiteRegistroProfesionalId;
    }

    public void setAnalsisTramiteRegistroProfesionalId(Long analsisTramiteRegistroProfesionalId) {
        this.analsisTramiteRegistroProfesionalId = analsisTramiteRegistroProfesionalId;
    }

    public Date getFechaAsigna() {
        return fechaAsigna;
    }

    public void setFechaAsigna(Date fechaAsigna) {
        this.fechaAsigna = fechaAsigna;
    }

    public RemCatalogo getEstado() {
        return estado;
    }

    public void setEstado(RemCatalogo estado) {
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

    public RemRegistroProfesional getRegistroProfesionalId() {
        return registroProfesionalId;
    }

    public void setRegistroProfesionalId(RemRegistroProfesional registroProfesionalId) {
        this.registroProfesionalId = registroProfesionalId;
    }

    public RemAnalista getAnalistaId() {
        return analistaId;
    }

    public void setAnalistaId(RemAnalista analistaId) {
        this.analistaId = analistaId;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
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

    public Date getFechaRechazo() {
        return fechaRechazo;
    }

    public void setFechaRechazo(Date fechaRechazo) {
        this.fechaRechazo = fechaRechazo;
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

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (analsisTramiteRegistroProfesionalId != null ? analsisTramiteRegistroProfesionalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemAnalisisTramiteRegistroProfesional)) {
            return false;
        }
        RemAnalisisTramiteRegistroProfesional other = (RemAnalisisTramiteRegistroProfesional) object;
        if ((this.analsisTramiteRegistroProfesionalId == null && other.analsisTramiteRegistroProfesionalId != null) || (this.analsisTramiteRegistroProfesionalId != null && !this.analsisTramiteRegistroProfesionalId.equals(other.analsisTramiteRegistroProfesionalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemAnalisisTramiteRegistroProfesional{" + "analsisTramiteRegistroProfesionalId=" + analsisTramiteRegistroProfesionalId + ", fechaVigencia=" + fechaVigencia + ", fechaAprobacion=" + fechaAprobacion + ", fechaDevolucion=" + fechaDevolucion + ", fechaRechazo=" + fechaRechazo + ", fechaAsigna=" + fechaAsigna + ", novedadAprobacion=" + novedadAprobacion + ", motivoDevolucion=" + motivoDevolucion + ", motivoRechazo=" + motivoRechazo + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", registroProfesionalId=" + registroProfesionalId + ", estado=" + estado + ", analistaId=" + analistaId + '}';
    }

}
