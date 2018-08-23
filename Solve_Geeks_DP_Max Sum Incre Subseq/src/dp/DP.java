package dp;

public class DP 
{
	public int LIS(int []arr)
	{
		int []a = new int[arr.length];
		for(int i = 1;i < a.length;i++)
		{
			for(int j = 0;j < i;j++)
			{
				if(arr[i] > arr[j] && a[i] < a[j] + 1)
					a[i] = a[j] + 1;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < a.length;i++)
		{
			if(max < a[i])
				max = a[i];
		}
		return max +1;
	}
	
	public int maxSum(int []arr)
	{
		int []a = new int[arr.length];
		for(int i = 0;i < a.length;i++)
			a[i] = arr[i];
		for(int i = 1;i < a.length;i++)
		{
			for(int j = 0;j < i;j++)
			{
				if(arr[i] > arr[j] && a[i] < a[j] + arr[i])
					a[i] += arr[j];
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < a.length;i++)
		{
			if(max < a[i])
				max = a[i];
		}
		return max;
	}
}
