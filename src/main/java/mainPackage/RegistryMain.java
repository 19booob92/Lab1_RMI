package mainPackage;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import mainPack.RegistryImpl;


public class RegistryMain {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        LocateRegistry.createRegistry(1099);
        RegistryImpl registry = new RegistryImpl();
    }
}
