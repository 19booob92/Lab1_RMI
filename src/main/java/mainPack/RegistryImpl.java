package mainPack;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RegistryImpl extends UnicastRemoteObject implements IRegistry {

	private ArrayList<Object> sensors = new ArrayList<>();
	private ArrayList<Object> monitors = new ArrayList<>();

	private static int id = 0;

	public RegistryImpl() throws RemoteException, AlreadyBoundException {
		super();
	}

	private static final long serialVersionUID = -388878129705895055L;

	public int registerObject(Object object, int category)
			throws RemoteException {
		if (category == 0) {
			IMonitor monitor = (IMonitor) object;
			monitors.add(monitor);
			System.err.println("Registred Monitor");
			return nextId();
		} else {
			ISensor sensor = (ISensor) object;
			sensors.add(sensor);
			System.err.println("Registred Sensor");
			return nextId();
		}
	}

	public boolean unRegister(int number) throws RemoteException {
		for (Object sensor : sensors) {
			ISensor sensorImpl = (ISensor) sensor;
			if (sensorImpl.getNumber() == number) {
				sensors.remove(sensorImpl);
				System.err.println("deleted " + sensorImpl.getNumber());
				return true;
			}
		}
		for (Object monitor : monitors) {
			IMonitor monitorImpl = (IMonitor) monitor;
			if (monitorImpl.getNumber() == number) {
				sensors.remove(monitorImpl);
				System.err.println("deleted " + monitorImpl.getNumber());
				return true;
			}
		}
		return false;
	}

	public ArrayList<Object> getObjects(int category) throws RemoteException {
		if (category == 0) {
			return monitors;
		} else {
			return sensors;
		}
	}

	private int nextId() {
		return id++;
	}

}
