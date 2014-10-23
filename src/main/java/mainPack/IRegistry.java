package mainPack;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IRegistry {

	int registerObject(Object sensor, int category); // 1 : sensor
																			// 0 : monitor
	boolean unRegister(int number);				// < 0 : blad
	ArrayList<Object> getObjects(int category);
}
