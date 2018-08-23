package main; 

import list.SingleLinkList;

public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		SingleLinkList sll = new SingleLinkList();
		sll.insert(12);
		sll.insert(13);
		sll.insert(11);
		sll.insert(5);
		sll.insert(6);
		sll.insert(7);
			
		sll.print();
		
		System.out.println("Sorting List");
		sll.mergeSort(sll.head);
		System.out.println("Printing List after Sort");
		sll.print();
	}
}
