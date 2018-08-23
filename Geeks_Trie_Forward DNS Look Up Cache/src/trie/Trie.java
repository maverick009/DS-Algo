package trie;

import java.util.ArrayList;

public class Trie 
{
	class Node
	{
		char ch;
		String ip;
		boolean isLeaf;
		ArrayList<Node> childList;
		
		public Node(char ch)
		{
			this.ch = ch;
			this.isLeaf = false;
			this.ip ="";
			childList = new ArrayList<>();
		}
		
		public Node subnode(char ch)
		{
			for(Node child : childList)
				if(child.ch == ch)
					return child;
			return null;
		}
	}
	
	private Node root;
	
	public Trie()
	{
		root = new Node(' ');
	}
	
	public void insert(String url,String ip)
	{
		if(search(url) != null)
			return;
		Node temp = root;
		for(char ch : url.toCharArray())
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
		temp.ip = ip;
		temp.isLeaf = true;
	}
	
	public String search(String url)
	{
		if(root == null)
			return null;
		if(!url.startsWith("www."))
			url = "www." + url;
		Node temp = root;
		for(char ch : url.toCharArray())
		{
			Node child = temp.subnode(ch);
			if(child == null)
				return null;
			else if(child.isLeaf)
				return child.ip;
			else
				temp = child;
		}
		return null;
	}
}
