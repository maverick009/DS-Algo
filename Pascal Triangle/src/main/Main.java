package main;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		/*Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Number:");
		int num = sc.nextInt();
		int [][]a = new int[num+1][num+1];
		
		for(int i = 0;i < num;i++)
			for(int j = 0;j < num+1;j++)
				a[i][j] = 0;
		
		a[0][0] = 1;
		a[1][0] = a[1][1] = 1;
		
		if(num >= 2)
			for(int i = 2;i <= num;i++)
				for(int j = 0;j <= i;j++)
					if(j == 0 || j == i)
						a[i][j] = 1;
					else
						a[i][j] = a[i-1][j-1] + a[i-1][j];
		
		for(int i = 0;i <= num;i++)
		{
			for(int j = 0;j < num +1;j++)
			{
				if(a[i][j] != 0)
					System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}*/
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int num = scan.nextInt();
		scan.close();
		for(int i = 0;i <= num;i++)
		{
			int Bcoeff = 1;
			for(int k = num; k > i; k--)
			{
				System.out.print(" ");
			}
			for(int j = 0;j <= i;j++)
			{
				 System.out.print(Bcoeff+ " ");
				 Bcoeff = Bcoeff * (i - j) / (j + 1);
			}
			System.out.println();
		}		
	}	
}
