package main;
import sort.Sort;
public class Main 
{
	public static void main(String[] args) 
	{
		int []a = {64,34,25,12,22,11,90};
		System.out.println("Array");
		Sort sort = new Sort();
		sort.print(a);
		System.out.println("Bubble Sort");
		sort.bubblesort(a);
		System.out.println("Array after Sort");
		sort.print(a);
	}
}
