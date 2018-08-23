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
	
	public int edit(String a,String b)
	{
		int [][]arr = new int[a.length()+1][b.length()+1];
		for(int i = 0;i < b.length();i++)
			arr[0][i] = i;
		for(int i =0;i < a.length();i++)
			arr[i][0] = i;
		
		for(int i = 1;i <= a.length();i++)
		{
			for(int j = 1;j <= b.length();j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
					arr[i][j] = arr[i-1][j-1];
				else
					arr[i][j] = 1+ min(arr[i-1][j-1], arr[i][j-1],arr[i-1][j]);
			}
		}
		return arr[a.length()][b.length()];
	}
}
