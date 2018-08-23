package main;

import heap.Heap;

public class Main 
{
	public static void main(String[] args) 
	{
		//int arr[] = {2, 6, 3, 12, 56, 8};
		int arr[] = {3,2,1,7,8,4,10,16,12};
		int k = 3;
		System.out.println("Original Array");
		for(int i = 0;i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		
		Heap minheap = new Heap();
		arr = minheap.sortK(arr, k);
		
		System.out.println("Sorted Array");
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();		
	}
}
