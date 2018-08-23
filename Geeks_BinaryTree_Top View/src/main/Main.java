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
		bt.root.left.right= bt.new Node(4);
		bt.root.left.right.right = bt.new Node(5);
		bt.root.left.right.right.right= bt.new Node(6);
		bt.topView(bt.root);
	}
}
