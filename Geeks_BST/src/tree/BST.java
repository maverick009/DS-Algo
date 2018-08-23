package tree;

public class BST 
{
	class Node
	{
		int data;
		Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	
	public Node root;
	
	public Node insert(Node node, int data)
	{
		Node newnode = new Node(data);
		if(node == null)
			return newnode;
		
		if(data < node.data)
			node.left = insert(node.left,data);
		else
			node.right = insert(node.right,data);
		
		return node;
	}	
	
	public void preorder(Node node)
	{
		if(node == null)
			return;

		System.out.println("Data:" + node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder(Node node)
	{
		if(node == null)
			return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.println("Data:" + node.data);
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.println("Data:" + node.data);
		inorder(node.right);
	}
	
	public int height(Node node)
	{
		if(node == null)
			return 0;
		
		int l = height(node.left);
		int r = height(node.right);
		
		return ((l <= r)?r+1:l+1);
	}
	
	public void printNode(Node node,int h)
	{
		if(node == null || h < 1)
			return;
		if(h == 1)
			System.out.println("Data:" + node.data);
		else
		{
			printNode(node.left, h - 1);
			printNode(node.right, h - 1);
		}		
	}
	
	public void levelorder(Node node)
	{
		if(node == null)
			return;
		int h = height(node);
		//System.out.println("height:" + h);
		for(int i =1;i <= h;i++)
			printNode(node, i);
	}
	
	public boolean search(Node node,int val)
	{
		if(node == null)
			return false;
		
		if(val == node.data)
			return true;
		
		else if(val < node.data)
			search(node.left, val);
		else
			search(node.right,val);		
		
		return false;
	}
	
	public int minSuccessor(Node node)
	{
		if(node == null)
			return -1;
		
		Node temp = node.right;
		while(temp != null && temp.left != null)
			temp = temp.left;
	
		return temp.data;
	}
	
	public int maxPredecessor(Node node)
	{
		if(node == null)
			return -1;
		Node temp = node.left;
		while(temp != null && temp.right != null)
			temp = temp.right;
		
		return temp.data;
	}
	
	public Node delete(Node node,int val)
	{
		if(node == null && search(node, val) == false)
			return node;
		
		if(val < node.data)
			node.left = delete(node.left, val);
		else if(val > node.data)
			node.right = delete(node.right, val);
		else
		{
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			
			node.data = minSuccessor(node);
			node.right = delete(node.right, node.data);
		}
		return node;
	}
	
	Node prev = null;
	
	public boolean isBST(Node node)
	{		
		if(node != null)
		{
			if(!isBST(node.left))
				return false;
			
			if(prev != null && node.data <= prev.data)
				return false;
			
			prev = node;
			return isBST(node.right);
		}
		return true;
	}
	
}
