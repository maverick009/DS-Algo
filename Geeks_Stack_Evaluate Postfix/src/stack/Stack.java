package stack;

public class Stack 
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
	
	Node head = null;
	
	public void push(int data)
	{
		System.out.println("Push:" + data);
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;				
	}
	
	public void display()
	{
		if(head == null)
			return;
		
		Node temp = head;
		
		while(temp != null)
		{
			System.out.println("Stack data:" + temp.data);
			temp = temp.next;
		}
	}
	
	public int pop()
	{
		if(head == null)
			return 0;
		
		Node temp = head;
		
		System.out.println("data Popped:" + temp.data);
		head = head.next;
		
		return temp.data;
	}
	
	public boolean isEmpty()
	{
		return(head == null?true:false);
	}
	
	public int length()
	{
		if(head == null)
			return 0;
		
		Node temp = head;
		int count = 0;
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		
		return count;
	}
	
	public boolean isDigit(char c)
	{
		return ((c >= '0' && c <= '9')?true:false);
	}
	
	public int peek()
	{
		return head.data;
	}
	
	public int evaluatePostfix(String str)
	{
		if(str == null)
			return -1;
		
		for(int i = 0;i<str.length();i++)
		{
			System.out.println("str.charAt(i):" + str.charAt(i));
			if(isDigit(str.charAt(i)))
				push(str.charAt(i) - 48);
			
			else
			{
				if(!isEmpty() && length() >= 2)
				{
					System.out.println("peek:" + peek());
					int num2 = pop();
					System.out.println("peek:" + peek());
					int num1 = pop();
					
					switch(str.charAt(i))
					{
						case '+':push(num1 + num2);
							break;
						case '-':push(num1 - num2);
							break;
						case '*':push(num1 * num2);
						break;
						
						case '/':
							if(num2 != 0)
								push(num1 / num2);
						default:
					}
				}
			}
			display();
		}
		
		if(length() > 1)
			return -1;
		
		return head.data;
	}
}
