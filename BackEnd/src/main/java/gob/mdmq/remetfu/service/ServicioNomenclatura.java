/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.repository.NomenclaturaRepository;
import gob.mdmq.remetfu.repository.RegistroProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author omaldonado
 */
@EnableTransactionManagement
@Service
public class ServicioNomenclatura {

    @Autowired
    private NomenclaturaRepository nomenclaturaRepository;

    @Autowired
    private RegistroProfesionalRepository registroProfesionalRepository;

    public Long obtenerSecuencialTemp(Long subTipoRegistro) {
        Long secuencialTmp = Long.parseLong("-1");
        try {
            secuencialTmp = nomenclaturaRepository.obtenerSecuencialNomenclatura(subTipoRegistro);
            return secuencialTmp;
        } catch (Exception e) {
            e.printStackTrace();
            return secuencialTmp;
        }

    }

    public Long obtenerSecuencialFinal(Long subTipoRegistro) {
        Long secuencialTmp = Long.parseLong("-1");
        try {
            secuencialTmp = nomenclaturaRepository.obtenerSecuencialFinalNomenclatura(subTipoRegistro);
            return secuencialTmp;
        } catch (Exception e) {
            e.printStackTrace();
            return secuencialTmp;
        }

    }

    public boolean actualizaSecuencialTemp(Long secuencial, Long subTipoRegistro, Long usuarioId, Long registroProfesionalId) {
        boolean resultado = false;
        try {
            nomenclaturaRepository.actualizarSecuencialTemp(secuencial, subTipoRegistro);
            if (actualizaTempProfesional(secuencial, subTipoRegistro, usuarioId,registroProfesionalId)) {
                return resultado = true;
            } else {
                return resultado = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return resultado;
        }

    }

    public boolean actualizaSecuencialNomenclaturaTemp(Long secuencial, Long subTipoRegistro) {
        boolean resultado = false;
        try {
            nomenclaturaRepository.actualizarSecuencialTemp(secuencial, subTipoRegistro);
            return resultado = true;

        } catch (Exception e) {
            e.printStackTrace();
            return resultado;
        }

    }
    
    public boolean actualizaTempProfesional(Long secuencial, Long subTipoRegistro, Long usuarioId,  Long registroProfesionalId) {
        boolean resultado = false;
        try {
            registroProfesionalRepository.actualizarSecuencialTemp(secuencial, subTipoRegistro, usuarioId,   registroProfesionalId);
            return resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            return resultado;
        }

    }

    public boolean actualizaSecuencialFinal(Long secuencial, Long subTipoRegistro, Long usuarioId) {
        boolean resultado = false;
        try {
            nomenclaturaRepository.actualizarSecuencialFinal(secuencial, subTipoRegistro);
            if (actualizaSecuencialFinalProfesional(secuencial, subTipoRegistro, usuarioId)) {
                return resultado = true;
            } else {
                return resultado = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return resultado;
        }

    }

    public boolean actualizaSecuencialFinalProfesional(Long secuencial, Long subTipoRegistro, Long usuarioId) {
        boolean resultado = false;
        try {
            registroProfesionalRepository.actualizarSecuencialFinal(secuencial, subTipoRegistro, usuarioId);
            return resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            return resultado;
        }

    }

}
