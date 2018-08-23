import java.util.Scanner;

import mergeSort.MergeSort;

public class Main extends MergeSort 
{
	/*
	  @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int []array = new int[size];
		for(int i = 0;i < size; i++)
			array[i] = sc.nextInt();
		System.out.println("Display Array");
		MergeSort.print(array);
		
		System.out.println("sorting array");
		MergeSort.mergeSort(array, 0, array.length -1);
		
		System.out.println("Display array");
		MergeSort.print(array);
		
		sc.close();
	}
}