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
public class DtoComiteEticaDetalle {

    private Long comiteEticaDetId;
    private String identificacion;
    private String nombres;
    private String numeroSenecyt;
    private String correo;
    private String telefono;
    private String estado;
    private String cargo;

    public DtoComiteEticaDetalle() {
    }

    public DtoComiteEticaDetalle(Long comiteEticaDetId, String identificacion, String nombres, String numeroSenecyt, String correo, String telefono, String estado, String cargo) {
        this.comiteEticaDetId = comiteEticaDetId;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.numeroSenecyt = numeroSenecyt;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
        this.cargo = cargo;
    }

    
}
