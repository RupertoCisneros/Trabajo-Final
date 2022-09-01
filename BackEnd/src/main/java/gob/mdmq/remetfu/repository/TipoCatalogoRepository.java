/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemTipoCatalogo;
import gob.mdmq.remetfu.dto.DtoTipoCatalogo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface TipoCatalogoRepository extends JpaRepository<RemTipoCatalogo, Long> {
    
    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoTipoCatalogo(e.tipoCatalogoId, e.nombre,e.estado) from RemTipoCatalogo e where e.estado ='ACT'")
    List<DtoTipoCatalogo> obtenerListaTipoCatalogo();
    
    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoTipoCatalogo(cat.catalogoId, cat.nombre,cat.estado) "
            + "from RemTipoCatalogo e "
            + "inner join e.remCatalogoSet cat "
            + "where e.estado ='ACT' "
            + "and e.tipoCatalogoId = :id")
    List<DtoTipoCatalogo> obtenerListaTipoCatalogoById(@Param("id") Long id);
   
}
