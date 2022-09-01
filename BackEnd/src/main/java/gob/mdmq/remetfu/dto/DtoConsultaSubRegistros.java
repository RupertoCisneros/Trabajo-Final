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
public class DtoConsultaSubRegistros {

    private Long registroProfesionalId; 
    private String nroRegistro;    
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private String estado;
    
}
