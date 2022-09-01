/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemPerfil;
import gob.mdmq.remetfu.dto.DtoPerfil;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ruper
 */
public interface PerfilRepository extends JpaRepository<RemPerfil, Long> {

    @Query("Select new  gob.mdmq.remetfu.dto.DtoPerfil(p.perfilId, p.nombre)  from RemPerfil p")
    Set<DtoPerfil> obtenerPerfiles();

    @Query( value="Select *  from [Remetfu].[REM_PERFIL] where PERFIL_ID = :perfilId",  nativeQuery = true)
    RemPerfil obtenerPerfilById(@Param("perfilId") Long perfilId);
    
    
    
}
