package main;

import stack.Stack;

public class Main 
{
	public static void main(String []args)
	{
		Stack stack = new Stack();
		stack.head = stack.push(60);
		stack.head = stack.push(50);
		stack.head = stack.push(40);
		stack.head = stack.push(30);
		stack.head = stack.push(20);
		stack.head = stack.push(10);
		
		System.out.println("Display Stack");
		stack.display(stack.head);
		
		System.out.println("IsEmpty:" + stack.isEmpty());
		
		System.out.println("head node:" + stack.peek());
		
		System.out.println(stack.pull());
	}
}
