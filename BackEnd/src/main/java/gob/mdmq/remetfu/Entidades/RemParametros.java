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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_PARAMETROS", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@NamedQueries({
    @NamedQuery(name = "RemParametros.findAll", query = "SELECT r FROM RemParametros r"),
    @NamedQuery(name = "RemParametros.findByParametrosId", query = "SELECT r FROM RemParametros r WHERE r.parametrosId = :parametrosId"),
    @NamedQuery(name = "RemParametros.findByDescripcion", query = "SELECT r FROM RemParametros r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RemParametros.findByValor", query = "SELECT r FROM RemParametros r WHERE r.valor = :valor"),
    @NamedQuery(name = "RemParametros.findByUsuarioCreacion", query = "SELECT r FROM RemParametros r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemParametros.findByTerminalCreacion", query = "SELECT r FROM RemParametros r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemParametros.findByFechaCreacion", query = "SELECT r FROM RemParametros r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemParametros.findByUsuarioModificacion", query = "SELECT r FROM RemParametros r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemParametros.findByTerminalModificacion", query = "SELECT r FROM RemParametros r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemParametros.findByFechaModificacion", query = "SELECT r FROM RemParametros r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemParametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARAMETROS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parametrosId;
    @Size(max = 100)
    @Column(length = 100)
    private String descripcion;
    @Size(max = 30)
    @Column(length = 30)
    private String valor;
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

    public RemParametros() {
    }

    public RemParametros(Long parametrosId, String descripcion, String valor, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.parametrosId = parametrosId;
        this.descripcion = descripcion;
        this.valor = valor;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getParametrosId() {
        return parametrosId;
    }

    public void setParametrosId(Long parametrosId) {
        this.parametrosId = parametrosId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
        hash += (parametrosId != null ? parametrosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemParametros)) {
            return false;
        }
        RemParametros other = (RemParametros) object;
        if ((this.parametrosId == null && other.parametrosId != null) || (this.parametrosId != null && !this.parametrosId.equals(other.parametrosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemParametros{" + "parametrosId=" + parametrosId + ", descripcion=" + descripcion + ", valor=" + valor + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + '}';
    }


}
