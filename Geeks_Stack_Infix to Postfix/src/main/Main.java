package main;

import stack.Stack;

public class Main 
{
	public static void main(String[] args) 
	{
		String str = "a+b*(c^d-e)^(f+g*h)-i";
		Stack stack = new Stack();
		
		System.out.println(stack.infixToPostfix(str));
	}

}
