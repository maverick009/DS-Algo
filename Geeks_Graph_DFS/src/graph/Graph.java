package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph 
{
	private int vertices;
	private LinkedList<Integer> []adj;
	
	public Graph(int vertices)
	{
		this.vertices = vertices;
		adj = new LinkedList[vertices];
		for(int i = 0;i < vertices;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int vertex,int edge)
	{
		adj[vertex].add(edge);
	}
	
	public void display()
	{
		for(int i = 0;i < vertices;i++)
		{
			System.out.print(i + ":");
			LinkedList<Integer> temp = adj[i];
			for(int j = 0; ;j++)
			{
				if(j != temp.size()-1)
					System.out.print(temp.get(j) + "->");
				else
				{
					System.out.print(temp.get(j));
					break;
				}
			}
			System.out.println();
		}
	
	}
	
	public void BFS(int vertex)
	{
		boolean []visited = new boolean[vertices];
		visited[vertex] = true;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		
		while(queue.size() != 0)
		{
			vertex = queue.poll();
			System.out.print(vertex + " ");
			Iterator<Integer> i = adj[vertex].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public void DFSUtil(int vertex,boolean []visited)
	{	
		visited[vertex] = true;
		System.out.print(vertex + " ");
		Iterator<Integer> i = adj[vertex].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
				DFSUtil(n,visited);
		}		
	}
	
	public void DFS(int vertex)
	{
		boolean []visited = new boolean[vertices];
		DFSUtil(vertex,visited);	
	}
}
