/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import java.math.BigDecimal;

/**
 *
 * @author srcisnerosv
 */
public class DtoHijosRegistro {
    
    private Long subtipoRegistroId;
    private String descripcion;
    private Long tipoFormulario;
    private String acuerdoResponsabilidad;
    private String informeValorOrdenanza;
    private String valor1; 

    public DtoHijosRegistro() {
    }

    public DtoHijosRegistro(Long subtipoRegistroId, String descripcion, Long tipoFormulario) {
        this.subtipoRegistroId = subtipoRegistroId;
        this.descripcion = descripcion;
        this.tipoFormulario = tipoFormulario;
    }

    public DtoHijosRegistro(Long subtipoRegistroId, String descripcion, Long tipoFormulario, String acuerdoResponsabilidad) {
        this.subtipoRegistroId = subtipoRegistroId;
        this.descripcion = descripcion;
        this.tipoFormulario = tipoFormulario;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
    }

    public DtoHijosRegistro(Long subtipoRegistroId, String descripcion, Long tipoFormulario, String acuerdoResponsabilidad, String informeValorOrdenanza,String valor1) {
        this.subtipoRegistroId = subtipoRegistroId;
        this.descripcion = descripcion;
        this.tipoFormulario = tipoFormulario;
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
        this.informeValorOrdenanza = informeValorOrdenanza;
        this.valor1 = valor1;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }



    
    public Long getSubtipoRegistroId() {
        return subtipoRegistroId;
    }

    public void setSubtipoRegistroId(Long subtipoRegistroId) {
        this.subtipoRegistroId = subtipoRegistroId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(Long tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }

    public String getAcuerdoResponsabilidad() {
        return acuerdoResponsabilidad;
    }

    public void setAcuerdoResponsabilidad(String acuerdoResponsabilidad) {
        this.acuerdoResponsabilidad = acuerdoResponsabilidad;
    }

    public String getInformeValorOrdenanza() {
        return informeValorOrdenanza;
    }

    public void setInformeValorOrdenanza(String informeValorOrdenanza) {
        this.informeValorOrdenanza = informeValorOrdenanza;
    }

    @Override
    public String toString() {
        return "DtoHijosRegistro{" + "subtipoRegistroId=" + subtipoRegistroId + ", descripcion=" + descripcion + ", tipoFormulario=" + tipoFormulario + ", acuerdoResponsabilidad=" + acuerdoResponsabilidad + ", informeValorOrdenanza=" + informeValorOrdenanza + '}';
    }
            
}
