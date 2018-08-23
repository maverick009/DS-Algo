package main;

public class Main 
{
	public static void swap(int []arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void print(int []arr)
	{
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void sort(int[] input, int low, int high) 
	{     
	      if (high <= low) 
	    	  return;
	      
	      int lt=low;
	      int gt=high;
	      int i=low + 1;
	      
	      int pivotIndex=low;
	      int pivotValue=input[pivotIndex];	      
	      
	      while (i <= gt)
	      {   
	          if (input[i] < pivotValue)
				  swap(input, i++, lt++);	          
	          else if (pivotValue < input[i])
	        	  swap(input, i, gt--);	         
	          else
	              i++;
	      }	      
	      sort (input, low, lt-1);
	      sort (input, gt+1, high);
	  }
	
	public static void main(String[] args) 
	{
		int arr[] = {10, 7, 8, 9, 1, 5};
		//int arr[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
		//int arr[] = {4, 39, 54, 14, 31, 89, 44, 34, 59, 64, 64, 11, 41};
		print(arr);
		sort(arr, 0, arr.length - 1);
		print(arr);
	}
}
