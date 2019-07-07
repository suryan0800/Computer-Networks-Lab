package networks;

import java.net.*;
import java.io.*;


public class TCPClient {
	public static void main(String args[])
	{
		try
		{
			String str,str1;
			int port;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Host Name or Address : ");
			
			str = br.readLine();
			System.out.println("Enter Port Number : ");
			port = Integer.parseInt(br.readLine());
			Socket s = new Socket(str,port);
		
			DataInputStream br1 = new DataInputStream(s.getInputStream());
			FileWriter fw = new FileWriter(new File("Received.txt"));
			fw.write("Received from : " + str + "\n");
			while(!(str1 = br1.readUTF()).equals("stop"))
			{
				
				System.out.println(str1);
				fw.append(str1);
			}
			fw.close();
			
			
		}
		catch(Exception e)
		{
			
		}
	}
}
