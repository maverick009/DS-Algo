package main;

import redblack.RedBlack;

public class Main 
{
	public static void main(String[] args) 
	{
		RedBlack rb = new RedBlack();
		rb.root = rb.insert(7);
		rb.root = rb.insert(6);
		rb.root = rb.insert(5);
		rb.root = rb.insert(4);
		rb.root = rb.insert(3);
		rb.root = rb.insert(2);
		rb.root = rb.insert(1);
		rb.inorder(rb.root);
		System.out.println();
	}
}
