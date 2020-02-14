import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class Action extends UnicastRemoteObject implements ServerInterface {
	HashMap<String, Graph> graphBook = new HashMap<String, Graph>();

	Action() throws RemoteException {
		super();
	}

	public int sum(int a, int b) {
		return a + b;
	}

	public int addGraph(String id, int n) {
		// Check and put
		if (this.graphBook.containsKey(id)) {
			System.out.println("Key exists already");
			return 0;
		} else {
			this.graphBook.put(id, new Graph(n));
			return 1;
		}
	}

	public int addEdge(String id, int weight, int vertex1, int vertex2) {
		Graph graph_with_id = graphBook.get(id);
		graph_with_id.addEdge(vertex1, vertex2, weight);
		return 1;
	};

	public int getMST(String id) {
		return this.graphBook.get(id).MST();
	}

	public int print(String id) {
		this.graphBook.get(id).print();
		return 0;
	}

	// public int print(){
		// for()
	// }

}