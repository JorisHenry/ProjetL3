
package Server;

import Client.client;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 */
public class ServerObj extends UnicastRemoteObject implements server
{
    static Registry reg = null;
    List<client> clients = new ArrayList<client>(); // Liste d'utilisateur
    List<String> clientsName = new ArrayList<String>(); // Liste de surnom d'utilisateur
    
    public ServerObj() throws RemoteException {
    	
    }
    
    // Lancer serveur
    public static void StartServer()	{
    	try {
    		reg = java.rmi.registry.LocateRegistry.createRegistry(1099);                        
    		reg.bind("Server", new ServerObj());
    		System.out.println("Server Ready");
    		} 
    		catch (AlreadyBoundException ex) { 
    			ex.printStackTrace(); 
    		} 
    		catch (RemoteException ex) { 
    			ex.printStackTrace(); 
    		}                
    	}
    
    // Terminer serveur
    public static void StopServer()
    {
        try {
            reg.unbind("Server");
            UnicastRemoteObject.unexportObject(reg, true);
            System.out.println("Server Stopped");
        }
        
        catch (RemoteException ex)  {
        	ex.printStackTrace();
        }
        catch (NotBoundException ex) {
            ex.printStackTrace();
        }        
    }
    
    // Quand un client connecter à serveur
    public boolean RegisterToServer(client client, String Name) throws RemoteException
    {
        boolean registe = false;
        try {    
        	System.out.println(clientsName.indexOf(Name));
            if(clientsName.indexOf(Name)>-1) // Le surnom du client a été registé  
            {
            }
            
            else {
                 clients.add(client);      // 
                 clientsName.add(Name); 
                 registe = true;
                 for(int i=0; i < clients.size(); i++)
                 {
                     try
                     {
                         clients.get(i).UpdateUserList(clientsName);
                     }
                     catch(Exception e)
                     {
                    	 e.printStackTrace();
                         clients.remove(i);
                         clientsName.remove(i);
                     }
                 }
             }
                     
         }
         catch(Exception e) {
        	
         }        
         
         return registe;
    }

    // Client envoye un message
    public void MsgToServer(String msg, String FromUser, String ToUser) throws RemoteException
    {
        if(ToUser.equalsIgnoreCase("Tous utilisateurs")) { // Envoye un message a tous utilisateurs                     
            for(int i=0; i < clients.size(); i++)
             {
                 try
                 {
                     if(clientsName.get(i).equals(FromUser)) {
                        clients.get(i).MsgArrived(msg, "Moi");
                     	}
                     
                     else {
                         clients.get(i).MsgArrived(msg, FromUser);
                     }                     
                 }
                 // Si client disonnecter au serveur
                 catch(Exception e) { 
                     System.out.println(e);
                     clients.remove(i);
                     clientsName.remove(i);
                     
                     for(client cl : clients)
                     {
                         cl.UpdateUserList(clientsName);
                     }
                 }
             }
        }
        else
        {
            int count=0;
            for(int i=0; i< clientsName.size(); i++)                
            {
                if(clientsName.get(i).equals(ToUser))
                {    
                    count++;
                    try
                     {
                         clients.get(i).MsgArrived(msg, FromUser);
                     }
                     catch(Exception e)
                     {
                         System.out.println(e);
                         clients.remove(i);
                         clientsName.remove(i);
                         
                         for(client cl : clients)
                        {
                             cl.UpdateUserList(clientsName);
                        }
                         
                         MsgToServer("user " + ToUser +" seems unavailable.", "Server", FromUser);
                         count++;
                     }                                        
                }
                else if(clientsName.get(i).equals(FromUser))
                {
                    count++;
                    try
                     {
                         clients.get(i).MsgArrived(msg, "Moi");
                     }
                     catch(Exception e)
                     {
                         System.out.println(e);
                         clients.remove(i);
                         clientsName.remove(i);
                         
                        for(client icl : clients)
                        {
                             icl.UpdateUserList(clientsName);
                        }                                                  
                     }
                }
                if(count==2)
                {
                    break;                    
                }
            }
        }
    }


    // Client disconnect a serveur
    public void LogoutToServer(client client, String Name) throws RemoteException {
        clients.remove(client);
        clientsName.remove(Name);
        for(client cl : clients)
        {
             cl.UpdateUserList(clientsName);
        }    
    }  
    
}
