package main;

import java.util.Scanner;
import graph.Graph;

public class Main 
{
	public static void main(String[] args) 
	{
		int vertices,edges;
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter vertices and edges");
			vertices = sc.nextInt();
			edges = sc.nextInt();
			
			Graph graph = new Graph(vertices, edges);
			System.out.println("Enter Ends of Edges: <Source> <destination>");
			for(int i = 0;i < edges;i++)
			{
				graph.edge[i].src = sc.nextInt();
				graph.edge[i].dest = sc.nextInt();
			}
			
			System.out.println("Cycle Present:" + graph.isCycle(graph));
		}
	}
}