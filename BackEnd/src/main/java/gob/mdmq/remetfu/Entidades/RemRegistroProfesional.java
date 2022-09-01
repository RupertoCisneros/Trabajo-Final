/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
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
@Table(name = "REM_REGISTRO_PROFESIONAL", catalog = "MDMQ_REMETFU", schema = "Remetfu", uniqueConstraints = {
    @UniqueConstraint(name = "REM_REGISTRO_PROFESIONAL_UNQ01", columnNames = {"USUARIO_ID", "SUBTIPO_REGISTRO_ID", "ESTADO"})})

public class RemRegistroProfesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REGISTRO_PROFESIONAL_ID", nullable = false)
    private Long registroProfesionalId;
    @Column(name = "VISA_TRABAJO", length = 300)
    private String visatrabajo;
    @Column(name = "CALLE_PRINCIPAL", length = 150)
    private String callePrincipal;
    @Column(name = "CALLE_NUMERO", length = 15)
    private String calleNumero;
    @Column(name = "CALLE_SECUNDARIA", length = 150)
    private String calleSecundaria;
    @Column(name = "CALLE_REFERENCIA1", length = 150)
    private String calleReferencia1;
    @Column(name = "CALLE_REFERENCIA2", length = 150)
    private String calleReferencia2;
    @Column(name = "NOMBRE_GREMIO", length = 100)
    private String nombreGremio;
    @Column(name = "FECHA_INACTIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInactivo;
    @Column(name = "DIAS_INACTIVO")
    private Integer diasInactivo;
    @Basic(optional = false)
    @Column(name = "USUARIO_CREACION", nullable = false, length = 30)
    private String usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "TERMINAL_CREACION", nullable = false, length = 30)
    private String terminalCreacion;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "USUARIO_MODIFICACION", nullable = false, length = 30)
    private String usuarioModificacion;
    @Basic(optional = false)
    @Column(name = "TERMINAL_MODIFICACION", nullable = false, length = 30)
    private String terminalModificacion;
    @Basic(optional = false)
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL_TMP", nullable = false)
    private long secuencialTmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL_FINAL", nullable = false)
    private long secuencialFinal;
    @Size(max = 150)
    @Column(length = 150)
    private String barrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ACUERDO_RESPONSABILIDAD", nullable = false, length = 3)
    private String acuerdoResponsabilidad;
    @Size(max = 300)
    @Column(name = "EXPERIENCIA_LABORAL", length = 300)
    private String experienciaLaboral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String agremiado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veterinario", fetch = FetchType.LAZY)
    private Set<RemMicrochipMascota> remMicrochipMascotaSet;

    @JoinColumn(name = "VISA_TRABAJO", referencedColumnName = "ARCHIVO_ID", insertable = false, updatable = false)
    @JsonBackReference("visaTrabajo")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos visaTrabajo;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "registroProfesionalId", fetch = FetchType.LAZY)
    private RemAnalisisTramiteRegistroProfesional remAnalisisTramiteRegistroProfesional;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registroProfesionalId", fetch = FetchType.LAZY)
    private Set<RemPerfilAcademico> remPerfilAcademicoSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registroProfesionalId", fetch = FetchType.LAZY)
    private Set<RemTituloProfesional> remTituloProfesionalSet;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("usuarioId")
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", nullable = false)
    private RemUsuarios usuarioId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("subtipoRegistroId")
    @JoinColumn(name = "SUBTIPO_REGISTRO_ID", referencedColumnName = "SUBTIPO_REGISTRO_ID", nullable = false)
    private RemSubtipoRegistro subtipoRegistroId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("estado")
    @JoinColumn(name = "ESTADO", referencedColumnName = "CATALOGO_ID", nullable = false)
    private RemCatalogo estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("parroquia")
    @JoinColumn(name = "PARROQUIA", referencedColumnName = "CATALOGO_ID", nullable = false)
    private RemCatalogo parroquia;

    public RemRegistroProfesional() {
    }

    public RemRegistroProfesional(Long registroProfesionalId, String visatrabajo, String callePrincipal, String calleNumero, String calleSecundaria, String calleReferencia1, String calleReferencia2, String nombreGremio, Date fechaInactivo, Integer diasInactivo, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, long secuencialTmp, long secuencialFinal, String barrio, String acuerdoResponsabilidad, String experienciaLaboral, String agremiado, RemArchivos visaTrabajo, RemAnalisisTramiteRegistroProfesional remAnalisisTramiteRegistroProfesional, RemUsuarios usuarioId, RemSubtipoRegistro subtipoRegistroId, RemCatalogo estado, RemCatalogo parroquia) {
        this.registroProfesionalId = registroProfesionalId;
        this.visatrabajo = visatrabajo;
        this.callePrincipal = callePrincipal;
        this.calleNumero = calleNumero;
        this.calleSecundaria = calleSecundaria;
        this.calleReferencia1 = calleReferencia1;
        this.calleReferencia2 = calleReferencia2;
        this.nombreGremio = nombreGremio;
        this.fechaInactivo = fechaInactivo;
        this.diasInactivo = diasInactivo;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.fechaModificacion = fechaModificacion;
        this.secuencialTmp = secuencialTmp;
        this.secuencialFinal = secuencialFinal;
        this.barrio = barrio;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.experienciaLaboral = experienciaLaboral;
        this.agremiado = agremiado;
        this.visaTrabajo = visaTrabajo;
        this.remAnalisisTramiteRegistroProfesional = remAnalisisTramiteRegistroProfesional;
        this.usuarioId = usuarioId;
        this.subtipoRegistroId = subtipoRegistroId;
        this.estado = estado;
        this.parroquia = parroquia;
    }

    public Long getRegistroProfesionalId() {
        return registroProfesionalId;
    }

    public void setRegistroProfesionalId(Long registroProfesionalId) {
        this.registroProfesionalId = registroProfesionalId;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getCalleReferencia1() {
        return calleReferencia1;
    }

    public void setCalleReferencia1(String calleReferencia1) {
        this.calleReferencia1 = calleReferencia1;
    }

    public String getCalleReferencia2() {
        return calleReferencia2;
    }

    public void setCalleReferencia2(String calleReferencia2) {
        this.calleReferencia2 = calleReferencia2;
    }

    public RemCatalogo getEstado() {
        return estado;
    }

    public void setEstado(RemCatalogo estado) {
        this.estado = estado;
    }

    public String getNombreGremio() {
        return nombreGremio;
    }

    public void setNombreGremio(String nombreGremio) {
        this.nombreGremio = nombreGremio;
    }

    public Date getFechaInactivo() {
        return fechaInactivo;
    }

    public void setFechaInactivo(Date fechaInactivo) {
        this.fechaInactivo = fechaInactivo;
    }

    public Integer getDiasInactivo() {
        return diasInactivo;
    }

    public void setDiasInactivo(Integer diasInactivo) {
        this.diasInactivo = diasInactivo;
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

    public RemUsuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(RemUsuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getSecuencialTmp() {
        return secuencialTmp;
    }

    public void setSecuencialTmp(long secuencialTmp) {
        this.secuencialTmp = secuencialTmp;
    }

    public long getSecuencialFinal() {
        return secuencialFinal;
    }

    public void setSecuencialFinal(long secuencialFinal) {
        this.secuencialFinal = secuencialFinal;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
    }

    public RemSubtipoRegistro getSubtipoRegistroId() {
        return subtipoRegistroId;
    }

    public void setSubtipoRegistroId(RemSubtipoRegistro subtipoRegistroId) {
        this.subtipoRegistroId = subtipoRegistroId;
    }

    public RemAnalisisTramiteRegistroProfesional getRemAnalisisTramiteRegistroProfesional() {
        return remAnalisisTramiteRegistroProfesional;
    }

    public void setRemAnalisisTramiteRegistroProfesional(RemAnalisisTramiteRegistroProfesional remAnalisisTramiteRegistroProfesional) {
        this.remAnalisisTramiteRegistroProfesional = remAnalisisTramiteRegistroProfesional;
    }

    public RemCatalogo getParroquia() {
        return parroquia;
    }

    public void setParroquia(RemCatalogo parroquia) {
        this.parroquia = parroquia;
    }

    public Set<RemPerfilAcademico> getRemPerfilAcademicoSet() {
        return remPerfilAcademicoSet;
    }

    public void setRemPerfilAcademicoSet(Set<RemPerfilAcademico> remPerfilAcademicoSet) {
        this.remPerfilAcademicoSet = remPerfilAcademicoSet;
    }

    public Set<RemTituloProfesional> getRemTituloProfesionalSet() {
        return remTituloProfesionalSet;
    }

    public void setRemTituloProfesionalSet(Set<RemTituloProfesional> remTituloProfesionalSet) {
        this.remTituloProfesionalSet = remTituloProfesionalSet;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public RemArchivos getVisaTrabajo() {
        return visaTrabajo;
    }

    public void setVisaTrabajo(RemArchivos visaTrabajo) {
        this.visaTrabajo = visaTrabajo;
    }

    public Set<RemMicrochipMascota> getRemMicrochipMascotaSet() {
        return remMicrochipMascotaSet;
    }

    public void setRemMicrochipMascotaSet(Set<RemMicrochipMascota> remMicrochipMascotaSet) {
        this.remMicrochipMascotaSet = remMicrochipMascotaSet;
    }

    public String getVisatrabajo() {
        return visatrabajo;
    }

    public void setVisatrabajo(String visatrabajo) {
        this.visatrabajo = visatrabajo;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getAgremiado() {
        return agremiado;
    }

    public void setAgremiado(String agremiado) {
        this.agremiado = agremiado;
    }

    @Override
    public String toString() {
        return "RemRegistroProfesional{" + "registroProfesionalId=" + registroProfesionalId + ", visatrabajo=" + visatrabajo + ", callePrincipal=" + callePrincipal + ", calleNumero=" + calleNumero + ", calleSecundaria=" + calleSecundaria + ", calleReferencia1=" + calleReferencia1 + ", calleReferencia2=" + calleReferencia2 + ", nombreGremio=" + nombreGremio + ", fechaInactivo=" + fechaInactivo + ", diasInactivo=" + diasInactivo + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", fechaModificacion=" + fechaModificacion + ", secuencialTmp=" + secuencialTmp + ", secuencialFinal=" + secuencialFinal + ", barrio=" + barrio + ", acuerdoResponsabilidad=" + acuerdoResponsabilidad + ", experienciaLaboral=" + experienciaLaboral + ", agremiado=" + agremiado + ", remMicrochipMascotaSet=" + remMicrochipMascotaSet + ", visaTrabajo=" + visaTrabajo + ", remAnalisisTramiteRegistroProfesional=" + remAnalisisTramiteRegistroProfesional + ", remPerfilAcademicoSet=" + remPerfilAcademicoSet + ", remTituloProfesionalSet=" + remTituloProfesionalSet + ", usuarioId=" + usuarioId + ", subtipoRegistroId=" + subtipoRegistroId + ", estado=" + estado + ", parroquia=" + parroquia + '}';
    }

   

}
