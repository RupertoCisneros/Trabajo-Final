/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

import java.util.List;

/**
 *
 * @author srcisnerosv
 */
public class DtoTipoRegistro {

    private Long tipoRegistroId;
    private String descripcion;
    private Long tipoFormulario;
    private List<DtoHijosRegistro> hijos;

    public DtoTipoRegistro() {
    }

    public DtoTipoRegistro(Long tipoRegistroId, String descripcion, Long tipoFormulario, List<DtoHijosRegistro> hijos) {
        this.tipoRegistroId = tipoRegistroId;
        this.descripcion = descripcion;
        this.tipoFormulario = tipoFormulario;
        this.hijos = hijos;
    }

    

    public Long getTipoRegistroId() {
        return tipoRegistroId;
    }

    public void setTipoRegistroId(Long tipoRegistroId) {
        this.tipoRegistroId = tipoRegistroId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DtoHijosRegistro> getHijos() {
        return hijos;
    }

    public void setHijos(List<DtoHijosRegistro> hijos) {
        this.hijos = hijos;
    }

    public Long getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(Long tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }

    @Override
    public String toString() {
        return "DtoTipoRegistro{" + "tipoRegistroId=" + tipoRegistroId + ", descripcion=" + descripcion + ", tipoFormulario=" + tipoFormulario + ", hijos=" + hijos + '}';
    }
    

   

}
