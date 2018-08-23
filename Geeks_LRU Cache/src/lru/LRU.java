package lru;

import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;

class DLL
{
	public class Node
	{
		int key;
		int value;
		Node prev,next;
		
		public Node(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	private int size;
	Map<Integer, Node> map = new HashMap<>();
	Node head, tail;
	
	public boolean search(int key)
	{
		return map.containsKey(key);
	}
	
	public int getSize()
	{
		return this.size;
	}
	/*
	 * node1(tail) -> node2 -> node3(head)
	 * tail = least recently used
	 */
	public void insert(int key, int value)
	{
		Node newnode = new Node(key, value);
		if(head == null && tail == null)		
			head = tail = newnode;
		else
		{
			head.next = newnode;
			newnode.prev = head;
			head = head.next;
		}
		this.size++;
		map.put(key, newnode);	
	}
	
	public void remove(Node node)
	{
		if(node == null)
			return;
		
		if(head == tail)
			head = tail = null;
		
		if(node == head)
		{
			head = head.prev;
			head.next = null;
		}
		else if(node == tail)
		{
			tail = tail.next;
			tail.prev = null;
		}
		else
		{
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}
		map.remove(node.key);
		this.size--;
	}
	
	public void print()
	{
		Node temp = tail;
		while(temp != null)
		{
			System.out.print(temp.key + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

public class LRU
{
	private final int capacity;
	DLL dll = new DLL();
	
	public LRU(int capacity)
	{
		this.capacity = capacity;
	}
	
	public void insertinCache(int key, int value)
	{
		if(dll.search(key))
		{
			dll.remove(dll.map.get(key));
			dll.insert(key, value);
		}
		else
		{
			if(dll.getSize() >= capacity)
				dll.remove(dll.map.get(dll.tail.key));
			dll.insert(key, value);
		}
	}
	
	public void print()
	{
		dll.print();
	}
}

/*
 * Using Java STL 
 */

/*public class LRU<K, V> extends LinkedHashMap<K, V> 
{
	private final int capacity;
	public LRU(int capacity, float loadfactor)
	{
		super(capacity, loadfactor, true);
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
	{
		return size() > this.capacity;
	}	
}*/