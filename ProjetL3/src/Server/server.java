package Server;

import Client.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 */
public interface server extends Remote
{   

    public boolean RegisterToServer(client client, String Name) throws  RemoteException;
    
    public void MsgToServer(String msg, String FrmUser, String ToName) throws RemoteException;
    
    public void LogoutToServer(client client, String Name) throws RemoteException;
}
