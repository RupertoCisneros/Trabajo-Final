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
@Table(name = "REM_ENFERMEDADES_ANIMALES", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemEnfermedadesAnimales.findAll", query = "SELECT r FROM RemEnfermedadesAnimales r"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByEnfermedadesAnimalesId", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.enfermedadesAnimalesId = :enfermedadesAnimalesId"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByFechaRegistro", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByEstado", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByUsuarioCreacion", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByTerminalCreacion", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByFechaCreacion", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByUsuarioModificacion", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByTerminalModificacion", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemEnfermedadesAnimales.findByFechaModificacion", query = "SELECT r FROM RemEnfermedadesAnimales r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemEnfermedadesAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENFERMEDADES_ANIMALES_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enfermedadesAnimalesId;
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

    @JoinColumn(name = "ENFERMEDADES_DETECTADAS", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("enfermedadesDetectadas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo enfermedadesDetectadas;

    @JoinColumn(name = "ATENCION_ANIMALES_ID", referencedColumnName = "ATENCION_ANIMALES_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("atencionAnimalesId")
    private RemAtencionAnimales atencionAnimalesId;

    public RemEnfermedadesAnimales() {
    }

    public RemEnfermedadesAnimales(Long enfermedadesAnimalesId) {
        this.enfermedadesAnimalesId = enfermedadesAnimalesId;
    }

    public RemEnfermedadesAnimales(Long enfermedadesAnimalesId, Date fechaRegistro, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemCatalogo enfermedadesDetectadas, RemAtencionAnimales atencionAnimalesId) {
        this.enfermedadesAnimalesId = enfermedadesAnimalesId;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.enfermedadesDetectadas = enfermedadesDetectadas;
        this.atencionAnimalesId = atencionAnimalesId;
    }


    public Long getEnfermedadesAnimalesId() {
        return enfermedadesAnimalesId;
    }

    public void setEnfermedadesAnimalesId(Long enfermedadesAnimalesId) {
        this.enfermedadesAnimalesId = enfermedadesAnimalesId;
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

    public RemCatalogo getEnfermedadesDetectadas() {
        return enfermedadesDetectadas;
    }

    public void setEnfermedadesDetectadas(RemCatalogo enfermedadesDetectadas) {
        this.enfermedadesDetectadas = enfermedadesDetectadas;
    }

    public RemAtencionAnimales getAtencionAnimalesId() {
        return atencionAnimalesId;
    }

    public void setAtencionAnimalesId(RemAtencionAnimales atencionAnimalesId) {
        this.atencionAnimalesId = atencionAnimalesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enfermedadesAnimalesId != null ? enfermedadesAnimalesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemEnfermedadesAnimales)) {
            return false;
        }
        RemEnfermedadesAnimales other = (RemEnfermedadesAnimales) object;
        if ((this.enfermedadesAnimalesId == null && other.enfermedadesAnimalesId != null) || (this.enfermedadesAnimalesId != null && !this.enfermedadesAnimalesId.equals(other.enfermedadesAnimalesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemEnfermedadesAnimales{" + "enfermedadesAnimalesId=" + enfermedadesAnimalesId + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", enfermedadesDetectadas=" + enfermedadesDetectadas + ", atencionAnimalesId=" + atencionAnimalesId + '}';
    }


}
