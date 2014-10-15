package mainPack;


import java.rmi.RemoteException;

public interface IMonitor {
	void change() throws RemoteException;
	int getNumber() throws RemoteException;
	void refresh() throws RemoteException;
}
