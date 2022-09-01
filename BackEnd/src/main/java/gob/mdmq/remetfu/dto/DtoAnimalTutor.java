/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gob.mdmq.remetfu.Entidades.RemArchivos;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.Entidades.RemTipoAnimalTutor;
import gob.mdmq.remetfu.Entidades.RemTutorMascota;
import gob.mdmq.remetfu.Entidades.RemTutoresComunitarios;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author oportero
 */
public class DtoAnimalTutor {

    private Long animalTutorId;
    private String nroRegistro;
    private long secuencialTmp;
    private long secuencialFinal;
    private Long tutorId;
    private String denominacionTutor;
    private String nombresTutor;
    private String apellidosTutor;
    private String identificacionTutor;
    private String nacionalidadTutor;
    private String direccionTutor;
    private String movilTutor;
    private String telefonoTutor;
    private String emailTutor;
    private String emailPersonalTutor;    
    private String comunitario;
    private Long estadoTutoria;
    private String estadoTutoriaNombre;
    private Long procedencia;
    private String procedenciaNombre;
    private Long microchipMascotaId;
    private String observacionMicrochip;
    private String nombreAnimal;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    private Long especie;
    private String especieNombre;
    private Long raza;
    private String razaNombre;
    private Long sexo;
    private String sexoNombre;
    private Long estadoReproductivo;
    private String estadoReproductivoNombre;
    private Long coloPredominante;
    private String coloPredominanteNombre;
    private Long coloSecundario;
    private String coloSecundarioNombre;
    private String senialesParticulares;
    private String identificacionFotografica1;
    private String identificacionFotografica2;
    private String identificacionVisible;
    private Long permanencia;
    private String permanenciaNombre;
    private String permanenciaOtros;
    private Long parroquia;
    private String parroquiaNombre;
    private String barrio;
    private String callePrincipal;
    private String calleNumero;
    private String calleSecundaria;
    private String calleReferencia1;
    private String calleReferencia2;
    private Long tipoVivienda;
    private String tipoViviendaNombre;
    private BigDecimal mt2Vivienda;
    private BigDecimal mt2Permanencia;
    private String cerramiento;
    private Long estatusVivienda;
    private String estatusViviendaNombre;
    private String estatusViviendaOtros;
    private String enfermedadCatastrofica;
    private String descripcionEnfermedad;
    private String examenComportamental;
    private Long pruebaComportamiento;
    private String pruebaComportamientoNombre;
    private String examenComportamentalArchivo;
    private String examenFisico;
    private String certificadoVacunacion;
    private String certificadoVacunacionArchivo;
    private String certificadoEsterilizacion;
    private String certificadoEsterilizacionArchivo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFallecimiento;
    private Long motivoFallecimiento;
    private String motivoFallecimientoNombre;
    private String acuerdoResponsabilidad;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    private Long estado;
    private String estadoNombre;
    private Long edadAnimal;

    public DtoAnimalTutor() {
    }

    public DtoAnimalTutor(Long animalTutorId, String nroRegistro, long secuencialTmp, long secuencialFinal, Long tutorId, String denominacionTutor, String nombresTutor, String apellidosTutor, String identificacionTutor, String nacionalidadTutor, String direccionTutor, String movilTutor, String telefonoTutor, String emailTutor, String emailPersonalTutor, String comunitario, Long estadoTutoria, String estadoTutoriaNombre, Long procedencia, String procedenciaNombre, Long microchipMascotaId, String observacionMicrochip, String nombreAnimal, Date fechaNacimiento, Long especie, String especieNombre, Long raza, String razaNombre, Long sexo, String sexoNombre, Long estadoReproductivo, String estadoReproductivoNombre, Long coloPredominante, String coloPredominanteNombre, Long coloSecundario, String coloSecundarioNombre, String senialesParticulares, String identificacionFotografica1, String identificacionFotografica2, String identificacionVisible, Long permanencia, String permanenciaNombre, String permanenciaOtros, Long parroquia, String parroquiaNombre, String barrio, String callePrincipal, String calleNumero, String calleSecundaria, String calleReferencia1, String calleReferencia2, Long tipoVivienda, String tipoViviendaNombre, BigDecimal mt2Vivienda, BigDecimal mt2Permanencia, String cerramiento, Long estatusVivienda, String estatusViviendaNombre, String estatusViviendaOtros, String enfermedadCatastrofica, String descripcionEnfermedad, String examenComportamental, Long pruebaComportamiento, String pruebaComportamientoNombre, String examenComportamentalArchivo, String examenFisico, String certificadoVacunacion, String certificadoVacunacionArchivo, String certificadoEsterilizacion, String certificadoEsterilizacionArchivo, Date fechaFallecimiento, Long motivoFallecimiento, String motivoFallecimientoNombre, String acuerdoResponsabilidad, Date fechaRegistro, Long estado, String estadoNombre, Long edadAnimal) {
        this.animalTutorId = animalTutorId;
        this.nroRegistro = nroRegistro;
        this.secuencialTmp = secuencialTmp;
        this.secuencialFinal = secuencialFinal;
        this.tutorId = tutorId;
        this.denominacionTutor = denominacionTutor;
        this.nombresTutor = nombresTutor;
        this.apellidosTutor = apellidosTutor;
        this.identificacionTutor = identificacionTutor;
        this.nacionalidadTutor = nacionalidadTutor;
        this.direccionTutor = direccionTutor;
        this.movilTutor = movilTutor;
        this.telefonoTutor = telefonoTutor;
        this.emailTutor = emailTutor;
        this.emailPersonalTutor = emailPersonalTutor;
        this.comunitario = comunitario;
        this.estadoTutoria = estadoTutoria;
        this.estadoTutoriaNombre = estadoTutoriaNombre;
        this.procedencia = procedencia;
        this.procedenciaNombre = procedenciaNombre;
        this.microchipMascotaId = microchipMascotaId;
        this.observacionMicrochip = observacionMicrochip;
        this.nombreAnimal = nombreAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.especieNombre = especieNombre;
        this.raza = raza;
        this.razaNombre = razaNombre;
        this.sexo = sexo;
        this.sexoNombre = sexoNombre;
        this.estadoReproductivo = estadoReproductivo;
        this.estadoReproductivoNombre = estadoReproductivoNombre;
        this.coloPredominante = coloPredominante;
        this.coloPredominanteNombre = coloPredominanteNombre;
        this.coloSecundario = coloSecundario;
        this.coloSecundarioNombre = coloSecundarioNombre;
        this.senialesParticulares = senialesParticulares;
        this.identificacionFotografica1 = identificacionFotografica1;
        this.identificacionFotografica2 = identificacionFotografica2;
        this.identificacionVisible = identificacionVisible;
        this.permanencia = permanencia;
        this.permanenciaNombre = permanenciaNombre;
        this.permanenciaOtros = permanenciaOtros;
        this.parroquia = parroquia;
        this.parroquiaNombre = parroquiaNombre;
        this.barrio = barrio;
        this.callePrincipal = callePrincipal;
        this.calleNumero = calleNumero;
        this.calleSecundaria = calleSecundaria;
        this.calleReferencia1 = calleReferencia1;
        this.calleReferencia2 = calleReferencia2;
        this.tipoVivienda = tipoVivienda;
        this.tipoViviendaNombre = tipoViviendaNombre;
        this.mt2Vivienda = mt2Vivienda;
        this.mt2Permanencia = mt2Permanencia;
        this.cerramiento = cerramiento;
        this.estatusVivienda = estatusVivienda;
        this.estatusViviendaNombre = estatusViviendaNombre;
        this.estatusViviendaOtros = estatusViviendaOtros;
        this.enfermedadCatastrofica = enfermedadCatastrofica;
        this.descripcionEnfermedad = descripcionEnfermedad;
        this.examenComportamental = examenComportamental;
        this.pruebaComportamiento = pruebaComportamiento;
        this.pruebaComportamientoNombre = pruebaComportamientoNombre;
        this.examenComportamentalArchivo = examenComportamentalArchivo;
        this.examenFisico = examenFisico;
        this.certificadoVacunacion = certificadoVacunacion;
        this.certificadoVacunacionArchivo = certificadoVacunacionArchivo;
        this.certificadoEsterilizacion = certificadoEsterilizacion;
        this.certificadoEsterilizacionArchivo = certificadoEsterilizacionArchivo;
        this.fechaFallecimiento = fechaFallecimiento;
        this.motivoFallecimiento = motivoFallecimiento;
        this.motivoFallecimientoNombre = motivoFallecimientoNombre;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.estadoNombre = estadoNombre;
        this.edadAnimal = edadAnimal;
    }


    public Long getAnimalTutorId() {
        return animalTutorId;
    }

    public void setAnimalTutorId(Long animalTutorId) {
        this.animalTutorId = animalTutorId;
    }

    public String getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(String nroRegistro) {
        this.nroRegistro = nroRegistro;
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

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public String getDenominacionTutor() {
        return denominacionTutor;
    }

    public void setDenominacionTutor(String denominacionTutor) {
        this.denominacionTutor = denominacionTutor;
    }

    public String getNombresTutor() {
        return nombresTutor;
    }

    public void setNombresTutor(String nombresTutor) {
        this.nombresTutor = nombresTutor;
    }

    public String getApellidosTutor() {
        return apellidosTutor;
    }

    public void setApellidosTutor(String apellidosTutor) {
        this.apellidosTutor = apellidosTutor;
    }

    public String getIdentificacionTutor() {
        return identificacionTutor;
    }

    public void setIdentificacionTutor(String identificacionTutor) {
        this.identificacionTutor = identificacionTutor;
    }

    public String getNacionalidadTutor() {
        return nacionalidadTutor;
    }

    public void setNacionalidadTutor(String nacionalidadTutor) {
        this.nacionalidadTutor = nacionalidadTutor;
    }

    public String getDireccionTutor() {
        return direccionTutor;
    }

    public void setDireccionTutor(String direccionTutor) {
        this.direccionTutor = direccionTutor;
    }

    public String getMovilTutor() {
        return movilTutor;
    }

    public void setMovilTutor(String movilTutor) {
        this.movilTutor = movilTutor;
    }

    public String getTelefonoTutor() {
        return telefonoTutor;
    }

    public void setTelefonoTutor(String telefonoTutor) {
        this.telefonoTutor = telefonoTutor;
    }

    public String getEmailTutor() {
        return emailTutor;
    }

    public void setEmailTutor(String emailTutor) {
        this.emailTutor = emailTutor;
    }

    public String getEmailPersonalTutor() {
        return emailPersonalTutor;
    }

    public void setEmailPersonalTutor(String emailPersonalTutor) {
        this.emailPersonalTutor = emailPersonalTutor;
    }

    public String getComunitario() {
        return comunitario;
    }

    public void setComunitario(String comunitario) {
        this.comunitario = comunitario;
    }

    public Long getEstadoTutoria() {
        return estadoTutoria;
    }

    public void setEstadoTutoria(Long estadoTutoria) {
        this.estadoTutoria = estadoTutoria;
    }

    public String getEstadoTutoriaNombre() {
        return estadoTutoriaNombre;
    }

    public void setEstadoTutoriaNombre(String estadoTutoriaNombre) {
        this.estadoTutoriaNombre = estadoTutoriaNombre;
    }

    public Long getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Long procedencia) {
        this.procedencia = procedencia;
    }

    public String getProcedenciaNombre() {
        return procedenciaNombre;
    }

    public void setProcedenciaNombre(String procedenciaNombre) {
        this.procedenciaNombre = procedenciaNombre;
    }

    public Long getMicrochipMascotaId() {
        return microchipMascotaId;
    }

    public void setMicrochipMascotaId(Long microchipMascotaId) {
        this.microchipMascotaId = microchipMascotaId;
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

    public Long getEspecie() {
        return especie;
    }

    public void setEspecie(Long especie) {
        this.especie = especie;
    }

    public String getEspecieNombre() {
        return especieNombre;
    }

    public void setEspecieNombre(String especieNombre) {
        this.especieNombre = especieNombre;
    }

    public Long getRaza() {
        return raza;
    }

    public void setRaza(Long raza) {
        this.raza = raza;
    }

    public String getRazaNombre() {
        return razaNombre;
    }

    public void setRazaNombre(String razaNombre) {
        this.razaNombre = razaNombre;
    }

    public Long getSexo() {
        return sexo;
    }

    public void setSexo(Long sexo) {
        this.sexo = sexo;
    }

    public String getSexoNombre() {
        return sexoNombre;
    }

    public void setSexoNombre(String sexoNombre) {
        this.sexoNombre = sexoNombre;
    }

    public Long getEstadoReproductivo() {
        return estadoReproductivo;
    }

    public void setEstadoReproductivo(Long estadoReproductivo) {
        this.estadoReproductivo = estadoReproductivo;
    }

    public String getEstadoReproductivoNombre() {
        return estadoReproductivoNombre;
    }

    public void setEstadoReproductivoNombre(String estadoReproductivoNombre) {
        this.estadoReproductivoNombre = estadoReproductivoNombre;
    }

    public Long getColoPredominante() {
        return coloPredominante;
    }

    public void setColoPredominante(Long coloPredominante) {
        this.coloPredominante = coloPredominante;
    }

    public String getColoPredominanteNombre() {
        return coloPredominanteNombre;
    }

    public void setColoPredominanteNombre(String coloPredominanteNombre) {
        this.coloPredominanteNombre = coloPredominanteNombre;
    }

    public Long getColoSecundario() {
        return coloSecundario;
    }

    public void setColoSecundario(Long coloSecundario) {
        this.coloSecundario = coloSecundario;
    }

    public String getColoSecundarioNombre() {
        return coloSecundarioNombre;
    }

    public void setColoSecundarioNombre(String coloSecundarioNombre) {
        this.coloSecundarioNombre = coloSecundarioNombre;
    }

    public String getSenialesParticulares() {
        return senialesParticulares;
    }

    public void setSenialesParticulares(String senialesParticulares) {
        this.senialesParticulares = senialesParticulares;
    }

    public String getIdentificacionFotografica1() {
        return identificacionFotografica1;
    }

    public void setIdentificacionFotografica1(String identificacionFotografica1) {
        this.identificacionFotografica1 = identificacionFotografica1;
    }

    public String getIdentificacionFotografica2() {
        return identificacionFotografica2;
    }

    public void setIdentificacionFotografica2(String identificacionFotografica2) {
        this.identificacionFotografica2 = identificacionFotografica2;
    }

    public String getIdentificacionVisible() {
        return identificacionVisible;
    }

    public void setIdentificacionVisible(String identificacionVisible) {
        this.identificacionVisible = identificacionVisible;
    }

    public Long getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(Long permanencia) {
        this.permanencia = permanencia;
    }

    public String getPermanenciaNombre() {
        return permanenciaNombre;
    }

    public void setPermanenciaNombre(String permanenciaNombre) {
        this.permanenciaNombre = permanenciaNombre;
    }

    public String getPermanenciaOtros() {
        return permanenciaOtros;
    }

    public void setPermanenciaOtros(String permanenciaOtros) {
        this.permanenciaOtros = permanenciaOtros;
    }

    public Long getParroquia() {
        return parroquia;
    }

    public void setParroquia(Long parroquia) {
        this.parroquia = parroquia;
    }

    public String getParroquiaNombre() {
        return parroquiaNombre;
    }

    public void setParroquiaNombre(String parroquiaNombre) {
        this.parroquiaNombre = parroquiaNombre;
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

    public Long getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(Long tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getTipoViviendaNombre() {
        return tipoViviendaNombre;
    }

    public void setTipoViviendaNombre(String tipoViviendaNombre) {
        this.tipoViviendaNombre = tipoViviendaNombre;
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

    public Long getEstatusVivienda() {
        return estatusVivienda;
    }

    public void setEstatusVivienda(Long estatusVivienda) {
        this.estatusVivienda = estatusVivienda;
    }

    public String getEstatusViviendaNombre() {
        return estatusViviendaNombre;
    }

    public void setEstatusViviendaNombre(String estatusViviendaNombre) {
        this.estatusViviendaNombre = estatusViviendaNombre;
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

    public Long getPruebaComportamiento() {
        return pruebaComportamiento;
    }

    public void setPruebaComportamiento(Long pruebaComportamiento) {
        this.pruebaComportamiento = pruebaComportamiento;
    }

    public String getPruebaComportamientoNombre() {
        return pruebaComportamientoNombre;
    }

    public void setPruebaComportamientoNombre(String pruebaComportamientoNombre) {
        this.pruebaComportamientoNombre = pruebaComportamientoNombre;
    }

    public String getExamenComportamentalArchivo() {
        return examenComportamentalArchivo;
    }

    public void setExamenComportamentalArchivo(String examenComportamentalArchivo) {
        this.examenComportamentalArchivo = examenComportamentalArchivo;
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

    public String getCertificadoVacunacionArchivo() {
        return certificadoVacunacionArchivo;
    }

    public void setCertificadoVacunacionArchivo(String certificadoVacunacionArchivo) {
        this.certificadoVacunacionArchivo = certificadoVacunacionArchivo;
    }

    public String getCertificadoEsterilizacion() {
        return certificadoEsterilizacion;
    }

    public void setCertificadoEsterilizacion(String certificadoEsterilizacion) {
        this.certificadoEsterilizacion = certificadoEsterilizacion;
    }

    public String getCertificadoEsterilizacionArchivo() {
        return certificadoEsterilizacionArchivo;
    }

    public void setCertificadoEsterilizacionArchivo(String certificadoEsterilizacionArchivo) {
        this.certificadoEsterilizacionArchivo = certificadoEsterilizacionArchivo;
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public Long getMotivoFallecimiento() {
        return motivoFallecimiento;
    }

    public void setMotivoFallecimiento(Long motivoFallecimiento) {
        this.motivoFallecimiento = motivoFallecimiento;
    }

    public String getMotivoFallecimientoNombre() {
        return motivoFallecimientoNombre;
    }

    public void setMotivoFallecimientoNombre(String motivoFallecimientoNombre) {
        this.motivoFallecimientoNombre = motivoFallecimientoNombre;
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

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public Long getEdadAnimal() {
        return edadAnimal;
    }

    public void setEdadAnimal(Long edadAnimal) {
        this.edadAnimal = edadAnimal;
    }
        
}
