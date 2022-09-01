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

/**
 *
 * @author srcisnerosv
 */
@Entity
@Table(name = "REM_ANIMAL_TUTOR", catalog = "MDMQ_REMETFU", schema = "Remetfu")
public class RemAnimalTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIMAL_TUTOR_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalTutorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL_TMP", nullable = false)
    private long secuencialTmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SECUENCIAL_FINAL", nullable = false)
    private long secuencialFinal;
    
    @Column(name = "MT2_VIVIENDA", precision = 5, scale = 2)
    private BigDecimal mt2Vivienda;
    @Column(name = "MT2_PERMANENCIA", precision = 5, scale = 2)
    private BigDecimal mt2Permanencia;
    @Column(name = "FECHA_FALLECIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFallecimiento;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String cerramiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String comunitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROCEDENCIA_ANIMAL", nullable = false)
    private int procedenciaAnimal;
    @Size(max = 300)
    @Column(name = "OBSERVACION_MICROCHIP", length = 300)
    private String observacionMicrochip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_ANIMAL", nullable = false, length = 100)
    private String nombreAnimal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Size(max = 300)
    @Column(name = "SENIALES_PARTICULARES", length = 300)
    private String senialesParticulares;
    @Size(max = 50)
    @Column(name = "PERMANENCIA_OTROS", length = 50)
    private String permanenciaOtros;
    @Size(max = 150)
    @Column(length = 150)
    private String barrio;
    @Size(max = 150)
    @Column(name = "CALLE_PRINCIPAL", length = 150)
    private String callePrincipal;
    @Size(max = 15)
    @Column(name = "CALLE_NUMERO", length = 15)
    private String calleNumero;
    @Size(max = 150)
    @Column(name = "CALLE_SECUNDARIA", length = 150)
    private String calleSecundaria;
    @Size(max = 150)
    @Column(name = "CALLE_REFERENCIA1", length = 150)
    private String calleReferencia1;
    @Size(max = 150)
    @Column(name = "CALLE_REFERENCIA2", length = 150)
    private String calleReferencia2;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS_VIVIENDA", nullable = false)
    private int estatusVivienda;
    @Size(max = 50)
    @Column(name = "ESTATUS_VIVIENDA_OTROS", length = 50)
    private String estatusViviendaOtros;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 3)
    @Column(name = "ENFERMEDAD_CATASTROFICA", nullable = false, length = 3)
    private String enfermedadCatastrofica;
    @Size(max = 300)
    @Column(name = "DESCRIPCION_ENFERMEDAD", length = 300)
    private String descripcionEnfermedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EXAMEN_COMPORTAMENTAL", nullable = false, length = 3)
    private String examenComportamental;
    @Size(max = 300)
    @Column(name = "EXAMEN_FISICO", length = 300)
    private String examenFisico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CERTIFICADO_VACUNACION", nullable = false, length = 3)
    private String certificadoVacunacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CERTIFICADO_ESTERILIZACION", nullable = false, length = 3)
    private String certificadoEsterilizacion;
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
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_CREACION", nullable = false, length = 30)
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull()
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalTutorId", fetch = FetchType.LAZY)
    private Set<RemTipoAnimalTutor> remTipoAnimalTutorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalTutorId", fetch = FetchType.LAZY)
    private Set<RemTutoresComunitarios> remTutoresComunitariosSet;

    @JoinColumn(name = "CERTIFICADO_ESTERILIZACION_ARCHIVO", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("certificadoEsterilizacionArchivo")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos certificadoEsterilizacionArchivo;

    @JoinColumn(name = "RAZA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("raza")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo raza;

    @JoinColumn(name = "IDENTIFICACION_FOTOGRAFICA1", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("identificacionFotografica1")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos identificacionFotografica1;

    @JoinColumn(name = "IDENTIFICACION_FOTOGRAFICA2", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("identificacionFotografica2")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos identificacionFotografica2;

    @JoinColumn(name = "ESTADO_REPRODUCTIVO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("estadoReproductivo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo estadoReproductivo;

    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID")
    @JsonBackReference("tutorId")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemTutorMascota tutorId;

    @JoinColumn(name = "ESPECIE", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("especie")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo especie;

    @JoinColumn(name = "IDENTIFICACION_VISIBLE", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("identificacionVisible")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos identificacionVisible;

    @JoinColumn(name = "CERTIFICADO_VACUNACION_ARCHIVO", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("certificadoVacunacionArchivo")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos certificadoVacunacionArchivo;

    @JoinColumn(name = "MOTIVO_FALLECIMIENTO", referencedColumnName = "CATALOGO_ID")
    @JsonBackReference("motivoFallecimiento")
    @ManyToOne( fetch = FetchType.LAZY)
    private RemCatalogo motivoFallecimiento;

    @JoinColumn(name = "PERMANENCIA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("permanencia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo permanencia;

    @JoinColumn(name = "COLOR_PREDOMINANTE", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("colorPredominante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo colorPredominante;

    @JoinColumn(name = "COLOR_SECUNDARIO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("colorSecundario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo colorSecundario;

    @JoinColumn(name = "PARROQUIA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("parroquia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo parroquia;

    @JoinColumn(name = "TIPO_VIVIENDA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("tipoVivienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo tipoVivienda;

    @JoinColumn(name = "MICROCHIP_MASCOTA_ID", referencedColumnName = "MICROCHIP_MASCOTA_ID")
    @JsonBackReference("microchipMascotaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemMicrochipMascota microchipMascotaId;

    @JoinColumn(name = "PRUEBA_COMPORTAMIENTO", referencedColumnName = "CATALOGO_ID")
    @JsonBackReference("pruebaComportamiento")
    @ManyToOne( fetch = FetchType.LAZY)
    private RemCatalogo pruebaComportamiento;

    @JoinColumn(name = "ESTADO_TUTORIA", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("estadoTutoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo estadoTutoria;

    @JoinColumn(name = "SEXO", referencedColumnName = "CATALOGO_ID", nullable = false)
    @JsonBackReference("sexo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RemCatalogo sexo;

    @JoinColumn(name = "EXAMEN_COMPORTAMENTAL_ARCHIVO", referencedColumnName = "ARCHIVO_ID")
    @JsonBackReference("examenComportamentalArchivo")
    @ManyToOne(fetch = FetchType.LAZY)
    private RemArchivos examenComportamentalArchivo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("estado")
    @JoinColumn(name = "ESTADO", referencedColumnName = "CATALOGO_ID", nullable = false)
    private RemCatalogo estado;

    public RemAnimalTutor() {
    }

    public RemAnimalTutor(Long animalTutorId, long secuencialTmp, long secuencialFinal, BigDecimal mt2Vivienda, BigDecimal mt2Permanencia, Date fechaFallecimiento, String cerramiento, Date fechaModificacion, String comunitario, int procedenciaAnimal, String observacionMicrochip, String nombreAnimal, Date fechaNacimiento, String senialesParticulares, String permanenciaOtros, String barrio, String callePrincipal, String calleNumero, String calleSecundaria, String calleReferencia1, String calleReferencia2, int estatusVivienda, String estatusViviendaOtros, String enfermedadCatastrofica, String descripcionEnfermedad, String examenComportamental, String examenFisico, String certificadoVacunacion, String certificadoEsterilizacion, String acuerdoResponsabilidad, Date fechaRegistro, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, RemArchivos certificadoEsterilizacionArchivo, RemCatalogo raza, RemArchivos identificacionFotografica1, RemArchivos identificacionFotografica2, RemCatalogo estadoReproductivo, RemTutorMascota tutorId, RemCatalogo especie, RemArchivos identificacionVisible, RemArchivos certificadoVacunacionArchivo, RemCatalogo motivoFallecimiento, RemCatalogo permanencia, RemCatalogo colorPredominante, RemCatalogo colorSecundario, RemCatalogo parroquia, RemCatalogo tipoVivienda, RemMicrochipMascota microchipMascotaId, RemCatalogo pruebaComportamiento, RemCatalogo estadoTutoria, RemCatalogo sexo, RemArchivos examenComportamentalArchivo, RemCatalogo estado) {
        this.animalTutorId = animalTutorId;
        this.secuencialTmp = secuencialTmp;
        this.secuencialFinal = secuencialFinal;
        this.mt2Vivienda = mt2Vivienda;
        this.mt2Permanencia = mt2Permanencia;
        this.fechaFallecimiento = fechaFallecimiento;
        this.cerramiento = cerramiento;
        this.fechaModificacion = fechaModificacion;
        this.comunitario = comunitario;
        this.procedenciaAnimal = procedenciaAnimal;
        this.observacionMicrochip = observacionMicrochip;
        this.nombreAnimal = nombreAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.senialesParticulares = senialesParticulares;
        this.permanenciaOtros = permanenciaOtros;
        this.barrio = barrio;
        this.callePrincipal = callePrincipal;
        this.calleNumero = calleNumero;
        this.calleSecundaria = calleSecundaria;
        this.calleReferencia1 = calleReferencia1;
        this.calleReferencia2 = calleReferencia2;
        this.estatusVivienda = estatusVivienda;
        this.estatusViviendaOtros = estatusViviendaOtros;
        this.enfermedadCatastrofica = enfermedadCatastrofica;
        this.descripcionEnfermedad = descripcionEnfermedad;
        this.examenComportamental = examenComportamental;
        this.examenFisico = examenFisico;
        this.certificadoVacunacion = certificadoVacunacion;
        this.certificadoEsterilizacion = certificadoEsterilizacion;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.fechaRegistro = fechaRegistro;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = terminalModificacion;
        this.certificadoEsterilizacionArchivo = certificadoEsterilizacionArchivo;
        this.raza = raza;
        this.identificacionFotografica1 = identificacionFotografica1;
        this.identificacionFotografica2 = identificacionFotografica2;
        this.estadoReproductivo = estadoReproductivo;
        this.tutorId = tutorId;
        this.especie = especie;
        this.identificacionVisible = identificacionVisible;
        this.certificadoVacunacionArchivo = certificadoVacunacionArchivo;
        this.motivoFallecimiento = motivoFallecimiento;
        this.permanencia = permanencia;
        this.colorPredominante = colorPredominante;
        this.colorSecundario = colorSecundario;
        this.parroquia = parroquia;
        this.tipoVivienda = tipoVivienda;
        this.microchipMascotaId = microchipMascotaId;
        this.pruebaComportamiento = pruebaComportamiento;
        this.estadoTutoria = estadoTutoria;
        this.sexo = sexo;
        this.examenComportamentalArchivo = examenComportamentalArchivo;
        this.estado = estado;
    }


    public Long getAnimalTutorId() {
        return animalTutorId;
    }

    public void setAnimalTutorId(Long animalTutorId) {
        this.animalTutorId = animalTutorId;
    }

    public String getComunitario() {
        return comunitario;
    }

    public void setComunitario(String comunitario) {
        this.comunitario = comunitario;
    }

    public int getProcedenciaAnimal() {
        return procedenciaAnimal;
    }

    public void setProcedenciaAnimal(int procedenciaAnimal) {
        this.procedenciaAnimal = procedenciaAnimal;
    }

    public String getObservacionMicrochip() {
        return observacionMicrochip;
    }

    public void setObservacionMicrochip(String observacionMicrochip) {
        this.observacionMicrochip = observacionMicrochip;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSenialesParticulares() {
        return senialesParticulares;
    }

    public void setSenialesParticulares(String senialesParticulares) {
        this.senialesParticulares = senialesParticulares;
    }

    public String getPermanenciaOtros() {
        return permanenciaOtros;
    }

    public void setPermanenciaOtros(String permanenciaOtros) {
        this.permanenciaOtros = permanenciaOtros;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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

    public BigDecimal getMt2Vivienda() {
        return mt2Vivienda;
    }

    public void setMt2Vivienda(BigDecimal mt2Vivienda) {
        this.mt2Vivienda = mt2Vivienda;
    }

    public BigDecimal getMt2Permanencia() {
        return mt2Permanencia;
    }

    public void setMt2Permanencia(BigDecimal mt2Permanencia) {
        this.mt2Permanencia = mt2Permanencia;
    }

    public String getCerramiento() {
        return cerramiento;
    }

    public void setCerramiento(String cerramiento) {
        this.cerramiento = cerramiento;
    }

    public int getEstatusVivienda() {
        return estatusVivienda;
    }

    public void setEstatusVivienda(int estatusVivienda) {
        this.estatusVivienda = estatusVivienda;
    }

    public String getEstatusViviendaOtros() {
        return estatusViviendaOtros;
    }

    public void setEstatusViviendaOtros(String estatusViviendaOtros) {
        this.estatusViviendaOtros = estatusViviendaOtros;
    }

    public String getEnfermedadCatastrofica() {
        return enfermedadCatastrofica;
    }

    public void setEnfermedadCatastrofica(String enfermedadCatastrofica) {
        this.enfermedadCatastrofica = enfermedadCatastrofica;
    }

    public String getDescripcionEnfermedad() {
        return descripcionEnfermedad;
    }

    public void setDescripcionEnfermedad(String descripcionEnfermedad) {
        this.descripcionEnfermedad = descripcionEnfermedad;
    }

    public String getExamenComportamental() {
        return examenComportamental;
    }

    public void setExamenComportamental(String examenComportamental) {
        this.examenComportamental = examenComportamental;
    }

    public String getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(String examenFisico) {
        this.examenFisico = examenFisico;
    }

    public String getCertificadoVacunacion() {
        return certificadoVacunacion;
    }

    public void setCertificadoVacunacion(String certificadoVacunacion) {
        this.certificadoVacunacion = certificadoVacunacion;
    }

    public String getCertificadoEsterilizacion() {
        return certificadoEsterilizacion;
    }

    public void setCertificadoEsterilizacion(String certificadoEsterilizacion) {
        this.certificadoEsterilizacion = certificadoEsterilizacion;
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
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

    public RemCatalogo getEstado() {
        return estado;
    }

    public void setEstado(RemCatalogo estado) {
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

    public RemArchivos getCertificadoEsterilizacionArchivo() {
        return certificadoEsterilizacionArchivo;
    }

    public void setCertificadoEsterilizacionArchivo(RemArchivos certificadoEsterilizacionArchivo) {
        this.certificadoEsterilizacionArchivo = certificadoEsterilizacionArchivo;
    }



    public RemCatalogo getRaza() {
        return raza;
    }

    public void setRaza(RemCatalogo raza) {
        this.raza = raza;
    }

    public RemArchivos getIdentificacionFotografica1() {
        return identificacionFotografica1;
    }

    public void setIdentificacionFotografica1(RemArchivos identificacionFotografica1) {
        this.identificacionFotografica1 = identificacionFotografica1;
    }

    public RemArchivos getIdentificacionFotografica2() {
        return identificacionFotografica2;
    }

    public void setIdentificacionFotografica2(RemArchivos identificacionFotografica2) {
        this.identificacionFotografica2 = identificacionFotografica2;
    }

    public RemCatalogo getEstadoReproductivo() {
        return estadoReproductivo;
    }

    public void setEstadoReproductivo(RemCatalogo estadoReproductivo) {
        this.estadoReproductivo = estadoReproductivo;
    }

    public RemTutorMascota getTutorId() {
        return tutorId;
    }

    public void setTutorId(RemTutorMascota tutorId) {
        this.tutorId = tutorId;
    }

    public RemCatalogo getEspecie() {
        return especie;
    }

    public void setEspecie(RemCatalogo especie) {
        this.especie = especie;
    }

    public RemArchivos getIdentificacionVisible() {
        return identificacionVisible;
    }

    public void setIdentificacionVisible(RemArchivos identificacionVisible) {
        this.identificacionVisible = identificacionVisible;
    }

    public RemArchivos getCertificadoVacunacionArchivo() {
        return certificadoVacunacionArchivo;
    }

    public void setCertificadoVacunacionArchivo(RemArchivos certificadoVacunacionArchivo) {
        this.certificadoVacunacionArchivo = certificadoVacunacionArchivo;
    }

    public RemCatalogo getMotivoFallecimiento() {
        return motivoFallecimiento;
    }

    public void setMotivoFallecimiento(RemCatalogo motivoFallecimiento) {
        this.motivoFallecimiento = motivoFallecimiento;
    }

    public RemCatalogo getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(RemCatalogo permanencia) {
        this.permanencia = permanencia;
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

    public RemCatalogo getParroquia() {
        return parroquia;
    }

    public void setParroquia(RemCatalogo parroquia) {
        this.parroquia = parroquia;
    }

    public RemCatalogo getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(RemCatalogo tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public RemMicrochipMascota getMicrochipMascotaId() {
        return microchipMascotaId;
    }

    public void setMicrochipMascotaId(RemMicrochipMascota microchipMascotaId) {
        this.microchipMascotaId = microchipMascotaId;
    }

    public RemCatalogo getPruebaComportamiento() {
        return pruebaComportamiento;
    }

    public void setPruebaComportamiento(RemCatalogo pruebaComportamiento) {
        this.pruebaComportamiento = pruebaComportamiento;
    }

    public RemCatalogo getEstadoTutoria() {
        return estadoTutoria;
    }

    public void setEstadoTutoria(RemCatalogo estadoTutoria) {
        this.estadoTutoria = estadoTutoria;
    }

    public RemCatalogo getSexo() {
        return sexo;
    }

    public void setSexo(RemCatalogo sexo) {
        this.sexo = sexo;
    }

    public Set<RemTipoAnimalTutor> getRemTipoAnimalTutorSet() {
        return remTipoAnimalTutorSet;
    }

    public void setRemTipoAnimalTutorSet(Set<RemTipoAnimalTutor> remTipoAnimalTutorSet) {
        this.remTipoAnimalTutorSet = remTipoAnimalTutorSet;
    }

    public Set<RemTutoresComunitarios> getRemTutoresComunitariosSet() {
        return remTutoresComunitariosSet;
    }

    public void setRemTutoresComunitariosSet(Set<RemTutoresComunitarios> remTutoresComunitariosSet) {
        this.remTutoresComunitariosSet = remTutoresComunitariosSet;
    }

    public RemArchivos getExamenComportamentalArchivo() {
        return examenComportamentalArchivo;
    }

    public void setExamenComportamentalArchivo(RemArchivos examenComportamentalArchivo) {
        this.examenComportamentalArchivo = examenComportamentalArchivo;
    }

    @Override
    public String toString() {
        return "RemAnimalTutor{" + "animalTutorId=" + animalTutorId + ", secuencialTmp=" + secuencialTmp + ", secuencialFinal=" + secuencialFinal + ", mt2Vivienda=" + mt2Vivienda + ", mt2Permanencia=" + mt2Permanencia + ", fechaFallecimiento=" + fechaFallecimiento + ", cerramiento=" + cerramiento + ", fechaModificacion=" + fechaModificacion + ", comunitario=" + comunitario + ", procedenciaAnimal=" + procedenciaAnimal + ", observacionMicrochip=" + observacionMicrochip + ", nombreAnimal=" + nombreAnimal + ", fechaNacimiento=" + fechaNacimiento + ", senialesParticulares=" + senialesParticulares + ", permanenciaOtros=" + permanenciaOtros + ", barrio=" + barrio + ", callePrincipal=" + callePrincipal + ", calleNumero=" + calleNumero + ", calleSecundaria=" + calleSecundaria + ", calleReferencia1=" + calleReferencia1 + ", calleReferencia2=" + calleReferencia2 + ", estatusVivienda=" + estatusVivienda + ", estatusViviendaOtros=" + estatusViviendaOtros + ", enfermedadCatastrofica=" + enfermedadCatastrofica + ", descripcionEnfermedad=" + descripcionEnfermedad + ", examenComportamental=" + examenComportamental + ", examenFisico=" + examenFisico + ", certificadoVacunacion=" + certificadoVacunacion + ", certificadoEsterilizacion=" + certificadoEsterilizacion + ", acuerdoResponsabilidad=" + acuerdoResponsabilidad + ", fechaRegistro=" + fechaRegistro + ", usuarioCreacion=" + usuarioCreacion + ", terminalCreacion=" + terminalCreacion + ", fechaCreacion=" + fechaCreacion + ", usuarioModificacion=" + usuarioModificacion + ", terminalModificacion=" + terminalModificacion + ", remTipoAnimalTutorSet=" + remTipoAnimalTutorSet + ", remTutoresComunitariosSet=" + remTutoresComunitariosSet + ", certificadoEsterilizacionArchivo=" + certificadoEsterilizacionArchivo + ", raza=" + raza + ", identificacionFotografica1=" + identificacionFotografica1 + ", identificacionFotografica2=" + identificacionFotografica2 + ", estadoReproductivo=" + estadoReproductivo + ", tutorId=" + tutorId + ", especie=" + especie + ", identificacionVisible=" + identificacionVisible + ", certificadoVacunacionArchivo=" + certificadoVacunacionArchivo + ", motivoFallecimiento=" + motivoFallecimiento + ", permanencia=" + permanencia + ", colorPredominante=" + colorPredominante + ", colorSecundario=" + colorSecundario + ", parroquia=" + parroquia + ", tipoVivienda=" + tipoVivienda + ", microchipMascotaId=" + microchipMascotaId + ", pruebaComportamiento=" + pruebaComportamiento + ", estadoTutoria=" + estadoTutoria + ", sexo=" + sexo + ", examenComportamentalArchivo=" + examenComportamentalArchivo + ", estado=" + estado + '}';
    }

}
