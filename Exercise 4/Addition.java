package networks;

import java.rmi.*;
import java.rmi.server.*;

public interface Addition extends Remote {
	int add(int a,int b) throws RemoteException;
}

class Calc  extends UnicastRemoteObject  implements Addition 
{
	Calc() throws Exception
	{
		super();
	}
	
	public int add(int a,int b) throws RemoteException
	{
		int c = a + b;
		return c;
	}
}
