package main;
import kdtree.KDTree;

public class Main 
{	
	public static void main(String[] args) 
	{		
		 //int points[][] = {{3, 6}, {17, 15}, {13, 15}, {6, 12}, {9, 1}, {2, 7}, {10, 19}};
		 int points[][] = {{30, 40}, {5, 25}, {70, 70},{10, 12}, {50, 30}, {35, 45}};
		 KDTree kdt = new KDTree();
		 for(int i = 0;i < points.length;i++)
			 kdt.root = kdt.insert(kdt.root, points[i]);
		 
		 int []p = {10, 10};
		 System.out.println("[10, 10]:" + kdt.search(kdt.root, p));
		 
		 int []p1 = {35, 45};
		 System.out.println("[35, 45]:" + kdt.search(kdt.root, p1));
		 System.out.println("Min:" + kdt.min(kdt.root, 0));
	}
}
