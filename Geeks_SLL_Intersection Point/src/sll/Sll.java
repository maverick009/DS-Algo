package sll;

public class Sll 
{
	public class Node
	{
		public int data;
		public Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	public Node head;
	
	public Node insert(Node node,int data)
	{
		Node newnode = new Node(data);
		newnode.next = node;
		node = newnode;
		return node;
	}
	
	public void display(Node node)
	{
		if(node == null)
			return;
		
		Node temp = node;
		
		while(temp != null)
		{
			System.out.println("element:" + temp.data);
			temp = temp.next;
		}
	}
	
	public int length(Node node)
	{
		if(node == null)
			return 0;
		int count = 0;
		Node temp = node;
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public Node checkElement(Node node1,Node node2)
	{
		if(node1 == null || node2 == null)
			return null;
		
		Node temp1 = node1,temp2 = node2;
		while(temp1 != null && temp2 != null)
		{
			if(temp1.data == temp2.data)
				return temp1;
			else
			{
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		
		return null;
	}
	
	public Node intersectionNode(Node node1,Node node2)
	{
		if(node1 == null || node2 == null)
			return null;
		
		int len1 = length(node1);
		int len2 = length(node2);
		
		Node temp1 = node1,temp2 = node2;
		if(len1 != len2)
		{
			int diff  = Math.abs(len1 - len2);
			if(len1 > len2)
			{
				for(int i =0;i<diff;i++)
					temp1 = temp1.next;
			}
			else
			{
				for(int i =0;i<diff;i++)
					temp2 = temp2.next;
			}
		}
		Node resNode = checkElement(temp1, temp2);	
		
		return resNode;
	}
	
}
