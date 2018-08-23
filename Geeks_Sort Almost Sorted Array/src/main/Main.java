package main;

import sort.Sort;

public class Main 
{
	public static void main(String[] args) 
	{
		//int []a = {2,6,3,12,56,8};
		int []a = {100,99,98,2,6,3,12,56,8};
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println();
		/*Sort sort = new Sort();
		sort.isort(a);
		System.out.println();
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");*/
		
		//Using Heap
		
		Sort sort = new Sort(a);
		sort.create(a);
		System.out.println("Heap");
		sort.display();
		
		for(int i = 0;i < a.length;i++)
			a[i] = sort.getMin();
		
		System.out.println("\nSorted Array");
		
		for(int i = 0;i < a.length;i++)
			System.out.print(a[i] + " ");
	}
}
