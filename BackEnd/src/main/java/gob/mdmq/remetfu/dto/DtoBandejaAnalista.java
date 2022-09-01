/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author srcisnerosv
 */
@Data

@ToString
@JsonIgnoreProperties( ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoBandejaAnalista {

    private Long registroProfesionalId;    
    private String nroRegistro;
    private String descripcion;
    private String nombre;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsigna;
    private String estadoTramite;
    private String denominacion;
    private String nroIdentificacion;
    private Long nroRegistrosPendientes;
    private Long analistaId;
    private Long usuarioId;
    private String nombreAnalista;

    public DtoBandejaAnalista() {
    }

    public DtoBandejaAnalista(Long registroProfesionalId, String nombre, Date fechaAsigna, String estadoTramite) {
        this.registroProfesionalId = registroProfesionalId;
        this.nombre = nombre;
        this.fechaAsigna = fechaAsigna;
        this.estadoTramite = estadoTramite;
    }        

    public DtoBandejaAnalista(Long registroProfesionalId, String descripcion, String nombre, Date fechaAsigna, String estadoTramite) {
        this.registroProfesionalId = registroProfesionalId;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fechaAsigna = fechaAsigna;
        this.estadoTramite = estadoTramite;
    }

    //Para conulta de obtenerBandejaporAnalista
    public DtoBandejaAnalista(Long registroProfesionalId, String nroRegistro, String descripcion, String nombre, Date fechaAsigna, String estadoTramite, String nombreAnalista, Long analistaId){//, Long nroRegistrosPendientes) {
        this.registroProfesionalId = registroProfesionalId;
        this.nroRegistro = nroRegistro;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fechaAsigna = fechaAsigna;
        this.estadoTramite = estadoTramite;
        this.nombreAnalista= nombreAnalista;
        this.analistaId = analistaId;
    }

    public DtoBandejaAnalista(String denominacion, String nroIdentificacion, Long nroRegistrosPendientes, Long analistaId, Long usuarioId) {
        this.denominacion = denominacion;
        this.nroIdentificacion = nroIdentificacion;
        this.nroRegistrosPendientes = nroRegistrosPendientes;
        this.analistaId = analistaId;
        this.usuarioId = usuarioId;
    }

    public DtoBandejaAnalista(Long registroProfesionalId, String nroRegistro, String descripcion, String nroIdentificacion, String nombre, Date fechaAsigna, String nombreAnalista, String estadoTramite) {
        this.registroProfesionalId = registroProfesionalId;
        this.nroRegistro = nroRegistro;
        this.descripcion = descripcion;
        this.nroIdentificacion = nroIdentificacion;
        this.nombre = nombre;
        this.fechaAsigna = fechaAsigna;
        this.nombreAnalista = nombreAnalista;
        this.estadoTramite = estadoTramite;
    }
    
}
