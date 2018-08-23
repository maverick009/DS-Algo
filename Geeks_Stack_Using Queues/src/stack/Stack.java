package stack;
import java.util.LinkedList;


public class Stack 
{
	LinkedList<Integer> q1;
	LinkedList<Integer> q2;
	
	public Stack()
	{
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}
	
	public void display()
	{
		if(q1 == null)
			return;
		
		for(int i:q1)
			System.out.println("Data:" + i);
	}
	
	public int pop()
	{
		return dequeue();
	}
	
	public void push(int data)
	{
		enqueue(data);
	}
	
	public int dequeue()
	{
		return q1.removeLast();
	}
	
	/*public void enqueue(int data)
	{
		q2.addFirst(data);
		while(!q1.isEmpty())
			q2.addFirst(q1.removeLast());
		
		LinkedList<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}*/
	
	public void enqueue(int data)
	{
		int size = q1.size();
		q1.addFirst(data);
		for(int i = 0;i<size;i++)
		{
			q1.addFirst(q1.getLast());
			q1.removeLast();
		}
	}
}
