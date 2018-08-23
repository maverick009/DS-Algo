package kdtree;

public class KDTree 
{
	class Node
	{
		int []points;
		Node left, right;
		
		public Node(int []arr)
		{
			points = new int[arr.length];
			for(int i = 0; i < arr.length;i++)
				points[i] = arr[i];
			this.left = this.right = null;
		}
	}
	
	public Node root;
	private int dimension;
	
	public KDTree(int dimension)
	{
		this.dimension = dimension;
	}
	
	public void inorder(Node node)
	{
		if(node == null)
			return;
		inorder(node.left);
		for(int i = 0;i < this.dimension;i++)
			System.out.print(node.points[i] + " ");
		System.out.println();
		inorder(node.right);
	}
	
	public Node insertUtil(Node node, int []arr, int depth)
	{
		if(node == null)
			return new Node(arr);
		int cd = depth % this.dimension;
		if(arr[cd] < node.points[cd])
			node.left = insertUtil(node.left, arr, depth + 1);
		else
			node.right = insertUtil(node.right, arr, depth + 1);
		return node;
	}
	
	public Node insert(Node node, int []arr)
	{
		return insertUtil(node, arr, 0);
	}
	
	public boolean isSame(int []arr1, int []arr2)
	{
		for(int i = 0;i < this.dimension;i++)
			if(arr1[i] != arr2[i])
				return false;
		return true;		
	}
	
	public boolean searchUtil(Node node, int []arr, int depth)
	{
		if(node == null)
			return false;
		if(isSame(arr, node.points))
			return true;
		int cd = depth % this.dimension;
		if(arr[cd] < node.points[cd])
			return searchUtil(node.left, arr, depth + 1);
		return searchUtil(node.right, arr, depth + 1);
	}
	
	public boolean search(Node node, int []arr)
	{
		return searchUtil(node, arr, 0);
	}
	
	public int minUtil(Node node, int dimension, int depth)
	{
		if(node == null)
			return Integer.MAX_VALUE;
		int cd = depth % this.dimension;
		if(dimension == cd)
		{
			if(node.left == null)
				return node.points[dimension];
			return minUtil(node.left, dimension, depth + 1);			
		}
		return min(node.points[dimension], minUtil(node.left, dimension, depth + 1),
				minUtil(node.right, dimension, depth + 1));
	}
	
	public int min(int a, int b, int c)
	{
		if(a < b && a < c)
			return a;
		else if(b < a && b < c)
			return b;
		else return c;
	}
	
	public int getMin(Node node, int dimension)
	{
		return minUtil(node, dimension, 0);
	}
}
