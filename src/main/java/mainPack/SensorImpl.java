package mainPack;

import ifaces.IRegistry;
import ifaces.ISensor;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import utils.Connect;
import utils.MessageUtils;
import utils.SensorMessageUtils;
import utils.finals;


public class SensorImpl extends Connect implements ISensor, Serializable {

    private static final long serialVersionUID = 11234443L;
    
    private String position;

    private transient Random random;
    private transient ScheduledExecutorService scheduler;
    private int number;
    private transient String read;

    private transient Gson gson = new Gson();
    
    protected transient IRegistry remoteRegistry;

    public SensorImpl(String ip, int port) {

        setIp(ip);
        setPort(port);
        System.out.println("Tworzenie sensrora: " + port + "  " + ip);
        (new Thread()).start();

        setPosition("0,0");
        scheduler = Executors.newScheduledThreadPool(1);
        randomValue();
    }

    @Override
    public boolean start() {
        return true;
    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public String getReading() {
        return read;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getPosition() {
        return position;
    }

    private void randomValue() {

        final StringBuilder stringBuilder = new StringBuilder();

        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                try {
                    //stateChange();
                } catch (Exception e) {
                    System.err.println("Nie udalo sie pobrac rejestru");
                }
                random = new Random(555);
                stringBuilder.append(random.nextInt(55));
                stringBuilder.append(",     ");
                stringBuilder.append(random.nextInt(15));
            }

        }, 15, 15, TimeUnit.SECONDS);

//        read = stringBuilder.toString();
//        write("registerSensor", finals.MASTER_PORT);
    }

    @Override
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void stateChange(List<String> sensors) {
//        for (Object monitor : remoteRegistry.getObjects(0)) {
//            IMonitor monitorImpl = (IMonitor) monitor;
//            monitorImpl.stateChange();
//        }
    }

    @Override
    public void register() {
        String message = SensorMessageUtils.prepareMessageForOrderToRegistring(getPort(),
                getIp(), gson.toJson(this));
        write(message, finals.MASTER_PORT);
    }

    @Override
    public void unregister() {
        remoteRegistry.unRegister(this.number);
    }

    @Override
    public void checkRequest(String inputMessage) {
        MessageUtils.MessageTuple order = SensorMessageUtils.parseMessage(inputMessage);

        switch (inputMessage) {
        case "setNumber":
            setNumber(Integer.parseInt(order.getContent()));
            break;
        case "getData":
//            stateChange();
            break;
        }
    }

}
