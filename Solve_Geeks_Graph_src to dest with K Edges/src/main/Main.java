//Print Path and Understand
package main;

public class Main 
{
	private static final int INF = Integer.MAX_VALUE;
	
	public static int shortestpath(int [][]graph, int src, int dest, int k)
	{
		int [][][]sp = new int[graph.length][graph.length][k + 1];
		for(int e = 0;e <= k;e++)
		{
			for(int i = 0;i < graph.length;i++)
			{
				for(int j = 0;j < graph.length;j++)
				{
					sp[i][j][e] = INF;
					if(e == 0 && i == j)
						sp[i][j][e] = 0;
					if(e == 1 && graph[i][j] != INF)
						sp[i][j][e] = graph[i][j];
					
					if(e > 1)
					{
						for(int a = 0;a < graph.length;a++)
						{
							if(graph[i][a] != INF && i != a && j != a && sp[a][j][e - 1] != INF)
								sp[i][j][e] = Math.min(sp[i][j][e], graph[i][a] + sp[a][j][e - 1]);
						}
					}
				}
			}
		}
		return sp[src][dest][k];
	}
	
	public static int path(int [][]graph, int src, int dest, int k)
	{
		int [][][]count = new int[graph.length][graph.length][k + 1];
		for(int e = 0;e <= k;e++)
		{
			for(int i = 0;i < graph.length;i++)
			{
				for(int j = 0;j < graph.length;j++)
				{
					if(e == 0 && i == j)
						count[i][j][e] = 1;
					if(e == 1 && graph[i][j] != 0)
						count[i][j][e] = 1;
					
					if(e > 1)
					{
						for(int a = 0;a < graph.length;a++)
							if(graph[i][a] != 0)
								count[i][j][e] += count[a][j][e - 1];							
					}
				}
			}			
		}
		return count[src][dest][k];
	}
	
	public static void main(String[] args) 
	{
		/*int [][]graph =	{ {0, 1, 1, 1},
            			  {0, 0, 0, 1},
            			  {0, 0, 0, 1},
            			  {0, 0, 0, 0}
           				};*/
		int graph[][] = { {0, 10, 3, 2},
            			  {INF, 0, INF, 7},
            			  {INF, INF, 0, 6},
            			  {INF, INF, INF, 0}
          				};		
		int src = 0, dest = 3, k = 2;
		//System.out.println("total number of paths:" + path(graph, src, dest, k));
		System.out.println("Shortest Path:" + shortestpath(graph, src, dest, k));
	}
}
