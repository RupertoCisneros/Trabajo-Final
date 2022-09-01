/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemPerfil;
import gob.mdmq.remetfu.dto.DtoPerfil;
import gob.mdmq.remetfu.repository.PerfilRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ruper
 */
@Service
public class ServicioPerfiles {
    
    @Autowired
    private PerfilRepository perfilRepository;
    
     public List<RemPerfil> obtener() {
         try {
             return (List<RemPerfil>) perfilRepository.findAll();
         } catch (Exception e) {
             return (List<RemPerfil>) perfilRepository.findAll();
         }
    }

    
     
     
     public Set<DtoPerfil> obtenerPerfiles(){
         try {
              return perfilRepository.obtenerPerfiles();
         } catch (Exception e) {
              return perfilRepository.obtenerPerfiles();
         }
     }
     
     
      public RemPerfil obtenerPerfilById(Long id){
         try {
              return  perfilRepository.obtenerPerfilById(id);
         } catch (Exception e) {
              return  null;
         }
    }
     
     
}
