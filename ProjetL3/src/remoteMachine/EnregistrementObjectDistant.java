package remoteMachine;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class EnregistrementObjectDistant {
	/**
	 * @param args[0] : port
	 */
	public static void main(String[] args) {
		if (args.length!=1){
			System.out.println("le port SVP!");
			System.exit(1);
		}
		try {
			/*
			 * lancement dynamique de registres de noms avant d'enregistre un objet
			 */
			LocateRegistry.createRegistry(Integer.parseInt(args[0]));
			/*
			 *  mise en place d'un security manager
			 */
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			/*
			 * instanciation d'un objet de la classe distante
			 */
			RemoteMachine serveur = new RemoteMachine();
			 
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/remoteMachine";
			/*
			 * Enregistrement de l'objet avec l'url
			 */
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			
			Naming.rebind(url, serveur);
			
			System.out.println("Serveur lancé");
			
			} catch (RemoteException e) {
			e.printStackTrace();
			} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (UnknownHostException e) {
			e.printStackTrace();
			}
	}

}
