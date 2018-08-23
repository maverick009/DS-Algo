package hashtable;

import java.util.ArrayList;

public class HashTable<K,V> 
{
	class Node<K,V>
	{
		K key;
		V value;
		Node<K,V> next;
		
		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			next = null;
		}
	}
	
	ArrayList<Node<K,V>> bucketArray;
	int numbuckets;
	int size;
	
	public HashTable()
	{
		bucketArray = new ArrayList<>();
		numbuckets = 10;
		size = 0;
		
		for(int i = 0;i < numbuckets; i++)
			bucketArray.add(null);
	}
	
	public int getIndex(K key)
	{
		int code = key.hashCode();
		return (code % numbuckets);
	}
	
	
	public void put(K key, V value)
	{
		int index = getIndex(key);
		Node<K,V> head = bucketArray.get(index);
		
		while(head != null)
		{
			if(head.key == key)
			{
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		size++;
		head = bucketArray.get(index);
		Node<K,V> newnode = new Node<>(key, value);
		newnode.next = head;
		bucketArray.set(index, newnode);
		
		if((1.0 * size)/numbuckets > 0.7)
		{
			ArrayList<Node<K,V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			numbuckets *= 2;
			size = 0;
			
			for(Node<K,V> node : temp)
			{
				if(node != null)
				{
					put(node.key, node.value);
					node = node.next;
				}
			}
		}
	}
	
	public void display()
	{		
		for(Node<K,V> temp : bucketArray)
		{
			while(temp != null)
			{
				System.out.println("Key:" + temp.key + " Value:" + temp.value);
				temp = temp.next;
			}
		}
	}
	
	public boolean search(K key)
	{
		int index = getIndex(key);
		Node<K,V> head = bucketArray.get(index);
		
		while(head != null)
		{
			if(head.key == key)
				return true;
			head = head.next;
		}
		return false;
	}
	
}
