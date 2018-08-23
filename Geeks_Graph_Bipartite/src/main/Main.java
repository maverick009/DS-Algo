package main;
import java.util.LinkedList;
import java.util.Queue;

class Graph
{
	int v;	
	boolean bipartiteutil(int [][]graph, int src, int []color)
	{
		color[src] = 1;		
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		while(!q.isEmpty())
		{
			int u = q.poll();
			if(graph[u][u] == 1)
				return false;
			for(int v = 0;v < this.v;v++)
			{
				if(graph[u][v] == 1 && color[v] == -1)
				{
					color[v] = 1 - color[u];
					q.offer(v);
				}
				else if(graph[u][v] == 1 && color[u] == color[v])
					return false;
			}
		}
		return true;
	}
	
	boolean bipartite(int [][]graph)
	{
		this.v = graph.length;
		int []color = new int[this.v];
		for(int i = 0;i < color.length;i++)
			color[i] = -1;
		
		for(int i = 0;i < this.v;i++)
			if(color[i] == -1)
				if(!bipartiteutil(graph, i, color))
					return false;
		return true;
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		int G[][] = {{0, 1, 0, 1},
                	 {1, 0, 1, 0},
                	 {0, 1, 0, 1},
                	 {1, 0, 1, 0}};
		Graph g = new Graph();
		System.out.println("Bipartite:" + g.bipartite(G));
	}
}