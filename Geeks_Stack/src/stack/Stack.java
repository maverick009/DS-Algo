package stack;

public class Stack 
{
	class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	public Node head;
	
	public Node push(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
		return head;
	}
	
	public void display(Node node)
	{
		if(node == null)
			return;
		
		Node temp = node;
		while(temp != null)
		{
			System.out.println("data:" + temp.data);
			temp = temp.next;
		}
	}
	
	public int peek()
	{
		if(head == null)
			return -1;
		
		return head.data;
	}
	
	public int pull()
	{
		if(head == null)
			return -1;
		Node temp = head;
		head = head.next;
		return temp.data;
	}
	
	public boolean isEmpty()
	{
		return (head == null)?true:false;
	}
}
