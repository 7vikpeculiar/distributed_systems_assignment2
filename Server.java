import java.rmi.*;

public class Server {
	public static void main(String args[]) {
		try {
			ServerInterface addService = new Action();
			Naming.rebind("AddService", addService); // addService object is hosted with name AddService

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}