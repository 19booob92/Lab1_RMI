package mainPackage;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import view.SensorWindow;


public class SensorMain {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        SensorWindow sensorWindow = new SensorWindow();
    }
}
