/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author omaldonado
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoUsuarioKeyCloack implements  Serializable{

    private String id;
    private String username;

    public DtoUsuarioKeyCloack() {
    }

    public DtoUsuarioKeyCloack(String id, String username) {
        this.id = id;
        this.username = username;
    }
    
    

}
