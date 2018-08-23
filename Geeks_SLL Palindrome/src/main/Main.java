package main;

import sll.Sll;

public class Main 
{
	public static void main(String[] args) 
	{
		Sll sll1 = new Sll();
		sll1.insert(7);
		sll1.insert(6);
		sll1.insert(5);
		sll1.insert(5);
		sll1.insert(6);
		sll1.insert(7);
		
		System.out.println("Display List");
		sll1.display();
		
		System.out.println("Reversing List");
		sll1.head = sll1.reverse(sll1.head);
		sll1.display();
		
		System.out.println("Palindrome:" + sll1.palindrome(sll1.head));
	}
}
