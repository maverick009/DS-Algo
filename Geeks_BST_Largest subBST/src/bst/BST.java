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
	
	public class Info
	{
		public int size,max,min,subBSTSize;
		public Info(int size,int max,int min,int subSize)
		{
			this.size = size;
			this.max = max;
			this.min = min;
			this.subBSTSize = subSize;
		}
	}
	
	public Node head;
	public Info info;
	
	public Node insert(Node node, int data)
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
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.println("Data:" + node.data);
		inorder(node.right);
	}
	
	Node prev;
	public boolean isBST(Node node)
	{
		if(node != null)
		{
			if(!isBST(node.left))
				return false;
			
			if(prev != null && prev.data > node.data)
				return false;
			
			prev = node;
			return isBST(node.right);
		}
		return true;
	}
	
	public int size(Node node)
	{
		if(node == null)
			return 0;
		
		int l = size(node.left);
		int r = size(node.right);
		
		return (l+r+1);		
	}
	
	public int max(int a,int b)
	{
		return ((a >= b)?a:b);
	}
	
	/*public int largestBST(Node node)
	{
		if(node == null)
			return 0;
		
		if(isBST(node))
			return size(node);
		return ((largestBST(node.left) >= largestBST(node.right))?size(node.left):size(node.right));
	}*/
	
	public Info largestBST(Node node)
	{
		Info info = new Info(0,0,0,0); 
		
		if(node == null)
			return info;
		
		info = new Info(1, node.data, node.data, 1);
		
		if(node.left != null)
		{
			Info l = largestBST(node.left);
			
			if(l.max <= info.min)
			{
				info.size += l.size;
				info.min = l.min;
			}
			info.subBSTSize = max(info.subBSTSize, max(info.size, l.subBSTSize));
		}
		
		if(node.right != null)
		{
			Info r = largestBST(node.right);
			if(r.min >= info.max)
			{
				info.size += r.size;
				info.max = r.max;
			}
			info.subBSTSize = max(info.subBSTSize, max(info.size, r.subBSTSize));
		}
		return info;
	}
}
