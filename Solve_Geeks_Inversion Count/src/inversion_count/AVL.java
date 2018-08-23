package inversion_count;

public class AVL 
{
	class Node
	{
		int data, height, size;
		Node left, right;
		
		public Node(int data)
		{
			this.data = data;
			this.height = 1;
			left = right = null;
			this.size = 1;
		}
	}
	
	public Node root;
	public int count = 0;
	
	public int getBalance(Node node)
	{
		if(node == null)
			return 0;
		return getHeight(node.left) - getHeight(node.right); 
	}
	
	public int max(int a, int b)
	{
		return (a >= b)? a : b;
	}
	
	public int getHeight(Node node)
	{
		if(node == null)
			return 0;
		return node.height;
	}
	
	public int getSize(Node node)
	{
		if(node == null)
			return 0;
		return node.size;
	}
	
	public Node leftrotate(Node node)
	{
		if(node == null)
			return node;
		
		Node temp = node.right;
		Node gchild = null;
		gchild = temp.left;
		
		temp.left = node;
		node.right = gchild;
		
		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		temp.height = max(getHeight(temp.left), getHeight(temp.right)) + 1;
		
		node.size = getSize(node.left) + getSize(node.right) + 1;
		temp.size = getSize(temp.left) + getSize(temp.right) + 1;
		
		return temp;
	}
	
	public Node rightrotate(Node node)
	{
		if(node == null)
			return node;
		
		Node temp = node.left;
		Node gchild = null;
		if(temp != null)
			gchild = temp.right;
		
		temp.right = node;
		node.left = gchild;
		
		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		temp.height = max(getHeight(temp.left), getHeight(temp.right)) + 1;
		
		node.size = getSize(node.left) + getSize(node.right) + 1;
		temp.size = getSize(temp.left) + getSize(temp.right) + 1;
		
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
	
	public Node minNode(Node node)
	{
		if(node == null)
			return node;
		
		while(node.left != null)
			node = node.left;
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
	
	public int getInversion(int []arr)
	{
		Node node = null;
		for(int i = 0;i < arr.length;i++)
			node = insert(node, arr[i], this.count);
		
		return this.count;
	}
	
	public Node insert(Node node, int data, int count)
	{
		Node newnode = new Node(data);
		
		if(node == null)
			return newnode;
		
		if(data < node.data)
		{
			this.count += Math.abs(getSize(node.right)) + 1;
			node.left = insert(node.left, data, this.count);
		}
		else if(data > node.data)
			node.right = insert(node.right, data, this.count);
		else
			return node;
		
		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		node.size = getSize(node.left) + getSize(node.right) + 1; 
		
		int bal = getBalance(node);
		
		if(bal > 1 && data < node.left.data)
			return rightrotate(node);
		
		if(bal < -1 && data > node.right.data)
			return leftrotate(node);
		
		if(bal > 1 && data > node.left.data)
		{
			node.left = leftrotate(node.left);
			return rightrotate(node);
		}
		if(bal < -1 && data < node.right.data)
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
					node = node.right;
				else
					node = node.left;
				
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
				Node temp = minNode(node.right);
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}			
		}
		
		if(node == null)
			return node;
		
		node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
		
		int bal = getBalance(node);
		
		if(bal < -1 && getBalance(node.right) <= 0)
			return leftrotate(node);
		
		if(bal > 1 && getBalance(node.left) >= 0)
			return rightrotate(node);
		
		if(bal < -1 && getBalance(node.right) > 0)
		{
			node.right = rightrotate(node.right);
			return leftrotate(node);
		}
		
		if(bal > 1 && getBalance(node.left) < 0)
		{
			node.left = leftrotate(node.left);
			return rightrotate(node);
		}
		return node;
	}
	
	
}
