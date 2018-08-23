package kdtree;

import kdtree.KDTree.Node;

public class KDTree 
{
	public static final int k = 2;
	public class Node
	{
		int points[];
		Node left, right;
		
		public Node(int p[])
		{
			points = new int[k];
			for(int i = 0;i < k;i++)
				this.points[i] = p[i];
			left = right = null;
		}
	}
	
	public Node root;
	
	public Node insert(Node node, int []points)
	{
		return insertutil(node, points, 0);
	}
	
	public Node insertutil(Node node, int []points, int depth)
	{
		if(node == null)
			return new Node(points);
		
		int cd = depth % k;
		if(points[cd] < node.points[cd])
			node.left = insertutil(node.left, points, depth + 1);
		else
			node.right = insertutil(node.right, points, depth + 1);
		return node;
	}
	
	public boolean areSame(int []p1, int []p2)
	{
		for(int i = 0;i < k;i++)
			if(p1[i] != p2[i])
				return false;
		return true;
	}
	
	public boolean searchUtil(Node node, int []points, int depth)
	{
		if(node == null)
			return false;
		if(areSame(points, node.points))
			return true;
		int cd = depth % k;
		
		if(points[cd] < node.points[cd])
			return searchUtil(node.left, points, depth + 1);
		else return searchUtil(node.right, points, depth + 1);
	}
	
	public boolean search(Node node, int []points)
	{
		return searchUtil(node, points, 0);
	}
	
	public int findmin(int a, int b, int c)
	{
		if(a < b && a < c)
			return a;
		else if(b < a && b < c)
			return b;
		else
			return c;
	}
	
	public int minUtil(Node node, int d, int depth)
	{
		if(node == null)
			return Integer.MAX_VALUE;
		
		int cd = depth % k;
		if(cd == d)
		{
			if(node.left == null)
				return node.points[d];
			return minUtil(node.left, d, depth + 1);
		}		
		return findmin(node.points[d], minUtil(node.left, d, depth + 1), 
						minUtil(node.right, d, depth + 1));
	}
	
	public int min(Node node, int d)
	{
		return minUtil(node, d, 0);
	}
}