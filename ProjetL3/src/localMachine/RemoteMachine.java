package localMachine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMachine extends UnicastRemoteObject implements _RemoteMachine {
	
	protected RemoteMachine() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * message � envoyer (?)
	
	public RemoteMachine()throws RemoteException{
		super();
	}

	/*
	 * envoie d'une message par l'objet distant (serveur)
	 * 
	 */
	String messageEnv;
	public void envoieMessage()throws RemoteException{
		
	}
	/*
	 * nom du client source de message
	 */
	String nomClientSource;
	/*
	 * message re�u par l'objet distant (serveur) 
	 * qui a �t� envoye par l'un des clients connect�
	 * @param message : message � recevoir
	 * @param clientSource : client qui a envoy� le message
	 */
	public void messageRecu (String message, Client clientSource) throws RemoteException{
		String messageRecu = message;
		nomClientSource = clientSource.getnom();
	}
		
}
