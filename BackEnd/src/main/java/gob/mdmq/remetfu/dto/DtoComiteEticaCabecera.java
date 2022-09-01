/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class DtoComiteEticaCabecera {

    private Long comiteEticaCabId;
    private String comiteEticaCabIdC;
    private String nombreInstitucion;
    private String facultadInvestigacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    private String estado;

    public DtoComiteEticaCabecera() {
    }

    public DtoComiteEticaCabecera(Long comiteEticaCabId, String comiteEticaCabIdC, String nombreInstitucion, String facultadInvestigacion, Date fechaRegistro, String estado) {
        this.comiteEticaCabId = comiteEticaCabId;
        this.comiteEticaCabIdC = comiteEticaCabIdC;
        this.nombreInstitucion = nombreInstitucion;
        this.facultadInvestigacion = facultadInvestigacion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    
}
