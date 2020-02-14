import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			ServerInterface st = (ServerInterface) Naming.lookup("rmi://" + args[0] + "/AddService");
			if (args[1].equals("1")) {
				st.addGraph("a", 4);
				st.addEdge("a", 10, 0, 1);
				st.addEdge("a", 6, 0, 2);
				st.addEdge("a", 5, 0, 3);
				st.addEdge("a", 15, 1, 3);
				st.addEdge("a", 4, 2, 3);
				System.out.println(st.print("a"));
				System.out.println("Print out");
				System.out.println(st.getMST("a"));
			} else if (args[1].equals("2")) {
				// st.addGraph("a", 2);
				// st.addEdge("a", 5, 1, 2);
				// st.addEdge("a", 6, 2, 1);
				
				System.out.println(st.getMST("a"));
			}
			// System.out.println(st.print(""));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}