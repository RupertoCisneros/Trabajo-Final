/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.ToString;

/**
 *
 * @author omaldonado
 */


@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoMenuPerfil {

    private String nombre;
    private List<DtoHijos> hijos;

    public DtoMenuPerfil() {
    }

    public DtoMenuPerfil( String nombre, List<DtoHijos> hijos) {
        
        this.nombre = nombre;
        this.hijos = hijos;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DtoHijos> getHijos() {
        return hijos;
    }

    public void setHijos(List<DtoHijos> hijos) {
        this.hijos = hijos;
    }

   

    
}
