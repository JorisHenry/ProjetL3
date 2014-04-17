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
	 * message reçu par l'objet distant (serveur) 
	 * qui a été envoye par l'un des clients connecté
	 * @param message : message à recevoir
	 * @param clientSource : client qui a envoyé le message
	 */
	public void messageRecu (String message, Client clientSource) throws RemoteException;

}
