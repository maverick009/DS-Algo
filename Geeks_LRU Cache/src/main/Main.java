package main;
import lru.LRU;

public class Main 
{
	public static void main(String []args)
	{
		LRU lru = new LRU(3);
		lru.insertinCache(7, 7);
		lru.insertinCache(0, 0);
		lru.insertinCache(3, 3);
		lru.print();
		lru.insertinCache(6, 6);
		lru.insertinCache(7, 7);
		lru.print();
		lru.insertinCache(3, 3);
		lru.insertinCache(2, 2);
		lru.print();
	}	
}	
	/*
	 * Using JAVA LinkedHashedMap
	 */
	/*public static void main(String[] args) 
	{
		LRU<Integer, String> lru = new LRU<>(3, 0.75F);
		lru.put(1, "object1");
		lru.put(2, "object2");
		lru.put(3, "object3");
		lru.get(1);
		System.out.println(lru);
		lru.put(4, "object4");
		System.out.println(lru);
		lru.put(5, "object5");
		lru.get(3);
		lru.put(6, "object6");
		System.out.println(lru);
		lru.put(7, "object7");
		lru.put(8, "object8");
		System.out.println(lru);
	}*/