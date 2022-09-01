/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_SECUENCIAL", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@NamedQueries({
    @NamedQuery(name = "RemSecuencial.findAll", query = "SELECT r FROM RemSecuencial r"),
    @NamedQuery(name = "RemSecuencial.findBySecuencialId", query = "SELECT r FROM RemSecuencial r WHERE r.secuencialId = :secuencialId"),
    @NamedQuery(name = "RemSecuencial.findByDescripcion", query = "SELECT r FROM RemSecuencial r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RemSecuencial.findByAnio", query = "SELECT r FROM RemSecuencial r WHERE r.anio = :anio"),
    @NamedQuery(name = "RemSecuencial.findByFormato", query = "SELECT r FROM RemSecuencial r WHERE r.formato = :formato"),
    @NamedQuery(name = "RemSecuencial.findByNumero", query = "SELECT r FROM RemSecuencial r WHERE r.numero = :numero"),
    @NamedQuery(name = "RemSecuencial.findByTabla", query = "SELECT r FROM RemSecuencial r WHERE r.tabla = :tabla"),
    @NamedQuery(name = "RemSecuencial.findByCampo", query = "SELECT r FROM RemSecuencial r WHERE r.campo = :campo")})
public class RemSecuencial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL_ID", nullable = false)
    private Integer secuencialId;
    @Size(max = 50)
    @Column(length = 50)
    private String descripcion;
    @Size(max = 50)
    @Column(length = 50)
    private String anio;
    @Size(max = 50)
    @Column(length = 50)
    private String formato;
    private BigInteger numero;
    @Size(max = 50)
    @Column(length = 50)
    private String tabla;
    @Size(max = 50)
    @Column(length = 50)
    private String campo;

    public RemSecuencial() {
    }

    public RemSecuencial(Integer secuencialId, String descripcion, String anio, String formato, BigInteger numero, String tabla, String campo) {
        this.secuencialId = secuencialId;
        this.descripcion = descripcion;
        this.anio = anio;
        this.formato = formato;
        this.numero = numero;
        this.tabla = tabla;
        this.campo = campo;
    }

    public Integer getSecuencialId() {
        return secuencialId;
    }

    public void setSecuencialId(Integer secuencialId) {
        this.secuencialId = secuencialId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencialId != null ? secuencialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemSecuencial)) {
            return false;
        }
        RemSecuencial other = (RemSecuencial) object;
        if ((this.secuencialId == null && other.secuencialId != null) || (this.secuencialId != null && !this.secuencialId.equals(other.secuencialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RemSecuencial{" + "secuencialId=" + secuencialId + ", descripcion=" + descripcion + ", anio=" + anio + ", formato=" + formato + ", numero=" + numero + ", tabla=" + tabla + ", campo=" + campo + '}';
    }

    
}
