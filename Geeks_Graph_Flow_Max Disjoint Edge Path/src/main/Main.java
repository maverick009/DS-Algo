package main;

import java.util.LinkedList;
import java.util.Queue;

class Graph
{
	int v;
	boolean bfs(int [][]rgraph, int src, int dest, int []parent)
	{
		boolean []visited = new boolean[this.v];
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		parent[src] = -1;
		
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
					visited[v] = true;
				}
			}
		}
		return (visited[dest] == true);
	}
	
	int maxedge(int [][]graph, int src, int dest)
	{
		this.v = graph.length;
		int []parent = new int[this.v];
		
		int u, v;
		int [][]rgraph = new int[this.v][this.v];
		for(u = 0;u < graph.length;u++)
			for(v = 0;v < graph.length;v++)
				rgraph[u][v] = graph[u][v];
		
		int max_flow = 0;
		while(bfs(rgraph, src, dest, parent))
		{
			int path_flow = Integer.MAX_VALUE;
			for(v = dest;v != src;v = parent[v]) 
			{
				System.out.print(v + "-");
				u = parent[v];
				path_flow = Math.min(path_flow, rgraph[u][v]);
			}
			System.out.println();
			for(v = dest;v != src;v = parent[v]) {
				u = parent[v];
				rgraph[u][v] -= path_flow;
				rgraph[v][u] += path_flow;
			}
			max_flow += path_flow;
		}
		return max_flow;
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		 int graph[][] = { {0, 1, 1, 1, 0, 0, 0, 0},
                 		   {0, 0, 1, 0, 0, 0, 0, 0},
                 		   {0, 0, 0, 1, 0, 0, 1, 0},
                 		   {0, 0, 0, 0, 0, 0, 1, 0},
                 		   {0, 0, 1, 0, 0, 0, 0, 1},
                 		   {0, 1, 0, 0, 0, 0, 0, 1},
                 		   {0, 0, 0, 0, 0, 1, 0, 1},
                 		   {0, 0, 0, 0, 0, 0, 0, 0}
               			};
		Graph g = new Graph();
		System.out.println("Max Disjoint Edge Path: " + g.maxedge(graph, 0, 7));
		
	}
}
