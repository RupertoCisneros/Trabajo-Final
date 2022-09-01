///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
// */
//package gob.mdmq.remetfu.service;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import javax.xml.bind.JAXBElement;
//import javax.xml.datatype.DatatypeConfigurationException;
//import javax.xml.datatype.DatatypeFactory;
//import javax.xml.datatype.XMLGregorianCalendar;
//import javax.xml.ws.Holder;
//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.frontend.ClientProxy;
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.apache.cxf.transport.http.HTTPConduit;
//import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
//import org.datacontract.schemas._2004._07.mdmq_domain.ArrayOfSAOORDENPAGODEUDOR;
//import org.datacontract.schemas._2004._07.mdmq_domain.ArrayOfSAOORDENPAGORUBRO;
//import org.datacontract.schemas._2004._07.mdmq_domain.ObjectFactory;
//import org.datacontract.schemas._2004._07.mdmq_domain.SAOORDENPAGO;
//import org.datacontract.schemas._2004._07.mdmq_domain.SAOORDENPAGODEUDOR;
//import org.datacontract.schemas._2004._07.mdmq_domain.SAOORDENPAGORUBRO;
//import org.springframework.stereotype.Service;
//import org.tempuri.IServiceSAOORDENPAGO;
// 
//
///**
// *
// * @author omaldonado
// */
//@Service
//public class ServicioSAO {
//
//    public void generarOrdenPago() {
//        Holder<Integer> saoResult = new Holder<>();
//        Holder<String> saoMensaje = new Holder<>();
//        Holder<Long> saoOrdenPago = new Holder<>();
//        ObjectFactory factory = new ObjectFactory();
//        Date fechaOrdenPago = new Date();
//        GregorianCalendar c = new GregorianCalendar();
//        try {
//            c.setTime(fechaOrdenPago);
//            XMLGregorianCalendar fechaSao = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//            JAXBElement<XMLGregorianCalendar> fechaModificacion = factory.createSAOORDENPAGOVTAFECHAMODIFICACION(fechaSao);
//            LocalDate fechaActual = LocalDate.now();
//            JAXBElement<String> direccion = factory.createSAOORDENPAGOVTASAODIRECCION("");
//            JAXBElement<String> origen = factory.createSAOORDENPAGOSAONUMEROORIGEN("0000000");
//            JAXBElement<String> observacion = factory.createSAOORDENPAGOSAOOBSERVACIONES("REMERFU");
//            JAXBElement<String> sistemaOrigen = factory.createSAOORDENPAGOSAOSISTEMAORIGEN("REMERFU");
//            JAXBElement<Integer> subEstadoId = factory.createSAOORDENPAGOVTASAOSUBESTADOID(3);
//            JAXBElement<Integer> rubroAnt = factory.createSAOORDENPAGOVTASAOSUBESTADOID(290);
//            JAXBElement<Integer> tipoOrdenPagoId = factory.createSAOORDENPAGOVTASAOTIPOORDENPAGOID(45);
//            JAXBElement<String> tituloCredito = factory.createSAOORDENPAGOVTASAOTITULOCREDITO("0");
//            JAXBElement<String> tramite = factory.createSAOORDENPAGOVTASAOTRAMITE("");
//            JAXBElement<String> usuarioModificacion = factory.createSAOORDENPAGOUSUARIOMODIFICACION("omaldonado");
//            JAXBElement<String> usuarioCreacion = factory.createSAOORDENPAGOUSUARIOCREACION("omaldonado");
//            JAXBElement<String> usuarioModificacionDeudor = factory.createSAOORDENPAGODEUDORUSUARIOMODIFICACION("omaldonado");
//            JAXBElement<String> usuarioCreacionDeudor = factory.createSAOORDENPAGODEUDORUSUARIOCREACION("omaldonado");
//
//            JAXBElement<String> usuarioModificacionRubro = factory.createSAOORDENPAGORUBROUSUARIOMODIFICACION("omaldonado");
//            JAXBElement<String> usuarioCreacionRubro = factory.createSAOORDENPAGORUBROUSUARIOCREACION("omaldonado");
//
//            JAXBElement<byte[]> versionFila = factory.createSAORUBROVERSIONFILA(new byte[]{0});
//
//            JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
//            factoryBean.setServiceClass(IServiceSAOORDENPAGO.class);
////            factoryBean.setAddress("http://172.22.8.126/MDMQ_SAO_servicios/ServiceSAO_ORDEN_PAGO.svc?wsdl");
//            factoryBean.setAddress("http://172.16.20.35/ServicioSAOOriginal/ServiceSAO_ORDEN_PAGO.svc?wsdl");
//
//            IServiceSAOORDENPAGO port = (IServiceSAOORDENPAGO) factoryBean.create();
//            Client client = ClientProxy.getClient(port);
//            if (client != null) {
//                HTTPConduit conduit = (HTTPConduit) client.getConduit();
//                HTTPClientPolicy policy = new HTTPClientPolicy();
//
//                //policy.setConnectionTimeout(ParametrosUtil.CONNECTION_TIMEOUT);
//                //policy.setReceiveTimeout(ParametrosUtil.RECEIVE_TIMEOUT);
//                policy.setAllowChunking(false);
//                conduit.setClient(policy);
//
//            }
//
//            //Instancia Sao
//            SAOORDENPAGO saoPago = new SAOORDENPAGO();
//            saoPago.setFECHACREACION(fechaSao);
//            saoPago.setFECHAMODIFICACION(fechaModificacion);
//            saoPago.setSAOANIOTRIBUTARIO(fechaActual.getYear());
//            saoPago.setSAODIRECCION(direccion);
//            saoPago.setSAOELIMINADO(Boolean.FALSE);
//            saoPago.setSAODIVIDIDA(Boolean.FALSE);
//            saoPago.setSAOESTADOID(3);
//            //TEMPORALIDAD SAO
//            // var temporalidad = Convert.ToInt32(ConfigurationManager.AppSettings["TEMPORALIDAD_SAO"].ToString());
//            saoPago.setSAOFECHAEMISION(fechaSao);
//            saoPago.setSAOFECHAEXIGIBILIDAD(fechaSao);
//            saoPago.setSAOFECHANOTIFICACION(fechaModificacion);
//            saoPago.setSAONUMEROORIGEN(origen);
//            saoPago.setSAOOBSERVACIONES(observacion);
//            saoPago.setSAOORDENPAGOID(Long.parseLong("0"));
//            saoPago.setSAOORIGEN(45);
//
//            saoPago.setSAOSISTEMAORIGEN(sistemaOrigen);
//            saoPago.setSAOSUBESTADOID(subEstadoId);
//
//            //PARAMETRO A SELECCIONAR SEGUN LA TABLA*******************************
//            //*********************************************************************
//            saoPago.setSAOTIPOORDENPAGOID(tipoOrdenPagoId);
//            saoPago.setSAOTITULOCREDITO(tituloCredito);
//            saoPago.setSAOTRAMITE(tramite);
//            saoPago.setUSUARIOCREACION(usuarioCreacion);
//            saoPago.setUSUARIOMODIFICACION(usuarioModificacion);
//            saoPago.setVERSIONFILA(versionFila);
//
//            ArrayOfSAOORDENPAGORUBRO saoRubro = new ArrayOfSAOORDENPAGORUBRO();
//            SAOORDENPAGORUBRO saoOrdenPagoRubro = new SAOORDENPAGORUBRO();
//            saoOrdenPagoRubro.setFECHACREACION(fechaSao);
//            saoOrdenPagoRubro.setFECHAMODIFICACION(fechaSao);
//            saoOrdenPagoRubro.setSAOELIMINADO(Boolean.FALSE);
//            saoOrdenPagoRubro.setSAOORDENPAGOID(Long.parseLong("0"));
//            saoOrdenPagoRubro.setSAOORDENPAGORUBROID(Long.parseLong("0"));
//            //PARAMETRO A SELECCIONAR SEGUN LA TABLA*******************************
//            //*********************************************************************
//            saoOrdenPagoRubro.setSAORUBROANT(rubroAnt);
//            //PARAMETRO A SELECCIONAR SEGUN LA TABLA*******************************
//            //*********************************************************************
//            saoOrdenPagoRubro.setSAOTIPOORDENPAGORUBROID(1161);
//            saoOrdenPagoRubro.setSAOVALOR(BigDecimal.valueOf(100));
//            saoOrdenPagoRubro.setSAOVALORACTUAL(BigDecimal.valueOf(100));
//            saoOrdenPagoRubro.setUSUARIOCREACION(usuarioCreacionRubro);
//            saoOrdenPagoRubro.setUSUARIOMODIFICACION(usuarioModificacionRubro);
//            saoOrdenPagoRubro.setVERSIONFILA(versionFila);
//            saoRubro.getSAOORDENPAGORUBRO().add(saoOrdenPagoRubro);
//
//            ArrayOfSAOORDENPAGODEUDOR saoDeudor = new ArrayOfSAOORDENPAGODEUDOR();
//            SAOORDENPAGODEUDOR deudor = new SAOORDENPAGODEUDOR();
//            deudor.setFECHACREACION(fechaSao);
//            deudor.setFECHAMODIFICACION(fechaSao);
//            deudor.setSAOORDENPAGODEUDORID(Long.parseLong("0"));
//            deudor.setSAOORDENPAGOID(Long.parseLong("0"));
//            deudor.setSAOPERSONAID(Long.parseLong("1937492"));
//            deudor.setSAOPRINCIPAL(Boolean.TRUE);
//            deudor.setUSUARIOCREACION(usuarioCreacionDeudor);
//            deudor.setUSUARIOMODIFICACION(usuarioModificacionDeudor);
//            deudor.setVERSIONFILA(versionFila);
//            saoDeudor.getSAOORDENPAGODEUDOR().add(deudor);
//
//            port.saoORDENPAGOInsertar(saoPago, saoRubro, saoDeudor, saoResult, saoMensaje, saoOrdenPago);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package gob.mdmq.remetfu.service;

import gob.mdmq.remetfu.Entidades.RemOrdenesPago;
import gob.mdmq.remetfu.Entidades.RemRubrosSao;
import gob.mdmq.remetfu.Entidades.RemSubtipoRegistro;
import gob.mdmq.remetfu.Entidades.RemUsuarios;
import gob.mdmq.remetfu.config.ProjectProperties;
import gob.mdmq.remetfu.repository.ParametroRepository;
import gob.mdmq.remetfu.repository.RubrosSaoRepository;
import gob.mdmq.remetfu.repository.SubtipoRegistroRepository;
import gob.mdmq.remetfu.repository.UsuarioPerfilRepository;
import gob.mdmq.remetfu.repository.UsuariosRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.datacontract.schemas._2004._07.mdmq_domain.ArrayOfSAOORDENPAGODEUDOR;
import org.datacontract.schemas._2004._07.mdmq_domain.ArrayOfSAOORDENPAGORUBRO;
import org.datacontract.schemas._2004._07.mdmq_domain.ObjectFactory;
import org.datacontract.schemas._2004._07.mdmq_domain.SAOORDENPAGO;
import org.datacontract.schemas._2004._07.mdmq_domain.SAOORDENPAGODEUDOR;
import org.datacontract.schemas._2004._07.mdmq_domain.SAOORDENPAGORUBRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tempuri.IServiceSAOORDENPAGO;

/**
 *
 * @author omaldonado
 */
@Service
public class ServicioSAO {

    @Autowired
    ProjectProperties propiedades;

    @Autowired
    private RubrosSaoRepository rubrosSaoRepository;

    @Autowired
    private ParametroRepository parametroRepository;

    @Autowired
    private SubtipoRegistroRepository subtipoRegistroRepository;

    @Autowired
    private ServicioUsuarios servicioUsuarios;
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ServicioOrdenesPago servicioOrdenesPago;

    //Servicio general para generar Ordenes de Pago en SAO
    //se basa en el tipo registro para saber el valor a cobrar
    @Transactional
    public String generarOrdenPago(Long subTipoRegistro, Long registroOperacion, String usuarioTransaccion, Long usuarioPropietario, String terminalTransaccion, String ususarioModificacion) {
        String ordenPagoValor = "";

        //Obtenemos datos del Rubro correspondiente
        Integer estadoInicialOrdenPago = 3;
        RemRubrosSao remRubrosSao = new RemRubrosSao();
        Optional<RemUsuarios> remUsuarios = null;
        Optional<RemSubtipoRegistro> remSubtipoRegistro = null;
        RemOrdenesPago remOrdenesPago = new RemOrdenesPago();

        String ordenanza = parametroRepository.obtenerParametro(Long.parseLong("5"));
        var valorSalarioBasicoC = parametroRepository.obtenerParametro(Long.parseLong("11"));
        Double valorSalarioBasicoN = Double.parseDouble(valorSalarioBasicoC);
        Double valorCobroRegistro = 0.0;
        remSubtipoRegistro = subtipoRegistroRepository.findById(subTipoRegistro);

        valorCobroRegistro = valorSalarioBasicoN * new BigDecimal(remSubtipoRegistro.get().getValor1().toString()).doubleValue() / 100.00;

        remRubrosSao = rubrosSaoRepository.obtenerRubroSao(subTipoRegistro);
        remUsuarios = usuariosRepository.findById(usuarioPropietario);

        Holder<Integer> saoResult = new Holder<>();
        Holder<String> saoMensaje = new Holder<>();
        Holder<Long> saoOrdenPago = new Holder<>();
        ObjectFactory factory = new ObjectFactory();

        Date fechaOrdenPago = new Date();
        GregorianCalendar c = new GregorianCalendar();
        try {
            c.setTime(fechaOrdenPago);
            XMLGregorianCalendar fechaSao = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            JAXBElement<XMLGregorianCalendar> fechaModificacion = factory.createSAOORDENPAGOVTAFECHAMODIFICACION(fechaSao);
            LocalDate fechaActual = LocalDate.now();
            JAXBElement<String> direccion = factory.createSAOORDENPAGOVTASAODIRECCION("");
            JAXBElement<String> origen = factory.createSAOORDENPAGOSAONUMEROORIGEN(registroOperacion.toString());
            JAXBElement<String> observacion = factory.createSAOORDENPAGOSAOOBSERVACIONES(remRubrosSao.getSaoDetalle());
            JAXBElement<String> sistemaOrigen = factory.createSAOORDENPAGOSAOSISTEMAORIGEN(remRubrosSao.getSaoDetalle());

            JAXBElement<Integer> subEstadoId = factory.createSAOORDENPAGOVTASAOSUBESTADOID(estadoInicialOrdenPago);
            JAXBElement<Integer> rubroAnt = factory.createSAOORDENPAGOVTASAOSUBESTADOID(Integer.parseInt(remRubrosSao.getSaoRubroAnt()));
            JAXBElement<Integer> tipoOrdenPagoId = factory.createSAOORDENPAGOVTASAOTIPOORDENPAGOID(Integer.parseInt(remRubrosSao.getSaoTipoOrdenPagoId()));
            JAXBElement<String> tituloCredito = factory.createSAOORDENPAGOVTASAOTITULOCREDITO("0");
            JAXBElement<String> tramite = factory.createSAOORDENPAGOVTASAOTRAMITE("");

            JAXBElement<String> usuarioCreacion = factory.createSAOORDENPAGOUSUARIOCREACION(usuarioTransaccion);
            JAXBElement<String> usuarioModificacion = factory.createSAOORDENPAGOUSUARIOMODIFICACION(usuarioTransaccion);
            JAXBElement<String> usuarioCreacionDeudor = factory.createSAOORDENPAGODEUDORUSUARIOCREACION(usuarioTransaccion);
            JAXBElement<String> usuarioModificacionDeudor = factory.createSAOORDENPAGODEUDORUSUARIOMODIFICACION(usuarioTransaccion);
            JAXBElement<String> usuarioCreacionRubro = factory.createSAOORDENPAGORUBROUSUARIOCREACION(usuarioTransaccion);
            JAXBElement<String> usuarioModificacionRubro = factory.createSAOORDENPAGORUBROUSUARIOMODIFICACION(usuarioTransaccion);

            JAXBElement<byte[]> versionFila = factory.createSAORUBROVERSIONFILA(new byte[]{0});

            JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
            factoryBean.setServiceClass(IServiceSAOORDENPAGO.class);
            factoryBean.setAddress(propiedades.getWsServiceSAOordenesPago());

            IServiceSAOORDENPAGO port = (IServiceSAOORDENPAGO) factoryBean.create();
            Client client = ClientProxy.getClient(port);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) client.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();

                policy.setAllowChunking(false);
                conduit.setClient(policy);

            }

            //Instancia Sao
            SAOORDENPAGO saoPago = new SAOORDENPAGO();
            saoPago.setFECHACREACION(fechaSao);
            saoPago.setFECHAMODIFICACION(fechaModificacion);
            saoPago.setSAOANIOTRIBUTARIO(fechaActual.getYear());
            saoPago.setSAODIRECCION(direccion);
            saoPago.setSAOELIMINADO(Boolean.FALSE);
            saoPago.setSAODIVIDIDA(Boolean.FALSE);
            saoPago.setSAOESTADOID(3);
            //TEMPORALIDAD SAO
            // var temporalidad = Convert.ToInt32(ConfigurationManager.AppSettings["TEMPORALIDAD_SAO"].ToString());
            saoPago.setSAOFECHAEMISION(fechaSao);
            saoPago.setSAOFECHAEXIGIBILIDAD(fechaSao);
            saoPago.setSAOFECHANOTIFICACION(fechaModificacion);
            saoPago.setSAONUMEROORIGEN(origen);
            saoPago.setSAOOBSERVACIONES(observacion);
            saoPago.setSAOORDENPAGOID(Long.parseLong("0"));
            saoPago.setSAOORIGEN(Integer.parseInt(remRubrosSao.getSaoTipoOrdenPagoId())); //45

            saoPago.setSAOSISTEMAORIGEN(sistemaOrigen);
            saoPago.setSAOSUBESTADOID(subEstadoId);

            //PARAMETRO A SELECCIONAR SEGUN LA TABLA*******************************
            //*********************************************************************
            saoPago.setSAOTIPOORDENPAGOID(tipoOrdenPagoId);
            saoPago.setSAOTITULOCREDITO(tituloCredito);
            saoPago.setSAOTRAMITE(tramite);
            saoPago.setUSUARIOCREACION(usuarioCreacion);
            saoPago.setUSUARIOMODIFICACION(usuarioModificacion);
            saoPago.setVERSIONFILA(versionFila);

            ArrayOfSAOORDENPAGORUBRO saoRubro = new ArrayOfSAOORDENPAGORUBRO();
            SAOORDENPAGORUBRO saoOrdenPagoRubro = new SAOORDENPAGORUBRO();
            saoOrdenPagoRubro.setFECHACREACION(fechaSao);
            saoOrdenPagoRubro.setFECHAMODIFICACION(fechaSao);
            saoOrdenPagoRubro.setSAOELIMINADO(Boolean.FALSE);
            saoOrdenPagoRubro.setSAOORDENPAGOID(Long.parseLong("0"));
            saoOrdenPagoRubro.setSAOORDENPAGORUBROID(Long.parseLong("0"));
            //PARAMETRO A SELECCIONAR SEGUN LA TABLA*******************************
            //*********************************************************************
            saoOrdenPagoRubro.setSAORUBROANT(rubroAnt);
            //PARAMETRO A SELECCIONAR SEGUN LA TABLA*******************************
            //*********************************************************************
            saoOrdenPagoRubro.setSAOTIPOORDENPAGORUBROID(Integer.parseInt(remRubrosSao.getSaoTipoOrdenPagoRubroId()));
            saoOrdenPagoRubro.setSAOVALOR(BigDecimal.valueOf(valorCobroRegistro));
            saoOrdenPagoRubro.setSAOVALORACTUAL(BigDecimal.valueOf(valorCobroRegistro));
            saoOrdenPagoRubro.setUSUARIOCREACION(usuarioCreacionRubro);
            saoOrdenPagoRubro.setUSUARIOMODIFICACION(usuarioModificacionRubro);
            saoOrdenPagoRubro.setVERSIONFILA(versionFila);
            saoRubro.getSAOORDENPAGORUBRO().add(saoOrdenPagoRubro);

            ArrayOfSAOORDENPAGODEUDOR saoDeudor = new ArrayOfSAOORDENPAGODEUDOR();
            SAOORDENPAGODEUDOR deudor = new SAOORDENPAGODEUDOR();
            deudor.setFECHACREACION(fechaSao);
            deudor.setFECHAMODIFICACION(fechaSao);
            deudor.setSAOORDENPAGODEUDORID(Long.parseLong("0"));
            deudor.setSAOORDENPAGOID(Long.parseLong("0"));
            deudor.setSAOPERSONAID(Long.parseLong(remUsuarios.get().getCim().toString()));
            deudor.setSAOPRINCIPAL(Boolean.TRUE);
            deudor.setUSUARIOCREACION(usuarioCreacionDeudor);
            deudor.setUSUARIOMODIFICACION(usuarioModificacionDeudor);
            deudor.setVERSIONFILA(versionFila);
            saoDeudor.getSAOORDENPAGODEUDOR().add(deudor);

            port.saoORDENPAGOInsertar(saoPago, saoRubro, saoDeudor, saoResult, saoMensaje, saoOrdenPago);

            remOrdenesPago.setSubtipoRegistroId(remSubtipoRegistro.get());
            remOrdenesPago.setNroRegistro(registroOperacion);
            remOrdenesPago.setFechaIng(fechaOrdenPago);
            remOrdenesPago.setOrdenpagoSao(saoOrdenPago.value.toString());
            remOrdenesPago.setEstadoSao(estadoInicialOrdenPago.toString());
            remOrdenesPago.setFechaRegSao(fechaOrdenPago);
            remOrdenesPago.setCodigoQr(ordenanza);
            remOrdenesPago.setValorSao(new BigDecimal(valorCobroRegistro.toString()));
            remOrdenesPago.setConceptoSao(remSubtipoRegistro.get().getDescripcion());
            remOrdenesPago.setCiDeudor(remUsuarios.get().getNroIdentificacion().toString());
            remOrdenesPago.setNovedad(remSubtipoRegistro.get().getDescripcion());
            remOrdenesPago.setUsuarioCreacion(ususarioModificacion);
            remOrdenesPago.setUsuarioModificacion(ususarioModificacion);
            remOrdenesPago.setFechaCreacion(fechaOrdenPago);
            remOrdenesPago.setFechaModificacion(fechaOrdenPago);
            remOrdenesPago.setTerminalCreacion(terminalTransaccion);
            remOrdenesPago.setTerminalModificacion(terminalTransaccion);

            //Graba ordenes de pago en tabla local
            if (servicioOrdenesPago.guardarOrdenesPagoLocal(remOrdenesPago)) {
                ordenPagoValor = saoOrdenPago.value.toString();
            }
            return ordenPagoValor;

        } catch (Exception e) {
            e.printStackTrace();
            return ordenPagoValor;
        }

    }

}
