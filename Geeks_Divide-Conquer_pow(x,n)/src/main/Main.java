package main;
import java.util.Scanner;

public class Main 
{
	public static float power(int x, int n)
	{
		if(n == 0)
			return 1;
		float temp = power(x, n/2);
		if(n % 2 == 0)
			return temp * temp;
		else
		{
			if(n > 0)
				return temp * temp * x;
			else
				return (temp * temp)/x;
		} 	
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x and n");
		int x = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(Math.pow(x, n));
		System.out.println("Value:" + power(x, n));
	}
}
