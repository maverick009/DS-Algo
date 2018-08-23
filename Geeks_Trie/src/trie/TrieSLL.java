package trie;

import java.util.ArrayList;

public class TrieSLL 
{
	public class Node
	{
		char content;
		boolean isLeaf;
		ArrayList<Node> childList;
		
		public Node(char content)
		{
			this.content = content;
			isLeaf = false;
			childList = new ArrayList<>();
		}
		
		public Node subNode(char content)
		{
			for(Node child : childList)
				if(child.content == content)
					return child;
			return null;
		}
	}
	
	private Node root;
	
	public TrieSLL()
	{
		root = new Node(' ');
	}
	
	public void insert(String str)
	{
		if(search(str))
			return;
		Node curr = root;
		for(char ch : str.toCharArray())
		{
			Node child = curr.subNode(ch);
			if(child != null)
				curr = child;
			else
			{
				curr.childList.add(new Node(ch));
				curr = curr.subNode(ch);
			}
		}
		curr.isLeaf = true;
	}
	
	public boolean search(String str)
	{
		if(root == null)
			return false;
		Node temp = root;
		for(char ch : str.toCharArray())
		{
			if(temp.subNode(ch) == null)
				return false;
			temp = temp.subNode(ch);
		}
		if(temp.isLeaf)
			return true;
		return false;
	}
	
	public void delete(String str)
	{
		if(root == null || !search(str))
			return;
		Node temp = root;
		for(char ch : str.toCharArray())
		{
			Node child = temp.subNode(ch);
			if(child.isLeaf)
			{
				temp.childList.remove(child);
				return;
			}
			temp = child;
		}
		temp.isLeaf = false;		
	}
}
