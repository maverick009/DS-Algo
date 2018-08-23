package main;

import avl.AVL;

public class Main 
{
	public static void main(String[] args) 
	{
		AVL avl = new AVL();
		avl.root = avl.insert(avl.root, 9);
		avl.root = avl.insert(avl.root, 5);
		avl.root = avl.insert(avl.root, 10);
		avl.root = avl.insert(avl.root, 5);
		avl.root = avl.insert(avl.root, 9);
		avl.root = avl.insert(avl.root, 7);
		avl.root = avl.insert(avl.root, 17);
		avl.preorder(avl.root);
		System.out.println();
		
		avl.root = avl.delete(avl.root, 9);
		avl.preorder(avl.root);
		System.out.println();
	}
}
