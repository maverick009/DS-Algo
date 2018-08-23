import java.util.Scanner;

public class Main 
{
	/**
	 * @param args
	 */
	public static boolean checkPrime(long num)
	{
		if(num == 2)
			return true;
		
		if(num <= 1 || num % 2 ==0)
			return false;
		
		for(int i = 3;i<= Math.sqrt(num); i+=2)
		{
			if(num % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i = 0;i < testcase;i++)
		{
			long m = sc.nextLong();
			long n  =sc.nextLong();
			if(m <=0 || n <=0 || n-m >100000 || m > n)
			{
				sc.close();
				return;				
			}
			for(long j = m; j<= n;j++)
			{
				if(checkPrime(j))
					System.out.println(j);
			}
		}
		
		sc.close();
		
	}
}
