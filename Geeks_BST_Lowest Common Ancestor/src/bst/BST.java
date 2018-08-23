package bst;

public class BST 
{
	public class Node
	{
		public int data;
		public Node left,right;
		
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	public Node root;
	
	public Node insert(Node root,int data)
	{
		Node newnode = new Node(data);
		if(root == null)
		{
			root = newnode;
			return root;
		}
		if(data < root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		return root;
	}
	
	public void inorder(Node root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	/*
	 * BEST SOLUTION
	 */
	class Boolean
	{
		boolean v1,v2;
	}
	public Node findLcaUtil(Node root,int val1,int val2,Boolean b)
	{
		if(root == null)
			return null;

		if(root.data == val1)
		{
			b.v1 = true;
			return root;
		}
		
		if(root.data == val2)
		{
			b.v2 = true;
			return root;
		}
		Node left_lca = findLcaUtil(root.left, val1, val2,b);
		Node right_lca = findLcaUtil(root.right, val1, val2,b);
		
		if(left_lca != null && right_lca != null)
			return root;
		
		return (left_lca != null?left_lca:right_lca);
	}
	
	public boolean find(Node root,int val)
	{
		if(root == null)
			return false;
		
		return (root.data == val || find(root.left, val) || find(root.right, val));
	}
	
	public int findLca(Node root,int val1,int val2)
	{
		Boolean b = new Boolean();
		b.v1 = false;
		b.v2 = false;
		if(root == null)
			return -1;
		if(val1 == val2 && find(root, val1))
			return val1; 
		Node lca = findLcaUtil(root, val1, val2,b);
		
		if((lca != null && (b.v1 && b.v2)) || (b.v1 && find(root, val2)) || (b.v2 && find(root, val1)))
			return lca.data;
		
		return -1;
	}
	
	
	/*public Node lca(Node root,int val1,int val2)
	{
		if(root == null)
			return null;
		
		if(root.data > val1 && root.data > val2)
			return lca(root.left, val1, val2);
		if(root.data < val1 && root.data < val2)
			return lca(root.right, val1, val2);
		else
			return root;
	}*/
	
	/*List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	public int lca1(Node root,int val1,int val2)
	{
		if(root == null)
			return -1;	
		
		if(!findpath(root, val1, list1) || !findpath(root, val2, list2))
		{
			System.out.println(list1.size() > 0 ?"val1 is present" :"val1 is not present");
			System.out.println(list2.size() > 0 ?"val2 is present" :"val2 is not present");
			return -1;
		}
		
		 * BEAUTIFUL CODE
		 * COMPARES TWO LIST IN O(n)
		 
		
		int i;
		for(i = 0;i < list1.size() && i < list2.size();i++)
			if(!list1.get(i).equals(list2.get(i)))
				break;
			
		return list1.get(i - 1);
	}
	
	public boolean findpath(Node root,int val,List<Integer> path)
	{
		if(root == null)
			return false;
		
		path.add(root.data);
		
		if(root.data == val)
			return true;
		
		if(root.left != null && findpath(root.left, val, path))
			return true;
		if(root.right != null && findpath(root.right, val, path))
			return true;
		
		path.remove(path.size() - 1);
		return false;
	}*/
	
	/*public Node lca2(Node root,int val1,int val2)
	{
		if(root == null)
			return null;
		
		if(root.data == val1 || root.data == val2)
			return root;
		
		Node left_lca = lca2(root.left, val1, val2);
		Node right_lca = lca2(root.right, val1, val2);
		
		if(left_lca != null && right_lca != null)
			return root;
		
		return(left_lca != null ?left_lca :right_lca);
	}*/	
}
