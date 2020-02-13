import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			ServerInterface st = (ServerInterface) Naming.lookup("rmi://" + args[0] + "/AddService");
			// if (args[1] != null) {
			st.addGraph("a", 2);
			st.addEdge("a", 5, 1, 2);
			st.addEdge("a", 4, 1, 2);
			st.addEdge("a", 6, 2, 1);
			System.out.println(st.print("a"));
			// } else if (args[2] == "2") {
			// st.addGraph("a", 2);
			// st.addEdge("a", 5, 1, 2);
			// st.addEdge("a", 6, 2, 1);
			// System.out.println(st.print("a"));
			// }
			// System.out.println(st.print(""));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}