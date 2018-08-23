package main;

import bst.BST;

public class Main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 25);
		bst.root = bst.insert(bst.root, 45);
		bst.root = bst.insert(bst.root, 15);
		bst.root = bst.insert(bst.root, 15);
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 25);
		bst.root = bst.insert(bst.root, 35);
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 40);
		bst.inorder(bst.root);
		System.out.println();
		
		bst.root = bst.delete(bst.root, 15);
		bst.inorder(bst.root);
		System.out.println();
	}
}
