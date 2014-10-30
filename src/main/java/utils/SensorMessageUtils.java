package utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import mainPack.SensorImpl;


public class SensorMessageUtils {
    public static String prepareMessageForOrderToRegistring(Integer port,
            String host, String obj) {

        String order = "RegistrySensor";
        return MessageUtils.prepareMsg(port, host, order, String.valueOf(obj));
    }

    public static String prepareMessageForOrderToUnRegistring(Integer port,
            String host, String obj) {
        
        String order = "UnRegistrySensor";
        return MessageUtils.prepareMsg(port, host, order, String.valueOf(obj));
    }
    
    public static String prepareMessageForStatusChanged(Integer port,
            String host, String sensor) {

        String order = "StatusChanged";
        return MessageUtils.prepareMsg(port, host, order, sensor);
    }

    public static String prepareMessageForOrderToFetchObjects(Integer port,
            String host) {

        String order = "GetMonitors";
        return MessageUtils.prepareMsg(port, host, order, String.valueOf(port));
    }

    public static MessageUtils.MessageTuple parseMessage(String message) {

        MessageUtils.MessageTuple order = null;

        try {

            InputStream is = new ByteArrayInputStream(message.getBytes());
            SOAPMessage request = MessageFactory.newInstance().createMessage(
                    null, is);

            SOAPElement element = (SOAPElement) request.getSOAPBody()
                    .getChildElements().next();

            System.out.println(element.getLocalName());
            System.out.println(element.getValue());

            order = new MessageUtils.MessageTuple(element.getLocalName(), element.getValue());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }

        return order;
    }
    
}
