package client;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client1 {
	
	public static void main(String[] zero) {
		
		Socket socket;

		try {
		
		    // socket = new Socket(InetAddress.getLocalHost(),2009);
			socket = new Socket("130.190.28.29",2009, InetAddress.getLocalHost(), 2009);
	             socket.close();

		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
