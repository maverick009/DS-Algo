package main;

class Graph
{
	public void dfsutil(int [][]graph, boolean []visited, int vertex)
	{
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for(int i = 0;i < graph.length;i++)
		{
			if(!visited[i] && graph[vertex][i] != 0)
				dfsutil(graph, visited, i);
		}
	}
	
	public void dfs(int [][]graph)
	{
		boolean []visited = new boolean[graph.length];
		for(int i = 0;i < graph.length;i++)
			if(!visited[i])
			{
				dfsutil(graph, visited, i);
				System.out.println();
			}
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		int [][]graph = { {0, 1, 0, 0, 0},
						  {1, 0, 0, 0, 0},
						  {0, 0, 0, 1, 0},
						  {0, 0, 1, 0, 1},
						  {0, 0, 0, 1, 0}
						};
		Graph g = new Graph();
		g.dfs(graph);
	}
}