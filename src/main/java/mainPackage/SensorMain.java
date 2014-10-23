package mainPackage;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import utils.Connect;
import view.SensorWindow;


public class SensorMain extends Connect{

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        new SensorWindow();
        
    }

    @Override
    public void checkRequest(String inputMessage) {
    }
    
    
}
