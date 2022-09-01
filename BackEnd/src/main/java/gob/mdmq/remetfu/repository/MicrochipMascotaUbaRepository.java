/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascotaUba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface MicrochipMascotaUbaRepository extends JpaRepository<RemMicrochipMascotaUba, Long> {

    @Query("Select mch from RemMicrochipMascotaUba mch where mch.codigoMicrochip = :codigo")
    RemMicrochipMascota obtenerCodigoMicroChipUba(@Param("codigo") String codigo);
    
}
