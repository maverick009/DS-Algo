package main;

import sll.SLL;

public class Main 
{
	public static void main(String[] args) 
	{	
		SLL sll1 = new SLL();
		SLL sll2 = new SLL();
		sll1.head = sll1.insert(sll1.head, 30);
		sll1.head = sll1.insert(sll1.head, 20);
		sll1.head = sll1.insert(sll1.head, 60);
		sll1.head = sll1.insert(sll1.head, 70);
		sll1.head = sll1.insert(sll1.head, 10);
		
		sll2.head = sll2.insert(sll2.head, 10);
		sll2.head = sll2.insert(sll2.head, 75);
		sll2.head = sll2.insert(sll2.head, 80);
		sll2.head = sll2.insert(sll2.head, 90);
		sll2.head = sll2.insert(sll2.head, 60);
		
		System.out.println("Display List");
		sll1.display(sll1.head);
		System.out.println();
		sll2.display(sll2.head);
		
		/*System.out.println("Union of Lists");
		sll1.union(sll1.head, sll2.head);*/
		
		SLL.Node node = sll1.new Node();
		node = sll1.union(sll1.head, sll2.head);
		System.out.println("Union of Lists");
		sll1.display(node);
		
		System.out.println("Intersection of Lists");
		node = sll1.intersection(sll1.head, sll2.head);
		sll1.display(node);
	}
}
