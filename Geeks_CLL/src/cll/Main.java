package cll;

class CircularLinkList
{
	static class Node
	{
		int data;
		Node next;
	
		public Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	Node head,tail;
	
	public CircularLinkList()
	{
		this.head = null;
		this.tail = null;
	}
	
	public void insertHead(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
		
		if(tail == null)
			tail = head;
		else
			tail.next = head;
	}
	
	public void insertEnd(int data)
	{
		if(tail == null)
		{
			insertHead(data);
			return;
		}
		Node newnode = new Node(data);
		newnode.next = head;
		tail.next = newnode;
		tail = newnode;
	}
	
	public void deleteKey(int data)
	{
		if(head == null || tail == null)
			return;
		
		Node temp = head, prev = null;
		
		while(temp.data != data)
		{
			prev = temp;
			temp = temp.next;
			
			if(temp == head)
				break;
		}
		
		if(prev == null)
		{
			head = head.next;
			tail.next = head;
		}
		
		else if(temp == head)
			return;
		
		else if(temp == tail)
		{
			tail = prev;
			tail.next = head;
		}
		else
			prev.next = temp.next;
	}
	
	public int length()
	{
		if(head == null || tail == null)
			return -1;
		
		Node temp = head;
		int len = 0;
		while(temp != null)
		{
			temp = temp.next;
			len++;
			
			if(temp == head)
				return len;
		}
		
		return -1;
	}
	
	
	public void display()
	{
		if(head == null || tail == null)
			return;
		
		Node temp = head;
		
		while(true)
		{
			System.out.println("data:" + temp.data);
			temp = temp.next;
			
			if(temp == head)
				break;
		}
	}
}


public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		CircularLinkList cll = new CircularLinkList();
		cll.insertHead(7);
		cll.insertHead(6);
		cll.insertHead(5);
		cll.insertHead(4);
		cll.insertHead(3);
		cll.insertHead(2);
		cll.insertHead(1);
		
		cll.display();
		System.out.println("Adding 8 at end");
		cll.insertEnd(8);
		cll.display();
		
		System.out.println(cll.head.data);
		System.out.println(cll.head.next.data);
		System.out.println(cll.head.next.next.data);
		System.out.println(cll.head.next.next.next.data);
		System.out.println(cll.head.next.next.next.next.data);
		System.out.println(cll.head.next.next.next.next.next.data);
		System.out.println(cll.head.next.next.next.next.next.next.data);
		System.out.println(cll.head.next.next.next.next.next.next.next.data);
		System.out.println(cll.head.next.next.next.next.next.next.next.next.data);
		System.out.println(cll.tail.data);
		
		System.out.println("deleting 3");
		cll.deleteKey(9);
		cll.display();
		
		System.out.println("length:" + cll.length());
		
	}
}
