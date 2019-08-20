
import java.io.*;
import java.net.*;

public class BitStuffingServer {
	
	static String stuffing(String str)
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
				sb.append('0');
				count = 0;
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
			System.out.println("Connected with "+ client.getInetAddress());
			DataOutputStream bw = new DataOutputStream(client.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter stop to exit");
			while(!(str = br.readLine()).equals("stop"))
			{
				bw.writeUTF("01111110" + stuffing(str) + "01111110" + "\n");
									
			}
			bw.writeUTF("stop");
		}
		catch(Exception e)
		{
			
		}
	}
}
