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
@Table(name = "REM_TITULO_PROFESIONAL", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(name = "REM_TITULO_PROFESIONAL_UNQ01", columnNames = {"REGISTRO_PROFESIONAL_ID"})})
@NamedQueries({
    @NamedQuery(name = "RemTituloProfesional.findAll", query = "SELECT r FROM RemTituloProfesional r")})
public class RemTituloProfesional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TITULO_PROFESIONAL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tituloProfesionalId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NRO_REGISTRO", nullable = false, length = 20)
    private String nroRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_TITULO", nullable = false, length = 50)
    private String nombreTitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "INSTITUCION_TITULO", nullable = false, length = 50)
    private String institucionTitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NIVEL_TITULO", nullable = false, length = 50)
    private String nivelTitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_TITULO", nullable = false, length = 20)
    private String tipoTitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RECONOCIDO_POR", nullable = false, length = 50)
    private String reconocidoPor;
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

    @JoinColumn(name = "REGISTRO_PROFESIONAL_ID", referencedColumnName = "REGISTRO_PROFESIONAL_ID", nullable = false)
    @JsonBackReference("registroProfesionalId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemRegistroProfesional registroProfesionalId;

    public RemTituloProfesional() {
    }

    public RemTituloProfesional(String nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public RemTituloProfesional(Long tituloProfesionalId, String nroRegistro, Date fechaRegistro, String nombreTitulo, String institucionTitulo, String nivelTitulo, String tipoTitulo, String reconocidoPor, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemRegistroProfesional registroProfesionalId) {
        this.tituloProfesionalId = tituloProfesionalId;
        this.nroRegistro = nroRegistro;
        this.fechaRegistro = fechaRegistro;
        this.nombreTitulo = nombreTitulo;
        this.institucionTitulo = institucionTitulo;
        this.nivelTitulo = nivelTitulo;
        this.tipoTitulo = tipoTitulo;
        this.reconocidoPor = reconocidoPor;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.registroProfesionalId = registroProfesionalId;
    }

    public Long getTituloProfesionalId() {
        return tituloProfesionalId;
    }

    public void setTituloProfesionalId(Long tituloProfesionalId) {
        this.tituloProfesionalId = tituloProfesionalId;
    }

    public String getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(String nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getInstitucionTitulo() {
        return institucionTitulo;
    }

    public void setInstitucionTitulo(String institucionTitulo) {
        this.institucionTitulo = institucionTitulo;
    }

    public String getNivelTitulo() {
        return nivelTitulo;
    }

    public void setNivelTitulo(String nivelTitulo) {
        this.nivelTitulo = nivelTitulo;
    }

    public String getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(String tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public String getReconocidoPor() {
        return reconocidoPor;
    }

    public void setReconocidoPor(String reconocidoPor) {
        this.reconocidoPor = reconocidoPor;
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

    public RemRegistroProfesional getRegistroProfesionalId() {
        return registroProfesionalId;
    }

    public void setRegistroProfesionalId(RemRegistroProfesional registroProfesionalId) {
        this.registroProfesionalId = registroProfesionalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroRegistro != null ? nroRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemTituloProfesional)) {
            return false;
        }
        RemTituloProfesional other = (RemTituloProfesional) object;
        if ((this.nroRegistro == null && other.nroRegistro != null) || (this.nroRegistro != null && !this.nroRegistro.equals(other.nroRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemTituloProfesional{" + "nroRegistro=" + nroRegistro + ", fechaRegistro=" + fechaRegistro + ", nombreTitulo=" + nombreTitulo + ", institucionTitulo=" + institucionTitulo + ", nivelTitulo=" + nivelTitulo + ", tipoTitulo=" + tipoTitulo + ", reconocidoPor=" + reconocidoPor + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", registroProfesionalId=" + registroProfesionalId + '}';
    }

}
