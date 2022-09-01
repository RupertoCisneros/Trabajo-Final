/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto.fileserver;

/**
 *
 * @author oportero
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoSistemaRequest {

    private String nombre;
    private String nombreProyecto;
    private DtoDatosAuditoria datosAuditoria;

    public DtoSistemaRequest() {
    }

    public DtoSistemaRequest(String nombre, String nombreProyecto, DtoDatosAuditoria datosAuditoria) {
        this.nombre = nombre;
        this.nombreProyecto = nombreProyecto;
        this.datosAuditoria = datosAuditoria;
    }

}

