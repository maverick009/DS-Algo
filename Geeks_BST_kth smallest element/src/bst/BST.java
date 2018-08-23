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
			node = newnode;
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
		//System.out.println("height:" + h);
		for(int i = 1;i<= h;i++)
			printLevel(node, i);	
	}
	
	int []arr = new int[10];
	int i = 1;
	int kth;
	
	Node curr;
	public void inorder(Node node, int k)
	{
		if(node == null)
			return;
		
		inorder(node.left,k);
		/*arr[i] = node.data;
		i++;*/
		if(i <= k)
		{
			/*System.out.println("inside if");
			System.out.println("node.data:" + node.data);*/
			curr = node;
			i++;
		}
		inorder(node.right,k);
		kth = curr.data;
	}
	
	public int count(Node node)
	{
		if(node == null)
			return 0;
		
		int l = count(node.left);
		int r = count(node.right);
		return l+r+1;
	}	
	
	public int ksmallest(Node node,int k)
	{
		if(node == null)
			return -1;
		
		inorder(node,k);
		
		/*for(int i = 0;i<count(node);i++)
			System.out.println("array Data:"+arr[i]);*/
		
		//return arr[k-1];
		return kth;
	}
}
