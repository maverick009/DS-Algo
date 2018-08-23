package main;

class Graph
{
	int V, E;
	class Edge
	{
		int src, dest, weight;
	}
	
	public Edge []edge;
	public Graph(int V, int E)
	{
		this.V = V;
		this.E = E;
		edge = new Edge[E];
		for(int i = 0;i < E;i++)
			edge[i] = new Edge();
	}
	
	public void print(int []dist, int src)
	{
		System.out.println("src-dest" + "\tDistance");
		for(int i = 0;i < this.V;i++)
			System.out.println(src + "-" + i + "\t\t" + dist[i]);
	}
	
	public void bellman_ford(int src)
	{
        int []dist = new int[this.V];
        for(int i = 0;i < dist.length;i++)
        	dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        
        for(int i = 1;i < this.V;i++)
        {
        	for(int j = 0;j < this.E;j++)
        	{
        		int u = edge[j].src;
        		int v = edge[j].dest;
        		int weight = edge[j].weight;
        		if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
        			dist[v] = dist[u] + weight;
        	}
        }
        
        for(int j = 0;j < this.E;j++)
        {
        	int u = edge[j].src;
        	int v = edge[j].dest;
        	int weight = edge[j].weight;
        	if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
        	{
        		System.out.println("Negative Weight Cycle");
        		break;
        	}
        }
        print(dist, src);
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		int V = 5, E = 8;
		Graph graph = new Graph(V, E);
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;
		
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;
		
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;
		
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;
		
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;
		
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;
		
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;
		
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;
		
		graph.bellman_ford(0);
	}
}