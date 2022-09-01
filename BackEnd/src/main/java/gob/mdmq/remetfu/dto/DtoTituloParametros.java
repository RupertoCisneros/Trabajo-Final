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

/**
 *
 * @author srcisnerosv
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoTituloParametros {

    private String areaTitulo;
    private Date fechaRegistro;
    private String ies;
    private String nivel;
    private String nombreTitulo;
    private String numeroIdentificacion;
    private String numeroRegistro;
    private String subArea;

    public DtoTituloParametros() {
    }

    public DtoTituloParametros(String areaTitulo, Date fechaRegistro, String ies, String nivel, String nombreTitulo, String numeroIdentificacion, String numeroRegistro, String subArea) {
        this.areaTitulo = areaTitulo;
        this.fechaRegistro = fechaRegistro;
        this.ies = ies;
        this.nivel = nivel;
        this.nombreTitulo = nombreTitulo;
        this.numeroIdentificacion = numeroIdentificacion;
        this.numeroRegistro = numeroRegistro;
        this.subArea = subArea;
    }

    

}
