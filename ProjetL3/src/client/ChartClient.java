package client;

import java.rmi.server.UnicastRemoteObject;

import serveur.Serveur;
import java.rmi.RemoteException;
import java.util.LinkedList;
public class ChartClient<T> extends UnicastRemoteObject implements _ChartClients  {
	

/*
 * serveur donn�
 */
protected Serveur serveur;
///*
// * les clients connect� sur ce serveur
// */
//protected LinkedList <Client> listeClient;
	
	
	/*
	 * le client qui re�oit ou envoie le message au chart
	 */
	private Client client;
	/*
	 * connection du client courant au serveur
	 */
	client.connecter();
	/*
	 * le nom du  Client source de message re�u par le client courant 
	 */
	private String nomClientSource;
	/*
	 *message � envoyer 
	 */
	protected T messageEnv;
	/*
	 * message re�u
	 */
	protected T messageRecu;
	//constructeur
	public ChartClient(T messageEnv){
		this.messageEnv = messageEnv; 
	}
	// r�alisation des m�thode abstract de l'interface _ChartClient
	public T envoieMessage() {
			
			return messageEnv; 
	}
	/*
	 * message re�u par l'un des clients provenant des autres clients connect� au m�me serveur que le client courant
	 * @param message : message envoye au chart qui va �tre recuperer par le client courant
	 * @param clientSource : client qui a envoy� le message sur chat
	 */
	public void messageRecu(T message, Client clientSource) throws RemoteException {
			messageRecu = message;
			nomClientSource = clientSource.getnom();
		}
}