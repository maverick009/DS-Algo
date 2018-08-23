package main;

import queue.PriorityQueue;

public class Main 
{
	public static void main(String[] args) 
	{
		PriorityQueue pq = new PriorityQueue(10);
		pq.offer("GeeksForGeeks10", 10);
		pq.offer("GeeksForGeeks7", 7);
		pq.offer("GeeksForGeeks2", 2);
		pq.offer("GeeksForGeeks9", 9);
		pq.offer("GeeksForGeeks1", 1);
		pq.offer("GeeksForGeeks6", 6);
		pq.offer("GeeksForGeeks8", 8);
		pq.offer("GeeksForGeeks12", 12);
		
		System.out.println("Priority Queue");
		pq.display();
		
		System.out.println("\nPoll");
		pq.poll();
		System.out.println("\nPriority Queue");
		pq.display();
		
	}
}
