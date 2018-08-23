package main;

import treap.Treap;

public class Main 
{
	public static void main(String[] args) 
	{
		Treap treap = new Treap();
		treap.root = treap.insert(treap.root, 50);
		treap.root = treap.insert(treap.root, 30);
		treap.root = treap.insert(treap.root, 20);
		treap.root = treap.insert(treap.root, 40);
		treap.root = treap.insert(treap.root, 70);
		treap.root = treap.insert(treap.root, 60);
		treap.root = treap.insert(treap.root, 80);
		
		//values will change with every execution as priority is random.
		treap.inorder(treap.root);
		System.out.println();
		/*treap.levelorder(treap.root);
		System.out.println();*/
		
		treap.root = treap.delete(treap.root, 20);
		treap.inorder(treap.root);
		System.out.println();
		
		Treap.Node node = treap.search(treap.root, 50);
		System.out.println((node != null)? "Found" : "Not Found");
	}
}