package main;

import sll.SLL;

public class Main 
{
	public static void main(String[] args) 
	{
		SLL sll1 = new SLL();
		SLL sll2 = new SLL();
		
		sll1.head = sll1.insert(2, 0);
		sll1.head = sll1.insert(4, 1);
		sll1.head = sll1.insert(5, 2);
		sll1.display(sll1.head);
		
		sll2.head = sll2.insert(5, 0);
		sll2.head = sll2.insert(5, 1);
		sll2.display(sll2.head);
			
		System.out.println("Resultant List");
		sll1.display(sll1.polyadd(sll1.head, sll2.head));
	}
}
