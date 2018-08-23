package dp;

public class DP 
{
	public int max(int a,int b)
	{
		return (a >= b?a:b);
	}
	
	public int maxValue(int []arr)
	{
		int [][]a = new int[arr.length + 1][arr.length + 1];
		for(int i = 0;i < a.length;i++)
			a[0][i] = 0;
		for(int i = 0;i < a.length;i++)
			a[i][0] = 0;
		for(int i = 1;i < a.length;i++)
			a[1][i] = a[1][i-1] + arr[0];		
		
		for(int i = 2;i < a.length;i++)
		{
			for(int j = 2;j < a.length;j++)
			{
				if(i > j)
					a[i][j] = a[i-1][j];
				else
					a[i][j] = max(a[i-1][j],arr[i-1] + a[i][j-i]);
				//System.out.println(i + " " + j + " " + a[i][j]);
			}
		}
		
		return a[arr.length][arr.length];
	}
}
