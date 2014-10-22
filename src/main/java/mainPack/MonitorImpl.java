package mainPack;


import static java.lang.System.out;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import utils.RegistryUtils;


public class MonitorImpl extends UnicastRemoteObject implements IMonitor {

    private static final long serialVersionUID = -1994726035869244103L;

    private int number;
	
    protected IRegistry remoteRegistry;
	
	public MonitorImpl(String ip, int port) throws RemoteException, NotBoundException, MalformedURLException {
	    remoteRegistry = (IRegistry) Naming.lookup("rmi://" + ip + "/remoteRegisty");
	    System.err.println("Created Monitor");
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
		for (Object sensor : remoteRegistry.getObjects(1)) {
			ISensor sensorsImpl = (ISensor) sensor;
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
