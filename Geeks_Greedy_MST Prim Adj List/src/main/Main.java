package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class MST
{
	public class Node implements Comparable<Node>
	{
		int vertex, key;
		public Node(int vertex, int key)
		{
			this.vertex = vertex;
			this.key = key;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.key - n.key;
		}
	}
	
	LinkedList<Node> []adj;
	int V;
	public MST(int V)
	{
		this.V = V;
		adj = new LinkedList[V];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int src, int dest, int key)
	{
		Node newnode1 = new Node(src, key);
		Node newnode2 = new Node(dest, key);
		adj[src].add(newnode2);
		adj[dest].add(newnode1);
	}
	
	public void prim()
	{
		Node []dist = new Node[V];
		int []parent = new int[V];
		boolean []visited = new boolean[V];
		
		for(int i = 0;i < V;i++)
			dist[i] = new Node(i, Integer.MAX_VALUE);
		
		dist[0].key = 0;
		
		Queue<Node> pq = new PriorityQueue<>();
		pq.addAll(Arrays.asList(dist));
		
		while(pq.size() > 1)
		{
			Node u = pq.remove();
			visited[u.vertex] = true;
			
			for(Node node : adj[u.vertex])
			{
				int v = node.vertex;
				if(!visited[v] && node.key < dist[v].key)
				{
					pq.remove(dist[v]);
					dist[v].key = node.key;
					parent[v] = u.vertex;
					pq.add(dist[v]);					
				}
			}
		}//End of While
		print(dist, parent);
	}
	
	public void print(Node []dist, int []parent)
	{
		System.out.println("src-dest" + "\tDistance");
		for(int i = 1;i < this.V;i++) {
			int v = dist[i].vertex;
			System.out.println(parent[v] + "-" + i + "\t\t" + dist[v].key);
		}
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		int V = 9;
		MST m = new MST(V);
		m.addEdge(0, 1, 4);
        m.addEdge(0, 7, 8);
        m.addEdge(1, 2, 8);
        m.addEdge(1, 7, 11);
        m.addEdge(2, 3, 7);
        m.addEdge(2, 8, 2);
        m.addEdge(2, 5, 4);
        m.addEdge(3, 4, 9);
        m.addEdge(3, 5, 14);
        m.addEdge(4, 5, 10);
        m.addEdge(5, 6, 2);
        m.addEdge(6, 7, 1);
        m.addEdge(6, 8, 6);
        m.addEdge(7, 8, 7);
        m.prim();
	}
}