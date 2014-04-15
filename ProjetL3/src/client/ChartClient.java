package client;

import java.rmi.server.UnicastRemoteObject;

import serveur.Serveur;
import java.rmi.RemoteException;
import java.util.LinkedList;
public class ChartClient<T> extends UnicastRemoteObject implements _ChartClients  {
	

/*
 * serveur donné
 */
protected Serveur serveur;
///*
// * les clients connecté sur ce serveur
// */
//protected LinkedList <Client> listeClient;
	
	
	/*
	 * le client qui reçoit ou envoie le message au chart
	 */
	private Client client;
	/*
	 * connection du client courant au serveur
	 */
	client.connecter();
	/*
	 * le nom du  Client source de message reçu par le client courant 
	 */
	private String nomClientSource;
	/*
	 *message à envoyer 
	 */
	protected T messageEnv;
	/*
	 * message reçu
	 */
	protected T messageRecu;
	//constructeur
	public ChartClient(T messageEnv){
		this.messageEnv = messageEnv; 
	}
	// réalisation des méthode abstract de l'interface _ChartClient
	public T envoieMessage() {
			
			return messageEnv; 
	}
	/*
	 * message reçu par l'un des clients provenant des autres clients connecté au même serveur que le client courant
	 * @param message : message envoye au chart qui va être recuperer par le client courant
	 * @param clientSource : client qui a envoyé le message sur chat
	 */
	public void messageRecu(T message, Client clientSource) throws RemoteException {
			messageRecu = message;
			nomClientSource = clientSource.getnom();
		}
}