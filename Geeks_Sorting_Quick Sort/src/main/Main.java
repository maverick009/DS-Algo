package main;
import sort.Sort;
public class Main 
{	
	public static void main(String []args)
	{
		Sort sort = new Sort();
		int a[] = {10, 7, 8, 9, 1, 5};
		System.out.println("Original Array");
		sort.print(a);
		sort.quicksort(a, 0, a.length - 1);
		System.out.println("\nSorted Array");
		sort.print(a);
	}
}
