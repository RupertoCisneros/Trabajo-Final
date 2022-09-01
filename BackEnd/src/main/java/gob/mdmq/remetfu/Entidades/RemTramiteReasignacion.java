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

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_TRAMITE_REASIGNACION", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@NamedQueries({
    @NamedQuery(name = "RemTramiteReasignacion.findAll", query = "SELECT r FROM RemTramiteReasignacion r"),
    @NamedQuery(name = "RemTramiteReasignacion.findByTramiteReasignacionId", query = "SELECT r FROM RemTramiteReasignacion r WHERE r.tramiteReasignacionId = :tramiteReasignacionId"),
    @NamedQuery(name = "RemTramiteReasignacion.findByMotivo", query = "SELECT r FROM RemTramiteReasignacion r WHERE r.motivo = :motivo"),
    @NamedQuery(name = "RemTramiteReasignacion.findByFechaReasignacion", query = "SELECT r FROM RemTramiteReasignacion r WHERE r.fechaReasignacion = :fechaReasignacion"),
    @NamedQuery(name = "RemTramiteReasignacion.findByUsuarioReasignacion", query = "SELECT r FROM RemTramiteReasignacion r WHERE r.usuarioReasignacion = :usuarioReasignacion"),
    @NamedQuery(name = "RemTramiteReasignacion.findByTerminalReasignacion", query = "SELECT r FROM RemTramiteReasignacion r WHERE r.terminalReasignacion = :terminalReasignacion")})
public class RemTramiteReasignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAMITE_REASIGNACION_ID", nullable = false)
    private Long tramiteReasignacionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(nullable = false, length = 500)
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REASIGNACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReasignacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_REASIGNACION", nullable = false, length = 30)
    private String usuarioReasignacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TERMINAL_REASIGNACION", nullable = false, length = 30)
    private String terminalReasignacion;
    @JoinColumn(name = "ANALISTA_ANTES", referencedColumnName = "ANALISTA_ID", nullable = false)
    @JsonBackReference("analistaAntes")
    @ManyToOne(optional = false)
    private RemAnalista analistaAntes;
    @JoinColumn(name = "ANALISTA_DESPUES", referencedColumnName = "ANALISTA_ID", nullable = false)
    @JsonBackReference("analistaDespues")
    @ManyToOne(optional = false)
    private RemAnalista analistaDespues;

    public RemTramiteReasignacion() {
    }

    public RemTramiteReasignacion(Long tramiteReasignacionId) {
        this.tramiteReasignacionId = tramiteReasignacionId;
    }

    public RemTramiteReasignacion(Long tramiteReasignacionId, String motivo, Date fechaReasignacion, String usuarioReasignacion, String terminalReasignacion, RemAnalista analistaAntes, RemAnalista analistaDespues) {
        this.tramiteReasignacionId = tramiteReasignacionId;
        this.motivo = motivo;
        this.fechaReasignacion = fechaReasignacion;
        this.usuarioReasignacion = usuarioReasignacion;
        this.terminalReasignacion = terminalReasignacion;
        this.analistaAntes = analistaAntes;
        this.analistaDespues = analistaDespues;
    }

    public Long getTramiteReasignacionId() {
        return tramiteReasignacionId;
    }

    public void setTramiteReasignacionId(Long tramiteReasignacionId) {
        this.tramiteReasignacionId = tramiteReasignacionId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaReasignacion() {
        return fechaReasignacion;
    }

    public void setFechaReasignacion(Date fechaReasignacion) {
        this.fechaReasignacion = fechaReasignacion;
    }

    public String getUsuarioReasignacion() {
        return usuarioReasignacion;
    }

    public void setUsuarioReasignacion(String usuarioReasignacion) {
        this.usuarioReasignacion = usuarioReasignacion;
    }

    public String getTerminalReasignacion() {
        return terminalReasignacion;
    }

    public void setTerminalReasignacion(String terminalReasignacion) {
        this.terminalReasignacion = terminalReasignacion;
    }

    public RemAnalista getAnalistaAntes() {
        return analistaAntes;
    }

    public void setAnalistaAntes(RemAnalista analistaAntes) {
        this.analistaAntes = analistaAntes;
    }

    public RemAnalista getAnalistaDespues() {
        return analistaDespues;
    }

    public void setAnalistaDespues(RemAnalista analistaDespues) {
        this.analistaDespues = analistaDespues;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tramiteReasignacionId != null ? tramiteReasignacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemTramiteReasignacion)) {
            return false;
        }
        RemTramiteReasignacion other = (RemTramiteReasignacion) object;
        if ((this.tramiteReasignacionId == null && other.tramiteReasignacionId != null) || (this.tramiteReasignacionId != null && !this.tramiteReasignacionId.equals(other.tramiteReasignacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemTramiteReasignacion{" + "tramiteReasignacionId=" + tramiteReasignacionId + ", motivo=" + motivo + ", fechaReasignacion=" + fechaReasignacion + ", usuarioReasignacion=" + usuarioReasignacion + ", terminalReasignacion=" + terminalReasignacion + ", analistaAntes=" + analistaAntes + ", analistaDespues=" + analistaDespues + '}';
    }

}
