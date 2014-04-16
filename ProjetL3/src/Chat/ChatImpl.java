package Chat;

import java.rmi.*;
import java.rmi.server.*;

public class ChatImpl extends UnicastRemoteObject implements ChatInterface {
	private ServerUI ui;
	
	public ChatImpl() throws RemoteException
	{
	}
	
	public ChatImpl(ServerUI ui) throws RemoteException
	{
	this.ui=ui;
	}

	public String chat(String s) throws RemoteException {
		ui.addItem("Messaage from client: "+s);
		return s;
	}

}