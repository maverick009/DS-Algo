package main;

import splay.Splay;

public class Main 
{
	public static void main(String[] args) 
	{
		Splay splay = new Splay();
		/*splay.root = splay.new Node(100);
		splay.root.left = splay.new Node(50);
		splay.root.right = splay.new Node(200);
		splay.root.left.left = splay.new Node(40);
		splay.root.left.left.left = splay.new Node(30);
		splay.root.left.left.left.left = splay.new Node(20);*/
		
		splay.root = splay.new Node(6);
		splay.root.left = splay.new Node(1);
		splay.root.right = splay.new Node(9);
		splay.root.left.right = splay.new Node(4);
		splay.root.left.right.left = splay.new Node(2);
		splay.root.right.left = splay.new Node(7);
		
		splay.preorder(splay.root);
		System.out.println();
		
		//splay.root = splay.insert(splay.root, 25);
		splay.root = splay.delete(splay.root, 4);
		splay.preorder(splay.root);
		System.out.println();
	}
}
