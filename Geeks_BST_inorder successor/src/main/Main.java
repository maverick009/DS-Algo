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
		
		System.out.println("Level Order");
		bst.levelorder(bst.root);
		
		System.out.println("Inorder Successor of 25:" + bst.inorderSucessor(bst.root, 10));
		
	}

}
