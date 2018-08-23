package main;

import java.util.Scanner;

public class Main 
{
	public static void print(int [][]arr, int n, int k)
	{
		for(int i = 0;i <= n;i++)
		{
			for(int j = 0;j <= k;j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	public static int min(int a, int b)
	{
		return (a < b)? a : b;
	}
	
	/*public static int bc(int n, int k)
	{
		int [][]arr = new int[n + 1][k + 1];
		for(int i = 0;i <= n;i++)
		{
			for(int j = 0;j <= min(i, k);j++)
			{
				if(j == 0 || i == j)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}
		return arr[n][k];
	}*/
	
	/*
	 * Space Optimize Solution
	 */
	
	public static int bc(int n, int k)
	{
		int []C = new int[k + 1];
		
		C[0] = 1;
		for(int i = 0;i <= n;i++)
		{
			for(int j = min(i, k);j > 0;j--)
				C[j] = C[j] + C[j -1];
		}
		return C[k];
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n, k;
		System.out.println("Enter N and K:");
		n = sc.nextInt();
		k = sc.nextInt();
		System.out.println("Value of " + n + "C" + k + ":" + bc(n, k));
	}
}
