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
			node.left = insert(node.left, data);
		else
			node.right = insert(node.right, data);
		
		return node;
	}
	
	public void inorder(Node node,int k1,int k2)
	{
		if(node == null)
			return;
		
		inorder(node.left, k1, k2);
		if(node.data >= k1 && node.data <= k2)
			System.out.println("Data:" + node.data);
		inorder(node.right, k1, k2);
	}
}