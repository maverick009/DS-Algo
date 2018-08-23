package splay;

public class Splay 
{
	public class Node
	{
		public int data;
		public Node left, right;
		
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	
	public Node root;
	
	public void preorder(Node node)
	{
		if(node == null)
			return;
		
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public Node minsuccessor(Node node)
	{
		if(node == null)
			return node;
		
		while(node.left != null)
			node = node.left;
		return node;
	}
	
	public Node maxsuccessor(Node node)
	{
		if(node == null)
			return node;
		while(node.right != null)
			node = node.right;
		return node;
	}
	
	public Node leftrotate(Node node)
	{
		if(node == null)
			return node;
		
		Node temp1 = node.right;
		node.right = temp1.left;
		temp1.left = node;
		return temp1;
	}
	
	public Node rightrotate(Node node)
	{
		if(node == null)
			return null;
		
		Node temp1 = node.left;
		node.left = temp1.right;
		temp1.right = node;
		return temp1;
	}
	
	public Node splay(Node node, int data)
	{
		if(node == null || data == node.data)
			return node;
		
		if(data < node.data)
		{
			if(node.left == null)
				return node;
			
			if(data < node.left.data)
			{
				node.left.left = splay(node.left.left, data);
				node = rightrotate(node);
			}
			
			else if(data > node.left.data)
			{
				node.left.right = splay(node.left.right, data);
				
				if(node.left.right != null)
					node.left = leftrotate(node.left);
			}
			return (node.left == null)?node : rightrotate(node);
		}
		else
		{
			if(node.right == null)
				return node;
			
			if(data > node.right.data)
			{
				node.right.right = splay(node.right.right, data);
				node = leftrotate(node);
			}
			
			else if(data < node.right.data)
			{
				node.right.left = splay(node.right.left, data);
				
				if(node.right.left != null)
					node.right = leftrotate(node.right);
			}
		}
		return (node.right == null)? node : leftrotate(node);
	}
	
	public Node search(Node node, int data)
	{
		if(node == null)
			return node;
		return splay(node, data);
	}
	
	public Node insert(Node node, int data)
	{
		if(node == null)
			return new Node(data);
		
		node = splay(node, data);
		
		if(data == node.data)
			return node;
		
		Node newnode = new Node(data);
		
		if(data < node.data)
		{
			newnode.right = node;
			newnode.left = node.left;
			node.left = null;			
		}
		
		else
		{
			newnode.left = node;
			newnode.right = node.right;
			node.right = null;			
		}
		return newnode;		
	}
	
	public Node delete(Node node, int data)
	{
		if(node == null)
			return node;
		
		node = splay(node, data);
		
		if(node.data != data)
			return node;
		else
		{
			Node left = node.left;
			Node right = node.right;
			
			if(left == null)
				return right;
			else
			{
				Node temp = maxsuccessor(left);
				left = splay(left, temp.data);
				left.right = right;
				return left;
			}
		}		
			
	}
}
