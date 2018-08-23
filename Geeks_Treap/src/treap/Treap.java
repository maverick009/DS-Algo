package treap;

import java.util.LinkedList;
import java.util.Queue;

public class Treap 
{
	public class Node
	{
		int data, priority;
		Node left, right;
		
		public Node(int data)
		{
			this.data = data;
			this.priority = (int)(Math.random() * 100);
			left = right = null;
		}
	}
	
	public Node root;
	
	public Node rightrotate(Node node)
	{
		Node temp1 = node.left;
		Node temp2 = temp1.right;
		temp1.right = node;
		node.left = temp2;
		return temp1;
	}
	
	public Node leftrotate(Node node)
	{
		Node temp1 = node.right;
		Node temp2 = temp1.left;
		temp1.left = node;
		node.right = temp2;
		return temp1;
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print("\ndata:" + node.data + "\tPriority:" + node.priority);
		if(node.left != null)
			System.out.print("\tLeft Child:" + node.left.data);
		if(node.right != null)
			System.out.print("\tRight Child:" + node.right.data);
		inorder(node.right);
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
	
	public Node search(Node node, int data)
	{
		if(node == null || node.data == data)
			return node;
		if(data <= node.data)
			return search(node.left, data);
		else
			return search(node.right, data);
	}
	
	public Node insert(Node node, int data)
	{
		if(node == null)
			return new Node(data);
		
		if(data <= node.data)
		{
			node.left = insert(node.left, data);
			if(node.left.priority > node.priority)
				node = rightrotate(node);
		}
		else
		{
			node.right = insert(node.right, data);
			if(node.right.priority > node.priority)
				node = leftrotate(node);
		}
		return node;
	}
	
	public Node delete(Node node, int data)
	{
		if(node == null)
			return node;
		
		if(data < node.data)
			node.left = delete(node.left, data);
		else if(data > node.data)
			node.right = delete(node.right, data);
		else
		{
			if(node.left == null)
				node = node.right;			
			else if(node.right == null)
				node = node.left;
			else
			{
				if(node.left.priority < node.right.priority)
				{
					node = leftrotate(node);
					node.left = delete(node.left, data);
				}
				else
				{
					node = rightrotate(node);
					node.right = delete(node.right, data);
				}
			}
		}
		return node;
	}
}