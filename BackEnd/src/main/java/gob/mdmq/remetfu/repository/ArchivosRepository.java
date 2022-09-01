/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemArchivos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author omaldonado
 */
public interface ArchivosRepository extends CrudRepository<RemArchivos, Long> {
    
    @Query("select ar from RemArchivos ar where ar.archivoId = :archivoId")
    RemArchivos buscarArchivo(@Param("archivoId") String archivoId);
    
}
