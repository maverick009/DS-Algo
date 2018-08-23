package bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST 
{
	class Node
	{
		int data;
		Node left, right;
		
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	
	public Node root;
	
	public Node insert(Node node, int data)
	{
		if(node == null)
			return new Node(data);
		
		if(data < node.data)
			node.left = insert(node.left, data);
		else
			node.right = insert(node.right, data);
		return node;
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public void levelorder(Node node)
	{
		if(node == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			if(temp == null)
				break;
			
			System.out.print(temp.data + " ");
			
			if(node.left != null)
				queue.offer(temp.left);
			
			if(node.right != null)
				queue.offer(temp.right);
		}
	}
}
