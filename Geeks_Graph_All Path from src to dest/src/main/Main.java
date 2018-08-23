package main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class Graph
{
	LinkedList<Integer> []adj;
	int v;
	public Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[this.v];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addedge(int src, int dest) {
		adj[src].add(dest);
	}
	
	public void printutil(int src, int dest, ArrayList<Integer> list, boolean []visited)
	{	
		visited[src] = true;
		if(src == dest)
			System.out.println(list);
		
		Iterator<Integer> i = adj[src].listIterator();
		while(i.hasNext())
		{
			int temp = i.next();
			if(!visited[temp])
			{
				list.add(temp);
				printutil(temp, dest, list, visited);
				list.remove(list.indexOf(temp));
			}			
		}
		visited[src] = false;
	}
	
	public void printpath(int src, int dest)
	{
		boolean []visited = new boolean[this.v];
		ArrayList<Integer> list = new ArrayList<>();
		list.add(src);
		printutil(src, dest, list, visited);
	}
}


public class Main 
{
	public static void main(String[] args) 
	{
		Graph g = new Graph(4);
		g.addedge(0,1);
        g.addedge(0,2);
        g.addedge(0,3);
        g.addedge(2,0);
        g.addedge(2,1);
        g.addedge(1,3);
     
        // arbitrary source
        int s = 2;
     
        // arbitrary destination
        int d = 3;
     
        System.out.println("Following are all different paths from "+s+" to "+d);
        g.printpath(s, d);
	}
}