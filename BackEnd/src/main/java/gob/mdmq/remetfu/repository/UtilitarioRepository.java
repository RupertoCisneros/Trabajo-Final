/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemSecuencial;
import gob.mdmq.remetfu.dto.DtoNacionalidad;
import gob.mdmq.remetfu.dto.DtoUsuarioAnalista;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtilitarioRepository extends JpaRepository<RemSecuencial, Long> {

    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoUsuarioAnalista(ru.usuarioId, trim(ru.nroIdentificacion), ru.denominacion, ru.estado) from RemUsuarios ru, RemUsuarioPerfil rup, RemPerfil rp where ru.usuarioId = rup.usuarioId and rup.perfilId = rp.perfilId AND rp.perfilId = 3")
    Set<DtoUsuarioAnalista> getListaAnalistas();

    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoNacionalidad(cat.catalogoId , cat.nombre) from RemCatalogo cat where cat.tipoCatalogoId = 2")
    Set<DtoNacionalidad> obtenerNacionalidad();


}
