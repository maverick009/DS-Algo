package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import graph.Graph;

public class Main 
{
	public static void main(String[] args) 
	{
		int source,destination,edges,vertices,count = 1;
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter number of vertices:");
			vertices = sc.nextInt();
			System.out.println("Enyer number of edges:");
			edges = sc.nextInt();
			
			Graph graph = new Graph(vertices);
			
			System.out.println("Enter edges in graph format: <Source> <Destination>");
			while(count <= edges)
			{
				source = sc.nextInt();
				destination = sc.nextInt();
				graph.setEdge(source, destination);
				count++;
			}
			
			System.out.println("Adjacency List:");
			graph.display();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Input Mismatch Exception");
		}
	}

}
