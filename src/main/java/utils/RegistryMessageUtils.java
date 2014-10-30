package utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import utils.MessageUtils.MessageTuple;


public class RegistryMessageUtils {
    public static String prepareMessageForRegistringObject(Integer id,
            Integer port, String host) {

        String order = "setNumber";
        return MessageUtils.prepareMsg(port, host, order,
                String.valueOf(id));
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

            order = new MessageTuple(element.getLocalName(), element.getValue());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }

        return order;
    }

    public static void main(String[] args) {
        prepareMessageForRegistringObject(1099, 1,
                "localhost");
    }

    public static String prepareMessageForSendingSensors(String list,
            int port, String host) {

        String order = "sensorsData";
        return MessageUtils.prepareMsg(port, host, order,
                list);

    }
    
    public static String prepareMessageForSendingMonitors(String list,
            int port, String host) {
        String order = "moitorData";
        return MessageUtils.prepareMsg(port, host, order,
                list);

    }
}
