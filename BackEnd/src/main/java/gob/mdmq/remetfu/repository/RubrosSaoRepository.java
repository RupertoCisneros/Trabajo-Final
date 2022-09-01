/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemRubrosSao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface RubrosSaoRepository extends JpaRepository<RemRubrosSao, Long> {
    
    @Query("Select r from RemRubrosSao r where r.subtipoRegistroId.subtipoRegistroId = :subtipoRegistro")
    RemRubrosSao obtenerRubroSao(@Param("subtipoRegistro") Long subtipoRegistro);
    
}
