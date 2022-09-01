/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "REM_FERIADOS", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemFeriados.findAll", query = "SELECT r FROM RemFeriados r"),
    @NamedQuery(name = "RemFeriados.findByFeriadosId", query = "SELECT r FROM RemFeriados r WHERE r.feriadosId = :feriadosId"),
    @NamedQuery(name = "RemFeriados.findByDescripcion", query = "SELECT r FROM RemFeriados r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RemFeriados.findByFechaFeriado", query = "SELECT r FROM RemFeriados r WHERE r.fechaFeriado = :fechaFeriado"),
    @NamedQuery(name = "RemFeriados.findByEstado", query = "SELECT r FROM RemFeriados r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemFeriados.findByUsuarioCreacion", query = "SELECT r FROM RemFeriados r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemFeriados.findByTerminalCreacion", query = "SELECT r FROM RemFeriados r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemFeriados.findByFechaCreacion", query = "SELECT r FROM RemFeriados r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemFeriados.findByUsuarioModificacion", query = "SELECT r FROM RemFeriados r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemFeriados.findByTerminalModificacion", query = "SELECT r FROM RemFeriados r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemFeriados.findByFechaModificacion", query = "SELECT r FROM RemFeriados r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemFeriados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FERIADOS_ID", nullable = false)
    private Long feriadosId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FERIADO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFeriado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
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

    public RemFeriados() {
    }

    public RemFeriados(Long feriadosId) {
        this.feriadosId = feriadosId;
    }

    public RemFeriados(Long feriadosId, String descripcion, Date fechaFeriado, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.feriadosId = feriadosId;
        this.descripcion = descripcion;
        this.fechaFeriado = fechaFeriado;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getFeriadosId() {
        return feriadosId;
    }

    public void setFeriadosId(Long feriadosId) {
        this.feriadosId = feriadosId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFeriado() {
        return fechaFeriado;
    }

    public void setFechaFeriado(Date fechaFeriado) {
        this.fechaFeriado = fechaFeriado;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feriadosId != null ? feriadosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemFeriados)) {
            return false;
        }
        RemFeriados other = (RemFeriados) object;
        if ((this.feriadosId == null && other.feriadosId != null) || (this.feriadosId != null && !this.feriadosId.equals(other.feriadosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.mdmq.remetfu.Entidades.RemFeriados[ feriadosId=" + feriadosId + " ]";
    }
    
}
