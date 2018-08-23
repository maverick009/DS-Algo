package bst;

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
	
	public Node insert(Node node,int data)
	{
		Node newnode = new Node(data);
		if(node == null)
			return newnode;
		else if(data < node.data)
			node.left = insert(node.left,data);
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
		
		return ((l<=r)?r+1:l+1);
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
		System.out.println("height:" + h);
		for(int i =1;i<=h;i++)
			printLevel(node, i);
	}
	
	public Node search(Node node,int val)
	{
		if(node == null)
			return node;
		Node temp = node;
		if(temp.data == val)
			return temp;
		else if(val < temp.data)
			temp =  search(temp.left, val);
		else
			temp = search(temp.right, val);
		return temp;
	}
	
	public int minSucc(Node node)
	{
		if(node == null)
			return -1;
		while(node.left != null)
			node = node.left;
		
		return node.data;
	}
	
	public boolean maxVal(Node node,int val)
	{
		if(node == null)
			return false;
		while(node.right != null)
			node = node.right;
		
		return ((node.data == val)?true:false);
	}
	
	public int inorderSucessor(Node node,int val)
	{
		if(node == null || maxVal(node, val))
			return -1;
		
		Node temp = search(node, val);
		//System.out.println("temp.data:" + temp.data);
		Node succ = null;
		if(temp.right != null)
			return minSucc(temp.right);
		
		while(node != null)
		{			
			if(temp.data < node.data)
			{
				succ = node;
				node = node.left;
			}
			else
				node = node.right;
		}
		
		return succ.data;
	}
}
