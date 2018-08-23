//Print Elements in Max SubArray
package main;

public class Main 
{	
	//Divide and Conquer
	public static int crossingsum(int []arr, int low, int mid, int high)
	{
		int sum = 0;
		int lsum = Integer.MIN_VALUE;
		for(int i = mid;i >= low;i--) {
			sum += arr[i];
			if(lsum < sum)
				lsum = sum;
		}
		
		sum = 0;
		int rsum = Integer.MIN_VALUE;
		for(int i = mid + 1;i <= high;i++) {
			sum += arr[i];
			if(rsum < sum)
				rsum = sum;
		}
		return lsum + rsum;
	}
	
	public static int sum(int []arr, int low, int high)
	{
		if(low == high)
			return arr[low];
		int mid = low + (high - low)/2;
		return Math.max(Math.max(sum(arr, low, mid), sum(arr, mid + 1, high)), 
				crossingsum(arr, low, mid, high));
	}
	
	public static int kadane(int []arr)
	{
		int max_so_far = 0, max_ending_here = 0;
		for(int i = 0;i < arr.length;i++)
		{
			max_ending_here += arr[i];
			if(max_ending_here < 0)
				max_ending_here = 0;
			
			else if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}
	
	public static int kadanedp(int []arr)
	{
		int max_so_far = arr[0];
		int current = arr[0];
		int start = 0, end = 0;
		for(int i = 1;i < arr.length;i++)
		{
			current = Math.max(arr[i], arr[i] + current);
			if(max_so_far < current)
				end = i;
			max_so_far = Math.max(current, max_so_far);
		}
		System.out.println("start:" + start + "\tend:" + end);
		return max_so_far;
	}
	
	
	public static void main(String[] args) 
	{
		//int arr[] = {2, 3, 4, 5, 7};
		//int []arr = {-2, -5, -6, -2, -3, 1, 5, -6};
		int []arr = {-2, -2, 4, -1, -2, 1, 5, -3};
		System.out.println("Max Subarray Sum:" + sum(arr, 0, arr.length - 1));
		System.out.println("kadane max:" + kadane(arr));
		System.out.println("kadane max:" + kadanedp(arr));
	}
}