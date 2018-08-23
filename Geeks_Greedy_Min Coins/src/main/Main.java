package main;

import java.util.Scanner;

import coins.Coins;

public class Main 
{
	public static void main(String[] args) 
	{	
		int value;
		int []demonition = {1,2,5,10,20,50,100,500,1000};
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter Value");
			value = sc.nextInt();
			Coins c = new Coins();
			c.minCoins(value, demonition);
		}
	}
}
