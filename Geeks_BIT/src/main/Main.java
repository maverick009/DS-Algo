package main;

import bit.BIT;

public class Main 
{
	public static void main(String[] args) 
	{
	    int arr[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
	    BIT bit = new BIT();
	    bit.construct(arr);
	    System.out.println(bit.getSum(5));
	    bit.update(arr, 3, 6);
	    System.out.println(bit.getSum(5));
	}
}
