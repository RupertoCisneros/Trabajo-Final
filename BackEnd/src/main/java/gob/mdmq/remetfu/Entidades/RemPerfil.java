/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_PERFIL", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PERFIL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perfilId;
    @Column(length = 50)
    private String nombre;
    @Column(length = 200)
    private String descripcion;
    @Column(length = 3)
    private String estado;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("tipoUsuario")
    @JoinColumn(name = "TIPO_USUARIO", referencedColumnName = "CATALOGO_ID")
    private RemCatalogo tipoUsuario;

    @OneToMany(mappedBy = "perfilId", fetch = FetchType.LAZY)
    private Set<RemUsuarioPerfil> remUsuarioPerfilSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remPerfil", fetch = FetchType.LAZY)
    private Set<RemMenuPerfil> remMenuPerfilSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilId", fetch = FetchType.LAZY)
    private Set<RemAnalista> remAnalistaSet;

    public RemPerfil() {
    }

    public RemPerfil(Long perfilId, String nombre, String descripcion, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemCatalogo tipoUsuario) {
        this.perfilId = perfilId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public RemCatalogo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(RemCatalogo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Set<RemMenuPerfil> getRemMenuPerfilSet() {
        return remMenuPerfilSet;
    }

    public void setRemMenuPerfilSet(Set<RemMenuPerfil> remMenuPerfilSet) {
        this.remMenuPerfilSet = remMenuPerfilSet;
    }

    public Set<RemAnalista> getRemAnalistaSet() {
        return remAnalistaSet;
    }

    public void setRemAnalistaSet(Set<RemAnalista> remAnalistaSet) {
        this.remAnalistaSet = remAnalistaSet;
    }

    public Set<RemUsuarioPerfil> getRemUsuarioPerfilSet() {
        return remUsuarioPerfilSet;
    }

    public void setRemUsuarioPerfilSet(Set<RemUsuarioPerfil> remUsuarioPerfilSet) {
        this.remUsuarioPerfilSet = remUsuarioPerfilSet;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilId != null ? perfilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemPerfil)) {
            return false;
        }
        RemPerfil other = (RemPerfil) object;
        if ((this.perfilId == null && other.perfilId != null) || (this.perfilId != null && !this.perfilId.equals(other.perfilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemPerfil{" + "perfilId=" + perfilId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", tipoUsuario=" + tipoUsuario + ", remUsuarioPerfilSet=" + remUsuarioPerfilSet + ", remMenuPerfilSet=" + remMenuPerfilSet + ", remAnalistaSet=" + remAnalistaSet + '}';
    }

}
