package mainPack;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IRegistry extends Remote {

	int registerObject(Object sensor, int category) throws RemoteException; // 1 : sensor
																			// 0 : monitor
	boolean unRegister(int number) throws RemoteException;				// < 0 : b��d
	ArrayList<Object> getObjects(int category) throws RemoteException;
}
