
package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**

 */
public class ClientObj  extends UnicastRemoteObject  implements client
{       
    public ClientObj() throws RemoteException    {
        
    }
   
    public void MsgArrived(String msg, String FromUser) throws RemoteException    {
        Chat_interface._MsgArrived(msg, FromUser);
    }
   
    public void UpdateUserList(List<String> ClientsName) throws RemoteException    {
        Chat_interface._UpdateUserList(ClientsName);
    }
}
