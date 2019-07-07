package networks;

import java.net.*;
import java.util.Scanner;

public class Ip
{
    public static void main(String args[]) 
    {
    	try
    	{
    	
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter IP Address or Name ");
        String str = scan.nextLine();
        
        InetAddress ia = InetAddress.getByName(str);

        System.out.println("Host Name " +ia.getHostName());
        System.out.println("Host IP Address " + ia.getHostAddress());
        System.out.println("Is the Website Reachable " + ia.isReachable(100));
        
    	}
    	catch(Exception e)
    	{
    		System.out.print("Exception : Unable to find such Website.");
    	}
        
    }
}

