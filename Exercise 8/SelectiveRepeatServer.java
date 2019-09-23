import java.net.*;
import java.util.Random;
import java.io.*;


class SelectiveRepeatServer
{
    public static void main(String args[])
		{
			try
			{
				String str;

                Random rand = new Random();
				ServerSocket ss = new ServerSocket(1234);
				System.out.println("Port No 1234 is Open for Connection. ");
				Socket client = ss.accept(); 
				System.out.println("Connected with "+ client.getInetAddress());
				DataOutputStream bw = new DataOutputStream(client.getOutputStream());
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int r = rand.nextInt(15);
			//	System.out.println("Enter stop to exit");
				for(int i = 0; i < 15;i++)
				{
                    if(i != r)
                    {
					    bw.writeUTF(i + "\n");	
                    }		
                    Thread.sleep(1000);		
				}

                    bw.writeUTF(r+ "\n");
                     Thread.sleep(1000);		
                
				bw.writeUTF("stop");
			}
			catch(Exception e)
			{
				
			}
		}
}
