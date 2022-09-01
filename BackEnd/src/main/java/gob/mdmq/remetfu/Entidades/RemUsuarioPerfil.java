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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_USUARIO_PERFIL", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(name = "REM_USUARIO_PERFIL_UNQ01", columnNames = {"USUARIO_ID", "PERFIL_ID"})})

@NamedQueries({
    @NamedQuery(name = "RemUsuarioPerfil.findAll", query = "SELECT r FROM RemUsuarioPerfil r"),
    @NamedQuery(name = "RemUsuarioPerfil.findByUsuarioPerfilId", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.usuarioPerfilId = :usuarioPerfilId"),
    @NamedQuery(name = "RemUsuarioPerfil.findByDescripcion", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RemUsuarioPerfil.findByEstado", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemUsuarioPerfil.findByUsuarioCreacion", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemUsuarioPerfil.findByTerminalCreacion", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemUsuarioPerfil.findByFechaCreacion", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemUsuarioPerfil.findByUsuarioModificacion", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemUsuarioPerfil.findByTerminalModificacion", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemUsuarioPerfil.findByFechaModificacion", query = "SELECT r FROM RemUsuarioPerfil r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemUsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_PERFIL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioPerfilId;
    @Size(max = 60)
    @Column(length = 60)
    private String descripcion;
    @Size(max = 3)
    @Column(length = 3)
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

    @JoinColumn(name = "TIPO_USUARIO", referencedColumnName = "CATALOGO_ID")
    @JsonBackReference("tipoUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemCatalogo tipoUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("perfilId")
    @JoinColumn(name = "PERFIL_ID", referencedColumnName = "PERFIL_ID")
    private RemPerfil perfilId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("usuarioId")
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")
    private RemUsuarios usuarioId;

    public RemUsuarioPerfil() {
    }

    public RemUsuarioPerfil(Long usuarioPerfilId) {
        this.usuarioPerfilId = usuarioPerfilId;
    }

    public RemUsuarioPerfil(Long usuarioPerfilId, String descripcion, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemCatalogo tipoUsuario, RemPerfil perfilId, RemUsuarios usuarioId) {
        this.usuarioPerfilId = usuarioPerfilId;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.tipoUsuario = tipoUsuario;
        this.perfilId = perfilId;
        this.usuarioId = usuarioId;
    }

    public Long getUsuarioPerfilId() {
        return usuarioPerfilId;
    }

    public void setUsuarioPerfilId(Long usuarioPerfilId) {
        this.usuarioPerfilId = usuarioPerfilId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public RemPerfil getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(RemPerfil perfilId) {
        this.perfilId = perfilId;
    }

    public RemUsuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(RemUsuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    public RemCatalogo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(RemCatalogo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPerfilId != null ? usuarioPerfilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemUsuarioPerfil)) {
            return false;
        }
        RemUsuarioPerfil other = (RemUsuarioPerfil) object;
        if ((this.usuarioPerfilId == null && other.usuarioPerfilId != null) || (this.usuarioPerfilId != null && !this.usuarioPerfilId.equals(other.usuarioPerfilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemUsuarioPerfil{" + "usuarioPerfilId=" + usuarioPerfilId + ", descripcion=" + descripcion + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", tipoUsuario=" + tipoUsuario + ", perfilId=" + perfilId + ", usuarioId=" + usuarioId + '}';
    }

}
