package btree;

public class BTree 
{
	public class Node
	{
		int []keys;
		int t;	//degree
		Node []child;
		int n;	//current no of keys
		boolean leaf;
		
		public Node(int t, boolean leaf)
		{
			this.t = t;
			this.leaf = leaf;
			this.keys = new int[2 * t - 1];
			this.child = new Node[2 * t];
			for(int i = 0;i < child.length;i++)
				child[i] = null;
			this.n = 0;
		}
	}
	
	public Node root;
	int t;
	
	public BTree(int t)
	{
		root = null;
		this.t = t;
	}
	
	public void traverse(Node node)
	{
		if(node == null)
			return;
		int i;
		for(i = 0;i < node.n;i++)
		{
			if(!node.leaf)
				traverse(node.child[i]);
			System.out.print(node.keys[i] + " ");
		}
		
		if(!node.leaf)
			traverse(node.child[i]);
	}
	
	public Node search(Node node, int k)
	{
		if(node == null)
			return null;
		int i = 0;
		while(i < node.n && k > node.keys[i])
			i++;
		
		if(node.keys[i] == k)
			return node;
		if(node.leaf)
			return null;
		return search(node.child[i], k);
	}
	
	public Node insertNotFull(Node node, int k)
	{
		if(node == null)
			return node;
		
		int i = node.n - 1;
		if(node.leaf)
		{
			while(i >= 0 && node.keys[i] > k)
			{
				node.keys[i + 1] = node.keys[i];
				i--;
			}
			node.keys[i + 1] = k;
			node.n++;
		}
		else
		{
			while(i >= 0 && node.keys[i] > k)
				i--;
			
			if(node.child[i+1] != null && node.child[i+1].n == this.t * 2 - 1)
			{
				splitChild(node, node.child[i +1], i + 1);
				if(node.keys[i + 1] < k)
					i++;
			}			
			insertNotFull(node.child[i + 1], k);
		}
		System.out.println("insert not full");
		traverse(node);
		return node;
	}
	
	public void splitChild(Node node, Node child, int i)
	{
		if(node == null || child == null)
			return;
		
		Node newnode = new Node(child.t, child.leaf);
		newnode.n = t - 1;
		for(int j = 0;j < t - 1;j++)
			newnode.keys[j] = child.keys[j + t];
		
		if(!child.leaf)
		{
			for(int j = 0;j < t;j++)
				newnode.child[j] = child.child[j + t];
		}
		
		child.n = t - 1;
		for(int j = node.n;j >= i + 1;j--)
			node.child[j + 1] = node.child[j];
		node.child[i + 1] = newnode;
		
		for(int j = node.n - 1;j >= i;j--)
			node.keys[j + 1] = node.keys[j];
		
		node.keys[i] = child.keys[t - 1];
		node.n++;
	}
	
	public Node insert(Node node, int k)
	{
		if(node == null)
		{
			Node newnode = new Node(k, true);
			newnode.keys[0] = k;
			newnode.n = 1;
			return newnode;
		}
		
		if(node.n == 2 * t - 1)
		{
			Node newnode = new Node(t, false);
			newnode.child[0] = node;
			splitChild(node, newnode, 0);
			
			int i = 0;
			if(newnode.keys[0] < k)
				i++;
			insertNotFull(newnode.child[i], k);
			node = newnode;
		}
		else
			insertNotFull(node, k);
		return node;
	}
}