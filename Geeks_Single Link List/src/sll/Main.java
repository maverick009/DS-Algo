package sll;

class SingleLinkList
{
	
	private static class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	
	public SingleLinkList()
	{
		head = null;
	}
	
	public void insert(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	
	public void deleteAtStart()
	{
		System.out.println("data deleted:" + head.data);
		head = head.next;
	}
	
	public void deleteKey(int data)
	{
		if(head == null)
			return;
		
		Node temp = head,prev = null;
		
		if(head.data == data)
			head = head.next;
		
		while(temp != null && temp.data != data)
		{
			prev = temp;
			temp = temp.next;
		}			
		
		if(temp == null)
			return;
		
		prev.next = temp.next;		
	}
	
	public void deleteAtPoint(int index)
	{
		if(head == null)
			return;
		
		if(index == 0)
			head = head.next;
		
		Node temp = head, prev = null;
		int i =0;
		while(temp != null && i < index)
		{
			prev = temp;
			temp = temp.next;
			i++;
		}
		
		if(i == index && temp == null)
			return;
		
		prev.next = temp.next;		
	}
	
	public int length()
	{
		if(head == null)
			return 0;
		Node temp = head;
		int len = 0;
		while(temp != null)
		{
			temp = temp.next;
			len++;
		}
		return len;
	}
	
	public int search(int data)
	{
		if(head == null)
			return -1;
		
		if(head.data == data)
			return 0;
		
		Node temp = head;
		int index = 0;
		while(temp != null && temp.data != data)
		{
			temp = temp.next;
			index++;
		}
		
		if(temp == null)
			return -1;
		
		if(temp.data == data)
			return index;
		
		return -1;
	}
	
	public void display()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.println("data:" + temp.data);
			temp = temp.next;
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
		SingleLinkList sll = new SingleLinkList();
		sll.insert(7);
		sll.insert(6);
		sll.insert(5);
		sll.insert(4);
		sll.insert(3);
		sll.insert(2);
		sll.insert(1);
		sll.display();
		
		/*System.out.println("length:" + sll.length());
		sll.deleteKey(3);
		sll.display();
		System.out.println("length:" + sll.length());
		sll.deleteAtPoint(2);
		sll.display();
		System.out.println("length:" + sll.length());*/
		
		System.out.println(sll.search(0));
	}
}
