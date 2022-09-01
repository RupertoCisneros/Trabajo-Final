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

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_MICROCHIP_MASCOTA_UBA", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemMicrochipMascotaUba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MICROCHIP_MASCOTA_UBA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long microchipMascotaUbaId;
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

    @JoinColumn(name = "ESTABLECIMIENTO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("establecimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo establecimiento;

    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID", nullable = false)
    @JsonBackReference("tutorId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemTutorMascota tutorId;

    @JoinColumn(name = "FUNCIONARIO_UBA", referencedColumnName = "USUARIO_ID", nullable = false)
    @JsonBackReference("funcionarioUba")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemUsuarios funcionarioUba;

    public RemMicrochipMascotaUba() {
    }

    public RemMicrochipMascotaUba(Long microchipMascotaUbaId) {
        this.microchipMascotaUbaId = microchipMascotaUbaId;
    }

    public RemMicrochipMascotaUba(Long microchipMascotaUbaId, String codigoMicrochip, Date fechaIngreso, String informacionConsiderada, String acuerdoResponsabilidad, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.microchipMascotaUbaId = microchipMascotaUbaId;
        this.codigoMicrochip = codigoMicrochip;
        this.fechaIngreso = fechaIngreso;
        this.informacionConsiderada = informacionConsiderada;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getMicrochipMascotaUbaId() {
        return microchipMascotaUbaId;
    }

    public void setMicrochipMascotaUbaId(Long microchipMascotaUbaId) {
        this.microchipMascotaUbaId = microchipMascotaUbaId;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
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

    public RemUsuarios getFuncionarioUba() {
        return funcionarioUba;
    }

    public void setFuncionarioUba(RemUsuarios funcionarioUba) {
        this.funcionarioUba = funcionarioUba;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (microchipMascotaUbaId != null ? microchipMascotaUbaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemMicrochipMascotaUba)) {
            return false;
        }
        RemMicrochipMascotaUba other = (RemMicrochipMascotaUba) object;
        if ((this.microchipMascotaUbaId == null && other.microchipMascotaUbaId != null) || (this.microchipMascotaUbaId != null && !this.microchipMascotaUbaId.equals(other.microchipMascotaUbaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.mdmq.remetfu.Entidades.RemMicrochipMascotaUba[ microchipMascotaUbaId=" + microchipMascotaUbaId + " ]";
    }
    
}
