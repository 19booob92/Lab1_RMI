package utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


public class SensorMessageUtils {
    public static String prepareMessageForOrderToRegistring(Integer port,
            String host) {

        String order = "RegistrySensor";
        return MessageUtils.prepareSimpleMessage(port, host, order, String.valueOf(port));
    }

    public static String prepareMessageForOrderToFetchObjects(Integer port,
            String host) {

        String order = "FetchMonitors";
        return MessageUtils.prepareSimpleMessage(port, host, order, String.valueOf(port));
    }

    public static String prepareMessageForMonitor(Integer port, String host,
            String value) {

        String order = "SensorData";
        return MessageUtils.prepareSimpleMessage(port, host, order, value);
    }

    public static MessageUtils.Order parseMessage(String message) {

        System.out.println("Tryaing to read message...");
        MessageUtils.Order order = null;

        try {

            InputStream is = new ByteArrayInputStream(message.getBytes());
            SOAPMessage request = MessageFactory.newInstance().createMessage(
                    null, is);

            SOAPElement element = (SOAPElement) request.getSOAPBody()
                    .getChildElements().next();

            System.out.println(element.getLocalName());
            System.out.println(element.getValue());

            order = new MessageUtils.Order(element.getLocalName(), element.getValue());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }

        return order;
    }

    public static void main(String[] args) {
        SensorMessageUtils
                .prepareMessageForOrderToRegistring(1099,
                "localhost");
    }
    
}
