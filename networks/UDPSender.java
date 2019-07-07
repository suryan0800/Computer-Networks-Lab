package networks;

import java.net.*;
import java.io.*;


public class UDPSender {
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str,host;
			System.out.println("Enter Receiver name or address :");
			host = br.readLine();
			InetAddress ia = InetAddress.getByName(host);
			DatagramSocket ds = new DatagramSocket();
			System.out.println("Enter stop to exit");
			while(!(str = br.readLine()).equals("stop"))
			{
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 1234);
				ds.send(dp);
				
			}
			str = "stop";
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, 1234);
			ds.send(dp);
		
		}
		catch(Exception e)
		{
			
		}
		
	}
}
