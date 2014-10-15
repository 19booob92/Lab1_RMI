package mainPackage;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import mainPack.RegistryImpl;
import view.MonitorWindow;
import view.SensorWindow;

public class MainClass {
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
	    RegistryImpl registry = new RegistryImpl();
	    
	    SensorWindow sensorWindow = new SensorWindow();
	    MonitorWindow monitorWindow = new MonitorWindow();
	}
}
