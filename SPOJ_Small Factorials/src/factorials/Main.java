package factorials;

import java.math.BigInteger;
import java.util.Scanner;

class Factorials
{
	public BigInteger calculateFactorials(int num)
	{
		BigInteger bi = new BigInteger
		
		if(num == 0 || num == 1)
			return 1;
		for(long i =1; i<= num; i++)
		{
			fact *= i;
		}		
		return fact;
	}
}



public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		Factorials factorial = new Factorials();
		for(int i = 0;i < testcases;i++)
		{
			System.out.println(factorial.calculateFactorials(sc.nextInt()));
		}
		sc.close();
	}
}
