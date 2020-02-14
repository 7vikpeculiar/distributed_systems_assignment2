import java.rmi.*;
import java.util.Scanner; // Import the Scanner class

public class Client {
	public static void main(String args[]) {
		try {
			ServerInterface st = (ServerInterface) Naming.lookup("rmi://" + args[0] +":" + args[1]+ "/AddService");
			Scanner inpScanner = new Scanner(System.in);
			String input;
			while (inpScanner.hasNext()) {
				input = inpScanner.nextLine();
				if (input == null) {
					break;
				}
				String[] input_words = input.split(" ");
				switch (input_words[0]) {
				case "add_graph":
					st.addGraph(input_words[1], Integer.parseInt(input_words[2]));
					break;

				case "add_edge":
					// add_edge id, u , v, w
					st.addEdge(input_words[1], Integer.parseInt(input_words[4]), Integer.parseInt(input_words[2]) - 1,
							Integer.parseInt(input_words[3]) - 1);
					break;

				case "get_mst":
					System.out.println(st.getMST(input_words[1]));
					break;

				case "print_graph":
					st.print(input_words[1]);
				}
			}
			inpScanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}