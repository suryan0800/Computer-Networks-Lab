
import java.io.*;
import java.net.*;

public class BitStuffingClient {
	
	static String stuffingExtract(String str)
	{
		
		StringBuffer sb = new StringBuffer();
		int count = 0;
		
		for(int i = 0; i < str.length(); i++ )
		{
			if(str.charAt(i) == '1')
			{
				sb.append(str.charAt(i));
				count++;
			}
			else
			{
				sb.append(str.charAt(i));
				count = 0; 
			}
			if(count == 5)
			{
				i++;
				count = 0;
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
		
			DataInputStream br1 = new DataInputStream(s.getInputStream());
			FileWriter fw = new FileWriter(new File("Received.txt"));
			fw.write("Received from : " + str + "\n");
			while(!(str1 = br1.readUTF()).equals("stop"))
			{
				
				System.out.println(str1);
				str1 = str1.replaceAll("01111110", "");
				System.out.println(stuffingExtract(str1));
				fw.append(stuffingExtract(str1));
			}
			fw.close();
			
			
		}
		catch(Exception e)
		{
			
		}
	}
}
