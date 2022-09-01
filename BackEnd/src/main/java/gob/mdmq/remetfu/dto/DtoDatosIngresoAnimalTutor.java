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
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class DtoDatosIngresoAnimalTutor {

    private Long estadoTutoria;
    private Long tipoAnimal;
    private Long microchipMascotaId;
    private Long especie;
    private Long raza;
    private Long sexo;
    private Long estadoReproductivo;
    private Long colorPredominante;
    private Long colorSecundario;
    private Long permanencia;
    private Long parroquia;
    private Long tipoVivienda;
    private Long pruebaComportamiento;
    private Long motivoFallecimiento;
    private Long certificadoEsterilizacionArchivo;
    private Long anexoVisible;
    private Long identificacionFotografica1;
    private Long identificacionFotografica2 ;
    private Long tutorId ;
    private Long identificacionVisible ;
    private Long certificadoVacunacionArchivo ;
  

    public DtoDatosIngresoAnimalTutor() {
    }

    public DtoDatosIngresoAnimalTutor(Long estadoTutoria, Long tipoAnimal, Long microchipMascotaId, Long especie, Long raza, Long sexo, Long estadoReproductivo, Long colorPredominante, Long colorSecundario, Long permanencia, Long parroquia, Long tipoVivienda, Long pruebaComportamiento, Long motivoFallecimiento, Long certificadoEsterilizacionArchivo, Long anexoVisible, Long identificacionFotografica1, Long identificacionFotografica2, Long tutorId, Long identificacionVisible, Long certificadoVacunacionArchivo) {
        this.estadoTutoria = estadoTutoria;
        this.tipoAnimal = tipoAnimal;
        this.microchipMascotaId = microchipMascotaId;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.estadoReproductivo = estadoReproductivo;
        this.colorPredominante = colorPredominante;
        this.colorSecundario = colorSecundario;
        this.permanencia = permanencia;
        this.parroquia = parroquia;
        this.tipoVivienda = tipoVivienda;
        this.pruebaComportamiento = pruebaComportamiento;
        this.motivoFallecimiento = motivoFallecimiento;
        this.certificadoEsterilizacionArchivo = certificadoEsterilizacionArchivo;
        this.anexoVisible = anexoVisible;
        this.identificacionFotografica1 = identificacionFotografica1;
        this.identificacionFotografica2 = identificacionFotografica2;
        this.tutorId = tutorId;
        this.identificacionVisible = identificacionVisible;
        this.certificadoVacunacionArchivo = certificadoVacunacionArchivo;
    }

   

}
