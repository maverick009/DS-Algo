package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

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
	
	public void addEdge(int source,int destination)
	{
		adj[source].add(destination);
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
		System.out.print(vertex + " ");
		visited[vertex] = true;
		Iterator<Integer> i = adj[vertex].iterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	public void DFS(int vertex)
	{
		boolean []visited = new boolean[vertices];
		for(int i = 0;i < vertices;i++)
			visited[i] = false;
		
		DFSUtil(vertex, visited);
	}
	
	public void fullDFS()
	{
		boolean []visited = new boolean[vertices];
		for(int i = 0;i < vertices;i++)
			visited[i] = false;
		
		for(int i = 0;i < vertices;i++)
		{
			if(!visited[i])
				DFSUtil(i, visited);
		}
	}
	
	public void toposortUtil(int vertex, Stack<Integer> stack,boolean []visited)
	{
		visited[vertex] = true;
		Iterator<Integer> i = adj[vertex].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
				toposortUtil(n, stack, visited);
		}		
		stack.push(vertex);
	}
	
	public void topologicalSort()
	{
		boolean []visited = new boolean[vertices];
		for(int i = 0;i < vertices;i++)
			visited[i] = false;
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0;i < vertices;i++)
		{
			if(!visited[i])
				toposortUtil(i, stack, visited);
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
	
	public void kahnAlgo()
	{
		int []indegree = new int[vertices];
		for(int i = 0;i < vertices;i++)
		{
			LinkedList<Integer> list = adj[i];
			for(int node : list)
				indegree[node]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0;i < vertices;i++)
		{
			if(indegree[i] == 0)
				queue.add(i);
		}
		
		int count = 0;
		Vector<Integer> vector = new Vector<>();
		while(!queue.isEmpty())
		{
			int vertex = queue.poll();
			vector.add(vertex);
			for(int node : adj[vertex])
			{
				if(--indegree[node] == 0)
					queue.add(node);
			}
			count++;
		}
		
		if(count != vertices)
		{
			System.out.println("Not DAG");
			return;
		}
		
		for(int i :vector)
			System.out.print(i + " ");
	}
}