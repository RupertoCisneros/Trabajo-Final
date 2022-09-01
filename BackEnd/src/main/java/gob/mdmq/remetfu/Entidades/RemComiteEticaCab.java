/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "REM_COMITE_ETICA_CAB", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemComiteEticaCab.findAll", query = "SELECT r FROM RemComiteEticaCab r"),
    @NamedQuery(name = "RemComiteEticaCab.findByComiteEticaCabId", query = "SELECT r FROM RemComiteEticaCab r WHERE r.comiteEticaCabId = :comiteEticaCabId"),
    @NamedQuery(name = "RemComiteEticaCab.findByNombreInstitucion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.nombreInstitucion = :nombreInstitucion"),
    @NamedQuery(name = "RemComiteEticaCab.findByFacultadInvestigacion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.facultadInvestigacion = :facultadInvestigacion"),
    @NamedQuery(name = "RemComiteEticaCab.findByFechaRegistro", query = "SELECT r FROM RemComiteEticaCab r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "RemComiteEticaCab.findByEstado", query = "SELECT r FROM RemComiteEticaCab r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemComiteEticaCab.findByUsuarioCreacion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemComiteEticaCab.findByTerminalCreacion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemComiteEticaCab.findByFechaCreacion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemComiteEticaCab.findByUsuarioModificacion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemComiteEticaCab.findByTerminalModificacion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemComiteEticaCab.findByFechaModificacion", query = "SELECT r FROM RemComiteEticaCab r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemComiteEticaCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMITE_ETICA_CAB_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comiteEticaCabId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "NOMBRE_INSTITUCION", nullable = false, length = 300)
    private String nombreInstitucion;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 300)
    @Column(name = "FACULTAD_INVESTIGACION", nullable = false, length = 300)
    private String facultadInvestigacion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comiteEticaCabId", fetch = FetchType.LAZY)
    private Set<RemComiteEticaDet> remComiteEticaDetSet;

    public RemComiteEticaCab() {
    }

    public RemComiteEticaCab(Long comiteEticaCabId) {
        this.comiteEticaCabId = comiteEticaCabId;
    }

    public RemComiteEticaCab(Long comiteEticaCabId, String nombreInstitucion, String facultadInvestigacion, Date fechaRegistro, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.comiteEticaCabId = comiteEticaCabId;
        this.nombreInstitucion = nombreInstitucion;
        this.facultadInvestigacion = facultadInvestigacion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getComiteEticaCabId() {
        return comiteEticaCabId;
    }

    public void setComiteEticaCabId(Long comiteEticaCabId) {
        this.comiteEticaCabId = comiteEticaCabId;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getFacultadInvestigacion() {
        return facultadInvestigacion;
    }

    public void setFacultadInvestigacion(String facultadInvestigacion) {
        this.facultadInvestigacion = facultadInvestigacion;
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

    public Set<RemComiteEticaDet> getRemComiteEticaDetSet() {
        return remComiteEticaDetSet;
    }

    public void setRemComiteEticaDetSet(Set<RemComiteEticaDet> remComiteEticaDetSet) {
        this.remComiteEticaDetSet = remComiteEticaDetSet;
    }

    @Override
    public String toString() {
        return "RemComiteEticaCab{" + "comiteEticaCabId=" + comiteEticaCabId + ", nombreInstitucion=" + nombreInstitucion + ", facultadInvestigacion=" + facultadInvestigacion + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", remComiteEticaDetSet=" + remComiteEticaDetSet + '}';
    }


    

}
