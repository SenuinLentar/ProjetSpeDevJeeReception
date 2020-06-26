/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appjee.receptionfacade.facade;

import com.appjee.receptionfacade.domain.SoapMessage;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author myal6
 */
@Stateless
@WebService(
        endpointInterface = "com.appjee.receptionfacade.facade.FacadeServiceEndpointInterface",
        portName = "ReceptionPort",
        serviceName = "ReceptionService"
)
public class FacadeServiceBean implements FacadeServiceEndpointInterface {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/facadeQueue")
    private Queue facadeQueue;

    @Override
    public SoapMessage receiveDecipherOrder(SoapMessage message) {
        System.out.println("Appel de receiveDecipherOrder");
        System.out.println("Message info : " + message.getInfo());

        addDecipherOrderToQueue(message);
        
        //message.setInfo("Ordre reçu et envoyé dans la queue.");

        return message;
    }

    private void addDecipherOrderToQueue(SoapMessage message) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(SoapMessage.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            StringWriter writer = new StringWriter();

            jaxbMarshaller.marshal(message, writer);
            String xmlMessage = writer.toString();
            System.out.println(xmlMessage);

            TextMessage msg = context.createTextMessage(xmlMessage);

            context.createProducer().send(facadeQueue, msg);

        } catch (JAXBException ex) {
            Logger.getLogger(FacadeServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
