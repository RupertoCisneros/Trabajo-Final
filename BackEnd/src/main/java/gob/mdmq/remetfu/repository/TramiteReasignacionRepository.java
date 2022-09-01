/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemTramiteReasignacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface TramiteReasignacionRepository extends JpaRepository<RemTramiteReasignacion, Long> {
    
    @Query(value = "SELECT RP.REGISTRO_PROFESIONAL_ID,\n"
            + "NRO_REGISTRO=case when rp.estado=223 or rp.estado=224 or rp.estado=225 or rp.estado=227 or rp.estado=228 then concat(nom.NOMENCLATURA_TMP,'-',convert(varchar,year(rp.FECHA_CREACION)),'-',\n"
            + "concat(replicate('0',convert(varchar,(select valor from Remetfu.Rem_Parametros where parametros_Id=8)-len(rp.secuencial_Tmp))),convert(varchar,rp.secuencial_Tmp)))\n"
            + "else concat(nom.nomenclatura_Final,'-',convert(varchar,year(rp.fecha_Creacion)),'-',\n"
            + "concat(replicate('0',convert(varchar,(select valor from Remetfu.Rem_Parametros where parametros_Id=8)-len(rp.secuencial_Final))),convert(varchar,rp.secuencial_Final))) end, \n"
            + "ANALISTA_ANTES=us1.DENOMINACION,ANALISTA_DESPUES=us2.DENOMINACION,tre.MOTIVO,FECHA_REASIGNACION,'PERTENECE A'= us4.DENOMINACION,'USUARIO REASIGNA'= us3.DENOMINACION\n"
            + "FROM Remetfu.REM_TRAMITE_REASIGNACION tre\n"
            + "inner join Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL trp\n"
            + "on tre.TRAMITE_REASIGNACION_ID=trp.ANALSIS_TRAMITE_REGISTRO_PROFESIONAL_ID\n"
            + "inner join Remetfu.REM_REGISTRO_PROFESIONAL rp\n"
            + "on rp.REGISTRO_PROFESIONAL_ID=trp.REGISTRO_PROFESIONAL_ID\n"
            + "inner join Remetfu.REM_SUBTIPO_REGISTRO sr\n"
            + "on rp.subtipo_Registro_Id =sr.SUBTIPO_REGISTRO_ID\n"
            + "inner join Remetfu.REM_NOMENCLATURA nom \n"
            + "on sr.SUBTIPO_REGISTRO_ID= nom.SUBTIPO_REGISTRO_ID\n"
            + "inner join Remetfu.REM_ANALISTA ana1\n"
            + "on tre.ANALISTA_ANTES=ana1.ANALISTA_ID\n"
            + "inner join Remetfu.REM_ANALISTA ana2\n"
            + "on tre.ANALISTA_DESPUES=ana2.ANALISTA_ID\n"
            + "inner join Remetfu.REM_USUARIOS us1\n"
            + "on ana1.USUARIO_ID=us1.USUARIO_ID\n"
            + "inner join Remetfu.REM_USUARIOS us2\n"
            + "on ana2.USUARIO_ID=us2.USUARIO_ID\n"
            + "inner join Remetfu.REM_USUARIOS us3\n"
            + "on tre.USUARIO_REASIGNACION=us3.NRO_IDENTIFICACION\n"
            + "inner join Remetfu.REM_USUARIOS us4\n"
            + "on rp.USUARIO_ID=us4.USUARIO_ID\n"
            + "where (rp.REGISTRO_PROFESIONAL_ID =:nroRegistro or :nroRegistro=0"
            + " and (tre.FECHA_REASIGNACION between convert(date,:fechaInicio) and convert(date,:fechaFin) or isnull(:fechaInicio,'')='' or isnull(:fechaFin,'')='')"
            + " and (tre.ANALISTA_ANTES=:analistaAntes or :analistaAntes=0)"
            + " and (tre.ANALISTA_DESPUES=:analistaDespues or :analistaDespues=0)"
            + " and (us3.USUARIO_ID=:usuarioId or :usuarioId=0)"
            + " and (us4.NRO_IDENTIFICACION=:nroIdentificacion or :nroIdentificacion='')"
            + ") ", nativeQuery = true)
        List<String> obtenerDatosReasignaciones(
            @Param("nroRegistro") Long nroRegistro,                //nro de Registro
            @Param("fechaInicio") String fechaInicio,              //Fecha de inicio de Registros
            @Param("fechaFin") String fechaFin,                    //Fecha de Fin de Registro
            @Param("analistaAntes") Long analistaAntes,            //Analista Antes
            @Param("analistaDespues") Long analistaDespues,        //Analista Despues
            @Param("usuarioId") Long usuarioId,                    //Usuario Asigna
            @Param("nroIdentificacion") String nroIdentificacion); //Contribuyente

}
