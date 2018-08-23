package main;

import stack.Stack;

public class Main 
{
	public static void main(String[] args) 
	{
		Stack stack = new Stack();
		String str = "natasha";
		System.out.println("String:" + str);
		str = stack.reverse(str);
		System.out.println("Reverse:" + str);
	}
}
