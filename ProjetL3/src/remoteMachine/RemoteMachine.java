package remoteMachine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import localMachine.Client;

public class RemoteMachine<T> extends UnicastRemoteObject implements _RemoteMachine<T> {
	private static final long serialVersionUID = 2674880711467464646L;
	/*
	 * message à envoyer (?)
	 */
	T messageEnv;
	/*
	 * message reçu (envoye par l'un des client connect )
	 */
	T messageRecu;
	public RemoteMachine()throws RemoteException{
		super();
	}

	/*
	 * envoie d'une message par l'objet distant (serveur)
	 * 
	 */
	public T envoieMessage()throws RemoteException{
		return messageEnv;
	}
	/*
	 * nom du client source de message
	 */
	String nomClientSource;
	/*
	 * message reçu par l'objet distant (serveur) 
	 * qui a été envoye par l'un des clients connecté
	 * @param message : message à recevoir
	 * @param clientSource : client qui a envoyé le message
	 */
	public void messageRecu (T message, Client clientSource) throws RemoteException{
		messageRecu = message;
		nomClientSource = clientSource.getnom();
	}
}
