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
@JsonIgnoreProperties( ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoUsuarios {

    //Datos de Entidad de Usuario
    private Long usuarioId;
    private Character tipoIdentificacion;
    private String nroIdentificacion;
    private String denominacion;
    private String nombres;
    private String apellidos;
    private String mail;
    private String mailPersonal;
    private String direccion;
    private String telefono;
    private String movil;
    private String aceptacionMedios;
    private String estado;
    private String cim;
    private String username;
    private String clave;
    private Long tipoUsuario;
    private String tipoUsuarioDesc;  //Viene de Catalogo, cod=30
    private Long admZonal;
    private String admZonalDesc;     //Viene de Catalogo, cod=3
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    private Long nacionalidad;
    private String nacionalidadDesc;//Viene de Catalogo, cod=2
    private Long genero;
    private String generoDesc;      //Viene de Catalogo, cod=34
    private String discapacidad;

    public DtoUsuarios() {
    }

    public DtoUsuarios(Long usuarioId, Character tipoIdentificacion, String nroIdentificacion, String denominacion, String nombres, String apellidos, String mail, String mailPersonal, String direccion, String telefono, String movil, String aceptacionMedios, String estado, String cim, String username, String clave, Long tipoUsuario, String tipoUsuarioDesc, Long admZonal, String admZonalDesc, Date fechaNacimiento, Long nacionalidad, String nacionalidadDesc, Long genero, String generoDesc, String discapacidad) {
        this.usuarioId = usuarioId;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nroIdentificacion = nroIdentificacion;
        this.denominacion = denominacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.mail = mail;
        this.mailPersonal=mailPersonal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.aceptacionMedios = aceptacionMedios;
        this.estado = estado;
        this.cim = cim;
        this.username = username;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
        this.tipoUsuarioDesc = tipoUsuarioDesc;
        this.admZonal = admZonal;
        this.admZonalDesc = admZonalDesc;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.nacionalidadDesc = nacionalidadDesc;
        this.genero = genero;
        this.generoDesc = generoDesc;
        this.discapacidad = discapacidad;
    }

    public DtoUsuarios(Long usuarioId, String nroIdentificacion, String denominacion) {
        this.usuarioId = usuarioId;
        this.nroIdentificacion = nroIdentificacion;
        this.denominacion = denominacion;
    }

    public DtoUsuarios(String nroIdentificacion, String denominacion, String mailPersonal, String direccion, String telefono, String movil) {
        this.nroIdentificacion = nroIdentificacion;
        this.denominacion = denominacion;
        this.mailPersonal = mailPersonal;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
    }

    
}
