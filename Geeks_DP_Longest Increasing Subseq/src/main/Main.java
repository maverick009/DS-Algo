package main;

import subseq.Subseq;

public class Main 
{
	public static void main(String[] args) 
	{
		int []a = {10,22,9,31,21,50,41,60,80};
		Subseq s = new Subseq();
		System.out.println("LIS:" + s.lis(a));
	}

}
