package graph;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
//Use Array of Link List instead of Hash Table
//Check BFS
public class Graph 
{
	private HashMap<Integer, List<Integer>> Adjacency_List;
	private int vertices;
	
	public Graph(int vertices)
	{
		Adjacency_List = new HashMap<>();
		this.vertices = vertices;
		for(int i = 1;i <= vertices;i++)
		{
			Adjacency_List.put(i, new LinkedList<>());
		}
	}
	
	public void setEdge(int source, int destination)
	{
		if(source > Adjacency_List.size() || destination > Adjacency_List.size())
		{
			System.out.println("Vertex entered is not present");
			return;
		}
		List<Integer> slist = Adjacency_List.get(source);
		slist.add(destination);
		List<Integer> dlist = Adjacency_List.get(destination);
		dlist.add(source);
	}
	
	public List<Integer> getEdge(int source)
	{
		if(source > Adjacency_List.size())
			return null;
		
		return Adjacency_List.get(source);
	}
	
	public void display()
	{
		for(int i = 1;i <= vertices;i++)
		{
			System.out.print(i + ":");
			List<Integer> edgelist = getEdge(i);
			for(int j = 1; ;j++)
			{
				if(j != edgelist.size())
				{
					System.out.print(edgelist.get(j - 1) + "->");
				}
				else
				{
					System.out.print(edgelist.get(j-1));
					break;
				}
			}
			System.out.println();
		}
	}	
}
