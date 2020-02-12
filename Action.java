import java.rmi.*;
import java.rmi.server.*;

public class Action extends UnicastRemoteObject implements ServerInterface
{
	HashMap<String, Graph> hmap = new HashMap<String, Graph>();
	Action()throws RemoteException{
	super();
}
public int add(int a,int b)
{
	return a+b;
}
public int 
}