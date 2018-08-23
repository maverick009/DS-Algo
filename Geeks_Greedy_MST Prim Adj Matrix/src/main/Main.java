package main;

class Graph
{
	int V;
	
	public int minkey(int []key, boolean []mst)
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int i = 0;i < this.V;i++)
		{
			if(!mst[i] && key[i] < min)
			{
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	public void print(int [][]graph, int []parent)
	{
		System.out.println("Prim Minimum Spanning tree");
		for(int i = 1;i < this.V;i++)
			System.out.println(parent[i] + "-" + i + "\tWeight:" + graph[parent[i]][i]);
	}
	
	public void prim(int [][]graph)
	{
		this.V = graph.length;
		int []parent = new int[this.V];
		int []key = new int[this.V];
		boolean []mst = new boolean[this.V];
		for(int i = 0;i < this.V;i++)
			key[i] = Integer.MAX_VALUE;
		
		key[0] = 0;
		
		parent[0] = -1;
		for(int i = 0;i < this.V - 1;i++)
		{
			int u = minkey(key, mst);
			mst[u] = true;
			
			for(int v = 0;v < this.V;v++)
			{
				if(!mst[v] && graph[u][v] != 0 && graph[u][v] < key[v])
				{
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		print(graph, parent);
	}
}

public class Main
{	
	public static void main(String[] args) 
    {
		int graph[][] = new int[][] {{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}};
        Graph g = new Graph();
        g.prim(graph);	    
    }
}