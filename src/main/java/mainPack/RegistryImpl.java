package mainPack;

import ifaces.IRegistry;

import java.util.HashMap;

import com.google.gson.Gson;

import utils.Connect;
import utils.RegistryMessageUtils;
import utils.MessageUtils.MessageTuple;

public class RegistryImpl extends Connect implements IRegistry {

    public HashMap<Integer, Integer> monitors  = new HashMap<>();
    public HashMap<Integer, Integer> sensors = new HashMap<>();
    private int inputPort = 0;
    private static int id = 0;

    private Gson gson = new Gson();
    
    public RegistryImpl() {
        setIp("127.0.0.1");
        setPort(9999);
    }

    public int registerObject(Object object, int category)
    {
        if (category == 0) {
            monitors.put(nextId(), Integer.parseInt((String) object));
            System.err.println("Registred Monitor");
            return nextId();
        } else {
            SensorImpl sensor = (SensorImpl) object;
            sensors.put(nextId(), sensor.getPort());
            System.err.println("Registred Sensor " + sensor.getPosition());
            return nextId();
        }
    }

    public boolean unRegister(int number) {
        for (int sensorId : sensors.keySet()) {
            if (sensorId == number) {
                sensors.remove(sensorId);
                System.err.println("deleted " + sensorId);
                return true;
            }
        }
        for (int monitorId : monitors.keySet()) {
            if (monitorId == number) {
                sensors.remove(monitorId);
                System.err.println("deleted " + monitorId);
                return true;
            }
        }
        return false;
    }

    public void getObjects(int category) {

        StringBuilder sensorsString = new StringBuilder();
        
        if (category == 0) {
            for (Integer port : monitors.values()) {
                sensorsString.append(port);
                sensorsString.append(",");
            }
            System.err.println("Numer portu sensora :" + inputPort);
            write(RegistryMessageUtils.prepareMessageForSendingSensors(
                    sensorsString.toString(), getPort(),
                    getIp()), inputPort);
        } else {
            for (Integer sId : sensors.keySet()) {
                sensorsString.append(sId);
                sensorsString.append(",");
            }
            System.err.println("Numer portu monitora :" + inputPort);
            write(RegistryMessageUtils.prepareMessageForSendingSensors(
                    sensorsString.toString(), getPort(),
                    getIp()), inputPort);
        }
    }

    private int nextId() {
        return id++;
    }

    @Override
    public void checkRequest(String inputMessage) {
        System.err.println("dostalem : " + inputMessage);
        
        MessageTuple body = RegistryMessageUtils.parseMessage(inputMessage);
        
        switch (body.getRequest()) {
        case "RegistrySensor":
            SensorImpl sensorsToAdd = gson.fromJson(body.getContent(), SensorImpl.class);
            registerObject(sensorsToAdd, 1);
            break;
        case "RegistryMonitor":
            registerObject(body.getContent(), 0);
            break;
        case "GetSensors":
            inputPort = Integer.parseInt(body.getContent());
            getObjects(1);
            break;
        case "GetMonitors":
            inputPort = Integer.parseInt(body.getContent());
            getObjects(0);
            break;
        }
    }

}
