package stack;

public class Stack 
{
	class Node
	{
		char data;
		Node next;
		public Node(char data)
		{
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	
	public void push(char data)
	{
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	
	public char pop()
	{
		if(head == null)
			return '\0';
		
		Node temp = head; 
		System.out.println("Data Popped:" + temp.data);
		head = head.next;
		return temp.data;
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
	
	public boolean isEmpty()
	{
		return ((head == null)?true:false);
	}

	public String reverse(String str)
	{
		for(int i = 0;i<str.length();i++)
			push(str.charAt(i));
		
		StringBuilder temp = new StringBuilder();
		while(!isEmpty())
			temp.append(pop());
		return temp.toString();
	}
}
