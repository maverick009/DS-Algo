package sll;

public class SLL 
{
	public class Node
	{
		int data,degree;
		Node next;
		
		public Node(int data, int degree)
		{
			this.data = data;
			this.degree = degree;
			next = null;
		}
	}
	
	public Node head;
	
	public Node insert(int data, int degree)
	{
		Node newnode = new Node(data, degree);
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
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public Node polyadd(Node head1, Node head2)
	{
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		Node temp1 = head1, temp2 = head2;
		Node res = new Node(0, 0);
		Node temp = res;
		while(temp1 != null && temp2 != null)
		{
			if(temp1.degree < temp2.degree)
			{
				temp.next  = new Node(temp2.data, temp2.degree);
				temp2 = temp2.next;
			}
			else if(temp1.degree > temp2.degree)
			{
				temp.next = new Node(temp1.data, temp1.degree);
				temp1 = temp1.next;
			}
			else
			{
				temp.next = new Node(temp1.data + temp2.data, temp1.degree);
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		
		while(temp1 != null)
		{
			temp.next = new Node(temp1.data, temp1.degree);
			temp1 = temp1.next;
			temp = temp.next;
		}
		
		while(temp2 != null)
		{
			temp.next = new Node(temp2.data, temp2.degree);
			temp2 = temp2.next;
			temp = temp.next;
		}
		return res.next;
	}
}
