/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigInteger;
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
public class DtoAsignacionAnalista {

    private String nroIdentificacion;
    private String denominacion;
    private Long analistaId;
    private BigInteger nroTramitesMes;
    private Long analsisTramiteRegistroProfesionalId;
    
    
    public DtoAsignacionAnalista() {
    }

    public DtoAsignacionAnalista(Long analistaId, BigInteger nroTramitesMes, Long analsisTramiteRegistroProfesionalId) {
        this.analistaId = analistaId;
        this.nroTramitesMes = nroTramitesMes;
        this.analsisTramiteRegistroProfesionalId = analsisTramiteRegistroProfesionalId;
    }

    public DtoAsignacionAnalista(String nroIdentificacion, String denominacion, Long analsisTramiteRegistroProfesionalId) {
        this.nroIdentificacion = nroIdentificacion;
        this.denominacion = denominacion;
        this.analsisTramiteRegistroProfesionalId = analsisTramiteRegistroProfesionalId;
    }

}
