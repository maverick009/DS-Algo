package graph;

public class Graph 
{
	public class Node
	{
		public int src,dest;
	}
	
	int vertices,edges;
	public Node[] edge;
	
	public Graph(int vertices,int edges) 
	{
		this.vertices = vertices;
		this.edges = edges;
		edge = new Node[edges];
		for(int i = 0;i < edges;i++)
		{
			edge[i] = new Node();
		}
	}	
	
	public int find(int []parent,int i)
	{
		if(parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}
	
	public void union(int []parent,int a,int b)
	{
		int x = find(parent,a);
		int y = find(parent,b);
		parent[x] = y;
	}
	
	public boolean isCycle(Graph graph)
	{
		int []parent = new int[graph.vertices];
		for(int i = 0;i < parent.length;i++)
			parent[i] = -1;
		
		for(int i = 0;i < graph.edges;i++)
		{
			int x = find(parent,graph.edge[i].src);
			int y = find(parent,graph.edge[i].dest);
			
			if(x == y)
				return true;
			
			union(parent,x,y);
		}
		return false;
	}
}