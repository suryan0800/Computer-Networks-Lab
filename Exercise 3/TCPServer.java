package networks;

import java.net.*;

import java.io.*;


public class TCPServer {
		
	static String  encrypt (String str, int j)
	{
		StringBuffer sb = new StringBuffer(str);
		// System.out.println((int)sb.charAt(0));
		
		for(int i = 0; i < sb.length(); i++)
		{
			if(Character.isUpperCase(sb.charAt(i)))
			{
				sb.setCharAt(i, (char)((sb.charAt(i) - 65 + j)% 26 + 65) );
			}
			else if(Character.isLowerCase(sb.charAt(i)))
			{
				sb.setCharAt(i, (char)((sb.charAt(i) - 97 + j)% 26 + 97) );
			}
			
		}
		
		return new String(sb);
	}
	
	
		public static void main(String args[])
		{
			try
			{
				String str;
				ServerSocket ss = new ServerSocket(1234);
				System.out.println("Port No 1234 is Open for Connection. ");	
				Socket client = ss.accept(); 
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				DataOutputStream bw = new DataOutputStream(client.getOutputStream());
				bw.writeUTF("Enter Key : ");
				DataInputStream bz = new DataInputStream(client.getInputStream());
				int key = Integer.parseInt(bz.readUTF());
				System.out.println("Connected with "+ client.getInetAddress());
				System.out.println("Enter stop to exit");
				while(!(str = br.readLine()).equals("stop"))
				{
					bw.writeUTF(encrypt(str,key) + "\n");
										
				}
				bw.writeUTF("stop");
			}
			catch(Exception e)
			{
				
			}
		}
}
