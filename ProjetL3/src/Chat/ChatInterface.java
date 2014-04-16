package Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
	
	String chat(String s)throws RemoteException;
	
}