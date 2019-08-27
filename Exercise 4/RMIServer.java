
import java.rmi.*;



public class RMIServer 
{
	public static void main(String args[]) throws Exception
	{
		Addition a = new Calc();
		Naming.rebind("rmi://localhost:1999/Surya",a);
		
	}
}
