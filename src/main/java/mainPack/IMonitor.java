package mainPack;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMonitor extends Remote, MainInterface {
	void change() throws RemoteException;
	int getNumber() throws RemoteException;
}
