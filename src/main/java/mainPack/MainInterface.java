package mainPack;

import java.rmi.RemoteException;


public interface MainInterface {

    void stateChange() throws RemoteException;
    void register() throws RemoteException;
    void unregister() throws RemoteException;
    
}
