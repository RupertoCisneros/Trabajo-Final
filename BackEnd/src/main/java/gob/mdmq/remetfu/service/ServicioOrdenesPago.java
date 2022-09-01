/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemOrdenesPago;
import gob.mdmq.remetfu.repository.OrdenesPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioOrdenesPago {
    
    @Autowired
    private OrdenesPagoRepository ordenesPagoRepository;
    
    @Transactional
    public boolean guardarOrdenesPagoLocal(RemOrdenesPago remOrdenesPago) {
        boolean respuesta = false;
        try {
            ordenesPagoRepository.save(remOrdenesPago);
            respuesta = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;

    }
        
}
