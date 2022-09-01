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
import javax.persistence.OneToMany;
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
@Table(name = "REM_MICROCHIP_MASCOTA", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@NamedQueries({
    @NamedQuery(name = "RemMicrochipMascota.findAll", query = "SELECT r FROM RemMicrochipMascota r"),
    @NamedQuery(name = "RemMicrochipMascota.findByMicrochipMascotaId", query = "SELECT r FROM RemMicrochipMascota r WHERE r.microchipMascotaId = :microchipMascotaId"),
    @NamedQuery(name = "RemMicrochipMascota.findByCodigoMicrochip", query = "SELECT r FROM RemMicrochipMascota r WHERE r.codigoMicrochip = :codigoMicrochip"),
    @NamedQuery(name = "RemMicrochipMascota.findByFechaIngreso", query = "SELECT r FROM RemMicrochipMascota r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "RemMicrochipMascota.findByInformacionConsiderada", query = "SELECT r FROM RemMicrochipMascota r WHERE r.informacionConsiderada = :informacionConsiderada"),
    @NamedQuery(name = "RemMicrochipMascota.findByObservacion", query = "SELECT r FROM RemMicrochipMascota r WHERE r.observacion = :observacion"),
    @NamedQuery(name = "RemMicrochipMascota.findByAcuerdoResponsabilidad", query = "SELECT r FROM RemMicrochipMascota r WHERE r.acuerdoResponsabilidad = :acuerdoResponsabilidad"),
    @NamedQuery(name = "RemMicrochipMascota.findByEstado", query = "SELECT r FROM RemMicrochipMascota r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemMicrochipMascota.findByUsuarioCreacion", query = "SELECT r FROM RemMicrochipMascota r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemMicrochipMascota.findByTerminalCreacion", query = "SELECT r FROM RemMicrochipMascota r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemMicrochipMascota.findByFechaCreacion", query = "SELECT r FROM RemMicrochipMascota r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemMicrochipMascota.findByUsuarioModificacion", query = "SELECT r FROM RemMicrochipMascota r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemMicrochipMascota.findByTerminalModificacion", query = "SELECT r FROM RemMicrochipMascota r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemMicrochipMascota.findByFechaModificacion", query = "SELECT r FROM RemMicrochipMascota r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemMicrochipMascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MICROCHIP_MASCOTA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long microchipMascotaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODIGO_MICROCHIP", nullable = false, length = 30)
    private String codigoMicrochip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "INFORMACION_CONSIDERADA", nullable = false, length = 2)
    private String informacionConsiderada;
    @Size(max = 300)
    @Column(length = 300)
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ACUERDO_RESPONSABILIDAD", nullable = false, length = 3)
    private String acuerdoResponsabilidad;
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

    @OneToMany(mappedBy = "microchipMascotaId", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet;

    @JoinColumn(name = "VETERINARIO", referencedColumnName = "REGISTRO_PROFESIONAL_ID", nullable = false)
    @JsonBackReference("veterinario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemRegistroProfesional veterinario;

    @OneToMany(mappedBy = "microchipMascotaId", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet;

    @JoinColumn(name = "ESTABLECIMIENTO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("establecimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo establecimiento;

    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID", nullable = false)
    @JsonBackReference("tutorId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemTutorMascota tutorId;

    public RemMicrochipMascota() {
    }

    public RemMicrochipMascota(Long microchipMascotaId, String codigoMicrochip, Date fechaIngreso, String informacionConsiderada, String observacion, String acuerdoResponsabilidad, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemRegistroProfesional veterinario, RemCatalogo establecimiento, RemTutorMascota tutorId) {
        this.microchipMascotaId = microchipMascotaId;
        this.codigoMicrochip = codigoMicrochip;
        this.fechaIngreso = fechaIngreso;
        this.informacionConsiderada = informacionConsiderada;
        this.observacion = observacion;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.veterinario = veterinario;
        this.establecimiento = establecimiento;
        this.tutorId = tutorId;
    }

    public Long getMicrochipMascotaId() {
        return microchipMascotaId;
    }

    public void setMicrochipMascotaId(Long microchipMascotaId) {
        this.microchipMascotaId = microchipMascotaId;
    }

    public String getCodigoMicrochip() {
        return codigoMicrochip;
    }

    public void setCodigoMicrochip(String codigoMicrochip) {
        this.codigoMicrochip = codigoMicrochip;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getInformacionConsiderada() {
        return informacionConsiderada;
    }

    public void setInformacionConsiderada(String informacionConsiderada) {
        this.informacionConsiderada = informacionConsiderada;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
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

    public RemCatalogo getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(RemCatalogo establecimiento) {
        this.establecimiento = establecimiento;
    }

    public RemTutorMascota getTutorId() {
        return tutorId;
    }

    public void setTutorId(RemTutorMascota tutorId) {
        this.tutorId = tutorId;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet() {
        return remAnimalTutorSet;
    }

    public void setRemAnimalTutorSet(Set<RemAnimalTutor> remAnimalTutorSet) {
        this.remAnimalTutorSet = remAnimalTutorSet;
    }

    public RemRegistroProfesional getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(RemRegistroProfesional veterinario) {
        this.veterinario = veterinario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet() {
        return remAtencionAnimalesSet;
    }

    public void setRemAtencionAnimalesSet(Set<RemAtencionAnimales> remAtencionAnimalesSet) {
        this.remAtencionAnimalesSet = remAtencionAnimalesSet;
    }

    @Override
    public String toString() {
        return "RemMicrochipMascota{" + "microchipMascotaId=" + microchipMascotaId + ", codigoMicrochip=" + codigoMicrochip + ", fechaIngreso=" + fechaIngreso + ", informacionConsiderada=" + informacionConsiderada + ", observacion=" + observacion + ", acuerdoResponsabilidad=" + acuerdoResponsabilidad + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", remAtencionAnimalesSet=" + remAtencionAnimalesSet + ", veterinario=" + veterinario + ", remAnimalTutorSet=" + remAnimalTutorSet + ", establecimiento=" + establecimiento + ", tutorId=" + tutorId + '}';
    }

    

}
