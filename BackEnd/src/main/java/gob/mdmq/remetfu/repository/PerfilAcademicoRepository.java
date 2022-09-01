/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemPerfilAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author omaldonado
 */
public interface PerfilAcademicoRepository extends JpaRepository<RemPerfilAcademico, Long> {
    
    @Query("Select rp from RemPerfilAcademico rp where rp.registroProfesionalId.registroProfesionalId = :registroProfesionalId ")
    RemPerfilAcademico obtenerArchivoRegistroProfesional(@Param("registroProfesionalId") Long registroProfesionalId);
    
}
