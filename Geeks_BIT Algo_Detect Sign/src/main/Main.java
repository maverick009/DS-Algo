/*
 * negative binary to decimal
 * 10011011 = 128 - 27
 * since signed bit is one, answer is -101
 */

package main;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		a ^= b;
		if(a < 0)
			System.out.println("yes");
		else
			System.out.println("no");
		
	}
}
