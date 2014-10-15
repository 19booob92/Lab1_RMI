package utils;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryUtils {
	
	public static Registry setRegistry(String ip, int port) throws RemoteException {
		return LocateRegistry.getRegistry(ip, port);
	}
}
