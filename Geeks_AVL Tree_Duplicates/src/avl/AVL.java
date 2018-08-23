package avl;

public class AVL 
{
	class Node
	{
		int data,count,height;
		Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			this.count = 1;
			this.height = 1;			
			left = right = null;
		}		
	}
	
	public Node root;
	
	public void preorder(Node node)
	{
		if(node == null)
			return;
		for(int i = 0;i < node.count;i++)
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
	
	public int max(int a, int b)
	{
		return (a > b)?a : b;
	}
	
	public int height(Node node)
	{
		if(node == null)
			return 0;
		return max(height(node.left), height(node.right)) + 1;
	}
	
	public Node leftroatate(Node node)
	{
		if(node == null)
			return node;
		
		Node temp1 = node.right;
		Node temp2 = temp1.left;
		
		temp1.left = node;
		node.right = temp2;
		
		node.height = 1 + max(height(node.left), height(node.right));
		temp1.height = 1 + max(height(temp1.left), height(temp1.right));
		
		return temp1;
	}
	
	public Node rightrotate(Node node)
	{
		if(node == null)
			return node;
		
		Node temp1 = node.left;
		Node temp2 = temp1.right;
		
		temp1.right = node;
		node.left = temp2;
		
		node.height = 1 + max(height(node.left), height(node.right));
		temp1.height = 1 + max(height(temp1.left), height(temp1.right));
		
		return temp1;
	}
	
	public int balance(Node node)
	{
		return height(node.left) - height(node.right);
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
		
		node.height = 1 + max(height(node.left), height(node.right));
		int balancefactor = balance(node);
		
		if(balancefactor > 1 && data < node.left.data)
			return rightrotate(node);
		
		if(balancefactor > 1 && data > node.left.data)
		{
			node.left = leftroatate(node.left);
			return rightrotate(node);
		}
		
		if(balancefactor < -1 && data > node.right.data)
			return leftroatate(node);
		
		if(balancefactor < - 1 && data < node.right.data)
		{
			node.right = rightrotate(node.right);
			return leftroatate(node);
		}
		return node;
	}
	
	public Node delete(Node node, int data)
	{
		if(node == null)
			return null;
		
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
			if(node.left == null || node.right == null)
			{
				Node temp = (node.left != null) ? node.left : node.right;
				if(temp == null)
				{
					temp = node;
					node = null;
				}
				else
					node = temp;
				temp = null;
			}
			else
			{
				Node temp = minsuccessor(node.right);
				node.data = temp.data;
				node.count = temp.count;
				temp.count = 1;
				node.right = delete(node.right, temp.data);
			}
		}
		
		if(node == null)
			return node;
		
		node.height = 1 + max(height(node.left), height(node.right));
		int balance = balance(node);
		
		if(balance > 1 && balance(node.left) >= 0)
			return rightrotate(node);
		
		if(balance > 1 && balance(node.left) < 0)
		{
			node.left = leftroatate(node.left);
			return rightrotate(node);
		}
		
		if(balance < - 1 && balance(node.right) <= 0)
			return leftroatate(node);
		
		if(balance < -1 && balance(node.right) > 0)
		{
			node.right = rightrotate(node.right);
			return leftroatate(node);
		}
		return node;
	}
}