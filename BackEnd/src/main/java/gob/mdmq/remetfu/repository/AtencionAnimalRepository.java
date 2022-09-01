/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package gob.mdmq.remetfu.repository;

import gob.mdmq.remetfu.Entidades.RemAtencionAnimales;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author omaldonado
 */
public interface AtencionAnimalRepository extends CrudRepository<RemAtencionAnimales, Long> {
    
}
