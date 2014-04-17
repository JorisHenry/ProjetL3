package localMachine;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class serveur {
	/**
	 * @param args[0] : port
	 */
	static Registry registry=null;
	private static int port=1099;
	public static void main(String[] args) throws RemoteException {
//		if (args.length!=1){
//			System.out.println("le port SVP!");
//			System.exit(1);
//		}
		System.setProperty("java.security.policy", "E:/Users/mil/git/ProjetL3/ProjetL3/src/localMachine/security.policy");
		String url = "remote";
		try {
			if (System.getSecurityManager()== null) { System.setSecurityManager(new RMISecurityManager()); }
				if((registry=LocateRegistry.getRegistry(port))==null) registry=LocateRegistry.createRegistry(port);
				RemoteMachine r=new RemoteMachine();
			registry.rebind("remote", r);
			System.out.println("Tous les objets sont enregistrés dans le serveur d'objets distants"); 
			System.out.println("Serveur lancé");
			
			} catch (RemoteException e) {
			e.printStackTrace();
//			} catch (MalformedURLException e) {
//			e.printStackTrace();
//			} catch (UnknownHostException e) {
//			e.printStackTrace();
			}
	}

}
