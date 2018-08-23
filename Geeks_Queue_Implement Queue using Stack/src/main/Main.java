package main;
import queue.Queue;

public class Main 
{
	public static void main(String[] args) 
	{
		Queue q = new Queue();
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		q.offer(60);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());		
		System.out.println(q.pop());		
		System.out.println(q.pop());		
		System.out.println(q.pop());		
	}
}
