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
@Table(name = "REM_NOMENCLATURA", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemNomenclatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMENCLATURA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nomenclaturaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL_TMP", nullable = false)
    private long secuencialTmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMENCLATURA_TMP", nullable = false, length = 50)
    private String nomenclaturaTmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL_FINAL", nullable = false)
    private long secuencialFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMENCLATURA_FINAL", nullable = false, length = 50)
    private String nomenclaturaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_DIGITOS")
    private Long numeroDigitos;
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
    @JsonBackReference("subtipoRegistroIdNomenclatura")
    @ManyToOne(optional = false)
    private RemSubtipoRegistro subtipoRegistroId;

    public RemNomenclatura() {
    }

    public RemNomenclatura(Integer nomenclaturaId) {
        this.nomenclaturaId = nomenclaturaId;
    }

    public RemNomenclatura(Integer nomenclaturaId, long secuencialTmp, String nomenclaturaTmp, long secuencialFinal, String nomenclaturaFinal, Long numeroDigitos, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, RemSubtipoRegistro subtipoRegistroId) {
        this.nomenclaturaId = nomenclaturaId;
        this.secuencialTmp = secuencialTmp;
        this.nomenclaturaTmp = nomenclaturaTmp;
        this.secuencialFinal = secuencialFinal;
        this.nomenclaturaFinal = nomenclaturaFinal;
        this.numeroDigitos = numeroDigitos;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.subtipoRegistroId = subtipoRegistroId;
    }


    public Integer getNomenclaturaId() {
        return nomenclaturaId;
    }

    public void setNomenclaturaId(Integer nomenclaturaId) {
        this.nomenclaturaId = nomenclaturaId;
    }

    public long getSecuencialTmp() {
        return secuencialTmp;
    }

    public void setSecuencialTmp(long secuencialTmp) {
        this.secuencialTmp = secuencialTmp;
    }

    public String getNomenclaturaTmp() {
        return nomenclaturaTmp;
    }

    public void setNomenclaturaTmp(String nomenclaturaTmp) {
        this.nomenclaturaTmp = nomenclaturaTmp;
    }

    public long getSecuencialFinal() {
        return secuencialFinal;
    }

    public void setSecuencialFinal(long secuencialFinal) {
        this.secuencialFinal = secuencialFinal;
    }

    public String getNomenclaturaFinal() {
        return nomenclaturaFinal;
    }

    public void setNomenclaturaFinal(String nomenclaturaFinal) {
        this.nomenclaturaFinal = nomenclaturaFinal;
    }

    public Long getNumeroDigitos() {
        return numeroDigitos;
    }

    public void setNumeroDigitos(Long numeroDigitos) {
        this.numeroDigitos = numeroDigitos;
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
        hash += (nomenclaturaId != null ? nomenclaturaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemNomenclatura)) {
            return false;
        }
        RemNomenclatura other = (RemNomenclatura) object;
        if ((this.nomenclaturaId == null && other.nomenclaturaId != null) || (this.nomenclaturaId != null && !this.nomenclaturaId.equals(other.nomenclaturaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemNomenclatura{" + "nomenclaturaId=" + nomenclaturaId + ", secuencialTmp=" + secuencialTmp + ", nomenclaturaTmp=" + nomenclaturaTmp + ", secuencialFinal=" + secuencialFinal + ", nomenclaturaFinal=" + nomenclaturaFinal + ", numeroDigitos=" + numeroDigitos + ", estado=" + estado + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", subtipoRegistroId=" + subtipoRegistroId + '}';
    }

}
