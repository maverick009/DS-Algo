package graph;

public class Graph 
{
	public class Edge
	{
		public int src,dest;
	}
	public class subset
	{
		public int parent,rank;
	}
	
	public int vertices,edges;
	public Edge[] arr;
	
	public Graph(int vertices,int edges)
	{
		this.vertices = vertices;
		this.edges = edges;
		arr = new Edge[edges];
		for(int i = 0;i < edges;i++)
			arr[i] = new Edge();
	}
	
	public int find(subset []subsets,int i)
	{
		if(subsets[i].parent != i)
			subsets[i].parent = find(subsets,subsets[i].parent);
		return subsets[i].parent;
	}
	
	public void union(subset []subsets,int x,int y)
	{
		int a = find(subsets,x);
		int b = find(subsets,y);
		
		if(subsets[a].rank < subsets[b].rank)
			subsets[a].parent = b;
		else if(subsets[b].rank < subsets[a].rank)
			subsets[b].parent = a;
		else
		{
			subsets[b].parent = a;
			subsets[a].rank++;
		}
	}
	
	public boolean isCycle(Graph graph)
	{
		subset []subsets = new subset[graph.vertices];
		for(int i = 0;i < graph.vertices;i++)
			subsets[i] = new subset();
		for(int i = 0;i < graph.vertices;i++)
		{
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		
		for(int i = 0;i < graph.vertices;i++)
		{
			int x = find(subsets,graph.arr[i].src);
			int y = find(subsets,graph.arr[i].dest);
			
			System.out.println("X:" + x + "Y:" + y) ;
			
			if(x == y)
				return true;
			
			union(subsets,x,y);
		}
		return false;
	}
}
