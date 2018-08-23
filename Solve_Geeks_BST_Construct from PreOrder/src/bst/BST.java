package bst;

public class BST 
{
	public class Node
	{
		public int data;
		public Node left, right;
		
		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node root;
	
	public Node insert(Node root, int data)
	{
		Node newnode = new Node(data);
		if(root == null)
		{
			root = newnode;
			return root;
		}
		if(root.data < data)
			root.right = insert(root.right, data);
		else
			root.left = insert(root.left, data);
		
		return root;
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public void preorder(Node node)
	{
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	/*
	 * 0(n2) solution
	 */
	
	public Node inorderToBST(Node node, int []arr)
	{
		for(int i = 0;i < arr.length;i++)
			node = insert(node, arr[i]);
		preorder(node);
		System.out.println();
		inorder(node);
		return node;
	}
}