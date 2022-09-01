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
 * @author omaldonado
 */
@Data
@ToString
@JsonIgnoreProperties( ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MenuDto {
    
    private Long PADRE;
    private Long MENU_ID;
    
    private String NOMBRE;

    public MenuDto() {
    }

    public MenuDto(Long PADRE, Long MENU_ID, String NOMBRE) {
        this.PADRE = PADRE;
        this.MENU_ID = MENU_ID;
        this.NOMBRE = NOMBRE;
    }

}
