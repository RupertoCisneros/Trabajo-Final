/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemRetiroAnimales;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oportero
 */
public interface RetiroAnimalesRepository extends JpaRepository<RemRetiroAnimales, Long> {
    
}
