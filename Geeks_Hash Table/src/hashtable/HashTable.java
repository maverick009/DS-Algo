//Linear Probing
package hashtable;

public class HashTable 
{
	private int size = 10;
	
	public class Node
	{
		int data;
		int key;
		
		public Node(int key,int data)
		{
			this.key = key;
			this.data = data;
		}
	}
	Node []arr = new Node[size];
	
	public int hashCode(int key)
	{
		return (key % size);
	}
	
	public void insert(int key,int data)
	{
		Node newnode = new Node(key,data);
		int hashindex = hashCode(key);
		
		while(arr[hashindex] != null)
		{
			hashindex++;
			hashindex %= size;
		}
		arr[hashindex] = newnode;
	}
	
	public void display()
	{
		for(int i = 0;i<size;i++)
		{
			if(arr[i] != null)
				System.out.println("Key:" + arr[i].key + " Data:" + arr[i].data);
			else
				System.out.println("~~");
		}
	}
	
	public boolean search(int key)
	{
		int hashindex = hashCode(key);
		
		while(arr[hashindex] != null)
		{
			if(arr[hashindex].key == key)
				return true;
			
			hashindex++;
			
			hashindex %= size;
		}
		return false;
	}
	
	public void delete(int key)
	{
		int hashindex = hashCode(key);
		while(arr[hashindex] != null)
		{
			if(arr[hashindex].key == key)
			{
				System.out.println("Value of Key:" + arr[hashindex].data);
				arr[hashindex] = null;
			}
			hashindex++;
			hashindex %= size;
		}
	}
}
