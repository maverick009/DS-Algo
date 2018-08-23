package palindrome;
import java.math.BigInteger;
import java.util.Scanner;

class Palindrome
{
	public boolean check(long num)
	{
		if(num < 0)
			return false;
		
		long temp = num,sum = 0;int rem;
		
		while(num > 0)
		{
			rem = (int) num % 10;
			sum = (sum * 10) + rem;
			num /= 10;
		}
		
		if(temp != sum)
			return false;
		
		return true;
	}
	
	public long findSmallestPalindrome(long num)
	{
		if(num == 1000000)
			return 0;
		else
		{	
			for(long i = ++num; ;i++)
			{
				if(check(i))
					return i;
			}
		}
	}
}

class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		
		Palindrome palindrome = new Palindrome();
		
		for(int i =0;i <testcases;i++)
		{
			try
			{
				BigInteger bi = new BigInteger(sc.nextLine());
				System.out.println(palindrome.findSmallestPalindrome(bi));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		sc.close();
	}
}