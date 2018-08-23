//https://www.youtube.com/watch?v=ASsN8qNHFXI
package main;

public class Main 
{
	public static void printparenthesis(int i, int j, int size, int [][]bracket, char name)
	{
		if(i == j)
			name++;
		System.out.print("(");
		printparenthesis(i, bracket[i][j], size, bracket, name);
		printparenthesis(bracket[i][j], j, size, bracket, name);
		System.out.print(")");
	}
	
	
	public static int multiply(int []arr)
	{
		int [][]m = new int[arr.length][arr.length];
		int [][]bracket = new int[arr.length][arr.length];
		int i, j, k, L, cost;
		
		for(L = 2;L < arr.length;L++)
		{
			for(i = 1;i < arr.length - L + 1;i++)
			{
				j = i + L -1;
				if(j == arr.length)
					continue;
				m[i][j] = Integer.MAX_VALUE;
				for(k = i;k <= j - 1;k++)
				{
					cost = m[i][k] + m[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
					if(cost < m[i][j])
					{
						m[i][j] = cost;
						bracket[i][j] = k;
					}
				}
			}
		}
		char name = 'A';
		System.out.println("Optimal Parenthesis is:");
		//printparenthesis(1, arr.length - 1, arr.length, bracket, name);
		return m[1][arr.length - 1];
	}
	
	public static void main(String[] args) 
	{
		int []arr = {1, 2, 3, 4};
		System.out.println("Minimum Cost:" + multiply(arr));
	}
}
