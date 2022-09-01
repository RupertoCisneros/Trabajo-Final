/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gob.mdmq.remetfu.utilitarios;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author srcisnerosv
 */
public class ObtenerIP {
    public String obtenerIP() throws UnknownHostException {
                // Obtener dirección IP
    String ipEquipo="";
  
        try {
            
            ipEquipo = InetAddress.getLocalHost().getHostAddress();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
                
                return ipEquipo;
    }
}
