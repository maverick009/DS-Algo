package main;

import bst.BST;

public class Main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		bst.root = bst.insert(bst.root, 1);
		bst.root = bst.insert(bst.root, 2);
		bst.root = bst.insert(bst.root, 3);
		bst.root = bst.insert(bst.root, 4);
		bst.root = bst.insert(bst.root, 5);
		bst.levelorder(bst.root);
		System.out.println();
	}
}
