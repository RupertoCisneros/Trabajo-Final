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
 * @author ebustillos
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoUsuarioAnalista {

    private Long usuarioId;
    private String nroIdentificacion;
    private String denominacion;
    private String estado;

    public DtoUsuarioAnalista() {
    }

    public DtoUsuarioAnalista(Long usuarioId, String nroIdentificacion, String denominacion, String estado) {
        this.usuarioId = usuarioId;
        this.nroIdentificacion = nroIdentificacion;
        this.denominacion = denominacion;
        this.estado = estado;
    }
}
