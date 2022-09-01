/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class DtoDatosModificacion {

    private String usuarioModificacion;
    private String terminalModificacion;
    private Date fechaModificacion;

    public DtoDatosModificacion(String usuarioModificacion, String direccionIpModificacion, Date fechaModificacion) {
        this.usuarioModificacion = usuarioModificacion;
        this.terminalModificacion = direccionIpModificacion;
        this.fechaModificacion = fechaModificacion;
    }
}
