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
//@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoUsuarioPerfil {

    private Long usuarioId;
    private String nroIdentificacion;
    private String username;
    private String denominacion;
    private String nombres;
    private String apellidos;
    private String email;
    private String ssoId;
    private String estado;
    private String nombrePerfil;
    private String nombre;
    private String mail;

    public DtoUsuarioPerfil() {
    }

    public DtoUsuarioPerfil(String username, String nombres, String apellidos, String nombrePerfil) {
        this.username = username;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombrePerfil = nombrePerfil;
    }

    public DtoUsuarioPerfil(String nroIdentificacion, String username, String denominacion, String nombre, String mail) {
        this.nroIdentificacion = nroIdentificacion;
        this.username = username;
        this.denominacion = denominacion;
        this.nombre = nombre;
        this.mail = mail;
    }

    public DtoUsuarioPerfil(Long usuarioId, String nroIdentificacion, String username, String denominacion, String ssoId, String estado, String nombre, String mail) {
        this.usuarioId = usuarioId;
        this.nroIdentificacion = nroIdentificacion;
        this.username = username;
        this.denominacion = denominacion;
        this.ssoId = ssoId;
        this.estado = estado;
        this.nombre = nombre;
        this.mail = mail;
    }
    public DtoUsuarioPerfil(String nroIdentificacion, String username, String denominacion, String nombres, String apellidos, String email, String ssoId, String estado, String nombrePerfil) {
        this.nroIdentificacion = nroIdentificacion;
        this.username = username;
        this.denominacion = denominacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.ssoId = ssoId;
        this.estado = estado;
        this.nombrePerfil = nombrePerfil;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    

}
