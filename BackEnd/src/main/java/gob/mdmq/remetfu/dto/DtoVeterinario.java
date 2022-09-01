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
public class DtoVeterinario {

    private String denominacion;
    private String mail;
    private String direccion;
    private String telefono;
    private String movil;
    private String aceptacionMedios;
    private String estado;
    private String nacionalidadDesc;
    private String nombreTitulo;
    private String nroRegistro;
    private Long secuencialFinal;

    public DtoVeterinario() {
    }

    public DtoVeterinario(String denominacion, String mail, String direccion, String telefono, String movil, String aceptacionMedios, String estado, String nacionalidadDesc, String nombreTitulo, String nroRegistro, Long secuencialFinal) {
        this.denominacion = denominacion;
        this.mail = mail;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.aceptacionMedios = aceptacionMedios;
        this.estado = estado;
        this.nacionalidadDesc = nacionalidadDesc;
        this.nombreTitulo = nombreTitulo;
        this.nroRegistro = nroRegistro;
        this.secuencialFinal = secuencialFinal;
    }

   

}
