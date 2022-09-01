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
@Table(name = "REM_RECEPCION_ANIMALES", catalog = "MDMQ_REMETFU", schema = "Remetfu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemRecepcionAnimales.findAll", query = "SELECT r FROM RemRecepcionAnimales r"),
    @NamedQuery(name = "RemRecepcionAnimales.findByRecepcionAnimalesId", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.recepcionAnimalesId = :recepcionAnimalesId"),
    @NamedQuery(name = "RemRecepcionAnimales.findBySenialesParticulares", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.senialesParticulares = :senialesParticulares"),
    @NamedQuery(name = "RemRecepcionAnimales.findByDescripcionProceso", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.descripcionProceso = :descripcionProceso"),
    @NamedQuery(name = "RemRecepcionAnimales.findByExamenComportamental", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.examenComportamental = :examenComportamental"),
    @NamedQuery(name = "RemRecepcionAnimales.findByAcuerdoResponsabilidad", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.acuerdoResponsabilidad = :acuerdoResponsabilidad"),
    @NamedQuery(name = "RemRecepcionAnimales.findByFechaRegistro", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "RemRecepcionAnimales.findByEstado", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.estado = :estado"),
    @NamedQuery(name = "RemRecepcionAnimales.findByUsuarioCreacion", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RemRecepcionAnimales.findByTerminalCreacion", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.terminalCreacion = :terminalCreacion"),
    @NamedQuery(name = "RemRecepcionAnimales.findByFechaCreacion", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RemRecepcionAnimales.findByUsuarioModificacion", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RemRecepcionAnimales.findByTerminalModificacion", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.terminalModificacion = :terminalModificacion"),
    @NamedQuery(name = "RemRecepcionAnimales.findByFechaModificacion", query = "SELECT r FROM RemRecepcionAnimales r WHERE r.fechaModificacion = :fechaModificacion")})
public class RemRecepcionAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEPCION_ANIMALES_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recepcionAnimalesId;
    @Size(max = 300)
    @Column(name = "SENIALES_PARTICULARES", length = 300)
    private String senialesParticulares;
    @Size(max = 250)
    @Column(name = "DESCRIPCION_PROCESO", length = 250)
    private String descripcionProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EXAMEN_COMPORTAMENTAL", nullable = false, length = 3)
    private String examenComportamental;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ACUERDO_RESPONSABILIDAD", nullable = false, length = 3)
    private String acuerdoResponsabilidad;
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

    @JoinColumn(name = "AGENCIA_UBA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("agenciaUba")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo agenciaUba;

    @JoinColumn(name = "ESPECIE", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("especie")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo especie;

    @JoinColumn(name = "RAZA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("raza")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo raza;

    @JoinColumn(name = "SEXO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("sexo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo sexo;

    @JoinColumn(name = "ESTADO_REPRODUCTIVO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("estadoReproductivo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo estadoReproductivo;

    @JoinColumn(name = "COLOR_PREDOMINANTE", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("colorPredominante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo colorPredominante;

    @JoinColumn(name = "COLOR_SECUNDARIO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("colorSecundario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo colorSecundario;

    @JoinColumn(name = "PROCESO_EJECUCION", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("procesoEjecucion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo procesoEjecucion;

    @JoinColumn(name = "PRUEBA_COMPORTAMIENTO", referencedColumnName = "CATALOGO_ID", nullable = true)
    @JsonBackReference("pruebaComportamiento")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private RemCatalogo pruebaComportamiento;

    @JoinColumn(name = "FUNCIONARIO_UBA", referencedColumnName = "USUARIO_ID", nullable = false)
    @JsonBackReference("funcionarioUba")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemUsuarios funcionarioUba;

    public RemRecepcionAnimales() {
    }

    public RemRecepcionAnimales(Long recepcionAnimalesId, String examenComportamental, String acuerdoResponsabilidad, Date fechaRegistro, String estado, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion) {
        this.recepcionAnimalesId = recepcionAnimalesId;
        this.examenComportamental = examenComportamental;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getRecepcionAnimalesId() {
        return recepcionAnimalesId;
    }

    public void setRecepcionAnimalesId(Long recepcionAnimalesId) {
        this.recepcionAnimalesId = recepcionAnimalesId;
    }

    public String getSenialesParticulares() {
        return senialesParticulares;
    }

    public void setSenialesParticulares(String senialesParticulares) {
        this.senialesParticulares = senialesParticulares;
    }

    public String getDescripcionProceso() {
        return descripcionProceso;
    }

    public void setDescripcionProceso(String descripcionProceso) {
        this.descripcionProceso = descripcionProceso;
    }

    public String getExamenComportamental() {
        return examenComportamental;
    }

    public void setExamenComportamental(String examenComportamental) {
        this.examenComportamental = examenComportamental;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
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

    public RemCatalogo getAgenciaUba() {
        return agenciaUba;
    }

    public void setAgenciaUba(RemCatalogo agenciaUba) {
        this.agenciaUba = agenciaUba;
    }

    public RemCatalogo getEspecie() {
        return especie;
    }

    public void setEspecie(RemCatalogo especie) {
        this.especie = especie;
    }

    public RemCatalogo getRaza() {
        return raza;
    }

    public void setRaza(RemCatalogo raza) {
        this.raza = raza;
    }

    public RemCatalogo getSexo() {
        return sexo;
    }

    public void setSexo(RemCatalogo sexo) {
        this.sexo = sexo;
    }

    public RemCatalogo getEstadoReproductivo() {
        return estadoReproductivo;
    }

    public void setEstadoReproductivo(RemCatalogo estadoReproductivo) {
        this.estadoReproductivo = estadoReproductivo;
    }

    public RemCatalogo getColorPredominante() {
        return colorPredominante;
    }

    public void setColorPredominante(RemCatalogo colorPredominante) {
        this.colorPredominante = colorPredominante;
    }

    public RemCatalogo getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(RemCatalogo colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public RemCatalogo getProcesoEjecucion() {
        return procesoEjecucion;
    }

    public void setProcesoEjecucion(RemCatalogo procesoEjecucion) {
        this.procesoEjecucion = procesoEjecucion;
    }

    public RemCatalogo getPruebaComportamiento() {
        return pruebaComportamiento;
    }

    public void setPruebaComportamiento(RemCatalogo pruebaComportamiento) {
        this.pruebaComportamiento = pruebaComportamiento;
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
        hash += (recepcionAnimalesId != null ? recepcionAnimalesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemRecepcionAnimales)) {
            return false;
        }
        RemRecepcionAnimales other = (RemRecepcionAnimales) object;
        if ((this.recepcionAnimalesId == null && other.recepcionAnimalesId != null) || (this.recepcionAnimalesId != null && !this.recepcionAnimalesId.equals(other.recepcionAnimalesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.mdmq.remetfu.Entidades.RemRecepcionAnimales[ recepcionAnimalesId=" + recepcionAnimalesId + " ]";
    }

}
