package expressiontree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionTree 
{
	class Node
	{
		char data;
		Node left, right;
		
		public Node(char data)
		{
			this.data = data;
			left = right = null;
		}
	}
	
	public Node root;
	public boolean isOperator(char ch)
	{
		return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public void preorder(Node node)
	{
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder(Node node)
	{
		if(node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
	
	public void levelorder(Node node)
	{
		if(node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.offer(temp.left);
			
			if(temp.right != null)
				queue.offer(temp.right);
		}
	}
	
	public Node constructTree(String str)
	{
		if(str.length() == 0)
			return null;
		Stack<Node> stack = new Stack<>();
		
		char []arr = str.toCharArray();
		
		for(int i = 0;i < arr.length;i++)
		{
			if(!isOperator(arr[i]))
				stack.push(new Node(arr[i]));
			else
			{
				Node temp = new Node(arr[i]);
				Node temp1 = stack.pop();
				Node temp2 = stack.pop();
				
				temp.right = temp1;
				temp.left = temp2;
				
				stack.push(temp);
			}
		}
		return stack.peek();		
	}
}