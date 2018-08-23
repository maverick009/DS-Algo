package queue;

public class Queue 
{
	class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	Node head,rear;
	
	public void enqueue(int data)
	{
		Node newnode = new Node(data);
		if(rear == null)
			head = rear = newnode;
		
		rear.next = newnode;
		rear = newnode;
	}
	
	public void display()
	{
		if(head == null)
			return;
		
		Node temp = head;
		while(temp != null)
		{
			System.out.println("Data:" + temp.data);
			temp = temp.next;
		}
	}
	
	public void dequeue()
	{
		if(head == null || rear == null)
			return;
		
		Node temp = head;
		System.out.println("Data Dequeued:" + temp.data);
		head = head.next;
	}
	
	public boolean isEmpty()
	{
		return ((head == null)?true:false);
	}
	
	public int peek()
	{
		if(head == null)
			return 999999999;
		
		return head.data;
	}
}
