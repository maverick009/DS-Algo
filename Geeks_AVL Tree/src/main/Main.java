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
		avl.root = avl.insert(avl.root, 0);
		avl.root = avl.insert(avl.root, 6);
		avl.root = avl.insert(avl.root, 11);
		avl.root = avl.insert(avl.root, -1);
		avl.root = avl.insert(avl.root, 1);
		avl.root = avl.insert(avl.root, 2);
		
		System.out.println("Preorder Traversal");
		avl.preorder(avl.root);
		System.out.println();
		avl.root = avl.delete(avl.root, 10);
		System.out.println("Preorder Traversal");
		avl.preorder(avl.root);
	}
}
