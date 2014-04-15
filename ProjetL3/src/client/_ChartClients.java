package client;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  _ChartClients <T> extends Remote {
	/*
	 * envoie d'une message par le client courant
	 */
	public abstract T envoieMessage();
	/*
	 * message reçu par l'un des clients provenant des autres clients connecté au même serveur que le client courant
	 * @param message : message envoye au chart qui va être recuperer par le client courant
	 * @param clientSource : client qui a envoyé le message sur chat
	 */
	public abstract void messageRecu (T message, T clientSource) throws RemoteException;
}