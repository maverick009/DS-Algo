package main;
import btree.BTree;

public class Main 
{
	public static void main(String[] args) 
	{
		BTree btree = new BTree(3);
		btree.root = btree.insert(btree.root, 10);
		btree.root = btree.insert(btree.root, 20);
		btree.root = btree.insert(btree.root, 5);
		btree.root = btree.insert(btree.root, 6);
		btree.root = btree.insert(btree.root, 12);
		btree.root = btree.insert(btree.root, 30);
		btree.root = btree.insert(btree.root, 7);
		btree.root = btree.insert(btree.root, 17);
		
		System.out.println("B tree traversal");
		btree.traverse(btree.root);
	}
}