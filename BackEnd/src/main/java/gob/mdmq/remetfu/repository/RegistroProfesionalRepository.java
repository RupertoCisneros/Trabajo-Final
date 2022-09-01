/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemRegistroProfesional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface RegistroProfesionalRepository extends JpaRepository<RemRegistroProfesional, Long> {

    @Query(value = "select US.USUARIO_ID,US.TIPO_IDENTIFICACION,NRO_IDENTIFICACION=trim(US.NRO_IDENTIFICACION),DENOMINACION=RTRIM(US.DENOMINACION),MAIL_PERSONAL=RTRIM(US.MAIL_PERSONAL),DIRECCION=RTRIM(US.DIRECCION),US.TELEFONO,US.MOVIL,\n"
            + "US.ACEPTACION_MEDIOS,US.ESTADO AS EstadoUsuario,US.CIM,US.CLAVE,US.TIPO_USUARIO,TIPO_USUARIODESC=TU.NOMBRE,ADM_ZONAL=ISNULL(US.ADM_ZONAL,0),ADM_ZONALDESC=ISNULL(AZ.NOMBRE,''),US.FECHA_NACIMIENTO,NACIONALIDAD=ISNULL(US.NACIONALIDAD,0),\n"
            + "NACIONALIDADDESC=ISNULL(NA.NOMBRE,''),ISNULL(US.GENERO,0),GENERODESC=ISNULL(GE.NOMBRE,''),US.DISCAPACIDAD,RP.REGISTRO_PROFESIONAL_ID,RP.VISA_TRABAJO,RP.BARRIO,RP.CALLE_PRINCIPAL,RP.CALLE_NUMERO,\n"
            + "RP.CALLE_SECUNDARIA,RP.CALLE_REFERENCIA1,RP.CALLE_REFERENCIA2,RP.ESTADO as EstadoRegistroProfesional,RP.AGREMIADO,RP.NOMBRE_GREMIO,RP.FECHA_INACTIVO,DIAS_INACTIVO=ISNULL(RP.DIAS_INACTIVO,0),\n"
            + "RP.SECUENCIAL_TMP,RP.SECUENCIAL_FINAL,RP.ACUERDO_RESPONSABILIDAD,RP.SUBTIPO_REGISTRO_ID,ST.DESCRIPCION,RP.PARROQUIA,PARROQUIADESC=PARR.NOMBRE,\n"
            + "PA.FECHA_REGISTRO as FechaPerfilAcademico,DOCUMENTO_ACREDITA=ISNULL(PA.DOCUMENTO_ACREDITA,''),PERFIL_ACADEMICO=ISNULL(PA.CATALOGO_ID,''),PERFIL_ACADEMICODESC=ISNULL(PAC.NOMBRE,''),TP.NRO_REGISTRO,TP.FECHA_REGISTRO as FechaTitulo,TP.NOMBRE_TITULO,TP.INSTITUCION_TITULO,\n"
            + "TP.NIVEL_TITULO,TP.TIPO_TITULO,TP.RECONOCIDO_POR,NOMBRES=ISNULL(US.NOMBRES,''),APELLIDOS=ISNULL(US.APELLIDOS,''),\n"
            + "TRP.FECHA_ASIGNA,TRP.FECHA_VIGENCIA,FECHA_RECHAZO=ISNULL(TRP.FECHA_RECHAZO,'1995-01-01 00:00:00'),FECHA_APROBACION=ISNULL(TRP.FECHA_APROBACION,'1995-01-01 00:00:00'),FECHA_DEVOLUCION=ISNULL(TRP.FECHA_DEVOLUCION,'1995-01-01 00:00:00'),NOVEDAD_APROBACION=ISNULL(TRP.NOVEDAD_APROBACION,''),MOTIVO_DEVOLUCION=ISNULL(TRP.MOTIVO_DEVOLUCION,''),MOTIVO_RECHAZO=ISNULL(TRP.MOTIVO_RECHAZO,''),\n"
            + "nroRegistro=case when TRP.estado=223 or TRP.estado=224 or TRP.estado=225 or TRP.estado=226 or TRP.estado=227 or TRP.estado=228 or TRP.estado=229 then concat(nom.nomenclatura_Tmp,'-',convert(varchar,year(rp.fecha_Creacion)),'-',\n"
            + "concat(replicate('0',convert(varchar,nom.numero_Digitos-len(rp.secuencial_Tmp))),convert(varchar,rp.secuencial_Tmp)))\n"
            + "else concat(nom.nomenclatura_Final,'-',convert(varchar,year(rp.fecha_Creacion)),'-',\n"
            + "concat(replicate('0',convert(varchar,nom.numero_Digitos-len(rp.secuencial_Final))),convert(varchar,rp.secuencial_Final))) end,\n"
            + "MAIL=ISNULL(US.MAIL,''),\n"
            + "estadoRegistro=case when TRP.estado=223 or TRP.estado=224 or TRP.estado=225 or TRP.estado=229 or TRP.estado=230 then '0' when TRP.estado=227 Then 'Su registro se encuentra rechazado por: ' + isnull(TRP.MOTIVO_RECHAZO,'') when TRP.estado=228 then 'Su registro se encuentra rechazado por: ' +  isnull(TRP.MOTIVO_DEVOLUCION,'') when TRP.estado=226 then 'Registro aprobado, novedad: ' +  isnull(TRP.NOVEDAD_APROBACION,'') end\n"
            + "from Remetfu.rem_usuarios US\n"
            + "left join Remetfu.REM_CATALOGO TU\n"
            + "ON US.TIPO_USUARIO=TU.CATALOGO_ID AND TU.TIPO_CATALOGO_ID=30\n"
            + "left join Remetfu.REM_CATALOGO AZ\n"
            + "ON US.ADM_ZONAL=AZ.CATALOGO_ID AND AZ.TIPO_CATALOGO_ID=3\n"
            + "left join Remetfu.REM_CATALOGO NA\n"
            + "ON US.NACIONALIDAD=NA.CATALOGO_ID AND NA.TIPO_CATALOGO_ID=2\n"
            + "left join Remetfu.REM_CATALOGO GE\n"
            + "ON US.GENERO=GE.CATALOGO_ID AND GE.TIPO_CATALOGO_ID=34\n"
            + "LEFT JOIN Remetfu.REM_REGISTRO_PROFESIONAL RP\n"
            + "ON US.USUARIO_ID=RP.USUARIO_ID\n"
            + "JOIN Remetfu.REM_SUBTIPO_REGISTRO ST\n"
            + "ON RP.SUBTIPO_REGISTRO_ID=ST.SUBTIPO_REGISTRO_ID\n"
            + "left join Remetfu.REM_CATALOGO PARR\n"
            + "ON RP.PARROQUIA=PARR.CATALOGO_ID AND PARR.TIPO_CATALOGO_ID=4\n"
            + "LEFT join Remetfu.REM_PERFIL_ACADEMICO PA\n"
            + "ON RP.REGISTRO_PROFESIONAL_ID=PA.REGISTRO_PROFESIONAL_ID\n"
            + "LEFT join Remetfu.REM_CATALOGO PAC\n"
            + "ON PA.CATALOGO_ID=PAC.CATALOGO_ID AND PAC.TIPO_CATALOGO_ID=8\n"
            + "LEFT join Remetfu.REM_TITULO_PROFESIONAL TP\n"
            + "ON RP.REGISTRO_PROFESIONAL_ID=TP.REGISTRO_PROFESIONAL_ID\n"
            + "LEFT join Remetfu.REM_ANALISIS_TRAMITE_REGISTRO_PROFESIONAL TRP\n"
            + "on trp.REGISTRO_PROFESIONAL_ID = RP.REGISTRO_PROFESIONAL_ID\n"
            + "LEFT join Remetfu.REM_NOMENCLATURA NOM\n"
            + "on RP.SUBTIPO_REGISTRO_ID = NOM.SUBTIPO_REGISTRO_ID\n"
            + "WHERE trp.REGISTRO_PROFESIONAL_ID =:id", nativeQuery = true)
    List<String> obtenerPdf(@Param("id") Long id);

    @Query(value = "IF EXISTS(SELECT 1 FROM [Remetfu].[REM_REGISTRO_PROFESIONAL] RP \n"
            + "                        INNER JOIN [Remetfu].[REM_USUARIOS] US\n"
            + "						ON RP.USUARIO_ID=US.USUARIO_ID\n"
            + "                        WHERE RP.ESTADO NOT IN(227) AND US.NRO_IDENTIFICACION =:nroIdentificacion AND RP.SUBTIPO_REGISTRO_ID=:subtipoRegistro)\n"
            + "   SELECT 'Estimado usuario Ud. ya tiene un Trámite de: '+SR.DESCRIPCION+' en estado: '+CAT.NOMBRE\n"
            + "   FROM [Remetfu].[REM_REGISTRO_PROFESIONAL] RP\n"
            + "   INNER JOIN [Remetfu].[REM_USUARIOS] US\n"
            + "   ON RP.USUARIO_ID=US.USUARIO_ID\n"
            + "   INNER JOIN [Remetfu].[REM_SUBTIPO_REGISTRO] SR\n"
            + "   ON RP.SUBTIPO_REGISTRO_ID=SR.SUBTIPO_REGISTRO_ID\n"
            + "   INNER JOIN [Remetfu].[REM_CATALOGO] CAT\n"
            + "   ON RP.ESTADO=CAT.CATALOGO_ID AND CAT.TIPO_CATALOGO_ID=31\n"
            + "   WHERE RP.ESTADO NOT IN(227) AND US.NRO_IDENTIFICACION=:nroIdentificacion\n"
            + "   AND RP.SUBTIPO_REGISTRO_ID=:subtipoRegistro\n"
            + "ELSE\n"
            + "   SELECT 'OK'", nativeQuery = true)
    List<String> validarIngreso(@Param("nroIdentificacion") String nroIdentificacion, @Param("subtipoRegistro") Long subtipoRegistro);

    @Query(value = "IF NOT EXISTS(SELECT 1 FROM [Remetfu].[REM_REGISTRO_PROFESIONAL] RP \n"
            + "                        INNER JOIN [Remetfu].[REM_USUARIOS] US\n"
            + "						ON RP.USUARIO_ID=US.USUARIO_ID\n"
            + "                        WHERE RP.ESTADO IN(230) AND US.NRO_IDENTIFICACION =:nroIdentificacion AND RP.SUBTIPO_REGISTRO_ID = 2)\n"
            + "   SELECT 'Para proceder con el registro del microchip de los animales de compañía, usted debe estar registrado como Veterinario LEGALIZADO dentro del Sistema'\n"
            + "ELSE\n"
            + "   SELECT 'OK'", nativeQuery = true)
    List<String> validarIngresoPagado(@Param("nroIdentificacion") String nroIdentificacion);

    @Modifying
    @Query("update RemRegistroProfesional rp set rp.secuencialTmp = :secuencialTemporal where rp.subtipoRegistroId.subtipoRegistroId = :subTipoRegistro and rp.usuarioId.usuarioId = :usuarioId and rp.registroProfesionalId = :registroProfesionalId ")
    void actualizarSecuencialTemp(@Param("secuencialTemporal") Long secuencialTemporal, @Param("subTipoRegistro") Long subTipoRegistro, @Param("usuarioId") Long usuarioId, @Param("registroProfesionalId") Long registroProfesionalId);

    @Modifying
    @Query("update RemRegistroProfesional rp set rp.secuencialFinal = :secuencialFinal where rp.subtipoRegistroId.subtipoRegistroId = :subTipoRegistro and rp.usuarioId.usuarioId = :usuarioId ")
    void actualizarSecuencialFinal(@Param("secuencialFinal") Long secuencialTemporal, @Param("subTipoRegistro") Long subTipoRegistro, @Param("usuarioId") Long usuarioId);

//    @Query("Select rp from RemRegistroProfesional rp where rp.registroProfesionalId = :registroProfesionalId ")
//    RemRegistroProfesional obtenerArchivoRegistroProfesional(@Param("registroProfesionalId") Long registroProfesionalId);

    @Query("Select rp from RemRegistroProfesional rp where rp.usuarioId.usuarioId = :usuarioId and rp.subtipoRegistroId.subtipoRegistroId = 2 and rp.estado.catalogoId =230")
    RemRegistroProfesional obtenerRegistroProfesionalMicroChip(@Param("usuarioId") Long usuarioId);
}
