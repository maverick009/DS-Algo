package dp;
import java.util.Arrays;

/*https://www.tutorialspoint.com/design_and_analysis_of_algorithms/
design_and_analysis_of_algorithms_01_knapsack.htm*/

public class DP 
{
	class Knapsack implements Comparable<Knapsack>
	{
		int val,weight;
		
		public int compareTo(Knapsack k)
		{
			return k.val - this.val;
		}
	}
	//Greedy Divide Weight
	public void knapsack(int []val,int []weight,int W)
	{
		Knapsack []k = new Knapsack[val.length];
		for(int i = 0;i < k.length;i++)
			k[i] = new Knapsack();
		for(int i = 0;i < val.length;i++)
		{
			k[i].val = val[i];
			k[i].weight = weight[i];
		}
		Arrays.sort(k);
		int w = 0,sum = 0;
		for(int i = 0;i < k.length;i++)
		{
			if(w + k[i].weight <= W)
			{
				sum += k[i].val;
				w += k[i].weight;
			}
		}	
		System.out.println("Sum:" + sum);
	}
	
	public int max(int a,int b)
	{
		return (a >= b?a:b);
	}
	
	//DP 0-1 property
	public int knapsackdp(int []weight,int []val,int W)
	{
		int [][]a = new int[weight.length+1][W+1];
		for(int i = 0;i <= weight.length;i++)
		{
			for(int j = 0;j <= W;j++)
			{
				if(i == 0 || j == 0)
					a[i][j] = 0;
				else if(weight[i-1] <= j)
					a[i][j] = max(val[i-1] + a[i-1][j - weight[i-1]], a[i-1][j]);
				else
					a[i][j] = a[i-1][j];
			}
		}		
		return a[weight.length][W];
	}
}