package main;

import hashtable.HashTable;

public class Main 
{
	public static void main(String[] args) 
	{
		int arr[] =  {-3, 2, 3, 1, 6};
		HashTable ht = new HashTable();
		ht.put(1, 1);
		ht.put(2, 2);
		ht.put(3, 3);
		ht.display();
		
		ht.delete(2);
		ht.display();
	}
}
