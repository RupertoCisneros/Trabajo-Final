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
@Table(name = "REM_CONTROL_ACCESO", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemControlAcceso.findAll", query = "SELECT r FROM RemControlAcceso r"),
    @NamedQuery(name = "RemControlAcceso.findByControlAccesoId", query = "SELECT r FROM RemControlAcceso r WHERE r.controlAccesoId = :controlAccesoId"),
    @NamedQuery(name = "RemControlAcceso.findByTerminalConexion", query = "SELECT r FROM RemControlAcceso r WHERE r.terminalConexion = :terminalConexion"),
    @NamedQuery(name = "RemControlAcceso.findByNovedad1", query = "SELECT r FROM RemControlAcceso r WHERE r.novedad1 = :novedad1"),
    @NamedQuery(name = "RemControlAcceso.findByNovedad2", query = "SELECT r FROM RemControlAcceso r WHERE r.novedad2 = :novedad2"),
    @NamedQuery(name = "RemControlAcceso.findByFechaAcceso", query = "SELECT r FROM RemControlAcceso r WHERE r.fechaAcceso = :fechaAcceso"),
    @NamedQuery(name = "RemControlAcceso.findByRespuesta", query = "SELECT r FROM RemControlAcceso r WHERE r.respuesta = :respuesta")})
public class RemControlAcceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTROL_ACCESO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long controlAccesoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TERMINAL_CONEXION", nullable = false, length = 30)
    private String terminalConexion;
    @Size(max = 80)
    @Column(length = 80)
    private String novedad1;
    @Size(max = 80)
    @Column(length = 80)
    private String novedad2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACCESO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcceso;
    @Size(max = 80)
    @Column(length = 80)
    private String respuesta;

    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    @JsonBackReference("usuarioIdControl")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemUsuarios usuarioId;

    public RemControlAcceso() {
    }

    public RemControlAcceso(Long controlAccesoId) {
        this.controlAccesoId = controlAccesoId;
    }

    public RemControlAcceso(Long controlAccesoId, String terminalConexion, Date fechaAcceso) {
        this.controlAccesoId = controlAccesoId;
        this.terminalConexion = terminalConexion;
        this.fechaAcceso = fechaAcceso;
    }

    public Long getControlAccesoId() {
        return controlAccesoId;
    }

    public void setControlAccesoId(Long controlAccesoId) {
        this.controlAccesoId = controlAccesoId;
    }

    public String getTerminalConexion() {
        return terminalConexion;
    }

    public void setTerminalConexion(String terminalConexion) {
        this.terminalConexion = terminalConexion;
    }

    public String getNovedad1() {
        return novedad1;
    }

    public void setNovedad1(String novedad1) {
        this.novedad1 = novedad1;
    }

    public String getNovedad2() {
        return novedad2;
    }

    public void setNovedad2(String novedad2) {
        this.novedad2 = novedad2;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(Date fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public RemUsuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(RemUsuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (controlAccesoId != null ? controlAccesoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemControlAcceso)) {
            return false;
        }
        RemControlAcceso other = (RemControlAcceso) object;
        if ((this.controlAccesoId == null && other.controlAccesoId != null) || (this.controlAccesoId != null && !this.controlAccesoId.equals(other.controlAccesoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.mdmq.remetfu.Entidades.RemControlAcceso[ controlAccesoId=" + controlAccesoId + " ]";
    }

}
