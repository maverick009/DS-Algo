package sll;

public class Sll 
{
	class Node
	{
		private int data;
		private Node next;
		
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
	
	public void display()
	{
		if(head == null)
			return;
		
		Node temp = head;
		while(temp != null)
		{
			System.out.println("element:" + temp.data);
			temp = temp.next;
		}
	}
	
	public int length(Node head1)
	{
		if(head1 == null)
			return 0;
		
		int count = 0;
		
		Node temp = head1;
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public Node mid(Node head1)
	{
		if(head1 == null)
			return null;
		
		Node temp = head1;
		for(int i = 0;i<length(temp)/2;i++)
		{
			temp = temp.next;
		}
		return temp;
	}
	
	public Node reverse(Node head1)
	{
		if(head1 == null)
			return null;
		
		Node prev = null,curr = head1,next = null;
		
		while(curr!= null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public boolean palindrome(Node node)
	{
		if(node == null)
			return false;
		
		if(node.next == null)
			return true;
		Node temp = node;
		Node mid = mid(node);
		Node last = reverse(mid);
		
		while(temp != null && last != null && temp.data == last.data)
		{
			temp = temp.next;
			last = last.next;			
		}
	
		if(last == null || temp == null)
			return true;
		
		return false;
	}
	
}
