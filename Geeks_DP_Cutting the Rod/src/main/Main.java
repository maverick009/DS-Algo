package main;
import dp.DP;

public class Main 
{
	public static void main(String[] args) 
	{
		DP d = new DP();
		int []arr = {2,5,7,8};//{1,5,8,9,10,17,17,20};
		System.out.println("Maximum Value:" + d.maxValue(arr));
	}

}
