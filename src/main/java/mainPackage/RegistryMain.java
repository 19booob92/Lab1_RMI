package mainPackage;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import mainPack.IRegistry;
import mainPack.RegistryImpl;


public class RegistryMain {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        LocateRegistry.createRegistry(1099);
//        Registry registryDeflaut = LocateRegistry.getRegistry("localhost", 0);
//        IRegistry registry = new RegistryImpl();
//        registryDeflaut.bind("remoteRegisty", registry);
        
        
        System.err.println("Started Registry");
    }
}
