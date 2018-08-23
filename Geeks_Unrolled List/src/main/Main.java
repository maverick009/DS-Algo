package main;

import list.List;

public class Main 
{
	public static void main(String[] args) 
	{
		List ul = new List();
		List.Node head = ul.new Node(3);
		head.a[0] = 1;
		head.a[1] = 2;
		head.a[2] = 3;
		
		head.next = ul.new Node(3);
		head.next.a[0] = 4;
		head.next.a[1] = 5;
		head.next.a[2] = 6;
		
		head.next.next = ul.new Node(3);
		head.next.next.a[0] = 7;
		head.next.next.a[1] = 8;
		head.next.next.a[2] = 9;
		
		System.out.println("List");
		ul.print(head);
	}
}
