package timepass;

public class TimePass 
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
	
	class DLL
	{
		int data;
		DLL prev,next;
		
		public DLL(int data)
		{
			this.data = data;
			prev = next = null;
		}
	}
	
	public Node root;
	public DLL head,tail;
	
	public Node insert(Node node,int data)
	{
		Node newnode = new Node(data);
		
		if(node == null)
		{
			node = newnode;
			return node;
		}
		
		if(newnode.data < node.data)
			node.left = insert(node.left, data);
		else
			node.right = insert(node.right, data);
		
		return node;
	}
	
	public void inorder(Node root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public int height(Node root)
	{
		if(root == null)
			return 0;
		
		int l = height(root.left);
		int r = height(root.right);
		
		return (l >= r?l+1:r+1);
	}
	
	public void print(Node root,int height)
	{
		if(root == null || height < 1)
			return;
		
		if(height == 1)
			System.out.print(root.data + " ");
		print(root.left, height - 1);
		print(root.right, height - 1);
	}
	
	public void levelorder(Node root)
	{
		if(root == null)
			return;
		int h = height(root);
		int i;
		for(i = 1;i <= h;i++)
			print(root, i);
		System.out.println();
	}
	
	public Node smallest(Node root)
	{
		if(root == null)
			return null;
		if(root.left != null)
			return smallest(root.left);	
		return root;
	}
	
	public DLL convertBSTDLL(Node root)
	{
		if(root == null)
			return null;
		
		convertBSTDLL(root.left);
		DLL newnode = new DLL(root.data);
		if(tail == null)
			head = tail = newnode;
		else
		{
			tail.next = newnode;
			newnode.prev = tail;
			tail = newnode;
		}
		convertBSTDLL(root.right);
		return head;
	}
	
	public void display(DLL head)
	{
		if(head == null)
			return;
		while(head != null)
		{
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}
