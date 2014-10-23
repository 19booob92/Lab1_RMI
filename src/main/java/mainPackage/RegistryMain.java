package mainPackage;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import mainPack.RegistryImpl;
import utils.Connect;


public class RegistryMain extends Connect{

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        RegistryImpl registry = new RegistryImpl();
        try {
            registry.checkConnections();
        } catch (IOException e) {
            System.err.println("Nie mozna nawiazac polaczenia");
            e.printStackTrace();
        }
        
    }

    @Override
    public void checkRequest(String inputMessage) {
        System.err.println("Wiadomość : " + inputMessage );
    }
}
