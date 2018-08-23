//https://www.careercup.com/question?id=7902674
package main;

class Unique
{
	//If others are present twice
	public int unique2(int []arr)
	{
		int val = arr[0];
		for(int i = 1;i < arr.length;i++)
			val ^= arr[i];
		return val;
	}
	
	//if Others are present three times
	public int unique3(int []arr)
	{
		int ones = 0, twos = 0, not_three;
		for(int i = 0;i < arr.length;i++)
		{
			twos |= ones & arr[i];
			ones ^= arr[i];
			not_three = ~(ones & twos);
			ones &= not_three;
			twos &= not_three;
		}
		return ones;
	}	
}

public class Main 
{
	public static void main(String[] args) 
	{
		int arr[] = {7, 3, 5, 4, 5, 3, 4};
		System.out.println(new Unique().unique2(arr));
		int []arr3 = {7, 4, 5, 3, 4, 5, 3, 4, 5, 3};
		System.out.println(new Unique().unique3(arr3));
	}
}
