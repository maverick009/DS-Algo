package main;

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
	
	public void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
	
	public boolean reachutil(boolean []visited, int src, int dest)
	{
		visited[src] = true;
		Iterator<Integer> itr = adj[src].listIterator();
		while(itr.hasNext())
		{
			int node = itr.next();
			if(!visited[node])
				reachutil(visited, node, dest);
		}
		if(visited[dest])
			return true;			
		return false;
	}
	
	public boolean isReachable(int src, int dest)
	{
		boolean []visited = new boolean[this.v];
		return reachutil(visited, src, dest);
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
 
        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
	}
}