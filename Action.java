import java.rmi.*;
import java.rmi.server.*;
public class Action extends UnicastRemoteObject implements ServerInterface
{
	Action()throws RemoteException{
	super();
}
public int sum(int a,int b)
{
	return a+b;
}
}