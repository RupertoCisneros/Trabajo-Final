/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemAnimalTutor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface AnimalTutorRepository extends JpaRepository<RemAnimalTutor, Long> {

    @Query(value = "SELECT ANIMAL_TUTOR_ID,\n"
            + "NRO_REGISTRO=case when ANT.estado=223 or ANT.estado=224 or ANT.estado=225 or ANT.estado=226 or ANT.estado=227 or ANT.estado=228 or ANT.estado=229 then \n"
            + "concat(nom.nomenclatura_Tmp,'-',convert(varchar,year(ANT.FECHA_REGISTRO)),'-',\n"
            + "concat(replicate('0',convert(varchar,NOM.NUMERO_DIGITOS-len(ANT.secuencial_Tmp))),convert(varchar,ANT.secuencial_Tmp)))\n"
            + "else concat(nom.nomenclatura_Final,'-',convert(varchar,year(ANT.fecha_Creacion)),'-',\n"
            + "concat(replicate('0',convert(varchar,NOM.NUMERO_DIGITOS-len(ANT.secuencial_Final))),convert(varchar,ANT.secuencial_Final))) end,\n"
            + "ANT.SECUENCIAL_TMP,ANT.SECUENCIAL_FINAL,ANT.TUTOR_ID,US.DENOMINACION,US.NOMBRES,US.APELLIDOS,NRO_IDENTIFICACION=RTRIM(US.NRO_IDENTIFICACION),NACIONALIDAD=ISNULL(NAC.NOMBRE,''),\n"
            + "DIRECCION=RTRIM(US.DIRECCION),MOVIL=RTRIM(US.MOVIL),TELEFONO=RTRIM(US.TELEFONO),US.MAIL,US.MAIL_PERSONAL,COMUNITARIO,ESTADO_TUTORIA,ESTADO_TUTORIA_NOMBRE=ISNULL(ETU.NOMBRE,''),\n"
            + "PROCEDENCIA_ANIMAL,PROCEDENCIA_ANIMAL_NOMBRE=ISNULL(PRO.NOMBRE,''),MICROCHIP_MASCOTA_ID=ISNULL(MICROCHIP_MASCOTA_ID,''),OBSERVACION_MICROCHIP,NOMBRE_ANIMAL,\n"
            + "ANT.FECHA_NACIMIENTO,ESPECIE,ESPECIE_NOMBRE=ISNULL(ESP.NOMBRE,''),RAZA,RAZA_NOMBRE=ISNULL(RAZ.NOMBRE,''),\n"
            + "SEXO,SEXO_NOMBRE=ISNULL(SEX.NOMBRE,''),ESTADO_REPRODUCTIVO,ESTADO_REPRODUCTIVO_NOMBRE=ISNULL(ERE.NOMBRE,''),\n"
            + "COLOR_PREDOMINANTE,COLOR_PREDOMINANTE_NOMBRE=ISNULL(COP.NOMBRE,''),COLOR_SECUNDARIO,COLOR_SECUNDARIO_NOMBRE=ISNULL(COSE.NOMBRE,''),\n"
            + "SENIALES_PARTICULARES=ISNULL(SENIALES_PARTICULARES,''),IDENTIFICACION_FOTOGRAFICA1,IDENTIFICACION_FOTOGRAFICA2,IDENTIFICACION_VISIBLE,\n"
            + "PERMANENCIA,PERMANENCIA_NOMBRE=ISNULL(PER.NOMBRE,''),PERMANENCIA_OTROS=ISNULL(PERMANENCIA_OTROS,''),\n"
            + "PARROQUIA,PARROQUIA_NOMBRE=ISNULL(PAR.NOMBRE,''),BARRIO,CALLE_PRINCIPAL,CALLE_NUMERO,CALLE_SECUNDARIA,\n"
            + "CALLE_REFERENCIA1,CALLE_REFERENCIA2,TIPO_VIVIENDA,TIPO_VIVIENDA_NOMBRE=ISNULL(TIV.NOMBRE,''),\n"
            + "MT2_VIVIENDA,MT2_PERMANENCIA,CERRAMIENTO,ESTATUS_VIVIENDA,ESTATUS_VIVIENDA_NOMBRE=ISNULL(ESV.NOMBRE,''),\n"
            + "ESTATUS_VIVIENDA_OTROS=ISNULL(ESTATUS_VIVIENDA_OTROS,''),ENFERMEDAD_CATASTROFICA,\n"
            + "DESCRIPCION_ENFERMEDAD=ISNULL(DESCRIPCION_ENFERMEDAD,''),EXAMEN_COMPORTAMENTAL,\n"
            + "PRUEBA_COMPORTAMIENTO=ISNULL(PRUEBA_COMPORTAMIENTO,''),PRUEBA_COMPORTAMIENTO_NOMBRE=ISNULL(PCO.NOMBRE,''),EXAMEN_COMPORTAMENTAL_ARCHIVO,\n"
            + "EXAMEN_FISICO,CERTIFICADO_VACUNACION,CERTIFICADO_VACUNACION_ARCHIVO,CERTIFICADO_ESTERILIZACION,CERTIFICADO_ESTERILIZACION_ARCHIVO,\n"
            + "FECHA_FALLECIMIENTO=ISNULL(FECHA_FALLECIMIENTO,''),MOTIVO_FALLECIMIENTO=ISNULL(MOTIVO_FALLECIMIENTO,0),MOTIVO_FALLECIMIENTO_NOMBRE=ISNULL(MFA.NOMBRE,''),\n"
            + "ACUERDO_RESPONSABILIDAD,FECHA_REGISTRO,ANT.ESTADO,ESTADO_NOMBRE=ISNULL(EST.NOMBRE,''),EDAD=DATEDIFF(Y,ant.FECHA_NACIMIENTO,getdate())\n"
            + "FROM Remetfu.REM_ANIMAL_TUTOR ANT\n"
            + "INNER JOIN Remetfu.REM_TUTOR_MASCOTA TM\n"
            + "ON ANT.TUTOR_ID=TM.TUTOR_ID\n"
            + "INNER JOIN Remetfu.REM_USUARIOS US\n"
            + "ON TM.USUARIO_ID=US.USUARIO_ID\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO ETU\n"
            + "ON ANT.ESTADO_TUTORIA=ETU.CATALOGO_ID AND ETU.TIPO_CATALOGO_ID=36\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO PRO\n"
            + "ON ANT.PROCEDENCIA_ANIMAL=PRO.CATALOGO_ID AND PRO.TIPO_CATALOGO_ID=16\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO ESP\n"
            + "ON ANT.ESPECIE=ESP.CATALOGO_ID AND ESP.TIPO_CATALOGO_ID=14\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO RAZ\n"
            + "ON ANT.RAZA=RAZ.CATALOGO_ID AND RAZ.TIPO_CATALOGO_ID=22\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO SEX\n"
            + "ON ANT.SEXO=SEX.CATALOGO_ID AND SEX.TIPO_CATALOGO_ID=38\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO ERE\n"
            + "ON ANT.ESTADO_REPRODUCTIVO=ERE.CATALOGO_ID AND ERE.TIPO_CATALOGO_ID=17\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO COP\n"
            + "ON ANT.COLOR_PREDOMINANTE=COP.CATALOGO_ID AND COP.TIPO_CATALOGO_ID=23\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO COSE\n"
            + "ON ANT.COLOR_SECUNDARIO=COSE.CATALOGO_ID AND COSE.TIPO_CATALOGO_ID=24\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO PER\n"
            + "ON ANT.PERMANENCIA=PER.CATALOGO_ID AND PER.TIPO_CATALOGO_ID=13\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO PAR\n"
            + "ON ANT.PARROQUIA=PAR.CATALOGO_ID AND PAR.TIPO_CATALOGO_ID=4\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO TIV\n"
            + "ON ANT.TIPO_VIVIENDA=TIV.CATALOGO_ID AND TIV.TIPO_CATALOGO_ID=7\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO ESV\n"
            + "ON ANT.ESTATUS_VIVIENDA=ESV.CATALOGO_ID AND ESV.TIPO_CATALOGO_ID=6\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO PCO\n"
            + "ON ANT.PRUEBA_COMPORTAMIENTO=PCO.CATALOGO_ID AND PCO.TIPO_CATALOGO_ID=18\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO MFA\n"
            + "ON ANT.MOTIVO_FALLECIMIENTO=MFA.CATALOGO_ID AND MFA.TIPO_CATALOGO_ID=26\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO EST\n"
            + "ON ANT.ESTADO=EST.CATALOGO_ID AND EST.TIPO_CATALOGO_ID=31\n"
            + "LEFT JOIN Remetfu.REM_CATALOGO NAC\n"
            + "ON US.NACIONALIDAD=NAC.CATALOGO_ID AND NAC.TIPO_CATALOGO_ID=2\n"
            + "LEFT JOIN Remetfu.REM_NOMENCLATURA NOM\n"
            + "ON NOM.SUBTIPO_REGISTRO_ID=26 where ANIMAL_TUTOR_ID =:animalTutorId", nativeQuery = true)
    List<String> obtenerDatosAnimalTutor(@Param("animalTutorId") Long animalTutorId);

}