/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemUsuarioPerfil;
import gob.mdmq.remetfu.dto.DtoUsuarioPerfil;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ruper
 */

public interface UsuarioPerfilRepository extends JpaRepository<RemUsuarioPerfil, Long> {

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoUsuarioPerfil(trim(username), trim(nombres), trim(apellidos),per.nombre) "
            + "from RemUsuarios us "
            + "inner join us.remUsuarioPerfilSet upe "
            + "inner join upe.perfilId per "
            + "where us.username=:username and upe.perfilId.perfilId not  in(7)")
    DtoUsuarioPerfil obtenerPerfilesUsuario(@Param("username") String username);
    
    
    @Query("select up from RemUsuarioPerfil up where up.usuarioId.usuarioId = :usuarioId and up.perfilId.perfilId = 7 ")
    Set<RemUsuarioPerfil> obtenerUsuarioPAM(@Param("usuarioId") Long usuarioId);

}
