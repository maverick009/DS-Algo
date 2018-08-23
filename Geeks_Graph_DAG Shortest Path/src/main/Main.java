package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph
{
	class Node
	{
		int vertex, weight;
		public Node(int vertex, int weight)
		{
			this.vertex = vertex;
			this.weight = weight;
		}		
	}
	
	int v;
	LinkedList<Node> []adj;
	
	public Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[this.v];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addedge(int src,int dest, int weight) 
	{
		Node newnode = new Node(dest, weight);
		adj[src].add(newnode);
	}
	
	public void sortutil(boolean []visited, Stack<Integer> stack, int vertex)
	{
		visited[vertex] = true;
		Iterator<Node> i = adj[vertex].listIterator();
		while(i.hasNext())
		{
			Node node = i.next();
			if(!visited[node.vertex])
				sortutil(visited, stack, node.vertex);
		}
		stack.push(vertex);
	}
	
	public Stack<Integer> topologicalsort(Stack<Integer> stack)
	{
		boolean []visited = new boolean[this.v];
		
		for(int i = 0;i < this.v;i++)
			if(!visited[i])
				sortutil(visited, stack, i);
		/*while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");*/
		return stack;
	}
	
	public void print(int src, int []dist)
	{
		for(int i = 0;i < this.v;i++)
			if(dist[i] == Integer.MAX_VALUE)
				System.out.print("INF ");
			else
				System.out.print(dist[i] + " ");
		System.out.println();
	}
	
	public void path(int src)
	{
		int []dist = new int[this.v];
		for(int i = 0;i < dist.length;i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;
		
		Stack<Integer> stack = new Stack<>();
		stack = topologicalsort(stack);
		System.out.println(stack);
		
		for(int i = 0;i < dist.length;i++)
			System.out.print(dist[i] + " ");
		System.out.println();
		
		while(!stack.isEmpty())
		{
			int num = stack.pop();
			
			Iterator<Node> itr = adj[num].listIterator();
			if(dist[num] != Integer.MAX_VALUE)
			{
				while(itr.hasNext())
				{
					Node node = itr.next();
					if(dist[num] + node.weight < dist[node.vertex])
						dist[node.vertex] = dist[num] + node.weight;
				}
			}
		}
		print(src, dist);
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
        g.addedge(3, 4, -1);
        g.addedge(4, 5, -2);
        g.path(1);
	}
}