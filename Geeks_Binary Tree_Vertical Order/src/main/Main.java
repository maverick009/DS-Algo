package main;

import bt.BT;

public class Main 
{
	public static void main(String[] args) 
	{
		BT bt = new BT();
		bt.root = bt.new Node(1);
		bt.root.left = bt.new Node(2);
		bt.root.right = bt.new Node(3);
		bt.root.left.left = bt.new Node(4);
		bt.root.left.right = bt.new Node(5);
		bt.root.right.left = bt.new Node(6);
		bt.root.right.right = bt.new Node(7);
		bt.root.right.left.right = bt.new Node(8);
		bt.root.right.right.right = bt.new Node(9);
		bt.root.right.right.left = bt.new Node(10);
		bt.root.right.right.left.right = bt.new Node(11);
		bt.root.right.right.left.right.right = bt.new Node(12);
		System.out.println("Vertical Order using HashMap");
		bt.varticalOrder(bt.root);
	}
}
