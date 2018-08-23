package main;

import sll.SLL;

public class Main 
{
	public static void main(String[] args) 
	{
		SLL sll1 = new SLL();
		sll1.insert(15);
		sll1.insert(10);
		sll1.insert(5);
		
		SLL sll2 = new SLL();
		sll2.insert(20);
		sll2.insert(3);
		sll2.insert(2);
		
		System.out.println("First List");
		sll1.display(sll1.head);
		
		System.out.println("Second List");
		sll2.display(sll2.head);
		
		System.out.println("Merging Link List");
		SLL sll= sll1;
		SLL.Node res = sll.merge(sll1.head, sll2.head);
		
		System.out.println("Merged List");
		sll.display(res);
		

	}

}
