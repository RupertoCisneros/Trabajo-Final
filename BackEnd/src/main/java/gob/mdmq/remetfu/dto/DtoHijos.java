/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

/**
 *
 * @author omaldonado
 */
public class DtoHijos {
    
    private String nombre;
    private String descripcion;
    private String icono;
    private String ruta;

    public DtoHijos() {
    }
    
    

    public DtoHijos( String nombre, String descripcion, String icono, String ruta) {
       
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.ruta = ruta;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "DtoHijos{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", icono=" + icono + ", ruta=" + ruta + '}';
    }

   
    
}
