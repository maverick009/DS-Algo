package main;

import timepass.TimePass;

public class Main 
{
	public static void main(String[] args)
	{
		TimePass t = new TimePass();
		t.root = t.insert(t.root, 10);
		t.root = t.insert(t.root, 25);
		t.root = t.insert(t.root, 35);
		t.root = t.insert(t.root, 40);
		t.root = t.insert(t.root, 60);
		t.root = t.insert(t.root, 15);
		t.root = t.insert(t.root, 5);
		t.root = t.insert(t.root, 9);
		t.root = t.insert(t.root, 3);
		System.out.println("BST");
		t.levelorder(t.root);
		//t.inorder(t.root);
		t.convertBSTDLL(t.root);
		t.display(t.head);
	}
}
