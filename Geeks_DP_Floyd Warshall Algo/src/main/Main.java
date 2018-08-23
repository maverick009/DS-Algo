package main;

public class Main 
{
	public static int INF = 9999;
	
	public static void floyd_warshall(int [][]arr)
	{
		int [][]temp = new int[arr.length][arr.length];
		for(int i = 0;i < arr.length;i++)
		{
			for(int j = 0;j < arr.length;j++)
				temp[i][j] = arr[i][j];
		}
		
		for(int k = 0;k < arr.length;k++)
			for(int i = 0;i < arr.length;i++)
				for(int j = 0;j < arr.length;j++)
					if(temp[i][k] + temp[k][j] < temp[i][j])
						temp[i][j] = temp[i][k] + temp[k][j];
		print(temp);
	}
	
	public static void print(int [][]arr)
	{
		for(int i = 0;i < arr.length;i++)
		{
			for(int j = 0;j < arr.length;j++)
				if(arr[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		int graph[][] = { {0,   5,  INF, 10},
                		  {INF, 0,   3, INF},
                		  {INF, INF, 0,   1},
                		  {INF, INF, INF, 0}
              			};
		floyd_warshall(graph);
	}
}
