package networks;

import java.net.*;
import java.io.*;


public class TCPClient {
	
	static String decrypt(String str,int j)
	{
		StringBuffer sb = new StringBuffer(str);
		// System.out.println((int)sb.chart(0));
		
		for(int i = 0; i < sb.length(); i++)
		{
			if(Character.isUpperCase(sb.charAt(i)))
			{
				sb.setCharAt(i, (char)((sb.charAt(i) - 65 + 26 - j)% 26 + 65) );
			}
			else if(Character.isLowerCase(sb.charAt(i)))
			{
				sb.setCharAt(i, (char)((sb.charAt(i) - 97 + 26 - j)% 26 + 97) );
			}
			
		}
		
		return new String(sb);
		
	}
	
	
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
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			DataInputStream br1 = new DataInputStream(s.getInputStream());
			str1 = br1.readUTF();
			System.out.println(str1);
			int key = Integer.parseInt(br2.readLine());
			DataOutputStream bz = new DataOutputStream(s.getOutputStream());
		    bz.writeUTF(key+""); 
			FileWriter fw = new FileWriter(new File("Received.txt"));
			fw.write("Received from : " + str + "\n");
			while(!(str1 = br1.readUTF()).equals("stop"))
			{
				str1 = decrypt(str1,key);
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
