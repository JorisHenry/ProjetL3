package localMachine;

import java.rmi.Naming;

public class Client {
	private String nom;
	public Client(String nom){
		this.nom = nom;
	}
	public String getnom(){
		return nom;
	}
	
}
