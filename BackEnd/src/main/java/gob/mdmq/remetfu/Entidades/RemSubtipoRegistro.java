/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_SUBTIPO_REGISTRO", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemSubtipoRegistro implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_FORMULARIO", nullable = false)
    private Long tipoFormulario;
    @Size(max = 80)
    @Column(length = 80)
    private String novedad1;
    @Size(max = 800)
    @Column(length = 800)
    private String novedad2;
    @Size(max = 800)
    @Column(length = 800)
    private String novedad3;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtipoRegistroId", fetch = FetchType.LAZY)
    private Set<RemRubrosSao> remRubrosSaoSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBTIPO_REGISTRO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subtipoRegistroId;
    @Column(name = "VALOR1", precision = 15, scale = 2)
    private BigDecimal valor1;
    @Column(name = "VALOR2", precision = 15, scale = 2)
    private BigDecimal valor2;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtipoRegistroId")
    private Set<RemNomenclatura> subtipoRegistroIdNomenclatura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtipoRegistroId", fetch = FetchType.LAZY)
    private Set<RemRegistroProfesional> remRegistroProfesionalSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtipoRegistroId", fetch = FetchType.LAZY)
    private Set<RemOrdenesPago> remOrdenesPagoSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("tipoRegistroIdSubTipo")
    @JoinColumn(name = "TIPO_REGISTRO_ID", referencedColumnName = "TIPO_REGISTRO_ID", nullable = false)
    private RemTipoRegistro tipoRegistroId;

    public RemSubtipoRegistro() {
    }

    public RemSubtipoRegistro(String descripcion, Long tipoFormulario, String novedad1, String novedad2, String novedad3, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, Set<RemRubrosSao> remRubrosSaoSet, Long subtipoRegistroId, BigDecimal valor1, BigDecimal valor2, RemTipoRegistro tipoRegistroId) {
        this.descripcion = descripcion;
        this.tipoFormulario = tipoFormulario;
        this.novedad1 = novedad1;
        this.novedad2 = novedad2;
        this.novedad3 = novedad3;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.remRubrosSaoSet = remRubrosSaoSet;
        this.subtipoRegistroId = subtipoRegistroId;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.tipoRegistroId = tipoRegistroId;
    }



    public Long getSubtipoRegistroId() {
        return subtipoRegistroId;
    }

    public void setSubtipoRegistroId(Long subtipoRegistroId) {
        this.subtipoRegistroId = subtipoRegistroId;
    }

    public Long getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(Long tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }

    public Set<RemRubrosSao> getRemRubrosSaoSet() {
        return remRubrosSaoSet;
    }

    public void setRemRubrosSaoSet(Set<RemRubrosSao> remRubrosSaoSet) {
        this.remRubrosSaoSet = remRubrosSaoSet;
    }

    public BigDecimal getValor1() {
        return valor1;
    }

    public void setValor1(BigDecimal valor1) {
        this.valor1 = valor1;
    }

    public BigDecimal getValor2() {
        return valor2;
    }

    public void setValor2(BigDecimal valor2) {
        this.valor2 = valor2;
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

    public RemTipoRegistro getTipoRegistroId() {
        return tipoRegistroId;
    }

    public void setTipoRegistroId(RemTipoRegistro tipoRegistroId) {
        this.tipoRegistroId = tipoRegistroId;
    }

    @XmlTransient
    public Set<RemRegistroProfesional> getRemRegistroProfesionalSet() {
        return remRegistroProfesionalSet;
    }

    public void setRemRegistroProfesionalSet(Set<RemRegistroProfesional> remRegistroProfesionalSet) {
        this.remRegistroProfesionalSet = remRegistroProfesionalSet;
    }

    public Set<RemNomenclatura> getSubtipoRegistroIdNomenclatura() {
        return subtipoRegistroIdNomenclatura;
    }

    public void setSubtipoRegistroIdNomenclatura(Set<RemNomenclatura> subtipoRegistroIdNomenclatura) {
        this.subtipoRegistroIdNomenclatura = subtipoRegistroIdNomenclatura;
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

    public String getNovedad3() {
        return novedad3;
    }

    public void setNovedad3(String novedad3) {
        this.novedad3 = novedad3;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<RemOrdenesPago> getRemOrdenesPagoSet() {
        return remOrdenesPagoSet;
    }

    public void setRemOrdenesPagoSet(Set<RemOrdenesPago> remOrdenesPagoSet) {
        this.remOrdenesPagoSet = remOrdenesPagoSet;
    }

    
    @Override
    public String toString() {
        return "RemSubtipoRegistro{" + "descripcion=" + descripcion + ", tipoFormulario=" + tipoFormulario + ", novedad1=" + novedad1 + ", novedad2=" + novedad2 + ", novedad3=" + novedad3 + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", remRubrosSaoSet=" + remRubrosSaoSet + ", subtipoRegistroId=" + subtipoRegistroId + ", valor1=" + valor1 + ", valor2=" + valor2 + ", subtipoRegistroIdNomenclatura=" + subtipoRegistroIdNomenclatura + ", remRegistroProfesionalSet=" + remRegistroProfesionalSet + ", remOrdenesPagoSet=" + remOrdenesPagoSet + ", tipoRegistroId=" + tipoRegistroId + '}';
    }

}
