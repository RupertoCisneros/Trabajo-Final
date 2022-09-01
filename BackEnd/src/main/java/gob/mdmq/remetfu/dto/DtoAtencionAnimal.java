/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.dto;

/**
 *
 * @author omaldonado
 */
public class DtoAtencionAnimal {

    public Long registroProfesionalId;
    public Long microChipMascotaId;
    public String identidicacionFotografica1;
    public String identidicacionFotografica2;
    public Long tipoIdentificacionVisible;
    public String identificacionVisible;
    public Long atencionRealizada;
    public Long estadoChequeo;

    public DtoAtencionAnimal() {
    }

    public DtoAtencionAnimal(Long registroProfesionalId, Long microChipMascotaId, String identidicacionFotografica1, String identidicacionFotografica2, Long tipoIdentificacionVisible, String identificacionVisible, Long atencionRealizada, Long estadoChequeo) {
        this.registroProfesionalId = registroProfesionalId;
        this.microChipMascotaId = microChipMascotaId;
        this.identidicacionFotografica1 = identidicacionFotografica1;
        this.identidicacionFotografica2 = identidicacionFotografica2;
        this.tipoIdentificacionVisible = tipoIdentificacionVisible;
        this.identificacionVisible = identificacionVisible;
        this.atencionRealizada = atencionRealizada;
        this.estadoChequeo = estadoChequeo;
    }

   
    
    

    public Long getRegistroProfesionalId() {
        return registroProfesionalId;
    }

    public void setRegistroProfesionalId(Long registroProfesionalId) {
        this.registroProfesionalId = registroProfesionalId;
    }

    public Long getMicroChipMascotaId() {
        return microChipMascotaId;
    }

    public void setMicroChipMascotaId(Long microChipMascotaId) {
        this.microChipMascotaId = microChipMascotaId;
    }

    public String getIdentidicacionFotografica1() {
        return identidicacionFotografica1;
    }

    public void setIdentidicacionFotografica1(String identidicacionFotografica1) {
        this.identidicacionFotografica1 = identidicacionFotografica1;
    }

    public String getIdentidicacionFotografica2() {
        return identidicacionFotografica2;
    }

    public void setIdentidicacionFotografica2(String identidicacionFotografica2) {
        this.identidicacionFotografica2 = identidicacionFotografica2;
    }

    public Long getTipoIdentificacionVisible() {
        return tipoIdentificacionVisible;
    }

    public void setTipoIdentificacionVisible(Long tipoIdentificacionVisible) {
        this.tipoIdentificacionVisible = tipoIdentificacionVisible;
    }

    public String getIdentificacionVisible() {
        return identificacionVisible;
    }

    public void setIdentificacionVisible(String identificacionVisible) {
        this.identificacionVisible = identificacionVisible;
    }

    public Long getAtencionRealizada() {
        return atencionRealizada;
    }

    public void setAtencionRealizada(Long atencionRealizada) {
        this.atencionRealizada = atencionRealizada;
    }

    public Long getEstadoChequeo() {
        return estadoChequeo;
    }

    public void setEstadoChequeo(Long estadoChequeo) {
        this.estadoChequeo = estadoChequeo;
    }

    

    @Override
    public String toString() {
        return "DtoAtencionAnimal{" + "registroProfesionalId=" + registroProfesionalId + ", microChipMascotaId=" + microChipMascotaId + ", identidicacionFotografica1=" + identidicacionFotografica1 + ", identidicacionFotografica2=" + identidicacionFotografica2 + ", tipoIdentificacionVisible=" + tipoIdentificacionVisible + ", identificacionVisible=" + identificacionVisible + ", atencionRealizada=" + atencionRealizada + ", estadoChequeo=" + estadoChequeo + '}';
    }

    

}
