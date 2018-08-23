package main;

public class Main 
{
	public static void swap(int []arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void sort(int []arr)
	{
		int low = 0, high = arr.length - 1;
		int mid = 0;
		while(mid <= high)
		{
			switch(arr[mid])
			{
				case 0 : swap(arr, low, mid);
						 low++;
						 mid++;
						 break;
		
				case 1 : mid++;
						 break;
						 
				case 2 : swap(arr, mid, high);
						 high--;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		System.out.println("original Array");
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
		
		sort(arr);
		System.out.println("Sorted Array");
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}