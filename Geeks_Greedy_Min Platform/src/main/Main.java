package main;

import java.util.Arrays;

public class Main 
{
	public static int find_platform(int []arr, int []dept)
	{
		Arrays.sort(arr);
		Arrays.sort(dept);
		
		int res = 1, plat_req = 1;
		int i = 1, j = 0;
		
		while(i < arr.length && j < dept.length)
		{
			if(arr[i] < dept[j])
			{
				plat_req++;
				i++;
				
				if(plat_req > res)
					res = plat_req;
			}
			else
			{
				plat_req--;
				j++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};    
	    System.out.println("No of Platforms:" + find_platform(arr, dep));
	}
}
