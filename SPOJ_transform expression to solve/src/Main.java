import java.util.Scanner;

class Node
{
	char data;
	Node next;
	
	public Node(char data)
	{
		this.data = data;
		this.next = null;
	}
}

class Stack
{
	Node head;
	
	public Stack()
	{
		head = null;
	}
	
	public void push(char data)
	{
		Node newnode = new Node(data);
		if(head == null)
			head = newnode;
		else
		{
			newnode.next = head;
			head = newnode;
		}
	}
	
	public char pop()
	{
		if(!isEmpty())
		{
			//System.out.println("data popped:" + head.data);
			Node temp = head;
			head = head.next;
			return temp.data;
		}
		return '$';		
	}
	
	public boolean isEmpty()
	{
		//System.out.println(head);
		if(head == null)
			return true;
		return false;
	}
	
	public char peek()
	{
		if(!isEmpty())
			return head.data;
		return '$';
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

class convertRPN
{	
	public static boolean isOperator(char c)
	{
		if(c == '\0')
			return false;
		return (c == '+' || c =='-' || c == '*' || c == '/' || c == '(' || c == ')');
	}
	
	public static boolean isOperand(char c)
	{
		if(c == '\0')
			return false;
		
		return (( c >= 'a' && c<= 'z') || (c >= 'A' && c <= 'Z'));
	}
	
	static public int getPrecedence(char c)
	{
		if(c == '\0')
			return -1;
		
		switch(c)
		{
			case '+':
			case '-':
				return 1;
				
			case '/':
			case '*':
					return 2;
			case '^':
					return 3;
			default:
					return -1;
		}
	}
	
	public String convert(String str)
	{
		if(str == null)
			return null;
		
		Stack stack = new Stack();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<str.length();i++)
		{
			char c = str.charAt(i);
			
			if(isOperand(c))
				sb.append(c);
			else if(c == '(')
				stack.push(c);
			
			else if(c == ')')
			{
				while(!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				
				if(!stack.isEmpty() || stack.peek() != '(')
					return null;
				else
					c =stack.pop();
			}
			else if(isOperator(c))
			{
				if(!stack.isEmpty() && convertRPN.getPrecedence(c) <= convertRPN.getPrecedence(stack.peek()))
					sb.append(stack.pop());
				stack.push(c);
			}
			
		}		
		return sb.toString();
	}
	
}


public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int testcases = sc.nextInt();
		convertRPN convertrpn = new convertRPN();
		for(int i=0;i<testcases;i++)
		{
			String str = sc.next();
			System.out.println(convertrpn.convert(str));
		}
		sc.close();
	}
}
