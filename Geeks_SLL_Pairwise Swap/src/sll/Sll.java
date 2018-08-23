package sll;

public class Sll 
{
	class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	
	public void insert(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	
	public void display()
	{
		if(head == null)
			return;
		
		Node temp = head;
		
		while(temp != null)
		{
			System.out.println("data:" + temp.data);
			temp = temp.next;
		}
	}
	
	public int length()
	{
		if(head == null)
			return 0;
		
		Node temp = head;
		int count = 0;
		
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		
		return count;
	}
	
	public void swap(Node node1,Node node2)
	{
		if(node1 == null || node2 == null)
			return;
		
		int temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}
	
	public void pairwiseSwap()
	{
		if(head == null)
			return;
		
		Node temp = head,temp1 = null;
		
		while(temp != null)
		{
			if(temp.next != null)
			{
				temp1 = temp.next;
				swap(temp, temp1);
				temp = temp1.next;
			}
			else
				break;
		}
	}
}
