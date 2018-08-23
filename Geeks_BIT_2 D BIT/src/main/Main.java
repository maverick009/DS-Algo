package main;

import bit.BIT;

public class Main 
{
	public static void main(String[] args) 
	{
		int arr[][] = {{1, 2, 3, 4}, {5, 3, 8, 1}, {4, 6, 7, 5}, {2, 4, 8, 9} };
		BIT bit = new BIT(arr);
		int [][]q = {{1, 1, 3, 2}, {2, 3, 3, 3}, {1, 1, 1, 1} };
		for(int i = 0;i < q.length;i++)
			System.out.println(bit.sum(q[i]));
		bit.display();
	}
}
