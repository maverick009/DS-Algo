package main;

import dp.DP;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		int []val = {24,18,18,10};//{60,100,200};
		int []weight = {24,10,10,7};//{10,20,30};
		System.out.print("Enter Weight:");
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		DP d = new DP();
		//d.knapsack(val, weight,  W);
		System.out.println("Value:" + d.knapsackdp(weight, val, W));
	}
}
