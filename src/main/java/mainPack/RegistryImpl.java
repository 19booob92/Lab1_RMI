package mainPack;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import utils.Connect;
import utils.MessageUtils;
import utils.RegistryMessageUtils;


public class RegistryImpl extends Connect implements IRegistry {

    private ArrayList<Object> sensors = new ArrayList<>();
    private ArrayList<Object> monitors = new ArrayList<>();

    private static int id = 0;

    public RegistryImpl() {
        setIp("127.0.0.1");
        setPort(9999);
    }

    private static final long serialVersionUID = -388878129705895055L;

    public int registerObject(Object object, int category)
    {
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

    public boolean unRegister(int number) {
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

    public ArrayList<Object> getObjects(int category) {
        if (category == 0) {
            return monitors;
        } else {
            return sensors;
        }
    }

    private int nextId() {
        return id++;
    }

    @Override
    public void checkRequest(String inputMessage) {
        MessageUtils.Order order = RegistryMessageUtils.parseMessage(inputMessage);
        
        switch (inputMessage) {
        case "RegistrySensor":
            registerObject(order.getContent(), 1);
            break;
        case "RegistryMonitor":
            registerObject(order.getContent(), 0);
            break;
        case "getSensors":
            getObjects(1);
            break;
        }
    }

}
