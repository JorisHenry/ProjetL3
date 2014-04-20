
package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**

 */
public interface client extends Remote{   
	
	/**	Mettre à jour la liste de utilisateur en ligne	*/
    public void UpdateUserList(List<String> ClientsName) throws RemoteException;
    
    /** Afficher le message d'utilisateur  	*/
    public void  MsgArrived(String msg, String FromUser) throws RemoteException;            
}
