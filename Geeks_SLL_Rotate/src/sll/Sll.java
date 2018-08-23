package sll;

public class Sll 
{
	class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data =data;
			next = null;
		}
	}
	Node head;
	
	public Node getHead()
	{
		return head;
	}
	
	public void insert(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	
	public void display(Node node)
	{
		if(node == null)
			return;
		
		Node temp  = node;
		
		while(temp != null)
		{
			System.out.println("data:" + temp.data);
			temp = temp.next;
		}
	}
	
	public Node rotate(int k)
	{
		if(head == null || k <= 0)
			return null;
		
		if(head.next == null || k == 1)
			return head;
		
		int i = 0;
		Node node = head,newhead= null,prev = null,last = null;
		
		while(node != null)
		{
			i++;
			if(i == k-1)
			{
				prev = node;
				newhead= prev.next;
			}
			
			if(node.next == null)
				last = node;
			node = node.next;
		}
		
		prev.next = null;
		last.next = head;
		head = newhead;
		
		return head;
	}
}
