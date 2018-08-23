package main;
import dp.DP;

public class Main 
{
	public static void main(String[] args) 
	{
		DP d = new DP();
	    //int arr[] = {1, 101, 2, 3, 100, 4, 5};
	    int arr[] = {10,5,4,3};
	    //int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	    //System.out.println("Max Value:" + d.LIS(arr));
	    System.out.println("Max Sum:" + d.maxSum(arr));
	}
}
