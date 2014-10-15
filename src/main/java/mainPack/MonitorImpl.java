package mainPack;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import static java.lang.System.*;
import utils.RegistryUtils;

public class MonitorImpl extends RegisterDecorator implements IMonitor {

	private int number;
	
	private Registry registry;
	
	
	public MonitorImpl(String ip, int port) throws RemoteException, NotBoundException {
		registry = RegistryUtils.setRegistry(ip, port);
		remoteRegistry = (IRegistry) registry.lookup("remoteRegisty");
	}
	
	public void change() throws RemoteException {
		out.println("zmienio stan");
	}

	public int getNumber() throws RemoteException {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public void stateChange() throws RemoteException {
		for (Object sensor : remoteRegistry.getObjects(0)) {
			SensorImpl sensorsImpl = (SensorImpl) sensor;
			System.out.println(sensorsImpl.getNumber() + " jest na pozycji: " + sensorsImpl.getPosition());
		}
	}

    public void refresh() throws RemoteException {
        stateChange();
    }
	
}
