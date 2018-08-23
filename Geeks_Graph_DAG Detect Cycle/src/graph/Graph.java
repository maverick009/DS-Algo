package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
	
	public void addedge(int vertex,int edge)
	{
		adj[vertex].add(edge);
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
	
	public boolean cycleUtil(int index,Stack<Integer> stack,boolean []visited)
	{
		Iterator<Integer> i = adj[index].listIterator();
		while(i.hasNext())
		{			
			int n = i.next();
			if(!stack.isEmpty() && stack.contains(n))
			{
				
				return true;
			}
			if(!visited[n])
			{
				stack.push(n);
				return cycleUtil(n, stack, visited);
			}
		}		
		return false;
	}
	
	public boolean detectCycle()
	{
		boolean []visited = new boolean[vertices];
		for(int i = 0;i < vertices;i++)
			visited[i] = false;
		Stack<Integer> stack = new Stack<>();
		boolean val = false;
		for(int i = 0;i < vertices;i++)
			val = cycleUtil(i, stack, visited);
		return val;
	}
}
