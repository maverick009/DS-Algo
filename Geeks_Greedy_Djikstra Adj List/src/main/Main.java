package main;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Graph
{
	class Node implements Comparable<Node>
	{
		int dest, dist;
		public Node(int dest, int dist) {
			this.dist = dist;
			this.dest = dest;
		}
		
		@Override
		public int compareTo(Node node){
			return this.dist - node.dist;
		}
	}
	
	LinkedList<Node> []adj;
	int v, e;
	
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[this.v];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int src, int dest, int weight) {
		Node node1 = new Node(src, weight);
		Node node2 = new Node(dest, weight);
		adj[src].add(node2);
		adj[dest].add(node1);
	}
	
	public void djikstra(int src)
	{
		int []parent = new int[this.v];
		boolean []visited = new boolean[this.v];
		Node []dist = new Node[this.v];
		
		for(int i = 0;i < dist.length;i++)
			dist[i] = new Node(i, Integer.MAX_VALUE);
		dist[src].dist = 0;
		
		Queue<Node> pq = new PriorityQueue<>();
		pq.addAll(Arrays.asList(dist));
		
		while(pq.size() > 1)
		{
			Node u = pq.remove();
			visited[u.dest] = true;
			
			for(Node node : adj[u.dest])
			{
				int v = node.dest;
				if(!visited[v] && node.dist  + u.dist < dist[v].dist) 
				{
					pq.remove(dist[v]);
					parent[v] = u.dest;
					dist[v].dist = node.dist + u.dist;
					pq.add(dist[v]);
				}
			}
		}
		print(dist, parent, src);
	}
	
	public void print(Node []dist, int []parent, int src)
	{
		System.out.println("src-vertex" + "\tDistance");
		for(int i = 0;i < this.v;i++) {
			int node = dist[i].dest;
			System.out.println(src + "-" + i + "\t\t" + dist[node].dist);
		}
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		int v = 9;
		Graph g = new Graph(v);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);
		
		g.djikstra(0);
	}
}
