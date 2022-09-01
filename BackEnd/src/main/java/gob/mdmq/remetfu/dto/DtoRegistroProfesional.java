/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import gob.mdmq.remetfu.Entidades.RemAnalisisTramiteRegistroProfesional;
import gob.mdmq.remetfu.Entidades.RemArchivos;
import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author omaldonado
 */
public class DtoRegistroProfesional {

    private Long registroProfesionalId;
    private String visatrabajo;
    private String callePrincipal;
    private String calleNumero;
    private String calleSecundaria;
    private String calleReferencia1;
    private String calleReferencia2;
    private String nombreGremio;
    private Date fechaInactivo;
    private Integer diasInactivo;
    private String usuarioCreacion;
    private String terminalCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private String terminalModificacion;
    private Date fechaModificacion;
    private long secuencialTmp;
    private long secuencialFinal;
    private String barrio;
    private String acuerdoResponsabilidad;
    private String experienciaLaboral;
    private String agremiado;
    private Set<RemMicrochipMascota> remMicrochipMascotaSet;
    private RemArchivos visaTrabajo;
    private RemAnalisisTramiteRegistroProfesional remAnalisisTramiteRegistroProfesional;
    private Long perfilAcademico;
    private Object tituloSENESCYT;
    private RemUsuarios usuarioId;
    private RemSubtipoRegistro subtipoRegistroId;
    private RemCatalogo estado;
    private RemCatalogo parroquia;
    private Object documentoFormacion;
    private Object visaArchivo;
    private Long estadoRegistro;
    private Long registroProfesionalIdActualiza;

    public DtoRegistroProfesional() {
    }

    public DtoRegistroProfesional(Long registroProfesionalId, String visatrabajo, String callePrincipal, String calleNumero, String calleSecundaria, String calleReferencia1, String calleReferencia2, String nombreGremio, Date fechaInactivo, Integer diasInactivo, String usuarioCreacion, String terminalCreacion, Date fechaCreacion, String usuarioModificacion, String terminalModificacion, Date fechaModificacion, long secuencialTmp, long secuencialFinal, String barrio, String acuerdoResponsabilidad, String experienciaLaboral, String agremiado, Set<RemMicrochipMascota> remMicrochipMascotaSet, RemArchivos visaTrabajo, RemAnalisisTramiteRegistroProfesional remAnalisisTramiteRegistroProfesional, Long perfilAcademico, Object tituloSENESCYT, RemUsuarios usuarioId, RemSubtipoRegistro subtipoRegistroId, RemCatalogo estado, RemCatalogo parroquia, Object documentoFormacion, Object visaArchivo, Long estadoRegistro, Long registroProfesionalIdActualiza) {
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
        this.remMicrochipMascotaSet = remMicrochipMascotaSet;
        this.visaTrabajo = visaTrabajo;
        this.remAnalisisTramiteRegistroProfesional = remAnalisisTramiteRegistroProfesional;
        this.perfilAcademico = perfilAcademico;
        this.tituloSENESCYT = tituloSENESCYT;
        this.usuarioId = usuarioId;
        this.subtipoRegistroId = subtipoRegistroId;
        this.estado = estado;
        this.parroquia = parroquia;
        this.documentoFormacion = documentoFormacion;
        this.visaArchivo = visaArchivo;
        this.estadoRegistro = estadoRegistro;
        this.registroProfesionalIdActualiza = registroProfesionalIdActualiza;
    }

    

    public Long getRegistroProfesionalId() {
        return registroProfesionalId;
    }

    public void setRegistroProfesionalId(Long registroProfesionalId) {
        this.registroProfesionalId = registroProfesionalId;
    }

    public String getVisatrabajo() {
        return visatrabajo;
    }

    public void setVisatrabajo(String visatrabajo) {
        this.visatrabajo = visatrabajo;
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

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getAgremiado() {
        return agremiado;
    }

    public void setAgremiado(String agremiado) {
        this.agremiado = agremiado;
    }

    public Set<RemMicrochipMascota> getRemMicrochipMascotaSet() {
        return remMicrochipMascotaSet;
    }

    public void setRemMicrochipMascotaSet(Set<RemMicrochipMascota> remMicrochipMascotaSet) {
        this.remMicrochipMascotaSet = remMicrochipMascotaSet;
    }

    public RemArchivos getVisaTrabajo() {
        return visaTrabajo;
    }

    public void setVisaTrabajo(RemArchivos visaTrabajo) {
        this.visaTrabajo = visaTrabajo;
    }

    public RemAnalisisTramiteRegistroProfesional getRemAnalisisTramiteRegistroProfesional() {
        return remAnalisisTramiteRegistroProfesional;
    }

    public void setRemAnalisisTramiteRegistroProfesional(RemAnalisisTramiteRegistroProfesional remAnalisisTramiteRegistroProfesional) {
        this.remAnalisisTramiteRegistroProfesional = remAnalisisTramiteRegistroProfesional;
    }

    public Long getPerfilAcademico() {
        return perfilAcademico;
    }

    public void setPerfilAcademico(Long perfilAcademico) {
        this.perfilAcademico = perfilAcademico;
    }

    public Object getTituloSENESCYT() {
        return tituloSENESCYT;
    }

    public void setTituloSENESCYT(Object tituloSENESCYT) {
        this.tituloSENESCYT = tituloSENESCYT;
    }

    public RemUsuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(RemUsuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    public RemSubtipoRegistro getSubtipoRegistroId() {
        return subtipoRegistroId;
    }

    public void setSubtipoRegistroId(RemSubtipoRegistro subtipoRegistroId) {
        this.subtipoRegistroId = subtipoRegistroId;
    }

    public RemCatalogo getEstado() {
        return estado;
    }

    public void setEstado(RemCatalogo estado) {
        this.estado = estado;
    }

    public RemCatalogo getParroquia() {
        return parroquia;
    }

    public void setParroquia(RemCatalogo parroquia) {
        this.parroquia = parroquia;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
    }

    public Object getDocumentoFormacion() {
        return documentoFormacion;
    }

    public void setDocumentoFormacion(Object documentoFormacion) {
        this.documentoFormacion = documentoFormacion;
    }

    public Object getVisaArchivo() {
        return visaArchivo;
    }

    public void setVisaArchivo(Object visaArchivo) {
        this.visaArchivo = visaArchivo;
    }


 
    public Long getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(Long estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Long getRegistroProfesionalIdActualiza() {
        return registroProfesionalIdActualiza;
    }

    public void setRegistroProfesionalIdActualiza(Long registroProfesionalIdActualiza) {
        this.registroProfesionalIdActualiza = registroProfesionalIdActualiza;
    }

}
