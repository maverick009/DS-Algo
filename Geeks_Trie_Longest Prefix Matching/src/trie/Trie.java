package trie;

import java.util.ArrayList;

public class Trie 
{	
	public class Node
	{
		char ch;
		boolean isLeaf;
		ArrayList<Node> childList;
		
		public Node(char ch)
		{
			this.ch = ch;
			this.isLeaf = false;
			childList = new ArrayList<>();
		}
		
		public Node subnode(char ch)
		{
			for(Node child : childList)
			{
				if(child.ch == ch)
					return child;
			}
			return null;
		}
	}
	
	private Node root;
	public Trie()
	{
		root = new Node(' ');
	}
	
	public boolean search(String str)
	{
		if(root == null)
			return false;
		Node temp = root;
		for(char ch : str.toCharArray())
		{
			if(temp.subnode(ch) == null)
				return false;
			temp = temp.subnode(ch);
		}
		if(temp.isLeaf)
			return true;
		return false;
	}
	
	public void insert(String str)
	{
		if(search(str))
			return;
		Node temp = root;
		for(char ch : str.toCharArray())
		{
			Node child = temp.subnode(ch);
			if(child != null)
				temp = child;
			else
			{
				temp.childList.add(new Node(ch));
				temp = temp.subnode(ch);
			}
		}
		temp.isLeaf = true;
	}
	
	public void delete(String str)
	{
		if(root == null || !search(str))
			return;
		Node temp = root;
		for(char ch : str.toCharArray())
		{
			Node child = temp.subnode(ch);
			if(child.isLeaf)
			{
				temp.childList.remove(child);
				return;
			}
			else
				temp = child;
		}
		temp.isLeaf = false;
	}
	
	public String longestPrefix(String str)
	{
		if(root == null)
			return null;
		Node temp = root;
		String res = "";
		for(char ch : str.toCharArray())
		{
			Node child = temp.subnode(ch);
			if(child == null)
				return res;
			else
			{
				res += ch;
				temp = child;
			}
		}
		return res;
	}
}
