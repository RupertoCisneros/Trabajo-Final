/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemMenuCabecera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author omaldonado
 */
public interface MenuPerfilRepository extends JpaRepository<RemMenuCabecera, Long> {
    

    
    @Query ("SELECT  distinct  mc from RemMenuCabecera mc  "
            + "join fetch mc.hijos mn "
            + "join mn.remMenuPerfilSet mp "
            + "join mp.remPerfil per "
            + "join per.remMenuPerfilSet pm "
            + "join pm.remPerfil rp "
            + "join rp.remUsuarioPerfilSet up "
            + "join up.usuarioId usu  "
            + "where mp.estado='ACT'"
            + " and per.estado='ACT'"
            + " and pm.estado='ACT'"
            + " and rp.estado='ACT'"
            + " and up.estado='ACT'"
            + " and mn.estado='ACT'"
            + " and per.nombre = :perfil")
    List<RemMenuCabecera> obtenerMenuPorRoles(@Param("perfil")  String perfil);
    
}
