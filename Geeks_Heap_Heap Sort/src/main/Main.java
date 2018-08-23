package main;

import heap.Heap;

public class Main 
{
	public static void main(String[] args) 
	{
		int []a = {12,13,11,5,6,7};
		Heap heap = new Heap();
		System.out.println("Original Array");
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
		System.out.println("Array after Heap Sort");
		heap.heapSort(a);
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
		
	}

}
