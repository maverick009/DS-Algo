package main;

import java.util.LinkedList;
import java.util.Queue;

class Graph
{
	public void print(int [][]graph)
	{
		for(int i = 0;i < graph.length;i++)
		{
			for(int j = 0;j < graph.length;j++)
				System.out.print(graph[i][j] + " ");
			System.out.println();
		}
	}
	
	public boolean check(int src, int dest, int [][]graph)
	{
		//System.out.println("src:" + src + "\tdest:" + dest);
		boolean []visited = new boolean[graph.length];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		
		while(!queue.isEmpty())
		{
			int num = queue.poll();
			//System.out.println("num:" + num);
			if(num == dest)
				return true;
			for(int i = 0;i < graph.length;i++)
			{
				if(!visited[i] && graph[num][i] != 0)
				{
					queue.offer(i);
					visited[i] = true;
				}
			}	
		}
		return false;
	}
	
	public void closure(int [][]graph)
	{
		int [][]tc = new int[graph.length][graph.length];
		
		for(int i = 0;i < graph.length;i++)
		{
			for(int j = 0;j < graph.length;j++)
			{
				if(i == j || graph[i][j] == 1)
					tc[i][j] = 1;
				else if(check(i, j, graph))
						tc[i][j] = 1;				
			}
		}
		print(tc);
	}
}

public class Main 
{
	public static void main(String[] args) 
	{
		/*int graph[][] = { {1, 1, 0, 1},
            			  {0, 1, 1, 0},
            			  {0, 0, 1, 1},
            			  {0, 0, 0, 1}
          				};*/
		int graph[][] = { {1, 1, 1, 0},
  			  			  {0, 0, 1, 0},
  			  			  {1, 0, 0, 1},
  			  			  {0, 0, 0, 0}
						};
		Graph g = new Graph();
		g.closure(graph);
	}
}