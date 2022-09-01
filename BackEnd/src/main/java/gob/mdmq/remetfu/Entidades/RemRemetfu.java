/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "REM_REMETFU", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NRO_IDENTIFICACION"})})
@NamedQueries({
    @NamedQuery(name = "RemRemetfu.findAll", query = "SELECT r FROM RemRemetfu r"),
    @NamedQuery(name = "RemRemetfu.findByRemetfuId", query = "SELECT r FROM RemRemetfu r WHERE r.remetfuId = :remetfuId"),
    @NamedQuery(name = "RemRemetfu.findByTipoIdentificacion", query = "SELECT r FROM RemRemetfu r WHERE r.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "RemRemetfu.findByNroIdentificacion", query = "SELECT r FROM RemRemetfu r WHERE r.nroIdentificacion = :nroIdentificacion"),
    @NamedQuery(name = "RemRemetfu.findByNombres", query = "SELECT r FROM RemRemetfu r WHERE r.nombres = :nombres"),
    @NamedQuery(name = "RemRemetfu.findByApellidos", query = "SELECT r FROM RemRemetfu r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "RemRemetfu.findByMail", query = "SELECT r FROM RemRemetfu r WHERE r.mail = :mail"),
    @NamedQuery(name = "RemRemetfu.findByDireccion", query = "SELECT r FROM RemRemetfu r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "RemRemetfu.findByTelefono", query = "SELECT r FROM RemRemetfu r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "RemRemetfu.findByMovil", query = "SELECT r FROM RemRemetfu r WHERE r.movil = :movil"),
    @NamedQuery(name = "RemRemetfu.findByEstado", query = "SELECT r FROM RemRemetfu r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemRemetfu.findByUsuarioCreacion", query = "SELECT r FROM RemRemetfu r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemRemetfu.findByTerminalCreacion", query = "SELECT r FROM RemRemetfu r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemRemetfu.findByFechaCreacion", query = "SELECT r FROM RemRemetfu r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemRemetfu.findByUsuarioModificacion", query = "SELECT r FROM RemRemetfu r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemRemetfu.findByTerminalModificacion", query = "SELECT r FROM RemRemetfu r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemRemetfu.findByFechaModificacion", query = "SELECT r FROM RemRemetfu r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemRemetfu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REMETFU_ID", nullable = false)
    private Long remetfuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_IDENTIFICACION", nullable = false)
    private Character tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "NRO_IDENTIFICACION", nullable = false, length = 13)
    private String nroIdentificacion;
    @Size(max = 50)
    @Column(length = 50)
    private String nombres;
    @Size(max = 50)
    @Column(length = 50)
    private String apellidos;
    @Size(max = 60)
    @Column(length = 60)
    private String mail;
    @Size(max = 200)
    @Column(length = 200)
    private String direccion;
    @Size(max = 10)
    @Column(length = 10)
    private String telefono;
    @Size(max = 15)
    @Column(length = 15)
    private String movil;
    @Lob
    private byte[] firma;
    @Size(max = 3)
    @Column(length = 3)
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

    public RemRemetfu() {
    }

    public RemRemetfu(Long remetfuId) {
        this.remetfuId = remetfuId;
    }

    public RemRemetfu(Long remetfuId, Character tipoIdentificacion, String nroIdentificacion, String nombres, String apellidos, String mail, String direccion, String telefono, String movil, byte[] firma, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.remetfuId = remetfuId;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nroIdentificacion = nroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.mail = mail;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.firma = firma;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getRemetfuId() {
        return remetfuId;
    }

    public void setRemetfuId(Long remetfuId) {
        this.remetfuId = remetfuId;
    }

    public Character getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Character tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (remetfuId != null ? remetfuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemRemetfu)) {
            return false;
        }
        RemRemetfu other = (RemRemetfu) object;
        if ((this.remetfuId == null && other.remetfuId != null) || (this.remetfuId != null && !this.remetfuId.equals(other.remetfuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemRemetfu{" + "remetfuId=" + remetfuId + ", tipoIdentificacion=" + tipoIdentificacion + ", nroIdentificacion=" + nroIdentificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", mail=" + mail + ", direccion=" + direccion + ", telefono=" + telefono + ", movil=" + movil + ", firma=" + firma + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + '}';
    }

    
}
