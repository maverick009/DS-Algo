package main;

import java.util.LinkedList;
import java.util.Queue;

class Graph
{
	int v;
	boolean bfs(int [][]rgraph, int src, int dest, int []parent)
	{
		boolean []visited = new boolean[this.v];
		parent[src] = -1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			visited[u] = true;
			for(int v = 0;v < this.v;v++)
			{
				if(!visited[v] && rgraph[u][v] > 0)
				{
					parent[v] = u;
					q.offer(v);
				}
			}
		}
		return (visited[dest] == true);		
	}
	
	public void dfs(int [][]rgraph, int src, boolean []visited)
	{
		visited[src] = true;
		for(int i = 0;i < rgraph.length;i++)
			if(!visited[i] && rgraph[src][i] > 0)
				dfs(rgraph, i, visited);
	}
	
	void mincut(int [][]graph, int src, int dest)
	{
		this.v = graph.length;
		int u, v;
		int []parent = new int[this.v];
		
		int [][]rgraph = new int[this.v][this.v];
		for(u = 0;u < this.v;u++)
			for(v = 0;v < this.v;v++)
				rgraph[u][v] = graph[u][v];
		
		int max_flow = 0;
		while(bfs(rgraph, src, dest, parent))
		{
			int path_flow = Integer.MAX_VALUE;
			for(v = dest; v != src;v = parent[v])
			{
				u = parent[v];
				path_flow = Math.min(path_flow, rgraph[u][v]);
			}
			
			for(v = dest;v != src;v = parent[v])
			{
				u = parent[v];
				rgraph[u][v] -= path_flow;
				rgraph[v][u] += path_flow;
			}
			max_flow += path_flow;
		}
		boolean []visited = new boolean[this.v];
		dfs(rgraph, src, visited);
		
		for(u = 0;u < this.v;u++)
			for(v = 0;v < this.v;v++)
				if(!visited[v] && graph[u][v] > 0 && visited[u])
					System.out.println(u + "-" + v);
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		int graph[][] = { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
            };
		Graph g = new Graph();
		g.mincut(graph, 0, 5);
	}
}
