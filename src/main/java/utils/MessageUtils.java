package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;


public class MessageUtils {
    public static String prepareMsg(Integer port, String host,
            String order, String value) {

        try {

            String serverURI = host + ":" + port;

            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("order", serverURI);

            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem = soapBody.addChildElement(order, "order");

            soapBodyElem.addTextNode(value);

            soapMessage.saveChanges();

            System.out.print(soapMessageToString(soapMessage));
            return soapMessageToString(soapMessage);
 
        } catch (ArrayIndexOutOfBoundsException | IllegalAccessError | SOAPException e) {
            System.out.print(e.getMessage());
        }

        return "";
    }

    private static String soapMessageToString(SOAPMessage message) {
        String result = null;

        if (message != null) {
            ByteArrayOutputStream byteArrayStream = null;
            try {
                byteArrayStream = new ByteArrayOutputStream();
                message.writeTo(byteArrayStream);
                result = byteArrayStream.toString();
            } catch (Exception e) {
            } finally {
                if (byteArrayStream != null) {
                    try {
                        byteArrayStream.close();
                    } catch (IOException ioe) {
                    }
                }
            }
        }
        return result;
    }
    

    public static class MessageTuple {
        private String request;
        private String content;
        
        public MessageTuple(String reqest, String content) {
            this.request = reqest;
            this.content = content;
        }
        
        public String getRequest() {
            return request;
        }
        
        public void setRequest(String request) {
            this.request = request;
        }
        
        public String getContent() {
            return content;
        }
        
        public void setContent(String content) {
            this.content = content;
        }
        
    }
}
