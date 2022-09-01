/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemTipoCatalogo;
import gob.mdmq.remetfu.dto.DtoTipoCatalogo;
import gob.mdmq.remetfu.repository.TipoCatalogoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioTipoCatalogo {

    @Autowired
    private TipoCatalogoRepository tipoCatalogoRepository;

    public List<DtoTipoCatalogo> obtenerListaTipoCatalogo() {
        try {
            return tipoCatalogoRepository.obtenerListaTipoCatalogo();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public Optional<RemTipoCatalogo> obtenerById(Long id) {
        try {
            return tipoCatalogoRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<DtoTipoCatalogo> obtenerListaTipoCatalogoById(Long id) {
        try {
            return tipoCatalogoRepository.obtenerListaTipoCatalogoById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RemTipoCatalogo creaUpdate(RemTipoCatalogo remTipoCatalogo) {
        try {
            return tipoCatalogoRepository.save(remTipoCatalogo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
