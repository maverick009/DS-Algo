package dp;

public class DP 
{
	public int min(int a,int b,int c)
	{
		if(a <= b && a <= c)
			return a;
		else if(b <= a && b <= c)
			return b;
		else 
			return c;
	}
	
	public int cost(int [][]cost,int a,int b)
	{
		int [][]arr = new int[cost.length][cost.length];
		arr[0][0] = cost[0][0];
		for(int i = 1;i < cost.length;i++)
			arr[0][i] = arr[0][i-1] + cost[0][i];
		
		for(int i = 1;i < cost.length;i++)
			arr[i][0] = arr[i-1][0] + cost[i][0];
		
		for(int i = 1;i < cost.length;i++)
		{
			for(int j = 1;j < cost.length;j++)
				arr[i][j] = cost[i][j] + min(arr[i-1][j-1], arr[i][j-1], arr[i-1][j]); 
		}
		return arr[cost.length-1][cost.length-1];
	}
}
