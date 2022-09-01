/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_ANALISTA", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(name = "REM_ANALISTA_UNQ01",columnNames = {"PERFIL_ID", "USUARIO_ID"})})
public class RemAnalista implements Serializable {

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
    @Column(name = "ANALISTA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long analistaId;
    @Column(name = "FECHA_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;
    @Column(name = "FECHA_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;
    @Size(max = 500)
    @Column(length = 500)
    private String observacion;
    @Column(name = "AUTORIZACION_SALIDA")
    private Integer autorizacionSalida;
    @Size(max = 3)
    @Column(length = 3)
    private String estado;
    @Column(name = "NRO_TRAMITES")
    private BigInteger nroTramites;
    @Column(name = "NRO_TRAMITES_MES")
    private BigInteger nroTramitesMes;
    @Column(name = "MES_TRAMITES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mesTramites;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analistaAntes")
    private Set<RemTramiteReasignacion> remTramiteReasignacionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analistaDespues")
    private Set<RemTramiteReasignacion> remTramiteReasignacionSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analistaId", fetch = FetchType.LAZY)
    private Set<RemAnalisisTramiteRegistroProfesional> remAnalisisTramiteRegistroProfesionalSet;

    @JoinColumn(name = "CATALOGO_ID", referencedColumnName = "CATALOGO_ID")
    @JsonBackReference("catalogoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemCatalogo catalogoId;

    @JoinColumn(name = "PERFIL_ID", referencedColumnName = "PERFIL_ID", nullable = false)
    @JsonBackReference("perfilId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemPerfil perfilId;

    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    @JsonBackReference("usuarioId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemUsuarios usuarioId;


    public RemAnalista() {
    }

    public RemAnalista(Long analistaId) {
        this.analistaId = analistaId;
    }

    public RemAnalista(Long analistaId, Date fechaDesde, Date fechaHasta, String observacion, Integer autorizacionSalida, String estado, BigInteger nroTramites, BigInteger nroTramitesMes, Date mesTramites, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemCatalogo catalogoId, RemPerfil perfilId, RemUsuarios usuarioId) {
        this.analistaId = analistaId;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.observacion = observacion;
        this.autorizacionSalida = autorizacionSalida;
        this.estado = estado;
        this.nroTramites = nroTramites;
        this.nroTramitesMes = nroTramitesMes;
        this.mesTramites = mesTramites;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.catalogoId = catalogoId;
        this.perfilId = perfilId;
        this.usuarioId = usuarioId;
    }

    public Long getAnalistaId() {
        return analistaId;
    }

    public void setAnalistaId(Long analistaId) {
        this.analistaId = analistaId;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getAutorizacionSalida() {
        return autorizacionSalida;
    }

    public void setAutorizacionSalida(Integer autorizacionSalida) {
        this.autorizacionSalida = autorizacionSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getNroTramites() {
        return nroTramites;
    }

    public void setNroTramites(BigInteger nroTramites) {
        this.nroTramites = nroTramites;
    }

    public BigInteger getNroTramitesMes() {
        return nroTramitesMes;
    }

    public void setNroTramitesMes(BigInteger nroTramitesMes) {
        this.nroTramitesMes = nroTramitesMes;
    }

    public Date getMesTramites() {
        return mesTramites;
    }

    public void setMesTramites(Date mesTramites) {
        this.mesTramites = mesTramites;
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

    public RemCatalogo getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(RemCatalogo catalogoId) {
        this.catalogoId = catalogoId;
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

    public Set<RemAnalisisTramiteRegistroProfesional> getRemAnalisisTramiteRegistroProfesionalSet() {
        return remAnalisisTramiteRegistroProfesionalSet;
    }

    public void setRemAnalisisTramiteRegistroProfesionalSet(Set<RemAnalisisTramiteRegistroProfesional> remAnalisisTramiteRegistroProfesionalSet) {
        this.remAnalisisTramiteRegistroProfesionalSet = remAnalisisTramiteRegistroProfesionalSet;
    }

    public Set<RemTramiteReasignacion> getRemTramiteReasignacionSet() {
        return remTramiteReasignacionSet;
    }

    public void setRemTramiteReasignacionSet(Set<RemTramiteReasignacion> remTramiteReasignacionSet) {
        this.remTramiteReasignacionSet = remTramiteReasignacionSet;
    }

    public Set<RemTramiteReasignacion> getRemTramiteReasignacionSet1() {
        return remTramiteReasignacionSet1;
    }

    public void setRemTramiteReasignacionSet1(Set<RemTramiteReasignacion> remTramiteReasignacionSet1) {
        this.remTramiteReasignacionSet1 = remTramiteReasignacionSet1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (analistaId != null ? analistaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemAnalista)) {
            return false;
        }
        RemAnalista other = (RemAnalista) object;
        if ((this.analistaId == null && other.analistaId != null) || (this.analistaId != null && !this.analistaId.equals(other.analistaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemAnalista{" + "analistaId=" + analistaId + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", observacion=" + observacion + ", autorizacionSalida=" + autorizacionSalida + ", estado=" + estado + ", nroTramites=" + nroTramites + ", nroTramitesMes=" + nroTramitesMes + ", mesTramites=" + mesTramites + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", remTramiteReasignacionSet=" + remTramiteReasignacionSet + ", remTramiteReasignacionSet1=" + remTramiteReasignacionSet1 + ", catalogoId=" + catalogoId + ", perfilId=" + perfilId + ", usuarioId=" + usuarioId + ", remAnalisisTramiteRegistroProfesionalSet=" + remAnalisisTramiteRegistroProfesionalSet + '}';
    }

}
