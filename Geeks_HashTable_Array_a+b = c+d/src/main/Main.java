package main;
import hashtable.HashTable;

public class Main 
{
	public static void main(String[] args) 
	{
		HashTable<Integer, Integer> ht = new HashTable<>();
		/*ht.put(1, 1);
		ht.put(2, 2);
		ht.put(3, 3);
		ht.display();
		ht.remove(2);
		ht.display();*/
		
		int []arr = {3, 4, 7, 1, 2, 9, 8};
		for(int i = 0;i < arr.length;i++)
			ht.put(arr[i], arr[i]);
		ht.pair(arr);
	}
}