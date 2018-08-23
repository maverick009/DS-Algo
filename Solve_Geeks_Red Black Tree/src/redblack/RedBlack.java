package redblack;

public class RedBlack 
{
	public enum Color
	{
		RED, BLACK
	};
	
	public class Node
	{
		public int data;
		public int color;
		Node left, right, parent;
		
		public Node(int data)
		{
			this.data = data;
			this.color = 0;
			left = right = parent = null;
		}
	}
	
	public Node root;
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	
	
	public void leftrotate(Node root, Node node)
	{
		Node pt_right = node.right;
		node.right = pt_right.left;
		if(node.right != null)
			node.right.parent = node;
		
		pt_right.parent = node.parent;
		if(node.parent == null)
			root = pt_right;
		else if(node == node.parent.left)
			node.parent.left = pt_right;
		else
			node.parent.right = pt_right;
			
		pt_right.left = node;
		node.parent = pt_right;			
	}
	
	public void rightrotate(Node root, Node node)
	{
		Node pt_left = node.left;
		node.left = pt_left.right;
		if(node.left != null)
			node.left.parent = node;
		
		pt_left.parent = node.parent;
		if(node.parent == null)
			root = pt_left;
		else if(node.parent.left == node)
			node.parent.left = pt_left;
		else
			node.parent.right = pt_left;
		
		pt_left.right = node;
		node.parent = pt_left;
	}
	
	public void swapcolor(Node node1, Node node2)
	{
		int temp = node1.color;
		node1.color = node2.color;
		node2.color = temp;
	}
	
	public Node BSTInsert(Node root, Node node)
	{
		if(root == null)
			return node;
		
		if(node.data < root.data)
		{
			root.left = BSTInsert(root.left, node);
			root.left.parent = root;
		}
		else
		{
			root.right = BSTInsert(root.right, node);
			root.right.parent = root;
		}
		return root;
	}
	
	public Node insert(int data)
	{
		Node newnode = new Node(data);
		root = BSTInsert(root, newnode);
		fixViolation(root, newnode);
		return root;
	}
	
	public void fixViolation(Node root, Node node)
	{
		if(root == null)
			return;

		Node parent = null;
		Node grand_parent = null;
		while((node != null) && (node.color == 0) &&  (node.parent != null && node.parent.color == 0))
		{
			parent = node.parent;
			grand_parent = node.parent.parent;
			
			if(parent == grand_parent.left)
			{
				Node uncle = grand_parent.right;
				
				if(uncle != null && (uncle.color == 0))
				{
					grand_parent.color = 0;
					parent.color = 1;
					uncle.color = 1;
					node = grand_parent;
				}
				else
				{
					if(node == parent.right)
					{
						inorder(root);
						System.out.println("left");
						leftrotate(root, parent);
						inorder(root);
						System.out.println();
						node = parent;
						parent = node.parent;
					}
					inorder(root);
					System.out.println("right");
					rightrotate(root, grand_parent);
					inorder(root);
					System.out.println();
					swapcolor(parent, grand_parent);
					node = parent;				
				}
			}//End of parent == grand_parent.left
			else
			{
				Node uncle = grand_parent.left;
				if(uncle != null && (uncle.color == 0))
				{
					grand_parent.color = 0;
					parent.color = 1;
					uncle.color = 1;
					node = grand_parent;
				}
				else
				{
					if(node == parent.left)
					{
						inorder(root);
						System.out.println("right");
						rightrotate(root, parent);
						inorder(root);
						System.out.println();
						node = parent;
						parent = node.parent;
					}
					inorder(root);
					System.out.println("left");
					leftrotate(root, grand_parent);
					swapcolor(parent, grand_parent);
					inorder(root);
					System.out.println();
					node = parent;
				}
			}
		}//End of While
		root.color = 1;
	}//End of fixViolation
	
}
