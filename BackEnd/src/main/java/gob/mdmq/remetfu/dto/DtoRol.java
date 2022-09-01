/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

/**
 *
 * @author omaldonado
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoRol {

    private String id;
    private String name;
    private String description;
    private boolean composite;
    private boolean clientRole;
    private String containerId;

    public DtoRol() {
    };

    public DtoRol(String id, String name, String description, boolean composite, boolean clientRole, String containerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.composite = composite;
        this.clientRole = clientRole;
        this.containerId = containerId;
    }

}