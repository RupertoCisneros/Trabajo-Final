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
public class DtoTipoCatalogo {

    private Long tipoCatalogoId;
    private String nombre;
    private String estado;

    public DtoTipoCatalogo() {
    }

    public DtoTipoCatalogo(Long tipoCatalogoId, String nombre, String estado) {
        this.tipoCatalogoId = tipoCatalogoId;
        this.nombre = nombre;
        this.estado = estado;
    }

}
