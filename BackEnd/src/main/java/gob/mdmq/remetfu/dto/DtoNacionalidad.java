/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author srcisnerosv
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoNacionalidad {

    private Long idNacionalidad;
    private String nombreNacionalidad;

    public DtoNacionalidad() {
    }

    public DtoNacionalidad(Long idNacionalidad, String nombreNacionalidad) {
        this.idNacionalidad = idNacionalidad;
        this.nombreNacionalidad = nombreNacionalidad;
    }
    
    
    
    

}
