package networks;

import java.net.*;
import java.io.*;

public class UDPReceiver {
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str,host;
			byte bt[] = new byte[1000];
			
			DatagramSocket ds = new DatagramSocket(1234);
			
			DatagramPacket dp = new DatagramPacket(bt, 1000);
			ds.receive(dp);
			
			System.out.println("Received : ");
			FileWriter fw = new FileWriter(new File("Received.txt"));
			fw.write("Received : " + "\n");
			while(!(str = new String(dp.getData())).trim().equals("stop"))
			{
				System.out.println(str);
				fw.append(str.trim() + "\n");
				bt = new byte[1000];
				dp = new DatagramPacket(bt, 1000);
				ds.receive(dp);				
			}
			fw.close();
		}
		catch(Exception e)
		{
			
		}
	}
}
