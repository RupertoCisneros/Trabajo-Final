/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.repository.SubtipoRegistroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioSubtipoRegistro {
    @Autowired
    private SubtipoRegistroRepository subtipoRegistroRepository;
    
    public List<RemSubtipoRegistro> obtener() {
        try {
            var ver = subtipoRegistroRepository.findAll();
            return subtipoRegistroRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }
    
    public Optional<RemSubtipoRegistro> obtenerById(Long id){
        try {
            return subtipoRegistroRepository.findById(id);
        } catch (Exception e) {
            return  null;
        }
    }    
    
}
