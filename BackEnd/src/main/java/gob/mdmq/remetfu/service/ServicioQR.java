/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.config.ProjectProperties;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.datacontract.schemas._2004._07.stampinglibrary.Metadatos;
import org.datacontract.schemas._2004._07.stampinglibrary.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tempuri.IDocumentalService;

/**
 *
 * @author omaldonado
 */
@Service
public class ServicioQR {
    
    @Autowired
    ProjectProperties propiedades;        

    public byte[] estamparCodigoQr(byte[] archivoGenerado) throws IOException {

        Metadatos metadatos = new Metadatos();
        Date fechaOrdenPago = new Date();
        GregorianCalendar c = new GregorianCalendar();
        ObjectFactory factory = new ObjectFactory();
        byte[] docEstamp = null;
        try {
            c.setTime(fechaOrdenPago);
            XMLGregorianCalendar fechaArchivoEmision = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            JAXBElement<XMLGregorianCalendar> fechaArchivo = factory.createMetadatosFechaEmision(fechaArchivoEmision);
            JAXBElement<String> nombreDocumento = factory.createMetadatosNombreDocumento("REMERFU");
            JAXBElement<String> numeroHabilitanteUnico = factory.createMetadatosNumeroHabilitante("5");
            JAXBElement<String> terminal = factory.createMetadatosTerminal("172.162.20.21");
            JAXBElement<String> nombreUsuario = factory.createMetadatosUsuario("oscar");

            JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
            factoryBean.setServiceClass(IDocumentalService.class);
            factoryBean.setAddress(propiedades.getWsDocumentalService());

            IDocumentalService port = (IDocumentalService) factoryBean.create();
            Client client = ClientProxy.getClient(port);

            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) client.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setAllowChunking(false);
                conduit.setClient(policy);

            }

            metadatos.setCimSolicitante(Long.parseLong("1937492"));
            metadatos.setCoordenadaX((float) 14);
            metadatos.setCoordenadaY((float) 14);
            metadatos.setFechaEmision(fechaArchivo);
            metadatos.setFechaVigencia(fechaArchivo);
            metadatos.setNombreDocumento(nombreDocumento);
            metadatos.setNumeroHabilitante(numeroHabilitanteUnico);
            metadatos.setNumeroPagina(1);
            metadatos.setObservaciones(nombreDocumento);
            metadatos.setTamanioQR(100);
            metadatos.setTerminal(terminal);
            metadatos.setTipoDocumento(3);
            metadatos.setTipoOrigen(9);
            metadatos.setUsuario(nombreUsuario);

            File folder = new File("C://Users/omaldonado/Documents/REMETFU BACKEND/");

            for (File files : folder.listFiles()) {

                File file = new File("C://Users/omaldonado/Documents/REMETFU BACKEND/Especialista.pdf");
                byte[] bytes = Files.readAllBytes(file.toPath());
                var byteArchivo = port.estamparDocumento(bytes, metadatos);
                docEstamp = byteArchivo.getDocumentoEstampado().getValue();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return docEstamp;

    }

}
