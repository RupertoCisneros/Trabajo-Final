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
public class DtoTutorMascota {
    private Long tutor_id;
    private Long usuario_id;
    private String direccion;
    private String estado;
    private String denominacion;
    private String email;
    private String telefono;
    private String movil;

    public DtoTutorMascota() {
    }

    public DtoTutorMascota(Long tutor_id, Long usuario_id, String direccion, String estado, String denominacion, String email, String telefono, String movil) {
        this.tutor_id = tutor_id;
        this.usuario_id = usuario_id;
        this.direccion = direccion;
        this.estado = estado;
        this.denominacion = denominacion;
        this.email = email;
        this.telefono = telefono;
        this.movil = movil;
    }
    
    
    
    
}
