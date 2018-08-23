package main;

import bit.BIT;

public class Main 
{
	public static void main(String[] args) 
	{
		int []arr = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
		BIT bit = new BIT(arr);
		System.out.println("Orignal Array");
		bit.display(arr);
		System.out.println("BIT");
		bit.display(bit.bit);
		System.out.println("Sum[0-5]:" + bit.getSum(arr, 5));
		arr[3] += 6;
		bit.update(arr, 3, 6);
		System.out.println("Sum[0-5]:" + bit.getSum(arr, 5));
		bit.display(bit.bit);
		System.out.println("Sum[0-10]:" + bit.getSum(arr, 10));
		System.out.println("Sum[6-10]:" + (bit.getSum(arr, 10) - bit.getSum(arr, 5)));
		for(int i = 4;i <= 8;i++)
			arr[i] += 6;
		bit.updateRange(arr, 4, 8, 6);
		bit.display(bit.bit);
	}
}