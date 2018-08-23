package main;
import expressiontree.ExpressionTree;

public class Main 
{
	public static void main(String[] args) 
	{
		ExpressionTree et = new ExpressionTree();
		String postfix = "ab+ef*g*-";
		et.root = et.constructTree(postfix);
		System.out.println("Infix Expression:");
		et.inorder(et.root);
		System.out.println();
		et.preorder(et.root);
		System.out.println();
		et.postorder(et.root);
		System.out.println();
		et.levelorder(et.root);
	}
}
