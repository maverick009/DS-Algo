package main;

import stack.Stack;

public class Main 
{
	public static void main(String[] args) 
	{
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println(stack.pop());
		stack.push(60);
		stack.push(70);
		System.out.println("Display List");
		stack.display();
		
		System.out.println(stack.pop());
		stack.display();
		
	}
}
