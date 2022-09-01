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
 * @author oportero
 */
@Entity
@Table(name = "REM_TUTOR_MASCOTA", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@NamedQueries({
    @NamedQuery(name = "RemTutorMascota.findAll", query = "SELECT r FROM RemTutorMascota r"),
    @NamedQuery(name = "RemTutorMascota.findByTutorId", query = "SELECT r FROM RemTutorMascota r WHERE r.tutorId = :tutorId"),
    @NamedQuery(name = "RemTutorMascota.findByDireccion", query = "SELECT r FROM RemTutorMascota r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "RemTutorMascota.findByEstado", query = "SELECT r FROM RemTutorMascota r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemTutorMascota.findByUsuarioCreacion", query = "SELECT r FROM RemTutorMascota r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemTutorMascota.findByTerminalCreacion", query = "SELECT r FROM RemTutorMascota r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemTutorMascota.findByFechaCreacion", query = "SELECT r FROM RemTutorMascota r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemTutorMascota.findByUsuarioModificacion", query = "SELECT r FROM RemTutorMascota r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemTutorMascota.findByTerminalModificacion", query = "SELECT r FROM RemTutorMascota r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemTutorMascota.findByFechaModificacion", query = "SELECT r FROM RemTutorMascota r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemTutorMascota implements Serializable {

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
    @Column(name = "TUTOR_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String direccion;
    @Size(max = 3)
    @Column(length = 3)
    private String estado;

    @OneToMany(mappedBy = "tutorId", fetch = FetchType.LAZY)
    private Set<RemTutoresComunitarios> remTutoresComunitariosSet;

    @OneToMany(mappedBy = "tutorId", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorId", fetch = FetchType.LAZY)
    private Set<RemMicrochipMascota> remMicrochipMascotaSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorId", fetch = FetchType.LAZY)
    private Set<RemMicrochipMascotaUba> remMicrochipMascotaUbaSet;

    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    @JsonBackReference("usuarioIdTutor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemUsuarios usuarioId;

    public RemTutorMascota() {
    }

    public RemTutorMascota(String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, Long tutorId, String direccion, String estado, RemUsuarios usuarioId) {
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.tutorId = tutorId;
        this.direccion = direccion;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }


    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
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

    public RemUsuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(RemUsuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<RemMicrochipMascota> getRemMicrochipMascotaSet() {
        return remMicrochipMascotaSet;
    }

    public void setRemMicrochipMascotaSet(Set<RemMicrochipMascota> remMicrochipMascotaSet) {
        this.remMicrochipMascotaSet = remMicrochipMascotaSet;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet() {
        return remAnimalTutorSet;
    }

    public void setRemAnimalTutorSet(Set<RemAnimalTutor> remAnimalTutorSet) {
        this.remAnimalTutorSet = remAnimalTutorSet;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<RemTutoresComunitarios> getRemTutoresComunitariosSet() {
        return remTutoresComunitariosSet;
    }

    public void setRemTutoresComunitariosSet(Set<RemTutoresComunitarios> remTutoresComunitariosSet) {
        this.remTutoresComunitariosSet = remTutoresComunitariosSet;
    }

    public Set<RemMicrochipMascotaUba> getRemMicrochipMascotaUbaSet() {
        return remMicrochipMascotaUbaSet;
    }

    public void setRemMicrochipMascotaUbaSet(Set<RemMicrochipMascotaUba> remMicrochipMascotaUbaSet) {
        this.remMicrochipMascotaUbaSet = remMicrochipMascotaUbaSet;
    }

    @Override
    public String toString() {
        return "RemTutorMascota{" + "usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", tutorId=" + tutorId + ", direccion=" + direccion + ", estado=" + estado + ", remTutoresComunitariosSet=" + remTutoresComunitariosSet + ", remAnimalTutorSet=" + remAnimalTutorSet + ", remMicrochipMascotaSet=" + remMicrochipMascotaSet + ", remMicrochipMascotaUbaSet=" + remMicrochipMascotaUbaSet + ", usuarioId=" + usuarioId + '}';
    }

}
