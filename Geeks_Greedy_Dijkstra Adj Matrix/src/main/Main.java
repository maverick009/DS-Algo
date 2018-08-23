package main;

class Graph
{
	int V;
	public int min(int []dist, boolean []spt)
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int i = 0;i < this.V;i++)
		{
			if(!spt[i] && dist[i] < min)
			{
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;				
	}
	
	public void printPath(int []parent, int i)
	{
		if(parent[i] == -1)
			return;
		printPath(parent, parent[i]);
		System.out.print(i + " ");
	}
	
	public void print(int []dist, int []parent, int src)
	{
		System.out.println("Vertex" + "\tDistance from Source" + "\tPath");
		for(int i = 0;i < this.V;i++)
		{
			System.out.print(src + "-" + i + "\t\t" + dist[i] + "\t\t" + src + " ");
			printPath(parent, i);
			System.out.println();
		}
	}
	
	public void djikstra(int [][]graph, int src)
	{
		this.V = graph.length;
		int []dist = new int[this.V];
		int []parent = new int[this.V];
		boolean []spt = new boolean[this.V];
		for(int i = 0;i < this.V;i++)
		{
			parent[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		
		for(int i = 0;i < this.V;i++)
		{
			int u = min(dist, spt);
			spt[u] = true;
			
			for(int v = 0;v < this.V;v++)
			{
				if(!spt[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v])
				{
					parent[v] = u;
					dist[v] = graph[u][v] + dist[u];
				}
			}
		}
		print(dist, parent, src);
	}
}

public class Main
{	
	public static void main(String[] args) 
    {
		int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
						 {4, 0, 8, 0, 0, 0, 0, 11, 0},
					 	 {0, 8, 0, 7, 0, 4, 0, 0, 2},
					 	 {0, 0, 7, 0, 9, 14, 0, 0, 0},
					 	 {0, 0, 0, 9, 0, 10, 0, 0, 0},
					 	 {0, 0, 4, 14, 10, 0, 2, 0, 0},
					 	 {0, 0, 0, 0, 0, 2, 0, 1, 6},
					 	 {8, 11, 0, 0, 0, 0, 1, 0, 7},
					 	 {0, 0, 2, 0, 0, 0, 6, 7, 0}
           				};
		Graph g = new Graph();
		g.djikstra(graph, 0);		
    }
}