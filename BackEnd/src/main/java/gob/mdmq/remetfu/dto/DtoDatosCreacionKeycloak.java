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

public class DtoDatosCreacionKeycloak {

    private String banderaKeycloack;
    private String username;
    private String emailMunicipio;
    private String ssoId;
    private String nroIdentificacion;
    private Long idPerfil;
    public String usuarioCreacion;
    public String terminalCreacion;

    public DtoDatosCreacionKeycloak() {
    }

    public DtoDatosCreacionKeycloak(String banderaKeycloack, String username, String emailMunicipio, String ssoId, String nroIdentificacion, Long idPerfil, String usuarioCreacion, String terminalCreacion) {
        this.banderaKeycloack = banderaKeycloack;
        this.username = username;
        this.emailMunicipio = emailMunicipio;
        this.ssoId = ssoId;
        this.nroIdentificacion = nroIdentificacion;
        this.idPerfil = idPerfil;
        this.usuarioCreacion = usuarioCreacion;
        this.terminalCreacion = terminalCreacion;
    }


}
