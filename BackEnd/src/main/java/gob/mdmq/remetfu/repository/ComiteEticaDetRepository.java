/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemComiteEticaDet;
import gob.mdmq.remetfu.dto.DtoComiteEticaDetalle;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */

public interface ComiteEticaDetRepository extends JpaRepository<RemComiteEticaDet, Long> {

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoComiteEticaDetalle("
            + "det.comiteEticaDetId, trim(det.identificacion), trim(det.nombres),trim(det.numeroSenecyt),"
            + "trim(det.correo),trim(det.telefono),case det.estado when 'ACT' then 'ACTIVO' else 'INACTIVO' end,cgo.nombre) "
            + "from RemComiteEticaDet det "
            + "inner join det.comiteEticaCabId cab "
            + "inner join det.cargo cgo "
            + "where cab.comiteEticaCabId = :comiteEticaCabId")
    Set<DtoComiteEticaDetalle> obtenerMiembrosComiteEtica(@Param("comiteEticaCabId") Long comiteEticaCabId);
    
    @Query(value = "IF EXISTS(SELECT 1 FROM [Remetfu].[REM_COMITE_ETICA_DET] CE \n"
            + "                        WHERE CE.IDENTIFICACION =:nroIdentificacion AND CE.COMITE_ETICA_CAB_ID =:comite)\n"
            + "   SELECT top 1 'Estimado usuario la identificación ingresada ya consta como miembro de este comite'\n"
            + "ELSE\n"
            + "   SELECT 'OK'", nativeQuery = true)
    List<String> validarExisteMiembroComite(
            @Param("nroIdentificacion") String nroIdentificacion,
            @Param("comite") Long comite);

}
