package main;

import java.util.Deque;
import java.util.LinkedList;

public class Main 
{
	public static void SlidingWindow(int []arr, int k)
	{
		Deque<Integer> deque = new LinkedList<>();
		int i  = 0;
		for(;i < k;i++)
		{
			while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
				deque.removeLast();
			
			deque.addLast(i);
		}
		
		for(; i < arr.length;i++)
		{
			System.out.print(arr[deque.peekFirst()] + " ");
			
			while(!deque.isEmpty() && deque.peek() <= i - k)
				deque.removeFirst();
			
			while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
				deque.removeLast();
			deque.addLast(i);
		}
		System.out.println(arr[deque.peek()]);		
	}
	
	public static void main(String[] args) 
	{
		//int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		//int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int arr[]={12, 1, 78, 90, 57, 89, 56};
		int k = 3;
		SlidingWindow(arr, k);
	}
}
