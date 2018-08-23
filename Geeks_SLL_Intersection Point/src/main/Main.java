package main;

import sll.Sll;

public class Main 
{
	public static void main(String[] args) 
	{
		Sll sll1 = new Sll();
		Sll.Node head1 = null;
		head1 = sll1.insert(sll1.head, 3);
		head1.next = sll1.insert(sll1.head, 6);
		head1.next.next = sll1.insert(sll1.head, 9);
		head1.next.next.next = sll1.insert(sll1.head, 15);
		head1.next.next.next.next = sll1.insert(sll1.head, 30);
		
		Sll.Node head2 = null;
		Sll sll2 = new Sll();
		head2 = sll2.insert(sll2.head, 10);
		head2.next = head1.next.next.next;
		
		System.out.println("Display List1");
		sll1.display(head1);
		System.out.println("Display List 2");
		sll2.display(head2);
		
		
		Sll.Node node = sll1.intersectionNode(head1, head2);
		System.out.println("Intersection Node data:" + node.data);
	}

}
