package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class Graph
{
	int v;
	LinkedList<Integer> []adj;
	
	public Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[this.v];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int src, int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
	
	public void color()
	{
		int []result = new int[this.v];
		Arrays.fill(result, -1);
		result[0] = 0;
		
		boolean []available = new boolean[this.v];
		Arrays.fill(available, true);
		
		for(int u = 1;u < this.v;u++)
		{
			Iterator<Integer> itr = adj[u].listIterator();
			while(itr.hasNext())
			{
				int temp = itr.next();
				if(result[temp] != -1)
					available[result[temp]] = false;
			}
			
			int cr;
			for(cr = 0;cr < this.v;cr++)
			{
				if(available[cr])
					break;
			}
			
			result[u] = cr;
			Arrays.fill(available, true);
		}
		for(int u = 0;u < this.v;u++)
		{
			System.out.print("Vertex:" + u + "\tColor:" + result[u]);
			System.out.println();
		}
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.color();
 
        System.out.println();
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2 ");
        g2.color();
	}
}