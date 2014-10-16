package mainPack;


import static java.lang.System.out;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import utils.RegistryUtils;


public class MonitorImpl implements IMonitor {

	private int number;
	
	private Registry registry;
	
    protected IRegistry remoteRegistry;
	
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

    @Override
    public void register() throws RemoteException {
        remoteRegistry.registerObject(this, 0);
    }

    @Override
    public void unregister() throws RemoteException {
        remoteRegistry.unRegister(this.number);
    }
	
}
