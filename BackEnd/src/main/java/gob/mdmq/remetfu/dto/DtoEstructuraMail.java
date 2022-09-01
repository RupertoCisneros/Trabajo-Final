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
 * @author omaldonado
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoEstructuraMail {
    
    private String nombreArchivo;
    private byte[] contenidoMail;
    private String mail;

    public DtoEstructuraMail() {
    }

    public DtoEstructuraMail(String nombreArchivo, byte[] contenidoMail, String mail) {
        this.nombreArchivo = nombreArchivo;
        this.contenidoMail = contenidoMail;
        this.mail = mail;
    }

   
    
    
    
}
