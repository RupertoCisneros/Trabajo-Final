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
 * @author oportero
 */
@Data

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class DtoDatosWSPersonas {

    private String cim;
    private String nombres;
    private String apellidos;
    private String denominacion;
    private String identificacion;
    private String tipoIdentificacion;
    private String mail;
    private String celular;
    private String telefono;

    public DtoDatosWSPersonas() {
    }

    public DtoDatosWSPersonas(String cim, String nombres, String apellidos, String denominacion, String identificacion, String tipoIdentificacion, String mail, String celular, String telefono) {
        this.cim = cim;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.denominacion = denominacion;
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.mail = mail;
        this.celular = celular;
        this.telefono = telefono;
    }
    
    
    
}
