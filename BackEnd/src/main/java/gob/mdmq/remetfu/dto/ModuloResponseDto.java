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
@JsonIgnoreProperties( ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ModuloResponseDto {
    
    private Long MODULO_ID;
    private String NOMBRE;
  

    public ModuloResponseDto() {
    }
      
    public ModuloResponseDto(Long MODULO_ID, String NOMBRE) {
        this.MODULO_ID = MODULO_ID;
        this.NOMBRE = NOMBRE;
        
    }
 
    
}