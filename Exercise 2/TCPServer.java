
import java.net.*;

import java.io.*;


public class TCPServer {
	
		public static void main(String args[])
		{
			try
			{
				String str;
				ServerSocket ss = new ServerSocket(1234);
				System.out.println("Port No 1234 is Open for Connection. ");
				Socket client = ss.accept(); 
				System.out.println("Connected with "+ client.getInetAddress());
				DataOutputStream bw = new DataOutputStream(client.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter stop to exit");
				while(!(str = br.readLine()).equals("stop"))
				{
					bw.writeUTF(str + "\n");
										
				}
				bw.writeUTF("stop");
			}
			catch(Exception e)
			{
				
			}
		}
}
