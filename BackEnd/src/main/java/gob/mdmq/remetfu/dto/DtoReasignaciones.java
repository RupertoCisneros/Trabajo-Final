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
public class DtoReasignaciones {
    
    private Long registroProfesionalId;    
    private String nroRegistro;
    private String analistaAntes;
    private String analistaDespues;
    private String motivoReasignacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReasignacion;
    private String nombreUsuarioRegistro;    
    private String nombreUsuarioReasigna;    

    public DtoReasignaciones() {
    }

    public DtoReasignaciones(Long registroProfesionalId, String nroRegistro, String analistaAntes, String analistaDespues, String motivoReasignacion, Date fechaReasignacion, String nombreUsuarioRegistro, String nombreUsuarioReasigna) {
        this.registroProfesionalId = registroProfesionalId;
        this.nroRegistro = nroRegistro;
        this.analistaAntes = analistaAntes;
        this.analistaDespues = analistaDespues;
        this.motivoReasignacion = motivoReasignacion;
        this.fechaReasignacion = fechaReasignacion;
        this.nombreUsuarioRegistro = nombreUsuarioRegistro;
        this.nombreUsuarioReasigna = nombreUsuarioReasigna;
    }

    
}
