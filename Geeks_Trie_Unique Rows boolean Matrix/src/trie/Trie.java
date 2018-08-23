package trie;

public class Trie 
{
	private final int CHILD = 2;
	
	public class Node
	{
		Node []children;
		boolean isLeaf;
		
		public Node()
		{
			children = new Node[CHILD];
			for(int i = 0;i < children.length;i++)
				children[i] = null;
			
			this.isLeaf = false;
		}
	}
	
	public Node root;
	
	public Trie()
	{
		root = new Node();
	}
	
	public boolean search(int []arr)
	{
		if(arr.length == 0)
			return false;
		
		Node temp = root;
		for(int i = 0;i < arr.length;i++)
		{
			//System.out.println("arr[i]:" + arr[i] + "\t" + temp.children[arr[i]]);
			if(temp.children[arr[i]] == null)
				return false;
			temp = temp.children[arr[i]];
		}
		return (temp != null)?true:false;
	}
	
	public void insert(int []arr)
	{
		if(search(arr))
			return;
		Node temp = root;
		for(int i = 0;i < arr.length;i++)
		{
			if(temp.children[arr[i]] == null)
				temp.children[arr[i]] = new Node();
			temp = temp.children[arr[i]];
		}
		temp.isLeaf = true;
		print(arr);
	}
	
	public void print(int []arr)
	{
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
