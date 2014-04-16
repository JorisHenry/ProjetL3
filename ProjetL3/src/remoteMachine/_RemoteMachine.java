package remoteMachine;

import java.rmi.Remote;
import java.rmi.RemoteException;

import localMachine.Client;

public interface _RemoteMachine <T> extends Remote {

	/*
	 * envoie d'une message par l'objet distant (serveur)
	 * 
	 */
	public abstract T envoieMessage()throws RemoteException;
	/*
	 * message reçu par l'objet distant (serveur) 
	 * qui a été envoye par l'un des clients connecté
	 * @param message : message à recevoir
	 * @param clientSource : client qui a envoyé le message
	 */
	public abstract void messageRecu (T message, Client clientSource) throws RemoteException;

}
