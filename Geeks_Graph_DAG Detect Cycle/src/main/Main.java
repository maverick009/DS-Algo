package main;
import graph.Graph;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		int vertices,edges,source,dest;
		
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter number of Vertices and Edges");
			vertices = sc.nextInt();
			edges = sc.nextInt();
			
			System.out.println("Enter in graph order:<source> <destination>");
			Graph graph = new Graph(vertices);
			for(int i = 0;i < edges;i++)
			{
				source = sc.nextInt();
				dest = sc.nextInt();
				graph.addedge(source, dest);
			}
			
			System.out.println("DFS:");
			graph.DFS(2);
			System.out.println("\nCycle?" + graph.detectCycle());
		}
	}

}
