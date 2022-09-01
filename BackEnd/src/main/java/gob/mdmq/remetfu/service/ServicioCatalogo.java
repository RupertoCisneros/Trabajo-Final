/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.dto.DtoCatalogo;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioCatalogo {
    
   
    @Autowired
    private CatalogoRepository catalogoRepository;
    
     public List<DtoCatalogo> obtenerListaCatalogo() {
         try {
               return catalogoRepository.obtenerListaCatalogo();
         } catch (Exception e) {
             return null;
         }
      
    }
    
     public List<DtoCatalogo> obtenerListaCatalogos() {
         try {
               return catalogoRepository.obtenerListaCatalogos();
         } catch (Exception e) {
             return null;
         }
      
    }
     public Optional<RemCatalogo> obtenerById(Long id){
       
         try {
              return catalogoRepository.findById(id);
         } catch (Exception e) {
              return null;
         }
     }
     
     public List<DtoCatalogo> obtenerCatalogoById(Long id){
       
         try {
             return catalogoRepository.obtenerCatalogoById(id);
         } catch (Exception e) {
             return null;
         }
     }
    public Boolean creaUpdate(RemCatalogo remCatalogo){
        try {
            Date fechaCreacion = new Date();
            remCatalogo.setFechaCreacion(fechaCreacion);
            catalogoRepository.save(remCatalogo);
            return true;
        } catch (Exception e) {
            return false;
        }
       }
     public Boolean eliminarCatalogo(Long catalogoId){
        try {
            catalogoRepository.deleteById(catalogoId);
            return true;
        } catch (Exception e) {
            return false;
        }
       }
    
}
