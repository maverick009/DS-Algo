package main;

import java.util.LinkedList;
import java.util.Queue;

class Graph
{
	int v;
	boolean bfs(int [][]rgraph, int src, int sink, int []parent)
	{
		boolean []visited = new boolean[this.v];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		parent[src] = -1;
		
		while(!queue.isEmpty())
		{
			int u = queue.poll();
			visited[u] = true;
			
			for(int v = 0;v < this.v;v++)
			{
				if(!visited[v] && rgraph[u][v] > 0)
				{
					queue.offer(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}
		return (visited[sink] == true);
	}
	
	int ford_fulkerson(int [][]graph, int src, int sink)
	{
		this.v = graph.length;
		int [][]rgraph = new int[this.v][this.v];
		int u, v;
		for(u = 0;u < graph.length;u++)
			for(v = 0;v < graph.length;v++)
				rgraph[u][v] = graph[u][v];
		
		int []parent = new int[this.v];
		int max_flow = 0;
		
		while(bfs(rgraph, src, sink, parent))
		{
			int path_flow = Integer.MAX_VALUE;
			for(v = sink;v != src;v = parent[v])
			{
				u = parent[v];
				path_flow = Math.min(path_flow, rgraph[u][v]);
			}
			
			for(v = sink;v != src;v = parent[v])
			{
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
		int graph[][] = { {0, 16, 13, 0, 0, 0},
						  {0, 0, 10, 12, 0, 0},
						  {0, 4, 0, 0, 14, 0},
						  {0, 0, 9, 0, 0, 20},
						  {0, 0, 0, 7, 0, 4},
						  {0, 0, 0, 0, 0, 0}
          				};
		Graph g = new Graph();
		System.out.println("Max Flow 0-5:" + g.ford_fulkerson(graph, 0, 5));
	}
}
