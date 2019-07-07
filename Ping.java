package networks;

import java.util.Scanner;
public class Ping {
	public static void main(String args[]) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter IP Address to Ping :");
		String str = scan.nextLine();
		scan.close();
		Runtime rt = Runtime.getRuntime();
		Process p  = rt.exec("ping " + str + " -c 3");
		Thread.sleep(1000);
		Scanner red = new Scanner(p.getInputStream());
		while(red.hasNext())
		{
			System.out.println(red.nextLine());
			
		}
	}
}
