/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemMicrochipMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface MicrochipMascotaRepository extends JpaRepository<RemMicrochipMascota, Long> {
    
    @Query("Select mch from RemMicrochipMascota mch where mch.codigoMicrochip = :codigo")
    RemMicrochipMascota obtenerCodigoMicroChip(@Param("codigo") String codigo);
    
}
