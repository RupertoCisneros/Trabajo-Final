/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemTutorMascota;
import gob.mdmq.remetfu.dto.DtoTutorMascota;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author oportero
 */
public interface TutorMascotaRepository extends JpaRepository<RemTutorMascota, Long> {

    @Query("SELECT new gob.mdmq.remetfu.dto.DtoTutorMascota(tu.tutorId, u.usuarioId, trim(tu.direccion),tu.estado,trim(u.denominacion),trim(u.mailPersonal),trim(u.telefono),trim(u.movil)) from RemTutorMascota tu inner join tu.usuarioId u where tu.estado ='ACT' and u.nroIdentificacion = :nroIdentificacion")
    Set<DtoTutorMascota> obtenerDatosTutorMascota(@Param("nroIdentificacion") String nroIdentificacion);

    @Query(value = "IF EXISTS(SELECT 1 FROM [Remetfu].[REM_TUTOR_MASCOTA] TM \n"
            + "                        INNER JOIN [Remetfu].[REM_USUARIOS] US\n"
            + "						ON TM.USUARIO_ID=US.USUARIO_ID\n"
            + "                        WHERE US.NRO_IDENTIFICACION =:nroIdentificacion)\n"
            + "   SELECT top 1 'Estimado usuario Ud. ya se encuentra registrado como Tutor'\n"
            + "ELSE\n"
            + "   SELECT 'OK'", nativeQuery = true)
    List<String> validarIngresoTutor(@Param("nroIdentificacion") String nroIdentificacion);

    @Query(value = "IF NOT EXISTS(SELECT 1 FROM [Remetfu].[REM_TUTOR_MASCOTA] TM \n"
            + "                        INNER JOIN [Remetfu].[REM_USUARIOS] US\n"
            + "						ON TM.USUARIO_ID=US.USUARIO_ID\n"
            + "                        WHERE US.NRO_IDENTIFICACION =:nroIdentificacion)\n"
            + "   SELECT top 1 'Estimado usuario Ud. debe estar ingresado como Tutor para poder Registrar Animales de Compania'\n"
            + "ELSE\n"
            + "   SELECT 'OK'", nativeQuery = true)
    List<String> validarExisteTutor(@Param("nroIdentificacion") String nroIdentificacion);

    @Query("Select t from RemTutorMascota t where t.usuarioId.usuarioId= :usuarioId")
    RemTutorMascota obtenerTutor(@Param("usuarioId") Long usuarioId);
}
