/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.dto.DtoCatalogo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */

public interface CatalogoRepository extends JpaRepository<RemCatalogo, Long> {
    
    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoCatalogo(e.catalogoId, e.nombre,e.estado) from RemCatalogo e where e.estado ='ACT'")
    List<DtoCatalogo> obtenerListaCatalogo();
    
    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoCatalogo(e.catalogoId,e.nombre,e.estado) from RemCatalogo e where e.estado ='ACT' and e.catalogoId = :id ")
    List<DtoCatalogo> obtenerCatalogoById(@Param("id") Long id);

    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoCatalogo("
            + "tc.tipoCatalogoId,tc.nombre,e.catalogoId, e.nombre,e.estado) "
            + "from RemCatalogo e,RemTipoCatalogo tc "
            + "where e.tipoCatalogoId=tc.tipoCatalogoId ")
    List<DtoCatalogo> obtenerListaCatalogos();
}
