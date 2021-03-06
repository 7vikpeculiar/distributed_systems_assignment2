import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String args[]) {
		try {
			String server_uri = "rmi://0.0.0.0:" + args[0]+"/AddService";
			ServerInterface addService = new Action();
			LocateRegistry.createRegistry(Integer.valueOf(args[0]));
			Naming.rebind(server_uri,addService); // addService object is hosted with name AddService

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}