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
		bst.root = bst.insert(bst.root, 15);
		bst.root = bst.insert(bst.root, 25);
		
		System.out.println("Display with range 35-50");
		bst.inorder(bst.root, 35, 70);
	}

}
