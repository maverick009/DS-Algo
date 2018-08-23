package dll;

class DoubleLinkList
{
	static class Node
	{
		int data;
		Node next;
		Node prev;
	
		public Node(int data)
		{
			this.data = data;
			next = prev = null;
		}
	}
	
	Node head;
	
	public DoubleLinkList()
	{
		head = null;
	}
	
	public void insert(int data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		newnode.prev = null;
		if(head != null)
			head.prev = newnode;
		head = newnode;
	}
	
	
	public void insertAt(int index,int data)
	{
		if(head == null || index < 0 || data < 0)
			return;
		
		Node temp = head;
		
		int i = 0;
		while(temp != null && i < index)
		{
			temp = temp.next;
			i++;
		}
		
		Node newnode = new Node(data);
		newnode.next = temp.next;
		newnode.prev = temp;
		if(temp.next != null)
			temp.next.prev = newnode;
		temp.next = newnode;
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
		DoubleLinkList dll = new DoubleLinkList();
		dll.insert(8);
		dll.insert(7);
		dll.insert(6);
		dll.insert(5);
		dll.insert(4);
		dll.insert(3);
		dll.insert(2);
		dll.insert(1);
		
		dll.display();
		
		System.out.println("inserting at 4");
		dll.insertAt(0, 0);
		dll.display();
	}
}
