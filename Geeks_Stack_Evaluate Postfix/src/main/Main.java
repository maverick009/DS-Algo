package main;

import stack.Stack;

public class Main 
{
	public static void main(String[] args) 
	{
		Stack stack = new Stack();
		System.out.println("Value:" + stack.evaluatePostfix("542*+9-"));
	}

}
