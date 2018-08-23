package sll;

public class SLL 
{
	public class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	public Node head;
	
	public void insert(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	
	public void display(Node head1)
	{
		if(head1 == null)
			return;
		
		Node temp = head1;
		
		while(temp != null)
		{
			System.out.println("element:" + temp.data);
			temp = temp.next;
		}
	}
	
	public Node merge(Node head1, Node head2)
	{
		if(head1 == null)
			return head2;
		
		if(head2 == null)
			return head1;
		
		Node res = null;
		
		if(head1.data <= head2.data)
		{
			res = head1;
			res.next = merge(head1.next, head2);
		}
		else
		{
			res = head2;
			res.next = merge(head1, head2.next);
		}
		
		return res;
	}
	
}
