/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemTipoRegistro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author srcisnerosv
 */
public interface TipoRegistroRepository extends JpaRepository<RemTipoRegistro, Long> {
    
    @Query("Select distinct tp from RemTipoRegistro tp join fetch  tp.remSubtipoRegistro stp where tp.estado = 'ACT' and stp.estado = 'ACT'")
    List<RemTipoRegistro> listaRegistros();
    
}
