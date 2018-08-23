package main;

import dnf.DNF;

public class Main 
{
	public static void main(String[] args) 
	{
		DNF d = new DNF();
		int a[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		//int a[] = {4, 39, 54, 14, 31, 89, 44, 34, 59, 64, 64, 11, 41};
	    //int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//int a[] = {91, 82, 73, 64, 55, 46, 37, 28, 19, 10};
		//int a[] = {4, 9, 4, 4, 9, 1, 1, 1};
		System.out.println("Original Array");
		d.print(a);
		//d.sort012(a);
		d.quicksort(a);
		System.out.println("\nSorted Array");
		d.print(a);
	}

}
