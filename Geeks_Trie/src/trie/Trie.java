//https://www.youtube.com/watch?v=CX777rfuZtM
package trie;

public class Trie 
{
	private static final int CHAR = 26;
	
	class Node
	{
		Node []children;
		boolean isleaf;
		
		public Node()
		{
			children = new Node[CHAR];
			isleaf = false;
			
			for(int i = 0;i < CHAR;i++)
				children[i] = null;
		}
	}
	
	public Node root = new Node();
	
	public boolean search(String str)
	{
		if(str.length() == 0)
			return false;
		
		Node temp = root;
		char []arr = str.toCharArray();
		for(int i = 0;i < arr.length;i++)
		{
			if(temp.children[arr[i] - 'a'] == null)
				return false;
			temp = temp.children[arr[i] - 'a'];
		}
		return (temp != null)?true:false;
	}
	
	public void insert(String str)
	{
		if(str.length() == 0 || search(str))
			return;
		
		char[]arr = str.toCharArray();
		Node temp = root;
		
		for(int i = 0;i < arr.length;i++)
		{
			if(temp.children[arr[i] - 'a'] == null)
				temp.children[arr[i] - 'a'] = new Node();
			temp = temp.children[arr[i] - 'a'];
		}
		temp.isleaf = true;
	}
	
	public boolean isfree(Node node)
	{
		for(int i = 0;i < CHAR;i++)
		{
			if(node.children[i] != null)
				return false;
		}
		return true;
	}
	
	public int getIndex(char ch)
	{
		return ch - 'a';
	}
	
	public boolean deleteUtil(Node node, String str, int level, int len)
	{
		if(node != null)
		{
			if(level == len)
			{
				node.isleaf = true;
				if(isfree(node))
					return true;
				return false;
			}
			else
			{
				int index = getIndex(str.charAt(level));
				if(deleteUtil(node.children[index], str, level + 1, len))
				{
					node.children[index] = null;
					return(isfree(node) && !node.isleaf);
				}
			}
		}		
		return false;
	}
	
	public void delete(Node node, String str)
	{
		if(str.length() == 0)
			return;
		deleteUtil(root, str, 0, str.length());
	}	
}
