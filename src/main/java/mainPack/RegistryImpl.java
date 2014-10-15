package mainPack;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import view.SensorWindow;

public class RegistryImpl extends UnicastRemoteObject implements IRegistry {

	private ArrayList<Object> sensors;
	private ArrayList<Object> monitors;

	private static int id = 0;
	private Registry registry;

	protected RegistryImpl() throws RemoteException, AlreadyBoundException {
		super();
		registry = LocateRegistry.createRegistry(8080);
		registry.bind("remoteRegisty", this);
	}

	private static final long serialVersionUID = -388878129705895055L;

	public int registerObject(Object object, int category)
			throws RemoteException {
		if (category == 1) {
			MonitorImpl monitor = (MonitorImpl) object;
			monitor.setNumber(nextId());
			monitors.add(monitor);
			return monitor.getNumber();
		} else {
			SensorImpl sensor = (SensorImpl) object;
			sensor.setNumber(nextId());
			sensors.add(sensor);
			return sensor.getNumber();
		}
	}

	public boolean unRegister(int number) throws RemoteException {
		for (Object sensor : sensors) {
			SensorImpl sensorImpl = (SensorImpl) sensor;
			if (sensorImpl.getNumber() == number) {
				sensors.remove(sensorImpl);
				return true;
			}
		}
		for (Object monitor : monitors) {
			MonitorImpl monitorImpl = (MonitorImpl) monitor;
			if (monitorImpl.getNumber() == number) {
				sensors.remove(monitorImpl);
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
