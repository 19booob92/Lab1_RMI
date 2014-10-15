package mainPack;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISensor extends Remote{
	
	boolean start() throws RemoteException;
	boolean stop() throws RemoteException;
	String getReading() throws RemoteException;
	void setPosition(String position) throws RemoteException;
	String getPosition() throws RemoteException;
	int getNumber() throws RemoteException;
}
