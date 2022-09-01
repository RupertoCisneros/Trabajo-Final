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
@Table(name = "REM_PERFIL_ACADEMICO", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(name = "REM_PERFIL_ACADEMICO_UNQ01", columnNames = {"REGISTRO_PROFESIONAL_ID", "CATALOGO_ID"})})
@NamedQueries({
    @NamedQuery(name = "RemPerfilAcademico.findAll", query = "SELECT r FROM RemPerfilAcademico r")})
public class RemPerfilAcademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERFIL_ACADEMICO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perfilAcademicoId;
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
    @Size(max = 100)
    @Column(name = "DOCUMENTO_ACREDITA", length = 100)
    private String documentoAcredita;
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

    @JoinColumn(name = "CATALOGO_ID", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("catalogoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo catalogoId;

    @JoinColumn(name = "REGISTRO_PROFESIONAL_ID", referencedColumnName = "REGISTRO_PROFESIONAL_ID", nullable = false)
    @JsonBackReference("registroProfesionalId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemRegistroProfesional registroProfesionalId;

    public RemPerfilAcademico() {
    }

    public RemPerfilAcademico(Long perfilAcademicoId) {
        this.perfilAcademicoId = perfilAcademicoId;
    }

    public RemPerfilAcademico(Long perfilAcademicoId, Date fechaRegistro, String estado, String documentoAcredita, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemCatalogo catalogoId, RemRegistroProfesional registroProfesionalId) {
        this.perfilAcademicoId = perfilAcademicoId;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.documentoAcredita = documentoAcredita;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.catalogoId = catalogoId;
        this.registroProfesionalId = registroProfesionalId;
    }


    public Long getPerfilAcademicoId() {
        return perfilAcademicoId;
    }

    public void setPerfilAcademicoId(Long perfilAcademicoId) {
        this.perfilAcademicoId = perfilAcademicoId;
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

    public String getDocumentoAcredita() {
        return documentoAcredita;
    }

    public void setDocumentoAcredita(String documentoAcredita) {
        this.documentoAcredita = documentoAcredita;
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

    public RemRegistroProfesional getRegistroProfesionalId() {
        return registroProfesionalId;
    }

    public void setRegistroProfesionalId(RemRegistroProfesional registroProfesionalId) {
        this.registroProfesionalId = registroProfesionalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilAcademicoId != null ? perfilAcademicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemPerfilAcademico)) {
            return false;
        }
        RemPerfilAcademico other = (RemPerfilAcademico) object;
        if ((this.perfilAcademicoId == null && other.perfilAcademicoId != null) || (this.perfilAcademicoId != null && !this.perfilAcademicoId.equals(other.perfilAcademicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemPerfilAcademico{" + "perfilAcademicoId=" + perfilAcademicoId + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", documentoAcredita=" + documentoAcredita + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", catalogoId=" + catalogoId + ", registroProfesionalId=" + registroProfesionalId + '}';
    }

}
