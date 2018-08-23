package main;

import java.util.Deque;
import java.util.LinkedList;

public class Main 
{
	public static int getSum(int []arr, int k)
	{
		int sum = 0;
		Deque<Integer> dmax = new LinkedList<>();
		Deque<Integer> dmin = new LinkedList<>();
		
		int i = 0;
		for(;i < k;i++)
		{
			while(!dmax.isEmpty() && arr[i] >= arr[dmax.peekLast()])
				dmax.removeLast();
			
			while(!dmin.isEmpty() && arr[i] <= arr[dmin.peekLast()])
				dmin.removeLast();
			
			dmax.addLast(i);
			dmin.addLast(i);
		}
		
		for(;i < arr.length;i++)
		{
			sum += arr[dmax.peekFirst()] + arr[dmin.peekFirst()];
			
			while(!dmax.isEmpty() && dmax.peek() <= i - k)
				dmax.removeFirst();
			
			while(!dmin.isEmpty() && dmin.peek() <= i - k)
				dmin.removeFirst();
			
			while(!dmax.isEmpty() && arr[i] >= arr[dmax.peekLast()])
				dmax.removeLast();
			
			while(!dmin.isEmpty() && arr[i] <= arr[dmin.peekLast()])
				dmin.removeLast();
			
			dmax.addLast(i);
			dmin.addLast(i);
		}
		sum += arr[dmax.peekFirst()] + arr[dmin.peekFirst()];		
		return sum;
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {2, 5, -1, 7, -3, -1, -2};
		int k = 3;
		System.out.println("Sum:" + getSum(arr, k));
	}
}