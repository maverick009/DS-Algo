package sll;

public class SLL 
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
	
	public Node head;
	
	public Node insert(Node node, int data)
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
		while(node != null)
		{
			System.out.println("Data:" + node.data);
			node = node.next;
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
	
	public Node merge(Node node1,Node node2)
	{
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		
		Node res = null;
		Node temp1 = node1,temp2 = node2;
		
		if(temp1.data <= temp2.data)
		{
			res = temp1;
			res.next = merge(temp1.next, temp2);
		}
		else
		{
			res = temp2;
			res.next = merge(temp1, temp2.next);
		}
				
		return res;
	}
	
	public Node mergeSort(Node node)
	{
		if(node == null || node.next == null)
			return node;
		
		Node temp1 = node,temp2 = null;
		for(int i = 0;i< (length(node) - 1)/2;i++)
			temp1 = temp1.next;
		
		if(temp1.next != null)
			temp2 = temp1.next;
		
		temp1.next = null;
		temp1 = node;
		
		temp1 = mergeSort(temp1);
		temp2 = mergeSort(temp2);
		
		node = merge(temp1, temp2);
		
		return node;
	}

}
