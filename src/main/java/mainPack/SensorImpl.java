package mainPack;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import utils.RegistryUtils;


public class SensorImpl extends RegisterDecorator implements ISensor {

    private String position;
    private Random random;
    private ScheduledExecutorService scheduler;
    private int number;
    private String read;

    private Registry registry;

    public SensorImpl(String ip, int port) throws RemoteException, NotBoundException {
        setPosition("0,0");
        registry = RegistryUtils.setRegistry(ip, port);
        remoteRegistry = (IRegistry) registry.lookup("remoteRegisty");
        scheduler = Executors.newScheduledThreadPool(1);
        randomValue();
    }

    @Override
    public boolean start() throws RemoteException {
        return true;
    }

    @Override
    public boolean stop() throws RemoteException {
        return false;
    }

    @Override
    public String getReading() throws RemoteException {
        return read;
    }

    @Override
    public void setPosition(String position) throws RemoteException {
        this.position = position;
    }

    @Override
    public String getPosition() throws RemoteException {
        return position;
    }

    private void randomValue() {

        final StringBuilder stringBuilder = new StringBuilder();

        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                try {
                    stateChange();

                } catch (RemoteException e) {
                    System.err.println("Nie udalo sie pobrac rejestru");
                }
                random = new Random(555);
                stringBuilder.append(random.nextInt(55));
                stringBuilder.append(",     ");
                stringBuilder.append(random.nextInt(15));
            }

        }, 1, 1, TimeUnit.MINUTES);

        read = stringBuilder.toString();
    }

    @Override
    public int getNumber() throws RemoteException {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected void stateChange() throws RemoteException {
        for (Object monitor : remoteRegistry.getObjects(1)) {
            MonitorImpl monitorImpl = (MonitorImpl) monitor;
            monitorImpl.change();
        }
    }

}
