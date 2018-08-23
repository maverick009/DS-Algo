package queue;
import java.util.Stack;

public class Queue 
{
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public Queue()
	{
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public void display()
	{
		if(stack1.isEmpty())
			return;
		
		for(int i:stack1)
		{
			System.out.println("data:" + i);
		}
	}
	
	public void offer(int item)
	{
		stack1.push(item);
	}
	
	public int pop()
	{
		if(stack1.isEmpty() && stack2.isEmpty())
			return -1;
		if(stack2.isEmpty())
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
		return stack2.pop();
	}
}

