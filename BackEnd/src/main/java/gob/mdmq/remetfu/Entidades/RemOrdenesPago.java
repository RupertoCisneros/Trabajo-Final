/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author oportero
 */
@Entity
@Table(name = "REM_ORDENES_PAGO", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemOrdenesPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDENES_PAGO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordenesPagoId;
    @Column(name = "NRO_REGISTRO", nullable = false)
    private Long nroRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ING", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIng;
    @Size(max = 20)
    @Column(name = "ORDENPAGO_SAO", length = 20)
    private String ordenpagoSao;
    @Size(max = 3)
    @Column(name = "ESTADO_SAO", length = 3)
    private String estadoSao;
    @Column(name = "FECHA_REG_SAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegSao;
    @Column(name = "FECHA_PAGO_SAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagoSao;
    @Column(name = "FECHA_BAJA_SAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBajaSao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CODIGO_QR", nullable = false, length = 200)
    private String codigoQr;
    @Column(name = "VALOR_SAO", precision = 18, scale = 2)
    private BigDecimal valorSao;
    @Size(max = 200)
    @Column(name = "CONCEPTO_SAO", length = 200)
    private String conceptoSao;
    @Size(max = 15)
    @Column(name = "CI_DEUDOR", length = 15)
    private String ciDeudor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String novedad;
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

    @JoinColumn(name = "SUBTIPO_REGISTRO_ID", referencedColumnName = "SUBTIPO_REGISTRO_ID", nullable = false)
    @JsonBackReference("subtipoRegistroId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemSubtipoRegistro subtipoRegistroId;

    public RemOrdenesPago() {
    }

    public RemOrdenesPago(Long ordenesPagoId, Long nroRegistro, Date fechaIng, String ordenpagoSao, String estadoSao, Date fechaRegSao, Date fechaPagoSao, Date fechaBajaSao, String codigoQr, BigDecimal valorSao, String conceptoSao, String ciDeudor, String novedad, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemSubtipoRegistro subtipoRegistroId) {
        this.ordenesPagoId = ordenesPagoId;
        this.nroRegistro = nroRegistro;
        this.fechaIng = fechaIng;
        this.ordenpagoSao = ordenpagoSao;
        this.estadoSao = estadoSao;
        this.fechaRegSao = fechaRegSao;
        this.fechaPagoSao = fechaPagoSao;
        this.fechaBajaSao = fechaBajaSao;
        this.codigoQr = codigoQr;
        this.valorSao = valorSao;
        this.conceptoSao = conceptoSao;
        this.ciDeudor = ciDeudor;
        this.novedad = novedad;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.subtipoRegistroId = subtipoRegistroId;
    }


    public Long getOrdenesPagoId() {
        return ordenesPagoId;
    }

    public void setOrdenesPagoId(Long ordenesPagoId) {
        this.ordenesPagoId = ordenesPagoId;
    }

    public RemSubtipoRegistro getSubtipoRegistroId() {
        return subtipoRegistroId;
    }

    public void setSubtipoRegistroId(RemSubtipoRegistro subtipoRegistroId) {
        this.subtipoRegistroId = subtipoRegistroId;
    }

    public Long getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(Long nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getOrdenpagoSao() {
        return ordenpagoSao;
    }

    public void setOrdenpagoSao(String ordenpagoSao) {
        this.ordenpagoSao = ordenpagoSao;
    }

    public String getEstadoSao() {
        return estadoSao;
    }

    public void setEstadoSao(String estadoSao) {
        this.estadoSao = estadoSao;
    }

    public Date getFechaRegSao() {
        return fechaRegSao;
    }

    public void setFechaRegSao(Date fechaRegSao) {
        this.fechaRegSao = fechaRegSao;
    }

    public Date getFechaPagoSao() {
        return fechaPagoSao;
    }

    public void setFechaPagoSao(Date fechaPagoSao) {
        this.fechaPagoSao = fechaPagoSao;
    }

    public Date getFechaBajaSao() {
        return fechaBajaSao;
    }

    public void setFechaBajaSao(Date fechaBajaSao) {
        this.fechaBajaSao = fechaBajaSao;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public BigDecimal getValorSao() {
        return valorSao;
    }

    public void setValorSao(BigDecimal valorSao) {
        this.valorSao = valorSao;
    }

    public String getConceptoSao() {
        return conceptoSao;
    }

    public void setConceptoSao(String conceptoSao) {
        this.conceptoSao = conceptoSao;
    }

    public String getCiDeudor() {
        return ciDeudor;
    }

    public void setCiDeudor(String ciDeudor) {
        this.ciDeudor = ciDeudor;
    }

    
    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
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
    public String toString() {
        return "RemOrdenesPago{" + "ordenesPagoId=" + ordenesPagoId + ", nroRegistro=" + nroRegistro + ", fechaIng=" + fechaIng + ", ordenpagoSao=" + ordenpagoSao + ", estadoSao=" + estadoSao + ", fechaRegSao=" + fechaRegSao + ", fechaPagoSao=" + fechaPagoSao + ", fechaBajaSao=" + fechaBajaSao + ", codigoQr=" + codigoQr + ", novedad=" + novedad + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", subtipoRegistroId=" + subtipoRegistroId + '}';
    }
    
}
