package localMachine;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _RemoteMachine extends Remote {

	/*
	 * envoie d'une message par l'objet distant (serveur)
	 * 
	 */
	public  void envoieMessage() throws RemoteException;;
	/*
	 * message re�u par l'objet distant (serveur) 
	 * qui a �t� envoye par l'un des clients connect�
	 * @param message : message � recevoir
	 * @param clientSource : client qui a envoy� le message
	 */
	public void messageRecu (String message, Client clientSource) throws RemoteException;

}
