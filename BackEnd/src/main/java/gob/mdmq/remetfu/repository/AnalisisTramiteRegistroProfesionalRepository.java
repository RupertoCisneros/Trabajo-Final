/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemAnalisisTramiteRegistroProfesional;
import gob.mdmq.remetfu.dto.DtoBandejaAnalista;
import gob.mdmq.remetfu.dto.DtoConsultaRegistros;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface AnalisisTramiteRegistroProfesionalRepository extends JpaRepository<RemAnalisisTramiteRegistroProfesional, Long> {

    @Query(value = "SELECT valor FROM [Remetfu].[REM_PARAMETROS] where PARAMETROS_ID = :codigo ", nativeQuery = true)
    String obtenerParametros(@Param("codigo") Long codigo);

    @Query(value = "IF EXISTS(SELECT FECHA_FERIADO FROM Remetfu.REM_FERIADOS WHERE CONVERT(VARCHAR,FECHA_FERIADO,112)=CONVERT(VARCHAR,CONVERT(DATE,:fechaDato),112))   SELECT 1 ELSE   SELECT 0 ", nativeQuery = true)
    String verificaFechaFeriado(@Param("fechaDato") Date fechaDato);

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoBandejaAnalista(rp.registroProfesionalId,"
            + "case when ar.estado=223 or ar.estado=224 or ar.estado=225 or ar.estado=226 or ar.estado=227 or ar.estado=228 or ar.estado=229 then concat(nom.nomenclaturaTmp,'-',convert(varchar,year(rp.fechaCreacion)),'-',"
            + "concat(replicate('0',convert(varchar,nom.numeroDigitos-len(rp.secuencialTmp))),convert(varchar,rp.secuencialTmp)))"
            + "else concat(nom.nomenclaturaFinal,'-',convert(varchar,year(rp.fechaCreacion)),'-',"
            + "concat(replicate('0',convert(varchar,nom.numeroDigitos-len(rp.secuencialFinal))),convert(varchar,rp.secuencialFinal))) end, "
            + "sr.descripcion, us.denominacion, ar.fechaAsigna, cat.nombre, us1.denominacion, ana.analistaId) "
            + " from RemAnalisisTramiteRegistroProfesional ar,RemCatalogo cat "
            + " join  ar.analistaId ana "
            + " join  ar.registroProfesionalId rp "
            + " join  rp.subtipoRegistroId sr "
            + " join  rp.usuarioId us "
            + " join  ana.usuarioId us1 "
            + " join  sr.subtipoRegistroIdNomenclatura nom "
            + " where us1.nroIdentificacion =:nroIdentificacion"
            + " and ar.estado in (223,225)"
            + " and ar.estado = cat.catalogoId and cat.tipoCatalogoId=31"
    )
    Set<DtoBandejaAnalista> obtenerBandejaporAnalista(@Param("nroIdentificacion") String nroIdentificacion);

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoBandejaAnalista(rp.registroProfesionalId,"
            + "case when ar.estado=223 or ar.estado=224 or ar.estado=225 or ar.estado=226 or ar.estado=227 or ar.estado=228 or ar.estado=229 then concat(nom.nomenclaturaTmp,'-',convert(varchar,year(rp.fechaCreacion)),'-',"
            + "concat(replicate('0',convert(varchar,nom.numeroDigitos-len(rp.secuencialTmp))),convert(varchar,rp.secuencialTmp)))"
            + "else concat(nom.nomenclaturaFinal,'-',convert(varchar,year(rp.fechaCreacion)),'-',"
            + "concat(replicate('0',convert(varchar,nom.numeroDigitos-len(rp.secuencialFinal))),convert(varchar,rp.secuencialFinal))) end, "
            + "sr.descripcion,trim(us.nroIdentificacion),trim(us.denominacion),rp.fechaCreacion,trim(us1.denominacion),cat.nombre) "
            + " from RemAnalisisTramiteRegistroProfesional ar,RemCatalogo cat "
            + " join  ar.analistaId ana "
            + " join  ar.registroProfesionalId rp "
            + " join  rp.subtipoRegistroId sr "
            + " join  rp.usuarioId us "
            + " join  ana.usuarioId us1 "
            + " join  sr.subtipoRegistroIdNomenclatura nom "
            + " where ar.estado = cat.catalogoId and cat.tipoCatalogoId=31"
            + " and (us1.nroIdentificacion =:nroIdentificacion or trim(:nroIdentificacion)='')"
            + " and (ar.estado.catalogoId =:estadoRegistro or :estadoRegistro=0)"
            + " and (rp.fechaCreacion between convert(date,:fechaInicio) and convert(date,:fechaFin)"
            + " or trim(:fechaInicio)='' or trim(:fechaInicio)='')"
    )
    Set<DtoBandejaAnalista> obtenerRegistrosPorFiltros(
            @Param("nroIdentificacion") String nroIdentificacion, //Analista
            @Param("estadoRegistro") Long estadoRegistro, //Estado del Registro
            @Param("fechaInicio") String fechaInicio, //Fecha de inicio de Registros
            @Param("fechaFin") String fechaFin);                   //Fecha de Fin de Registro

    @Query(value = "select RP.SUBTIPO_REGISTRO_ID,RP.REGISTRO_PROFESIONAL_ID,nroRegistro=case when RP.estado=223 or RP.estado=224 or RP.estado=225 or RP.estado=226 or RP.estado=227 or RP.estado=228 or RP.estado=229 then concat(nom.nomenclatura_Tmp,'-',convert(varchar,year(rp.fecha_Creacion)),'-',\n"
            + "concat(replicate('0',convert(varchar,NOM.numero_Digitos-len(rp.secuencial_Tmp))),convert(varchar,rp.secuencial_Tmp)))\n"
            + "else concat(nom.nomenclatura_Final,'-',convert(varchar,year(rp.fecha_Creacion)),'-',\n"
            + "concat(replicate('0',convert(varchar,nom.numero_Digitos-len(rp.secuencial_Final))),convert(varchar,rp.secuencial_Final))) end,\n"
            + "ST.DESCRIPCION,RP.FECHA_CREACION,CAT.NOMBRE,US.DENOMINACION\n"
            + "from Remetfu.rem_usuarios US\n"
            + "LEFT JOIN Remetfu.REM_REGISTRO_PROFESIONAL RP\n"
            + "ON US.USUARIO_ID=RP.USUARIO_ID\n"
            + "JOIN Remetfu.REM_SUBTIPO_REGISTRO ST\n"
            + "ON RP.SUBTIPO_REGISTRO_ID=ST.SUBTIPO_REGISTRO_ID\n"
            + "LEFT join Remetfu.REM_NOMENCLATURA NOM\n"
            + "on RP.SUBTIPO_REGISTRO_ID = NOM.SUBTIPO_REGISTRO_ID\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO CAT\n"
            + "ON CAT.CATALOGO_ID=RP.ESTADO AND CAT.TIPO_CATALOGO_ID=31\n"
            + "WHERE US.NRO_IDENTIFICACION =:nroIdentificacion\n"
            + "UNION ALL\n"
            + "SELECT ST.SUBTIPO_REGISTRO_ID,TM.TUTOR_ID,concat(NOM.nomenclatura_Final,'-',convert(varchar,year(TM.FECHA_CREACION)),'-',\n"
            + "concat(replicate('0',convert(varchar,NOM.numero_Digitos-len(TM.TUTOR_ID))),convert(varchar,TM.TUTOR_ID))),\n"
            + "ST.DESCRIPCION,TM.FECHA_CREACION,CASE TM.ESTADO WHEN 'ACT' THEN 'ACTIVO' ELSE 'INACTIVO' END,US.DENOMINACION\n"
            + "FROM Remetfu.REM_TUTOR_MASCOTA TM,\n"
            + "Remetfu.REM_NOMENCLATURA NOM,\n"
            + "Remetfu.REM_USUARIOS US,\n"
            + "Remetfu.REM_SUBTIPO_REGISTRO ST\n"
            + "WHERE NOM.SUBTIPO_REGISTRO_ID=1\n"
            + "AND TM.USUARIO_ID=US.USUARIO_ID\n"
            + "AND NOM.SUBTIPO_REGISTRO_ID=ST.SUBTIPO_REGISTRO_ID\n"
            + "AND US.NRO_IDENTIFICACION =:nroIdentificacion\n"
            + "UNION ALL\n" 
            + "SELECT ST.SUBTIPO_REGISTRO_ID,ANT.ANIMAL_TUTOR_ID,nroRegistro=case when ANT.estado=223 or ANT.estado=224 or ANT.estado=225 or ANT.estado=226 or ANT.estado=227 or ANT.estado=228 or ANT.estado=229 then concat(nom.nomenclatura_Tmp,'-',convert(varchar,year(ANT.FECHA_REGISTRO)),'-',\n"
            + "concat(replicate('0',convert(varchar,NOM.NUMERO_DIGITOS-len(ANT.secuencial_Tmp))),convert(varchar,ANT.secuencial_Tmp)))\n"
            + "else concat(nom.nomenclatura_Final,'-',convert(varchar,year(ANT.fecha_Creacion)),'-',\n"
            + "concat(replicate('0',convert(varchar,NOM.NUMERO_DIGITOS-len(ANT.secuencial_Final))),convert(varchar,ANT.secuencial_Final))) end,\n"
            + "ST.DESCRIPCION,ANT.FECHA_REGISTRO,CAT.NOMBRE,US.DENOMINACION\n"
            + "FROM Remetfu.REM_ANIMAL_TUTOR ANT,\n"
            + "Remetfu.REM_TUTOR_MASCOTA TM,\n"
            + "Remetfu.REM_NOMENCLATURA NOM,\n"
            + "Remetfu.REM_USUARIOS US,\n"
            + "Remetfu.REM_SUBTIPO_REGISTRO ST,\n"
            + "Remetfu.REM_CATALOGO CAT\n"
            + "WHERE NOM.SUBTIPO_REGISTRO_ID=26\n"
            + "AND ANT.TUTOR_ID=TM.TUTOR_ID\n"
            + "AND TM.USUARIO_ID=US.USUARIO_ID\n"
            + "AND NOM.SUBTIPO_REGISTRO_ID=ST.SUBTIPO_REGISTRO_ID\n"
            + "AND CAT.CATALOGO_ID=ANT.ESTADO AND CAT.TIPO_CATALOGO_ID=31\n"
            + "AND US.NRO_IDENTIFICACION =:nroIdentificacion  ORDER BY FECHA_CREACION DESC", nativeQuery = true)
      List<String> obtenerRegistrosCiudadano(@Param("nroIdentificacion") String nroIdentificacion);

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoConsultaRegistros(rp.registroProfesionalId,"
            + "case when rp.estado=223 or rp.estado=224 or rp.estado=225 or rp.estado=226 or rp.estado=227 or rp.estado=228 or rp.estado=229 then concat(nom.nomenclaturaTmp,'-',convert(varchar,year(rp.fechaCreacion)),'-',"
            + "concat(replicate('0',convert(varchar,nom.numeroDigitos-len(rp.secuencialTmp))),convert(varchar,rp.secuencialTmp)))"
            + "else concat(nom.nomenclaturaFinal,'-',convert(varchar,year(rp.fechaCreacion)),'-',"
            + "concat(replicate('0',convert(varchar,nom.numeroDigitos-len(rp.secuencialFinal))),convert(varchar,rp.secuencialFinal))) end, "
            + "sr.descripcion, rp.fechaCreacion, cat.nombre)"
            + " from RemRegistroProfesional rp "
            + " join  rp.subtipoRegistroId sr "
            + " join  rp.estado cat "
            + " join  rp.usuarioId us "
            + " join  sr.subtipoRegistroIdNomenclatura nom "
            + " where us.nroIdentificacion =:nroIdentificacion "
            + " and rp.registroProfesionalId = :registroProfesionalId"
            + " and rp.usuarioId.usuarioId = :usuarioId "
            + " and cat.tipoCatalogoId in (31)"
    )
    Set<DtoConsultaRegistros> obtenerRegistroMail(@Param("nroIdentificacion") String nroIdentificacion,
            @Param("usuarioId") Long usuarioId, @Param("registroProfesionalId") Long registroProfesionalId);

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoBandejaAnalista(trim(us.denominacion),trim(us.nroIdentificacion),"//ana.analistaId,"
            + "(select count(ar.analsisTramiteRegistroProfesionalId) from RemAnalisisTramiteRegistroProfesional ar "
            + "where ar.estado in(223,225) and ar.analistaId=ana.analistaId),"
            + "ana.analistaId, us.usuarioId) "
            + " from RemAnalista ana "
            + " join ana.usuarioId us ")
    Set<DtoBandejaAnalista> obtenerNroRegistrosAnalista();

    @Query("SELECT arp from RemAnalisisTramiteRegistroProfesional arp "
            + " where arp.registroProfesionalId.registroProfesionalId = :registroProfesionalId"
    )
    Optional<RemAnalisisTramiteRegistroProfesional> obtenerTramiteporRegistro(@Param("registroProfesionalId") Long registroProfesionalId);

    @Modifying
    @Query("update RemAnalisisTramiteRegistroProfesional arp "
            + "set arp.analistaId.analistaId = :analistaId "
            + "where arp.registroProfesionalId.registroProfesionalId = :registroProfesionalId")
    void actualizarTramiteRegistroProfesional(@Param("registroProfesionalId") Long registroProfesionalId,
            @Param("analistaId") Long analistaId);

}
