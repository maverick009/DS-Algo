package main;

import sll.Sll;

public class Main 
{
	public static void main(String[] args) 
	{
		Sll sll = new Sll();
		sll.insert(7);
		sll.insert(6);
		sll.insert(5);
		sll.insert(13);
		sll.insert(11);
		sll.insert(12);
		sll.insert(114);
		
		System.out.println("Display List");
		sll.display();
		
		System.out.println("Display List after Swap");
		sll.pairwiseSwap();
		sll.display();
	}

}
