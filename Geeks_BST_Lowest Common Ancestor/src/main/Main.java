package main;
import bst.BST;
import bst.BSTParent;

public class Main 
{
	public static void main(String[] args) 
	{
		BST bst = new BST();
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 100);
		bst.root = bst.insert(bst.root, 80);
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 35);
		bst.root = bst.insert(bst.root, 20);
		//bst.inorder(bst.root);
		//System.out.println();
		/*BST.Node node = bst.lca(bst.root, 20, 35);
		System.out.println("\nLCA:" + node.data);
		System.out.println("LCA:" + bst.lca1(bst.root, 100, 75));
		BST.Node node1 = bst.lca2(bst.root, 20, 35);
		System.out.println("LCA:" + node1.data);*/
		//System.out.println("LCA:" + bst.findLca(bst.root, 20, 10));
		
		
		BSTParent bstp = new BSTParent();
		bstp.root = bstp.insert(bstp.root, 40);
		bstp.root = bstp.insert(bstp.root, 30);
		bstp.root = bstp.insert(bstp.root, 60);
		bstp.root = bstp.insert(bstp.root, 70);
		bstp.root = bstp.insert(bstp.root, 100);
		bstp.root = bstp.insert(bstp.root, 80);
		bstp.root = bstp.insert(bstp.root, 10);
		bstp.root = bstp.insert(bstp.root, 35);
		bstp.root = bstp.insert(bstp.root, 20);
		
		bstp.inorder(bstp.root);
		System.out.println();
		BSTParent.Node node = bstp.lca(bstp.root, bstp.root.left.left, bstp.root.left.left.right);
		System.out.println("LCA:" + node.data);
	}
}
