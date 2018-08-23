package main;

import hashtable.HashTable_SLL;

public class Main 
{
	public static void main(String[] args) 
	{
		/*HashTable ht = new HashTable();
		ht.insert(1, 20);
		ht.insert(2, 70);
		ht.insert(42, 80);
		ht.insert(4, 25);
		ht.insert(12, 44);
		ht.insert(14, 32);
		ht.insert(17, 11);
		ht.insert(13, 78);
		ht.insert(37, 97);
		
		System.out.println("Hash Table");
		ht.display();
		
		System.out.println("42 Present?" + ht.search(424));
		System.out.println("Deleting 37");
		ht.delete(37);*/
		
		HashTable_SLL<Integer, Integer> ht = new HashTable_SLL<>();
		ht.put(1, 1);
		ht.put(2, 4);
		ht.put(3, 9);
		
		System.out.println("Hash Table");
		ht.display();
		System.out.println("Remove 2");
		ht.remove(2);
		ht.display();
	}
}
