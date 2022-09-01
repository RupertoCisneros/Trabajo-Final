/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.Entidades.RemTipoRegistro;
import gob.mdmq.remetfu.dto.DtoHijosRegistro;
import gob.mdmq.remetfu.dto.DtoTipoRegistro;
import gob.mdmq.remetfu.repository.ParametroRepository;
import gob.mdmq.remetfu.repository.TipoRegistroRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioTipoRegistro {

    @Autowired
    private TipoRegistroRepository tipoRegistroRepository;

    @Autowired
    private ParametroRepository parametroRepository;

    public List<RemTipoRegistro> obtenerRegistrosTodos() {
        try {
            return tipoRegistroRepository.findAll();
        } catch (Exception e) {
            return tipoRegistroRepository.findAll();
        }
    }

    public Optional<RemTipoRegistro> obtenerById(Long id) {
        try {
            return tipoRegistroRepository.findById(id);
        } catch (Exception e) {
            return tipoRegistroRepository.findById(id);
        }
    }

    public List<DtoTipoRegistro> obtenerTipoRegistro() {

        var registros = tipoRegistroRepository.listaRegistros();
        String ordenanza = parametroRepository.obtenerParametro(Long.parseLong("5"));
        var valorSalarioBasicoC = parametroRepository.obtenerParametro(Long.parseLong("11"));
        Double valorSalarioBasicoN = Double.parseDouble(valorSalarioBasicoC);

        List<DtoTipoRegistro> result = Arrays.asList(new DtoTipoRegistro[registros.size()]);
        List<DtoTipoRegistro> subRegistros = new ArrayList<>();

        for (int i = 0; i < registros.size(); i++) {
            DtoTipoRegistro rp = new DtoTipoRegistro();

            rp.setTipoRegistroId(registros.get(i).getTipoRegistroId());
            rp.setDescripcion(registros.get(i).getDescripcion());

            List<RemSubtipoRegistro> ite = registros.get(i).gethijos();

            List<DtoHijosRegistro> hijosRegistros = new ArrayList<>();

            for (var registroHijos : ite) {

                if (!registros.get(i).getNovedad2().contains("Registrar")) {
                    DtoHijosRegistro registroHijo = new DtoHijosRegistro();

                    registroHijo.setDescripcion(registroHijos.getDescripcion());
                    registroHijo.setSubtipoRegistroId(registroHijos.getSubtipoRegistroId());
                    registroHijo.setTipoFormulario(registroHijos.getTipoFormulario());
                    registroHijo.setAcuerdoResponsabilidad(registroHijos.getNovedad2());
                    if (registroHijos.getTipoFormulario() == 2) {
                        registroHijo.setInformeValorOrdenanza("En caso de que su pre registro sea Aprobado el GAD DMQ en base a la ordenanza NRO. " + ordenanza
                                + " emitirá una orden de pago, por un valor de $" + (valorSalarioBasicoN * registroHijos.getValor1().longValue() / 100.00) + ".");
                    } else if (registroHijos.getValor1().intValue() > 0 && registroHijos.getTipoFormulario() != 2) {
                        registroHijo.setInformeValorOrdenanza("El GAD DMQ en base a la ordenanza NRO. " + ordenanza
                                + " emitirá una orden de pago, por un valor de $" + (valorSalarioBasicoN * registroHijos.getValor1().longValue() / 100.00) + ".");
                    } else {
                        registroHijo.setInformeValorOrdenanza("");
                    }

                    registroHijo.setValor1(registroHijos.getValor1().toString());
                    hijosRegistros.add(registroHijo);
                    rp.setHijos(hijosRegistros);

                }
                rp.setTipoFormulario(registroHijos.getTipoFormulario());
                result.set(i, rp);

            }

            subRegistros.add(rp);
        }

        List<DtoTipoRegistro> sourceList = result;
        return sourceList;
    }

}
