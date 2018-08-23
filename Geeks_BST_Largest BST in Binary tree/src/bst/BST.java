package bst;

public class BST 
{
	public class Node 
	{
		public int data;
		public Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	
	public Node root;
	
	public Node insert(Node node,int data)
	{
		Node newnode = new Node(data);
		if(node == null)
			node = newnode;
		else if(data < node.data)
			node.left = insert(node.left, data);
		else
			node.right = insert(node.right, data);
		return node;
	}
	
	public int height(Node node)
	{
		if(node == null)
			return 0;
		
		int l = height(node.left);
		int r = height(node.right);
		
		return ((l <= r)?r+1:l+1);
	}
	
	public void printLevel(Node node,int h)
	{
		if(node == null || h < 1)
			return;
		
		if(h == 1)
			System.out.println("Data:" + node.data);
		else
		{
			printLevel(node.left, h - 1);
			printLevel(node.right, h - 1);
		}
	}
	
	public void levelorder(Node node)
	{
		if(node == null)
			return;
		int h = height(node);
		for(int i = 1;i <= h; i++)
			printLevel(node, i);
	}
	
	boolean isBST = true;
	Node prev,curr;
	public void inorder(Node node)
	{
		if(node == null)
			return;
		curr = node;
		inorder(node.left);
		prev = curr;
		curr = node;
		if(prev.data > curr.data)
			isBST = false;
		inorder(node.right);
	}
		
	public boolean isBST(Node node)
	{
		/*Node prev = null;
		while(node != null)
		{
			if(!isBST(node.left))
				return false;
			
			if(prev != null && prev.data > node.data)
				return false;
			
			prev = node;
			return isBST(node.right);			
		}
		return true;*/
		inorder(node);
		return isBST;
	}
	
	public int size(Node node)
	{
		if(node == null)
			return 0;
		
		return size(node.left) + size(node.right) + 1;
	}
	
	public int max(int a, int b)
	{
		return ((a >= b)?a:b);
	}
	
	public int maxBST(Node node)
	{
		if(node == null)
			return 0;
		if(isBST(node))
			return size(node);
		else
			return max(size(node.left), size(node.right));
	}
}
