package main;

import bst.BST;

public class Main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 80);
		bst.root = bst.insert(bst.root, 90);
		bst.root = bst.insert(bst.root, 25);
		bst.root = bst.insert(bst.root, 15);
		
		System.out.println("Display");
		bst.levelorder(bst.root);
		System.out.println("Array");
		System.out.println("2nd smallest element:" + bst.ksmallest(bst.root, 9));
	}
}
