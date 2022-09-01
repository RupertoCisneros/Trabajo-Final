/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
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
public class DtoTituloUniversitario {
    
    
    private String id;
    private List<DtoTituloParametros> listParametros;
    

    public DtoTituloUniversitario() {
    }

    public DtoTituloUniversitario(String id, List<DtoTituloParametros> listParametros) {
        this.id = id;
        this.listParametros = listParametros;
    }

        
    
}
