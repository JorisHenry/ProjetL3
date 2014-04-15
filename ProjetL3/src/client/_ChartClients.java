package client;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  _ChartClients <T> extends Remote {
	/*
	 * envoie d'une message par le client courant
	 */
	public abstract T envoieMessage();
	/*
	 * message re�u par l'un des clients provenant des autres clients connect� au m�me serveur que le client courant
	 * @param message : message envoye au chart qui va �tre recuperer par le client courant
	 * @param clientSource : client qui a envoy� le message sur chat
	 */
	public abstract void messageRecu (T message, T clientSource) throws RemoteException;
}