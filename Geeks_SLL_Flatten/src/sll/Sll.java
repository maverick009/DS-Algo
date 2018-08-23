package sll;

public class Sll 
{
	public class Node
	{
		public int data;
		public Node next;
		public Node down;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
			down = null;
		}
	}
	
	public Node head;
	
	public Node insert(int data)
	{
		return new Node(data);
	}
	
	public void display(Node node,boolean bool)
	{
		if(node == null)
			return;
		
		Node temp = node,td = null;
		if(bool)
		{
			while(temp != null)
			{
				System.out.println("data:" + temp.data);
				temp = temp.down;
			}
		}
		else
		{
			while(temp != null)
			{
				td = temp;
				while(td != null)
				{
					System.out.println("data:" + td.data);
					td = td.down;
				}
				temp = temp.next;
			}
		}
	}
	
	public Node merge(Node node1, Node node2)
	{
		if(node1 == null)
			return node2;
		
		if(node2 == null)
			return node1;
		
		Node res = null;
		
		if(node1.data <= node2.data)
		{	
			res = node1;
			res.down = merge(node1.down,node2);
		}
		else
		{
			res = node2;
			res.down = merge(node1,node2.down);
		}
		
		return res;
	}
	
	public Node flatten(Node node)
	{
		if(node == null || node.next == null)
			return node;
		
		return merge(node, flatten(node.next));
	}
}

