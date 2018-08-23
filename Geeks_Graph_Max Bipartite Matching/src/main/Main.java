package main;

class Graph
{
	int app,jobs;
	boolean bpm(boolean [][]graph, int u, boolean []visited, int []match)
	{
		for(int v = 0;v < this.jobs;v++)
		{
			if(!graph[u][v] && !visited[v])
			{
				visited[v] = true;
				if(match[v] < 0 || bpm(graph, match[v], visited, match))
				{
					match[v] = u;
					return true;
				}
			}
		}
		return false;
	}
	
	int maxbpm(boolean [][]graph)
	{
		this.app = graph.length;
		this.jobs = graph.length;
		
		int match[] = new int[this.jobs];
		for(int i = 0;i < this.jobs;i++)
			match[i] = -1;
		
		int res = 0;
		for(int u = 0;u < this.app;u++)
		{
			boolean []visited = new boolean[this.jobs];
			if(bpm(graph, u, visited, match))
				res++;
		}
		return res;
	}
}

public class Main 
{	
	public static void main(String[] args) 
	{
		boolean bpGraph[][] = new boolean[][]{
            {false, true, true, false, false, false},
            {true, false, false, true, false, false},
            {false, false, true, false, false, false},
            {false, false, true, true, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, true}
        };
        Graph g = new Graph();
        System.out.println("Max Match:" + g.maxbpm(bpGraph));
	}
}