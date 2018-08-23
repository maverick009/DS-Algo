package main;

import inversion_count.AVL;
import inversion_count.BIT;
import inversion_count.MergeSort;

public class Main 
{	
	public static void print(int []arr)
	{
		for(int a : arr)
			System.out.print(a + " ");
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		//int arr[] = {12, 11, 13, 5, 6, 7};
		//int arr[] = new int[]{1, 20, 6, 4, 5};
		//int []arr = {1, 20, 6};
		//int []arr = {8, 4, 2, 1};
		
		/*AVL avl = new AVL();
		System.out.println("Total Inversions:" + avl.getInversion(arr));
		
		print(arr);
		MergeSort mergesort = new MergeSort();
		System.out.println("sorted array");
		int count = mergesort.mergesort(arr, 0, arr.length - 1);
		print(arr);
		System.out.println("count:" + count);*/
		
		int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
		BIT bit = new BIT(freq);
		System.out.println("Sum(5):" + bit.getSum(freq, 5));
		freq[3] += 6;
		bit.update(freq, 3, 6);
		System.out.println("Sum(5):" + bit.getSum(freq, 5));
	}
}