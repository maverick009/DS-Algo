package main;
import java.util.Scanner;
import dp.DP;

public class Main 
{
	public static void main(String[] args) 
	{
		String a,b;
		System.out.println("Enter two Strings");
		Scanner sc = new Scanner(System.in);
		a = sc.next();
		b = sc.next();
		DP d = new DP();
		System.out.println("Edit Distance:" + d.edit(a, b));
	}
}
