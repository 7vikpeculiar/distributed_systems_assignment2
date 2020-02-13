import java.rmi.*;

public interface ServerInterface extends Remote {
    public int sum(int a, int b) throws RemoteException;

    public int addGraph(String id, int n) throws RemoteException;

    public int addEdge(String id, int weight, int vertex1, int vertex2) throws RemoteException;

    public int getMST(String id) throws RemoteException;

    public int print(String id) throws RemoteException;
}