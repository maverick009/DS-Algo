package hashtable; 

import java.util.ArrayList;

public class HashTable<K,V> 
{
	public class Node<K,V>
	{
		K key;
		V value;
		Node<K,V> next;
		
		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	int numbuckets, size;
	ArrayList<Node<K,V>> hashtable;
	
	public HashTable()
	{
		this.size = 0;
		this.numbuckets = 10;
		hashtable = new ArrayList<>();
		
		for(int i = 0;i < numbuckets;i++)
			hashtable.add(null);
	}
	
	public int getIndex(Integer key)
	{
		return (key.hashCode() % numbuckets);
	}
	
	public boolean isEmpty()
	{
		return (this.size == 0);
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void put(Integer key, V value)
	{
		int index = getIndex(key);
		Node<K,V> head = hashtable.get(index);
		Node<K,V> prev = null;
		
		while(head != null)
		{
			if(head.key == key)
			{
				head.value = value;
				break;
			}
			
			prev = head;
			head = head.next;
		}
		
		size++;
		head = hashtable.get(index);
		Node<K,V> newnode = new Node(key, value);
		newnode.next = head;
		hashtable.set(index, newnode);
		
		if((1.0 * size)/numbuckets > 0.7)
		{
			ArrayList<Node<K,V>> temp = hashtable;
			hashtable = new ArrayList<>();
			
			numbuckets *= 2;
			size = 0;
			
			for(Node<K,V> node : temp)
			{
				while(node != null)
				{
					put((Integer)node.key, node.value);
					node = node.next;
				}
			}
		}
	}
	
	public void display()
	{
		if(isEmpty())
			return;
		
		for(Node<K,V> node : hashtable)
		{
			while(node != null)
			{
				System.out.println("key:" + node.key + "\tValue:" + node.value);
				node = node.next;
			}
		}
		System.out.println();
	}
	
	public void remove(Integer key)
	{
		if(isEmpty())
			return;
		
		int index = getIndex(key);
		
		Node<K,V> node = hashtable.get(index);
		Node<K,V> prev = null;
		
		while(node != null)
		{
			if(node.key == key)
				break;
			prev = node;
			node = node.next;
		}
		
		if(node == null)
			return;
		
		if(prev == null)
			hashtable.set(index, node.next);
		else
			prev.next = node.next;
	}
	
	public boolean ispresent(Integer key)
	{
		int index = getIndex(key);
		Node<K,V> node = hashtable.get(index);
		while(node != null)
		{
			if(node.key == key)
				return true;
			node = node.next;
		}
		return false;
	}
	
	public V get(Integer key)
	{
		int index = getIndex(key);
		Node<K,V> node = hashtable.get(index);
		while(node != null)
		{
			if(node.key == key)
				return node.value;
			node = node.next;
		}
		return null;
	}
	
	public void pair(int []arr)
	{
		boolean []visited = new boolean[1000];
		for(int i = 0;i < visited.length;i++)
			visited[i] = false;
		
		int l = 0,h = arr.length - 1;
		while(l < h)
		{
			int sum = arr[l] + arr[h];
	
			for(int i = l + 1;i < h;i++)
			{
				int diff = sum - arr[i];
				if(ispresent(diff) && !visited[diff])
				{
					System.out.println(arr[l] + " + " + arr[h] + " = " + arr[i] + " + " + diff);
					visited[arr[l]] = true;
					visited[arr[h]]  = true;
					break;
				}
			}
			l++;
			h--;
		}
	}
}