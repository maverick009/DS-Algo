package main;
import java.util.Scanner;

public class Main 
{
	//Method 1
	public static int setbits(int n)
	{
		int count = 0;
		for(int i = 1;i <= n;i++)
			count += setbitUtil(i);
		return count;
	}
	
	public static int setbitUtil(int n)
	{
		if(n <= 0)
			return 0;
		return ((n%2 == 0?0:1) + setbitUtil(n/2));
	}
	
	//Method 2
	public static int getset(int n)
	{
		int ans = 0, i = 0;
		while(1 << i <= n)
		{
			boolean k = false;
			int change = 1 << i;
			for(int j = 0;j <= n;j++)
			{
				if(k)
					ans += 1;
				else
					ans += 0;
				
				if(change == 1)
				{
					k = !k;
					change = 1 << i;
				}
				else
					change--;
			}
			i++;
		}
		return ans;
	}
	
	//Method 3
	public static int func(int n)
	{
		int ans = 0, rem, ques, i =0;
		for(i = 0;i < 32;i++)
		{
			if(n >> i == 0)
				break;
			ques = n + 1 >> i + 1;
			ans += ques << i;
			rem = ((n+1)%(1 << i +1)) - (1<<i);
			if(rem > 0)
				ans += rem;
		}
		return ans;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		//System.out.println("bits:" + setbits(sc.nextInt()));
		//System.out.println("Bits Method2:" + getset(sc.nextInt()));
		System.out.println("method3:" + func(sc.nextInt()));
	}
}