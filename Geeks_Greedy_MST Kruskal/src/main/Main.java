package main;

import graph.Graph;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
    {
	    int V,E,src, dest;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Vertex and Edges");
	    V = sc.nextInt();
	    E = sc.nextInt();
	    Graph graph = new Graph(V, E);
	    
	    for(int i = 0;i < E;i++)
	    {
	    	graph.edges[i].src = sc.nextInt();
		    graph.edges[i].dest = sc.nextInt();
		    graph.edges[i].weight = sc.nextInt();
	    }
	    /*graph.edges[0].src = 0;
	    graph.edges[0].dest = 1;
	    graph.edges[0].weight = 10;
	    
	    graph.edges[1].src = 0;
	    graph.edges[1].dest = 2;
	    graph.edges[1].weight = 6;
	    
	    graph.edges[2].src = 0;
	    graph.edges[2].dest = 3;
	    graph.edges[2].weight = 5;
	    
	    graph.edges[3].src = 1;
	    graph.edges[3].dest = 3;
	    graph.edges[3].weight = 15;
	    
	    graph.edges[4].src = 2;
	    graph.edges[4].dest = 3;
	    graph.edges[4].weight = 4;*/
	    
	    graph.kruskal();
    }
}