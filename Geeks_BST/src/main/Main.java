package main;

import tree.BST;

public class Main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 80);
		bst.root = bst.insert(bst.root, 90);
		
		System.out.println("Inorder Traversal");
		bst.inorder(bst.root);
		System.out.println("Preorder Traversal");
		bst.preorder(bst.root);
		System.out.println("Postorder Traversal");
		bst.postorder(bst.root);
		System.out.println("LevelOrder Traversal");
		bst.levelorder(bst.root);
		
		System.out.println("search 30:" + bst.search(bst.root, 30));
		
		System.out.println("Deleting 20");
		bst.root = bst.delete(bst.root, 20);
		System.out.println("Inorder Traversal");
		bst.inorder(bst.root);
		
		System.out.println("Is BST?" + bst.isBST(bst.root));
	}

}
