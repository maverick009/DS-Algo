package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph
{
	class Node
	{
		int dest, weight;
		public Node(int dest, int weight)
		{
			this.dest = dest;
			this.weight = weight;
		}		
	}
	
	int v;
	public LinkedList<Node> []adj;
	public Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[this.v];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addedge(int src, int dest, int weight)
	{
		Node newnode = new Node(dest,weight);
		adj[src].add(newnode);
	}
	
	public void print(int []dist, int src)
	{
		for(int i = 0;i < dist.length;i++)
		{
			if(dist[i] == Integer.MIN_VALUE)
				System.out.print("INF ");
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}
	
	public void sortutil(Stack<Integer> stack, boolean []visited, int vertex)
	{
		visited[vertex] = true;
		Iterator<Node> itr = adj[vertex].listIterator();
		while(itr.hasNext())
		{
			Node node = itr.next();
			if(!visited[node.dest])
				sortutil(stack, visited, node.dest);
		}
		stack.push(vertex);
	}
	
	public Stack<Integer> topologicalsort(Stack<Integer> stack, boolean []visited)
	{
		for(int i = 0;i < this.v;i++)
			if(!visited[i])
				sortutil(stack, visited, i);
		return stack;
	}
	
	public void path(int src)
	{
		int []dist = new int[this.v];
		boolean []visited = new boolean[this.v];
		for(int i = 0;i < dist.length;i++)
			dist[i] = Integer.MIN_VALUE;
		dist[src] = 0;
		
		Stack<Integer> stack = new Stack<>();
		stack = topologicalsort(stack, visited);
	
		while(!stack.isEmpty())
		{
			int num = stack.pop();
			Iterator<Node> itr = adj[num].listIterator();
			if(dist[num] != Integer.MIN_VALUE)
			{
				while(itr.hasNext())
				{
					Node node = itr.next();
					if(dist[num] + node.weight > dist[node.dest])
						dist[node.dest] = dist[num] + node.weight;
				}
			}			
		}
		print(dist, src);
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		Graph g = new Graph(6);
	    g.addedge(0, 1, 5);
	    g.addedge(0, 2, 3);
	    g.addedge(1, 3, 6);
	    g.addedge(1, 2, 2);
	    g.addedge(2, 4, 4);
	    g.addedge(2, 5, 2);
	    g.addedge(2, 3, 7);
	    g.addedge(3, 5, 1);
	    g.addedge(3, 4, -1);
	    g.addedge(4, 5, -2);
	    g.path(1);
	}
}