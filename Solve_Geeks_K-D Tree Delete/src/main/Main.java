package main;

import kdtree.KDTree;

public class Main 
{
	public static void main(String[] args) 
	{
		int points[][] = {{30, 40}, {5, 25}, {70, 70}, {10, 12}, {50, 30}, {35, 45}};
		KDTree kd = new KDTree(2);
		for(int i = 0;i < points.length;i++)
			kd.root = kd.insert(kd.root, points[i]);
		kd.inorder(kd.root);
		System.out.println("Search:" + kd.search(kd.root, points[2]));
		System.out.println("Min in dimension 0:" + kd.getMin(kd.root, 0));
		System.out.println("Min in dimension 1:" + kd.getMin(kd.root, 1));
	}
}
