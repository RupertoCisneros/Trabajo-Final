/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "REM_TIPO_REGISTRO", catalog = "MDMQ_REMETFU", schema = "Remetfu")

public class RemTipoRegistro implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String descripcion;
    @Size(max = 80)
    @Column(length = 80)
    private String novedad1;
    @Size(max = 80)
    @Column(length = 80)
    private String novedad2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
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


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_REGISTRO_ID", nullable = false)
    private Long tipoRegistroId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRegistroId")
    private List<RemSubtipoRegistro> remSubtipoRegistro;

    public RemTipoRegistro() {
    }

    public RemTipoRegistro(String descripcion, String novedad1, String novedad2, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, Long tipoRegistroId, List<RemSubtipoRegistro> remSubtipoRegistro) {
        this.descripcion = descripcion;
        this.novedad1 = novedad1;
        this.novedad2 = novedad2;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.tipoRegistroId = tipoRegistroId;
        this.remSubtipoRegistro = remSubtipoRegistro;
    }


    public Long getTipoRegistroId() {
        return tipoRegistroId;
    }

    public void setTipoRegistroId(Long tipoRegistroId) {
        this.tipoRegistroId = tipoRegistroId;
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

    public List<RemSubtipoRegistro> gethijos() {
        return remSubtipoRegistro;
    }

    public void sethijos(List<RemSubtipoRegistro> remSubtipoRegistro) {
        this.remSubtipoRegistro = remSubtipoRegistro;
    }

    public List<RemSubtipoRegistro> getRemSubtipoRegistro() {
        return remSubtipoRegistro;
    }

    public void setRemSubtipoRegistro(List<RemSubtipoRegistro> remSubtipoRegistro) {
        this.remSubtipoRegistro = remSubtipoRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNovedad1() {
        return novedad1;
    }

    public void setNovedad1(String novedad1) {
        this.novedad1 = novedad1;
    }

    public String getNovedad2() {
        return novedad2;
    }

    public void setNovedad2(String novedad2) {
        this.novedad2 = novedad2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RemTipoRegistro{" + "descripcion=" + descripcion + ", novedad1=" + novedad1 + ", novedad2=" + novedad2 + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", tipoRegistroId=" + tipoRegistroId + ", remSubtipoRegistro=" + remSubtipoRegistro + '}';
    }


}
