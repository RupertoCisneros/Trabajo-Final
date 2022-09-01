/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemAnalista;
import gob.mdmq.remetfu.dto.DtoAsignacionAnalista;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface AnalistaRepository extends JpaRepository<RemAnalista, Long> {

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoAsignacionAnalista( ana.analistaId , SUM(ana.nroTramitesMes),  (select COUNT (tra.analsisTramiteRegistroProfesionalId) "
            + "from RemAnalisisTramiteRegistroProfesional tra where tra.analistaId =ana.analistaId and tra.estado IN(225,223)) as p) "
            + "from RemAnalisisTramiteRegistroProfesional atr right "
            + "join atr.analistaId ana "
            + "where YEAR(ana.mesTramites)=YEAR(getdate()) "
            + "and MONTH(ana.mesTramites)=MONTH(getdate()) "
            + "AND ana.estado ='ACT' "
            + "group by ana.analistaId, "
            + "ana.nroTramitesMes "
            + "order by ana.nroTramitesMes ASC, p ASC")
    List<DtoAsignacionAnalista> getListaAnalistasActivos();

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoAsignacionAnalista( trim(us.nroIdentificacion), us.denominacion, "
            + "(select COUNT (tra.analsisTramiteRegistroProfesionalId) "
            + "from RemAnalisisTramiteRegistroProfesional tra "
            + "where tra.analistaId =ana.analistaId and tra.estado IN(225,223) ) as p) "
            + "from RemAnalisisTramiteRegistroProfesional atr "
            + "right join atr.analistaId ana "
            + "left join ana.usuarioId us "
            + "where ana.estado ='ACT' "
            + "group by ana.analistaId,us.nroIdentificacion, us.denominacion "
            + "order by p ASC")
    List<DtoAsignacionAnalista> obtenerRegistrosAnalistas();

    @Query(value = "Select top 1 * from [Remetfu].[REM_ANALISTA]", nativeQuery = true)
    RemAnalista obtenerAnalistatByDefault();

    @Modifying
    @Query("update RemAnalisisTramiteRegistroProfesional ana set ana.usuarioModificacion = :usuarioModificacion, ana.terminalModificacion = :terminalModificacion,  ana.estado.catalogoId = 226, fechaAprobacion = :fechaAprobacion , novedadAprobacion = :novedad  where ana.registroProfesionalId.registroProfesionalId = :registroProfesionalId ")
    void aprobarTramiteRegistroAnalistaProfesional(@Param("registroProfesionalId") Long registroProfesionalId, @Param("fechaAprobacion") Date fechaAprobacion,
            @Param("novedad") String novedad, @Param("usuarioModificacion") String usuarioModificacion,
            @Param("terminalModificacion") String terminalModificacion);

    @Modifying
    @Query("update RemRegistroProfesional rp set rp.usuarioModificacion = :usuarioModificacion, rp.terminalModificacion = :terminalModificacion,rp.estado.catalogoId = 226 where rp.registroProfesionalId = :registroProfesionalId")
    void aprobarTramiteProfesional(@Param("registroProfesionalId") Long registroProfesionalId,
            @Param("usuarioModificacion") String usuarioModificacion,
            @Param("terminalModificacion") String terminalModificacion);

    @Modifying
    @Query("update RemAnalisisTramiteRegistroProfesional ana set ana.usuarioModificacion = :usuarioModificacion, ana.terminalModificacion = :terminalModificacion ,ana.estado.catalogoId = 228, fechaDevolucion = :fechaDevolucion , motivoDevolucion = :motivo  where ana.registroProfesionalId.registroProfesionalId = :registroProfesionalId ")
    void devolverTramiteRegistroAnalistaProfesional(@Param("registroProfesionalId") Long registroProfesionalId, @Param("fechaDevolucion") Date fechaDevolucion,
            @Param("motivo") String motivo,
             @Param("usuarioModificacion") String usuarioModificacion,
            @Param("terminalModificacion") String terminalModificacion);

    @Modifying
    @Query("update RemRegistroProfesional rp set rp.usuarioModificacion = :usuarioModificacion, rp.terminalModificacion = :terminalModificacion, rp.estado.catalogoId = 228 where rp.registroProfesionalId = :registroProfesionalId")
    void devolverTramiteProfesional(@Param("registroProfesionalId") Long registroProfesionalId,
            @Param("usuarioModificacion") String usuarioModificacion,
            @Param("terminalModificacion") String terminalModificacion);

    @Modifying
    @Query("update RemAnalisisTramiteRegistroProfesional ana set ana.usuarioModificacion = :usuarioModificacion, ana.terminalModificacion = :terminalModificacion , ana.estado.catalogoId = 227, fechaRechazo = :fechaRechazo , motivoRechazo = :motivo  where ana.registroProfesionalId.registroProfesionalId = :registroProfesionalId ")
    void rechazarTramiteRegistroAnalistaProfesional(@Param("registroProfesionalId") Long registroProfesionalId, @Param("fechaRechazo") Date fechaRechazo,
            @Param("motivo") String motivo,
            @Param("usuarioModificacion") String usuarioModificacion,
            @Param("terminalModificacion") String terminalModificacion);

    @Modifying
    @Query("update RemRegistroProfesional rp  set rp.usuarioModificacion = :usuarioModificacion, rp.terminalModificacion = :terminalModificacion, rp.estado.catalogoId = 227 where rp.registroProfesionalId = :registroProfesionalId")
    void rechazarTramiteProfesional(@Param("registroProfesionalId") Long registroProfesionalId,
            @Param("usuarioModificacion") String usuarioModificacion,
            @Param("terminalModificacion") String terminalModificacion);

    @Query(value = "select * from Remetfu.REM_ANALISTA where ANALISTA_ID = :analistaId", nativeQuery = true)
    RemAnalista obtenerAnalista(@Param("analistaId") Long analistaId);

}
