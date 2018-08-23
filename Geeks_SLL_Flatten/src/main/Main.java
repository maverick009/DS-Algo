package main;

import sll.Sll;

public class Main 
{
	public static void main(String[] args) 
	{
		Sll sll = new Sll();
		sll.head = sll.insert(5);
		sll.head.down = sll.insert(7);
		sll.head.down.down = sll.insert(8);
		sll.head.down.down.down = sll.insert(30);
		
		sll.head.next = sll.insert(10);
		sll.head.next.down = sll.insert(20);

		
		sll.head.next.next = sll.insert(19);
		sll.head.next.next.down = sll.insert(22);
		sll.head.next.next.down.down = sll.insert(50);
		
		sll.head.next.next.next = sll.insert(28);
		sll.head.next.next.next.down = sll.insert(35);
		sll.head.next.next.next.down.down = sll.insert(40);
		sll.head.next.next.next.down.down.down = sll.insert(45);
		
		System.out.println("Printing List");
		sll.display(sll.head,false);
		
		System.out.println("Display List after Flattening");
		sll.flatten(sll.head);
		sll.display(sll.head, true);
		
	}
}
