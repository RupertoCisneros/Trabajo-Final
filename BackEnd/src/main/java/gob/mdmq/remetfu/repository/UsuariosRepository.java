/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.dto.DtoUsuarioAnalista;
import gob.mdmq.remetfu.dto.DtoUsuarioPerfil;
import gob.mdmq.remetfu.dto.DtoUsuarios;
import java.util.Date;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author srcisnerosv
 */
public interface UsuariosRepository extends JpaRepository<RemUsuarios, Long> {

    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoUsuarioAnalista(ru.usuarioId, trim(ru.nroIdentificacion), ru.denominacion, ru.estado) "
            + "from RemUsuarios ru, RemUsuarioPerfil rup, RemPerfil rp "
            + "where ru.usuarioId = rup.usuarioId and rup.perfilId = rp.perfilId AND rp.perfilId = 3")
    Set<DtoUsuarioAnalista> getListaAnalistas();

    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoUsuarioAnalista(ru.usuarioId, trim(ru.nroIdentificacion), ru.denominacion, ru.estado) "
            + "from RemUsuarios ru "
            + "where ru.estado = 'ACT' and trim(ru.nroIdentificacion)=trim(:nroIdentificacion)")
    Set<DtoUsuarioAnalista> obtenerByNroIdentificacion(@Param("nroIdentificacion") String nroIdentificacion);

    @Query(value = "select * from [Remetfu].REM_USUARIOS where NRO_IDENTIFICACION = :cedula", nativeQuery = true)
    List<String> obtenerUsuario(@Param("cedula") String cedula);

    @Query(value = "select USUARIO_ID from [Remetfu].REM_USUARIOS where NRO_IDENTIFICACION = :cedula", nativeQuery = true)
    String obtenerUsuarioByCedula(@Param("cedula") String cedula);

    @Query(value = "select US.USUARIO_ID,US.TIPO_IDENTIFICACION,US.NRO_IDENTIFICACION,US.DENOMINACION,US.NOMBRES,US.APELLIDOS,MAIL=ISNULL(US.MAIL,''),RTRIM(US.DIRECCION) DIRECCION,RTRIM(US.TELEFONO) TELEFONO,RTRIM(US.MOVIL) MOVIL,\n"
            + "RTRIM(US.ACEPTACION_MEDIOS) ACEPTACION_MEDIOS,US.ESTADO AS EstadoUsuario,US.CIM,US.USERNAME,US.CLAVE,US.TIPO_USUARIO,TIPO_USUARIODESC=TU.NOMBRE,ADM_ZONAL=ISNULL(US.ADM_ZONAL,0),ADM_ZONALDESC=ISNULL(AZ.NOMBRE,''),US.FECHA_NACIMIENTO,US.NACIONALIDAD,\n"
            + "NACIONALIDADDESC=NA.NOMBRE,GENERO=ISNULL(US.GENERO,0),GENERODESC=ISNULL(GE.NOMBRE,''),MAIL_PERSONAL=ISNULL(US.MAIL_PERSONAL,''),DISCAPACIDAD=TRIM(US.DISCAPACIDAD)\n"
            + "from [Remetfu].rem_usuarios US\n"
            + "left join [Remetfu].REM_CATALOGO TU\n"
            + "ON US.TIPO_USUARIO=TU.CATALOGO_ID AND TU.TIPO_CATALOGO_ID=30\n"
            + "left join [Remetfu].REM_CATALOGO AZ\n"
            + "ON US.ADM_ZONAL=AZ.CATALOGO_ID AND AZ.TIPO_CATALOGO_ID=3\n"
            + "left join [Remetfu].REM_CATALOGO NA\n"
            + "ON US.NACIONALIDAD=NA.CATALOGO_ID AND NA.TIPO_CATALOGO_ID=2\n"
            + "left join [Remetfu].REM_CATALOGO GE\n"
            + "ON US.GENERO=GE.CATALOGO_ID AND GE.TIPO_CATALOGO_ID=34\n"
            + "WHERE US.NRO_IDENTIFICACION =:nroIdentificacion ", nativeQuery = true)
    List<String> obtenerDatosUsuario(@Param("nroIdentificacion") String nroIdentificacion);

    @Query("Select u from RemUsuarios u where u.nroIdentificacion = :nroIdentificacion")
    RemUsuarios obtenerByCedula(@Param("nroIdentificacion") String nroIdentificacion);

    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoUsuarios(ru.usuarioId, trim(ru.nroIdentificacion), ru.denominacion) "
            + "from RemUsuarios ru"
            + " join ru.remAnalisistaSet ana"
            + " where trim(ru.denominacion) like '%'+ trim(:nombre) +'%'")
    Set<DtoUsuarios> obtenerUsuariosNombresAnalistas(@Param("nombre") String nombre);
    
        @Query("SELECT new  gob.mdmq.remetfu.dto.DtoUsuarios(ru.usuarioId, trim(ru.nroIdentificacion), ru.denominacion) "
            + "from RemUsuarios ru"
            + " where trim(ru.denominacion) like '%'+ trim(:nombre) +'%'")
    Set<DtoUsuarios> obtenerUsuariosNombres(@Param("nombre") String nombre);

    @Modifying
    @Query("update RemUsuarios usu set usu.username = :userName , usu.ssoId = :ssoId , usu.mail = :mail where usu.usuarioId = :usuarioId ")
    void actualizaUsuarioKeyCloack(@Param("usuarioId") Long usuarioId, @Param("userName") String userName, @Param("ssoId") String ssoId, @Param("mail") String mail);

    @Modifying
    @Query("update RemUsuarios usu set usu.mailPersonal = :mailPersonal , usu.direccion = :direccion , usu.movil = :movil , usu.telefono = :telefono  where usu.usuarioId = :usuarioId ")
    void actualizaUsuarioPAM(@Param("usuarioId") Long usuarioId, @Param("mailPersonal") String mailPersonal, @Param("direccion") String direccion, @Param("movil") String movil, @Param("telefono") String telefono);

    @Query("select usr from RemUsuarios usr inner join usr.remUsuarioPerfilSet up where up.perfilId.perfilId =8 and usr.nroIdentificacion = :cedula")
    RemUsuarios obtenerUsuarioUBA(@Param("cedula") String cedula);

    @Query("SELECT new  gob.mdmq.remetfu.dto.DtoUsuarioPerfil("
            + "ru.usuarioId,"
            + "trim(ru.nroIdentificacion),"
            + "trim(ru.username),"
            + "trim(ru.denominacion),"
            + "trim(ru.ssoId),"
            + "trim(ru.estado),"
            + "trim(rp.nombre),"
            + "trim(ru.mail))"
            + "from RemUsuarios ru, RemUsuarioPerfil rup, RemPerfil rp "
            + "where ru.usuarioId = rup.usuarioId and rup.perfilId = rp.perfilId AND rp.perfilId != 7")
    List<DtoUsuarioPerfil> obtenerListaUsuarios();
    
    
    @Modifying
    @Query("update RemUsuarios usu set usu.estado = :estado where usu.usuarioId = :usuarioId ")
    void inactivarOActivarUsuario(@Param("usuarioId") Long usuarioId,@Param("estado") String estado);

}
