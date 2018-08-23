package bst;

public class BSTParent 
{
	public class Node
	{
		public int data;
		public Node left,right,parent;
		
		public Node(int data)
		{
			this.data = data;
			left = right = parent = null;
		}
	}
	
	public Node root;
	
	public Node insert(Node root,int data)
	{
		Node newnode = new Node(data);
		
		if(root == null)
			return newnode;
		
		
		if(root.data < data)
		{
			root.right = insert(root.right, data);
			root.right.parent = root;
		}
		else
		{
			root.left = insert(root.left,data);
			root.left.parent = root;
		}
		return root;
	}
	
	public void inorder(Node root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public int depth(Node root,Node node)
	{
		if(root == null)
			return -1;
		int d = -1;
		while(node != null)
		{
			++d;
			node = node.parent;
		}
		return d;
	}
	
	public Node lca(Node root,Node node1,Node node2)
	{
		if(root == null)
			return null;
		
		int d1 = depth(root, node1);
		int d2 = depth(root, node2);
		int diff = d1 - d2;
		if(diff < 0)
		{
			Node temp = node1;
			node1 = node2;
			node2 = temp;
			diff = -diff;
		}
		
		while(diff-- != 0)
			node1 = node1.parent;
		
		while(node1 != null && node2 != null)
		{
			if(node1 == node2)
				return node1;
			node1 = node1.parent;
			node2 = node2.parent;
		}
		return null;
	}
}
