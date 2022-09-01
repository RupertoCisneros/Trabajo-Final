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
 * @author oportero
 */
@Data

@ToString
@JsonIgnoreProperties( ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoConsultaRegistros {
    
    private Long subregistro; 
    private Long registroProfesionalId; 
    private String nroRegistro;    
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private String estado;
    private String denominacion;

    public DtoConsultaRegistros() {
    }

    public DtoConsultaRegistros(Long registroProfesionalId, String nroRegistro, String descripcion, Date fechaCreacion, String estado) {
        this.registroProfesionalId = registroProfesionalId;
        this.nroRegistro = nroRegistro;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    //Consulta de datos de Registros Profesionales: obtenerRegistrosCiudadano
    public DtoConsultaRegistros(Long subregistro, Long registroProfesionalId, String nroRegistro, String descripcion, Date fechaCreacion, String estado, String denominacion) {
        this.subregistro = subregistro;
        this.registroProfesionalId = registroProfesionalId;
        this.nroRegistro = nroRegistro;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.denominacion = denominacion;
    }
    
    

}
