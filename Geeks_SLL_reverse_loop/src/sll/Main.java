package sll;

class SingleLinkList
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
	
	Node head;
	
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
	
	public void reverse()
	{
		if(head == null)
			return;
		
		Node prev = null, curr = head, next = null;
		
		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public Node detectLoop()
	{
		if(head == null)
			return null;
		
		Node slow = head,fast = head;
		while(slow != null && fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
			{
				System.out.println("Node:" + slow.data);
				return slow;
			}				
		}
		
		return null;
	}
	
	public void removeLoop()
	{
		
		Node slow = detectLoop();
		if(head == null || slow == null) 
			return;
		
		Node ptr1 = slow;
		Node ptr2 = slow;
		
		int loop_len = 1;
		while(ptr1.next != ptr2)
		{
			ptr1 = ptr1.next;
			loop_len++;
		}
		System.out.println("Number of nodes in loop:" + loop_len);
		
		ptr1 = head;
		for(int i =0;i<loop_len;i++)
			ptr2 = ptr2.next;
		
		while(ptr1 != ptr2)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		while(ptr1.next != ptr2)
			ptr1 = ptr1.next;
		System.out.println("ptr.data:" + ptr1.data);
		
		ptr1.next = null;
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
		
		System.out.println("head.data:" + sll.head.data);
		sll.display();
		
		System.out.println("reversing list");
		sll.reverse();
		sll.display();
		
		System.out.println("reversing list");
		sll.reverse();
		sll.display();
		
		
		System.out.println("Creating Loop");
		System.out.println("head:" + sll.head.data);
		System.out.println("2:" + sll.head.next.data);
		System.out.println("3:" + sll.head.next.next.data);
		System.out.println("4:" + sll.head.next.next.next.data);
		System.out.println("5:" + sll.head.next.next.next.next.data);
		System.out.println("6:" + sll.head.next.next.next.next.next.data);
		System.out.println("7:" + sll.head.next.next.next.next.next.next.data);

		sll.head.next.next.next.next.next.next.next = sll.head.next;
		//System.out.println("Loop:" + sll.detectLoop());
		//System.out.println(sll.head.data);
		System.out.println("removing loop");
		sll.removeLoop();
		System.out.println("Display");
		sll.display();
		
	}
}
