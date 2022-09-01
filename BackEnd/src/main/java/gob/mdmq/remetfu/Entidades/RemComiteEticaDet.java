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
@Table(name = "REM_COMITE_ETICA_DET", catalog = "MDMQ_REMETFU", schema = "Remetfu")
        //,uniqueConstraints = {UniqueConstraint(name = "REM_COMITE_ETICA_DET_UNQ01",columnNames = {"COMITE_ETICA_CAB_ID", "IDENTIFICACION"})})
public class RemComiteEticaDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMITE_ETICA_DET_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comiteEticaDetId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IDENTIFICACION", nullable = false, length = 15)
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRES", nullable = false, length = 100)
    private String nombres;
   
    @Size(min = 1, max = 50)
    @Column(name = "NUMERO_SENECYT", length = 50)
    private String numeroSenecyt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO", nullable = false, length = 50)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONO", nullable = false, length = 15)
    private String telefono;
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

    @JoinColumn(name = "CARGO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("cargoComite")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo cargo;

    @JoinColumn(name = "COMITE_ETICA_CAB_ID", referencedColumnName = "COMITE_ETICA_CAB_ID", nullable = false)
    @JsonBackReference("comiteEticaCabIds")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemComiteEticaCab comiteEticaCabId;

    public RemComiteEticaDet() {
    }

    public RemComiteEticaDet(Long comiteEticaDetId) {
        this.comiteEticaDetId = comiteEticaDetId;
    }

    public RemComiteEticaDet(Long comiteEticaDetId, String identificacion, String nombres, String numeroSenecyt, String correo, String telefono, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemCatalogo cargo, RemComiteEticaCab comiteEticaCabId) {
        this.comiteEticaDetId = comiteEticaDetId;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.numeroSenecyt = numeroSenecyt;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.cargo = cargo;
        this.comiteEticaCabId = comiteEticaCabId;
    }


    public Long getComiteEticaDetId() {
        return comiteEticaDetId;
    }

    public void setComiteEticaDetId(Long comiteEticaDetId) {
        this.comiteEticaDetId = comiteEticaDetId;
    }

    public String getNumeroSenecyt() {
        return numeroSenecyt;
    }

    public void setNumeroSenecyt(String numeroSenecyt) {
        this.numeroSenecyt = numeroSenecyt;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public RemCatalogo getCargo() {
        return cargo;
    }

    public void setCargo(RemCatalogo cargo) {
        this.cargo = cargo;
    }

    public RemComiteEticaCab getComiteEticaCabId() {
        return comiteEticaCabId;
    }

    public void setComiteEticaCabId(RemComiteEticaCab comiteEticaCabId) {
        this.comiteEticaCabId = comiteEticaCabId;
    }

    @Override
    public String toString() {
        return "RemComiteEticaDet{" + "comiteEticaDetId=" + comiteEticaDetId + ", identificacion=" + identificacion + ", nombres=" + nombres + ", numeroSenecyt=" + numeroSenecyt + ", correo=" + correo + ", telefono=" + telefono + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", cargo=" + cargo + ", comiteEticaCabId=" + comiteEticaCabId + '}';
    }

}
