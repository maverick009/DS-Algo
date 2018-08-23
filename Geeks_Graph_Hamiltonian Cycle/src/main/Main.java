package main;

class Graph
{
	int v;
	
	public void print(int []path)
	{
		for(int i = 0;i < this.v;i++)
			System.out.print(path[i] + " ");
		System.out.print(path[0] + "\n");
	}
	
	public boolean issafe(int [][]graph, int []path, int u, int v)
	{
		if(graph[path[u - 1]][v] == 0)
			return false;
		
		for(int i = 0;i < u;i++)
			if(path[i] == v)
				return false;
		return true;
	}
	
	public boolean util(int [][]graph, int []path, int pos)
	{
		if(pos == this.v)
		{
			if(graph[path[pos - 1]][path[0]] == 1)
				return true;
			else
				return false;
		}
		
		for(int v = 1;v < this.v;v++)
		{
			if(issafe(graph, path, pos, v))
			{
				path[pos] = v;
				if(util(graph, path, pos + 1))
					return true;
				
				path[pos] = -1;
			}
		}
		return false;
	}
	
	public void hamiltonian(int [][]graph)
	{
		this.v = graph.length;
		int []res = new int[this.v];
		for(int i = 0;i < res.length;i++)
			res[i] = -1;
		res[0] = 0;
		
		if(!util(graph, res, 1))
		{
			System.out.println("No Path");
			return;
		}
		print(res);		
	}
	
}

public class Main 
{
	public static void main(String[] args) 
	{
		int graph1[][] = {{0, 1, 0, 1, 0},
	            		  {1, 0, 1, 1, 1},
	            		  {0, 1, 0, 0, 1},
	            		  {1, 1, 0, 0, 1},
	            		  {0, 1, 1, 1, 0},
	        			 };
		Graph g = new Graph();
		g.hamiltonian(graph1);
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
        				  {1, 0, 1, 1, 1},
        				  {0, 1, 0, 0, 1},
        				  {1, 1, 0, 0, 0},
        				  {0, 1, 1, 0, 0},
        				 };
        g.hamiltonian(graph2);
	}
}
