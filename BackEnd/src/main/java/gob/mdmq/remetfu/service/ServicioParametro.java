/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemParametros;
import gob.mdmq.remetfu.repository.ParametroRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioParametro {
    @Autowired
    private ParametroRepository parametroRepository;
    
    public Optional<RemParametros> obtenerById(Long id){
        try {
            return parametroRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<RemParametros> obtenerParametroById(){
        try {
            return parametroRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public RemParametros crearUpdate(RemParametros remParametro){
        try {
            return parametroRepository.save(remParametro);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String obtenerParametro(Long codigo) {
        try {
            return parametroRepository.obtenerParametro(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
