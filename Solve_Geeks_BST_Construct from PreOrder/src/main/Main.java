package main;
import bst.BST;

public class Main 
{
	public static void main(String[] args) 
	{
		int pre[] = {10, 5, 1, 7, 40, 50};
		BST bst = new BST();
		bst.inorderToBST(bst.root, pre);
		System.out.println();
	}
}
