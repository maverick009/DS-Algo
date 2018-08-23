package main;
import java.util.Scanner;

import graph.Graph;

public class Main 
{
	public static void main(String[] args) 
	{
		int source,dest,vertices,edges;
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter number of Vertices and edges:");
			vertices = sc.nextInt();
			edges = sc.nextInt();
			
			System.out.println("Enter Data in Graph Form <Source> <Destination>");
			Graph graph = new Graph(vertices);
			for(int i = 0;i < edges;i++)
			{
				source = sc.nextInt();
				dest = sc.nextInt();
				graph.addEdge(source, dest);
			}
			
			System.out.println("BFS");
			graph.BFS(2);
			System.out.println("\nDFS");
			graph.DFS(2);
			System.out.println("\nFull DFS");
			graph.fullDFS();
			System.out.println("\nTopological Sort");
			graph.topologicalSort();
			System.out.println("\nInodegree");
			graph.kahnAlgo();
		}
	}

}
