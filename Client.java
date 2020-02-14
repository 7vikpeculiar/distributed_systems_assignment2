import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			ServerInterface st = (ServerInterface) Naming.lookup("rmi://" + args[0] + "/AddService");
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
			// System.out.println(st.print(""));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}