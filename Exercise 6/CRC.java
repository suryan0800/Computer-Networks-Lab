import java.util.Scanner;
class CRC
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m,g[],n,d[];
        System.out.println("Enter no. of data bits : ");
        n=sc.nextInt();
        System.out.println("Enter no. of generator bits : ");
        m=sc.nextInt();
        d=new int[n+m];
        g=new int[m];
        System.out.println("Enter data bits : ");
        for(int i=0;i<n;i++)
            d[i]=sc.nextInt();
        System.out.println("Enter generator bits : ");
        for(int j=0;j<m;j++)
            g[j]=sc.nextInt();
        //int r[] = new int[n+m+m];
        cyclicRedundancyCheck(n,d,m,g);
        /*for(int i = 0; i < n+m; i++)
        {
            r[i] = r1[i];
        }
        cyclicRedundancyCheck(n+m,r,m,g);
        */

        
        System.out.println("Enter No of Received Bits : ");
        int l = sc.nextInt();

        int r[] = new int[l+m];

        System.out.println("Enter Received data : ");
        for(int i = 0; i < l; i++)
        {
            r[i] = sc.nextInt();
        }

        int r1[] = cyclicRedundancyCheck(l,r,m,g);
        
        int flag = 0;

        for(int i = l; i < l+m-1; i++)
        {
            if(r1[i] != 0)
            {
                flag = 1;
                break;
            }
        }

        if(flag == 0)
        {   System.out.println("No Error is Detected ");}
        else
        {   System.out.println("Error Detected "); }
    }

    public static int[] cyclicRedundancyCheck(int n,int d[],int m,int g[])
    {
        int msb,r[],k;
        for(int i=0;i<m-1;i++)
            d[n+i]=0;
        r=new int[m+n];
        for(int i=0;i<m;i++)
            r[i]=d[i];
        
        for(int i=0;i<n;i++)
        {
            k=0;
            msb=r[i];
            for(int j=i;j<m+i;j++)
            {
                if(msb==0)
                r[j]=xor(r[j],0);
                else
                r[j]=xor(r[j],g[k]);
                k++;
            }
            r[m+i]=d[m+i];
        }
        System.out.println("The code bits added are : ");
        for(int i=n;i<n+m-1;i++)
        {
            d[i]=r[i];
            System.out.print(d[i]);
        }
        System.out.println("\nThe code data is : ");
        for(int i=0;i<n+m-1;i++)
        {
            System.out.print(d[i]);
        }
        System.out.println();
        return d;
    }
    public static int xor(int x,int y)
    {
        if(x==y)
         return(0);
        else
         return(1);
    }
}
