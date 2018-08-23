package main;

import java.util.Arrays;

public class Main 
{
	public static void sort(int []arr)
	{
		for(int i = 1;i < arr.length;i++)
		{
			int temp = arr[i];
			int j = Math.abs(Arrays.binarySearch(arr, 0, i, temp) + 1);
			System.arraycopy(arr, j, arr, j + 1, i - j);
			arr[j] = temp;
		}
	}
	
	public static void print(int []arr)
	{
		for(int a : arr)
			System.out.print(a + " ");
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		int[] arr = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54 };
		print(arr);
		sort(arr);
		print(arr);
	}
}
