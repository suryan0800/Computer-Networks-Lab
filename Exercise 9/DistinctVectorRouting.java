package networks;

import java.util.Scanner;

public class DistinctVectorRouting {
	public static void main(String args[])
	{
		int node;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter No of Nodes : ");
		node = scan.nextInt();
		int dist[][] = new int[node][node];
		int via [][] = new int [node][node];
		for(int i = 0; i < node;i++ )
		{
			for(int j = 0; j < node; j++)
			{
				if(i == j)
				{
					dist[i][j] = 0;
					via[i][j] = i;
				
				}
				else
				{
					dist[i][j] = Integer.MAX_VALUE;
					via[i][j] = 100;
				
				}
			}
		}
		System.out.println("Enter no of Edges : ");
		int edge = scan.nextInt();
		
		for(int i = 0 ; i < edge; i++)
		{
			System.out.println("Enter Starting Node No : ");
			int start = scan.nextInt();
			System.out.println("Enter End Node No : ");
			int end = scan.nextInt();
			System.out.println("Enter Edge Weight : ");
			dist[start][end] = scan.nextInt();
			dist[end][start] = dist[start][end];
			via[start][end] = start;
			via[end][start] = end;
			
		}
	
		for(int source = 0; source < node ; source++)
		{
	
		for(int i = 0; i < node; i++)
		  {
			   if(dist[source][i] != Integer.MAX_VALUE && dist[source][i] != 0)
			   {
				   int d1 = dist[source][i];
				    for(int j = 0; j < node; j++)
				    {
				    	if(i != j && j != source)
				    	{
				    		int d2 = dist[i][j];
				    		
				    		if(d2 != Integer.MAX_VALUE && d1 + d2 < dist[source][j])
				    		{
				    		//	System.out.println("d1  " + d1 + " d2 " + d2 + " dist " + dist[source][i]);
				    			dist[source][j] = dist[j][source] =  d1 + d2;
				    			int s = source;
				    			int ii = i;
				    			while(s != via[s][ii])
				    			{
				    				ii = via[s][ii];
				    			}
				    			via[source][j] = ii;
				    			 s = j;
				    			 ii = i;
				    			 while(s != via[s][ii])
				    			{
				    				ii = via[s][ii];
				    			}
				    			via[j][source] = ii;
				    		}
				    	}
				    }
			   }
		  }
		
	
		}
		
		System.out.print("    ");
		for(int i = 0; i < node; i++)
		{
			System.out.print(i + " , " + "via " +  "\t");
		}
		System.out.println();
		for(int i = 0; i < node; i++)
		{
			System.out.print(i + "   ");
			for(int j = 0 ; j < node; j++)
			{
		
					System.out.print( dist[i][j] + ", via " + via[i][j] + "\t");
				
			
			}
			System.out.println();
		}
	}
}
