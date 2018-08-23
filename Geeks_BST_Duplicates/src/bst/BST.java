package bst;

public class BST 
{
	class Node
	{
		int data, count;
		Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			this.count = 1;
			left = right = null;
		}
	}
	
	public Node root;
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.left);
		for(int i = 0;i < node.count;i++)
			System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public Node minSuccessor(Node node)
	{
		if(node == null)
			return node;
		while(node.left != null)
			node = node.left;
		return node;
	}
	
	public Node insert(Node node, int data)
	{
		if(node == null)
			return new Node(data);
		
		if(data < node.data)
			node.left = insert(node.left, data);
		else if(data > node.data)
			node.right = insert(node.right, data);
		else
			node.count++;
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
			if(node.count > 1)
			{
				node.count--;
				return node;
			}
			
			if(node.left == null)
			{
				Node temp = node.right;
				node = null;
				return temp;
			}
			
			else if(node.right == null)
			{
				Node temp = node.left;
				node = null;
				return temp;
			}
			
			Node temp = minSuccessor(node.right);
			node.data = temp.data;
			node.count = temp.count;
			temp.count = 1;
			node.right = delete(node.right, temp.data);
		}
		return node;
	}
}
