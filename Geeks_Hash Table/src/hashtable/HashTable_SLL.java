package hashtable;

import java.util.ArrayList;

public class HashTable_SLL<K,V>
{
	class Node<K,V>
	{
		K key;
		V value;
		Node<K,V> next;
		
		public Node(K key,V value)
		{
			this.key = key;
			this.value = value;
			next = null;
		}
	}
	
	ArrayList<Node<K,V>> bucketarray;
	int numBuckets;
	int size;
	
	public HashTable_SLL()
	{
		bucketarray = new ArrayList<>();
		numBuckets = 10;
		size = 0;
		
		for(int i = 0;i < numBuckets; i++)
			bucketarray.add(null);
	}
	
	public int getIndex(K key)
	{
		int code = key.hashCode();
		//System.out.println("Index:" + (code % numBuckets));
		return (code % numBuckets);
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return (getSize() == 0);
	}
	
	public void put(K key,V value)
	{
		int index = getIndex(key);
		Node<K,V> head = bucketarray.get(index);
		
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
		head = bucketarray.get(index);
		Node<K,V> newnode = new Node<>(key, value);
		newnode.next = head;
		bucketarray.set(index, newnode);
		
		if((1.0 * size)/numBuckets > 0.7)
		{
			ArrayList<Node<K,V>> temp = bucketarray;
			bucketarray = new ArrayList<>();
			numBuckets *= 2;
			size = 0;
			
			for(int i =0;i< numBuckets;i++)
				bucketarray.add(null);
			
			for(Node<K,V> node:temp)
			{
				while(node != null)
					put(node.key,node.value);
				
				node = node.next;
			}
		}
	}
	
	public void display()
	{
		ArrayList<Node<K,V>> temp = bucketarray;
		
		for(Node<K,V> node : temp)
		{
			while(node != null)
			{
				System.out.println("Key:" + node.key + " Data:" + node.value);
				node = node.next;
			}
		}
	}
	
	public V getValue(K key)
	{
		int index = getIndex(key);
		Node<K,V> head = bucketarray.get(index);
		
		while(head != null)
		{
			if(head.key == key)
				return head.value;
			
			head = head.next;
		}
		return null;
	}
	
	public void remove(K key)
	{
		int index = getIndex(key);
		Node<K,V> head = bucketarray.get(index);
		Node<K,V> prev = null;
		
		while(head != null)
		{
			if(head.key == key)
				break;
			
			prev = head;
			head = head.next;
		}
		
		if(head == null)
			return;
		
		size--;
		if(prev != null)
			prev.next = head.next;
		else
			bucketarray.set(index, head.next);
	}
}