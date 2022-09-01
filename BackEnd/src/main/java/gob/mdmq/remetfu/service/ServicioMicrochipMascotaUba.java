/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemCatalogo;
import gob.mdmq.remetfu.Entidades.RemMicrochipMascotaUba;
import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.Entidades.RemTutorMascota;
import gob.mdmq.remetfu.repository.CatalogoRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import gob.mdmq.remetfu.repository.TutorMascotaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.mdmq.remetfu.repository.MicrochipMascotaUbaRepository;
import gob.mdmq.remetfu.repository.ParametroRepository;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srcisnerosv
 */
@Service
public class ServicioMicrochipMascotaUba {

    @Autowired
    private MicrochipMascotaUbaRepository microchipMascotaUbaRepository;
    @Autowired
    private TutorMascotaRepository tutorMascotaRepository;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private ServicioSAO servicioSao;
    @Autowired
    private ServicioMail servicioMail;
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private ServicioSubtipoRegistro servicioSubtipoRegistro;    
    @Autowired
    private ParametroRepository parametroRepository;

    public Optional<RemMicrochipMascotaUba> obtenerById(Long id) {
        return microchipMascotaUbaRepository.findById(id);
    }

    public List<RemMicrochipMascotaUba> obtenerMicrochipTodos() {
        try {
            return (List<RemMicrochipMascotaUba>) microchipMascotaUbaRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public boolean crearMicrochipMascotaUba(RemMicrochipMascotaUba remMicrochipMascotaUba, Long tutorId, String cedulaVeterinario, Long establecimientoId) {

        boolean respuesta = false;
        Date fecha = new Date();
        try {

            Optional<RemTutorMascota> codigoTutor = tutorMascotaRepository.findById(tutorId);
            Optional<RemCatalogo> codigoEstablecimiento = catalogoRepository.findById(establecimientoId);
            RemUsuarios usuarioIdEntity = usuariosRepository.obtenerByCedula(cedulaVeterinario);
            Optional<RemUsuarios> tutorMascota = usuariosRepository.findById(codigoTutor.get().getUsuarioId().getUsuarioId());

            remMicrochipMascotaUba.setTutorId(codigoTutor.get());
            remMicrochipMascotaUba.setEstablecimiento(codigoEstablecimiento.get());
            remMicrochipMascotaUba.setFuncionarioUba(usuarioIdEntity);
            remMicrochipMascotaUba.setFechaCreacion(fecha);
            remMicrochipMascotaUba.setFechaIngreso(fecha);
            remMicrochipMascotaUba.setFechaModificacion(fecha);
            remMicrochipMascotaUba.setUsuarioCreacion(remMicrochipMascotaUba.getUsuarioCreacion());
            remMicrochipMascotaUba.setUsuarioModificacion(remMicrochipMascotaUba.getUsuarioModificacion());

            var microchipUba = microchipMascotaUbaRepository.save(remMicrochipMascotaUba);
            if (microchipUba != null) {
                taskExecutor.execute(new Runnable() {
                    public void run() {
                        try {
                            var ordenGenerada = servicioSao.generarOrdenPago(Long.parseLong("3"), microchipUba.getMicrochipMascotaUbaId(), microchipUba.getUsuarioCreacion(), usuarioIdEntity.getUsuarioId(), microchipUba.getTerminalCreacion(), microchipUba.getUsuarioCreacion());
                            var mensaje = mensajeMicrochipUba(ordenGenerada);
                            var enviarmail = servicioMail.enviarNotificaciones("Colocación Microchip Mascota UBA", mensaje, tutorMascota.get().getUsuarioId(), 3, microchipUba.getMicrochipMascotaUbaId(), false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                respuesta = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return respuesta;
        }

        return respuesta;

    }
        public String mensajeMicrochipUba(String ordenGenerada) {
        var mensaje = "";
        try {
            Optional<RemSubtipoRegistro> subTipoRegistroObj = servicioSubtipoRegistro.obtenerById(Long.parseLong("3"));
            var valorSalarioBasicoC = parametroRepository.obtenerParametro(Long.parseLong("11"));
            Double valorSalarioBasicoN = Double.parseDouble(valorSalarioBasicoC);
            mensaje = "Se ha registrado correctamente, por favor acerquese a cancelar la orden de pago N° " +ordenGenerada
                    + " por el valor de $ "+ (valorSalarioBasicoN * subTipoRegistroObj.get().getValor1().longValue() / 100.00);
            return mensaje;
        } catch (Exception e) {
            return mensaje;
        }
    }

    public Optional<RemMicrochipMascotaUba> obtenerById(String codigoMicrochip) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
