/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemArchivos;
import gob.mdmq.remetfu.dto.DtoNacionalidad;
import gob.mdmq.remetfu.repository.ArchivosRepository;
import gob.mdmq.remetfu.repository.UtilitarioRepository;
import java.util.Date;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUtilitario {

    @Autowired
    private UtilitarioRepository utilitarioRepository;

    @Autowired
    private ArchivosRepository archivosRepository;

    public Set<DtoNacionalidad> obtenerNacionalidad() {

        return utilitarioRepository.obtenerNacionalidad();
    }

    public boolean guardarArchivo(String archivoId, String ip, String usuario) {
        boolean respuesta = false;
        RemArchivos archivos = new RemArchivos();
        Date fecha = new Date();
        try {
            archivos.setArchivoId(archivoId.substring(1, archivoId.length() - 1));
            archivos.setFechaCreacion(fecha);
            archivos.setFechaModificacion(fecha);
            archivos.setHash("");
            archivos.setNombreArchivo("");
            archivos.setObservacion("");
            archivos.setRuta("");
            archivos.setTerminalCreacion(ip);
            archivos.setTerminalModificacion(ip);
            archivos.setTipoArchivo("aplication/pdf");
            archivos.setUsuarioCreacion(usuario);
            archivos.setUsuarioModificacion(usuario);
            archivosRepository.save(archivos);

            return respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }
    }

}
