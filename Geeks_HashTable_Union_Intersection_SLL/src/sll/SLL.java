package sll;

import java.util.HashMap;
import java.util.Map;

public class SLL 
{
	public class Node
	{
		int data;
		Node next;
		
		public Node()
		{
			
		}
		
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
			System.out.println("Data:" + temp.data);
			temp = temp.next;
		}
	}
	
	public Node remove(Node node)
	{
		if(node == null)
			return null;
		System.out.println("Node Remove:" + node.data);
		node = node.next;
		return node;
	}
	
	public boolean isEmpty(Node node)
	{
		return ((node == null)?true:false);
	}
	
	public int length(Node node)
	{
		if(node == null)
			return -1;
		
		int count = 0;
		Node temp = node;
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public Node union(Node node1,Node node2)
	{
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		
		Map<Integer, Integer> hm = new HashMap<>();
		
		Node temp1 = node1;
		while(temp1 != null)
		{
			hm.put(temp1.data, temp1.data);
			temp1 = temp1.next;
		}
		
		Node temp2 = node2;
		while(temp2 != null)
		{
			if(!hm.containsKey(temp2.data))
				hm.put(temp2.data, temp2.data);
			temp2 = temp2.next;
		}
		System.out.println(hm.toString());
		Node res = null;
		for(Map.Entry<Integer, Integer> pair: hm.entrySet())
		{
			Node newnode = new Node(pair.getValue());
			newnode.next = res;
			res = newnode;
		}
		//hm.forEach((k,v) -> {Node res = null;Node newnode = new Node(v);newnode = res;res = newnode;});
		
		
		return res;
	}
	
	public Node intersection(Node node1,Node node2)
	{
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		Node temp1 = node1;
		while(temp1 != null)
		{
			hm.put(temp1.data, temp1.data);
			temp1 = temp1.next;
		}
		
		Node temp2 = node2,res = null;
		while(temp2 != null)
		{
			if(hm.containsKey(temp2.data))
			{
				Node newnode = new Node(temp2.data);
				newnode.next = res;
				res= newnode;
			}
			temp2 = temp2.next;
		}
		
		return res;
	}
}
