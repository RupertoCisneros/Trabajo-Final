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
@Table(name = "REM_RUBROS_SAO", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemRubrosSao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUBROS_SAO_ID", nullable = false)
    private Integer rubrosSaoId;
    @Size(max = 10)
    @Column(name = "SAO_TIPO_ORDEN_PAGO_RUBRO_ID", length = 10)
    private String saoTipoOrdenPagoRubroId;
    @Size(max = 10)
    @Column(name = "SAO_TIPO_ORDEN_PAGO_ID", length = 10)
    private String saoTipoOrdenPagoId;
    @Size(max = 10)
    @Column(name = "SAO_RUBRO_ID", length = 10)
    private String saoRubroId;
    @Size(max = 10)
    @Column(name = "SAO_RUBRO_ANT", length = 10)
    private String saoRubroAnt;
    @Size(max = 350)
    @Column(name = "SAO_DETALLE", length = 350)
    private String saoDetalle;
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
    @JoinColumn(name = "SUBTIPO_REGISTRO_ID", referencedColumnName = "SUBTIPO_REGISTRO_ID", nullable = false)
    @JsonBackReference("subtipoRegistroId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemSubtipoRegistro subtipoRegistroId;

    public RemRubrosSao() {
    }

    public RemRubrosSao(Integer rubrosSaoId) {
        this.rubrosSaoId = rubrosSaoId;
    }

    public RemRubrosSao(Integer rubrosSaoId, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.rubrosSaoId = rubrosSaoId;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getRubrosSaoId() {
        return rubrosSaoId;
    }

    public void setRubrosSaoId(Integer rubrosSaoId) {
        this.rubrosSaoId = rubrosSaoId;
    }

    public String getSaoTipoOrdenPagoRubroId() {
        return saoTipoOrdenPagoRubroId;
    }

    public void setSaoTipoOrdenPagoRubroId(String saoTipoOrdenPagoRubroId) {
        this.saoTipoOrdenPagoRubroId = saoTipoOrdenPagoRubroId;
    }

    public String getSaoTipoOrdenPagoId() {
        return saoTipoOrdenPagoId;
    }

    public void setSaoTipoOrdenPagoId(String saoTipoOrdenPagoId) {
        this.saoTipoOrdenPagoId = saoTipoOrdenPagoId;
    }

    public String getSaoRubroId() {
        return saoRubroId;
    }

    public void setSaoRubroId(String saoRubroId) {
        this.saoRubroId = saoRubroId;
    }

    public String getSaoRubroAnt() {
        return saoRubroAnt;
    }

    public void setSaoRubroAnt(String saoRubroAnt) {
        this.saoRubroAnt = saoRubroAnt;
    }

    public String getSaoDetalle() {
        return saoDetalle;
    }

    public void setSaoDetalle(String saoDetalle) {
        this.saoDetalle = saoDetalle;
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

    public RemSubtipoRegistro getSubtipoRegistroId() {
        return subtipoRegistroId;
    }

    public void setSubtipoRegistroId(RemSubtipoRegistro subtipoRegistroId) {
        this.subtipoRegistroId = subtipoRegistroId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rubrosSaoId != null ? rubrosSaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemRubrosSao)) {
            return false;
        }
        RemRubrosSao other = (RemRubrosSao) object;
        if ((this.rubrosSaoId == null && other.rubrosSaoId != null) || (this.rubrosSaoId != null && !this.rubrosSaoId.equals(other.rubrosSaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.mdmq.remetfu.Entidades.RemRubrosSao[ rubrosSaoId=" + rubrosSaoId + " ]";
    }
    
}
