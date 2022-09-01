/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemParametros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface ParametroRepository extends JpaRepository<RemParametros, Long> {

    @Query(value = "SELECT valor FROM [Remetfu].[REM_PARAMETROS] where PARAMETROS_ID = :codigo ", nativeQuery = true)
    String obtenerParametro(@Param("codigo") Long codigo);
    
}
