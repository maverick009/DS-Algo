package main;

import backtrack.Backtrack;

public class Main 
{
	public static void main(String[] args) 
	{
		String str = "ABC";
		Backtrack b = new Backtrack();
		b.permute(str, 0, str.length()-1);
	}
}
