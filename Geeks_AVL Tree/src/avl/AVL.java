package avl;

public class AVL 
{
	class Node
	{
		int data, height;
		Node left, right;
		
		public Node(int data)
		{
			this.data = data;
			this.height = 1;
		}
	}
	
	public Node root;
	
	public int max(int a, int b)
	{
		return (a > b)?a : b; 
	}
	
	public int height(Node node)
	{
		if(node == null)
			return 0;
		
		return node.height;
	}
	
	public int getBalanced(Node node)
	{
		if(node == null)
			return 0;		
		return height(node.left) - height(node.right);
	}
	
	public Node leftrotate(Node node)
	{
		if(node == null)
			return null;
		
		Node temp1 = node.right;
		Node temp2 = temp1.left;
		
		temp1.left = node;
		node.right = temp2;
		
		/*
		 * We don't use node.left.height or node.right.height
		 * because in these node.left or node.right might be null.
		 * In that case, it will throw exception.Thus it is safe to use height()
		 */
		node.height = 1 + max(height(node.left), height(node.right));
		temp1.height = 1 + max(height(temp1.left), height(temp1.right));		
		
		return temp1;
	}
	
	public Node rightrotate(Node node)
	{
		if(node == null)
			return null;
		
		Node temp1 = node.left;
		Node temp2 = temp1.right;
		
		temp1.right = node;
		node.left = temp2;
		
		node.height = 1 + max(height(node.left), height(node.right));
		temp1.height = 1 + max(height(temp1.left), height(temp1.right));
		return temp1;
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
			return node;
		
		node.height = 1 + max(height(node.left), height(node.right));
		int balancefactor = getBalanced(node);
		
		if(balancefactor > 1 && data < node.left.data)		
			return rightrotate(node);		
		
		if(balancefactor > 1 && data > node.left.data)
		{
			node.left = leftrotate(node.left);
			return rightrotate(node);
		}
		
		if(balancefactor < -1 && data > node.right.data)		
			return leftrotate(node);
		
		if(balancefactor < - 1 && data < node.right.data)
		{
			node.right = rightrotate(node.right);
			return leftrotate(node);
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
			if(node.left == null || node.right == null)
			{
				Node temp = null;
				if(temp == node.left)
					temp = node.right;
				else
					temp = node.left;
				
				if(temp == null)
				{
					temp = node;
					node = null;
				}
				else
					node = temp;				
			}
			else
			{
				Node temp = minValNode(node.right);
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}
		}
		
		if(node == null)
			return node;
		
		node.height = 1 + max(height(node.left), height(node.right));
		int balance = getBalanced(node);
		
		if(balance  > 1 && getBalanced(node.left) >= 0)
			return rightrotate(node);
		
		if(balance > 1 && getBalanced(node.left) < 0)
		{
			node.left = leftrotate(node.left);
			return rightrotate(node);			
		}
		
		if(balance < -1 && getBalanced(node.right) <= 0)
			return leftrotate(node);		
		
		if(balance < -1 && getBalanced(node.right) > 0)
		{
			node.right = rightrotate(node.right);
			return leftrotate(node);
		}
		return node;
	}
	
	public Node minValNode(Node node)
	{
		if(node == null)
			return node;
		
		Node temp = node;
		while(temp != null)
			temp = temp.left;
		return temp;
	}
	
	public void preorder(Node node)
	{
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
}