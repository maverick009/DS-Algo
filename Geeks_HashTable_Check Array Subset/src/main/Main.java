package main;
//import hashtable.HashTable;;

import java.util.HashMap;

public class Main 
{
	public static void main(String[] args) 
	{
		/*HashTable<Integer, Integer> ht = new HashTable<>();
		int []a1 = {11,1,13,21,3,7};
		for(int i = 0;i<a1.length;i++)
			ht.put(a1[i], a1[i]);
		
		int []a2 = {11,3,7,1,5};
		int i =0;
		for(i = 0;i< a2.length;i++)
		{
			if(!ht.search(a2[i]))
			{
				System.out.println("No");
				break;
			}
		}
		if(i == a2.length)
			System.out.println("Yes");
		
		 */		
		int []a1 = {11,1,13,21,3,7};
		int []a2 = {11,3,7,1,5};
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i:a1)
			hm.put(i, i);
		boolean b = true;
		for(int i:a2)
		{
			if(!hm.containsKey(i))
				b = false;
		}
		System.out.println("Subset?" + b);
		
	}

}
