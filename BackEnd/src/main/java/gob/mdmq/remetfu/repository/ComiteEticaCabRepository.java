/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemComiteEticaCab;
import gob.mdmq.remetfu.dto.DtoComiteEticaCabecera;
import gob.mdmq.remetfu.dto.DtoComiteEticaDetalle;
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
public interface ComiteEticaCabRepository extends JpaRepository<RemComiteEticaCab, Long> {
    
    @Query(value="SELECT \n"
            + "cab.COMITE_ETICA_CAB_ID,NUM_REGISTRO=CASE CAB.ESTADO when 'ACT' THEN concat(nom.nomenclatura_Final,'-',convert(varchar,year(cab.fecha_Registro)),'-',\n"
            + "concat(replicate('0',convert(varchar,nom.numero_Digitos-len(cab.COMITE_ETICA_CAB_ID))),convert(varchar,cab.COMITE_ETICA_CAB_ID))) else \n"
            + "concat(nom.nomenclatura_tmp,'-',convert(varchar,year(cab.fecha_Registro)),'-',\n"
            + "concat(replicate('0',convert(varchar,nom.numero_Digitos-len(cab.COMITE_ETICA_CAB_ID))),convert(varchar,cab.COMITE_ETICA_CAB_ID))) end,"
            + "NOMBRE_INSTITUCION=RTRIM(CAB.NOMBRE_INSTITUCION),FACULTAD_INVESTIGACION=RTRIM(CAB.FACULTAD_INVESTIGACION),FECHA_REGISTRO,\n"
            + "ESTADO=CASE CAB.ESTADO WHEN 'ACT' THEN 'ACTIVO' ELSE 'INACTIVO' END\n"
            + "FROM Remetfu.REM_COMITE_ETICA_CAB CAB,Remetfu.REM_NOMENCLATURA NOM\n"
            + "WHERE NOM.SUBTIPO_REGISTRO_ID=4",nativeQuery = true)
    List<String> obtenerDatosComiteEtica();

    
    @Modifying
    @Query("update RemComiteEticaCab cab set"
            + " cab.estado = :estado,"
            + " cab.usuarioModificacion = :usuarioModificacion,"
            + " cab.terminalModificacion = :terminalModificacion,"
            + " cab.fechaModificacion = :fechaModificacion"
            + " where cab.comiteEticaCabId = :comiteEticaCabId ")
    void actualizarComiteEticaCab(
            @Param("comiteEticaCabId") Long comiteEticaCabId,
            @Param("usuarioModificacion") String usuarioModificacion,
            @Param("terminalModificacion") String terminalModificacion,
            @Param("estado") String estado,
            @Param("fechaModificacion") Date fechaModificacion);

    @Query(value="SELECT \n"
            + "cab.COMITE_ETICA_CAB_ID,NUM_REGISTRO=CASE CAB.ESTADO when 'ACT' THEN concat(nom.nomenclatura_Final,'-',convert(varchar,year(cab.fecha_Registro)),'-',\n"
            + "concat(replicate('0',convert(varchar,nom.numero_Digitos-len(cab.COMITE_ETICA_CAB_ID))),convert(varchar,cab.COMITE_ETICA_CAB_ID))) else \n"
            + "concat(nom.nomenclatura_tmp,'-',convert(varchar,year(cab.fecha_Registro)),'-',\n"
            + "concat(replicate('0',convert(varchar,nom.numero_Digitos-len(cab.COMITE_ETICA_CAB_ID))),convert(varchar,cab.COMITE_ETICA_CAB_ID))) end,"
            + "NOMBRE_INSTITUCION=RTRIM(CAB.NOMBRE_INSTITUCION),FACULTAD_INVESTIGACION=RTRIM(CAB.FACULTAD_INVESTIGACION),FECHA_REGISTRO,\n"
            + "DET.COMITE_ETICA_DET_ID,DET.IDENTIFICACION,DET.NOMBRES,DET.NUMERO_SENECYT,DET.CORREO,DET.TELEFONO,DET.CARGO,CAT.NOMBRE\n"
            + "FROM Remetfu.REM_COMITE_ETICA_CAB CAB\n"
            + "INNER JOIN Remetfu.REM_COMITE_ETICA_DET DET\n"
            + "ON CAB.COMITE_ETICA_CAB_ID=DET.COMITE_ETICA_CAB_ID\n"
            + "INNER JOIN Remetfu.REM_CATALOGO CAT\n"
            + "ON DET.CARGO=CAT.CATALOGO_ID AND CAT.TIPO_CATALOGO_ID=11\n"
            + "INNER JOIN Remetfu.REM_NOMENCLATURA NOM\n"
            + "ON NOM.SUBTIPO_REGISTRO_ID=4\n"
            + "WHERE DET.ESTADO='ACT' AND CAB.COMITE_ETICA_CAB_ID = :comiteEticaCabId",nativeQuery = true)
    List<String> consultaDatosComiteEtica(
    @Param("comiteEticaCabId") Long comiteEticaCabId);

}
