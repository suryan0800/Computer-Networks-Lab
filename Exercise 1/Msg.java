
import java.util.Scanner;
public class Msg{
	public static void main(String args[]) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter IP Address of Receiver :");
		String str = scan.nextLine();
		System.out.println("Enter Message to Send :");
		String ss = scan.nextLine();
		
		scan.close();
		Runtime rt = Runtime.getRuntime();
		Process p  = rt.exec("net send " + str +" " +  ss);
		Thread.sleep(1000);
		Scanner red = new Scanner(p.getInputStream());
		while(red.hasNext())
		{
			System.out.println(red.nextLine());
			
		}
	}
}
