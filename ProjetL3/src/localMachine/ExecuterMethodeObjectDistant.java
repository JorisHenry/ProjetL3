package localMachine;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import remoteMachine._RemoteMachine;

public class ExecuterMethodeObjectDistant {

	public static void main(String[] args) throws NumberFormatException, RemoteException {
		LocateRegistry.createRegistry(Integer.parseInt(args[0]));
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
			String url = "//localhost/serveur";
			Remote r = Naming.lookup(url);
			System.out.println(r);
			if (r instanceof _RemoteMachine) {
				String message = (String)((_RemoteMachine) r).envoieMessage();
				//System.out.println("chaine renvoyee = " + s);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
