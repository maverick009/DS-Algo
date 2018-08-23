package graph;

import java.util.Arrays;

public class Graph
{
	public class Edge implements Comparable<Edge>
	{
		public int src, dest, weight;
		public int compareTo(Edge e)
		{
			return this.weight - e.weight;
		}
	}
	public class Subset
	{
		int parent, rank;
	}
	
	public int V, E;
	public Edge []edges;
	public Graph(int V, int E)
	{
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		for(int i = 0;i < edges.length;i++)
			edges[i] = new Edge();
	}
	
	public int find(Subset []subsets, int i)
	{
		if(subsets[i].parent != i)
			return subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;			
	}
	
	public void union(Subset[] subsets, int x, int y)
	{
		int a = find(subsets, x);
		int b = find(subsets, y);
		
		if(subsets[a].rank < subsets[b].rank)
			subsets[a].parent = b;
		else if(subsets[a].rank > subsets[b].rank)
			subsets[b].parent = a;
		else
		{
			subsets[a].parent = b;
			subsets[b].rank++;
		}
	}	
	
	public void kruskal()
	{
		Arrays.sort(edges, (x, y) -> x.weight - y.weight);
		Edge []result = new Edge[this.V - 1];
		for(int i = 0;i < result.length;i++)
			result[i] = new Edge();
		
		Subset []subsets = new Subset[this.V];
		for(int i = 0;i < subsets.length;i++)
			subsets[i] = new Subset();
		
		for(int i = 0;i < this.V;i++)
		{
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		
		int e = 0, i = 0;
		while(e < this.V - 1)
		{
			Edge next_edge = new Edge();
			next_edge = edges[i++];
			
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
			
			if(x != y)
			{
				result[e++] = next_edge;
				union(subsets, x, y);
			}
		}
		System.out.println("Constructed Kruskal MST");
		for(i = 0;i < result.length;i++)
			System.out.println("Source:" + result[i].src + "\tDestiantion:" + result[i].dest
					+ "\tWeight:" + result[i].weight);
	}
}