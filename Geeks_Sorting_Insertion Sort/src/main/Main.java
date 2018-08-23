package main;

import sort.InsertionSort;

public class Main 
{
	public static void main(String[] args) 
	{
		int []a = {9,7,6,15,16,5,10,11};
		InsertionSort sort = new InsertionSort();
		System.out.println("Original Array\n");
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println("\nSorted Array");
		sort.sort(a);
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
	}

}
