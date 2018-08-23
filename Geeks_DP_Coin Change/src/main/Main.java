/*
 * https://www.youtube.com/watch?v=ZaVM057DuzE
 */
package main;
import dp.DP;
import java.util.*;

class Greedy
{
	public void minCoin(int []deno, int V)
	{	
		Arrays.sort(deno);
		Stack<Integer> stack = new Stack<>();
		for(int i = deno.length - 1;i >= 0;i--)
		{
			while(V >= deno[i])
			{
				V -= deno[i];
				stack.push(deno[i]);
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		/*int []a = {1,2,3};
		int sum = 4;
		DP d = new DP();
		d.change(a, sum);*/
		
		int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int sum = 93;
		Greedy greedy = new Greedy();
		greedy.minCoin(deno, sum);
	}
}