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
			System.out.println("Enter Number of Vertices and Edges:");
			vertices = sc.nextInt();
			edges = sc.nextInt();
			
			Graph graph = new Graph(vertices);
			System.out.println("Enter edges in Graph form <source> <Destination>");
			for(int i = 0; i < edges;i++)
			{				
				source = sc.nextInt();
				dest = sc.nextInt();
				graph.addEdge(source, dest);
			}
			
			System.out.println("Display Graph");
			graph.display();
			System.out.println("BFS");
			graph.BFS(2);
			System.out.println("\nDFS");
			graph.DFS(2);
		}
	}

}
