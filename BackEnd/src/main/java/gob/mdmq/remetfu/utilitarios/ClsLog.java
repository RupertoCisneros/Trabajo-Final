/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.utilitarios;

import gob.mdmq.remetfu.config.ProjectProperties;
import gob.mdmq.remetfu.service.ServicioAnalisisTramiteRegistroProfesional;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClsLog {

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private ServicioAnalisisTramiteRegistroProfesional analisisTramiteRegistroProfesional;

    private enum TipoLog {
        Proceso,
        Error
    }

    public void RegistrarError(String clase, String strMensajeError, String strMetodo) {
        try {
            Registrar(clase, strMensajeError, TipoLog.Error.toString(), strMetodo);
        } catch (Exception ex) {
        }
    }

    public void RegistrarProceso(String clase, String mensaje, String metodo) {
        try {
            Registrar(clase, mensaje, TipoLog.Proceso.toString(), metodo);
        } catch (Exception ex) {
        }
    }

    private void Registrar(String clase, String mensaje, String tipoLog, String metodo) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSistema = sdf.format(new Date());
            String fechaArchivo = sdf1.format(new Date());
            String[] pathnames;
            File archivo = new File(projectProperties.getRutaArchivoLog());

            pathnames = archivo.list();

            // For each pathname in the pathnames array
            for (String pathname : pathnames) {
                // Print the names of files and directories
                System.out.println(pathname);
            }

            // Le damos al nombre del fichero la fecha y hora actual
            String nombreFichero = "Remetfu_" + fechaArchivo.replace("/", "") + ".log";
            nombreFichero = projectProperties.getRutaArchivoLog() + nombreFichero;

            archivo = new File(nombreFichero);
            File carpeta = archivo.getParentFile();

            Long size = archivo.length();
            System.out.println("el tamaño del archivo es" + " " + size + " bytes");

            String ver = analisisTramiteRegistroProfesional.obtenerParametros(Long.parseLong("10"));
            int parametro = Integer.parseInt(ver);
            if (size > parametro) {

                String contador = nombreFichero.substring(nombreFichero.length() - 5, nombreFichero.length() - 4);
                nombreFichero = nombreFichero.substring(0, nombreFichero.length() - 4) + "_1" + ".log";

                archivo = new File(nombreFichero);
                carpeta = archivo.getParentFile();

            }

            // si el archivo no existe se crea
            if (!archivo.exists()) {
                carpeta.mkdirs();
                archivo.createNewFile();
            }
            FileWriter tw = new FileWriter(nombreFichero, true);

            if (tipoLog.equals("Proceso")) {
                tw.write("");
                tw.write("Hora Evento: " + fechaSistema);
                tw.write("\n");
                tw.write("Clase: " + clase);
                tw.write("\n");
                tw.write("Tipo log: " + tipoLog);
                tw.write("\n");
                tw.write("Metodo: " + metodo);
                tw.write("\n");
                tw.write("Mensaje proceso: " + mensaje);
                tw.write("\n");
                tw.close();
            } else if (tipoLog.equals("Error")) {
                tw.write("");
                tw.write("Hora Evento: " + fechaSistema);
                tw.write("\n");
                tw.write("Clase: " + clase);
                tw.write("\n");
                tw.write("Tipo log: " + tipoLog);
                tw.write("\n");
                tw.write("Mensaje error: " + mensaje);
                tw.write("\n");
                tw.close();
            }

        } catch (Exception ex) {
        }
    }

}
