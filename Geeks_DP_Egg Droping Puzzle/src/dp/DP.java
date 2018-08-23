package dp;

public class DP 
{
	public int max(int a,int b)
	{
		return (a >= b?a:b);
	}
	
	public int min(int a,int b)
	{
		return (a <= b?a:b);
	}
	
	public int eggdrop(int floor,int numegg)
	{
		if(numegg == 0)
			return numegg;
		
		if(floor == 0 || floor == 1 || numegg == 1)
			return floor;
		
		int [][]a = new int[numegg+1][floor+1];
		int res = 0;
		
		for(int i = 0;i <= numegg;i++)
		{
			a[i][0] = 0;
			a[i][1] = 1;
		}
		
		for(int i = 1;i <= floor;i++)
		{
			a[0][i] = 0;
			a[1][i] = i;
		}
		
		for(int i = 2;i <= numegg;i++)
		{
			for(int j = 2;j <= floor;j++)
			{
				a[i][j] = Integer.MAX_VALUE;
				for(int k = 1;k <= j;k++)
				{
					res = 1 + max(a[i-1][k-1], a[i][j - k]);
					if(res < a[i][j])
						a[i][j] = res;
				}
			}
		}
		return a[numegg][floor];
	}
}
