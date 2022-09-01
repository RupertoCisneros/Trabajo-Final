/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemNomenclatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author omaldonado
 */
public interface NomenclaturaRepository extends JpaRepository<RemNomenclatura, Long> {

    @Query("Select n.secuencialTmp from RemNomenclatura n inner join n.subtipoRegistroId st where st.subtipoRegistroId = :idSubTipoRegistro")
    Long obtenerSecuencialNomenclatura(@Param("idSubTipoRegistro") Long idSubTipoRegistro);

    @Modifying
    @Query("update RemNomenclatura n set n.secuencialTmp = :secuencialTemporal where n.subtipoRegistroId.subtipoRegistroId = :subTipoRegistro")
    void actualizarSecuencialTemp(@Param("secuencialTemporal") Long secuencialTemporal, @Param("subTipoRegistro") Long subTipoRegistro);

    @Query("Select n.secuencialFinal from RemNomenclatura n inner join n.subtipoRegistroId st where st.subtipoRegistroId = :idSubTipoRegistro")
    Long obtenerSecuencialFinalNomenclatura(@Param("idSubTipoRegistro") Long idSubTipoRegistro);

    @Modifying
    @Query("update RemNomenclatura n set n.secuencialFinal = :secuencialFinal where n.subtipoRegistroId.subtipoRegistroId = :subTipoRegistro")
    void actualizarSecuencialFinal(@Param("secuencialFinal") Long secuencialTemporal, @Param("subTipoRegistro") Long subTipoRegistro);

}
