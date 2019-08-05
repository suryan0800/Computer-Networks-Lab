package networks;

import java.rmi.*;

public class RMIClient {
	public static void main(String args[]) throws Exception
	{
		Addition a = (Addition) Naming.lookup("rmi://localhost:1999/Pravin");
		
		System.out.println("Added Value : " + a.add(10, 50));
	}
}
