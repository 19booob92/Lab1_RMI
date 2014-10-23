package mainPack;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMonitor extends MainInterface {
	void change() ;
	int getNumber() ;
}
