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
public class DtoArchivo {

    private String nombre;
    private String contenido;
    private String observacion;
    private DtoDatosAuditoria datosAuditoria;

    public DtoArchivo() {
    };

    public DtoArchivo(String nombre, String contenido, String observacion, DtoDatosAuditoria datosAuditoria) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.observacion = observacion;
        this.datosAuditoria = datosAuditoria;
    }

}
