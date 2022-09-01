/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

/**
 *
 * @author ebustillos
 */
public class DtoPerfil {

    private Long perfilId;
    private String nombre;

    public DtoPerfil() {
    }

    public DtoPerfil(Long perfilId, String nombre) {
        this.perfilId = perfilId;
        this.nombre = nombre;
    }

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DtoPerfil{" + "perfilId=" + perfilId + ", nombre=" + nombre + '}';
    }
    
    

}
