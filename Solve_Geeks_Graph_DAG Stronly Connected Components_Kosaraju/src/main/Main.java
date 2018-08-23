/*Use Transitive Closure or DFS 0(v3).
 * Thus Kosaraju
 * Tarjan is Remaining
*/

package main;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph
{
	int v;
	LinkedList<Integer> []adj;
	public Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[this.v];
		for(int i = 0;i < adj.length;i++)
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
	
	public void DFSUtil(int vertex, boolean []visited)
	{
		visited[vertex] = true;
		//System.out.print(vertex + " ");
		Iterator<Integer> i = adj[vertex].listIterator();
		while(i.hasNext())
		{
			int temp = i.next();
			if(!visited[temp])
				DFSUtil(temp, visited);
		}
	}
	
	public Graph tanspose()
	{
		Graph g = new Graph(this.v);
		for(int i = 0;i < this.v;i++)
		{
			Iterator<Integer> itr = adj[i].listIterator();
			while(itr.hasNext())
				g.adj[itr.next()].add(i);
		}
		return g;
	}
	
	public void fill(boolean []visited, Stack<Integer> stack, int vertex)
	{
		visited[vertex] = true;
		Iterator<Integer> i = adj[vertex].listIterator();
		while(i.hasNext())
		{
			int temp = i.next();
			if(!visited[temp])
				fill(visited, stack, temp);
		}
		stack.push(vertex);
	}
	
	public void findAllSCC()
	{
		Stack<Integer> stack = new Stack<>();
		boolean []visited = new boolean[this.v];
		
		for(int i = 0;i < this.v;i++)
			if(!visited[i])
				fill(visited, stack, i);
		
		Graph g = tanspose();
		
		for(int i = 0;i < visited.length;i++)
			visited[i] = false;
		
		while(!stack.isEmpty())
		{
			int temp = stack.pop();
			if(!visited[temp])
			{
				g.DFSUtil(temp, visited);
				System.out.println();
			}
		}
	}
	
	public boolean isStrong()
	{
		boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;
 
        // Step 2: Do DFS traversal starting from first vertex.
        DFSUtil(0, visited);
 
        // If DFS traversal doesn't visit all vertices, then
        // return false.
        for (int i = 0; i < v; i++)
            if (visited[i] == false)
                return false;
 
        // Step 3: Create a reversed graph
        Graph gr = tanspose();
 
        // Step 4: Mark all the vertices as not visited (For
        // second DFS)
        for (int i = 0; i < v; i++)
            visited[i] = false;
 
        // Step 5: Do DFS for reversed graph starting from
        // first vertex. Staring Vertex must be same starting
        // point of first DFS
        gr.DFSUtil(0, visited);
 
        // If all vertices are not visited in second DFS, then
        // return false
        for (int i = 0; i < v; i++)
            if (visited[i] == false)
                return false;
 
        return true;
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		/*Graph g = new Graph(5);
        g.addedge(1, 0);
        g.addedge(0, 2);
        g.addedge(2, 1);
        g.addedge(0, 3);
        g.addedge(3, 4);*/
		Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        /*System.out.println("Following are strongly connected components "+
                "in given graph ");
        g1.findAllSCC();
        System.out.println();*/
        if (g1.isStrong())
            System.out.println("Yes");
        else
            System.out.println("No");
 
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        /*System.out.println("Following are strongly connected components "+
                "in given graph ");
        g2.findAllSCC();
        System.out.println();*/
        if (g2.isStrong())
            System.out.println("Yes");
        else
            System.out.println("No");
	}
}