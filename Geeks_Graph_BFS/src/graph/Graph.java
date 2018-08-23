package graph;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

public class Graph 
{
	private int vertices;
	private LinkedList<Integer> []adj;
	
	public Graph(int vertices)
	{
		setVertices(vertices);
		adj = new LinkedList[vertices];
		for(int i = 0;i < vertices;i++)
		{
			adj[i] = new LinkedList();
		}
	}
	
	public void setVertices(int vertices)
	{
		if(vertices != 0)
			this.vertices = vertices;
	}
	
	public void addEdge(int vertices,int edge)
	{
		adj[vertices].add(edge);
	}
	
	public void display()
	{
		for(int i = 0;i < vertices;i++)
		{
			System.out.print(i + ":");
			LinkedList<Integer> temp = adj[i];
			for(int j = 0; ;j++)
			{
				if(j != temp.size() - 1)
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
		boolean []visisted = new boolean[vertices];
		LinkedList<Integer> queue = new LinkedList<>();
		visisted[vertex] = true;
		queue.add(vertex);
		
		while(queue.size() != 0)
		{
			vertex = queue.poll();
			System.out.print(vertex + " ");
			
			Iterator<Integer> i = adj[vertex].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visisted[n])
				{
					visisted[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
}
