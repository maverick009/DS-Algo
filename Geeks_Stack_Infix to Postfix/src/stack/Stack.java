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
	
	public Node head = null;
	
	public void push(char data)
	{
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
			System.out.println("Stack data:"+ temp.data);
			temp = temp.next;
		}
	}
	
	public boolean isEmpty()
	{
		return (head == null)?true:false;
	}
	
	public char peek()
	{
		if(head == null)
			return '\0';
		
		return head.data;
	}
	
	public char pop()
	{
		if(head == null)
			return '\0';
		
		Node temp = head;
		//System.out.println("data pulled:" + temp.data);
		head = head.next;
		return temp.data;
	}
	
	public int precedence(char c)
	{
		if(c == '\0')
			return -1;
		
		switch(c)
		{
			case '^': return 3;
			
			case '/':
			case '*': return 2;
			
			case '+':
			case '-': return 1;
			
			default: return -1;
		}
	}
	
	public boolean isOperand(char c)
	{
		return ((c >= 'a' && c <= 'z') || (c>= 'A' && c<= 'Z') ? true:false);
	}
	
	public String infixToPostfix(String str)
	{
		if(str == null)
			return null;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<str.length();i++)
		{
			if(isOperand(str.charAt(i)))
				sb.append(str.charAt(i));
			
			else if(str.charAt(i) == '(')
				push(str.charAt(i));
			
			else if(str.charAt(i) == ')')
			{
				while(!isEmpty() && peek() != '(')
					sb.append(pop());
				
				if(!isEmpty() && peek() != '(')
					return "Invalid String";
				else
					pop();		
			}
			else
			{
				while(!isEmpty() && precedence(str.charAt(i)) <= precedence(peek()))
					sb.append(pop());
				push(str.charAt(i));
			}
		}
		while(!isEmpty())
			sb.append(pop());
		
		return sb.toString();
	}
}
