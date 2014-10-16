package mainPackage;

import java.awt.EventQueue;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import javax.sql.PooledConnection;

import view.SensorWindow;


public class SensorMain {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        SensorWindow sensorWindow = new SensorWindow();
    }
}
