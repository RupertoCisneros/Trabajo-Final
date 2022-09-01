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
public class DtoConsultaComite {
    private Long comiteEticaCabId;
    private String comiteEticaCabIdC;
    private String nombreInstitucion;
    private String facultadInvestigacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    private String estadoCabecera;
    
    private Long comiteEticaDetId;
    private String identificacion;
    private String nombres;
    private String numeroSenecyt;
    private String correo;
    private String telefono;
    private String estadoDetalle;
    private String cargo;  
    private String cargoDescripcion;  

    public DtoConsultaComite() {
    }

    public DtoConsultaComite(Long comiteEticaCabId, String comiteEticaCabIdC, String nombreInstitucion, String facultadInvestigacion, Date fechaRegistro, Long comiteEticaDetId, String identificacion, String nombres, String numeroSenecyt, String correo, String telefono, String cargo, String cargoDescripcion) {
        this.comiteEticaCabId = comiteEticaCabId;
        this.comiteEticaCabIdC = comiteEticaCabIdC;
        this.nombreInstitucion = nombreInstitucion;
        this.facultadInvestigacion = facultadInvestigacion;
        this.fechaRegistro = fechaRegistro;
        this.comiteEticaDetId = comiteEticaDetId;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.numeroSenecyt = numeroSenecyt;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
        this.cargoDescripcion = cargoDescripcion;
    }
    
}
