import java.util.Scanner;


class HammingCode
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter No of Bits ");
        int n = scan.nextInt();

        int r;

        for(r = 0; Math.pow(2,r) < n+r+1; r++) {}

        System.out.println("Redundant Bits " + r);
        int arr[] = new int[n+r+1];

        int j = 2;
        System.out.println("Enter the Data Bits ");
        
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scan.nextInt();
        }
        int l = n-1;
        for(int i = 3; i <= n+r; i++)
        {

            if(Math.pow(2,j) == i)
            {
                i++;j++;
            }
            
            arr[i] = a[l];
            l--;
        }

        int ind;
        for(int i = 1; i <= n+r ; i++)
        {
            for(int k = 0; k < r; k++)
            {
                ind = (int)Math.pow(2,k);
                if((ind & i) != 0)
                {
                    arr[ind] = arr[ind] ^ arr[i];
                }
            }
        }
        System.out.println("The Encoded Bits are ");

        for(int i=arr.length-1; i > 0; i--)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println("Error Detection Algorithm ");

        int n1; 

        System.out.println("Enter Received " + (n+r) + " Bits ");
        

        int a2[] = new int[n+r+1];
        for(int i = n+r ; i > 0; i--)
        {
            a2[i] = scan.nextInt();
        }

        
        int a3[] = new int[r];
        for(int i = 1; i <= n+r ; i++)
        {
            for(int k = 0; k < r; k++)
            {
                ind = (int)Math.pow(2,k);
                if((ind & i) != 0)
                {
                    a3[k] = a3[k] ^ a2[i];
                }
            }
        }
       
        int flag = 0;
        int er = 0;
        System.out.println("The Error Detection Data ");
        for(int i = 0; i < r; i++)
        {
            if(a3[i] == 1)
            {
                er += Math.pow(2,i);
                flag = 1;
            }
            System.out.print(a3[i]);
        }

        System.out.println();
        if(flag == 0)
        {
            System.out.println("No Error Detected ");
        }
        else
        {
            System.out.println("Error Detected at " + er + " th location ");
        }

    }
}













