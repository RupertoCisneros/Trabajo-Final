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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author omaldonado
 */
@Entity
@Table(name = "REM_MENU_PERFIL", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemMenuPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RemMenuPerfilPK remMenuPerfilPK;
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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("remMenu")
    @JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID", nullable = false, insertable = false, updatable = false)
    private RemMenu remMenu;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("remPerfil")
    @JoinColumn(name = "PERFIL_ID", referencedColumnName = "PERFIL_ID", nullable = false, insertable = false, updatable = false)
    private RemPerfil remPerfil;

    public RemMenuPerfil() {
    }

    public RemMenuPerfil(RemMenuPerfilPK remMenuPerfilPK) {
        this.remMenuPerfilPK = remMenuPerfilPK;
    }

    public RemMenuPerfil(RemMenuPerfilPK remMenuPerfilPK, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.remMenuPerfilPK = remMenuPerfilPK;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public RemMenuPerfil(long perfilId, int menuId) {
        this.remMenuPerfilPK = new RemMenuPerfilPK(perfilId, menuId);
    }

    public RemMenuPerfilPK getRemMenuPerfilPK() {
        return remMenuPerfilPK;
    }

    public void setRemMenuPerfilPK(RemMenuPerfilPK remMenuPerfilPK) {
        this.remMenuPerfilPK = remMenuPerfilPK;
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

    public RemMenu getRemMenu() {
        return remMenu;
    }

    public void setRemMenu(RemMenu remMenu) {
        this.remMenu = remMenu;
    }

    public RemPerfil getRemPerfil() {
        return remPerfil;
    }

    public void setRemPerfil(RemPerfil remPerfil) {
        this.remPerfil = remPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (remMenuPerfilPK != null ? remMenuPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemMenuPerfil)) {
            return false;
        }
        RemMenuPerfil other = (RemMenuPerfil) object;
        if ((this.remMenuPerfilPK == null && other.remMenuPerfilPK != null) || (this.remMenuPerfilPK != null && !this.remMenuPerfilPK.equals(other.remMenuPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemMenuPerfil{" + "remMenuPerfilPK=" + remMenuPerfilPK + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", remMenu=" + remMenu + ", remPerfil=" + remPerfil + '}';
    }

}
