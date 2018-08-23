package main;

import bst.BST;

public class Main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		/*bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 80);
		bst.root = bst.insert(bst.root, 90);
		bst.root = bst.insert(bst.root, 25);*/
		
		bst.root = bst.new Node(50);
        bst.root.left = bst.new Node(10);
        bst.root.right = bst.new Node(60);
        bst.root.left.left = bst.new Node(5);
        bst.root.left.right = bst.new Node(20);
        bst.root.right.left = bst.new Node(55);
        bst.root.right.left.left = bst.new Node(45);
        bst.root.right.right = bst.new Node(70);
        bst.root.right.right.left = bst.new Node(65);
        bst.root.right.right.right = bst.new Node(80);
		
		System.out.println("Display");
		bst.levelorder(bst.root);
		System.out.println("Is BST?" + bst.isBST(bst.root));
		//System.out.println("Size:" + bst.size(bst.root));
		//System.out.println("max bst:" + bst.maxBST(bst.root));
	}
}
