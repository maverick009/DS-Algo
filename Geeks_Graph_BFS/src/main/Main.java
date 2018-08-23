package main;
import java.util.Scanner;

import graph.Graph;
public class Main 
{
	public static void main(String[] args) 
	{
		int source,destination,vertices,edges,count = 1;
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("enter vertices and edges:");
			vertices = sc.nextInt();
			edges = sc.nextInt();
			
			Graph graph = new Graph(vertices);
			System.out.println("Enter edges in graph format: <source> <destination>");
			while(count <= edges)
			{
				source = sc.nextInt();
				destination = sc.nextInt();
				graph.addEdge(source, destination);
				count++;
			}
			
			System.out.println("Disply Graph");
			graph.display();
			
			System.out.println("BFS");
			graph.BFS(2);
		}
	}

}
