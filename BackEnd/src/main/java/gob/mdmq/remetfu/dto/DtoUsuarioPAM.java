/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

/**
 *
 * @author srcisnerosv
 */
//@Data
//@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoUsuarioPAM {

    private String cim;
    private String denominacion;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String tipoIdentificacion;
    private String mail;
    private String mailPersonal;
    private String direccion;
    private Date fechaNacimiento;
    private Long nacionalidad;
    private String celular;
    private String telefono;
    private Long genero;
    private String username;
    private String ssoId;
    private String banderaKeycloack;
    private String discapacidad;
    private String usuarioCreacion;

    public DtoUsuarioPAM() {
    }

    public DtoUsuarioPAM(String cim, String denominacion, String nombres, String apellidos, String identificacion, String tipoIdentificacion, String mail, String mailPersonal, String direccion, Date fechaNacimiento, Long nacionalidad, String celular, String telefono, Long genero, String username, String ssoId, String banderaKeycloack, String discapacidad, String usuarioCreacion) {
        this.cim = cim;
        this.denominacion = denominacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.mail = mail;
        this.mailPersonal = mailPersonal;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.telefono = telefono;
        this.genero = genero;
        this.username = username;
        this.ssoId = ssoId;
        this.banderaKeycloack = banderaKeycloack;
        this.discapacidad = discapacidad;
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailPersonal() {
        return mailPersonal;
    }

    public void setMailPersonal(String mailPersonal) {
        this.mailPersonal = mailPersonal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Long nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getGenero() {
        return genero;
    }

    public void setGenero(Long genero) {
        this.genero = genero;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getBanderaKeycloack() {
        return banderaKeycloack;
    }

    public void setBanderaKeycloack(String banderaKeycloack) {
        this.banderaKeycloack = banderaKeycloack;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    @Override
    public String toString() {
        return "DtoUsuarioPAM{" + "cim=" + cim + ", denominacion=" + denominacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", identificacion=" + identificacion + ", tipoIdentificacion=" + tipoIdentificacion + ", mail=" + mail + ", mailPersonal=" + mailPersonal + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad=" + nacionalidad + ", celular=" + celular + ", telefono=" + telefono + ", genero=" + genero + ", username=" + username + ", ssoId=" + ssoId + ", banderaKeycloack=" + banderaKeycloack + ", discapacidad=" + discapacidad + ", usuarioCreacion=" + usuarioCreacion + '}';
    } 

}
