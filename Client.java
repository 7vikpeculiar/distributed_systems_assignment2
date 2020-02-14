import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			ServerInterface st = (ServerInterface) Naming.lookup("rmi://" + args[0] + "/AddService");
<<<<<<< HEAD
			// if (args[1] != null) {
			st.addGraph("a", 2);
			st.addEdge("a", 5, 0, 1);
			st.addEdge("a", 4, 1, 0);
			st.addEdge("a", 6, 1, 0);
			System.out.println(st.print("a"));
			System.out.println(st.getMST("a"));
			// } else if (args[2] == "2") {
			// st.addGraph("a", 2);
			// st.addEdge("a", 5, 1, 2);
			// st.addEdge("a", 6, 2, 1);
			// System.out.println(st.print("a"));
			// }
=======
			System.out.println("arg[1} is " + args[1]);
			if (args[1].equals("a")) {
				System.out.println("here");

				st.addGraph("a", 2);
				st.addEdge("a", 5, 1, 2);
				st.addEdge("a", 4, 1, 2);
				st.addEdge("a", 6, 2, 1);
				st.addEdge("a", 4, 2, 1);
				System.out.println(st.print("a"));
			} else if ((args[1].equals("aa"))) {
				// st.addGraph("aa", 2);
				st.addEdge("a", 5, 1, 2);
				// st.addEdge("aa", 6, 2, 1);
				System.out.println(st.print("a"));
			}
>>>>>>> f6f711389bb0448aed7e6498070eb1d52dc4082e
			// System.out.println(st.print(""));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}