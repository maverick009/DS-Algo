package main;

import bst.BST;

public class Main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		/*bst.head = bst.insert(bst.head, 30);
		bst.head = bst.insert(bst.head, 40);
		bst.head = bst.insert(bst.head, 20);
		bst.head = bst.insert(bst.head, 15);
		bst.head = bst.insert(bst.head, 70);
		bst.head = bst.insert(bst.head, 60);
		bst.head = bst.insert(bst.head, 80);
		bst.head = bst.insert(bst.head, 90);*/
		
		bst.head = bst.new Node(50);
		bst.head.left = bst.new Node(10);
		bst.head.right = bst.new Node(60);
		bst.head.left.left = bst.new Node(5);
		bst.head.left.right = bst.new Node(20);
		bst.head.right.left = bst.new Node(55);
		bst.head.right.left.left = bst.new Node(45);
		bst.head.right.right = bst.new Node(70);
		bst.head.right.right.left = bst.new Node(65);
		bst.head.right.right.right = bst.new Node(80);
		
		System.out.println("Binary Search Tree");
		bst.inorder(bst.head);
		System.out.println("IsBST?" + bst.isBST(bst.head));
		System.out.println("Size of tree:" + bst.size(bst.head));
		
		//System.out.println("Largest BST Size:" + bst.largestBST(bst.head));
		bst.info = bst.largestBST(bst.head);
		System.out.println("Largest BST Size:" + bst.info.subBSTSize);
		//System.out.println("Largest ");
	}

}
