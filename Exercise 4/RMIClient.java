
import java.rmi.*;
import java.util.Scanner;

public class RMIClient {
	public static void main(String args[]) throws Exception
	{
		Addition aa = (Addition) Naming.lookup("rmi://localhost:1999/Surya");

        Scanner scan = new Scanner(System.in);
		System.out.println("Enter Two Values to Add : \n");
		int a,b;
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println("Added Value : " + aa.add(a, b));
		
		
	}
}
