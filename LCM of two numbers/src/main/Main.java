package main;

import java.util.Scanner;

public class Main 
{
	public static int HCF(int a, int b)
	{
		if(a == 0 || b == 0)
			return 0;
		
		if(a == b)
			return a;
		
		/*int small = 0, big = 0;
		if(a <= b)
		{
			small = a;
			big = b;
		}
		else
		{
			small = b;
			big = a;
		}
		
		while(big % small != 0)
		{
			int temp = big % small;
			big = small;
			small = temp;
		}*/
		if(a < b)
			return HCF(a, b - a);
		else
			return HCF(a - b, b);
		//return small;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two Numbers");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int hcf = HCF(a, b);
		System.out.println("LCM:" + (a * b)/hcf);
	}
}
