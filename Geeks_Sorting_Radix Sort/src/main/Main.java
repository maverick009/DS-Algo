package main;
import java.util.Arrays;

public class Main 
{
	public static int getMax(int []arr)
	{
		int max = arr[0];
		for(int i = 1;i < arr.length;i++)
			if(arr[i] > max)
				max = arr[i];
		return max;
	}
	
	public static void countingsort(int []arr, int exp)
	{
		int []output = new int[arr.length];
		int []count = new int[10];
		int i;
		Arrays.fill(count, 0);
		for(i = 0;i < arr.length;i++)
			count[arr[i]/exp %10]++;
		
		for(i = 1;i < 10;i++)
			count[i] += count[i - 1];
		
		for(i = arr.length - 1;i >= 0;i--)
		{
			output[count[arr[i]/exp %10] - 1] = arr[i];
			count[arr[i]/exp %10]--;
		}
		
		for(i = 0;i < arr.length;i++)
			arr[i] = output[i];
	}
	
	public static void radixsort(int []arr)
	{
		int max = getMax(arr);
		for(int exp = 1; max/exp > 0;exp *= 10)
			countingsort(arr, exp);
	}
	
	public static void print(int []arr)
	{
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String []args)
	{
		int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
		System.out.println("Original Array");
		print(arr);
		System.out.println("Sorted Array");
		radixsort(arr);
		print(arr);
	}
}