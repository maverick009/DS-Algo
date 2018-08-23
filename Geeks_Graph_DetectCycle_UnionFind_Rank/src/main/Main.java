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
			System.out.println("Enter number of vertices and edges");
			vertices = sc.nextInt();
			edges = sc.nextInt();
			
			Graph graph = new Graph(vertices, edges);
			System.out.println("Enter edges:<source> <destination>");
			for(int i = 0;i < edges;i++)
			{
				graph.arr[i].src = sc.nextInt();
				graph.arr[i].dest = sc.nextInt();
			}
			
			System.out.println("Contain Cycle:" + graph.isCycle(graph));
		}
	}
}
