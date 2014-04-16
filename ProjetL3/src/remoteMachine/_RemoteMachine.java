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
	 * message re�u par l'objet distant (serveur) 
	 * qui a �t� envoye par l'un des clients connect�
	 * @param message : message � recevoir
	 * @param clientSource : client qui a envoy� le message
	 */
	public abstract void messageRecu (T message, Client clientSource) throws RemoteException;

}
