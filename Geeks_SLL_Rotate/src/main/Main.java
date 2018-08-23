package main;

import sll.Sll;

public class Main 
{
	public static void main(String[] args) 
	{
		Sll sll = new Sll();
		sll.insert(60);
		sll.insert(50);
		sll.insert(40);
		sll.insert(30);
		sll.insert(20);
		sll.insert(10);
		
		System.out.println("Display list");
		sll.display(sll.getHead());
		
		System.out.println("List after rotation");
		sll.rotate(0);
		sll.display(sll.getHead());

	}
}
