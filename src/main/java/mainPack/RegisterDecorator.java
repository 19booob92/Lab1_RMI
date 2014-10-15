package mainPack;



import java.rmi.RemoteException;

public abstract class RegisterDecorator {

	protected IRegistry remoteRegistry;
	
	abstract protected void stateChange() throws RemoteException;
	
	
	
}
