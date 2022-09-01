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
@JsonIgnoreProperties( ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)    
public class DtoDatosActualizarAnalista {

    private Long registroProfesionalId;    
    private Long analistaAntes;
    private Long analistaDespues;
    private String cedulaUsuarioReasignacion;
    private String motivoCambio;
    private String equipoReasignacion;

    public DtoDatosActualizarAnalista() {
    }

    public DtoDatosActualizarAnalista(Long registroProfesionalId, Long analistaAntes, Long analistaDespues, String cedulaUsuarioReasignacion, String motivoCambio, String equipoReasignacion) {
        this.registroProfesionalId = registroProfesionalId;
        this.analistaAntes = analistaAntes;
        this.analistaDespues = analistaDespues;
        this.cedulaUsuarioReasignacion = cedulaUsuarioReasignacion;
        this.motivoCambio = motivoCambio;
        this.equipoReasignacion = equipoReasignacion;
    }

}
