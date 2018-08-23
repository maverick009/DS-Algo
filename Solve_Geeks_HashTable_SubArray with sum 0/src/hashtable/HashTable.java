package hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable
{
	class Node
	{
		int key;
		int value;
		Node next;
		
		public Node(int key, int value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	
	ArrayList<Node> ht;
	int numbucket,size;
	
	public HashTable()
	{
		this.numbucket = 10;
		this.size = 0;
		ht = new ArrayList<>();
		for(int i = 0;i < numbucket;i++)
			ht.add(null);
	}
	
	public int getIndex(int key)
	{
		return (key % numbucket);
	}
	
	public void put(int key, int value)
	{
		int index = getIndex(key);
		Node temp = ht.get(index);
		
		while(temp != null)
		{
			if(temp.key == key)
			{
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		
		temp = ht.get(index);
		size++;
		Node newnode = new Node(key, value);
		newnode.next = temp;
		ht.set(index, newnode);
		
		if((1.0 * size) / numbucket > 0.7)
		{
			ArrayList<Node> backup = ht;
			ht = new ArrayList<>();
			numbucket *= 2;
			size = 0;
			
			for(Node node : backup)
			{
				while(node != null)
				{
					put(node.key, node.value);
					node = node.next;
				}
			}
		}
	}
	
	public boolean contains(int key)
	{
		int index = getIndex(key);
		Node temp = ht.get(index);
		while(temp != null)
		{
			if(temp.key == key)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public void display()
	{
		for(Node node : ht)
		{
			while(node != null)
			{
				System.out.println("Key:" + node.key + "\tValue:" + node.value);
				node = node.next;
			}
		}
		System.out.println();
	}
	
	public void delete(int key)
	{
		int index = getIndex(key);
		Node temp = ht.get(index);
		
		Node prev = null;
		while(temp != null)
		{
			if(temp.key == key)
				break;
			prev = temp;
			temp = temp.next;
		}
		
		if(prev == null)
			ht.set(index, null);
		else
			prev.next = temp.next;
	}
}
