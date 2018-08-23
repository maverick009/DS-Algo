package main;

import queue.Queue;

public class Main 
{
	public static void main(String[] args) 
	{
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(70);
		
		System.out.println("Queue:");
		q.display();
		
		q.dequeue();
		q.display();
		System.out.println(q.isEmpty());
	}

}
