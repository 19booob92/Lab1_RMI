package mainPack;


import static java.lang.System.out;
import ifaces.IMonitor;
import ifaces.IRegistry;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import utils.Connect;
import utils.MessageUtils;
import utils.MonitorMessageUtils;
import utils.SensorMessageUtils;
import utils.finals;


public class MonitorImpl extends Connect implements IMonitor {

    private static final long serialVersionUID = -1994726035869244103L;
    private int number;

    private Gson gson = new Gson();

    protected IRegistry remoteRegistry;

    public MonitorImpl(String ip, int port) throws RemoteException, NotBoundException, MalformedURLException {

        setIp(ip);
        setPort(port);
        System.err.println("Created Monitor");

        Thread listenThread = new Thread() {

            @Override
            public void run() {
                try {
                    checkConnections();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        listenThread.start();
    }

    public void change() {
        out.println("zmienio stan");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void stateChange(List<String> sensors) {

        for (Object sensorId : sensors) {
            System.out.println("id : " + sensorId);
        }
    }

    private void getSensorsFromRegister() {
        String message = MonitorMessageUtils.prepareMessageForOrderToFetchObjects(getPort(), getIp());
        write(message, finals.MASTER_PORT);
    }

    @Override
    public void register() {
        String message = MonitorMessageUtils.prepareMessageForOrderToRegistring(getPort(), getIp());
        write(message, finals.MASTER_PORT);

        getSensorsFromRegister();
    }

    @Override
    public void unregister() {
        remoteRegistry.unRegister(this.number);
    }

    private List<String> convertStringToString(String content) {
        List<String> sensors;
        sensors = Arrays.asList(content.split(","));
        return sensors;
    }

    @Override
    public void checkRequest(String inputMessage) {
        MessageUtils.MessageTuple order = SensorMessageUtils.parseMessage(inputMessage);

        switch (order.getRequest()) {
        case "sensorsData":
            stateChange(convertStringToString(order.getContent()));
            break;
        case "StatusChanged":
            SensorImpl sensor = gson.fromJson(order.getContent(), SensorImpl.class);
            System.out.println("Zmieniono stan sensora na porcie : "
                    + sensor.getPort()
                    + " o id: " + sensor.getNumber() + " pozycja "
                    + sensor.getPosition());
            break;
        }
    }
}
