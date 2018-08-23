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
	
	public void swap(int data1,int data2)
	{
		if(head == null || length() <= 1 || data1 == data2 || data1 <= 0 || data2 <= 0)
			return;
		
		Node temp1 = head, temp2 = head, prev1 = null, prev2 = null;
		Node temp = null;
		while(temp1 != null && temp1.data != data1)
		{
			prev1 = temp1;
			temp1 = temp1.next;
		}
		
		while(temp2 != null && temp2.data != data2)
		{
			prev2 = temp2;
			temp2 = temp2.next;
		}
		
		if(temp1 == null || temp2 == null)
			return;		
		
		if(prev1 != null)
			prev1.next = temp2;
		else
			head = temp2;
		
		if(prev2 != null)
			prev2.next = temp1;
		else
			head = temp1;
		
		temp = temp1.next;
		temp1.next = temp2.next;
		temp2.next = temp;
	}	
	
	public int valueNode(int index)
	{
		if(head == null || index < 0 || index > length())
			return -1;
		Node temp = head;
		
		int i = 0;
		while(temp != null && i < index)
		{
			temp = temp.next;
			i++;
		}
		
		if(temp == null)
			return -1;
		
		return temp.data;
	}
	
	public int nodeFromEnd(int index)
	{
		if(head == null || index < 0 || index >= length())
			return -1;
		
		Node temp = head;
		
		int i = 0;
		while(temp != null && i < length() - index - 1)
		{
			temp = temp.next;
			i++;
		}
		
		if(temp == null)
			return -1;
		
		return temp.data;
	}
	
	public int middleNode()
	{
		if(head == null)
			return -1;
		Node slow = head, fast = head;
		
		while(slow != null && fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
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
		
		if(len == 0)
			return 0;
		
		return len;
	}
	
	public void display()
	{
		if(head == null)
			return;
		
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
		System.out.println("length:" + sll.length());
		
		//sll.swap(1,7);
		//sll.display();
		System.out.println("value at index:" + sll.valueNode(6));
		
		System.out.println("value from node:" + 3 + " is:" + sll.nodeFromEnd(7));
		System.out.println("middle Node:" + sll.middleNode());
	}
}
