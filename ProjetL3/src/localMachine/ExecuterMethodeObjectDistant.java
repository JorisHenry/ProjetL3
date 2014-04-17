package localMachine;

import java.io.EOFException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ExecuterMethodeObjectDistant {
	
	

	public static void main(String[] args) throws NumberFormatException, RemoteException {
		
		System.setProperty("java.security.policy", "E:/Users/mil/git/ProjetL3/ProjetL3/src/localMachine/security.policy");
		/*
		 *  mise en place d'un security manager
		 */
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		/*
		 * reference sur l'objet distant
		 */
		try {
			
			_RemoteMachine remote = (_RemoteMachine)Naming.lookup("rmi://localhost/remoteMachine");
			System.out.println(remote);
//			if (remote instanceof _RemoteMachine) {
//				String message = (String)((_RemoteMachine) remote).envoieMessage();
//				//System.out.println("chaine renvoyee = " + s);
//			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}
}
