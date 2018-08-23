package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Graph
{
	int V;
	LinkedList<Integer> []adj;
	public Graph(int V)
	{
		this.V = V;
		adj = new LinkedList[this.V];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addedge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}
	
	/*public void bfs(int vertex)
	{
		boolean []visited = new boolean[this.V];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
	
		while(!queue.isEmpty())
		{
			int temp = queue.poll();
			visited[temp] = true;
			System.out.print(temp + " ");
			Iterator<Integer> i = adj[temp].listIterator();
			while(i.hasNext())
			{
				int num = i.next();
				if(!visited[num])
				{
					visited[num] = true;
					queue.offer(num);
				}
			}
		}
	}
	
	public void dfsutil(boolean []visited, int vertex)
	{
		visited[vertex] = true;
		System.out.print(vertex + " ");
		Iterator<Integer> i = adj[vertex].listIterator();
		while(i.hasNext())
		{
			int num = i.next();
			if(!visited[num])
				dfsutil(visited, num);
		}
	}
	
	public void dfs(int vertex)
	{
		boolean []visited = new boolean[this.V];
		dfsutil(visited, vertex);			
	}*/
	
	public boolean istreeutil(boolean []visited, int vertex, int parent)
	{
		visited[vertex] = true;
		int num;
		Iterator<Integer> i = adj[vertex].listIterator();
		while(i.hasNext())
		{
			num = i.next();
			if(!visited[num])
			{
				if(istreeutil(visited, num, vertex))
					return true;
			}
			else if(num != parent)
				return true;
				
		}
		return false;
	}
	
	public boolean istree()
	{
		boolean []visited = new boolean[this.V];
		if(istreeutil(visited, 0, -1))
			return false;
		
		for(int i = 0;i < visited.length;i++)
			if(!visited[i])
				return false;
		return true;
	}
	/*Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
 
            // If an adjacent is not visited, then recur for
            // that adjacent
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited and not parent of 
            // current vertex, then there is a cycle.
            else if (i != parent)
               return true;
        }
        return false;
    }
	
	
	Boolean isTree()
    {
        // Mark all the vertices as not visited and not part
        // of recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // The call to isCyclicUtil serves multiple purposes
        // It returns true if graph reachable from vertex 0
        // is cyclcic. It also marks all vertices reachable
        // from 0.
        if (isCyclicUtil(0, visited, -1))
            return false;
 
        // If we find a vertex which is not reachable from 0
        // (not marked by isCyclicUtil(), then we return false
        for (int u = 0; u < V; u++)
            if (!visited[u])
                return false;
 
        return true;
    }*/
}

public class Main 
{
	public static void main(String[] args) 
	{
		Graph g1 = new Graph(5);
        g1.addedge(1, 0);
        g1.addedge(0, 2);
        g1.addedge(0, 3);
        g1.addedge(3, 4);
        if (g1.istree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
 
        Graph g2 = new Graph(5);
        g2.addedge(1, 0);
        g2.addedge(0, 2);
        g2.addedge(2, 1);
        g2.addedge(0, 3);
        g2.addedge(3, 4);
 
        if (g2.istree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
	}
}