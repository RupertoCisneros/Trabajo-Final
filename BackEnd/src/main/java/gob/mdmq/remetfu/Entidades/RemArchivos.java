/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "REM_ARCHIVOS", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@NamedQueries({
    @NamedQuery(name = "RemArchivos.findAll", query = "SELECT r FROM RemArchivos r"),
    @NamedQuery(name = "RemArchivos.findByArchivoId", query = "SELECT r FROM RemArchivos r WHERE r.archivoId = :archivoId"),
    @NamedQuery(name = "RemArchivos.findByNombreArchivo", query = "SELECT r FROM RemArchivos r WHERE r.nombreArchivo = :nombreArchivo"),
    @NamedQuery(name = "RemArchivos.findByTipoArchivo", query = "SELECT r FROM RemArchivos r WHERE r.tipoArchivo = :tipoArchivo"),
    @NamedQuery(name = "RemArchivos.findByHash", query = "SELECT r FROM RemArchivos r WHERE r.hash = :hash"),
    @NamedQuery(name = "RemArchivos.findByRuta", query = "SELECT r FROM RemArchivos r WHERE r.ruta = :ruta"),
    @NamedQuery(name = "RemArchivos.findByObservacion", query = "SELECT r FROM RemArchivos r WHERE r.observacion = :observacion"),
    @NamedQuery(name = "RemArchivos.findByUsuarioCreacion", query = "SELECT r FROM RemArchivos r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemArchivos.findByTerminalCreacion", query = "SELECT r FROM RemArchivos r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemArchivos.findByFechaCreacion", query = "SELECT r FROM RemArchivos r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemArchivos.findByUsuarioModificacion", query = "SELECT r FROM RemArchivos r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemArchivos.findByTerminalModificacion", query = "SELECT r FROM RemArchivos r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemArchivos.findByFechaModificacion", query = "SELECT r FROM RemArchivos r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemArchivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "ARCHIVO_ID", nullable = false, length = 36)
    private String archivoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "NOMBRE_ARCHIVO", nullable = false, length = 300)
    private String nombreArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TIPO_ARCHIVO", nullable = false, length = 150)
    private String tipoArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(nullable = false, length = 150)
    private String hash;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(nullable = false, length = 300)
    private String ruta;
    @Size(max = 300)
    @Column(length = 300)
    private String observacion;
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
    @OneToMany(mappedBy = "identificacionFotografica1", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet;
    @OneToMany(mappedBy = "identificacionFotografica2", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet1;
    @OneToMany(mappedBy = "identificacionVisible", fetch = FetchType.LAZY)
    private Set<RemAtencionAnimales> remAtencionAnimalesSet2;

    @OneToMany(mappedBy = "documentoAcredita", fetch = FetchType.LAZY)
    private Set<RemTipoAnimalTutor> remTipoAnimalTutorSet;

    @OneToMany(mappedBy = "certificadoEsterilizacionArchivo", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet;

    @OneToMany(mappedBy = "identificacionFotografica1", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet2;
    @OneToMany(mappedBy = "identificacionFotografica2", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet3;
    @OneToMany(mappedBy = "identificacionVisible", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet4;
    @OneToMany(mappedBy = "certificadoVacunacionArchivo", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet5;
    @OneToMany(mappedBy = "visaTrabajo", fetch = FetchType.LAZY)
    private Set<RemRegistroProfesional> remRegistroProfesionalSet;

    @OneToMany(mappedBy = "examenComportamentalArchivo", fetch = FetchType.LAZY)
    private Set<RemAnimalTutor> remAnimalTutorSet6;

    public RemArchivos() {
    }

    public RemArchivos(String archivoId, String nombreArchivo, String tipoArchivo, String hash, String ruta, String observacion, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.archivoId = archivoId;
        this.nombreArchivo = nombreArchivo;
        this.tipoArchivo = tipoArchivo;
        this.hash = hash;
        this.ruta = ruta;
        this.observacion = observacion;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

   
    public String getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(String archivoId) {
        this.archivoId = archivoId;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
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

    public Set<RemAnimalTutor> getRemAnimalTutorSet() {
        return remAnimalTutorSet;
    }

    public void setRemAnimalTutorSet(Set<RemAnimalTutor> remAnimalTutorSet) {
        this.remAnimalTutorSet = remAnimalTutorSet;
    }

    

    public Set<RemAnimalTutor> getRemAnimalTutorSet2() {
        return remAnimalTutorSet2;
    }

    public void setRemAnimalTutorSet2(Set<RemAnimalTutor> remAnimalTutorSet2) {
        this.remAnimalTutorSet2 = remAnimalTutorSet2;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet3() {
        return remAnimalTutorSet3;
    }

    public void setRemAnimalTutorSet3(Set<RemAnimalTutor> remAnimalTutorSet3) {
        this.remAnimalTutorSet3 = remAnimalTutorSet3;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet4() {
        return remAnimalTutorSet4;
    }

    public void setRemAnimalTutorSet4(Set<RemAnimalTutor> remAnimalTutorSet4) {
        this.remAnimalTutorSet4 = remAnimalTutorSet4;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet5() {
        return remAnimalTutorSet5;
    }

    public void setRemAnimalTutorSet5(Set<RemAnimalTutor> remAnimalTutorSet5) {
        this.remAnimalTutorSet5 = remAnimalTutorSet5;
    }

    public Set<RemRegistroProfesional> getRemRegistroProfesionalSet() {
        return remRegistroProfesionalSet;
    }

    public void setRemRegistroProfesionalSet(Set<RemRegistroProfesional> remRegistroProfesionalSet) {
        this.remRegistroProfesionalSet = remRegistroProfesionalSet;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Set<RemTipoAnimalTutor> getRemTipoAnimalTutorSet() {
        return remTipoAnimalTutorSet;
    }

    public void setRemTipoAnimalTutorSet(Set<RemTipoAnimalTutor> remTipoAnimalTutorSet) {
        this.remTipoAnimalTutorSet = remTipoAnimalTutorSet;
    }

    public Set<RemAnimalTutor> getRemAnimalTutorSet6() {
        return remAnimalTutorSet6;
    }

    public void setRemAnimalTutorSet6(Set<RemAnimalTutor> remAnimalTutorSet6) {
        this.remAnimalTutorSet6 = remAnimalTutorSet6;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet() {
        return remAtencionAnimalesSet;
    }

    public void setRemAtencionAnimalesSet(Set<RemAtencionAnimales> remAtencionAnimalesSet) {
        this.remAtencionAnimalesSet = remAtencionAnimalesSet;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet1() {
        return remAtencionAnimalesSet1;
    }

    public void setRemAtencionAnimalesSet1(Set<RemAtencionAnimales> remAtencionAnimalesSet1) {
        this.remAtencionAnimalesSet1 = remAtencionAnimalesSet1;
    }

    public Set<RemAtencionAnimales> getRemAtencionAnimalesSet2() {
        return remAtencionAnimalesSet2;
    }

    public void setRemAtencionAnimalesSet2(Set<RemAtencionAnimales> remAtencionAnimalesSet2) {
        this.remAtencionAnimalesSet2 = remAtencionAnimalesSet2;
    }

    @Override
    public String toString() {
        return "RemArchivos{" + "archivoId=" + archivoId + ", nombreArchivo=" + nombreArchivo + ", tipoArchivo=" + tipoArchivo + ", hash=" + hash + ", ruta=" + ruta + ", observacion=" + observacion + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", remAtencionAnimalesSet=" + remAtencionAnimalesSet + ", remAtencionAnimalesSet1=" + remAtencionAnimalesSet1 + ", remAtencionAnimalesSet2=" + remAtencionAnimalesSet2 + ", remTipoAnimalTutorSet=" + remTipoAnimalTutorSet + ", remAnimalTutorSet=" + remAnimalTutorSet + ", remAnimalTutorSet2=" + remAnimalTutorSet2 + ", remAnimalTutorSet3=" + remAnimalTutorSet3 + ", remAnimalTutorSet4=" + remAnimalTutorSet4 + ", remAnimalTutorSet5=" + remAnimalTutorSet5 + ", remRegistroProfesionalSet=" + remRegistroProfesionalSet + ", remAnimalTutorSet6=" + remAnimalTutorSet6 + '}';
    }


    

}
