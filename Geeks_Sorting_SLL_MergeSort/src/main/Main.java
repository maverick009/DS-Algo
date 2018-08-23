package main;

import sll.SLL;

public class Main 
{
	public static void main(String[] args) 
	{
		SLL sll = new SLL();
		sll.head = sll.insert(sll.head, 70);
		sll.head = sll.insert(sll.head, 60);
		sll.head = sll.insert(sll.head, 80);
		sll.head = sll.insert(sll.head, 10);
		sll.head = sll.insert(sll.head, 50);
		sll.head = sll.insert(sll.head, 20);
		sll.head = sll.insert(sll.head, 100);
		sll.head = sll.insert(sll.head, 30);
		
		System.out.println("List:");
		sll.display(sll.head);
		
		System.out.println("Sorting List");
		sll.head = sll.mergeSort(sll.head);
		
		System.out.println("List:");
		sll.display(sll.head);

	}

}
