package main;

class Graph
{	
	public boolean issafe(int [][]graph, boolean [][]visited, int row, int col)
	{
		return ((row >= 0 && row < graph.length) && (col >= 0 && col < graph.length) &&
				graph[row][col] != 0 && !visited[row][col]); 
	}
	
	public void dfsutil(int [][]graph, boolean [][]visited, int row, int col)
	{
		visited[row][col] = true;
		System.out.print(row + "," + col + " - ");
		int []ROW = {-1, -1, -1, 0, 0, 1, 1, 1};
		int []COL = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int i = 0;i < 8;i++)
		{
			if(issafe(graph, visited, row + ROW[i], col + COL[i]))
				dfsutil(graph, visited, row + ROW[i], col + COL[i]);
		}
	}
	
	public int islands(int [][]graph)
	{
		boolean [][]visited = new boolean[graph.length][graph.length];
		int count = 0;
		for(int i = 0;i < graph.length;i++)
		{
			for(int j = 0;j < graph.length;j++)
			{
				if(graph[i][j] == 1 && !visited[i][j])
				{
					dfsutil(graph, visited, i, j);
					System.out.println();
					count++;
				}
			}
		}
		return count;
	}
}

public class Main
{
	public static void main(String[] args) 
	{
		int graph[][]= { {1, 1, 0, 0, 0},
		        		 {0, 1, 0, 0, 1},
		        		 {1, 0, 0, 1, 1},
		        		 {0, 0, 0, 0, 0},
		        		 {1, 0, 1, 0, 1}
		    			};
		Graph g = new Graph();
		System.out.println("Number of Islands:" + g.islands(graph)); 
	}
}